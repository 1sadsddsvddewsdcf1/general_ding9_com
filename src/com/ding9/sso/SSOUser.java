package com.ding9.sso;

import java.sql.Timestamp;
import java.util.Date;











public class SSOUser
{
  private int userId;
  private String username;
  private String password;
  private String rememberMe;
  private Timestamp lastLoginTime;
  
  public int getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(int userId) {
    this.userId = userId;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String email) { this.password = email; }
  
  public String getUsername() {
    return this.username;
  }
  
  public void setUsername(String username) { this.username = username; }
  
  public Date getLastLoginTime() {
    return this.lastLoginTime;
  }
  
  public void setLastLoginTime(Timestamp lastLoginTime) { this.lastLoginTime = lastLoginTime; }
  
  public String getRememberMe()
  {
    return this.rememberMe;
  }
  
  public void setRememberMe(String rememberMe) {
    this.rememberMe = rememberMe;
  }
}
