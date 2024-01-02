package com.ding9.entity.category;

import java.sql.Date;









public class CheapCard
{
  private int chca_id;
  private int merc_id;
  private int prso_id_one;
  private String chca_pic;
  private String chca_title;
  private String chca_remark;
  private Date end_time;
  private String chca_url;
  private Date chca_time;
  
  public int getChca_id()
  {
    return this.chca_id;
  }
  
  public void setChca_id(int chca_id) { this.chca_id = chca_id; }
  
  public String getChca_pic() {
    return this.chca_pic;
  }
  
  public void setChca_pic(String chca_pic) { this.chca_pic = chca_pic; }
  
  public String getChca_remark() {
    return this.chca_remark;
  }
  
  public void setChca_remark(String chca_remark) { this.chca_remark = chca_remark; }
  
  public Date getChca_time() {
    return this.chca_time;
  }
  
  public void setChca_time(Date chca_time) { this.chca_time = chca_time; }
  
  public String getChca_title() {
    return this.chca_title;
  }
  
  public void setChca_title(String chca_title) { this.chca_title = chca_title; }
  
  public String getChca_url() {
    return this.chca_url;
  }
  
  public void setChca_url(String chca_url) { this.chca_url = chca_url; }
  
  public Date getEnd_time() {
    return this.end_time;
  }
  
  public void setEnd_time(Date end_time) { this.end_time = end_time; }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) { this.merc_id = merc_id; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
}
