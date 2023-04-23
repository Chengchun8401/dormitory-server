package com.city.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.manager.common.param.SuggestionParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Suggestion;

/**
 * @version v1.0
 * @InterfaceName: ISugesstionService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface ISuggestionService extends IService<Suggestion> {

    /**
     * 拉取反馈意见列表
     * @param param 参数
     */
    Result getSuggestionList(SuggestionParam param);
}
