package com.city.manager.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.city.manager.common.param.WorkOrderParam;
import com.city.manager.common.param.WorkUpdateParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Admin;
import com.city.manager.dao.entity.WorkOrder;
import com.city.manager.service.IAdminService;
import com.city.manager.service.IWorkOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @version v1.0
 * @ClassName: WorkOrderController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/dor/pm/work")
@Api(tags = "API-工单模块")
public class WorkOrderController {

    @Autowired
    private IWorkOrderService workOrderService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private IAdminService adminService;

    @ApiOperation("获取工单列表")
    @PostMapping("")
    public Result getWorkOrderList(@RequestBody WorkOrderParam workOrderParam){
        return workOrderService.getWorkOrderList(workOrderParam);
    }

    @ApiOperation("获取工单类型")
    @GetMapping("/type")
    public Result getWorkOrderType(){
        return workOrderService.getWorkOrderType();
    }

    @ApiOperation("更新工单状态")
    @PutMapping("")
    public Result updateWorkOrder(@RequestBody WorkUpdateParam param, @RequestHeader("Authorization") String token){
        String adminId = stringRedisTemplate.opsForValue().get("TOKEN_" + token);

        if(Strings.isBlank(adminId))  return Result.fail("管理员信息验证失败", 14000);

        Admin admin = adminService.getById(adminId);
        if(admin == null) return Result.fail("管理员信息验证失败", 14001);

        if(workOrderService.update(new UpdateWrapper<WorkOrder>().eq("id", param.getId()).set("status", param.getStatus()).set("adminId", admin.getId()))){
            return Result.success("更新成功", null);
        }

        return Result.fail("更新失败", 14002);
    }


}
