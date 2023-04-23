package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: SuggestionParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
@ApiModel("意见反馈检索参数")
public class SuggestionParam {

    @ApiModelProperty("页码")
    private Integer currentPage;

    @ApiModelProperty("页面大小")
    private Integer pageSize;

    @ApiModelProperty("反馈状态")
    private Integer status;

}
