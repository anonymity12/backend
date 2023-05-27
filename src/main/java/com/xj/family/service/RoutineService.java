package com.xj.family.service;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.Routine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoutineService {

    public List<Routine> queryAllRoutineForUser() {
        List<Routine> fake = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fake.add(new Routine("内容"+i, i, i*10));
        }
        return fake;
    }

    public RespBean addRoutineForUser(Routine routine) {
        return RespBean.ok("add faked");
    }

    public RespBean updateRoutineForUser(Routine routine) {
        return RespBean.ok("update faked");
    }

    public RespBean deleteRoutineById(Integer routineId) {
        return RespBean.ok("delete faked");
    }
}
