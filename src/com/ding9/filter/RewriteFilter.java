package com.ding9.filter;

import com.ding9.util.UrlRewriteManager;
import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RewriteFilter
  extends HttpServlet implements Filter
{
  private static final Log log = LogFactory.getLog(RewriteFilter.class);
  
  private static final long serialVersionUID = 1L;
  private FilterConfig filterConfig = null;
  
  public void init(FilterConfig filterConfig) { this.filterConfig = filterConfig; }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
  {
    try {
      HttpServletRequest req = (HttpServletRequest)request;
      
      request.setCharacterEncoding("UTF-8");
      

      String fileuri = URLDecoder.decode(req.getRequestURI(), "UTF-8");
      fileuri = fileuri == null ? "" : fileuri.trim();
      
      if (log.isInfoEnabled()) {
        log.info("****");
        log.info("Filter filepath :" + fileuri + req.getQueryString() + "  " + System.currentTimeMillis());
        log.info(UrlRewriteManager.static2dynamic(fileuri.toString()));
      }
      
      if ((isLegalPostfix(fileuri)) && 
        (!fileuri.toString().equals(UrlRewriteManager.static2dynamic(fileuri.toString())))) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(UrlRewriteManager.static2dynamic(fileuri.toString()));
        dispatcher.forward(request, response);
        return;
      }
      
      filterChain.doFilter(request, response);
    } catch (ServletException sx) {
      if (log.isErrorEnabled()) {
        log.error(sx.getMessage());
        this.filterConfig.getServletContext().log(sx.getMessage());
      }
    } catch (IOException iox) {
      if (log.isErrorEnabled()) {
        log.error(iox.getMessage());
        this.filterConfig.getServletContext().log(iox.getMessage());
      }
    }
  }
  


























  private boolean isLegalPostfix(String filename)
  {
    String[] legals = { ".htm" };
    
    for (int i = 0; i < legals.length; i++) {
      if ((filename.indexOf(legals[i]) > 0) && (filename.length() == filename.indexOf(legals[i]) + legals[i].length())) {
        return true;
      }
    }
    return false;
  }
}
