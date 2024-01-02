package com.ding9.search.entity.promotion;

import com.ding9.search.util.StringHelper;
import java.util.Date;




























































public class Promotion
{
  private int info_id;
  private int prso_id_one;
  private int prso_id_two;
  private int prso_id_three;
  private String prso_name;
  private int sort_id;
  private String title;
  private String rebate_range;
  private String content;
  private String brand_name;
  private String store_name;
  private String marketplace;
  private String sowntown;
  private Date pub_time;
  private int merc_id;
  private int prma_id;
  private String useful_life;
  private Date out_date;
  private int cooperate_id;
  private String info_source;
  private String source_url;
  private int info_type;
  private String picture;
  private Date begin_date;
  private String prma_name;
  private int coupon_type_id;
  private int shop_id;
  private boolean coupon;
  
  public String getInfo_source()
  {
    return this.info_source;
  }
  
  public void setInfo_source(String info_source) { this.info_source = StringHelper.getRealString(info_source); }
  
  public int getCoupon_type_id() {
    return this.coupon_type_id;
  }
  
  public void setCoupon_type_id(int coupon_type_id) {
    this.coupon_type_id = coupon_type_id;
  }
  
  public int getShop_id() {
    return this.shop_id;
  }
  
  public void setShop_id(int shop_id) {
    this.shop_id = shop_id;
  }
  
  public Date getPub_time() {
    return this.pub_time;
  }
  
  public void setPub_time(Date pub_time) {
    this.pub_time = pub_time;
  }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) {
    this.prma_name = StringHelper.getRealString(prma_name);
  }
  
  public String getBrand_name() {
    return this.brand_name;
  }
  
  public void setBrand_name(String brand_name) {
    this.brand_name = StringHelper.getRealString(brand_name);
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = StringHelper.getRealString(content);
  }
  
  public int getInfo_id() {
    return this.info_id;
  }
  
  public void setInfo_id(int info_id) {
    this.info_id = info_id;
  }
  
  public Date getBegin_date() {
    return this.begin_date;
  }
  
  public void setBegin_date(Date begin_date) { this.begin_date = begin_date; }
  
  public int getCooperate_id() {
    return this.cooperate_id;
  }
  
  public void setCooperate_id(int cooperate_id) { this.cooperate_id = cooperate_id; }
  
  public int getInfo_type() {
    return this.info_type;
  }
  
  public void setInfo_type(int info_type) { this.info_type = info_type; }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) { this.merc_id = merc_id; }
  
  public String getPicture() {
    return this.picture;
  }
  
  public void setPicture(String picture) { this.picture = StringHelper.getRealString(picture); }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) { this.prma_id = prma_id; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public int getPrso_id_three() {
    return this.prso_id_three;
  }
  
  public void setPrso_id_three(int prso_id_three) { this.prso_id_three = prso_id_three; }
  
  public int getPrso_id_two() {
    return this.prso_id_two;
  }
  
  public void setPrso_id_two(int prso_id_two) { this.prso_id_two = prso_id_two; }
  
  public String getPrso_name() {
    return this.prso_name;
  }
  
  public void setPrso_name(String prso_name) { this.prso_name = StringHelper.getRealString(prso_name); }
  
  public String getRebate_range() {
    return this.rebate_range;
  }
  
  public void setRebate_range(String rebate_range) { this.rebate_range = StringHelper.getRealString(rebate_range); }
  
  public String getUseful_life() {
    return this.useful_life;
  }
  
  public void setUseful_life(String useful_life) { this.useful_life = StringHelper.getRealString(useful_life); }
  
  public String getMarketplace() {
    return this.marketplace;
  }
  
  public void setMarketplace(String marketplace) {
    this.marketplace = StringHelper.getRealString(marketplace);
  }
  
  public Date getOut_date() {
    return this.out_date;
  }
  
  public void setOut_date(Date out_date) {
    this.out_date = out_date;
  }
  
  public int getSort_id() {
    return this.sort_id;
  }
  
  public void setSort_id(int sort_id) {
    this.sort_id = sort_id;
  }
  
  public String getSource_url() {
    return this.source_url;
  }
  
  public void setSource_url(String source_url) {
    this.source_url = StringHelper.getRealString(source_url);
  }
  
  public String getSowntown() {
    return this.sowntown;
  }
  
  public void setSowntown(String sowntown) {
    this.sowntown = StringHelper.getRealString(sowntown);
  }
  
  public String getStore_name() {
    return this.store_name;
  }
  
  public void setStore_name(String store_name) {
    this.store_name = StringHelper.getRealString(store_name);
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = StringHelper.getRealString(title);
  }
  
  public boolean isCoupon() {
    return (this.shop_id > 0) && (this.coupon_type_id > 0);
  }
  
  public String getShopName() {
    StringBuffer buffer = new StringBuffer();
    if ((this.sowntown != null) && (this.sowntown.trim().length() > 0)) {
      buffer.append(this.sowntown);
    }
    if ((this.marketplace != null) && (this.marketplace.trim().length() > 0)) {
      buffer.append(this.marketplace);
    }
    
    if ((this.store_name != null) && (this.store_name.trim().length() > 0)) {
      buffer.append(this.store_name);
    }
    
    return buffer.toString();
  }
}
