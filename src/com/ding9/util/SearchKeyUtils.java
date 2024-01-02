package com.ding9.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;



public class SearchKeyUtils
{
  public static String encodeKey(float min_price, float max_price, String prma_name)
  {
    return new String(Hex.encodeHex(("{" + min_price + "},{" + max_price + "},{" + prma_name + "}").getBytes()));
  }
  


  public static String[] decodeKey(String key)
  {
    if (StringUtils.isBlank(key)) {
      return null;
    }
    
    String str = null;
    try {
      str = new String(Hex.decodeHex(key.toCharArray()));
    } catch (DecoderException e) {
      e.printStackTrace();
    }
    
    return StringUtils.substringsBetween(str, "{", "}");
  }
}
