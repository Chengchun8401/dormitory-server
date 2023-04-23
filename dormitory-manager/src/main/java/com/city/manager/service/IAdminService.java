package com.city.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.manager.common.param.LoginParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Admin;

/**
 * @version v1.0
 * @InterfaceName: ILoginService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 管理员登录
     * @param loginParam 登录参数
     */
    Result adminLogin(LoginParam loginParam);

    /**
     * 注销登录
     * @param token Token
     */
    Result adminLogout(String token);
}
