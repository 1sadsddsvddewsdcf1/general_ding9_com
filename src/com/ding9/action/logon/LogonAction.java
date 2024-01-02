package com.ding9.action.logon;

import com.ding9.dao.collection.UserTagDao;
import com.ding9.dao.collection.UserTagDaoImpl;
import com.ding9.sso.SSOAppManager;
import com.ding9.util.CookieUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;






public final class LogonAction
  extends Action
{
  private static final Logger logger = Logger.getLogger(LogonAction.class);
  

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    if (logger.isInfoEnabled()) {
      logger.info("entered logon");
    }
    response.setContentType("text/xml; charset=GB2312");
    response.setHeader("Cache-Control", "no-cache");
    
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
    

    PrintWriter out = response.getWriter();
    if (CookieUtil.isValidCookieValue(cookieValue)) {
      List tagList = null;
      String[] arr = cookieValue.split(":");
      String userid = arr[0];
      UserTagDao tagDao = new UserTagDaoImpl();
      tagList = tagDao.query(Integer.parseInt(userid), 1);
      request.setAttribute("tagList", tagList);
      
      out.println("<pront>");
      out.println("<flag>1</flag>");
      out.println("</pront>");
      if (logger.isInfoEnabled()) logger.info("logon success");
    } else {
      out.println("<pront>");
      out.println("<flag>0</flag>");
      out.println("</pront>");
      if (logger.isInfoEnabled()) logger.info("logon unsuccess");
    }
    out.flush();
    out.close();
    
    if (logger.isInfoEnabled()) logger.info("left logon normally");
    return null;
  }
}
