package demo;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhoupanchn on 2019/8/29.
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        /*Date date = new Date();*/
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String           str        = "2019年2月1日";
        long dueTime = getDueTime(new Date());*/
        /*Date             date       = new Date();

        /*System.out.println("当前时间是：" + dateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();

        System.out.println("上一个月的时间： " + dateFormat.format(date));*/
        /*Date              parse    = dateFormat.parse(str);*/
        /*Map<String, Date> weekDate = getWeekDate(parse);
        Date              monday   = weekDate.get("mondayDate");
        Date              sunday   = weekDate.get("sundayDate");
        List<Date>        dates    = findDates(monday, sunday);
        for (Date d : dates) {
            System.out.println(dateFormat.format(d));
        }
        System.out.println(getStartDate(new Date()));
        System.out.println(getEndDate(new Date()));*/
        //System.out.println(getSevenDate(parse));
        //获取前月的第一天
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE, 0);//将秒至0
        c.set(Calendar.SECOND,0);//将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        System.out.println("===============first:"+c.getTime());
    }

    private static long getDueTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        System.out.println(cal.getTimeInMillis());
        return 0;
    }

    public static Map<String, Date> getWeekDate(Date date) {
        Map<String, Date> dateMap = new HashMap<>();
        Calendar          cal     = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (dayWeek == 1)
            dayWeek = 8;
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        Date mondayDate = cal.getTime();
        dateMap.put("mondayDate", mondayDate);

        cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        dateMap.put("sundayDate", sundayDate);
        return dateMap;
    }

    public static String getSevenDate(Date date) {
        Map<String, Date> dateMap = new HashMap<>();
        Calendar          cal     = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - 6);
        Date             pastDay = cal.getTime();
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
        String           result  = format.format(pastDay);
        return result;
    }

    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List lDate = new ArrayList();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    //返回当天第一秒
    public static Date getStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    //返回当天最后一秒
    public static Date getEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 59);
        return cal.getTime();
    }

    private String secondToTime(long second) {
        long days = second / 86400;//转换天数
        second = second % 86400;//剩余秒数
        long hours = second / 3600;//转换小时数
        second = second % 3600;//剩余秒数
        long minutes = second / 60;//转换分钟
        //second = second % 60;//剩余秒数
        if (0 < days) {
            //return days + "日" + hours + "小时"+ minutes + "分"+ second + "秒";
            return days + "日" + hours + "小时";
        } else {
            //return hours + "小时" + minutes + "分"+ second + "秒";
            return hours + "小时" + minutes + "分";
        }
    }
}
