package com.xj.family.mapper;

import com.xj.family.bean.CardInstance;
import com.xj.family.bean.CardTemplate;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CardInstanceMapper {
    // ----------------------- business methods -----------------------
    /* called when users trade,
       but we need gold system to support, later
     */
    int tradeCard(int fromUserId, int toUserId);
    List<CardInstance> listUserCards(int userId); // called when one user want to see all his/her cards
    int switchMainCard(int newCardId, int userId); // called when someone decide a card to refine


    // ----------------------- basic crud methods -----------------------
    int createCardInstance(int userId, int cardTemplateId);
    CardInstance readCardInstance(int cardId);
    int upgradeCard(int cardId); // called when user finish a task
    int downgradeCard(int cardId); // called when user undone a task
    int deleteCardInstance(int cardId);

    int clearUserMainCard(Integer owner);

    CardInstance getUserMainCard(@Param("owner")Integer owner);

    int setUserMainCard(@Param("cardInstanceId") int cardInstanceId);

    int getCardOwner(int cardInstanceId);

    int setCardOwner(int cardInstanceId, int cardTo);

    CardTemplate getCardTemplate(int cardInstanceId);
}
