package com.ding9.util;

import java.text.SimpleDateFormat;

public class Character
{
  public static String gb2iso(String qs)
  {
    try
    {
      if (qs == null) {
        return "NULL";
      }
      return new String(qs.getBytes("gb2312"), "iso-8859-1");
    }
    catch (Exception localException) {}
    

    return "NULL";
  }
  
  public static String iso2gb(String qs)
  {
    try {
      if (qs == null) {
        return "NULL";
      }
      return new String(qs.getBytes("iso-8859-1"), "gb2312");
    }
    catch (Exception localException) {}
    

    return "NULL";
  }
  
  public static String FieldDateToString(java.util.Date da, String format)
  {
    SimpleDateFormat form = new SimpleDateFormat(format);
    return form.format(da);
  }
}
