package com.ding9.click.entity.accesslog.impl;

import com.ding9.click.entity.accesslog.IBLAccessLogData;












public class BLAccessLogData
  implements IBLAccessLogData
{
  private int bl_id;
  private int cooperate_id;
  private int vipbl_id;
  private String access_date = "";
  private String remote_addr = "";
  private String remote_user = "";
  private String http_method = "";
  private String request_protocol = "";
  private String request_scheme = "";
  private int response_result = 200;
  private String request_server = "";
  private String request_port = "";
  private String request_uri = "";
  private String request_querystr = "";
  private String accept_type = "";
  private String referer_url = "";
  private String referer_host = "";
  private String referer_querystr = "";
  private String user_agent = "";
  private String init_referer_url = "";
  private String init_referer_host = "";
  private String session_id = "";
  private String cookie_id = "";
  
  private int is_spider;
  
  private int is_firstlog;
  

  public String getAccept_type()
  {
    return this.accept_type;
  }
  



  public void setAccept_type(String accept_type)
  {
    this.accept_type = (accept_type == null ? "" : accept_type.trim());
  }
  



  public String getAccess_date()
  {
    return this.access_date;
  }
  



  public void setAccess_date(String access_date)
  {
    this.access_date = (access_date == null ? "" : access_date.trim());
  }
  



  public int getBl_id()
  {
    return this.bl_id;
  }
  



  public void setBl_id(int bl_id)
  {
    this.bl_id = bl_id;
  }
  



  public String getCookie_id()
  {
    return this.cookie_id;
  }
  



  public void setCookie_id(String cookie_id)
  {
    this.cookie_id = (cookie_id == null ? "" : cookie_id.trim());
  }
  



  public int getCooperate_id()
  {
    return this.cooperate_id;
  }
  



  public void setCooperate_id(int cooperate_id)
  {
    this.cooperate_id = cooperate_id;
  }
  



  public String getHttp_method()
  {
    return this.http_method;
  }
  



  public void setHttp_method(String http_method)
  {
    this.http_method = (http_method == null ? "" : http_method.trim());
  }
  



  public String getInit_referer_host()
  {
    return this.init_referer_host;
  }
  



  public void setInit_referer_host(String init_referer_host)
  {
    this.init_referer_host = (init_referer_host == null ? "" : init_referer_host.trim());
  }
  



  public String getInit_referer_url()
  {
    return this.init_referer_url;
  }
  



  public void setInit_referer_url(String init_referer_url)
  {
    this.init_referer_url = (init_referer_url == null ? "" : init_referer_url.trim());
  }
  



  public int getIs_firstlog()
  {
    return this.is_firstlog;
  }
  



  public void setIs_firstlog(int is_firstlog)
  {
    this.is_firstlog = is_firstlog;
  }
  



  public int getIs_spider()
  {
    return this.is_spider;
  }
  



  public void setIs_spider(int is_spider)
  {
    this.is_spider = is_spider;
  }
  



  public String getReferer_host()
  {
    return this.referer_host;
  }
  



  public void setReferer_host(String referer_host)
  {
    this.referer_host = (referer_host == null ? "" : referer_host.trim());
  }
  



  public String getReferer_querystr()
  {
    return this.referer_querystr;
  }
  



  public void setReferer_querystr(String referer_querystr)
  {
    this.referer_querystr = (referer_querystr == null ? "" : referer_querystr.trim());
  }
  



  public String getReferer_url()
  {
    return this.referer_url;
  }
  



  public void setReferer_url(String referer_url)
  {
    this.referer_url = (referer_url == null ? "" : referer_url.trim());
  }
  



  public String getRemote_addr()
  {
    return this.remote_addr;
  }
  



  public void setRemote_addr(String remote_addr)
  {
    this.remote_addr = (remote_addr == null ? "" : remote_addr.trim());
  }
  



  public String getRemote_user()
  {
    return this.remote_user;
  }
  



  public void setRemote_user(String remote_user)
  {
    this.remote_user = (remote_user == null ? "" : remote_user.trim());
  }
  



  public String getRequest_port()
  {
    return this.request_port;
  }
  



  public void setRequest_port(String request_port)
  {
    this.request_port = (request_port == null ? "80" : request_port.trim());
  }
  



  public String getRequest_protocol()
  {
    return this.request_protocol;
  }
  



  public void setRequest_protocol(String request_protocol)
  {
    this.request_protocol = (request_protocol == null ? "" : request_protocol.trim());
  }
  



  public String getRequest_querystr()
  {
    return this.request_querystr;
  }
  



  public void setRequest_querystr(String request_querystr)
  {
    this.request_querystr = (request_querystr == null ? "" : request_querystr.trim());
  }
  



  public String getRequest_scheme()
  {
    return this.request_scheme;
  }
  



  public void setRequest_scheme(String request_scheme)
  {
    this.request_scheme = (request_scheme == null ? "" : request_scheme.trim());
  }
  



  public String getRequest_server()
  {
    return this.request_server;
  }
  



  public void setRequest_server(String request_server)
  {
    this.request_server = (request_server == null ? "" : request_server.trim());
  }
  



  public String getRequest_uri()
  {
    return this.request_uri;
  }
  



  public void setRequest_uri(String request_uri)
  {
    this.request_uri = (request_uri == null ? "" : request_uri.trim());
  }
  



  public int getResponse_result()
  {
    return this.response_result;
  }
  



  public void setResponse_result(int response_result)
  {
    this.response_result = response_result;
  }
  



  public String getSession_id()
  {
    return this.session_id;
  }
  



  public void setSession_id(String session_id)
  {
    this.session_id = (session_id == null ? "" : session_id.trim());
  }
  



  public String getUser_agent()
  {
    return this.user_agent;
  }
  



  public void setUser_agent(String user_agent)
  {
    this.user_agent = (user_agent == null ? "" : user_agent.trim());
  }
  



  public int getVipbl_id()
  {
    return this.vipbl_id;
  }
  



  public void setVipbl_id(int vipbl_id)
  {
    this.vipbl_id = vipbl_id;
  }
}
