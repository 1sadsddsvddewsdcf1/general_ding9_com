package com.ding9.entity.message;

public class Credit {
  private int cocr_id;
  private int user_id;
  private int cogr_credit;
  private int orde_id;
  private String cocr_reason;
  private String cocr_time;
  private String name;
  
  public int getCocr_id() { return this.cocr_id; }
  
  public void setCocr_id(int cocr_id) {
    this.cocr_id = cocr_id;
  }
  
  public String getCocr_reason() { return this.cocr_reason; }
  
  public void setCocr_reason(String cocr_reason) {
    this.cocr_reason = cocr_reason;
  }
  
  public String getCocr_time() { return this.cocr_time; }
  
  public void setCocr_time(String cocr_time) {
    this.cocr_time = cocr_time;
  }
  
  public int getCogr_credit() { return this.cogr_credit; }
  
  public void setCogr_credit(int cogr_credit) {
    this.cogr_credit = cogr_credit;
  }
  
  public String getName() { return this.name; }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getOrde_id() { return this.orde_id; }
  
  public void setOrde_id(int orde_id) {
    this.orde_id = orde_id;
  }
  
  public int getUser_id() { return this.user_id; }
  
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
}
