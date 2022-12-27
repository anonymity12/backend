package com.xj.family.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class LifeIndicator {
    Long userId; 
    Date birth;
    Date death;

    public LifeIndicator() {}

    public int getDayPassed() {
        LocalDate parsedBirth = LocalDate.parse(birth.toString());
        LocalDate nowDate = LocalDate.now();
        long dayPassed = parsedBirth.until(nowDate, ChronoUnit.DAYS);
        return (int)dayPassed;
    }

    public int getDayAll() {
        LocalDate parsedBirth = LocalDate.parse(birth.toString());
        LocalDate parsedDeath = LocalDate.parse(death.toString());
        long dayAll = parsedBirth.until(parsedDeath, ChronoUnit.DAYS);
        return (int)dayAll;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", birth='" + getBirth() + "'" +
            ", death='" + getDeath() + "'" +
            "}";
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getBirth() {
        return this.birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return this.death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }


}