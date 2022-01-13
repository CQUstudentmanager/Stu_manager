package com.cqu.stu_manager.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getshiroFilterFactoryBean(@Qualifier("getdefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /*
        * anon:无需认证
        * authc:必须认证才能访问
        * user:
        * perms:拥有对某个资源的权限才能访问
        * role：拥有某个权限才能访问
        */
        Map<String,String>filterMap=new LinkedHashMap<>();
        filterMap.put("/STUDENTLIST","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
        //设置安全管理器

    }

    @Bean
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("studentRealm") StudentRealm studentRealm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(studentRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public StudentRealm studentRealm(){
        StudentRealm studentRealm=new StudentRealm();


    return studentRealm;
}
}
