package com.ding9.sso.filter;

import com.ding9.sso.SSOAppManager;
import com.ding9.sso.SSOUser;
import com.oreilly.servlet.Base64Decoder;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;









public class SSOFilter
  extends HttpServlet
  implements Filter
{
  private static final Logger logger = Logger.getLogger(SSOFilter.class);
  
  private static final long serialVersionUID = -2501756843940604065L;
  private String onFailure = "/logon/logon.jsp";
  

  public void init(FilterConfig filterConfig)
    throws ServletException
  {
    this.onFailure = filterConfig.getInitParameter("onFailure");
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    if (logger.isInfoEnabled()) { logger.info("doFilter(ServletRequest request,ServletResponse response,FilterChain chain) - start");
    }
    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse res = (HttpServletResponse)response;
    if (logger.isInfoEnabled()) {
      logger.info("URI : " + req.getRequestURI());
    }
    if (req.getServletPath().equals(this.onFailure)) {
      chain.doFilter(request, response);
      return;
    }
    
    if ((isLegalPostfix(req, res)) && (!isIgnorePage(req, res))) {
      if (logger.isInfoEnabled()) logger.info("do Filter...");
      SSOAppManager appMgr = new SSOAppManager(req, res);
      if (!appMgr.isLogin()) {
        res.sendRedirect(req.getContextPath() + "/logon/logon.jsp");
      } else {
        String ssoid = appMgr.findSSOIdFromCookie();
        if (logger.isInfoEnabled()) logger.info("cookie Value : " + ssoid);
        if (StringUtils.isBlank(ssoid)) {
          res.sendRedirect(req.getContextPath() + "/logon/logon.jsp");
        }
        String[] cookStrings = ssoid.split(":");
        
        String id = cookStrings[0];
        if ("0".equals(id)) {
          res.sendRedirect(req.getContextPath() + "/logon/logon.jsp");
        }
        
        String username = Base64Decoder.decode(cookStrings[1]);
        String password = Base64Decoder.decode(cookStrings[2]);
        SSOUser user = appMgr.findUser(username, password);
        HttpSession session = req.getSession(true);
        session.setAttribute("userId", Integer.valueOf(user.getUserId()));
        session.setAttribute("username", username);
        session.setAttribute("logon_time", user.getLastLoginTime());
        session.setMaxInactiveInterval(28800);
      }
    }
    
    chain.doFilter(request, response);
    if (logger.isInfoEnabled()) logger.info("doFilter(ServletRequest request,ServletResponse response,FilterChain chain) - end");
  }
  
  public void destroy() {}
  
  private boolean isLegalPostfix(HttpServletRequest request, HttpServletResponse response)
  {
    String[] legals = {
      ".do", ".jsp" };
    
    String filename = request.getRequestURI();
    filename = filename != null ? filename.trim().toLowerCase() : "";
    if (filename.indexOf(".") < 1) {
      return true;
    }
    for (int i = 0; i < legals.length; i++) {
      if ((filename.indexOf(legals[i]) > 0) && (filename.length() == filename.indexOf(legals[i]) + legals[i].length()))
        return true;
    }
    return false;
  }
  
  private boolean isIgnorePage(HttpServletRequest request, HttpServletResponse response) {
    if (logger.isInfoEnabled()) logger.info("isIgnorePage() - start");
    String[] ignores = {
      "/include.*", 
      "/index.*", 
      "/logon*.*", 
      "/servlet/.*", 
      "/server/.*", 
      "/register.*", 
      "/findpwd/.*", 
      "/css/.*", 
      "/js/.*", 
      "/images/.*", 
      "/email_info.jsp", 
      "/getpwd.do", 
      "/user/tomail.jsp", 
      "/user/toupdpwd.jsp", 
      "/user/updpwd.jsp", 
      "/user/finish.jsp", 
      "/useremail/.*" };
    
    String filename = null;
    for (int i = 0; i < ignores.length; i++) {
      String rule = request.getContextPath() + ignores[i];
      if (logger.isInfoEnabled()) {
        logger.info("rule : " + rule);
      }
      Pattern p = Pattern.compile(rule);
      filename = request.getRequestURI();
      filename = filename != null ? filename.trim().toLowerCase() : "";
      for (int j = 0; j < 3; j++) {
        filename = filename.replaceAll("//", "/");
      }
      Matcher m = p.matcher(filename);
      if (m.matches()) {
        if (logger.isInfoEnabled()) {
          logger.info("filename : " + filename);
          logger.info("matches.");
          if (logger.isInfoEnabled()) logger.info("isIgnorePage() - true - end");
        }
        return true;
      }
    }
    if (logger.isInfoEnabled()) logger.info("isIgnorePage() - false - end");
    return false;
  }
}
