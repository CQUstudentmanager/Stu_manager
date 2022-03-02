package com.cqu.stu_manager.service;

import org.springframework.context.annotation.Configuration;

/**
 * 发送邮件服务
 * @author LingDu
 * 2017.8.18
 */
@Configuration
public interface MailService {
    /**
     * 发送简单邮件
     * @param to
     * @param subject
     * @param content
     */
    public void send(String to, String subject, String content);

}