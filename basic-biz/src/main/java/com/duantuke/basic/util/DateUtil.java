package com.duantuke.basic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    
    public final static  String  DateFormat = "yyyy-MM-dd";

	public static String dateToStr(Date date ,String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String d = null;
		try {
			d = format.format(date);
		} catch (Exception e) {
		}
		return d;
	}
	
	public static Date strToDate(String date ,String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
		}
		return d;
	}
	
	/**
	 * 获取n天 的时间
	 * @param n
	 * @return
	 * @throws ParseException
	 */
	public static Date getDay(int n) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.add(Calendar.DATE, -n);
		String dateString = String.valueOf(new java.sql.Date(c
				.getTimeInMillis()));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateString += " 00:00:00";
		return sf.parse(dateString);
	}
	/**
	 * 获取n分钟前的时间
	 * @param n
	 * @return
	 * @throws ParseException
	 */
	public static Date getMinute(int n) throws ParseException {
		Date date = new Date();
		long time = date.getTime();
		time = time - n*60*1000;
		
		return new Date(time);
	}
	/**
	 * 获取n微秒前的时间
	 * @param n
	 * @return
	 * @throws ParseException
	 */
	public static Date getSecond(int n) throws ParseException {
		Date date = new Date();
		long time = date.getTime();
		time = time - n;
		
		return new Date(time);
	}
	
	
	public static List<String> iterateTime(final Date startTime, final Date endTime){
		List<String> dateList = new ArrayList<String>();
    	Calendar start = Calendar.getInstance();
    	start.setTime(startTime);
    	
    	Calendar end = Calendar.getInstance();
    	end.setTime(endTime);

    	while (start.getTime().before(end.getTime())) {
    		dateList.add(DateUtil.dateToStr(start.getTime(), "yyyy-MM-dd"));
    		start.add(Calendar.DATE, 1);
		}
        return dateList;
    }
	
	
	public static boolean isSameDay(Date day1, Date day2) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String ds1 = sdf.format(day1);
	    String ds2 = sdf.format(day2);
	    if (ds1.equals(ds2)) {
	        return true;
	    } else {
	        return false;
	    }
	}

	
	/**
	 * 计算两个时间的时间差
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static int diffDay(Date day1, Date day2) {
	    long diff = day2.getTime() - day1.getTime();
	    Long days = diff / (1000 * 60 * 60 * 24);
	    return days.intValue();
	}
	
	/**
	 * 计算两个时间的时间差
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static int diffDay(String days1, String days2,String pattern) {
		

		Date day1 = DateUtil.strToDate(days1, pattern);
		Date day2 = DateUtil.strToDate(days2, pattern);
		
		long diff = day2.getTime() - day1.getTime();
		Long days = diff / (1000 * 60 * 60 * 24);
		return days.intValue();
	}

	/**
	 * 获取零点日期
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static Date getZeroTime(Date time) {
		return DateUtil.strToDate(DateUtil.dateToStr(time, "yyyy-MM-dd")+" 00:00:00","yyyy-MM-dd HH:mm:ss");
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println(getMinute(30));
	}

	public static String formatTime(Long ms) {  
	    Integer ss = 1000;  
	    Integer mi = ss * 60;  
	    Integer hh = mi * 60;  
	    Integer dd = hh * 24;  
	  
	    Long day = ms / dd;  
	    Long hour = (ms - day * dd) / hh;  
	    Long minute = (ms - day * dd - hour * hh) / mi;  
	    Long second = (ms - day * dd - hour * hh - minute * mi) / ss;  
	    Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;  
	      
	    StringBuffer sb = new StringBuffer();  
	    if(day > 0) {  
	        sb.append(day+"天");  
	    }  
	    if(hour > 0) {  
	        sb.append(hour+"小时");  
	    }  
	    if(minute > 0) {  
	        sb.append(minute+"分");  
	    }  
	    if(second > 0) {  
	        sb.append(second+"秒");  
	    }  
	    if(milliSecond > 0) {  
	        sb.append(milliSecond+"毫秒");  
	    }  
	    return sb.toString();  
	}  
	
	/**
	 * 字符串转换成时间 只包括时分秒
	 * @param date
	 * @return 
	 */
	public static Date getTime(String date){
		SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm:ss");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(date));
		} catch (ParseException e) {
		}
		return c.getTime();
	}
	
	 public static Date addDateOneDay(Date date,int inday) {  
        if (null == date) {  
            return date;  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);   //设置当前日期  
        c.add(Calendar.DATE, inday); //日期加1天  
        date = c.getTime();  
        return date;  
    }  
	 
	 
	public static Date getTime(int hour, int minute, int second, int day) {
		Calendar todayStart = Calendar.getInstance();
		todayStart.add(Calendar.DATE, day);
		todayStart.set(Calendar.HOUR_OF_DAY, hour);
		todayStart.set(Calendar.MINUTE, minute);
		todayStart.set(Calendar.SECOND, second);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}
	
	

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate
     *            较小的时间
     * @param bdate
     *            较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static List<Date> listDays(Date begintime, Date endtime) throws Exception {
        List<Date> list = new ArrayList<Date>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        begintime = sdf.parse(sdf.format(begintime));
        endtime = sdf.parse(sdf.format(endtime));
        Calendar cal = Calendar.getInstance();
        cal.setTime(begintime);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endtime);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        int daysnum = Integer.parseInt(String.valueOf(between_days));
        for (int i = 0; i < daysnum; i++) {
            list.add(DateUtil.addDateOneDay(begintime, i));
        }
        return list;
    }
	
	public static Date getNowDate(){
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}
	
	 /**
     * 计算两个日期之间相差的天数
     * @param smdate      较小的时间
     * @param bdate     较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date begintime, Date endtime) throws Exception {
    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          begintime = sdf.parse(sdf.format(begintime));
          endtime = sdf.parse(sdf.format(endtime));
          Calendar cal = Calendar.getInstance();
          cal.setTime(begintime);
          long time1 = cal.getTimeInMillis();
          cal.setTime(endtime);
          long time2 = cal.getTimeInMillis();
          long between_days = (time2 - time1) / (1000 * 3600 * 24);

          return Integer.parseInt(String.valueOf(between_days));
    }
		
    
    
    /**
	 *  星期日0 星期一 1 星期二 2 星期三 3 星期四 4 星期五 5 星期六 6
	 * @throws ParseException 
	 */
	public static int getWeekTime(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c.get(Calendar.DAY_OF_WEEK)-1;
	}
	
	
	 /**
     * 
     * @return 取得当前时间的date对象
     */
    public static Date createDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 为指定日期增加一段指定单位的时间
     * @param date 日期对象
     * @param calendarField 时间单位。
     * @param amount 数量
     * @return 增加指定单位之间之后的Date对象
     */
    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    /**
     * 为指定日期增加几分钟
     * @param date 指定日期
     * @param amount 增加的数量
     * @return 增加指定单位之间之后的Date对象
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 为指定日期增加几小时
     * @param date 指定日期
     * @param amount 增加的数量
     * @return 增加指定单位之间之后的Date对象
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }
    
    /**
     * 为指定日期增加几秒钟
     * @param date 指定日期
     * @param amount 增加的数量
     * @return 增加指定单位之间之后的Date对象
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    /**
     * 为指定日期增加几天
     * @param date 指定日期
     * @param amount 增加的数量
     * @return 增加指定单位之间之后的Date对象
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 为指定日期增加几星期
     * @param date 指定日期
     * @param amount 增加的数量
     * @return 增加指定单位之间之后的Date对象
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    /**
     * 为指定日期增加几个月
     * @param date 指定日期
     * @param amount 增加的数量
     * @return 增加指定单位之间之后的Date对象
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 为指定日期增加几年
     * @param date 指定日期
     * @param amount 增加的数量
     * @return 增加指定单位之间之后的Date对象
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

}
