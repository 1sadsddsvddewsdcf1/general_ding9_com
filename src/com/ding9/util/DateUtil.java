package com.ding9.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;





public class DateUtil
{
  public static String getDateStr(Date date)
  {
    if (date == null) {
      return "";
    }
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return format.format(date);
  }
  
  public static String getDateStrC(Date date) {
    if (date == null) {
      return "";
    }
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
    return format.format(date);
  }
  
  public static String getDateTimeStr(Date date) {
    if (date == null) {
      return "";
    }
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return format.format(date);
  }
  
  public static String date2pic(Date date) {
    if (date == null) {
      return "";
    }
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    return format.format(date);
  }
  
  public static String getDateTimeStrC(Date date) {
    if (date == null) {
      return "";
    }
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    return format.format(date);
  }
  
  public static Date parseDate(String s) throws ParseException {
    if ((s == "") || (s == null)) {
      return null;
    }
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    return format.parse(s);
  }
  
  public static Date parseDateC(String s) throws ParseException
  {
    if ((s == "") || (s == null)) {
      return null;
    }
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
    return format.parse(s);
  }
  
  public static Date parseDateTime(String s) throws ParseException {
    if ((s == "") || (s == null)) {
      return null;
    }
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return format.parse(s);
  }
  
  public static Date parseDateTimeC(String s) throws ParseException {
    if ((s == "") || (s == null)) {
      return null;
    }
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    return format.parse(s);
  }
  
  public static String format(Date date) throws ParseException {
    String datestr = "";
    if (getDateTimeStr(date).equals("")) {
      datestr = "";
    }
    else {
      datestr = getDateTimeStr(date).substring(0, 10);
    }
    
    return datestr;
  }
}
