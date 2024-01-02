package com.ding9.click.util;






















public class CutString
{
  public static String splitString(String str, int len)
  {
    return splitString(str, len, "...");
  }
  


















  public static String splitString(String str, int len, String elide)
  {
    if (str == null)
    {
      return "";
    }
    

    byte[] strByte = str.getBytes();
    
    int strLen = strByte.length;
    
    int elideLen = elide.trim().length() == 0 ? 0 : elide.getBytes().length;
    
    if ((len >= strLen) || (len < 1))
    {
      return str;
    }
    

    if (len - elideLen > 0)
    {
      len -= elideLen;
    }
    

    int count = 0;
    
    for (int i = 0; i < len; i++)
    {
      int value = strByte[i];
      
      if (value < 0)
      {
        count++;
      }
    }
    


    if (count % 2 != 0)
    {
      len = len == 1 ? len + 1 : len - 1;
    }
    

    return new String(strByte, 0, len) + elide.trim();
  }
}
