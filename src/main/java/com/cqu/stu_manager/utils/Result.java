package com.cqu.stu_manager.utils;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Author : MIAOHY
 * time : 2021/1/26
 */
@Data
@Builder
@AllArgsConstructor
public class Result<T> implements Serializable {
    /**
     * 响应码
     */
    private int code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;
    /**
     * 响应时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time =new Date();

    public Result() {

    }

    public static Result result(ResultCode resultCode, Object data){
        return result(resultCode,null,data);
    }

    public static Result result(ResultCode resultCode, String msg, Object data){
        boolean success = false;
        if (resultCode.getCode() == ResultCode.SUCCESS.getCode()){
            success = true;
        }
        String message = resultCode.getMsg();
        if (StrUtil.isNotBlank(msg)){
            message = msg;
        }
        return Result.builder()
                .code(resultCode.getCode())
                .msg(message)
                .data(data)
                .time(new Date())
                .build();
    }

    public static Result ok(Object data){
        return result(ResultCode.SUCCESS,data);
    }
    public static Result ok(Object data, String msg){
        return result(ResultCode.SUCCESS,msg,data);
    }

    public static Result fail(Object data){
        return result(ResultCode.FAIL,data);
    }
    public static Result fail(Object data, String msg){
        return result(ResultCode.FAIL,msg,data);
    }

}