package com.ding9.search.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;










public class StringHelper
{
  private static final Log logger = LogFactory.getLog(StringHelper.class);
  
  public static final String ALL_LOWER_LETTER = "abcdefghijklmnopqrstuvwxyz";
  public static final String ALL_UPPER_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String ALL_NUMERIC_LETTER = "0123456789";
  
  public static int parseInt(String in, int defaultValue)
  {
    if (in == null) return defaultValue;
    try {
      return Integer.parseInt(in);
    } catch (NumberFormatException nfe) {
      logger.warn("parseInt(" + in + "):NumberFormatException-->" + nfe.getMessage()); }
    return defaultValue;
  }
  




  public static boolean isEmail(String in)
  {
    if (isEmpty(in)) return false;
    int at = in.indexOf("@");
    int dot = in.indexOf(".");
    if ((at < 0) || (dot < 0)) return false;
    if (at + 1 >= dot) return false;
    if (dot + 1 >= in.length()) return false;
    return true;
  }
  




  public static double parseDouble(String in, double defaultValue)
  {
    if (in == null) return defaultValue;
    try {
      return Double.parseDouble(in);
    } catch (NumberFormatException nfe) {
      logger.warn("parseDouble(" + in + "):NumberFormatException-->" + nfe.getMessage()); }
    return defaultValue;
  }
  








  public static String truncate(String in, int length)
  {
    return truncate(in, length, "");
  }
  








  public static String truncate(String in, int length, String ender)
  {
    if ((length < 0) || (in == null) || (in.getBytes().length <= length)) return in;
    int index = getMaxTruncateLength(in, length);
    return in.substring(0, index) + ender;
  }
  




  public static int getMaxTruncateLength(String in, int length)
  {
    if ((in == null) || (in.trim().length() <= 0)) return 0;
    int len = in.getBytes().length;
    if (len <= length) return in.length();
    byte[] bytes = in.getBytes();
    int count = 0;
    for (int i = 0; i < length; i++) {
      if (bytes[i] < 0) {
        count++;
      }
    }
    if (count % 2 == 0) {
      return length - count / 2;
    }
    return length - 1 - count / 2;
  }
  







  public static String replace(String mother, int index, String child)
  {
    if ((index < 0) || (index >= mother.length())) return mother;
    StringBuffer out = new StringBuffer();
    
    if (index > 0) {
      out.append(mother.substring(0, index));
    }
    
    if (index + child.length() > mother.length()) {
      out.append(child.substring(0, mother.length() - index));
    } else {
      out.append(child);
      
      out.append(mother.substring(index + child.length()));
    }
    return out.toString();
  }
  



  public static boolean isEmpty(String in)
  {
    if ((in == null) || (in.trim().length() <= 0)) return true;
    return false;
  }
  



  public static String toString(Object[] in)
  {
    StringBuffer desc = new StringBuffer();
    desc.append("[");
    if (in != null) {
      for (int i = 0; i < in.length; i++) {
        desc.append(in[i]).append(";");
      }
    }
    desc.append("]");
    return desc.toString();
  }
  






  public static void main(String[] args) {}
  





  public static String getBytes(String in, String charset)
  {
    if (in == null) return null;
    try {
      return new String(in.getBytes(charset));
    } catch (UnsupportedEncodingException uee) {
      logger.warn("getBytes(" + in + "," + charset + "):UnsupportedEncodingException-->" + uee.getMessage()); }
    return in;
  }
  





  public static boolean isExceed(String in, int length)
  {
    if ((in == null) || (length <= 0)) return false;
    if (in.getBytes().length <= length) return false;
    return true;
  }
  









  public static String add(String mother, String splitter, String child)
  {
    return add(mother, splitter, child, false);
  }
  






  public static String add(String mother, String splitter, String child, boolean duplicate)
  {
    if (mother == null) return child;
    StringBuffer ret = new StringBuffer();
    ret.append(mother);
    
    if (duplicate) {
      ret.append(splitter).append(child);
    }
    else if (mother.indexOf(child) < 0) {
      ret.append(splitter).append(child);
    }
    
    return ret.toString();
  }
  








