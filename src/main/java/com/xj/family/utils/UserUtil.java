package com.xj.family.utils;

import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtil {
    public static Object getCurrentUser() {
        Object user =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
