package com.example.worknet.core.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * @Author: YunJieJiang
 * @Date: Created in 13:33 2019/5/6 0006
 */
public class RandomString {

    /**
     * 生成的字符串每个位置都有可能是str中的一个字母或数字，需要导入的包是import java.util.Random;
     * length用户要求产生字符串的长度
     * @param length
     * @return
     */
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 可以指定某个位置是a-z、A-Z或是0-9，需要导入的包是import java.util.Random;
     * 可以指定字符串的某个位置是什么范围的值
     * @param length
     * @return
     */
    public static String getRandomString2(int length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(3);
            long result=0;
            switch(number){
                case 0:
                    result=Math.round(Math.random()*25+65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

    /**
     * org.apache.commons.lang包下有一个RandomStringUtils类，其中有一个randomAlphanumeric(int length)函数，可以随机生成一个长度为length的字符串。
     * @param length
     * @return
     */
    public static String randomAlphanumeric(int length){
        return RandomStringUtils.randomAlphanumeric(10);
    }

}
