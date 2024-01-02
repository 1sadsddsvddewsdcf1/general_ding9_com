package com.ding9.search.entity.cheapcard;

import com.ding9.search.util.StringHelper;
import java.util.Date;










public class CheapCard
{
  private int chca_id;
  private int merc_id;
  private int prso_id_one;
  private String chca_pic = "";
  

  private String chca_title = "";
  

  private String chca_remark = "";
  

  private Date end_time;
  

  private String chca_url = "";
  

  private Date chca_time;
  

  private String info_source = "";
  

  private String useful_life = "";
  

  private int sort_id;
  

  private int cooperate_id;
  

  private String brand_name = "";
  

  private String store_name = "";
  

  private String marketplace = "";
  

  private String sowntown = "";
  

  private String sort_name = "";
  

  private int recommend_sort_id;
  

  private String recommend_sort_name = "";
  
  public String getInfo_source()
  {
    return this.info_source;
  }
  
  public void setInfo_source(String info_source) {
    this.info_source = StringHelper.getRealString(info_source);
  }
  
  public String getBrand_name() {
    return this.brand_name;
  }
  
  public void setBrand_name(String brand_name) {
    this.brand_name = StringHelper.getRealString(brand_name);
  }
  
  public int getChca_id() {
    return this.chca_id;
  }
  
  public void setChca_id(int chca_id) {
    this.chca_id = chca_id;
  }
  
  public String getChca_remark() {
    return this.chca_remark;
  }
  
  public void setChca_remark(String chca_remark) {
    this.chca_remark = StringHelper.getRealString(chca_remark);
  }
  
  public Date getChca_time() {
    return this.chca_time;
  }
  
  public void setChca_time(Date chca_time) {
    this.chca_time = chca_time;
  }
  
  public String getChca_title() {
    return this.chca_title;
  }
  
  public void setChca_title(String chca_title) {
    this.chca_title = StringHelper.getRealString(chca_title);
  }
  
  public Date getEnd_time() {
    return this.end_time;
  }
  
  public void setEnd_time(Date end_time) {
    this.end_time = end_time;
  }
  
  public String getMarketplace() {
    return this.marketplace;
  }
  
  public void setMarketplace(String marketplace) {
    this.marketplace = StringHelper.getRealString(marketplace);
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
  
  public String getChca_pic() {
    return this.chca_pic;
  }
  
  public void setChca_pic(String chca_pic) {
    this.chca_pic = StringHelper.getRealString(chca_pic);
  }
  
  public String getChca_url() {
    return this.chca_url;
  }
  
  public void setChca_url(String chca_url) {
    this.chca_url = StringHelper.getRealString(chca_url);
  }
  
  public int getCooperate_id() {
    return this.cooperate_id;
  }
  
  public void setCooperate_id(int cooperate_id) {
    this.cooperate_id = cooperate_id;
  }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) {
    this.merc_id = merc_id;
  }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public int getRecommend_sort_id() {
    return this.recommend_sort_id;
  }
  
  public void setRecommend_sort_id(int recommend_sort_id) {
    this.recommend_sort_id = recommend_sort_id;
  }
  
  public String getRecommend_sort_name() {
    return this.recommend_sort_name;
  }
  
  public void setRecommend_sort_name(String recommend_sort_name) {
    this.recommend_sort_name = StringHelper.getRealString(recommend_sort_name);
  }
  
  public int getSort_id() {
    return this.sort_id;
  }
  
  public void setSort_id(int sort_id) {
    this.sort_id = sort_id;
  }
  
  public String getSort_name() {
    return this.sort_name;
  }
  
  public void setSort_name(String sort_name) {
    this.sort_name = StringHelper.getRealString(sort_name);
  }
  
  public String getUseful_life() {
    return this.useful_life;
  }
  
  public void setUseful_life(String useful_life) {
    this.useful_life = StringHelper.getRealString(useful_life);
  }
}
