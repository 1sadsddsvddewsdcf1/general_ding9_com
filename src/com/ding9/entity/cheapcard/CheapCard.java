package com.ding9.entity.cheapcard;

import com.ding9.util.Character;
import java.util.Date;
import java.util.List;








public class CheapCard
{
  private int chca_id;
  private int merc_id;
  private int prso_id_one;
  private String chca_pic;
  private String chca_remark;
  private String chca_title;
  private String chca_url;
  private String end_time = Character.FieldDateToString(new Date(), "yyyy-MM-dd");
  
  private String chca_time = Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  private String marketplace;
  private String store_name;
  private String sort_name;
  private String info_source;
  private int sort_id;
  private List cheapcard;
  private String label;
  private String chsort_time;
  private int chca_yn;
  private String prso_name_one_en;
  
  public int getChca_id()
  {
    return this.chca_id;
  }
  
  public void setChca_id(int chca_id) { this.chca_id = chca_id; }
  
  public String getChca_title() {
    return this.chca_title;
  }
  
  public void setChca_title(String chca_title) { this.chca_title = chca_title; }
  
  public String getChca_url() {
    return this.chca_url;
  }
  
  public void setChca_url(String chca_url) { this.chca_url = chca_url; }
  
  public String getChca_pic() {
    return this.chca_pic;
  }
  
  public void setChca_pic(String chca_pic) { this.chca_pic = chca_pic; }
  
  public String getChca_remark() {
    return this.chca_remark;
  }
  
  public void setChca_remark(String chca_remark) { this.chca_remark = chca_remark; }
  
  public String getChca_time() {
    return this.chca_time;
  }
  
  public void setChca_time(String chca_time) { this.chca_time = chca_time; }
  
  public int getChca_yn() {
    return this.chca_yn;
  }
  
  public void setChca_yn(int chca_yn) { this.chca_yn = chca_yn; }
  
  public String getEnd_time() {
    return this.end_time;
  }
  
  public void setEnd_time(String end_time) { this.end_time = end_time; }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) { this.merc_id = merc_id; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public String getMarketplace() {
    return this.marketplace;
  }
  
  public void setMarketplace(String marketplace) { this.marketplace = marketplace; }
  
  public String getStore_name() {
    return this.store_name;
  }
  
  public void setStore_name(String store_name) { this.store_name = store_name; }
  
  public String getSort_name() {
    return this.sort_name;
  }
  
  public void setSort_name(String sort_name) { this.sort_name = sort_name; }
  
  public String getInfo_source() {
    return this.info_source;
  }
  
  public void setInfo_source(String info_source) { this.info_source = info_source; }
  
  public int getSort_id() {
    return this.sort_id;
  }
  
  public void setSort_id(int sort_id) { this.sort_id = sort_id; }
  
  public List getCheapcard() {
    return this.cheapcard;
  }
  
  public void setCheapcard(List cheapcard) { this.cheapcard = cheapcard; }
  
  public String getLabel() {
    return this.label;
  }
  
  public void setLabel(String label) { this.label = label; }
  
  public String getChsort_time() {
    return this.chsort_time;
  }
  
  public void setChsort_time(String chsort_time) { this.chsort_time = chsort_time; }
  
  public String getPrso_name_one_en() {
    return this.prso_name_one_en;
  }
  
  public void setPrso_name_one_en(String name) { this.prso_name_one_en = name; }
}
