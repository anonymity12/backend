package com.xj.family.service;


import com.xj.family.bean.Role;
import com.xj.family.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Arrays;

/**
 * Created by sang on 2017/12/17.
 */
@Service
@Transactional
public class UserService implements UserDetailsService {
 
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("ttt>>> someone are login ");
        User user = new User();
        user.setUsername(s);
        //查询用户的角色信息，并返回存入user中
        Role r1 = new Role(1l, "admin");
        Role r2 = new Role(2l, "user");
        List<Role> roles = Arrays.asList(r1, r2);
        user.setRoles(roles);
        return user;
    }

}

