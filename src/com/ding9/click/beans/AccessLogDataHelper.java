package com.ding9.click.beans;

import com.ding9.click.entity.accesslog.IBLAccessLogData;
import com.ding9.click.entity.accesslog.IVipBLAccessLogData;
import com.ding9.click.entity.accesslog.impl.BLAccessLogData;
import com.ding9.click.entity.accesslog.impl.VipBLAccessLogData;
import com.ding9.click.util.ConfigManager;
import com.ding9.click.util.Conversions;
import com.ding9.click.util.security.SecureFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Enumeration;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;













public class AccessLogDataHelper
{
  public static final String SSON_COOKIE_COOPERATE_ID = "ding9_click_cooperate_id";
  public static final String SSON_COOKIE_INIT_REFERER_URL = "ding9_click_init_referer_url";
  public static final String SSON_COOKIE_INIT_REFERER_HOST = "ding9_click_init_referer_host";
  public static final String SSON_COOKIE_USER_ID = "ding9_click_user_id";
  public static final String SSON_COOKIE_LINKED_ID = "ding9_click_linked_id";
  private HttpServletRequest request = null;
  



  private HttpServletResponse response = null;
  



  private String ssonkey = null;
  



  private byte[] ssonkeyvalue = new byte['È'];
  



  private long nowtime = 0L;
  



  private byte[] salt = new byte[16];
  



  private int timeout = 7200;
  



  private int refreshtime = 3600;
  



  private String serverhost = "";
  




  public AccessLogDataHelper(HttpServletRequest req, HttpServletResponse resp)
  {
    this.request = req;
    this.response = resp;
    initData();
  }
  

  private void initData()
  {
    try
    {
      this.timeout = Integer.parseInt(ConfigManager.getProperty("COOKIE_TIMEOUT"));
      this.refreshtime = Integer.parseInt(ConfigManager.getProperty("COOKIE_REFRESHTIME"));
      this.serverhost = String.valueOf(ConfigManager.getProperty("SERVER_HOST"));
      
      if (this.refreshtime >= this.timeout) {
        this.refreshtime = (this.timeout / 2);
      }
    }
    catch (Exception localException) {}
  }
  












  public IBLAccessLogData initAccessLogData(int billline_id, int vipbillline_id, IBLAccessLogData accesslog, HttpServletRequest request)
  {
    if (accesslog == null) {
      accesslog = new BLAccessLogData();
    }
    

    accesslog.setBl_id(billline_id);
    
    accesslog.setCooperate_id(getCooperateidFromRequest(request));
    
    accesslog.setVipbl_id(vipbillline_id);
    
    accesslog.setRemote_addr(request.getRemoteAddr());
    
    accesslog.setRemote_user(request.getRemoteUser() == null ? "" : request.getRemoteUser());
    
    accesslog.setHttp_method(request.getMethod());
    
    accesslog.setRequest_protocol(request.getProtocol());
    
    accesslog.setRequest_scheme(request.getScheme());
    
    accesslog.setRequest_server(request.getServerName());
    
    accesslog.setRequest_port(String.valueOf(request.getServerPort()));
    
    accesslog.setRequest_uri(request.getRequestURI());
    
    accesslog.setRequest_querystr(request.getQueryString());
    
    accesslog.setAccept_type(request.getHeader("Accept"));
    
    accesslog.setReferer_url(request.getHeader("Referer"));
    
    accesslog.setReferer_host(getHostFromUrl(accesslog.getReferer_url()));
    
    accesslog.setReferer_querystr(getQuerystrFromUrl(accesslog.getReferer_url()));
    
    accesslog.setUser_agent(request.getHeader("User-Agent"));
    
    accesslog.setInit_referer_url(getInitRefererUrl(accesslog.getReferer_url(), request));
    
    accesslog.setInit_referer_host(getInitRefererHost(accesslog.getReferer_host(), request));
    
    accesslog.setSession_id(request.getRequestedSessionId());
    
    accesslog.setCookie_id(request.getHeader("Cookie"));
    
    accesslog.setIs_spider(getIsSpider(accesslog.getUser_agent()));
    
    accesslog.setIs_firstlog(getIsFirstLog(accesslog.getReferer_host(), accesslog.getInit_referer_host()));
    
    return accesslog;
  }
  













