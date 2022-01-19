package com.xj.family.service;

import java.util.ArrayList;
import java.util.List;

import com.xj.family.bean.Say;
import com.xj.family.mapper.SayMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SayService {
    @Autowired
    SayMapper sayMapper;

    public int addNewSay(Say say) {
        int i = sayMapper.addNewSay(say);
        return i;
    }

    public List<Say> getAllSays() {
        List<Say> says = new ArrayList<Say>();
        says = sayMapper.getAllSays();
        return says;
    }
    
}
