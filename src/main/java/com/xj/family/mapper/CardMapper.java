package com.xj.family.mapper;

import com.xj.family.bean.Card;

import java.util.List;

public interface CardMapper {
    int upgradeCard(int cardId);
    int downgradeCard(int cardId);
    int tradeCard(int fromUserId, int toUserId);
    List<Card> listUserCards(int userId);
    int replaceCardToRefine(int newCardId, int userId);
}
