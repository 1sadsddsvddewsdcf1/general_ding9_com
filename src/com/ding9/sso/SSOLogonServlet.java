package com.ding9.sso;

import com.ding9.util.CookieUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;




public class SSOLogonServlet
  extends HttpServlet
{
  private static final Logger logger = Logger.getLogger(SSOLogonServlet.class);
  




  private static final long serialVersionUID = 905610280130490115L;
  





  public void destroy()
  {
    super.destroy();
  }
  













  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    if (logger.isInfoEnabled()) {
      logger.info("doGet(HttpServletRequest, HttpServletResponse) - start");
    }
    
    execute(request, response);
    
    if (logger.isInfoEnabled()) {
      logger.info("doGet(HttpServletRequest, HttpServletResponse) - end");
    }
  }
  














  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    if (logger.isInfoEnabled()) {
      logger.info("doPost(HttpServletRequest, HttpServletResponse) - start");
    }
    
    execute(request, response);
    
    if (logger.isInfoEnabled()) {
      logger.info("doPost(HttpServletRequest, HttpServletResponse) - end");
    }
  }
  



  public void init()
    throws ServletException
  {}
  


  private void execute(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String rememberMe = request.getParameter("rememberMe");
    if (logger.isInfoEnabled()) {
      logger.info("username: " + username);
      logger.info("password: " + password);
      logger.info("rememberMe: " + rememberMe);
    }
    
    SSOAppManager appMgr = new SSOAppManager(request, response);
    String cookieValue = null;
    
    if (appMgr.isLogin()) {
      cookieValue = appMgr.findSSOIdFromCookie();
    } else {
      cookieValue = appMgr.login(username, password, rememberMe);
    }
    
    if (StringUtils.isBlank(cookieValue)) {
      response.sendRedirect(request.getContextPath() + "/logon/logon.jsp");
    } else if (cookieValue.startsWith("error:")) {
      String message = cookieValue.substring(cookieValue.indexOf(":") + 1);
      if ("not_avail_parameter".equals(message)) {
        message = "无效的输入参数";
      } else if ("rep_var_para_err".equals(message)) {
        message = "用户名或者密码错误";
      } else if ("username_verify_error".equals(message)) {
        message = "用户名错误";
      } else if ("password_verify_error".equals(message)) {
        message = "密码错误";
      } else if ("user_is_not_activated".equals(message)) {
        message = "用户没有激活";
      } else if ("user_not_exist".equals(message)) {
        message = "用户没有找到";
      }
      request.getSession().setAttribute("logon_msg", message);
      response.sendRedirect(request.getContextPath() + "/logon/logon.jsp");
    } else {
      response.sendRedirect(request.getContextPath() + "/main.jsp");
    }
    
    if (CookieUtil.isValidCookieValue(cookieValue)) {
      response.sendRedirect(request.getContextPath() + "/main.jsp");
    } else if (cookieValue.startsWith("error:")) {
      String message = cookieValue.substring(cookieValue.indexOf(":") + 1);
      if ("not_avail_parameter".equals(message)) {
        message = "无效的输入参数";
      } else if ("rep_var_para_err".equals(message)) {
        message = "用户名或者密码错误";
      } else if ("username_verify_error".equals(message)) {
        message = "用户名错误";
      } else if ("password_verify_error".equals(message)) {
        message = "密码错误";
      } else if ("system_error".equals(message)) {
        message = "系统错误";
      } else if ("user_is_not_activated".equals(message)) {
        message = "用户没有激活";
      } else if ("user_not_exist".equals(message)) {
        message = "用户没有找到";
      }
      request.getSession().setAttribute("logon_msg", message);
      response.sendRedirect(request.getContextPath() + "/logon/logon.jsp");
    }
    
    response.getWriter().flush();
    response.getWriter().close();
  }
}
