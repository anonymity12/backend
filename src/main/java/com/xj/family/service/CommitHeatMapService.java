package com.xj.family.service;

import com.xj.family.bean.CommitDBView;
import com.xj.family.bean.CommitRedisView;
import com.xj.family.mapper.CommitHeatMapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// basic of service
@Service
public class CommitHeatMapService {
    @Autowired
    CommitHeatMapMapper commitHeatMapMapper;
    public List<CommitRedisView> getMyCommitHeatMap(Integer userId) {
        List<CommitDBView> dbViews = commitHeatMapMapper.calcCommitForOnePerson(userId);
        System.out.println("MAPPER: demo db commit view: " + dbViews.get(0));
        List<CommitRedisView> redisViews = new ArrayList<CommitRedisView>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (CommitDBView view: dbViews){
            CommitRedisView redisView = new CommitRedisView();
            redisView.setSimplifiedDateString(formatter.format(view.getCommitDate()));
            redisView.setCount(view.getCommitCount());
            redisViews.add(redisView);
        }
        System.out.println("SERVICE: demo redis commit view: " + redisViews.get(0));
        return redisViews;
    }
}