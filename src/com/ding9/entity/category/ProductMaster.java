package com.ding9.entity.category;

import java.util.List;



public class ProductMaster
{
  private int prma_id;
  private int prso_id;
  private int prbr_id;
  private int prma_sum;
  private int prma_visit;
  private int prma_sell;
  private int prma_new;
  private int prma_cheap;
  private String prma_name;
  private String prma_mpm;
  private String prma_upc;
  private String prma_remark;
  private String web_address;
  private String prac_address;
  private List merchant_product;
  private List all_merchant_product;
  private int all_merchant_product_qty;
  private List message_manage;
  private int message_manage_qty;
  private float min_mepr_price;
  private int merc_id;
  private List newProductNews;
  
  public int getMerc_id()
  {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) { this.merc_id = merc_id; }
  
  public float getMin_mepr_price() {
    return this.min_mepr_price;
  }
  
  public void setMin_mepr_price(float min_mepr_price) { this.min_mepr_price = min_mepr_price; }
  
  public List getAll_merchant_product() {
    return this.all_merchant_product;
  }
  
  public void setAll_merchant_product(List all_merchant_product) { this.all_merchant_product = all_merchant_product; }
  
  public String getPrac_address() {
    return this.prac_address;
  }
  
  public void setPrac_address(String prac_address) { this.prac_address = prac_address; }
  
  public String getWeb_address() {
    return this.web_address;
  }
  
  public void setWeb_address(String web_address) { this.web_address = web_address; }
  
  public int getPrbr_id() {
    return this.prbr_id;
  }
  
  public void setPrbr_id(int prbr_id) { this.prbr_id = prbr_id; }
  
  public int getPrma_cheap() {
    return this.prma_cheap;
  }
  
  public void setPrma_cheap(int prma_cheap) { this.prma_cheap = prma_cheap; }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) { this.prma_id = prma_id; }
  
  public String getPrma_mpm() {
    return this.prma_mpm;
  }
  
  public void setPrma_mpm(String prma_mpm) { this.prma_mpm = prma_mpm; }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) { this.prma_name = prma_name; }
  
  public int getPrma_new() {
    return this.prma_new;
  }
  
  public void setPrma_new(int prma_new) { this.prma_new = prma_new; }
  
  public String getPrma_remark() {
    return this.prma_remark;
  }
  
  public void setPrma_remark(String prma_remark) { this.prma_remark = prma_remark; }
  
  public int getPrma_sell() {
    return this.prma_sell;
  }
  
  public void setPrma_sell(int prma_sell) { this.prma_sell = prma_sell; }
  
  public int getPrma_sum() {
    return this.prma_sum;
  }
  
  public void setPrma_sum(int prma_sum) { this.prma_sum = prma_sum; }
  
  public String getPrma_upc() {
    return this.prma_upc;
  }
  
  public void setPrma_upc(String prma_upc) { this.prma_upc = prma_upc; }
  
  public int getPrma_visit() {
    return this.prma_visit;
  }
  
  public void setPrma_visit(int prma_visit) { this.prma_visit = prma_visit; }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) { this.prso_id = prso_id; }
  
  public List getMerchant_product() {
    return this.merchant_product;
  }
  
  public void setMerchant_product(List merchant_product) { this.merchant_product = merchant_product; }
  
  public int getAll_merchant_product_qty() {
    return this.all_merchant_product_qty;
  }
  
  public void setAll_merchant_product_qty(int all_merchant_product_qty) { this.all_merchant_product_qty = all_merchant_product_qty; }
  
  public List getMessage_manage() {
    return this.message_manage;
  }
  
  public void setMessage_manage(List message_manage) { this.message_manage = message_manage; }
  
  public int getMessage_manage_qty() {
    return this.message_manage_qty;
  }
  
  public void setMessage_manage_qty(int message_manage_qty) { this.message_manage_qty = message_manage_qty; }
  
  public List getNewProductNews() {
    return this.newProductNews;
  }
  
  public void setNewProductNews(List newProductNews) { this.newProductNews = newProductNews; }
}
