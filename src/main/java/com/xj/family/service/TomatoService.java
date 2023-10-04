package com.xj.family.service;

import com.xj.family.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * 在redis里面我们存储的key是 mysql 的 userID + 类型
 * 比如 userId:alltime
 * 或者 userId:2023-09-01
 * 实际的key案例是：
 *  16:alltime
 *  23:2023-09-01
 * 或许有一天，我们可以把userId:2023-09-01这种给替换为：userId:today
 */
@Service
public class TomatoService {
    public static final String ALL_TIME_KEY = "alltime";
    @Autowired
    StringRedisTemplate redisTemplate;
    public int queryTotalCounts() {
        Integer userId = LoginInterceptor.threadLocalUserId.get();
        String totalCountsKey = String.valueOf(userId) + ":" + ALL_TIME_KEY;
        int counts = Integer.parseInt(Objects.requireNonNull(
                redisTemplate.opsForValue().get(totalCountsKey)
        ));
        return counts;
    }
    public int queryTodayCounts() {
        Integer userId = LoginInterceptor.threadLocalUserId.get();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedToday = today.format(formatter);
        String todayCountsKey = String.valueOf(userId) + ":" + formattedToday;
        int counts = Integer.parseInt(Objects.requireNonNull(
                redisTemplate.opsForValue().get(todayCountsKey)
        ));
        return counts;
    }
    public int finishTomato() {
        Integer userId = LoginInterceptor.threadLocalUserId.get();
        String totalCountsKey = String.valueOf(userId) + ":" + ALL_TIME_KEY;
        Long incrementResult1 = redisTemplate.opsForValue().increment(totalCountsKey);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedToday = today.format(formatter);
        String todayCountsKey = String.valueOf(userId) + ":" + formattedToday;
        Long incrementResult2 = redisTemplate.opsForValue().increment(todayCountsKey);

        return (int)(incrementResult1 + incrementResult2);// greater than 0 when success
    }

}
