package com.city.manager.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.city.manager.common.vo.BuildingVo;
import com.city.manager.common.vo.DormitoryVo;
import com.city.manager.dao.entity.Dormitory;
import com.city.manager.dao.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @InterfaceName: DormitoryMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Mapper
public interface DormitoryMapper extends BaseMapper<Dormitory> {

    /**
     * 拉取楼栋信息
     */
    List<BuildingVo> getDorBuilding();

    /**
     * 获取寝室信息
     */
    IPage<DormitoryVo> getDormitoryInfo(Page<DormitoryVo> page, @Param("buildingId") Long buildingId, @Param("roomId") Long roomId,
                                        @Param("powerArrears") Integer powerArrears, @Param("waterArrears") Integer waterArrears);

    /**
     * 获取楼栋下的寝室信息
     */
    List<Room> getBuildingRooms(Long id);
}