  public static String remove(String mother, String splitter, String child)
  {
    if ((isEmpty(child)) || (isEmpty(mother))) return mother;
    StringBuffer ret = new StringBuffer();
    int index = mother.indexOf(child);
    if (index < 0) return mother;
    if (index == 0) {
      if (index + child.length() + splitter.length() < mother.length()) {
        ret.append(mother.substring(index + child.length() + splitter.length()));
      } else {
        return null;
      }
    } else {
      ret.append(mother.substring(0, index - splitter.length()));
      if (index + child.length() + splitter.length() < mother.length()) {
        ret.append(mother.substring(index + child.length()));
      }
    }
    return ret.toString();
  }
  




  public static long parseLong(String in, long defaultValue)
  {
    if (in == null) return defaultValue;
    try {
      return Long.parseLong(in);
    } catch (NumberFormatException nfe) {
      logger.error("parseLong(" + in + "):NumberFormatException-->" + nfe.getMessage()); }
    return defaultValue;
  }
  




  public static String bytes2Hex(byte[] b)
  {
    String hs = "";
    String stmp = "";
    for (int n = 0; n < b.length; n++) {
      stmp = Integer.toHexString(b[n] & 0xFF);
      if (stmp.length() == 1) { hs = hs + "0" + stmp;
      } else
        hs = hs + stmp;
    }
    return hs;
  }
  



  public static byte[] hex2Bytes(String in)
  {
    byte[] buf = new byte[in.length() / 2];
    char[] chars = in.toCharArray();
    int i = 0; for (int j = 0; i < buf.length; i++) {
      char c1 = chars[(j++)];
      char c2 = chars[(j++)];
      buf[i] = getByte(getValue(c1), getValue(c2));
    }
    return buf;
  }
  



  public static byte getValue(char c)
  {
    if ((c >= '0') && (c <= '9')) return (byte)(c - '0');
    if ((c >= 'a') && (c <= 'f')) return (byte)(c - 'a' + 10);
    if ((c >= 'A') && (c <= 'F')) return (byte)(c - 'A' + 10);
    return 0;
  }
  
  private static byte getByte(byte b1, byte b2) {
    return (byte)(b1 << 4 | b2);
  }
  




  public static boolean isIllegal(String in, String illegal)
  {
    if ((illegal == null) || (illegal.length() <= 0)) return false;
    if ((in == null) || (in.length() <= 0)) return false;
    for (int i = 0; i < illegal.length(); i++) {
      char c = illegal.charAt(i);
      if (in.indexOf(c) >= 0) return true;
    }
    return false;
  }
  




  public static boolean isLegal(String in, String legal)
  {
    if ((legal == null) || (legal.length() <= 0)) return false;
    if ((in == null) || (in.length() <= 0)) return true;
    for (int i = 0; i < in.length(); i++) {
      char c = in.charAt(i);
      if (legal.indexOf(c) < 0) return false;
    }
    return true;
  }
  







  public static boolean isMobile(String in)
  {
    if ((in == null) || (in.length() < 0)) return false;
    if (in.length() != 11) return false;
    if (!isLegal(in, "0123456789")) return false;
    if ((in.startsWith("13")) || (in.startsWith("15"))) return true;
    return false;
  }
  



  public static boolean isNumberic(String in)
  {
    if ((in == null) || (in.length() < 0)) return false;
    return isLegal(in, "0123456789");
  }
  




  public static String toBunch(int[] in, String splitter)
  {
    if (in == null) return null;
    String[] ins = new String[in.length];
    for (int i = 0; i < in.length; i++) {
      ins[i] = String.valueOf(in[i]);
    }
    return toBunch(ins, splitter, 0);
  }
  




  public static String toBunch(String[] in, String splitter)
  {
    return toBunch(in, splitter, 0);
  }
  





