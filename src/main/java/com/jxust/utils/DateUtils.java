package com.jxust.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  日期与字符串相互转换的工具类
 */
public class DateUtils {

    /**
     * 将日期转换为字符串
     * @param date  日期
     * @param pattern  字符串
     * @return
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 将字符串转化为日期
     * @param str   字符串
     * @param pattern   日期格式
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date parse = sdf.parse(str);
        return parse;
    }

}
