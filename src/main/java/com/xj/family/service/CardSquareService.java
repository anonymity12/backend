package com.xj.family.service;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.mapper.CardInstanceMapper;
import com.xj.family.mapper.GoldMapper;
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
    GoldMapper goldMapper;

    public List<CardVo> getAllSquareCards() {
        List<CardVo> vos = cardInstanceMapper.getAllSellableCards();
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