  public IBLAccessLogData initAccessLogData(int billline_id, int vipbillline_id, String referer_url, IBLAccessLogData accesslog, HttpServletRequest request)
  {
    if (accesslog == null) {
      accesslog = new BLAccessLogData();
    }
    

    accesslog.setBl_id(billline_id);
    
    accesslog.setCooperate_id(getCooperateidFromReferer(referer_url, request));
    
    accesslog.setVipbl_id(vipbillline_id);
    
    accesslog.setRemote_addr(request.getRemoteAddr());
    
    accesslog.setRemote_user(request.getRemoteUser() == null ? "" : request.getRemoteUser());
    
    accesslog.setHttp_method(request.getMethod());
    
    accesslog.setRequest_protocol(request.getProtocol());
    
    accesslog.setRequest_scheme(request.getScheme());
    


    accesslog.setRequest_server(getHostFromUrl(request.getHeader("Referer")));
    
    accesslog.setRequest_port(String.valueOf(getPortFromUrl(request.getHeader("Referer"))));
    
    accesslog.setRequest_uri(getUriFromUrl(request.getHeader("Referer")));
    
    accesslog.setRequest_querystr(getQuerystrFromUrl(request.getHeader("Referer")));
    


    accesslog.setAccept_type(request.getHeader("Accept"));
    

    accesslog.setReferer_url(referer_url);
    
    accesslog.setReferer_host(getHostFromUrl(accesslog.getReferer_url()));
    
    accesslog.setReferer_querystr(getQuerystrFromUrl(accesslog.getReferer_url()));
    

    accesslog.setUser_agent(request.getHeader("User-Agent"));
    
    accesslog.setInit_referer_url(getInitRefererUrl(accesslog.getReferer_url(), request));
    
    accesslog.setInit_referer_host(getInitRefererHost(accesslog.getReferer_host(), request));
    
    accesslog.setSession_id(request.getRequestedSessionId());
    
    accesslog.setCookie_id(request.getHeader("Cookie"));
    
    accesslog.setIs_spider(getIsSpider(accesslog.getUser_agent()));
    
    accesslog.setIs_firstlog(getIsFirstLog(accesslog.getReferer_host(), accesslog.getInit_referer_host()));
    
    return accesslog;
  }
  










  public IVipBLAccessLogData initVipAccessLogData(int billline_id, int vipbillline_id, boolean is_payclick, IVipBLAccessLogData vipaccesslog, HttpServletRequest request)
  {
    if (vipaccesslog == null) {
      vipaccesslog = new VipBLAccessLogData();
    }
    

    vipaccesslog.setBl_id(billline_id);
    
    vipaccesslog.setCooperate_id(getCooperateidFromRequest(request));
    
    vipaccesslog.setVipbl_id(vipbillline_id);
    
    vipaccesslog.setIs_payclick(is_payclick ? 1 : 0);
    

    vipaccesslog.setRemote_addr(request.getRemoteAddr());
    
    vipaccesslog.setRequest_server(request.getServerName());
    
    vipaccesslog.setRequest_port(String.valueOf(request.getServerPort()));
    
    vipaccesslog.setRequest_uri(request.getRequestURI());
    
    vipaccesslog.setRequest_querystr(request.getQueryString());
    
    vipaccesslog.setAccept_type(request.getHeader("Accept"));
    
    vipaccesslog.setReferer_url(request.getHeader("Referer"));
    
    vipaccesslog.setReferer_host(getHostFromUrl(vipaccesslog.getReferer_url()));
    
    vipaccesslog.setReferer_querystr(getQuerystrFromUrl(vipaccesslog.getReferer_url()));
    
    Enumeration em = request.getHeaderNames();
    while (em.hasMoreElements()) {
      String name = em.nextElement().toString();
      String str1 = request.getHeader(name);
    }
    
    vipaccesslog.setUser_agent(request.getHeader("User-Agent"));
    

    vipaccesslog.setInit_referer_url(getInitRefererUrl(vipaccesslog.getReferer_url(), request));
    

    vipaccesslog.setInit_referer_host(getInitRefererHost(vipaccesslog.getReferer_host(), request));
    
    vipaccesslog.setSession_id(request.getRequestedSessionId());
    
    vipaccesslog.setCookie_id(request.getHeader("Cookie"));
    

    vipaccesslog.setIs_spider(getIsSpider(vipaccesslog.getUser_agent()));
    
    vipaccesslog.setUser_id(getInitUserID(request.getParameter("user_id"), request));
    
    vipaccesslog.setLinked_id(getInitLinkedID(request.getParameter("linked_id"), request));
    
    return vipaccesslog;
  }
  






  private int getIsFirstLog(String referer_host, String init_referer_host)
  {
    int result = 0;
    
    referer_host = referer_host == null ? "" : referer_host.trim().toLowerCase();
    init_referer_host = init_referer_host == null ? "" : init_referer_host.trim().toLowerCase();
    
    if (init_referer_host.equals(referer_host)) {
      result = 1;
    }
    
    return result;
  }
  




