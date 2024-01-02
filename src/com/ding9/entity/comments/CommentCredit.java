package com.ding9.entity.comments;

public class CommentCredit
{
  int cocr_id;
  String merc_com_name;
  String cocr_reason;
  String cocr_time;
  
  public int getCocr_id()
  {
    return this.cocr_id;
  }
  
  public void setCocr_id(int cocr_id) { this.cocr_id = cocr_id; }
  
  public String getCocr_reason() {
    return this.cocr_reason;
  }
  
  public void setCocr_reason(String cocr_reason) { this.cocr_reason = cocr_reason; }
  
  public String getCocr_time() {
    return this.cocr_time;
  }
  
  public void setCocr_time(String cocr_time) { this.cocr_time = cocr_time; }
  
  public String getMerc_com_name() {
    return this.merc_com_name;
  }
  
  public void setMerc_com_name(String merc_com_name) { this.merc_com_name = merc_com_name; }
}
