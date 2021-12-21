package com.xing.scaffold.service;

import com.xing.scaffold.domain.UserVo;
import com.xing.scaffold.domain.constant.ErrorEnum;
import com.xing.scaffold.domain.entity.UserDo;
import com.xing.scaffold.domain.http.BaseResponse;
import com.xing.scaffold.domain.http.UserListResponse;
import com.xing.scaffold.domain.http.UserResponse;
import com.xing.scaffold.exception.ExtensionException;
import com.xing.scaffold.repository.UserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务逻辑封装
 *
 * @author xingzhe
 * @date 2021/4/7 20:53
 */
@Service
public class UserService {

    /**
     * 数据库交互
     */
    @Autowired
    UserDao userDao;

    /**
     * 翻页数
     */
    private static final Integer PAGE_SIZE = 10;

    /**
     * 根据用户id查用户信息
     *
     * @param id 用户id
     * @return 用户展示信息封装
     */
    public UserResponse getById(Integer id) {
        UserResponse userResponse = new UserResponse();
        userResponse.result(ErrorEnum.SUCCESS);
        UserDo userDo = userDao.getById(id);
        if (userDo == null) {
            //这里可以直接返回response，为了演示全局异常捕获，这里抛出异常
            throw new ExtensionException(ErrorEnum.USER_NOT_EXIST);
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userDo, userVo);
        userResponse.setUserVo(userVo);
        return userResponse;
    }

    /**
     * 保存用户信息
     *
     * @param userVo 用户展示信息
     * @return 返回结果
     */
    public BaseResponse save(UserVo userVo) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(userVo, userDo);
        userDao.save(userDo);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.result(ErrorEnum.SUCCESS);
        return baseResponse;
    }

    /**
     * 更新用户状态
     *
     * @param status 用户状态
     * @param id     用户id
     * @return 返回结果
     */
    public BaseResponse update(Integer status, Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        int result = userDao.updateUser(status, id);
        if (result <= 0) {
            baseResponse.result(ErrorEnum.COMMON_ERROR);
            return baseResponse;
        }
        baseResponse.result(ErrorEnum.SUCCESS);
        return baseResponse;
    }

    /**
     * 查用户翻页信息
     *
     * @param page 页数
     * @return 返回结果
     */
    public UserListResponse getUserList(Integer page, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        pageSize = pageSize == null ? PAGE_SIZE : pageSize;
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<UserDo> userDos = userDao.findAll(pageable);
        List<UserVo> resultList = new ArrayList<>();
        for (UserDo userDo : userDos.getContent()) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userDo, userVo);
            resultList.add(userVo);
        }
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.result(ErrorEnum.SUCCESS);
        userListResponse.setUserVo(resultList);
        return userListResponse;
    }
}
