package com.xj.family.util;

public class RedisKeyUtil {
    public static final String SPLIT = ":";
    public static final String PREFIX_LIKE_ENTITY = "like:entity";
    public static final String PREFIX_LIKE_USER = "like:user";
    public static final String PREFIX_LIKE_POST = "like:post";

    public static String getEntityLikeKey(int entityType, long entityId) {
        return PREFIX_LIKE_ENTITY + SPLIT + entityType + SPLIT + entityId;
    }
    public static String getSixLogKey(int sixLogId) {
        return PREFIX_LIKE_POST + SPLIT + sixLogId;
    }
}
