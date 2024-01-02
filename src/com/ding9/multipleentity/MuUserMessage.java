package com.ding9.multipleentity;

import java.util.List;



public class MuUserMessage
{
  private String user_name;
  private String user_date_reg;
  private String mema_title;
  private String mema_content;
  private String mema_defect;
  private String mema_merit;
  private String mema_time;
  private String url;
  private String author_name;
  private String source;
  private int mema_id;
  private List restore;
  private String count = "0";
  
  public String getCount() {
    return this.count;
  }
  
  public void setCount(String count) { this.count = count; }
  
  public List getRestore() {
    return this.restore;
  }
  
  public void setRestore(List restore) { this.restore = restore; }
  
  public String getMema_content() {
    return this.mema_content;
  }
  
  public void setMema_content(String mema_content) { this.mema_content = mema_content; }
  
  public String getMema_defect() {
    return this.mema_defect;
  }
  
  public void setMema_defect(String mema_defect) { this.mema_defect = mema_defect; }
  
  public String getMema_merit() {
    return this.mema_merit;
  }
  
  public void setMema_merit(String mema_merit) { this.mema_merit = mema_merit; }
  
  public String getMema_time() {
    return this.mema_time;
  }
  
  public void setMema_time(String mema_time) { this.mema_time = mema_time; }
  
  public String getMema_title() {
    return this.mema_title;
  }
  
  public void setMema_title(String mema_title) { this.mema_title = mema_title; }
  
  public String getUser_date_reg() {
    return this.user_date_reg;
  }
  
  public void setUser_date_reg(String user_date_reg) { this.user_date_reg = user_date_reg; }
  
  public String getUser_name() {
    return this.user_name;
  }
  
  public void setUser_name(String user_name) { this.user_name = user_name; }
  
  public int getMema_id() {
    return this.mema_id;
  }
  
  public void setMema_id(int mema_id) { this.mema_id = mema_id; }
  
  public String getSource() {
    return this.source;
  }
  
  public void setSource(String source) { this.source = source; }
  
  public String getUrl() {
    return this.url;
  }
  
  public void setUrl(String url) { this.url = url; }
  
  public String getAuthor_name() {
    return this.author_name;
  }
  
  public void setAuthor_name(String author_name) { this.author_name = author_name; }
}
