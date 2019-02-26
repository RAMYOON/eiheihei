package com.yoon.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ShiroTest {

    @Test
    public void loginOutTest() {
        // 创建SecurityManager工厂类
        // Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        // 通过SecurityManager工厂类创建SecurityManager对象
        SecurityManager securityManager = factory.getInstance();

        // 创建subject
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        // 创建用于验证的token，通常为用户输入
        UsernamePasswordToken token = new UsernamePasswordToken("yoon", "baccano");
        try {
            subject.login(token);
        } catch (AuthenticationException exception) {
            System.err.println("error!");
        }

        Assert.assertEquals(true, subject.isAuthenticated());

        subject.logout();


    }
}
