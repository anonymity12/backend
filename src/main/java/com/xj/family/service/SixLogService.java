package com.xj.family.service; 

import com.xj.family.mapper.SixLogMapper;
import com.xj.family.mapper.UserMapper;
import com.xj.family.bean.SixLog; 
import com.xj.family.bean.vo.SixLogVo;

import com.xj.family.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service 
public class SixLogService {
    @Autowired
    SixLogMapper sixLogMapper;
    @Autowired 
    UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    public List<SixLogVo> getLogByPage(int size, int page) {
        int offset = size * (page - 1);
        // 2023-04-11 22:21:34 chaging start
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
    public int addNewSixLog(SixLog log, int userId) {
        log.setOwnerId(userId);
        return sixLogMapper.addNewSixLog(log);
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
    public Long findSixLogLikeCount(int sixLogId) {
        String entityLikeKey = RedisKeyUtil.getSixLogKey(sixLogId);
        return redisTemplate.opsForList().size(entityLikeKey);
    }
}