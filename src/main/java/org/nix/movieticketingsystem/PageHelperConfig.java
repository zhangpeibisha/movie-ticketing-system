package org.nix.movieticketingsystem;


import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Create by zhangpe0312@qq.com on 2018/5/2.
 *
 * 分页插件配置
 */
@Configuration
public class PageHelperConfig {
    @Value("${pagehelper.helperDialect}")
    private String helperDialect;


    @Bean
    public PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", helperDialect);
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
