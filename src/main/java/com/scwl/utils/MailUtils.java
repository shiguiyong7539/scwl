package com.scwl.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 发邮件工具类
 */
public final class MailUtils {
    private static final String USER = ""; // 发件人称号，同邮箱地址
    private static final String PASSWORD = ""; // 如果是qq邮箱可以使户端授权码，或者登录密码



        @Autowired
        private JavaMailSenderImpl mailSender;
      public  void contextLoads() {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("你的qq邮箱地址xxx@qq.com");
            mailMessage.setTo("发送的目标地址");
            mailMessage.setText("你好 hello world");
            mailMessage.setSubject("测试Spring邮箱服务");
            mailSender.send(mailMessage);
            System.out.println("====完成发送！====");
        }







}
