package com.pet.survery.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.survery.model.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangbowei
 * @since 2020/09/17 15:!2
 * @description 此类是创建默认返回前端对象的处理类
 * @param <T>
 */
@Data
public class Wrapper<T> implements Serializable {
    /**
     * 序列化标识
     */
    private static final long serialVersionUID = 4893280118017319089L;

    /**
     * 成功码
     */
    public static final String SUCCESS_CODE = ErrorCodeEnum.SUCCESS.getCode();

    /**
     * 成功返回信息
     */

    public static final String SUCCESS_MESSAGE = ErrorCodeEnum.SUCCESS.getMessage();

    /**
     * 响应编号
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应体
     */
    private T data;

    /**
     * 默认初始化一个成功响应的wrapper对象
     */
    public Wrapper(){
        this(SUCCESS_CODE,SUCCESS_MESSAGE);
    }

    /**
     * 初始化一个wrapper对象
     * @param code 响应编号
     * @param msg 响应信息
     */
    public Wrapper(String code,String msg){
        this(code,msg,null);
    }

    /**
     * 初始化一个wrapper对象
     * @param code 响应编号
     * @param msg 响应信息
     * @param data 响应体
     */
    public Wrapper(String code,String msg,T data){
        super();
        this.code(code).msg(msg).data(data);
    }


    /**
     * 用于set响应编号用，返回自身的引用
     * @param code 响应编号
     * @return
     */
    public Wrapper<T> code(String code) {
        this.setCode(code);
        return this;
    }

    /**
     * 用于set响应信息用,返回自身的引用
     * @param msg 响应信息
     * @return
     */
    public Wrapper<T> msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    /**
     * 用于set响应返回体用,返回自身的引用
     * @param data 响应返回体
     * @return
     */
    public Wrapper<T> data(T data) {
        this.setData(data);
        return this;
    }

    /**
     * 用于判断是否成功：依据Wrapper.SUCCESS_CODE =this.code
     * @return code !=0,true;else,false
     */
    @JsonIgnore
    public boolean success(){
        return Wrapper.SUCCESS_CODE.equalsIgnoreCase(this.code);
    }

    /**
     * 不成功返回错误信息
     * @return
     */
    @JsonIgnore
    public boolean error(){
        return !success();
    }
}
