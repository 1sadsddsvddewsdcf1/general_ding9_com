package com.ding9.entity.comment;

public class MerchantComment {
  private int auto_id;
  private int merc_id;
  private int user_id;
  private int click_y;
  private int click_n;
  private int cocr_id;
  
  public int getAuto_id() { return this.auto_id; }
  
  public void setAuto_id(int auto_id) {
    this.auto_id = auto_id;
  }
  
  public int getClick_n() { return this.click_n; }
  
  public void setClick_n(int click_n) {
    this.click_n = click_n;
  }
  
  public int getClick_y() { return this.click_y; }
  
  public void setClick_y(int click_y) {
    this.click_y = click_y;
  }
  
  public int getCocr_id() { return this.cocr_id; }
  
  public void setCocr_id(int cocr_id) {
    this.cocr_id = cocr_id;
  }
  
  public int getMerc_id() { return this.merc_id; }
  
  public void setMerc_id(int merc_id) {
    this.merc_id = merc_id;
  }
  
  public int getUser_id() { return this.user_id; }
  
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
}
