package com.ding9.entity.category;

import java.sql.Date;

public class RecommendMerchantInfo
{
  private int info_id;
  private int recom_type;
  private int sequence_number;
  private int merc_id;
  private int syus_id;
  private String mere_logo;
  private String mere_name;
  private String mere_adress;
  private Date mere_time;
  
  public int getInfo_id() {
    return this.info_id;
  }
  
  public void setInfo_id(int info_id) { this.info_id = info_id; }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) { this.merc_id = merc_id; }
  
  public String getMere_adress() {
    return this.mere_adress;
  }
  
  public void setMere_adress(String mere_adress) { this.mere_adress = mere_adress; }
  
  public String getMere_logo() {
    return this.mere_logo;
  }
  
  public void setMere_logo(String mere_logo) { this.mere_logo = mere_logo; }
  
  public String getMere_name() {
    return this.mere_name;
  }
  
  public void setMere_name(String mere_name) { this.mere_name = mere_name; }
  
  public Date getMere_time() {
    return this.mere_time;
  }
  
  public void setMere_time(Date mere_time) { this.mere_time = mere_time; }
  
  public int getRecom_type() {
    return this.recom_type;
  }
  
  public void setRecom_type(int recom_type) { this.recom_type = recom_type; }
  
  public int getSequence_number() {
    return this.sequence_number;
  }
  
  public void setSequence_number(int sequence_number) { this.sequence_number = sequence_number; }
  
  public int getSyus_id() {
    return this.syus_id;
  }
  
  public void setSyus_id(int syus_id) { this.syus_id = syus_id; }
}
