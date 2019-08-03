package com.github.wxiaoqi.security.movie.system.bean;

import lombok.Data;

import java.io.Serializable;

/***
 *
 * @param <T>
 */
@Data
public class ResultData<T> implements Serializable {
    private Integer code;

    private String message;

    private T data;


    /**
     * 功能描述: 
     * 〈构造方法〉
     * 
     * @param code 1
     * @param message 2
     * @return : ResultData
     * @author : zhl
     * @date : 2019/3/18 0018 上午 11:22
     */
    public ResultData(Integer code, String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static ResultData successResult() {
        return successResult(null);
    }

    public static ResultData successResult(Object data) {
        return successResult(ResultCode.SUCCESS.getDesc(),data);
    }

    public static ResultData successResult(String mag,Object data) {
        return new ResultData(ResultCode.SUCCESS.getCode(), mag ,data);
    }


    public static ResultData failResult() {
        return failResult(null);
    }

    public static ResultData failResult(String msg) {
        return failResult(msg,null);
    }

    public static ResultData failResult(String msg,Object data) {
        return new ResultData(ResultCode.FAIL.getCode(),msg,null);
    }



    public static ResultData getResult(Integer code, String message,Object data){
        return new ResultData(code,message,data);
    }
}
