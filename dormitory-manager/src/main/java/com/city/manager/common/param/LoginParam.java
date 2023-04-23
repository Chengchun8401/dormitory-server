package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: LoginParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
@ApiModel("登录参数")
public class LoginParam {

    private String username;

    private String password;

}
