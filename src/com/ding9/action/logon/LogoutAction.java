package com.ding9.action.logon;

import com.ding9.sso.SSOAppManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class LogoutAction
  extends Action
{
  private static final Logger logger = Logger.getLogger(LogoutAction.class);
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    if (logger.isInfoEnabled()) logger.info("entered Logout");
    response.setContentType("text/xml; charset=GB2312");
    response.setHeader("Cache-Control", "no-cache");
    
    SSOAppManager appMgr = new SSOAppManager(request, response);
    appMgr.logout();
    
    PrintWriter out = response.getWriter();
    out.println("<pront>");
    out.println("<flag>1</flag>");
    out.println("</pront>");
    out.flush();
    out.close();
    if (logger.isInfoEnabled()) {
      logger.info("logout success");
      logger.info("left logout normally");
    }
    
    return null;
  }
}
