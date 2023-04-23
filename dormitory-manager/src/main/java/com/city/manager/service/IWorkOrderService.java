package com.city.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.manager.common.param.WorkOrderParam;
import com.city.manager.common.param.WorkUpdateParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.WorkOrder;

/**
 * @version v1.0
 * @InterfaceName: IWorkOrderService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface IWorkOrderService extends IService<WorkOrder> {

    /**
     * 条件查询工单列表
     * @param workOrderParam 条件参数
     */
    Result getWorkOrderList(WorkOrderParam workOrderParam);

    /**
     * 获取工单类型
     */
    Result getWorkOrderType();
}
