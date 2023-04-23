package com.city.manager.controller;

import com.city.manager.common.param.UserParam;
import com.city.manager.common.param.UserSearchParam;
import com.city.manager.common.vo.Result;
import com.city.manager.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: UserController
 * @Description: 用户信息管理模块
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/dor/pm/user")
@Api(tags = "API-用户信息管理模块")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("条件搜索用户")
    @PostMapping("")
    public Result searchUsers(@RequestBody UserSearchParam userParam){
        return userService.searchUsers(userParam);
    }

    @ApiOperation("更新用户信息")
    @PutMapping("")
    public Result updateUserInfo(@RequestBody UserParam userParam){
        return userService.updateUserInfo(userParam);
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }



}
