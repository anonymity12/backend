package com.xj.family.service;
import com.xj.family.bean.CardInstance;
import com.xj.family.bean.CardTemplate;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.mapper.CardInstanceMapper;
import com.xj.family.mapper.CardTemplateMapper;
import com.xj.family.mapper.GoldMapper;
import com.xj.family.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardSquareService {

    @Autowired
    CardInstanceMapper cardInstanceMapper;
    @Autowired
    CardTemplateMapper cardTemplateMapper;
    @Autowired
    GoldMapper goldMapper;
    @Autowired
    UserMapper userMapper;

    public List<CardVo> getAllSquareCards() {
        List<CardInstance> instances = cardInstanceMapper.getAllSellableCards();
        List<CardVo> vos = new ArrayList<>();
        for (CardInstance ins : instances) {
            CardVo vo = new CardVo();
            BeanUtils.copyProperties(ins, vo);
            String ownerName = userMapper.getUserById(ins.getOwner()).getName();
            vo.setOwnerName(ownerName);
            CardTemplate template = cardTemplateMapper.readTemplate(ins.getTemplateId());
            BeanUtils.copyProperties(template, vo);
            vo.calcFinalPrice();
        }
        return vos;
    }
    public int tradeCard(int cardInstanceId, int cardFrom, int cardTo) {
        int price = this.calcCardPrice(cardInstanceId);
        goldMapper.subtractGoldForUser(cardTo, price);
        goldMapper.addGoldForUser(cardFrom, price);
        cardInstanceMapper.setCardOwner(cardInstanceId, cardTo);
        return 0;
    }

    private int calcCardPrice(int cardInstanceId) {
        int price = (int) (cardInstanceMapper.getCardTemplate(cardInstanceId).getBasePrice() *
                Math.pow(1.05, cardInstanceMapper.readCardInstance(cardInstanceId).getHardWorkRate())
        );
        return price;
    }
}
