package com.ding9.click.util.validate;

import com.ding9.click.util.security.MD5;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class ValidateCode
{
  private static Log log = LogFactory.getLog(ValidateCode.class);
  





  public static boolean setValidateCode(HttpServletRequest request, String validatecode)
  {
    boolean result = false;
    try
    {
      HttpSession session = request.getSession(false);
      if (session != null) {
        session.removeAttribute("validatecode");
      }
      else {
        session = request.getSession(true);
      }
      session.setAttribute("validatecode", MD5.encode(validatecode));
      
      result = true;
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error(ex.toString());
      }
      result = false;
    }
    
    return result;
  }
  





  public static boolean verifyValidateCode(HttpServletRequest request, String validatecode)
  {
    boolean result = false;
    try
    {
      HttpSession session = request.getSession(false);
      if (session == null) {
        session = request.getSession(true);
      }
      String servercode = (String)session.getAttribute("validatecode");
      servercode = servercode == null ? "" : servercode.trim();
      
      result = servercode.equals(MD5.encode(validatecode).trim());
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error(ex.toString());
      }
      result = false;
    }
    
    return result;
  }
}
