package com.xing.scaffold.repository;

import com.xing.scaffold.domain.entity.UserDo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户数据库交互
 *
 * @author xingzhe
 * @date 2021/4/1 20:17
 */
public interface UserDao extends JpaRepository<UserDo, Long> {

    /**
     * 根据用户id查找用户信息
     *
     * @param id 用户id
     * @return 用户i信息
     */
    UserDo getById(Integer id);

    /**
     * 更新用户信息
     *
     * @param status 用户状态
     * @param id     用户id
     * @return 修改行数
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update UserDo u set u.status = :status where u.id = :id")
    int updateUser(Integer status, Integer id);
}
