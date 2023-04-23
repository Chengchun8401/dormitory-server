package com.city.manager.dao.entity;

import lombok.Data;

/**
 * @version v1.0
 * @ClassName: User
 * @Description: 管理用户信息
 * @Author: CitySpring
 */

@Data
public class Admin {

    private Long id;

    private String username;

    private String password;

    private String nickname;

}
