package com.github.wxiaoqi.security.movie.system;

import com.github.wxiaoqi.security.movie.entity.User;
import com.github.wxiaoqi.security.movie.system.exception.BeanValidatorException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-17 10:45
 **/
public class ValidatorUtils {



    public static void validator(Object obj){

        validator(obj,null);

    }

    public static void validator(Object obj,Class[] groupClass){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> requestViolations = groupClass==null?validator.validate(obj):validator.validate(obj,groupClass);
        if(requestViolations.isEmpty())return;
        throw new BeanValidatorException(requestViolations.iterator().next().getMessage());

    }


    public static void main(String[] args) {

        User user = new User();
        user.setName("a");
        user.setAccount("");
        validator(user);
        System.out.println(user);
    }


}
