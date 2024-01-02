package com.ding9.entity.collection;


public class UserTagVO
{
  private int label_id;
  
  private int uslb_id;
  
  private int user_id;
  private int type;
  private String lb_name;
  
  public String getLb_name()
  {
    return this.lb_name;
  }
  
  public void setLb_name(String lb_name) { this.lb_name = lb_name; }
  
  public int getLabel_id() {
    return this.label_id;
  }
  
  public void setLabel_id(int label_id) { this.label_id = label_id; }
  
  public int getUser_id() {
    return this.user_id;
  }
  
  public void setUser_id(int user_id) { this.user_id = user_id; }
  
  public int getUslb_id() {
    return this.uslb_id;
  }
  
  public void setUslb_id(int uslb_id) { this.uslb_id = uslb_id; }
  
  public int getType() {
    return this.type;
  }
  
  public void setType(int type) { this.type = type; }
}