  private int getIsSpider(String user_agent)
  {
    int result = 0;
    
    user_agent = user_agent == null ? "" : user_agent.trim().toLowerCase();
    
    if (user_agent.indexOf("spider") > -1) {
      result = 1;
    }
    
    return result;
  }
  






  private String getInitRefererUrl(String referer_url, HttpServletRequest request)
  {
    String result = "";
    


    result = getSsoKeyValue("ding9_click_init_referer_url");
    
    result = result == null ? "" : result.trim();
    result = "null".equals(result.toLowerCase()) ? "" : result.trim();
    
    if ("".equals(result)) {
      result = referer_url;
      

      setSsoKeyValue("ding9_click_init_referer_url", referer_url, request);
    }
    

    return result;
  }
  






  private String getInitRefererHost(String referer_host, HttpServletRequest request)
  {
    String result = "";
    


    result = getSsoKeyValue("ding9_click_init_referer_host");
    
    result = result == null ? "" : result.trim();
    result = "null".equals(result.toLowerCase()) ? "" : result.trim();
    
    if ("".equals(result)) {
      result = referer_host;
      

      setSsoKeyValue("ding9_click_init_referer_host", referer_host, request);
    }
    

    return result;
  }
  






  private String getInitUserID(String user_id, HttpServletRequest request)
  {
    String result = "";
    


    result = getSsoKeyValue("ding9_click_user_id");
    
    result = result == null ? "" : result.trim();
    result = "null".equals(result.toLowerCase()) ? "" : result.trim();
    int tempuser_id = 0;
    if ("".equals(result)) {
      try {
        user_id = user_id == null ? "0" : user_id;
        tempuser_id = Integer.parseInt(user_id);
      } catch (Exception e) { user_id = "0";tempuser_id = 0;
      }
      setSsoKeyValue("ding9_click_user_id", user_id, request);
      result = getSsoKeyValue("ding9_click_user_id");
    } else {
      try {
        result = result == null ? "0" : result;
        tempuser_id = Integer.parseInt(result);
      } catch (Exception e) { tempuser_id = 0;
      }
    }
    return Integer.toString(tempuser_id);
  }
  






  private int getInitLinkedID(String linked_id, HttpServletRequest request)
  {
    String result = "";
    

    result = getSsoKeyValue("ding9_click_linked_id");
    
    result = result == null ? "" : result.trim();
    result = "null".equals(result.toLowerCase()) ? "" : result.trim();
    int templink_id = 0;
    if ("".equals(result)) {
      try {
        linked_id = linked_id == null ? "0" : linked_id;
        templink_id = Integer.parseInt(linked_id);
      } catch (Exception e) { linked_id = "0";templink_id = 0;
      }
      setSsoKeyValue("ding9_click_linked_id", linked_id, request);
      result = getSsoKeyValue("ding9_click_linked_id");
    } else {
      try {
        result = result == null ? "0" : result;
        templink_id = Integer.parseInt(result);
      } catch (Exception e) { templink_id = 0;
      } }
    return templink_id;
  }
  



  private String getQuerystrFromUrl(String url)
  {
    url = url == null ? "" : url.trim().toLowerCase();
    url = "null".equals(url) ? "" : url.trim().toLowerCase();
    if (url.indexOf("?") < 0) {
      return "";
    }
    
    try
    {
      url = url.substring(url.indexOf("?") + 1, url.length());
    } catch (Exception ex) {
      url = "";
    }
    


    return url;
  }
  




  private String getUriFromUrl(String url)
  {
    url = url == null ? "" : url.trim().toLowerCase();
    url = "null".equals(url) ? "" : url.trim().toLowerCase();
    if ("".equals(url)) {
      return url;
    }
    
    try
    {
      url = url.substring(url.indexOf("://") + 3, url.length());
      
      url = url.substring(url.indexOf("/"), url.length());
      
      if (url.indexOf("?") > -1) {
        url = url.substring(0, url.indexOf("?"));
      }
    }
    catch (Exception localException) {}
    

    return url;
  }
  




  private int getPortFromUrl(String url)
  {
    int port = 80;
    
    url = url == null ? "" : url.trim().toLowerCase();
    url = "null".equals(url) ? "" : url.trim().toLowerCase();
    if ("".equals(url)) {
      return port;
    }
    
    try
    {
      url = url.substring(url.indexOf("://") + 3, url.length());
      
      url = url.substring(0, url.indexOf("/"));
      
      if (url.indexOf(":") > -1) {
        url = url.substring(url.indexOf(":") + 1, url.length());
        
        port = Integer.parseInt(url);
      }
    } catch (Exception ex) {
      port = 80;
    }
    


    return port;
  }
  




