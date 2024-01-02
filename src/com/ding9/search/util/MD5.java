package com.ding9.search.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


















public class MD5
{
  public static byte[] make(String source)
  {
    if (source == null)
      return null;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(source.getBytes());
      return md.digest();
    }
    catch (NoSuchAlgorithmException nsae) {
      nsae.printStackTrace(); }
    return null;
  }
  





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
    } catch (NoSuchAlgorithmException ex) {
      ex.printStackTrace(); }
    return null;
  }
  
  public static byte[] md5(byte[] bytes) {
    try {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.update(bytes);
      return digest.digest();
    }
    catch (NoSuchAlgorithmException ex) {
      ex.printStackTrace(); }
    return null;
  }
}
