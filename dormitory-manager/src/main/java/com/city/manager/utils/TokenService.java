package com.city.manager.utils;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ClassName: TokenService
 * @Description: Token颁发与校验
 * @Author: CitySpring
 */

@Service
public class TokenService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 创建新Token
     */
    public String createToken(String username, Long adminId){
        String token = JWTUtils.createToken(username);
        stringRedisTemplate.opsForValue().set("TOKEN_" + token, adminId.toString(),7, TimeUnit.DAYS);
        return token;
    }

    /**
     * 校验Token合理性
     */
    public Boolean checkToken(String token){
        if(Strings.isBlank(token)){ // token 为空
            return false;
        }

        Map<String, Object> map = JWTUtils.checkToken(token);
        if(map == null){ // 解析失败
            return false;
        }

        String userJson = stringRedisTemplate.opsForValue().get("TOKEN_" + token);
        if(Strings.isBlank(userJson)){ // token已过期
            return null;
        }

        return true;
    }

}
