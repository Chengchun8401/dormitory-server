package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: AnnounceParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@ApiModel("公告内容")
@Data
public class AnnounceParam {

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("发布人")
    private String publisher;

}
