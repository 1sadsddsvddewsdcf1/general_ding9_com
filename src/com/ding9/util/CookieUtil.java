package com.ding9.util;

import com.ding9.sso.SSOUser;
import com.oreilly.servlet.Base64Encoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;










public class CookieUtil
{
  private static final Logger logger = Logger.getLogger(CookieUtil.class);
  






  public static Cookie findCookie(HttpServletRequest request, String name)
  {
    Cookie[] cookies = request.getCookies();
    
    if (cookies == null) {
      return null;
    }
    
    for (int i = 0; i < cookies.length; i++) {
      if (name.equals(cookies[i].getName())) {
        if (logger.isInfoEnabled()) {
          logger.info("Cookie Name : " + cookies[i].getName());
          logger.info("Cookie Value : " + cookies[i].getValue());
          logger.info("Cookie Domain : " + cookies[i].getDomain());
        }
        return cookies[i];
      }
    }
    
    return null;
  }
  










  public static String createAndSaveCookie(HttpServletResponse response, String name, SSOUser user, int maxAge)
  {
    String usernameWithBASE64 = Base64Encoder.encode(user.getUsername());
    String passwordWithBASE64 = Base64Encoder.encode(user.getPassword());
    String cookieValue = user.getUserId() + ":" + usernameWithBASE64 + ":" + passwordWithBASE64 + ":" + user.getRememberMe();
    
    Cookie cookie = new Cookie(name, cookieValue);
    cookie.setMaxAge(maxAge);
    cookie.setDomain(getCookieDomainName());
    cookie.setPath("/");
    
    response.addCookie(cookie);
    
    if (logger.isInfoEnabled()) {
      logger.info("Cookie Version : " + cookie.getVersion());
      logger.info("Cookie Name : " + cookie.getName());
      logger.info("Cookie Value : " + cookie.getValue());
      logger.info("Cookie MaxAge : " + cookie.getMaxAge());
      logger.info("Cookie Domain : " + cookie.getDomain());
      logger.info("left saveCookie normally");
    }
    return cookieValue;
  }
  





  public static void removeCookie(HttpServletResponse response, String name)
  {
    Cookie cookie = new Cookie(name, null);
    cookie.setPath("/");
    cookie.setMaxAge(0);
    response.addCookie(cookie);
  }
  




  public static String getCookieDomainName()
  {
    String domainName = Environment.getDomainName();
    String cookieDomainName = domainName.substring(domainName.indexOf("."));
    return cookieDomainName;
  }
  






  public static boolean isValidCookieValue(String cookieValue)
  {
    if (StringUtils.isBlank(cookieValue))
      return false;
    if (cookieValue.startsWith("error:")) {
      return false;
    }
    return true;
  }
}
