package com.qusf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SiFan on 2018/5/3.
 */
public class DateUtils {
    /**
     * 正常上班时间
     * @return
     */
    public static Date getgoworkDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =new Date();
        String s = sdf.format(date);
        String str=s+" 09:00:00";
        Date date1=null;
        try {
            date1 = sdf1.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    /**
     * 正常下班时间
     * @return
     */
    public static Date getgohomeDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =new Date();
        String s = sdf.format(date);
        String str=s+" 18:00:00";
        Date date1=null;
        try {
            date1 = sdf1.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
    /**
     * 设置上班打卡最后时限
     */

    public static Date endgoworkDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =new Date();
        String s = sdf.format(date);
        String str=s+" 12:00:00";
        Date date1=null;
        try {
            date1 = sdf1.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
}
