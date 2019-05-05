package com.example.worknet.exceptionHandle.handle;

import com.example.worknet.common.state.ResultEnum;
import com.example.worknet.core.utils.Result;
import com.example.worknet.core.utils.ResultUtil;
import com.example.worknet.exceptionHandle.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常拦截
 * @Author: YunJieJiang
 * @Date: Created in 19:29 2018/8/23 0023
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR);
        }
    }
}
