package com.ding9.multipleentity;

public class MerchantProduct {
  private int mepr_id;
  private int prma_id;
  private int prso_id;
  private int merc_id;
  private float mepr_price;
  private float mepr_weight;
  private String prma_name;
  private String mepr_remark;
  private String mepr_contect;
  private String mepr_web_address;
  private String mepr_address;
  
  public String getMepr_address() {
    return this.mepr_address;
  }
  
  public void setMepr_address(String mepr_address) { this.mepr_address = mepr_address; }
  
  public String getMepr_contect() {
    return this.mepr_contect;
  }
  
  public void setMepr_contect(String mepr_contect) { this.mepr_contect = mepr_contect; }
  
  public int getMepr_id() {
    return this.mepr_id;
  }
  
  public void setMepr_id(int mepr_id) { this.mepr_id = mepr_id; }
  
  public float getMepr_price() {
    return this.mepr_price;
  }
  
  public void setMepr_price(float mepr_price) { this.mepr_price = mepr_price; }
  
  public String getMepr_remark() {
    return this.mepr_remark;
  }
  
  public void setMepr_remark(String mepr_remark) { this.mepr_remark = mepr_remark; }
  
  public String getMepr_web_address() {
    return this.mepr_web_address;
  }
  
  public void setMepr_web_address(String mepr_web_address) { this.mepr_web_address = mepr_web_address; }
  
  public float getMepr_weight() {
    return this.mepr_weight;
  }
  
  public void setMepr_weight(float mepr_weight) { this.mepr_weight = mepr_weight; }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) { this.merc_id = merc_id; }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) { this.prma_id = prma_id; }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) { this.prma_name = prma_name; }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) { this.prso_id = prso_id; }
}
