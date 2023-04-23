package com.city.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.manager.common.param.LoginParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Admin;
import com.city.manager.dao.mapper.AdminMapper;
import com.city.manager.service.IAdminService;
import com.city.manager.utils.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @version v1.0
 * @ClassName: AdminServiceImpl
 * @Description: 管理员登录信息模块  错误码 10001 ~ 19999
 * @Author: CitySpring
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private TokenService tokenService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result adminLogin(LoginParam param) {
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", param.getUsername()));
        if(admin == null){
            return Result.fail("管理员账号不存在", 10001);
        }

        if(!admin.getPassword().equals(param.getPassword())){
            return Result.fail("登录密码错误", 10002);
        }

        admin.setPassword("");
        String token = tokenService.createToken(admin.getUsername(), admin.getId());
        return Result.success("欢迎访问", token);
    }

    @Override
    public Result adminLogout(String token) {
        if(Boolean.TRUE.equals(stringRedisTemplate.delete("TOKEN_" + token))){
            return Result.success("注销成功", null);
        }
        return Result.fail("注销登录失败", 10003);
    }

}
