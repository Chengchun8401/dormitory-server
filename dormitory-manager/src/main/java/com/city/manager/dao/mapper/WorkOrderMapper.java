package com.city.manager.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.city.manager.common.vo.WorkOrderVo;
import com.city.manager.dao.entity.OrderType;
import com.city.manager.dao.entity.WorkOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @InterfaceName: WorkOrderMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Mapper
public interface WorkOrderMapper extends BaseMapper<WorkOrder> {

    IPage<WorkOrderVo> getWorkOrderList(Page<WorkOrderVo> page, @Param("typeId") Integer typeId, @Param("status") Integer status);

    List<OrderType> getWorkOrderType();

}
