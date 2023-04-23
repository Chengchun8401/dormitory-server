package com.city.manager.controller;

import com.city.manager.common.param.LoginParam;
import com.city.manager.common.vo.Result;
import com.city.manager.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: LoginController
 * @Description: 管理员登录模块
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/dor/pm")
@Api(tags = "API-登录信息模块")
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Result adminLogin(@RequestBody LoginParam loginParam){
        return adminService.adminLogin(loginParam);
    }

    @ApiOperation("注销登录")
    @GetMapping("/logout")
    public Result adminLogout(@RequestHeader("Authorization") String token){
        return adminService.adminLogout(token);
    }

}
