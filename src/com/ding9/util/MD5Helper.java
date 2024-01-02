package com.ding9.util;

import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;










public class MD5Helper
{
  private static final Log logger = LogFactory.getLog(MD5Helper.class);
  



  public static String encode(String in)
  {
    return encode(in, "");
  }
  




  public static String encode(String in, String charset)
  {
    if (in == null) return null;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      if (StringHelper.isEmpty(charset)) {
        md.update(in.getBytes());
      } else {
        try {
          md.update(in.getBytes(charset));
        } catch (Exception e) {
          md.update(in.getBytes());
        }
      }
      byte[] digesta = md.digest();
      return StringHelper.bytes2Hex(digesta);
    }
    catch (NoSuchAlgorithmException ex) {
      logger.error("encode(" + in + "," + charset + "):NoSuchAlgorithmException -->" + ex.getMessage()); }
    return null;
  }
  











  public static byte[] md5(byte[] bytes)
  {
    try
    {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.update(bytes);
      return digest.digest();
    }
    catch (NoSuchAlgorithmException ex) {
      logger.error("encode(byte[]):NoSuchAlgorithmException -->" + ex.getMessage()); }
    return null;
  }
  
  public static void main(String[] args) {
    System.out.println(encode("111111"));
  }
}
