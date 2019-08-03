package com.github.wxiaoqi.security.movie.system.aspect;

import com.github.wxiaoqi.security.movie.system.ValidatorUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import java.lang.reflect.Parameter;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-18 11:10
 **/
@Aspect
@Component
public class ValidationAspect {


    @Pointcut("execution(* com.github.wxiaoqi.security.movie.service.*.*(..))")
    public void point() {
    }


    @Before("point()")
    public void doBefore(JoinPoint joinPoint){

        Object[] objs = joinPoint.getArgs();

        Parameter[] parameters = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameters();
        for (int i = 0; i <parameters.length; i++) {
            Parameter parameter = parameters[i];
            Validated validated = parameter.getAnnotation(Validated.class);
            if (validated==null)continue;

            if (objs==null ||objs[i]==null)
                continue;

            ValidatorUtils.validator(objs[i],validated.value());

            }
    }

   /* @AfterReturning(returning = "ret",pointcut = "weblog()")
    public void doAfter(Object ret) {

    }*/

}
