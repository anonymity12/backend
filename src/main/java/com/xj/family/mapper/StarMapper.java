package com.xj.family.mapper;

import com.xj.family.bean.vo.StarInfoVo;
import com.xj.family.bean.vo.UserAndTheirStarCount;

import java.util.List;

public interface StarMapper {
    List<StarInfoVo> listStarInfo(int owner);
    List<StarInfoVo> listStarInfoOnlyThisWeek(int owner);
    List<StarInfoVo> listStarRecordsOfAllUsersRecently();
    List<StarInfoVo> listRecentStarsForUser(int userId, int recentCnt);
    int saveStarRecord(StarInfoVo vo);
    List<UserAndTheirStarCount> getStarRaceBayData();
    List<UserAndTheirStarCount> getStarWeeklyData();
    /*
    当你想看上一周的时,(或者更早,改7即可)//上述本周,就是 1
    select u.id as userId, u.userface as userface, u.cname as username, count(s.id) as cnt
        from user u
        left join
        (select * from starrecord where yearweek(starDateTime,1)=yearweek(curdate()-interval 7 day,1)) s
        on u.id=s.owner         
        group by u.id         
        order by cnt desc;
     */
}