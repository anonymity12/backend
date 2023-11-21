package com.xj.family.service;

import com.xj.family.bean.CardTemplate;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.mapper.CardInstanceMapper;
import com.xj.family.mapper.CardTemplateMapper;
import com.xj.family.mapper.GoldMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.xj.family.util.BusinessConstants.LOTTERY_MINI_GOLD_REQUIREMENT;

@Service
public class CardShopService {
    @Autowired
    CardInstanceMapper cardInstanceMapper;
    @Autowired
    CardTemplateMapper cardTemplateMapper;
    @Autowired
    GoldMapper goldMapper;
    public int buyANewCard(Integer owner, int cardTemplateId) {
        CardTemplate cardTemplate = cardTemplateMapper.readTemplate(cardTemplateId);
        int cardPrice = cardTemplate.getBasePrice();
        Integer balance = goldMapper.getGoldAmountForUser(owner);
        if (balance < cardPrice) {
            return -1;
        }
        cardInstanceMapper.createCardInstance(owner, cardTemplateId);
        goldMapper.subtractGoldForUser(owner, cardPrice);
        return 0;
    }

    public List<CardVo> getAllSellCards() {
        return null;
    }

    public int makeCardLotteryForUser(Integer userId) {
        Integer goldAmountOfUser = goldMapper.getGoldAmountForUser(userId);
        if (goldAmountOfUser < LOTTERY_MINI_GOLD_REQUIREMENT) {
            return -1;
        }
        goldMapper.subtractGoldForUser(userId, LOTTERY_MINI_GOLD_REQUIREMENT);
        int cardTemplateId = cardTemplateMapper.getRandomCardId();
        cardInstanceMapper.createCardInstance(userId, cardTemplateId);
        return 0;
    }
}