  private String getHostFromUrl(String url)
  {
    url = url == null ? "" : url.trim().toLowerCase();
    url = "null".equals(url) ? "" : url.trim().toLowerCase();
    

    if ("".equals(url)) {
      return url;
    }
    
    try
    {
      url = url.substring(url.indexOf("://") + 3, url.length());
      
      url = url.substring(0, url.indexOf("/"));
      
      url = url.substring(0, url.indexOf(":"));
    }
    catch (Exception localException) {}
    
    return url;
  }
  





  private int getCooperateidFromRequest(HttpServletRequest request)
  {
    int cooperate_id = 0;
    if (request == null) {
      return 0;
    }
    String referer_url = "";
    referer_url = request.getHeader("Referer");
    












    String temp_url = "";
    
    referer_url = referer_url == null ? "" : referer_url.trim().toLowerCase();
    



    if (referer_url.indexOf("uano_id=") > -1) {
      try {
        temp_url = referer_url.substring(referer_url.indexOf("uano_id="), referer_url.length());
        if ((!"".equals(temp_url)) && (temp_url.indexOf("&") > 0)) {
          cooperate_id = Integer.parseInt(temp_url.substring(temp_url.indexOf("uano_id=") + 8, temp_url.indexOf("&")));
        } else {
          cooperate_id = Integer.parseInt(temp_url.substring(temp_url.indexOf("uano_id=") + 8, temp_url.length()));
        }
      } catch (Exception ex) {
        cooperate_id = 0;
      }
    }
    if ((cooperate_id == 0) && 
      (referer_url.indexOf("cooperate_id=") > -1)) {
      try {
        temp_url = referer_url.substring(referer_url.indexOf("cooperate_id="), referer_url.length());
        if ((!"".equals(temp_url)) && (temp_url.indexOf("&") > 0)) {
          cooperate_id = Integer.parseInt(temp_url.substring(temp_url.indexOf("cooperate_id=") + 13, temp_url.indexOf("&")));
        } else {
          cooperate_id = Integer.parseInt(temp_url.substring(temp_url.indexOf("cooperate_id=") + 13, temp_url.length()));
        }
      } catch (Exception ex) {
        cooperate_id = 0;
      }
    }
    
    if (cooperate_id == 0)
    {
      String result = getSsoKeyValue("ding9_click_cooperate_id");
      result = result == null ? "0" : result.trim();
      result = "null".equals(result.toLowerCase()) ? "0" : result.trim();
      try {
        cooperate_id = Integer.parseInt(result);
      } catch (Exception ex) { cooperate_id = 0;
      }
    }
    if (cooperate_id > 0) {
      setSsoKeyValue("ding9_click_cooperate_id", String.valueOf(cooperate_id), request);
    }
    

    return cooperate_id;
  }
  




  private int getCooperateidFromReferer(String referer_url, HttpServletRequest request)
  {
    int cooperate_id = 0;
    String temp_url = "";
    
    referer_url = referer_url == null ? "" : referer_url.trim().toLowerCase();
    
    if ("".equals(referer_url)) {
      return cooperate_id;
    }
    if (referer_url.indexOf("uano_id=") > -1) {
      try {
        temp_url = referer_url.substring(referer_url.indexOf("uano_id="), referer_url.length());
        if ((!"".equals(temp_url)) && (temp_url.indexOf("&") > 0)) {
          cooperate_id = Integer.parseInt(temp_url.substring(temp_url.indexOf("uano_id=") + 8, temp_url.indexOf("&")));
        } else {
          cooperate_id = Integer.parseInt(temp_url.substring(temp_url.indexOf("uano_id=") + 8, temp_url.length()));
        }
      } catch (Exception ex) {
        cooperate_id = 0;
      }
    }
    if ((cooperate_id == 0) && 
      (referer_url.indexOf("cooperate_id=") > -1)) {
      try {
        temp_url = referer_url.substring(referer_url.indexOf("cooperate_id="), referer_url.length());
        if ((!"".equals(temp_url)) && (temp_url.indexOf("&") > 0)) {
          cooperate_id = Integer.parseInt(temp_url.substring(temp_url.indexOf("cooperate_id=") + 13, temp_url.indexOf("&")));
        } else {
          cooperate_id = Integer.parseInt(temp_url.substring(temp_url.indexOf("cooperate_id=") + 13, temp_url.length()));
        }
      } catch (Exception ex) {
        cooperate_id = 0;
      }
    }
    

    if (cooperate_id == 0)
    {
      String result = getSsoKeyValue("ding9_click_cooperate_id");
      result = result == null ? "0" : result.trim();
      result = "null".equals(result.toLowerCase()) ? "0" : result.trim();
      try {
        cooperate_id = Integer.parseInt(result);
      } catch (Exception ex) { cooperate_id = 0;
      }
    }
    if (cooperate_id > 0) {
      setSsoKeyValue("ding9_click_cooperate_id", String.valueOf(cooperate_id), request);
    }
    return cooperate_id;
  }
  




