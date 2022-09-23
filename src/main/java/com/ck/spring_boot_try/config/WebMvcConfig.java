package com.ck.spring_boot_try.config;

import com.ck.spring_boot_try.filter.ParameterFilter;
import com.ck.spring_boot_try.interceptor.UrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer {
        /**
         * 注册“参数过滤器”
         */
    @Bean
    public FilterRegistrationBean<ParameterFilter> filterRegistrationBean() {
        FilterRegistrationBean<ParameterFilter> filterFilterRegistrationBean = new FilterRegistrationBean<ParameterFilter>();
        filterFilterRegistrationBean.setFilter(new ParameterFilter());
        return filterFilterRegistrationBean;
    }

    @Autowired
    private UrlInterceptor urlInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(urlInterceptor).addPathPatterns("/**");
    }
}
