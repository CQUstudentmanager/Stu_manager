package com.cqu.stu_manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author xufan1
 * 邮箱发送实现类
 */
@Service
@Component
public class MailServiceImp implements MailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void send(String to,String subject,String content) {
        // new 一个简单邮件消息对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 和配置文件中的的username相同，相当于发送方
        message.setFrom("changyao2@163.com");
        // 收件人邮箱
        message.setTo(to);
        // 标题
        message.setSubject(subject);
        // 正文
        message.setText(content);
        // 发送
        mailSender.send(message);


    }


}
