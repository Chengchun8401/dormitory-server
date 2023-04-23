package com.city.manager.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.city.manager.dao.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version v1.0
 * @InterfaceName: AnnouncementMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    IPage<Announcement> getNoticeList(Page<Announcement> page, @Param("title") String title, @Param("publisher") String publisher);

}
