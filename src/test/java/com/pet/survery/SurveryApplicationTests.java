package com.pet.survery;

import com.pet.survery.encrypt.AESUtil;
import com.pet.survery.model.KeyEnum;
import com.pet.survery.wrapper.WrapperMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class SurveryApplicationTests {

    @Test
    void contextLoads() {
    }

    /*@Test
    void contextLoadss() {
        System.out.println("返回结果为："+WrapperMapper.error("123","hhdhjd"));
    }
*/
    /*@Test
    void decropt() {
        String hhdhjd = WrapperMapper.error(",?h&69_F;XsZ(@Rc", "2A3UY1eUr8CNpsNCtzqDwReGIAye1c30aytn0cBghmD+jjLo4ACR311vibVDUB0Z\n");
        try {
            String decrypt = AESUtil.decrypt(hhdhjd, KeyEnum.AES_KEY.getCode());
            System.out.println("返回结果为:" + decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
     }*/

   /* @Test
    void decroptResult() {
        try {
            String decrypt = AESUtil.decrypt("2A3UY1eUr8CNpsNCtzqDwReGIAye1c30aytn0cBghmD+jjLo4ACR311vibVDUB0Z", KeyEnum.AES_KEY.getCode());
            System.out.println("返回结果为:" + decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    }
