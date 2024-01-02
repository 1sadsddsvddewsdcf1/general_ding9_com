package com.ding9.search.entity.merchant;

import com.ding9.search.util.StringHelper;

public class MerchantProductMaster {
  private int prma_id;
  private String mepr_remark = "";
  private float mepr_price;
  private String prma_name = "";
  private int prso_id;
  private float min_price;
  private int merchant_count;
  private int comment_count;
  private int product_level;
  private String prac_address = "";
  private String web_address = "";
  
  public String getPrac_address() { return this.prac_address; }
  
  public void setPrac_address(String prac_address) {
    this.prac_address = StringHelper.getRealString(prac_address);
  }
  
  public String getWeb_address() { return this.web_address; }
  
  public void setWeb_address(String web_address) {
    this.web_address = StringHelper.getRealString(web_address);
  }
  
  public int getComment_count() { return this.comment_count; }
  
  public void setComment_count(int comment_count) {
    this.comment_count = comment_count;
  }
  
  public float getMepr_price() { return this.mepr_price; }
  
  public void setMepr_price(float mepr_price) {
    this.mepr_price = mepr_price;
  }
  
  public String getMepr_remark() { return this.mepr_remark; }
  
  public void setMepr_remark(String mepr_remark) {
    this.mepr_remark = StringHelper.getRealString(mepr_remark);
  }
  
  public int getMerchant_count() { return this.merchant_count; }
  
  public void setMerchant_count(int merchant_count) {
    this.merchant_count = merchant_count;
  }
  
  public float getMin_price() { return this.min_price; }
  
  public void setMin_price(float min_price) {
    this.min_price = min_price;
  }
  
  public int getPrma_id() { return this.prma_id; }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public String getPrma_name() { return this.prma_name; }
  
  public void setPrma_name(String prma_name) {
    this.prma_name = StringHelper.getRealString(prma_name);
  }
  
  public int getProduct_level() { return this.product_level; }
  
  public void setProduct_level(int product_level) {
    this.product_level = product_level;
  }
  
  public int getPrso_id() { return this.prso_id; }
  
  public void setPrso_id(int prso_id) {
    this.prso_id = prso_id;
  }
}
