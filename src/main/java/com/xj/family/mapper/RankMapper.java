package com.xj.family.mapper;

import com.xj.family.bean.vo.RankInfoVo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.lang.Integer;

public interface RankMapper {
    List<Integer> getUserListRanked();

    /**
     *
     * @return
     * userId    userface 头像	cname 	growFlyCnt	diedFlyCnt	babyFlyCnt
     * 13	https://picgorepo.o	玥玥	        30	0	11
     * 16	http://101.43.166.  天天	        10	3	19
     * 15	https://picgorepo.om郭郭	        4	1	6
     * 14	https://picgorepo.om昕昕	        2	3	9
     * 37	http://101.43.166.pg胡锦晗	    0	0	1
     * 1	https://picgorepo.om虚空	        0	0	5
     */
    List<RankInfoVo> getUserListRankedWithFliesCnt();

    RankInfoVo getUser3KindFliesCnt(int userId);

}
