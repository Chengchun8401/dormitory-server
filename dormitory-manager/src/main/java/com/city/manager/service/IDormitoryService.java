package com.city.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.manager.common.param.DormitoryParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Dormitory;

/**
 * @version v1.0
 * @InterfaceName: IDormitoryService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface IDormitoryService extends IService<Dormitory> {

    /**
     * 获取所有楼栋信息
     */
    Result getDorBuilding();

    /**
     * 获取楼栋下寝室信息
     * @param id 楼栋ID
     */
    Result getDorBuildingRoom(String id);

    /**
     * 条件分页查询寝室信息
     * @param dormitoryParam 查询条件
     */
    Result getAllDorInfo(DormitoryParam dormitoryParam);
}
