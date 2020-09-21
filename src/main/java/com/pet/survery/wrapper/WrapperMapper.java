package com.pet.survery.wrapper;

import com.pet.survery.encrypt.AESUtil;
import com.pet.survery.model.KeyEnum;
import com.pet.survery.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WrapperMapper {
    static Logger log= LoggerFactory.getLogger(WrapperMapper.class);

    /**
     * 初始化一个空的wrapper对象
     */
    private WrapperMapper(){}

    /**
     * 返回失败结果方法
     * @param code 响应编号
     * @param message  响应信息
     * @param o 响应体
     * @return
     */
    public static String error (String code,String message,Object o){
        Wrapper<Object> objectWrapper = new Wrapper<>(code, message, o);
        String returnResult = JsonUtils.toJsonString(objectWrapper);
        //对返回结果进行加密
        String encrypt=new String();
        try {
             encrypt = AESUtil.encrypt(returnResult, KeyEnum.AES_KEY.getCode());
        } catch (Exception e) {
            log.debug("返回对象进行aes加密的时候出错" + e.getMessage());
        }
        return returnResult;
    }

    /**
     * 返回失败结果方法
     * @param code 响应编号
     * @param message  响应信息
     * @return
     */
    public static String error (String code,String message){
        Wrapper<Object> objectWrapper = new Wrapper<>(code, message, null);
        String encrypt=new String();
        try {
            String returnResult = JsonUtils.toJsonString(objectWrapper);
            encrypt= AESUtil.encrypt(returnResult, KeyEnum.AES_KEY.getCode());
        } catch (Exception e) {
            log.debug("返回对象进行aes加密的时候出错" + e.getMessage());
        }
        return encrypt;
    }


    /**
     * 返回成功结果方法
     * @param
     * @return
     */
    public static String success (Object o){
        Wrapper<Object> objectWrapper = new Wrapper<>(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, o);
        String returnResult = JsonUtils.toJsonString(objectWrapper);
        String encrypt=new String();
        try {
            encrypt= AESUtil.encrypt(returnResult, KeyEnum.AES_KEY.getCode());
        } catch (Exception e) {
            log.debug("返回对象进行aes加密的时候出错" + e.getMessage());
        }
        return encrypt;
    }

    /**
     * 返回成功结果方法
     * @param
     * @return
     */
    public static String success (){
        Wrapper<Object> objectWrapper = new Wrapper<>();
        String returnResult = JsonUtils.toJsonString(objectWrapper);
        String encrypt=new String();
        try {
            encrypt= AESUtil.encrypt(returnResult, KeyEnum.AES_KEY.getCode());
        } catch (Exception e) {
            log.debug("返回对象进行aes加密的时候出错" + e.getMessage());
        }
        return encrypt;
    }
}
