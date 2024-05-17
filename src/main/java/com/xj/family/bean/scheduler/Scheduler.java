package com.xj.family.bean.scheduler;

import com.xj.family.bean.FlyItem;
import com.xj.family.bean.Task;
import com.xj.family.mapper.FlyItemMapper;
import com.xj.family.mapper.TaskMapper;
import com.xj.family.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// @Component()
public class Scheduler {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    FlyItemMapper flyItemMapper;
    @Autowired
    RoutineService routineService;
    @Scheduled(cron = "0 0 3 * * ?") // At 03:00 AM  , see: https://crontab.cronhub.io/
    public void scheduleTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String strDate = dateFormat.format(new Date());
        System.out.println("Cron job scheduler: Job running at - " + strDate);
        insertDailyRoutine();
    }

    private void insertDailyRoutine() {
        // 1. query routine
        List<Task> tasks = routineService.transformAllRoutineToTask();
        // 2. shape new task
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日:");
        String todayStr = simpleDateFormat.format(new Date());
        tasks.forEach(it -> {
            it.setMatrix(1); // we think routine has matrix prop 1
            it.setTitle(todayStr + it.getTitle());
        });
        //3. insert correspond fly item for routine task and real task
        final boolean[] insertFailFlag = new boolean[1];
        tasks.forEach(it -> {
            FlyItem flyItem = new FlyItem();
            flyItem.setOwner(it.getOwner());
            flyItem.setName("健康生活蝶"); // 例行公事蝶
            flyItem.setEvaluate(it.getTitle());
            flyItem.setStatus(0);
            flyItemMapper.addForTaskCreated(flyItem);
            long flyId = flyItem.getId();
            it.setFlyId(flyId);
            int ret = taskMapper.addRoutineTask(it);
            if (ret < 1) {
                insertFailFlag[0] = true;
            }
        });
        // 4. almost done, just check if there are any error
        if (insertFailFlag[0]) {
            System.out.println("Cron Job: insert routine failed at least once");
        }
    }
}
