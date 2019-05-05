package com.example.worknet.common.state;

/**
 * @Description 所有业务异常的枚举
 * @Author: YunJieJiang
 * @Date: Created in 1:14 2018/8/24 0024
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中"),
    ;
    private  Integer code;

    private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
