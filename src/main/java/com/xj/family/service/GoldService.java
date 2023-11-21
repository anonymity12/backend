package com.xj.family.service;

import com.xj.family.mapper.GoldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.xj.family.config.Constants.INIT_ALLOC_GOLD_AMOUNT;

@Service
public class GoldService {
    @Autowired
    GoldMapper goldMapper;

    public int allocateNewGoldForUser(int ownerId, int amount) {
        return goldMapper.allocateGoldForUser(ownerId, amount);
    }
    public int addGoldForUser(int ownerId, int addAmount) {
        if (goldMapper.getGoldAmountForUser(ownerId) == null) {
            // user doesn't have gold record yet, let's make one for him
            System.out.println("allocate new gold record for userId" + ownerId);
            allocateNewGoldForUser(ownerId, INIT_ALLOC_GOLD_AMOUNT);
        }
        return goldMapper.addGoldForUser(ownerId, addAmount);
    }
    public int subtractGoldForUser(int ownerId, int subtractAmount) {
        return goldMapper.subtractGoldForUser(ownerId, subtractAmount);
    }
    public int getUserBalance(int userId) {
        return goldMapper.getGoldAmountForUser(userId);
    }
}
