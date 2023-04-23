package com.city.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.manager.common.param.AnnounceParam;
import com.city.manager.common.param.NoticeParam;
import com.city.manager.common.vo.Result;
import com.city.manager.dao.entity.Announcement;

/**
 * @version v1.0
 * @InterfaceName: IAnnouncementService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface IAnnouncementService extends IService<Announcement> {

    /**
     * 拉取公告列表
     * @param param 预置参数
     */
    Result getNoticeList(NoticeParam param);

    /**
     * 根据ID删除公告
     * @param id 公告id
     * @return
     */
    Result deleteNotice(String id);

    /**
     * 更新公告内容
     * @param announcement 公告
     * @return
     */
    Result updateNotice(Announcement announcement);

    /**
     * 创建公告
     * @param announceParam 公告内容
     * @return
     */
    Result addNotice(AnnounceParam announceParam);
}
