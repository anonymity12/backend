package com.xj.family.config;
import com.xj.family.interceptor.LoginInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ButterFlySecurityConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/**")
                //放行路径，可以添加多个
                .excludePathPatterns(
                    "/api/train/**",
                    "/api/login", 
                                    //  "/api/sixlog/covers", // now(2023-01-23 20:24:39) elementui upload set this url in action field, 
                                                        //so no header can be add, so we cannot intercept this request
                                     "/api/img/**", 
                                     "/api/register" // for when user want to register
                                     );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/img/**").addResourceLocations("file:" + "/home/tt/code/CodeForFamily/backend/img_upload/"); // you must add final slash/ , 2023-01-04 14:36:58
    }
}
