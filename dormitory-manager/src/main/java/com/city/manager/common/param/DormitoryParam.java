package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: DormitoryParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
@ApiModel("寝室查询参数")
public class DormitoryParam {

    @ApiModelProperty("页码")
    private Integer currentPage;

    @ApiModelProperty("页面大小")
    private Integer pageSize;

    @ApiModelProperty("楼栋ID")
    private Long buildingId;

    @ApiModelProperty("寝室ID")
    private Long roomId;

    @ApiModelProperty("用电是否欠费 0默认|1开启")
    private Integer powerArrears;

    @ApiModelProperty("用水是否欠费 0默认|1开启")
    private Integer waterArrears;

}
