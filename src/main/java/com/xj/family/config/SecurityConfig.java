package com.xj.family;

import com.xj.family.bean.RespBean;
 
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean 
    JsonAuthenticationFilter loginFilter() throws Exception {
        JsonAuthenticationFilter loginFilter = new JsonAuthenticationFilter();
        loginFilter.setAuthenticationSuccessHandler(new 
                AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, 
                                                        HttpServletResponse response, 
                                                        Authentication authentication) 
                                                    throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        Object authInfo =  authentication.getPrincipal();
                        RespBean ok = RespBean.ok("您登录成功!", authInfo);
                        String s = new ObjectMapper().writeValueAsString(ok);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                });
        loginFilter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, 
                                            HttpServletResponse response, 
                                            AuthenticationException exception)
                                            throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                RespBean respBean = RespBean.error(exception.getMessage());
                if (exception instanceof LockedException) {
                    respBean.setMsg("账户被锁定，请联系管理员!");
                } else if (exception instanceof CredentialsExpiredException) {
                    respBean.setMsg("密码过期，请联系管理员!");
                } else if (exception instanceof AccountExpiredException) {
                    respBean.setMsg("账户过期，请联系管理员!");
                } else if (exception instanceof DisabledException) {
                    respBean.setMsg("账户被禁用，请联系管理员!");
                } else if (exception instanceof BadCredentialsException) {
                    respBean.setMsg("用户名或者密码输入错误，请重新输入!");
                }
                out.write(new ObjectMapper().writeValueAsString(respBean));
                out.flush();
                out.close();
            }
        });
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/doLogin");
        return loginFilter;
    }
 
    // add this, cause spring security ban our original cors annotation
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("yy")
                .password("666").roles("admin")
                .and()
                .withUser("gg")
                .password("123")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(); // add this, so that /login url can be visited
        http.authorizeRequests()
            .and()
            .logout()
            //.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
            .logoutUrl("/logout")
            .logoutSuccessHandler((req, resp, authentication) -> {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.write("注销成功");
                out.flush();
                out.close();
            })
            .permitAll()
            .and()
            .csrf().disable().exceptionHandling()
            //  authenticationEntryPoint is used when user not logged in, here we will return a json
            .authenticationEntryPoint((req, resp, authException) -> {
                resp.setContentType("application/json;charset=utf-8");
                resp.setStatus(401);
                PrintWriter out = resp.getWriter();
                RespBean respBean = RespBean.error("访问失败!");
                if (authException instanceof InsufficientAuthenticationException) {
                    respBean.setMsg("请求失败，请联系管理员!");
                }
                out.write(new ObjectMapper().writeValueAsString(respBean));
                out.flush();
                out.close();
            });
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
