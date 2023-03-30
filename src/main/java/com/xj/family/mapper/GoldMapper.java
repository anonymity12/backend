package com.xj.family.mapper;

public interface GoldMapper {
    int allocateGoldForUser(int ownerId, int allocateAmount);
    int addGoldForUser(int ownerId, int addAmount);
    int subtractGoldForUser(int ownerId, int subtractAmount);
    Integer getGoldAmountForUser(int ownerId);
}
