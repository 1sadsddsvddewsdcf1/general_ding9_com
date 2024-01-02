package com.ding9.entity.comment;

public class MessageRestore
{
  private int mere_id;
  private int mema_id;
  private int user_id;
  private String mere_content;
  private String mere_time;
  private String user_name;
  
  public int getMema_id() {
    return this.mema_id;
  }
  
  public void setMema_id(int mema_id) {
    this.mema_id = mema_id;
  }
  
  public String getMere_content() {
    return this.mere_content;
  }
  
  public void setMere_content(String mere_content) {
    this.mere_content = mere_content;
  }
  
  public int getMere_id() {
    return this.mere_id;
  }
  
  public void setMere_id(int mere_id) {
    this.mere_id = mere_id;
  }
  
  public String getMere_time() {
    return this.mere_time;
  }
  
  public void setMere_time(String mere_time) {
    this.mere_time = mere_time;
  }
  
  public int getUser_id() {
    return this.user_id;
  }
  
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  
  public String getUser_name() {
    return this.user_name;
  }
  
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }
}
