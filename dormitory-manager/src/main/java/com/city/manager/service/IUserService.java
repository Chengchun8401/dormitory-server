package com.city.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.manager.common.param.UserParam;
import com.city.manager.common.param.UserSearchParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.User;

/**
 * @version v1.0
 * @InterfaceName: IUserService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */

public interface IUserService extends IService<User> {

    /**
     * 条件查询用户
     * @param userParam 条件参数
     */
    Result searchUsers(UserSearchParam userParam);

    /**
     * 更新用户信息
     * @param userParam 信息参数
     */
    Result updateUserInfo(UserParam userParam);

    /**
     * 删除用户信息
     * @param id 用户ID
     */
    Result deleteUser(String id);
}
