package com.city.manager.controller;

import com.city.manager.common.param.DormitoryParam;
import com.city.manager.common.vo.Result;
import com.city.manager.service.IDormitoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: DormitoryController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/dor/pm/info")
@Api(tags = "API-寝室信息模块")
public class DormitoryController {

    @Autowired
    private IDormitoryService dormitoryService;

    @ApiOperation("获取楼栋信息")
    @GetMapping("/build")
    public Result getDorBuilding(){
        return dormitoryService.getDorBuilding();
    }

    @ApiOperation("获取楼栋下寝室信息")
    @GetMapping("/room/{id}")
    public Result getDorBuildingRoom(@PathVariable String id){
        return dormitoryService.getDorBuildingRoom(id);
    }

    @ApiOperation("获取所有寝室信息")
    @PostMapping("")
    public Result getAllDorInfo(@RequestBody DormitoryParam dormitoryParam){
        return dormitoryService.getAllDorInfo(dormitoryParam);
    }

}
