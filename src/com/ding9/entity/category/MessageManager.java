package com.ding9.entity.category;

import java.sql.Date;





public class MessageManager
{
  private int mema_id;
  private int memt_id;
  private int prso_id;
  private String mema_title;
  private String mema_content;
  private Date mema_time;
  
  public String getMema_content()
  {
    return this.mema_content;
  }
  
  public void setMema_content(String mema_content) { this.mema_content = mema_content; }
  
  public int getMema_id() {
    return this.mema_id;
  }
  
  public void setMema_id(int mema_id) { this.mema_id = mema_id; }
  
  public Date getMema_time() {
    return this.mema_time;
  }
  
  public void setMema_time(Date mema_time) { this.mema_time = mema_time; }
  
  public String getMema_title() {
    return this.mema_title;
  }
  
  public void setMema_title(String mema_title) { this.mema_title = mema_title; }
  
  public int getMemt_id() {
    return this.memt_id;
  }
  
  public void setMemt_id(int memt_id) { this.memt_id = memt_id; }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) { this.prso_id = prso_id; }
}
