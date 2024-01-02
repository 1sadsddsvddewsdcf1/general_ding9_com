package com.ding9.click.filter;

import com.ding9.click.client.IAccessLogApi;
import com.ding9.click.client.impl.AccessLogApi;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ClickStatFilter
  extends HttpServlet
  implements Filter
{
  private static final Log log = LogFactory.getLog(ClickStatFilter.class);
  
  private static final long serialVersionUID = 1L;
  private FilterConfig filterConfig = null;
  
  public void init(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }
  
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) {
    try {
      req.setCharacterEncoding("gbk");
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    try
    {
      HttpServletRequest request = (HttpServletRequest)req;
      HttpServletResponse response = (HttpServletResponse)resp;
      


      try
      {
        if (isLegalPostfix(request, response)) {
          IAccessLogApi accesslogapi = new AccessLogApi();
          
          accesslogapi.addAccessLogInfo(request, response);
        }
      } catch (Exception ex) {
        if (log.isErrorEnabled()) {
          log.error(ex);
        }
      }
      
      filterChain.doFilter(request, response);
    } catch (ServletException sx) {
      if (log.isErrorEnabled()) {
        log.error(sx.getMessage());
      }
    }
    catch (IOException iox) {
      if (log.isErrorEnabled()) {
        log.error(iox.getMessage());
      }
    }
  }
  







  private boolean isLegalPostfix(HttpServletRequest request, HttpServletResponse response)
  {
    String[] legals = { ".do", ".jsp", ".htm", ".html", ".jhtml", ".shtml" };
    
    String filename = request.getRequestURI();
    filename = filename == null ? "" : filename.trim().toLowerCase();
    


    if (filename.indexOf(".") < 1)
    {
      return true;
    }
    
    for (int i = 0; i < legals.length; i++) {
      if ((filename.indexOf(legals[i]) > 0) && (filename.length() == filename.indexOf(legals[i]) + legals[i].length())) {
        return true;
      }
    }
    return false;
  }
}
