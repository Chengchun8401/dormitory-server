package com.city.manager.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.manager.common.param.SuggestionParam;
import com.city.manager.common.vo.PageVo;
import com.city.manager.common.vo.Result;
import com.city.manager.common.vo.SuggestionVo;
import com.city.manager.dao.entity.Suggestion;
import com.city.manager.dao.mapper.SuggestionMapper;
import com.city.manager.service.ISuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @ClassName: SuggestionServiceImpl
 * @Description: 意见反馈模块
 * @Author: CitySpring
 */
@Service
public class SuggestionServiceImpl extends ServiceImpl<SuggestionMapper, Suggestion> implements ISuggestionService {

    @Autowired
    private SuggestionMapper suggestionMapper;

    @Override
    public Result getSuggestionList(SuggestionParam param) {
        PageVo pageVo = new PageVo();
        Page<SuggestionVo> page = new Page<>(param.getCurrentPage(), param.getPageSize());
        IPage<SuggestionVo> suggestionList = suggestionMapper.getSuggestionList(page, param.getStatus());

        pageVo.setTotal(suggestionList.getTotal());
        pageVo.setData(suggestionList.getRecords());

        return Result.success(null, pageVo);
    }
}
