package com.xing.scaffold.controller;

import com.xing.scaffold.domain.UserVo;
import com.xing.scaffold.domain.http.BaseResponse;
import com.xing.scaffold.domain.http.UserListResponse;
import com.xing.scaffold.domain.http.UserResponse;
import com.xing.scaffold.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口暴露
 *
 * @author xingzhe
 * @date 2021/4/7 20:35
 */
@Api(value = "springboot脚手架接口文档", tags = "Document")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "查询用户，restful方式调用", notes = "查询用户信息")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserResponse getUser(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "添加用户", notes = "添加用户信息")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public BaseResponse addUser(@RequestBody @Validated UserVo user) {
        return userService.save(user);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public BaseResponse updateUser(Integer status, @PathVariable Integer id) {
        return userService.update(status, id);
    }

    @ApiOperation(value = "获取翻页用户信息", notes = "获取翻页用户信息")
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public UserListResponse getUserList(Integer page){
        return userService.getUserList(page);
    }
}
