package com.xj.family.service;

import com.xj.family.bean.CardInstance;
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

@Service
public class CardService {
    @Autowired
    CardInstanceMapper cardInstanceMapper;
    @Autowired
    CardTemplateMapper cardTemplateMapper;
    @Autowired
    GoldMapper goldMapper;

    // user might buy a new card in the shop, then we in service to create a new card instance for he/she
    // so in controller, a method called buyNewCard() might call this method
    public int createCardInstance(int userId, int cardTemplateId) {
        return cardInstanceMapper.createCardInstance(userId, cardTemplateId);
    }
    public CardVo getOneCard(int cardInstanceId) {
        CardInstance cardInstance = cardInstanceMapper.readCardInstance(cardInstanceId);
        CardVo cardVo = new CardVo();
        BeanUtils.copyProperties(cardInstance, cardVo);
        CardTemplate cardTemplate = cardTemplateMapper.readTemplate(cardVo.getTemplateId());
        cardVo.setImageUrl(cardTemplate.getImageUrl());
        cardVo.setBasePrice(cardTemplate.getBasePrice());
        cardVo.setFinalPrice(cardVo.calcFinalPrice());
        return cardVo;
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
        int cardInstanceId = cardInstanceMapper.getUserMainCard(owner).getId();
        int ret = cardInstanceMapper.upgradeCard(cardInstanceId);
        return ret-1;
    }

    public int downgradeCard(Integer owner) {
        int cardInstanceId = cardInstanceMapper.getUserMainCard(owner).getId();
        int ret = cardInstanceMapper.downgradeCard(cardInstanceId);
        return ret-1;
    }

    public int getCardOwner(int cardInstanceId) {
        return cardInstanceMapper.getCardOwner(cardInstanceId);
    }

    public CardTemplate getCardTemplate(int cardInstanceId) {
        return cardInstanceMapper.getCardTemplate(cardInstanceId);
    }

    public int calcCardPrice(int cardInstanceId) {
        int price = (int) (cardInstanceMapper.getCardTemplate(cardInstanceId).getBasePrice() *
                Math.pow(1.05, cardInstanceMapper.readCardInstance(cardInstanceId).getHardWorkRate())
                );
        return price;
    }

    public int tradeCard(int cardInstanceId, int cardFrom, int cardTo) {
        int price = this.calcCardPrice(cardInstanceId);
        goldMapper.subtractGoldForUser(cardTo, price);
        goldMapper.addGoldForUser(cardFrom, price);
        cardInstanceMapper.setCardOwner(cardInstanceId, cardTo);
        return 0;
    }

    public CardVo getMyMainCard(Integer owner) {
        CardInstance i = cardInstanceMapper.getUserMainCard(owner);
        CardVo cardVo = new CardVo();
        BeanUtils.copyProperties(i, cardVo);
        CardTemplate cardTemplate = cardTemplateMapper.readTemplate(i.getId());
        cardVo.setDesc(cardTemplate.getDesc());
        return cardVo;
    }
}
