package com.pet.survery.encrypt;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhangbowei
 * @descrtion md5加密类
 * @since 2020/09/17 15:47
 * */
public class MD5 {

    /**
     *  MD5 32位字符
     *
     * @param str
     * @return
     */
    public static String toMD5(String str) {

        if (str == null) {
            return null;
        }

        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {

            return str;
        } catch (UnsupportedEncodingException e) {
            return str;
        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            }else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }

        return md5StrBuff.toString();
    }

    /**
     *  MD5 39位数字
     * @param str
     * @return
     */
    public static String toIntegerMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString();
            //return new BigInteger(1, md.digest()).toString(16); //old
        } catch (Exception e) {
            throw new RuntimeException("MD5加密出现错误");
        }
    }

    //md5盐值加密
    /**
     * @param password 需要加密的密码
     *
     * @return HashMap<String,Object>
     */
    public static Map<String,Object> toMD5Salt(String password){
        HashMap result=new HashMap();
        //创建盐值
        String salt = UUID.randomUUID().toString().toUpperCase().substring(0,31).replace("-","");
        result.put("salt",salt);

        //还需要返回经过MD5加密之后的值

        //先制造经过盐值加密的值
        String encodedPassword = salt + password + salt;
        // 循环加密5次
        for (int i = 0; i < 5; i++) {
            // DigestUtils：springboot提供的工具类
            encodedPassword = DigestUtils.md5DigestAsHex(
                    encodedPassword.getBytes()).toUpperCase();
        }
        result.put("encodedPassword",encodedPassword);
        return result;
    }

    //根据MD5和固定的盐值进行加密,获取到固定的密码
    public static String toMD5BringSalt(String password,String salt){
        //先制造经过盐值加密的值
        String encodedPassword = salt + password + salt;
        // 循环加密5次
        for (int i = 0; i < 5; i++) {
            // DigestUtils：springboot提供的工具类
            encodedPassword = DigestUtils.md5DigestAsHex(
                    encodedPassword.getBytes()).toUpperCase();
        }
        return encodedPassword;
    }

}
