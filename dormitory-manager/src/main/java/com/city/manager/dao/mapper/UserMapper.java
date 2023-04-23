package com.city.manager.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.city.manager.common.vo.UserVo;
import com.city.manager.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version v1.0
 * @ClassName: UserMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage<UserVo> searchUsers(Page<UserVo> page, @Param("username") Long username, @Param("buildingId") Long buildingId, @Param("roomId") Long roomId, @Param("majorId") Integer majorId);

}
