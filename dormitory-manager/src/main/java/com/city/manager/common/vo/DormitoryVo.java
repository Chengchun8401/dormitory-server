package com.city.manager.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: DormitoryVo
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
@ApiModel("寝室信息")
public class DormitoryVo {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("寝室ID")
    private Long id;

    @ApiModelProperty("楼栋")
    private String building;

    @ApiModelProperty("寝室号")
    private String room;

    @ApiModelProperty("居住人数")
    private Integer member;

    @ApiModelProperty("电费余额")
    private Double powerRate;

    @ApiModelProperty("水费余额")
    private Double waterRate;

    @ApiModelProperty("寝室得分")
    private Integer score;

}
