package com.ding9.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;







public class UrlRewriteManager
{
  private static final Log log = LogFactory.getLog(UrlRewriteManager.class);
  private static HashMap urlinfo = null;
  
  private static String staticPostFix = ".htm";
  private static String dynamicPostFix = ".do";
  private static boolean isRewrite = Environment.getRewriteSwitch();
  private static String separator = "----,";
  private static String base64separator = "--";
  





  public static String getStaticPath(String filepath, HashMap hm)
  {
    if (urlinfo == null) {
      setUrlInfo();
    }
    
    filepath = filepath == null ? "" : filepath.trim();
    
    if (isRewrite) {
      return getStaticPathPri(filepath, hm);
    }
    return getDynamicPathPri(filepath, hm);
  }
  





  public static String static2dynamic(String filepath)
  {
    if (urlinfo == null) {
      setUrlInfo();
    }
    
    if (!isRewrite) {
      return filepath;
    }
    
    StringBuffer result = new StringBuffer();
    filepath = filepath == null ? "" : filepath.trim();
    String fileprefix = null;
    String key = null;
    String value = null;
    





    if ((filepath.indexOf(staticPostFix) + 4 != filepath.length()) || (filepath.length() < 5)) {
      result.append(filepath);
    } else if (filepath.indexOf(separator) > -1) {
      filepath = filepath.substring(0, filepath.indexOf(staticPostFix));
      String[] pramary = filepath.split(separator);
      if ((pramary != null) && 
        (pramary.length > 0)) {
        fileprefix = pramary[0];
        result.append(fileprefix);
        result.append(dynamicPostFix);
        

        List praminfo = (ArrayList)urlinfo.get(fileprefix);
        
        if (praminfo != null) {
          for (int i = 0; i < praminfo.size(); i++) {
            if (i == 0) {
              result.append("?");
            } else {
              result.append("&");
            }
            key = (String)praminfo.get(i);
            try
            {
              value = pramary[(i + 1)];
            }
            catch (Exception ex) {
              value = "";
            }
            result.append(key);
            result.append("=");
            result.append(value);
          }
          
        }
      }
    }
    else
    {
      filepath = filepath.substring(0, filepath.indexOf(staticPostFix));
      
      String[] base64pramary = filepath.split(base64separator);
      
      if (base64pramary.length != 2) {
        return filepath + dynamicPostFix;
      }
      
      filepath = base64pramary[0] + unEncrypt(base64pramary[1]);
      
      String[] pramary = filepath.split(separator);
      if ((pramary != null) && 
        (pramary.length > 0)) {
        fileprefix = pramary[0];
        result.append(fileprefix);
        result.append(dynamicPostFix);
        

        List praminfo = (ArrayList)urlinfo.get(fileprefix);
        
        if (praminfo != null) {
          for (int i = 0; i < praminfo.size(); i++) {
            if (i == 0) {
              result.append("?");
            } else {
              result.append("&");
            }
            key = (String)praminfo.get(i);
            try
            {
              value = pramary[(i + 1)];
            }
            catch (Exception ex) {
              value = "";
            }
            result.append(key);
            result.append("=");
            result.append(value);
          }
        }
      }
    }
    

    return result.toString();
  }
  




  public static String dynamic2static(String filepath)
  {
    if (urlinfo == null) {
      setUrlInfo();
    }
    
    if (!isRewrite) {
      return filepath;
    }
    
    StringBuffer result = new StringBuffer();
    filepath = filepath == null ? "" : filepath.trim();
    String fileprefix = null;
    String key = null;
    String value = null;
    
    if (log.isInfoEnabled()) log.info("filepath: " + filepath);
    if (filepath.indexOf("?") < 0) {
      filepath = filepath.replaceAll(dynamicPostFix, staticPostFix);
      result.append(filepath);
    }
    else if (filepath.indexOf(dynamicPostFix) < 0) {
      result.append(filepath);
    }
    else {
      fileprefix = filepath.substring(0, filepath.indexOf(dynamicPostFix));
      result.append(fileprefix);
      

      filepath = filepath.substring(filepath.indexOf(dynamicPostFix) + 4, filepath.length());
      String[] pramary = filepath.split("&");
      

      List praminfo = (ArrayList)urlinfo.get(fileprefix);
      
      if (praminfo != null) {
        StringBuffer paresult = new StringBuffer();
        for (int i = 0; i < praminfo.size(); i++) {
          paresult.append(separator);
          key = (String)praminfo.get(i);
          if (pramary != null) {
            for (int j = 0; j < pramary.length; j++) {
              if (pramary[j].indexOf(key + "=") > -1) {
                value = pramary[j].substring(pramary[j].indexOf("=") + 1, pramary[j].length());
                paresult.append(value);
              }
            }
          }
        }
        result.append(base64separator);
        result.append(encrypt(paresult.toString()));
      }
      result.append(staticPostFix);
    }
    
    return result.toString();
  }
  





  private static String getStaticPathPri(String filepath, HashMap hm)
  {
    StringBuffer result = new StringBuffer();
    String key = null;
    String value = null;
    
    if (urlinfo == null) {
      setUrlInfo();
    }
    
    List praminfo = (ArrayList)urlinfo.get(filepath);
    
    result.append(filepath);
    if ((praminfo != null) && (hm != null)) {
      for (int i = 0; i < praminfo.size(); i++) {
        key = (String)praminfo.get(i);
        value = (String)hm.get(key);
        result.append(separator);
        result.append(value);
      }
    }
    result.append(staticPostFix);
    
    return result.toString();
  }
  





  private static String getDynamicPathPri(String filepath, HashMap hm)
  {
    StringBuffer result = new StringBuffer();
    String key = null;
    String value = null;
    
    if (urlinfo == null) {
      setUrlInfo();
    }
    
    List praminfo = (ArrayList)urlinfo.get(filepath);
    
    result.append(filepath);
    result.append(dynamicPostFix);
    if ((praminfo != null) && (hm != null)) {
      for (int i = 0; i < praminfo.size(); i++) {
        if (i == 0) {
          result.append("?");
        } else {
          result.append("&");
        }
        key = (String)praminfo.get(i);
        value = (String)hm.get(key);
        result.append(key);
        result.append("=");
        result.append(value);
      }
    }
    
    return result.toString();
  }
  



  private static void setUrlInfo()
  {
    if (urlinfo == null) {
      urlinfo = ProjectEnvironment.getUrlInfos();
    }
  }
  




  public static String encrypt(String str)
  {
    if ((str == null) || (str.equals(""))) {
      return "";
    }
    BASE64Encoder encoder = new BASE64Encoder();
    return encoder.encode(str.getBytes());
  }
  




  public static String unEncrypt(String str)
  {
    if ((str == null) || (str.equals(""))) {
      return "";
    }
    BASE64Decoder decoder = new BASE64Decoder();
    byte[] b = new byte[0];
    try
    {
      b = decoder.decodeBuffer(str);
    }
    catch (IOException localIOException) {}
    
    return new String(b);
  }
  















  public static void main(String[] arg)
  {
    String url = "/news/info-list.do?memt_id=1234&page_size=5678&current_page=90";
    

    String enstr = null;
    
    enstr = dynamic2static(url);
    
    System.out.println("enstr : " + enstr);
    
    String uenstr = null;
    
    uenstr = static2dynamic(enstr);
    
    System.out.println("uenstr : " + uenstr);
  }
}
