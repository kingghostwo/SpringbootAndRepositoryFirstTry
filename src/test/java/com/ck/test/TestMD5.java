package com.ck.test;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import javax.swing.*;

public class TestMD5 {
    public static void main(String[] args) {
//        int num = (int) (Math.random()*10000+1000);

        String userName = "ww";
        String userPassword="123";
        ByteSource salt = ByteSource.Util.bytes(userName);
        SimpleHash simpleAuthenticationInfo = new SimpleHash("MD5", userPassword, userName,1024);
        System.out.println(simpleAuthenticationInfo);
    }
}
