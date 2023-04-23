package com.city.manager.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.city.manager.common.param.SugParam;
import com.city.manager.common.param.SuggestionParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Suggestion;
import com.city.manager.service.ISuggestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: SuggestionController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/dor/pm/sug")
@Api(tags = "API-意见反馈模块")
public class SuggestionController {

    @Autowired
    private ISuggestionService suggestionService;

    @ApiOperation("拉取意见反馈列表")
    @PostMapping("")
    public Result getSuggestionList(@RequestBody SuggestionParam param){
        return suggestionService.getSuggestionList(param);
    }

    @ApiOperation("更新意见查阅状态")
    @PutMapping("")
    public Result changeSugStatus(@RequestBody SugParam param){
        if(suggestionService.update(new UpdateWrapper<Suggestion>().eq("id", param.getId()).set("status", param.getStatus()))){
            return Result.success("更新成功", null);
        }
        return Result.fail("更新失败", 15001);
    }

}
