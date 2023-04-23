package com.city.manager.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.city.manager.dao.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version v1.0
 * @ClassName: UserMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
