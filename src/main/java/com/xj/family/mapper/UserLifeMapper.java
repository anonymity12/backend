package com.xj.family.mapper;
import java.sql.Date;



public interface UserLifeMapper {
    int setLifeStartAndEnd(int userId, Date start, Date end);
}