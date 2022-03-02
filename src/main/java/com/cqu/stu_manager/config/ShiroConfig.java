package com.cqu.stu_manager.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

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
//        filterMap.put("/Tea/*","perms[teacher]");
//        filterMap.put("/Stu/*","perms[student]");
        //添加受限页面
        filterMap.put("/admin","perms[admin]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //设置身份信息认证失败的返回页面。
         shiroFilterFactoryBean.setUnauthorizedUrl("/Unauthorizeerror");
         shiroFilterFactoryBean.setLoginUrl("/tologin");


        return shiroFilterFactoryBean;
        //设置安全管理器

    }
//    @Bean
//    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver=new SimpleMappingExceptionResolver();
//        Properties properties=new Properties();
//        //这里的 /unauthorized 是页面，不是访问的路径
//        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/Unauthorizeerror");
//        properties.setProperty("org.apache.shiro.authz.UnauthenticatedException","/Unauthorizeerror");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return simpleMappingExceptionResolver;
//    }

    @Bean
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm =new UserRealm();


    return userRealm;
}
    /**
     * 对任意错误码，例如 404 500 等统一跳转到指定页面的配置
     * 注意：SpringBoot 2.0 以上为 WebServerFactoryCustomizer，以下为 EmbeddedServletContainerCustomizer
     */
//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
//        return new WebServerFactoryCustomizer<>() {
//            @Override
//            public void customize(ConfigurableWebServerFactory factory) {
//                // 配置
//                ErrorPage error401Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/tologin");
//                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
//                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
//
//                factory.addErrorPages(error401Page, error404Page, error500Page);
//            }
//        };
//    }


}
