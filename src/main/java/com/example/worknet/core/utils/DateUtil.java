package com.example.worknet.core.utils;

import java.util.Date;

/**
 * 获取时间
 * @Author: YunJieJiang
 * @Date: Created in 21:45 2018/12/11 0011
 */
public class DateUtil {

    public static java.sql.Date getSqlDate(){
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return  sqlDate;
    }

}
