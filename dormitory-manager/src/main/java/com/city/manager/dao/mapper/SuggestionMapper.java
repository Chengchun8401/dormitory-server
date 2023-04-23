package com.city.manager.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.city.manager.common.vo.SuggestionVo;
import com.city.manager.dao.entity.Suggestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version v1.0
 * @InterfaceName: SuggestionMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Mapper
public interface SuggestionMapper extends BaseMapper<Suggestion> {

    IPage<SuggestionVo> getSuggestionList(Page<SuggestionVo> page, @Param("status") Integer status);

}
