package com.cyx.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 日期工具类。<br>
 *
 * @author niyongsheng
 * @version 1.0
 */
public class DateUtil {
	/**
	 * 格式化为：yyyy-MM-dd
	 */
	public final static String PATTERN_YYMMDD =  "yyyy-MM-dd";
	/**
	 * 格式化为：yyyy-MM
	 */
	public final static String PATTERN_YYMM = "yyyy-MM";
    /**
     * 格式化为：yyyyMMdd
     */
    public final static String PATTERN_YYMMDD_1 = "yyyyMMdd";

    /**
     * 按照指定的格式返回日期字符串. 默认 "yyyy-MM-dd"
     *
     * @param date
     * @param pattern
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) return "";
        if (pattern == null) pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return (sdf.format(date));
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String formatDateTime(Date date) {
        return (formatDate(date, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 当前时间 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDateTime() {
        return (formatDate(now(), "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 当前时间 yyyyMMddHHmmss
     * @return
     */
    public static String formatDateTime2() {
        return (formatDate(now(), "yyyyMMddHHmmss"));
    }

    /**
     * yyyy-MM-dd
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return (formatDate(date, "yyyy-MM-dd"));
    }

    /**
     * 当前日期 yyyy-MM-dd
     * @return
     */
    public static String formatDate() {
        return (formatDate(now(), "yyyy-MM-dd"));
    }

    /**
     * 当前日期 yyyyMMdd
     * @return
     */
    public static String formatDate2() {
        return (formatDate(now(), "yyyyMMdd"));
    }

    /**
     * HH:mm:ss
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        return (formatDate(date, "HH:mm:ss"));
    }

    /**
     * 当前时间 HH:mm:ss
     * @return
     */
    public static String formatTime() {
        return (formatDate(now(), "HH:mm:ss"));
    }

    /**
     * 当前时间 HHmmss
     * @return
     */
    public static String formatTime2() {
        return (formatDate(now(), "HHmmss"));
    }

    /**
     * 当前时间 Date类型
     * @return
     */
    public static Date now() {
        return (new Date());
    }
    /**
     * 当前时间 Timestamp 类型
     * @return
     */
    public static Timestamp nowTimestamp(){
    	return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * yyyy-MM-dd HH:mm:ss 转Date
     * @param datetime
     * @return
     */
    public static Date parseDateTime(String datetime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ((datetime == null) || (datetime.equals(""))) {
            return null;
        } else {
            try {
                return formatter.parse(datetime);
            } catch (ParseException e) {
                return parseDate(datetime);
            }
        }
    }

    /**
     * yyyy-MM-dd 转Date
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        if ((date == null) || (date.equals(""))) {
            return null;
        } else {
            try {
                return formatter.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
    }

    public static Date parseDate(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        if ((date == null) || (date.equals(""))) {
            return null;
        } else {
            try {
                return formatter.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
    }

    public static Date parseDate(Date datetime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        if (datetime == null) {
            return null;
        } else {
            try {
                return formatter.parse(formatter.format(datetime));
            } catch (ParseException e) {
                return null;
            }
        }
    }

    public static String formatDate(Object o) {
        if (o == null) return "";
        if (o.getClass() == String.class)
            return formatDate((String) o);
        else if (o.getClass() == Date.class)
            return formatDate((Date) o);
        else if (o.getClass() == Timestamp.class) {
            return formatDate(new Date(((Timestamp) o).getTime()));
        } else
            return o.toString();
    }

    public static String formatDateTime(Object o) {
        if (o.getClass() == String.class)
            return formatDateTime((String) o);
        else if (o.getClass() == Date.class)
            return formatDateTime((Date) o);
        else if (o.getClass() == Timestamp.class) {
            return formatDateTime(new Date(((Timestamp) o).getTime()));
        } else
            return o.toString();
    }
    
    
    /**
     * 依据当前时间创建一个要求的时间
     * 
     * @param field  时间域，有Calendar.MILLISECOND,Calendar.SECOND,Calendar.MINUTE,<br>
     *               Calendar.HOUR,Calendar.DATE, Calendar.MONTH,Calendar.YEAR
     * @param amount	按指定时间域加减的时间数量，正数为加，负数为减。
     * @param formatType	日期的格式化类型（用于确定精度）
     * @return	
     */
    public static Timestamp createTime(int field, int amount , String formatType){
    	SimpleDateFormat formatter = new SimpleDateFormat(formatType);
    	try {
			Date date  = formatter.parse(formatter.format(new Date()));
			date = add(date,field, amount);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			return null;
		}
    }
    
    /**
     * 依据当前时间创建一个要求的时间
     * 
     * @param field  时间域，有Calendar.MILLISECOND,Calendar.SECOND,Calendar.MINUTE,<br>
     *               Calendar.HOUR,Calendar.DATE, Calendar.MONTH,Calendar.YEAR
     * @param amount	按指定时间域加减的时间数量，正数为加，负数为减。
     * @param formatType	日期的格式化类型（用于确定精度）
     * @return	
     */
    public static Timestamp formatTime(Timestamp time , String formatType){
    	SimpleDateFormat formatter = new SimpleDateFormat(formatType);
    	try {
			Date date  = formatter.parse(formatter.format(new Date(time.getTime())));
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			return null;
		}
    }
    
    /**
     * 给时间加上或减去指定毫秒，秒，分，时，天、月或年等，返回变动后的时间
     *
     * @param date   要加减前的时间，如果不传，则为当前日期
     * @param field  时间域，有Calendar.MILLISECOND,Calendar.SECOND,Calendar.MINUTE,<br>
     *               Calendar.HOUR,Calendar.DATE, Calendar.MONTH,Calendar.YEAR
     * @param amount 按指定时间域加减的时间数量，正数为加，负数为减。
     * @return 变动后的时间
     */
    public static Date add(Date date, int field, int amount) {
        if (date == null) {
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, amount);

        return cal.getTime();
    }

    /**
     * 将timestamp类型日期转成string,去掉时分秒
     * @param ts
     * @return
     */
    public static String getStringTime(Timestamp ts){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = ts;
           return df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 将timestamp类型日期转成date
     * @param ts
     * @return
     */
    public static Date getDateTime(Timestamp ts){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = ts;
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String getStringDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }


    public static Date addMilliSecond(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    public static Date addSecond(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    public static Date addMiunte(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    public static Date addHour(Date date, int amount) {
        return add(date, Calendar.HOUR, amount);
    }

    public static Date addDay(Date date, int amount) {
        return add(date, Calendar.DATE, amount);
    }

    public static Date addMonth(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    public static Date addYear(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    public static Date getDate() {
        return parseDate(formatDate());
    }

    public static Date getDateTime() {
        return parseDateTime(formatDateTime());
    }

    public static boolean between(Date date, long offset, TimeUnit unit) {
		return System.currentTimeMillis() - date.getTime() <= unit.toMillis(offset);
	}
    /**
     * 转成yyyy-mm-dd hh:MM:ss
     * @param date 日期
     * @return
     */
    public static String coverToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = date!=null?format.format(date):"";
        return dateString;
    };
}