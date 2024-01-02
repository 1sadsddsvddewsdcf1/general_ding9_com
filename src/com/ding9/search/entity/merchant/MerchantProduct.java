package com.ding9.search.entity.merchant;

import com.ding9.search.util.Character;
import com.ding9.search.util.StringHelper;
import java.util.Date;





























public class MerchantProduct
{
  private int mepr_id;
  private int prma_id;
  private int prso_id;
  private int merc_id;
  private float mepr_price;
  private String prma_name = "";
  



  private String mepr_remark = "";
  

  private float mepr_weight;
  
  private String mepr_contect = "";
  private int mepr_quality;
  private int mess_id;
  private int mepr_count;
  private float mepr_value;
  private int mepr_yn;
  private String mepr_yn_reason = "";
  private int sys_yn;
  private int mepr_sale;
  private int mepr_vouch;
  private int mepr_new;
  private int mepr_pop;
  private int mepr_cheap;
  private String mepr_web_address = "";
  private String mepr_address = "";
  private String mepr_time = Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  private String up_time = Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  private int mepr_count_des;
  private int mepr_ass;
  private int mepr_crawl;
  private int mepr_match;
  private int mepr_forestall;
  
  public String getMepr_address()
  {
    return this.mepr_address;
  }
  
  public void setMepr_address(String mepr_address) { this.mepr_address = StringHelper.getRealString(mepr_address); }
  
  public int getMepr_ass() {
    return this.mepr_ass;
  }
  
  public void setMepr_ass(int mepr_ass) { this.mepr_ass = mepr_ass; }
  
  public int getMepr_cheap() {
    return this.mepr_cheap;
  }
  
  public void setMepr_cheap(int mepr_cheap) { this.mepr_cheap = mepr_cheap; }
  
  public String getMepr_contect() {
    return this.mepr_contect;
  }
  
  public void setMepr_contect(String mepr_contect) { this.mepr_contect = StringHelper.getRealString(mepr_contect); }
  
  public int getMepr_count() {
    return this.mepr_count;
  }
  
  public void setMepr_count(int mepr_count) { this.mepr_count = mepr_count; }
  
  public int getMepr_count_des() {
    return this.mepr_count_des;
  }
  
  public void setMepr_count_des(int mepr_count_des) { this.mepr_count_des = mepr_count_des; }
  
  public int getMepr_crawl() {
    return this.mepr_crawl;
  }
  
  public void setMepr_crawl(int mepr_crawl) { this.mepr_crawl = mepr_crawl; }
  
  public int getMepr_forestall() {
    return this.mepr_forestall;
  }
  
  public void setMepr_forestall(int mepr_forestall) { this.mepr_forestall = mepr_forestall; }
  
  public int getMepr_id() {
    return this.mepr_id;
  }
  
  public void setMepr_id(int mepr_id) { this.mepr_id = mepr_id; }
  
  public int getMepr_match() {
    return this.mepr_match;
  }
  
  public void setMepr_match(int mepr_match) { this.mepr_match = mepr_match; }
  
  public int getMepr_new() {
    return this.mepr_new;
  }
  
  public void setMepr_new(int mepr_new) { this.mepr_new = mepr_new; }
  
  public int getMepr_pop() {
    return this.mepr_pop;
  }
  
  public void setMepr_pop(int mepr_pop) { this.mepr_pop = mepr_pop; }
  
  public float getMepr_price() {
    return this.mepr_price;
  }
  
  public void setMepr_price(float mepr_price) { this.mepr_price = mepr_price; }
  
  public int getMepr_quality() {
    return this.mepr_quality;
  }
  
  public void setMepr_quality(int mepr_quality) { this.mepr_quality = mepr_quality; }
  
  public String getMepr_remark() {
    return this.mepr_remark;
  }
  
  public void setMepr_remark(String mepr_remark) { this.mepr_remark = StringHelper.getRealString(mepr_remark); }
  
  public int getMepr_sale() {
    return this.mepr_sale;
  }
  
  public void setMepr_sale(int mepr_sale) { this.mepr_sale = mepr_sale; }
  
  public String getMepr_time() {
    return this.mepr_time;
  }
  
  public void setMepr_time(String mepr_time) { this.mepr_time = StringHelper.getRealString(mepr_time); }
  
  public float getMepr_value() {
    return this.mepr_value;
  }
  
  public void setMepr_value(float mepr_value) { this.mepr_value = mepr_value; }
  
  public int getMepr_vouch() {
    return this.mepr_vouch;
  }
  
  public void setMepr_vouch(int mepr_vouch) { this.mepr_vouch = mepr_vouch; }
  
  public String getMepr_web_address() {
    return this.mepr_web_address;
  }
  
  public void setMepr_web_address(String mepr_web_address) { this.mepr_web_address = StringHelper.getRealString(mepr_web_address); }
  
  public float getMepr_weight() {
    return this.mepr_weight;
  }
  
  public void setMepr_weight(float mepr_weight) { this.mepr_weight = mepr_weight; }
  
  public int getMepr_yn() {
    return this.mepr_yn;
  }
  
  public void setMepr_yn(int mepr_yn) { this.mepr_yn = mepr_yn; }
  
  public String getMepr_yn_reason() {
    return this.mepr_yn_reason;
  }
  
  public void setMepr_yn_reason(String mepr_yn_reason) { this.mepr_yn_reason = StringHelper.getRealString(mepr_yn_reason); }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) { this.merc_id = merc_id; }
  
  public int getMess_id() {
    return this.mess_id;
  }
  
  public void setMess_id(int mess_id) { this.mess_id = mess_id; }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) { this.prma_id = prma_id; }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) { this.prma_name = StringHelper.getRealString(prma_name); }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) { this.prso_id = prso_id; }
  
  public int getSys_yn() {
    return this.sys_yn;
  }
  
  public void setSys_yn(int sys_yn) { this.sys_yn = sys_yn; }
  
  public String getUp_time() {
    return this.up_time;
  }
  
  public void setUp_time(String up_time) { this.up_time = StringHelper.getRealString(up_time); }
}
