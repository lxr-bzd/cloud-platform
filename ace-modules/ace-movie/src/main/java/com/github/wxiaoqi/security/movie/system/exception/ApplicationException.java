package com.github.wxiaoqi.security.movie.system.exception;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-14 15:50
 **/
public class ApplicationException extends RuntimeException {


    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
