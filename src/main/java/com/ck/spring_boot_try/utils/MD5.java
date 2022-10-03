package com.ck.spring_boot_try.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

public class MD5 {
    private static String SALT = "&%5123***&&%%$$#@";

    public static String getMD5(String username, String password) {
        if (StringUtils.isBlank(password) || StringUtils.isBlank(username)) {
            return null;
        } else if (StringUtils.isNotBlank(username)) {
            SALT = username;
        }
        String base = password + "/" + SALT;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
