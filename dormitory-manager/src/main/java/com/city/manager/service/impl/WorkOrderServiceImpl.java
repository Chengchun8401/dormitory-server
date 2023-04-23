package com.city.manager.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.manager.common.param.WorkOrderParam;
import com.city.manager.common.param.WorkUpdateParam;
import com.city.manager.common.vo.PageVo;
import com.city.manager.common.vo.Result;
import com.city.manager.common.vo.WorkOrderVo;
import com.city.manager.dao.entity.OrderType;
import com.city.manager.dao.entity.WorkOrder;
import com.city.manager.dao.mapper.WorkOrderMapper;
import com.city.manager.service.IWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version v1.0
 * @ClassName: WorkOrderServiceImpl
 * @Description: 工单业务模块  错误码 14001 - 14999
 * @Author: CitySpring
 */
@Service
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapper, WorkOrder> implements IWorkOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Override
    public Result getWorkOrderList(WorkOrderParam param) {
        PageVo pageVo = new PageVo();
        Page<WorkOrderVo> page = new Page<>(param.getCurrentPage(), param.getPageSize()); // 开启分页

        IPage<WorkOrderVo> workOrderList = workOrderMapper.getWorkOrderList(page, param.getTypeId(), param.getStatus());
        pageVo.setTotal(workOrderList.getTotal());
        pageVo.setData(workOrderList.getRecords());

        return Result.success(null, pageVo);
    }

    @Override
    public Result getWorkOrderType() {
        List<OrderType> types = workOrderMapper.getWorkOrderType();
        if(types.isEmpty()){
            return Result.fail("工单类型获取失败", 14001);
        }
        return Result.success(null, types);
    }

}
