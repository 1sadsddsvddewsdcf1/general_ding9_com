package com.ding9.action.logon;

import org.apache.struts.action.ActionForm;

public class LogonForm extends ActionForm
{
  private static final long serialVersionUID = 1431968464552779682L;
  private int user_id;
  private String username;
  private String password;
  private String pwd;
  private String user_email;
  private long user_sn;
  private boolean rememberMe;
  
  public LogonForm()
  {
    this.username = "";
    this.password = "";
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String pass) { this.password = pass; }
  
  public String getUsername() {
    return this.username;
  }
  
  public void setUsername(String userName) { this.username = userName; }
  






  public boolean isRememberMe()
  {
    return this.rememberMe;
  }
  
  public void setRememberMe(boolean rememberMe) {
    this.rememberMe = rememberMe;
  }
  
  public String getUser_email() {
    return this.user_email;
  }
  
  public void setUser_email(String user_email) {
    this.user_email = user_email;
  }
  
  public long getUser_sn() {
    return this.user_sn;
  }
  
  public void setUser_sn(long user_sn) {
    this.user_sn = user_sn;
  }
  
  public int getUser_id() {
    return this.user_id;
  }
  
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  
  public String getPwd() {
    return this.pwd;
  }
  
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
}
