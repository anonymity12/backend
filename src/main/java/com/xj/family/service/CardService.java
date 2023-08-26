package com.xj.family.service;

import com.xj.family.bean.CardInstance;
import com.xj.family.bean.CardTemplate;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.mapper.CardInstanceMapper;
import com.xj.family.mapper.CardTemplateMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardInstanceMapper cardInstanceMapper;
    @Autowired
    CardTemplateMapper cardTemplateMapper;

    // user might buy a new card in the shop, then we in service to create a new card instance for he/she
    // so in controller, a method called buyNewCard() might call this method
    public int createCardInstance(int userId, int cardTemplateId) {
        return cardInstanceMapper.createCardInstance(userId, cardTemplateId);
    }
    public int tradeCard(int cardInstanceId, int from, int to) {

        return 0;
    }

    public List<CardVo> getAllMyCards(int userId) {
        List<CardInstance> cardInstances = cardInstanceMapper.listUserCards(userId);
        List<CardVo> cardVos = new ArrayList<>();
        cardInstances.forEach(i -> {
            CardVo cardVo = new CardVo();
            BeanUtils.copyProperties(i, cardVo);
            CardTemplate cardTemplate = cardTemplateMapper.readTemplate(i.getId());
            cardVo.setName(cardTemplate.getName());
            cardVo.setSeries(cardTemplate.getSeries());
            cardVo.setImageUrl(cardTemplate.getImageUrl());
            cardVo.setBasePrice(cardTemplate.getBasePrice());
            int finalPrice =(int) (cardVo.getBasePrice() * Math.pow(1.01, (double) cardVo.getHardWorkRate()));
            cardVo.setFinalPrice(finalPrice);
            cardVos.add(cardVo);
        });
        return cardVos;
    }

    public int setMainCard(Integer owner, int newMainCardId) {
        cardInstanceMapper.clearUserMainCard(owner);
        cardInstanceMapper.setUserMainCard(newMainCardId);
        return 0;
    }

    public int upgradeCard(Integer owner) {
        int cardInstanceId = cardInstanceMapper.getUserMainCard(owner);
        cardInstanceMapper.upgradeCard(cardInstanceId);
        return 0;
    }

    public int downgradeCard(Integer owner) {
        int cardInstanceId = cardInstanceMapper.getUserMainCard(owner);
        cardInstanceMapper.downgradeCard(cardInstanceId);
        return 0;
    }
}
