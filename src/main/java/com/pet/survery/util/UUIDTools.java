package com.pet.survery.util;

import java.util.UUID;

/**
 * ID生成工具
 */
public class UUIDTools {
    /**
     * UUID32 (主键id使用)
     * @return
     */
    public static String uuid32(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 后台管理后台管理员默认账号
     * @return
     */
    public static String uuid8(){
        return UUID.randomUUID().toString().replace("-", "").substring(0,8);
    }

    /**
     * WoostalkId10位默认
     * @return
     */
    public static String uuid10(){
        return UUID.randomUUID().toString().replace("-", "").substring(0,10);
    }

    /**
     * 邀请码，以及手机验证码的使用
     * @return
     */
    public static String uuid6(){
        return UUID.randomUUID().toString().substring(0,6);
    }
}
