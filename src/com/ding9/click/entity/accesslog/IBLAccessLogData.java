package com.ding9.click.entity.accesslog;

public abstract interface IBLAccessLogData
{
  public abstract String getAccept_type();
  
  public abstract void setAccept_type(String paramString);
  
  public abstract String getAccess_date();
  
  public abstract void setAccess_date(String paramString);
  
  public abstract int getBl_id();
  
  public abstract void setBl_id(int paramInt);
  
  public abstract String getCookie_id();
  
  public abstract void setCookie_id(String paramString);
  
  public abstract int getCooperate_id();
  
  public abstract void setCooperate_id(int paramInt);
  
  public abstract String getHttp_method();
  
  public abstract void setHttp_method(String paramString);
  
  public abstract String getInit_referer_host();
  
  public abstract void setInit_referer_host(String paramString);
  
  public abstract String getInit_referer_url();
  
  public abstract void setInit_referer_url(String paramString);
  
  public abstract int getIs_firstlog();
  
  public abstract void setIs_firstlog(int paramInt);
  
  public abstract int getIs_spider();
  
  public abstract void setIs_spider(int paramInt);
  
  public abstract String getReferer_host();
  
  public abstract void setReferer_host(String paramString);
  
  public abstract String getReferer_querystr();
  
  public abstract void setReferer_querystr(String paramString);
  
  public abstract String getReferer_url();
  
  public abstract void setReferer_url(String paramString);
  
  public abstract String getRemote_addr();
  
  public abstract void setRemote_addr(String paramString);
  
  public abstract String getRemote_user();
  
  public abstract void setRemote_user(String paramString);
  
  public abstract String getRequest_port();
  
  public abstract void setRequest_port(String paramString);
  
  public abstract String getRequest_protocol();
  
  public abstract void setRequest_protocol(String paramString);
  
  public abstract String getRequest_querystr();
  
  public abstract void setRequest_querystr(String paramString);
  
  public abstract String getRequest_scheme();
  
  public abstract void setRequest_scheme(String paramString);
  
  public abstract String getRequest_server();
  
  public abstract void setRequest_server(String paramString);
  
  public abstract String getRequest_uri();
  
  public abstract void setRequest_uri(String paramString);
  
  public abstract int getResponse_result();
  
  public abstract void setResponse_result(int paramInt);
  
  public abstract String getSession_id();
  
  public abstract void setSession_id(String paramString);
  
  public abstract String getUser_agent();
  
  public abstract void setUser_agent(String paramString);
  
  public abstract int getVipbl_id();
  
  public abstract void setVipbl_id(int paramInt);
}
