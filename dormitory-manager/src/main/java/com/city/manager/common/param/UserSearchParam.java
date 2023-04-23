package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: UserSearchParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
@ApiModel("用户搜索字段")
public class UserSearchParam {

    @ApiModelProperty("页码")
    private Integer currentPage;

    @ApiModelProperty("页面大小")
    private Integer pageSize;

    @ApiModelProperty("学生学号")
    private String username;

    @ApiModelProperty("楼栋ID")
    private String buildingId;

    @ApiModelProperty("寝室ID")
    private String roomId;

    @ApiModelProperty("学院ID")
    private Integer majorId;
}
