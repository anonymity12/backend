package com.xj.family.utils;
import com.xj.family.bean.Hr;

import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtil {
    public static Hr getCurrentUser() {
        Hr user =  (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
