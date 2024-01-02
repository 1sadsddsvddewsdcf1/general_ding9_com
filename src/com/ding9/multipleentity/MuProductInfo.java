package com.ding9.multipleentity;

public class MuProductInfo {
  private String web_address;
  private String prac_address;
  private String prma_remark;
  private String prma_name;
  private float min_price;
  private float max_price;
  private int merchant_count;
  private int comment_count;
  private int product_level;
  private int prma_id;
  private int prbr_id;
  private int prso_id;
  private String picno2;
  private String piclarge;
  
  public String getPiclarge() {
    return this.piclarge;
  }
  
  public void setPiclarge(String piclarge) { this.piclarge = piclarge; }
  
  public String getPicno2() {
    return this.picno2;
  }
  
  public void setPicno2(String picno2) { this.picno2 = picno2; }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) { this.prso_id = prso_id; }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) { this.prma_id = prma_id; }
  
  public String getPrac_address() {
    return this.prac_address;
  }
  
  public int getComment_count() { return this.comment_count; }
  
  public void setComment_count(int comment_count) {
    this.comment_count = comment_count;
  }
  
  public float getMax_price() { return this.max_price; }
  
  public void setMax_price(float max_price) {
    this.max_price = max_price;
  }
  
  public int getMerchant_count() { return this.merchant_count; }
  
  public void setMerchant_count(int merchant_count) {
    this.merchant_count = merchant_count;
  }
  
  public float getMin_price() { return this.min_price; }
  
  public void setMin_price(float min_price) {
    this.min_price = min_price;
  }
  
  public int getProduct_level() { return this.product_level; }
  
  public void setProduct_level(int product_level) {
    this.product_level = product_level;
  }
  
  public void setPrac_address(String prac_address) { this.prac_address = prac_address; }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) { this.prma_name = prma_name; }
  
  public String getPrma_remark() {
    return this.prma_remark;
  }
  
  public void setPrma_remark(String prma_remark) { this.prma_remark = prma_remark; }
  
  public String getWeb_address() {
    return this.web_address;
  }
  
  public void setWeb_address(String web_address) { this.web_address = web_address; }
  
  public int getPrbr_id() {
    return this.prbr_id;
  }
  
  public void setPrbr_id(int prbr_id) { this.prbr_id = prbr_id; }
}
