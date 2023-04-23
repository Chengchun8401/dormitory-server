package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: SugParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
@ApiModel("意见反馈更新")
public class SugParam {

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("状态码 -1未读|1已读")
    private Integer status;
}
