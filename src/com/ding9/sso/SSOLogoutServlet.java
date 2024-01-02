package com.ding9.sso;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;





public class SSOLogoutServlet
  extends HttpServlet
{
  private static final Logger logger = Logger.getLogger(SSOLogoutServlet.class);
  




  private static final long serialVersionUID = 966020834612616418L;
  




  public void destroy()
  {
    if (logger.isInfoEnabled()) {
      logger.info("destroy() - start");
    }
    
    super.destroy();
    

    if (logger.isInfoEnabled()) {
      logger.info("destroy() - end");
    }
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
    SSOAppManager appMgr = new SSOAppManager(request, response);
    appMgr.logout();
    logger.info("用户已登出");
    
    response.sendRedirect(request.getContextPath() + "/logon/logon.jsp");
    response.getWriter().flush();
    response.getWriter().close();
  }
}
