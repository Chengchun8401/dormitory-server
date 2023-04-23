package com.city.manager.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.manager.common.param.AnnounceParam;
import com.city.manager.common.param.NoticeParam;
import com.city.manager.common.vo.PageVo;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Announcement;
import com.city.manager.dao.mapper.AnnouncementMapper;
import com.city.manager.service.IAnnouncementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @ClassName: AnnouncementServiceImpl
 * @Description: 公告信息模块  错误码 11001 ~ 11999
 * @Author: CitySpring
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public Result getNoticeList(NoticeParam param) {
        PageVo pageVo = new PageVo();
        // 开启分页
        Page<Announcement> page = new Page<>(param.getCurrentPage(), param.getPageSize());
        IPage<Announcement> data = announcementMapper.getNoticeList(page, param.getTitle(), param.getPublisher());

        pageVo.setTotal(data.getTotal());
        pageVo.setData(data.getRecords());
        return Result.success(null, pageVo);
    }

    @Override
    public Result deleteNotice(String id) {
        if(announcementMapper.deleteById(id) > 0){
            return Result.success("删除成功", null);
        }
        return Result.fail("删除失败", 11001);
    }

    @Override
    public Result updateNotice(Announcement announcement) {
        if(announcementMapper.updateById(announcement) > 0){
            return Result.success("更新成功", null);
        }
        return Result.fail("更新失败", 11002);
    }

    @Override
    public Result addNotice(AnnounceParam announceParam) {
        Announcement announcement = new Announcement();
        BeanUtils.copyProperties(announceParam, announcement);
        announcement.setPublishTime(LocalDateTime.now());


        if(announcementMapper.insert(announcement) > 0){
            return Result.success("添加成功", null);
        }
        return Result.fail("添加失败", 11003);
    }


}
