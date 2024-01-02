package com.ding9.search.entity.merchant;

import com.ding9.search.util.StringHelper;

public class MerchantProductSale {
  private int prma_id;
  private String mepr_remark = "";
  private float mepr_price;
  private String prma_name = "";
  private int prso_id;
  private String day = "";
  private String time = "";
  private String prac_address = "";
  private String web_address = "";
  
  public float getMepr_price() { return this.mepr_price; }
  
  public void setMepr_price(float mepr_price) {
    this.mepr_price = mepr_price;
  }
  
  public String getMepr_remark() { return this.mepr_remark; }
  
  public void setMepr_remark(String mepr_remark) {
    this.mepr_remark = StringHelper.getRealString(mepr_remark);
  }
  
  public String getDay() { return this.day; }
  
  public void setDay(String day) {
    this.day = day;
  }
  
  public String getTime() { return this.time; }
  
  public void setTime(String time) {
    this.time = time;
  }
  
  public String getPrac_address() { return this.prac_address; }
  
  public void setPrac_address(String prac_address) {
    this.prac_address = StringHelper.getRealString(prac_address);
  }
  
  public int getPrma_id() { return this.prma_id; }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public String getPrma_name() { return this.prma_name; }
  
  public void setPrma_name(String prma_name) {
    this.prma_name = StringHelper.getRealString(prma_name);
  }
  
  public int getPrso_id() { return this.prso_id; }
  
  public void setPrso_id(int prso_id) {
    this.prso_id = prso_id;
  }
  
  public String getWeb_address() { return this.web_address; }
  
  public void setWeb_address(String web_address) {
    this.web_address = StringHelper.getRealString(web_address);
  }
}
