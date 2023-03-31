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
        return sixLogMapper.getLogByPage(offset, size);
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

    public void likeLogById(int userId, long sixLogId) {
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                String entityLikeKey = RedisKeyUtil.getEntityLikeKey(0, sixLogId);
                boolean isMember = operations.opsForSet().isMember(entityLikeKey, userId);
                operations.multi();
                if (isMember) {
                    // cancel like
                    operations.opsForSet().remove(entityLikeKey, userId);
                } else {
                    // do like
                    operations.opsForSet().add(entityLikeKey, userId);
                }
                return operations.exec();
            }
        });
    }
    public Long findSixLogLikeCount(long sixLogId) {
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(0, sixLogId);
        return redisTemplate.opsForSet().size(entityLikeKey);
    }
}