package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: WorkOrderParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
@ApiModel("工单条件查询")
public class WorkOrderParam {

    @ApiModelProperty("页码")
    private Integer currentPage;

    @ApiModelProperty("页面大小")
    private Integer pageSize;

    @ApiModelProperty("工单类型ID")
    private Integer typeId;

    @ApiModelProperty("工单状态码")
    private Integer status;

}
