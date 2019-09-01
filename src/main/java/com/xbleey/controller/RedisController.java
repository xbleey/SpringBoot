/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: RedisController
 * Author:   11580
 * Date:     2019/9/1 0001 17:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xbleey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 11580
 * @create 2019/9/1 0001
 * @since 1.0.0
 */
@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "/redisSave")
    public String saveMess(@RequestParam(name = "key") String key, @RequestParam(name = "value") String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return key + ":" + value;
    }

    @GetMapping(value = "/redisGet")
    public String getRedis(@RequestParam(name = "key") String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
 

