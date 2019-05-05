package com.example.worknet.exceptionHandle.exception;

import com.example.worknet.common.state.ResultEnum;

/**
 * @Author: YunJieJiang
 * @Date: Created in 19:33 2018/8/23 0023
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
