package com.pet.survery.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author zhangbowei
 * @desciption 对象字段校验工具类
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator =Validation.buildDefaultValidatorFactory().getValidator();
    }

    //第二种方式创建Validator
//	static {
//		ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
//		        .configure()
//		        .failFast(true)
//		        .buildValidatorFactory();
//	 validator = validatorFactory.getValidator();
//	}


    public static List<String> validateEntity(Object object,Class<?>... groups) {
        Set<ConstraintViolation<Object>> validate = validator.validate(object, groups);
//		ConstraintViolation<Object> constraint = validate.iterator().next();
        List<String> list = new ArrayList<>();
        for(ConstraintViolation<Object> aa :validate) {
            list.add(aa.getMessage());
        }
        return list;
    }
}