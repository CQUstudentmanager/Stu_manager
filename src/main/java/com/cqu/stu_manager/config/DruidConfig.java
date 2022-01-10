package com.cqu.stu_manager.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDatesource(){
        return new DruidDataSource();
    }
    @Bean
    public ServletRegistrationBean a(){
        ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
     HashMap<String,String> initParameters=new HashMap<>();
     initParameters.put("loginUsername","changyao");
     initParameters.put("loginPassword","changyao");
        bean.setInitParameters(initParameters);
        initParameters.put("allow","");
        return  bean;
    }
}
