package com.ding9.entity.collection;

import java.util.Date;













public class CollectionVO
{
  private int uscl_id;
  private int uslb_id;
  private int user_id;
  private int collection_type;
  private int collection_id;
  private String collection_url;
  private String remark;
  private Date collection_date;
  private String title;
  private String tag;
  private String logo;
  private int min_price;
  private int merchant_count;
  private int product_level;
  private String local_address;
  private String lb_name;
  
  public Date getCollection_date()
  {
    return this.collection_date;
  }
  
  public void setCollection_date(Date collection_date) { this.collection_date = collection_date; }
  
  public int getCollection_id() {
    return this.collection_id;
  }
  
  public void setCollection_id(int collection_id) { this.collection_id = collection_id; }
  
  public int getCollection_type() {
    return this.collection_type;
  }
  
  public void setCollection_type(int collection_type) { this.collection_type = collection_type; }
  
  public String getCollection_url() {
    return this.collection_url;
  }
  
  public void setCollection_url(String collection_url) { this.collection_url = collection_url; }
  
  public String getRemark() {
    return this.remark;
  }
  
  public void setRemark(String remark) { this.remark = remark; }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) { this.title = title; }
  
  public int getUscl_id() {
    return this.uscl_id;
  }
  
  public void setUscl_id(int uscl_id) { this.uscl_id = uscl_id; }
  
  public int getUser_id() {
    return this.user_id;
  }
  
  public void setUser_id(int user_id) { this.user_id = user_id; }
  
  public int getUslb_id() {
    return this.uslb_id;
  }
  
  public void setUslb_id(int uslb_id) { this.uslb_id = uslb_id; }
  
  public String getLb_name() {
    return this.lb_name;
  }
  
  public void setLb_name(String lb_name) { this.lb_name = lb_name; }
  
  public String getLogo() {
    return this.logo;
  }
  
  public void setLogo(String logo) { this.logo = logo; }
  
  public String getLocal_address() {
    return this.local_address;
  }
  
  public void setLocal_address(String local_address) { this.local_address = local_address; }
  
  public int getMerchant_count() {
    return this.merchant_count;
  }
  
  public void setMerchant_count(int merchant_count) { this.merchant_count = merchant_count; }
  
  public int getMin_price() {
    return this.min_price;
  }
  
  public void setMin_price(int min_price) { this.min_price = min_price; }
  
  public int getProduct_level() {
    return this.product_level;
  }
  
  public void setProduct_level(int product_level) { this.product_level = product_level; }
  
  public String getTag() {
    return this.tag;
  }
  
  public void setTag(String tag) { this.tag = tag; }
}
