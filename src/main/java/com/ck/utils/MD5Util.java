package com.ck.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {

    private String userPassword;
    private String userName;

    public String getPasswordByMD5(String password, String salt){
        //盐值即为加密凭证
        String simpleHash = new SimpleHash("MD5",password,salt,1024).toString();
        System.out.println(simpleHash);
        return simpleHash;
    }
}
