package com.ding9.search.util;

import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;








public class DateHelper
{
  private static final Log logger = LogFactory.getLog(DateHelper.class);
  

  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
  
  public static final int YEAR = 1;
  
  public static final int MONTH = 2;
  
  public static final int DAY = 3;
  
  public static final int HOUR = 4;
  
  public static final int MINUTE = 5;
  
  public static final int SECOND = 6;
  

  public static boolean isDateFormat(String in, String format)
  {
    if (in == null) return false;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      Date date = new Date(formatter.parse(in).getTime());
      
      if (!toString(date, format).equals(in)) return false;
      return true;
    } catch (ParseException pe) {
      logger.warn("isDateFormat(" + in + "," + format + "):ParseException-->" + pe.getMessage()); }
    return false;
  }
  




  public static boolean isDateFormat(String in)
  {
    return isDateFormat(in, "yyyy-MM-dd");
  }
  




  public static Date toDate(String in, String format)
  {
    if (!isDateFormat(in, format)) return null;
    if (in == null) return null;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      return formatter.parse(in);
    } catch (ParseException pe) {
      logger.warn("toDate(" + in + "," + format + "):ParseException-->" + pe.getMessage()); }
    return null;
  }
  




  public static Date fromTimestamp(Timestamp in)
  {
    if (in == null) return null;
    return new Date(in.getTime());
  }
  




  public static String toString(Date in, String format)
  {
    if (in == null) return null;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      return formatter.format(in);
    } catch (Exception e) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      return formatter.format(in);
    }
  }
  




  public static int getDayCounts(int year, int month)
  {
    switch (month) {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 12: 
      return 31;
    case 2: 
      if (isLeapYear(year)) {
        return 29;
      }
      return 28;
    
    case 4: 
    case 6: 
    case 9: 
    case 11: 
      return 30;
    }
    return 0;
  }
  






  public static boolean isSunday(int year, int month, int day)
  {
    return getDayofWeek(year, month, day) == 1;
  }
  





  public static boolean isSaturday(int year, int month, int day)
  {
    return getDayofWeek(year, month, day) == 7;
  }
  







  public static boolean isWeekend(int year, int month, int day) { return (isSaturday(year, month, day)) || (isSunday(year, month, day)); }
  
  private static int getDayofWeek(int year, int month, int day) {
    Calendar c = Calendar.getInstance();
    c.set(year, month - 1, day);
    return c.get(7);
  }
  



  public static boolean isLeapYear(int year)
  {
    if (year <= 0) return false;
    if (year % 4 != 0) return false;
    if ((year % 100 == 0) && (year % 400 != 0)) return false;
    return true;
  }
  


  public static int getNowYear()
  {
    Date date = new Date(getSystemTime());
    return get(date, 1);
  }
  


  public static int getNowMonth()
  {
    Date date = new Date(getSystemTime());
    return get(date, 2);
  }
  


  public static int getNowDay()
  {
    Date date = new Date(getSystemTime());
    return get(date, 3);
  }
  


  public static int getNowHour()
  {
    Date date = new Date(getSystemTime());
    return get(date, 4);
  }
  


  public static int getNowMinute()
  {
    Date date = new Date(getSystemTime());
    return get(date, 5);
  }
  


  public static int getNowSecond()
  {
    Date date = new Date(getSystemTime());
    return get(date, 6);
  }
  






  public static Date add(Date date, int field, int amount)
  {
    if (date == null) return null;
    Calendar c = Calendar.getInstance();
    c.setTimeInMillis(date.getTime());
    switch (field) {
    case 1: 
      c.add(1, amount);
      break;
    case 2: 
      c.add(2, amount);
      break;
    case 3: 
      c.add(5, amount);
      break;
    case 4: 
      c.add(10, amount);
      break;
    case 5: 
      c.add(12, amount);
      break;
    case 6: 
      c.add(13, amount);
      break;
    default: 
      return null;
    }
    return new Date(c.getTimeInMillis());
  }
  




  public static int get(Date date, int field)
  {
    if (date == null) return 0;
    Calendar c = Calendar.getInstance();
    c.setTimeInMillis(date.getTime());
    switch (field) {
    case 1: 
      return c.get(1);
    case 2: 
      return c.get(2) + 1;
    case 3: 
      return c.get(5);
    case 4: 
      return c.get(11);
    case 5: 
      return c.get(12);
    case 6: 
      return c.get(13);
    }
    return 0;
  }
  
  public static Timestamp toTimestamp(Date in) {
    if (in == null) return null;
    return new Timestamp(in.getTime());
  }
  
  public static Date toDate(Timestamp in) { if (in == null) return null;
    return new Date(in.getTime());
  }
  








  public static long getTime(int year, int month, int day, int hour, int min, int second)
  {
    Calendar c = Calendar.getInstance();
    c.set(year, month, day, hour, min, second);
    return c.getTimeInMillis();
  }
  


  public static long getSystemTime()
  {
    return System.currentTimeMillis();
  }
  



  public static String getSystemTime(String format)
  {
    return toString(new Date(getSystemTime()), format);
  }
  


  public static Date getToday()
  {
    return toDate(getSystemTime("yyyy-MM-dd"), "yyyy-MM-dd");
  }
  



  public static boolean isBeforeToday(String date)
  {
    Date d = toDate(date, "yyyy-MM-dd");
    if (d == null) return false;
    return d.before(getToday());
  }
  



  public static boolean isAfterToday(String date)
  {
    Date d = toDate(date, "yyyy-MM-dd");
    if (d == null) return false;
    return d.after(getToday());
  }
  



  public static boolean isToday(String date)
  {
    Date d = toDate(date, "yyyy-MM-dd");
    if (d == null) return false;
    return d.getTime() == getToday().getTime();
  }
  


  public static void main(String[] args)
  {
    System.out.println(toDate("2006-7-22", "yyyy-M-d"));
    System.out.println(getSystemTime("yyMMdd HH时mm分ss秒"));
  }
}
