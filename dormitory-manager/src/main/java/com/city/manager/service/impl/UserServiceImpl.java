package com.city.manager.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.manager.common.param.UserParam;
import com.city.manager.common.param.UserSearchParam;
import com.city.manager.common.vo.PageVo;
import com.city.manager.common.vo.Result;
import com.city.manager.common.vo.UserVo;
import com.city.manager.dao.entity.User;
import com.city.manager.dao.mapper.UserMapper;
import com.city.manager.service.IUserService;
import com.city.manager.utils.FaceAipUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @ClassName: UserServiceImpl
 * @Description: 用户信息模块  错误码 12001 ~ 12999
 * @Author: CitySpring
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FaceAipUtils faceAipUtils;

    @Override
    public Result searchUsers(UserSearchParam userParam) {
        PageVo pageVo = new PageVo();
        // 开启分页
        Page<UserVo> page = new Page<>(userParam.getCurrentPage(), userParam.getPageSize());

        IPage<UserVo> users = userMapper.searchUsers(page, Strings.isBlank(userParam.getUsername()) ? null : Long.parseLong(userParam.getUsername()),
                Strings.isBlank(userParam.getBuildingId()) ? null : Long.parseLong(userParam.getBuildingId()),
                Strings.isBlank(userParam.getRoomId()) ? null : Long.parseLong(userParam.getRoomId()),
                userParam.getMajorId());

        pageVo.setTotal(users.getTotal());
        pageVo.setData(users.getRecords());

        return Result.success(null, pageVo);
    }

    @Override
    public Result updateUserInfo(UserParam userParam) {
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        // 忽略密码更新
        user.setPassword(null);

        if(userMapper.updateById(user) > 0){
            return Result.success("更新成功", null);
        }

        return Result.fail("更新失败", 12001);
    }

    @Override
    public Result deleteUser(String id) {
        if (userMapper.deleteById(id) > 0){
            faceAipUtils.faceDelete(id);
            return Result.success("删除成功", null);
        }
        return Result.fail("删除失败", 12002);
    }


}
