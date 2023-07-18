package com.xj.family.service;

import com.xj.family.bean.CommitDBView;
import com.xj.family.bean.CommitRedisView;
import com.xj.family.mapper.CommitHeatMapMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// basic of service
public class CommitHeatMapService {
    @Autowired
    CommitHeatMapMapper commitHeatMapMapper;
    public List<CommitRedisView> getMyCommitHeatMap(Integer userId) {
        List<CommitDBView> dbViews = commitHeatMapMapper.calcCommitForOnePerson(userId);
        List<CommitRedisView> redisViews = new ArrayList<CommitRedisView>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (CommitDBView view: dbViews){
            CommitRedisView redisView = new CommitRedisView();
            redisView.setSimplifiedDateString(formatter.format(view.getDate()));
            redisViews.add(redisView);
        }
        return redisViews;
    }
}