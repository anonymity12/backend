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
       /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**")
                //放行路径，可以添加多个
                .excludePathPatterns("/api/login", "/api/sixlog/covers","/api/img/**");// append sixlog/covers at 2022-12-31 23:15:39
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/img/**").addResourceLocations("file:" + "/home/tt/code/CodeForFamily/backend/img_upload/");
    }
  //   // fix element ui request bug
  //   @Override
  // public void addCorsMappings(CorsRegistry registry) {

  //   registry.addMapping("/api/img/**")
  //     .allowedOrigins(Constants.FRONT_URL_DEV)
  //     .allowedMethods("GET", "POST")
  //     .allowCredentials(true).maxAge(3600);

  //   // Add more mappings...
  // }
}
