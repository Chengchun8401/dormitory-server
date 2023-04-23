package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: UserParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
@ApiModel("用户更新信息")
public class UserParam {

    @ApiModelProperty("学生学号")
    private Long id;

    @ApiModelProperty("学生性别")
    private Integer sex;

    @ApiModelProperty("寝室ID")
    private Long dormitoryId;

    @ApiModelProperty("学生姓名")
    private String name;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("专业Id")
    private Integer majorId;

}