  public static String toBunch(String[] in, String splitter, int start)
  {
    if ((in == null) || (in.length < 0) || (start >= in.length)) return null;
    StringBuffer bunch = new StringBuffer();
    for (int i = 0; i < in.length; i++) {
      if (i >= start)
        bunch.append(in[i]).append(splitter);
    }
    return bunch.toString().substring(0, bunch.toString().length() - splitter.length());
  }
  




  public static String toBunch(List in, String splitter)
  {
    if ((in == null) || (in.size() <= 0)) return null;
    StringBuffer bunch = new StringBuffer();
    for (Iterator it = in.iterator(); it.hasNext();) {
      bunch.append((String)it.next()).append(splitter);
    }
    return bunch.toString().substring(0, bunch.toString().length() - splitter.length());
  }
  



  public static String lowerFirstChar(String in)
  {
    if (in == null) return null;
    return in.substring(0, 1).toLowerCase() + in.substring(1);
  }
  



  public static String upperFirstChar(String in)
  {
    if ((in == null) || (in.length() <= 0)) return in;
    return in.substring(0, 1).toUpperCase() + in.substring(1);
  }
  





  public static String toString(double in, String format)
  {
    DecimalFormat formatter = new DecimalFormat(format);
    return formatter.format(in);
  }
  




  public static String formatNullValue(String in, String defaultNullValue)
  {
    return in == null ? defaultNullValue : in;
  }
  




  public static String toString(int in, String format)
  {
    DecimalFormat formatter = new DecimalFormat(format);
    
    return formatter.format(in);
  }
  





  public static String repeat(String in, int count)
  {
    if ((in == null) || (count < 1)) return "";
    StringBuffer out = new StringBuffer();
    for (int i = 0; i < count; i++) {
      out.append(in);
    }
    return out.toString();
  }
  







  public static String getIndexString(String in, int index, String splitter, String defaultValue)
  {
    if ((in == null) || (splitter == null)) return defaultValue;
    String[] infos = in.split(splitter);
    if (infos.length <= index) return defaultValue;
    if (infos[index] == null) return defaultValue;
    return infos[index];
  }
  




  public static String outputStrToHtml(String sourceStr)
  {
    String result = null;
    
    sourceStr = sourceStr == null ? "" : sourceStr.trim();
    try
    {
      result = sourceStr.replaceAll("\n", "<br>");
      result = result.replaceAll("\r", "");
      result = result.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");

    }
    catch (Exception ex)
    {
      result = null;
    }
    result = result == null ? "" : result.trim();
    
    return result;
  }
  






  public static String getSubString(String str, int len)
  {
    StringBuffer result = new StringBuffer();
    int counter = 0;
    
    str = str == null ? "" : str.trim();
    
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) < 'Ā') {
        counter++;
      } else {
        counter += 2;
      }
      if (counter <= len)
        result.append(String.valueOf(str.charAt(i)));
      if (counter > len) break;
    }
    return result.toString();
  }
  





  public static int getStringLen(String str)
  {
    int counter = 0;
    
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) < 'Ā') {
        counter++;
      }
      else {
        counter += 2;
      }
    }
    
    return counter;
  }
  




  public static String getRealString(String str)
  {
    str = str == null ? "" : str.trim();
    str = "null".equals(str.toLowerCase()) ? "" : str.trim();
    
    return str;
  }
  
  public static String floatToString(float data)
  {
    String result = "";
    
    int size = 10;
    
    if (data < 0.0F) {
      return result;
    }
    
    result = String.valueOf(data);
    
    if (result.indexOf(".") < 0) {
      for (int i = result.length(); i < size; i++) {
        result = "0" + result;
      }
    } else {
      for (int j = result.substring(0, result.indexOf(".")).length(); j < size; j++) {
        result = "0" + result;
      }
    }
    
    return result;
  }
  
  public static float stringToFloat(String data) {
    float result = 0.0F;
    try
    {
      result = Float.parseFloat(data);
    }
    catch (Exception localException) {}
    return result;
  }
}
