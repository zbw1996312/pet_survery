package com.pet.survery.util;


import org.apache.tomcat.util.buf.HexUtils;

import java.security.MessageDigest;

public class CodeUtil {

    public static String hexSHA1(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(value.getBytes("utf-8"));
            byte[] digest = md.digest();
            return byteToHexString(digest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String byteToHexString(byte[] bytes) {
        return String.valueOf(HexUtils.toHexString(bytes));
    }
}
