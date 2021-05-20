package cn.edu.xmu.alumni.config;

import cn.edu.xmu.alumni.interceptor.AppInterceptor;
import cn.edu.xmu.alumni.interceptor.ApiInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new ApiInterceptor()).
                        addPathPatterns("/alumni/**");
                registry.addInterceptor(new AppInterceptor()).
                        addPathPatterns("/app**");
                WebMvcConfigurer.super.addInterceptors(registry);
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("/login.html");
                //registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/app").setViewName("/index.html");
            }
        };
    }


}
