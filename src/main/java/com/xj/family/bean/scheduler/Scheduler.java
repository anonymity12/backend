package com.xj.family.bean.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component()
public class Scheduler {
    @Scheduled(cron = "0 * 12 * * ?")
    public void scheduleTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String strDate = dateFormat.format(new Date());
        System.out.println("Cron job scheduler: Job running at - " + strDate);
    }
}
