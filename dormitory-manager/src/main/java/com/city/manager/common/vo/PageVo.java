package com.city.manager.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: PageVo
 * @Description: 通用分页返回参数
 * @Author: CitySpring
 */
@Data
@ApiModel("列表统一返回数据格式")
public class PageVo {

    @ApiModelProperty("数据条数")
    private Long total;

    @ApiModelProperty("数据列表")
    private Object data;

}
