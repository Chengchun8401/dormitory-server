package com.city.manager.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDate;

/**
 * @version v1.0
 * @ClassName: SuggestionVo
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
public class SuggestionVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String student;

    private String content;

    private LocalDate commitTime;

    private LocalDate checkTime;

    private Integer status;

}
