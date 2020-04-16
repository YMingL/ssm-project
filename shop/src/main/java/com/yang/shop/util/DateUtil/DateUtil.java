package com.yang.shop.util.DateUtil;


import java.util.Calendar;

/**
 * 日期工具类
 */
public class DateUtil {

    private static Calendar calendar = Calendar.getInstance();
    private static Calendar old_calendar = Calendar.getInstance();
    /**
     * 判断两个日期是不是相邻两天
     * @param oldMillis 上次登陆时间
     * @param millis 当前登陆时间
     * @return  true 连续  false 非连续
     */
    public static boolean isContinualDay(long oldMillis,long millis){
        calendar.setTimeInMillis(millis);
        old_calendar.setTimeInMillis(oldMillis);
        old_calendar.add(Calendar.DAY_OF_MONTH,1);
        if(calendar.get(Calendar.YEAR) == old_calendar.get(Calendar.YEAR)
                && calendar.get(Calendar.MONTH) == old_calendar.get(Calendar.MONTH)
                && calendar.get(Calendar.DAY_OF_MONTH) == old_calendar.get(Calendar.DAY_OF_MONTH)){
            return true;
        }
        return false;
    }

    /**
     * 判断两个日期是否在同一周，以周一为起始
     * @param oldMillis
     * @param millis
     * @return
     */

    //利用week_od_month 但是注意判断周日这一情况、
    public static boolean isInWeek(long oldMillis,long millis){
        calendar.setTimeInMillis(millis);
        old_calendar.setTimeInMillis(oldMillis);
        //判断两日期之间天的差值与星期数差值是否相等，周日需要转化
        int weekNum = calendar.get(Calendar.DAY_OF_WEEK)-1;
        int old_weekNum = old_calendar.get(Calendar.DAY_OF_WEEK)-1;
        if (weekNum == 0){
            weekNum = 7;
        }
        if (old_weekNum == 0){
            old_weekNum = 7;
        }
        int d_value = weekNum-old_weekNum;

        //如果新日期的星期数小于老日期则两个日期不在一个星期
        if(d_value <= 0){
            return false;
        }
        old_calendar.add(Calendar.DAY_OF_YEAR,d_value);
        if(calendar.get(Calendar.YEAR) == old_calendar.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == old_calendar.get(Calendar.MONTH) && calendar.get(Calendar.DAY_OF_MONTH) == old_calendar.get(Calendar.DAY_OF_MONTH)){
            return true;
        }
        return false;
    }
}
