package com.ding9.sso;

import com.ding9.entity.user.UserAccountInfo;
import com.ding9.service.user.UserService;
import com.ding9.util.CookieUtil;
import com.oreilly.servlet.Base64Decoder;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;











public class SSOAppManager
{
  private static final Logger logger = Logger.getLogger(SSOAppManager.class);
  
  private HttpServletRequest request;
  
  private HttpServletResponse response;
  
  public SSOAppManager(HttpServletRequest request, HttpServletResponse response)
  {
    this.request = request;
    this.response = response;
  }
  







  public String login(String username, String password, String rememberMe)
    throws IOException
  {
    if (logger.isInfoEnabled()) logger.info("login(String, String) - start");
    if ((username == null) && (username.length() < 6)) {
      if (logger.isInfoEnabled()) { logger.info("login(String, String) - end");
      }
      
      return "error:not_avail_parameter";
    }
    
    UserService userService = new UserService();
    int authResult = userService.authenticate(username, password);
    if (authResult < 0) {
      logger.info("logon unsuccess");
      String msg = null;
      switch (authResult)
      {
      case -1: 
        msg = "error:rep_var_para_err";
        break;
      
      case -3: 
        msg = "error:username_verify_error";
        break;
      
      case -4: 
        msg = "error:password_verify_error";
        break;
      case -2: default: 
        msg = "error:system_error";
      }
      
      if (logger.isInfoEnabled()) logger.info("login(String, String) - end");
      return msg;
    }
    boolean result = userService.isActivated(username);
    if (!result) {
      if (logger.isInfoEnabled()) { logger.info("login(String, String) - end");
      }
      
      return "error:user_is_not_activated";
    }
    

    SSOUser user = findUser(username, password);
    if (user == null)
    {

      return "error:user_not_exist";
    }
    
    if (logger.isInfoEnabled()) logger.info("save Cookies");
    if ("true".equals(rememberMe)) {
      user.setRememberMe("true");
    } else {
      user.setRememberMe("false");
    }
    String cookieValue = CookieUtil.createAndSaveCookie(this.response, "SSOUserId", user, 28800);
    
    HttpSession session = this.request.getSession(true);
    session.setAttribute("userId", Integer.valueOf(user.getUserId()));
    session.setAttribute("username", username);
    session.setAttribute("logon_time", user.getLastLoginTime());
    session.setMaxInactiveInterval(28800);
    
    if (logger.isInfoEnabled()) {
      logger.info("login(String, String) - end");
    }
    return cookieValue;
  }
  






  public SSOUser findUser(String username, String password)
  {
    if (logger.isInfoEnabled()) {
      logger.info("findUser(String, String) - start");
    }
    
    if ((username == null) && (username.length() < 6)) {
      if (logger.isInfoEnabled()) logger.info("findUser(String, String) - end");
      return null;
    }
    
    UserService userService = new UserService();
    UserAccountInfo user = userService.findByName(username);
    if (user == null) {
      if (logger.isInfoEnabled()) logger.info("findUser(String, String) - end");
      return null;
    }
    
    SSOUser ssoUser = new SSOUser();
    ssoUser.setUserId(user.getUser_id());
    ssoUser.setUsername(username);
    ssoUser.setPassword(password);
    ssoUser.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
    
    if (logger.isInfoEnabled()) {
      logger.info("findUser(String, String) - end");
    }
    return ssoUser;
  }
  



  public String findSSOIdFromCookie()
  {
    if (logger.isInfoEnabled()) {
      logger.info("findSSOIdFromCookie() - start");
    }
    
    Cookie cookie = CookieUtil.findCookie(this.request, "SSOUserId");
    if (logger.isInfoEnabled()) { logger.info("Cookie cookie=" + cookie);
    }
    if (cookie == null) {
      if (logger.isInfoEnabled()) {
        logger.info("findSSOIdFromCookie() - end");
      }
      return null;
    }
    String returnString = cookie.getValue();
    if (logger.isInfoEnabled()) {
      logger.info("String returnString=" + returnString);
      logger.info("findSSOIdFromCookie() - end");
    }
    return returnString;
  }
  




  public void logout()
  {
    String cookieValue = findSSOIdFromCookie();
    if (StringUtils.isBlank(cookieValue)) {
      try {
        this.response.sendRedirect(this.request.getContextPath() + "/logon/logon.jsp");
      } catch (IOException e) {
        if (logger.isInfoEnabled()) { logger.error("IOException : " + e.getLocalizedMessage());
        }
      }
    }
    String[] cookStrings = cookieValue.split(":");
    String username = Base64Decoder.decode(cookStrings[1]);
    
    String string = "hUKlWJLj";
    SSOUser ssoUser = new SSOUser();
    ssoUser.setUserId(0);
    ssoUser.setUsername(username);
    ssoUser.setPassword(string);
    ssoUser.setRememberMe(string);
    
    String saveResult = CookieUtil.createAndSaveCookie(this.response, "SSOUserId", ssoUser, 28800);
    if (StringUtils.isBlank(saveResult)) {
      logger.info("Cookie重写失败.");
    } else {
      logger.info("Cookie重写成功.");
    }
    HttpSession session = this.request.getSession();
    if (session != null) {
      session.removeAttribute("username");
      session.invalidate();
      session = null;
    }
  }
  



  public boolean isLogin()
  {
    String cookieValue = findSSOIdFromCookie();
    if (logger.isInfoEnabled()) { logger.info("isLogin() - String cookieValue=" + cookieValue);
    }
    if (cookieValue == null) {
      logger.info("用户未登录");
      return false;
    }
    String[] cookStrings = cookieValue.split(":");
    
    if ("0".equals(cookStrings[0])) {
      logger.info("用户未登录");
      return false;
    }
    logger.info("用户已登录");
    return true;
  }
  

  public int findUserId()
  {
    String cookieValue = findSSOIdFromCookie();
    if (logger.isInfoEnabled()) logger.info("cookie Value : " + cookieValue);
    if (StringUtils.isBlank(cookieValue)) {
      try {
        this.response.sendRedirect(this.request.getContextPath() + "/logon/logon.jsp");
      } catch (IOException e) {
        if (logger.isInfoEnabled()) logger.error("IOException : " + e.getLocalizedMessage());
      }
      return 0;
    }
    String[] cookStrings = cookieValue.split(":");
    String id = cookStrings[0];
    if (StringUtils.isBlank(id)) {
      try {
        this.response.sendRedirect(this.request.getContextPath() + "/logon/logon.jsp");
      } catch (IOException e) {
        if (logger.isInfoEnabled()) logger.error("IOException : " + e.getLocalizedMessage());
      }
      return 0;
    }
    
    return Integer.parseInt(id);
  }
}
