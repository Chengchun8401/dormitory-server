package com.city.manager.controller;

import com.city.manager.common.param.AnnounceParam;
import com.city.manager.common.param.NoticeParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Announcement;
import com.city.manager.service.IAnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: AnnouncementController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/dor/pm/notice")
@Api(tags = "API-公告管理模块")
public class AnnouncementController {

    @Autowired
    private IAnnouncementService announcementService;

    @ApiOperation("获取公告列表")
    @PostMapping("")
    public Result getNoticeList(@RequestBody NoticeParam param){
        return announcementService.getNoticeList(param);
    }

    @ApiOperation("根据ID删除公告")
    @DeleteMapping("/{id}")
    public Result removeNotice(@PathVariable String id){
        return announcementService.deleteNotice(id);
    }

    @ApiOperation("更新公告内容")
    @PutMapping("")
    public Result updateNotice(@RequestBody Announcement announcement){
        return announcementService.updateNotice(announcement);
    }

    @ApiOperation("添加公告")
    @PostMapping("/add")
    public Result addNotice(@RequestBody AnnounceParam announceParam){
        return announcementService.addNotice(announceParam);
    }

}
