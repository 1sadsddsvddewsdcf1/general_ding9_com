package com.ding9.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager
{
  private HttpServletRequest request = null;
  private HttpServletResponse response = null;
  
  public CookieManager(HttpServletRequest request, HttpServletResponse response) { this.request = request;
    this.response = response;
  }
  
  public String getCookieValue(String name) { Cookie cookie = HttpHelper.getCookie(this.request, name);
    return cookie == null ? null : cookie.getValue();
  }
  
  public void addCookie(String name, String value) { Cookie cookie = new Cookie(name, value);
    cookie.setMaxAge(-1);
    cookie.setDomain(Environment.getDomainName());
    cookie.setPath("/");
    this.response.addCookie(cookie);
  }
  
  public void removeCookie(String name) {
    Cookie ck = new Cookie(name, "");
    ck.setDomain(Environment.getDomainName());
    ck.setPath("/");
    ck.setMaxAge(0);
    this.response.addCookie(ck);
  }
}