  private void setSsonKey(String sson_key_name, String sson_key_value)
  {
    try
    {
      int total = this.ssonkeyvalue.length;
      
      ByteBuffer bb = ByteBuffer.allocate(total);
      
      bb = bb.order(ByteOrder.BIG_ENDIAN);
      
      this.ssonkeyvalue = Conversions.wrapByteArray(sson_key_value.getBytes(), 0, this.ssonkeyvalue.length);
      
      bb.put(this.ssonkeyvalue);
      
      byte[] key = bb.array();
      SecureFactory secure = new SecureFactory(this.salt);
      Cookie ssonkey = new Cookie(sson_key_name, 
        Conversions.bytesToHexString(this.salt) + 
        Conversions.bytesToHexString(secure.encrypt(
        key)));
      

      ssonkey.setDomain(String.valueOf(ConfigManager.getProperty("DOMAINNAME")));
      ssonkey.setPath("/");
      this.response.addCookie(ssonkey);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  





  private String getSsonKey(String sson_key_name)
  {
    String result = "";
    
    if ((this.request == null) || (this.salt == null)) {
      return result;
    }
    Cookie[] cookies = this.request.getCookies();
    
    if (cookies == null) {
      return result;
    }
    for (int i = 0; i < cookies.length; i++) {
      if (cookies[i].getName().equals(sson_key_name)) {
        this.ssonkey = cookies[i].getValue();
      }
    }
    
    if ((this.ssonkey == null) || (this.ssonkey.equals("")) || (this.ssonkey.length() < 32) || 
      (this.ssonkey.length() % 2 != 0)) {
      return result;
    }
    
    this.salt = Conversions.hexStringToBytes(this.ssonkey.substring(0, 32));
    
    SecureFactory secure = new SecureFactory(this.salt);
    byte[] key = secure.decrypt(Conversions.hexStringToBytes(
      this.ssonkey
      .substring(32)));
    
    int pos = 0;
    
    ByteBuffer bb = ByteBuffer.wrap(key);
    bb = bb.order(ByteOrder.BIG_ENDIAN);
    
    this.ssonkeyvalue = Conversions.wrapByteArray(key, pos, this.ssonkeyvalue.length);
    
    result = new String(this.ssonkeyvalue);
    result = result == null ? "" : result.trim();
    
    return result;
  }
  



  private String getSsoKeyValue(String sson_key_name)
  {
    String keyvalue = "";
    
    if ((this.request == null) || (this.salt == null)) {
      return keyvalue;
    }
    Cookie[] cookies = this.request.getCookies();
    
    if (cookies == null) {
      return keyvalue;
    }
    for (int i = 0; i < cookies.length; i++) {
      if (cookies[i].getName().equals(sson_key_name)) {
        keyvalue = cookies[i].getValue();
      }
    }
    return keyvalue;
  }
  

  private void setSsoKeyValue(String sson_key_name, String sson_key_value, HttpServletRequest request)
  {
    try
    {
      Cookie[] cookies = request.getCookies();
      if (cookies == null) {
        Cookie ssonkey = new Cookie(sson_key_name, sson_key_value);
        ssonkey.setDomain(String.valueOf(ConfigManager.getProperty("DOMAINNAME")));
        ssonkey.setPath("/");
        this.response.addCookie(ssonkey);
        return;
      }
      int bl = 0;
      for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals(sson_key_name)) {
          Cookie ssonkey = cookies[i];
          ssonkey.setDomain(String.valueOf(ConfigManager.getProperty("DOMAINNAME")));
          ssonkey.setPath("/");
          this.response.addCookie(ssonkey);
          bl = 1;
        }
      }
      if (bl == 0) {
        Cookie ssonkey = new Cookie(sson_key_name, sson_key_value);
        ssonkey.setDomain(String.valueOf(ConfigManager.getProperty("DOMAINNAME")));
        ssonkey.setPath("/");
        this.response.addCookie(ssonkey);
      }
      

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
