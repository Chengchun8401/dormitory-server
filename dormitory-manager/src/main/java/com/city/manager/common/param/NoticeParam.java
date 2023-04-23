package com.city.manager.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: NoticeParam
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@ApiModel("公告拉取参数")
@Data
public class NoticeParam {

    @ApiModelProperty("页码")
    private Integer currentPage;

    @ApiModelProperty("页面大小")
    private Integer pageSize;

    @ApiModelProperty("发布人")
    private String publisher;

    @ApiModelProperty("标题")
    private String title;

}
