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


    public List<CardVo> getAllMyCards(int userId) {
        List<CardInstance> cardInstances = cardInstanceMapper.listUserCards(userId);
        List<CardVo> cardVos = new ArrayList<>();
        cardInstances.forEach(i -> {
            CardVo cardVo = new CardVo();
            BeanUtils.copyProperties(i, cardVo);
            CardTemplate cardTemplate = cardTemplateMapper.readTemplate(i.getTemplateId());
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
    public CardVo getMyMainCard(Integer owner) {
        CardInstance cardInstance = cardInstanceMapper.getUserMainCard(owner);
        CardVo cardVo = new CardVo();
        BeanUtils.copyProperties(cardInstance, cardVo);
        CardTemplate cardTemplate = cardTemplateMapper.readTemplate(cardInstance.getTemplateId());
        BeanUtils.copyProperties(cardTemplate, cardVo);
        cardVo.calcFinalPrice();
        return cardVo;
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
    public int setMainCard(Integer owner, int newMainCardId) {
        cardInstanceMapper.clearUserMainCard(owner);
        cardInstanceMapper.setUserMainCard(newMainCardId);
        return 0;
    }

    public CardVo getOneCard(int cardInstanceId) {
        CardInstance cardInstance = cardInstanceMapper.readCardInstance(cardInstanceId);
        CardVo cardVo = new CardVo();
        BeanUtils.copyProperties(cardInstance, cardVo);
        CardTemplate cardTemplate = cardTemplateMapper.readTemplate(cardVo.getTemplateId());
        cardVo.setImageUrl(cardTemplate.getImageUrl());
        cardVo.setBasePrice(cardTemplate.getBasePrice());
        cardVo.calcFinalPrice();
        return cardVo;
    }

    public int getCardOwner(int cardInstanceId) {
        return cardInstanceMapper.getCardOwner(cardInstanceId);
    }

    public CardTemplate getCardTemplate(int cardInstanceId) {
        return cardInstanceMapper.getCardTemplate(cardInstanceId);
    }





    public int markCardSellable(int cardInstanceId) {
        return cardInstanceMapper.markCardSellable(cardInstanceId);
    }

    public int markCardUnsellable(int cardInstanceId) {
        return cardInstanceMapper.markCardUnsellable(cardInstanceId);

    }
}
