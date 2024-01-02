package com.ding9.click.util;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
















public class HttpHelper
{
  public static String getServer(HttpServletRequest request)
  {
    String uri = request.getRequestURI();
    String url = request.getRequestURL().toString();
    return url.substring(0, url.indexOf(uri)) + request.getContextPath() + "/";
  }
  




  public static String getParameter(HttpServletRequest request, String name)
  {
    return request.getParameter(name);
  }
  





  public static String getParameter(HttpServletRequest request, String name, String defaultValue)
  {
    String value = request.getParameter(name);
    if (value == null) return defaultValue;
    return value;
  }
  




  public static int getParameterInt(HttpServletRequest request, String name)
  {
    return Integer.parseInt(getParameter(request, name));
  }
  





  public static int getParameterInt(HttpServletRequest request, String name, int defaultValue)
  {
    return StringHelper.parseInt(getParameter(request, name), defaultValue);
  }
  




  public static long getParameterLong(HttpServletRequest request, String name)
  {
    return Long.parseLong(getParameter(request, name));
  }
  





  public static long getParameterLong(HttpServletRequest request, String name, long defaultValue)
  {
    return StringHelper.parseLong(getParameter(request, name), defaultValue);
  }
  




  public static double getParameterDouble(HttpServletRequest request, String name)
  {
    return Double.parseDouble(getParameter(request, name));
  }
  





  public static double getParameterDouble(HttpServletRequest request, String name, double defaultValue)
  {
    return StringHelper.parseDouble(getParameter(request, name), defaultValue);
  }
  




  public static Date getParameterDate(HttpServletRequest request, String name)
  {
    String format = "yyyy-MM-dd";
    return getParameterDate(request, name, "yyyy-MM-dd");
  }
  





  public static Date getParameterDate(HttpServletRequest request, String name, String format)
  {
    String value = getParameter(request, name);
    if (!DateHelper.isDateFormat(value, format)) return null;
    return DateHelper.toDate(value, format);
  }
  




  public static Object getSessionAttribute(HttpServletRequest request, String name)
  {
    HttpSession session = request.getSession(true);
    return session.getAttribute(name);
  }
  








  public static String getRequestValue(HttpServletRequest request, String name)
  {
    String value = request.getParameter(name);
    if (value != null) return value;
    value = (String)request.getAttribute(name);
    if (value != null) return value;
    HttpSession session = request.getSession(true);
    value = (String)session.getAttribute(name);
    if (value != null) return value;
    value = (String)session.getServletContext().getAttribute(name);
    return value;
  }
  




  public static Cookie getCookie(HttpServletRequest request, String name)
  {
    Cookie[] cookies = request.getCookies();
    if ((cookies == null) || (cookies.length <= 0)) return null;
    for (int i = 0; i < cookies.length; i++) {
      Cookie cookie = cookies[i];
      if (cookie.getName().equals(name)) return cookie;
    }
    return null;
  }
  



  public static String getAllParametersDesc(HttpServletRequest request)
  {
    Enumeration names = request.getParameterNames();
    StringBuffer params = new StringBuffer();
    params.append("[");
    while (names.hasMoreElements()) {
      String name = (String)names.nextElement();
      String value = request.getParameter(name);
      params.append(name).append("=").append(value).append(";");
    }
    params.append("]");
    return params.toString();
  }
  
  public static String doGet(String reqURL) throws IOException { return URLGrabber.getDocumentAsString(reqURL); }
}
