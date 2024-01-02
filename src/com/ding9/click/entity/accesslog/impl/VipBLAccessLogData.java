package com.ding9.click.entity.accesslog.impl;

import com.ding9.click.entity.accesslog.IVipBLAccessLogData;












public class VipBLAccessLogData
  implements IVipBLAccessLogData
{
  private int bl_id;
  private int cooperate_id = 0;
  private int vipbl_id = 0;
  private int is_payclick = 0;
  private int action_price;
  private String access_date = "";
  private String remote_addr = "";
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
  private int is_spider = 0;
  private String user_id = "";
  private int linked_id = 0;
  private int prso_id_one = 0;
  private int prso_id_two = 0;
  private int prso_id_three = 0;
  private String type = "null";
  
  private int adad_id = 0;
  
  private int adv_id = 0;
  
  private int merc_id = 0;
  private int mepr_id = 0;
  private int prma_id = 0;
  private String target_url = "";
  private String jump_url = "";
  




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
  



  public String getRequest_port()
  {
    return this.request_port;
  }
  



  public void setRequest_port(String request_port)
  {
    this.request_port = (request_port == null ? "80" : request_port.trim());
  }
  



  public String getRequest_querystr()
  {
    return this.request_querystr;
  }
  



  public void setRequest_querystr(String request_querystr)
  {
    this.request_querystr = (request_querystr == null ? "" : request_querystr.trim());
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
  



  public int getAction_price()
  {
    return this.action_price;
  }
  



  public void setAction_price(int action_price)
  {
    this.action_price = action_price;
  }
  



  public int getIs_payclick()
  {
    return this.is_payclick;
  }
  



  public void setIs_payclick(int is_payclick)
  {
    this.is_payclick = is_payclick;
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
  
  public int getAdad_id() {
    return this.adad_id;
  }
  
  public void setAdad_id(int adad_id) {
    this.adad_id = adad_id;
  }
  
  public int getAdv_id() {
    return this.adv_id;
  }
  
  public void setAdv_id(int adv_id) {
    this.adv_id = adv_id;
  }
  
  public String getJump_url() {
    return this.jump_url;
  }
  
  public void setJump_url(String jump_url) {
    this.jump_url = jump_url;
  }
  
  public int getMepr_id() {
    return this.mepr_id;
  }
  
  public void setMepr_id(int mepr_id) {
    this.mepr_id = mepr_id;
  }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) {
    this.merc_id = merc_id;
  }
  
  public String getTarget_url() { return this.target_url; }
  
  public void setTarget_url(String target_url)
  {
    this.target_url = target_url;
  }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public int getPrso_id_three() {
    return this.prso_id_three;
  }
  
  public void setPrso_id_three(int prso_id_three) {
    this.prso_id_three = prso_id_three;
  }
  
  public int getPrso_id_two() {
    return this.prso_id_two;
  }
  
  public void setPrso_id_two(int prso_id_two) {
    this.prso_id_two = prso_id_two;
  }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public String getType() {
    return this.type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public int getLinked_id() {
    return this.linked_id;
  }
  
  public void setLinked_id(int linked_id) {
    this.linked_id = linked_id;
  }
  
  public String getUser_id() {
    return this.user_id;
  }
  
  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }
}
