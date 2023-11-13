package com.xj.family.service;

import com.xj.family.bean.vo.CardVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardShopService {
    public int buyANewCard(Integer owner, int cardTemplateId) {
        // read the card price from tbl: card_template
        // read the user's balance
        // compare the values to verify that user can afford this card
        // then create a card instance for him/her
        // cardInstanceMapper.createCardInstance(userId, cardTemplateId);
        return 0;
    }

    public List<CardVo> getAllSellCards() {
        return null;
    }
}
