package com.pet.survery.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    //时间转换规则
    static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static Logger log= LoggerFactory.getLogger(DateUtils.class);
    public static Date returnToDateFromMillisSeconds(Long TimeMillis){

        Calendar ca=Calendar.getInstance();
        ca.setTimeInMillis(Long.valueOf(TimeMillis));
        String format = sd.format(ca.getTimeInMillis());
        try {
            Date formatedDate = sd.parse(format);
            return formatedDate;
        } catch (ParseException e) {
            log.debug("转换时间出现异常" + e.toString());
            return null;
        }
    }

    public static Date addOneDay(Date date){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE, 1);
        Date resultDate = rightNow.getTime();
        return resultDate;
    }

    //将时间增加一个月
    public static Date addOneMonth(Date date){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, 1);
        Date resultDate = rightNow.getTime();
        return resultDate;
    }

    //将时间增加3个月
    public static Date addThreeMonth(Date date){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, 3);
        Date resultDate = rightNow.getTime();
        return resultDate;
    }

    //将时间增加6个月
    public static Date addHalfYear(Date date){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, 6);
        Date resultDate = rightNow.getTime();
        return resultDate;
    }

    //将时间增加1年
    public static Date addYear(Date date){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, 1);
        Date resultDate = rightNow.getTime();
        return resultDate;
    }

    //添加90年
    public static Date addYears(Date date){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, 90);
        Date resultDate = rightNow.getTime();
        return resultDate;
    }

}
