package com.xj.family.service; 

import com.xj.family.mapper.SixLogMapper2;
import com.xj.family.mapper.UserMapper;
import com.xj.family.bean.vo.SixLogVo2;

import com.xj.family.util.RedisKeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;


@Service 
public class SixLogService2 {
    @Autowired
    SixLogMapper2 sixLogMapper2;
    @Autowired 
    UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;


    public int addNewSixLog(SixLogVo2 log2, int userId) {
        log2.setOwnerId(userId);
        return sixLogMapper2.addNewSixLog(log2);
    }
    public List<SixLogVo2> getLogByPage(int size, int page) {
        int offset = size * (page - 1);
        List<SixLogVo2> logs = sixLogMapper2.getLogByPage(offset, size);
        for (SixLogVo2 log: logs) {
            Long tmpLikeCounts = findSixLogLikeCount(log.getId());
            long likeCounts = tmpLikeCounts == null? 0: tmpLikeCounts;
            log.setLikeCounts(likeCounts);
        }
        return logs;
    }
    public List<SixLogVo2> getLogByTagByPage(String tag, int size, int page) {
        int offset = size * (page - 1);
        List<SixLogVo2> logs = sixLogMapper2.getLogByTagByPage(tag, offset, size);
        for (SixLogVo2 log: logs) {
            Long tmpLikeCounts = findSixLogLikeCount(log.getId());
            long likeCounts = tmpLikeCounts == null? 0: tmpLikeCounts;
            log.setLikeCounts(likeCounts);
        }
        return logs;
    }
    private Long findSixLogLikeCount(int sixLogId) {
        String entityLikeKey = RedisKeyUtil.getSixLogKey(sixLogId);
        return redisTemplate.opsForList().size(entityLikeKey);
    }

    // ------------- old code below ------------------
    /*
    public List<SixLogVo> getLogByPage(int size, int page) {
        int offset = size * (page - 1);
        // 2023-04-11 22:21:34 changing start
        List<SixLogVo> logs = sixLogMapper.getLogByPage(offset, size);
        for (SixLogVo log: logs) {
            Long tmpLikeCounts = findSixLogLikeCount(log.getId());
            long likeCounts = tmpLikeCounts == null? 0: tmpLikeCounts;
            log.setLikeCounts(likeCounts);
        }
        return logs;
        // 2023-04-11 22:24:17 changing end
    }
    public SixLog getLogById(Long id) {
        return sixLogMapper.getLogById(id);
    }

    public int getTotalAmount() {
        return sixLogMapper.getTotalAmount();
    }
    public List<SixLog> getLogOfMineWithPageAndSize(int size, int page, int userId) {
        // System.out.println("SixLogService: getLogOfMineWithPageAndSize: for user: " + username);
        return null; // sixLogMapper impl 
    }

    public void likeLogById(int userId, int sixLogId) {
        String postKey = RedisKeyUtil.getSixLogKey(sixLogId);
        redisTemplate.opsForList().rightPush(postKey, ""+userId);
    }

    */
}