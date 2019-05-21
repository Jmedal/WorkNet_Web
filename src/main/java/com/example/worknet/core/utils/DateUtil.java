package com.example.worknet.core.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 获取时间
 * @Author: YunJieJiang
 * @Date: Created in 21:45 2018/12/11 0011
 */
public class DateUtil {

    public static java.sql.Date getSqlNowDate(){
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return  sqlDate;
    }

    public static Timestamp getSqlNowDateTime(){
        Date utilDate = new Date();
        Timestamp sqlDateTime = new Timestamp(utilDate.getTime());
        return  sqlDateTime;
    }
}
