package com.city.manager.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.manager.common.param.DormitoryParam;
import com.city.manager.common.vo.BuildingVo;
import com.city.manager.common.vo.DormitoryVo;
import com.city.manager.common.vo.PageVo;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Dormitory;
import com.city.manager.dao.entity.Room;
import com.city.manager.dao.mapper.DormitoryMapper;
import com.city.manager.service.IDormitoryService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version v1.0
 * @ClassName: DormitoryServiceImpl
 * @Description: 寝室信息模块 错误代码 13001 - 13999
 * @Author: CitySpring
 */
@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory> implements IDormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public Result getDorBuilding() {
        List<BuildingVo> buildings = dormitoryMapper.getDorBuilding();
        if(buildings.isEmpty()){
            return Result.fail("楼栋信息获取失败", 13001);
        }
        return Result.success(null, buildings);
    }

    @Override
    public Result getDorBuildingRoom(String id) {
        List<Room> rooms = dormitoryMapper.getBuildingRooms(Long.parseLong(id));
        if(rooms.isEmpty()){
            return Result.fail("寝室信息获取失败", 13002);
        }
        return Result.success(null, rooms);
    }

    @Override
    public Result getAllDorInfo(DormitoryParam dormitoryParam) {
        PageVo pageVo = new PageVo();
        // 开启分页
        Page<DormitoryVo> page = new Page<>(dormitoryParam.getCurrentPage(), dormitoryParam.getPageSize());
        IPage<DormitoryVo> dormitoryInfo = dormitoryMapper.getDormitoryInfo(page, dormitoryParam.getBuildingId(), dormitoryParam.getRoomId(),
                dormitoryParam.getPowerArrears(), dormitoryParam.getWaterArrears());

        pageVo.setTotal(dormitoryInfo.getTotal());
        pageVo.setData(dormitoryInfo.getRecords());
        return Result.success(null, pageVo);
    }


}
