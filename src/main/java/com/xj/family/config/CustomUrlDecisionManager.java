/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomUrlDecisionManager implements AccessDecisionManager{
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // what path_role that the url need
        for (ConfigAttribute configAttribute : configAttributes) {
            String needRole = configAttribute.getAttribute();
            if ("ROLE_XJTMP".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    System.out.println("a anonymous user");
                    throw new AccessDeniedException("customDecide: anonymous use are not allowed exception");
                } else {
                    System.out.println("not anonymous, but has ROLE_XJTMP");
                    return;
                }
            }
            // what auth_role that user have
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return; // once user has a role that satisfy needRole, the ok return
                }
            }
        }
        throw new AccessDeniedException("customDecide: finally you are no role that satisfy");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
