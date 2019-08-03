package com.github.wxiaoqi.security.movie.system.exception;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-18 10:44
 **/
public class BeanValidatorException extends ApplicationException {
    public BeanValidatorException() {
    }

    public BeanValidatorException(String message) {
        super(message);
    }

    public BeanValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanValidatorException(Throwable cause) {
        super(cause);
    }

    public BeanValidatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
