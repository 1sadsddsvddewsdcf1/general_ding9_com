package com.ding9.search.entity.product;

import com.ding9.search.util.StringHelper;
import java.util.Date;





public class ProductMaster
{
  private int prma_id;
  private String prma_name = "";
  

  private int prso_id;
  

  private String prso_name = "";
  

  private int prbr_id;
  

  private String prbr_name = "";
  

  private String prbr_english_name = "";
  








  private String prma_ena = "";
  
  private String prma_remark = "";
  

  private int merchant_count;
  

  private int comment_count;
  

  private int product_level;
  

  private float min_price;
  

  private float max_price;
  

  private float abs_price;
  

  private int prso_id_one;
  
  private String prso_name_one = "";
  

  private int prso_id_two;
  

  private String prso_name_two = "";
  

  private String pic_address = "";
  
  private String prma_name_alias = "";
  
  private String prso_name_alias = "";
  
  private String prbr_name_alias = "";
  
  private String prac_address = "";
  

  private String small_pic_address = "";
  

  private int mepr_id;
  

  private String merc_product_address = "";
  

  private int merc_id;
  

  private String merc_com_name = "";
  
  private Date up_time;
  
  public String getMerc_product_address()
  {
    return this.merc_product_address;
  }
  
  public void setMerc_product_address(String merc_product_address) {
    this.merc_product_address = StringHelper.getRealString(merc_product_address);
  }
  
  public int getMerchant_count() {
    return this.merchant_count;
  }
  
  public void setMerchant_count(int merchant_count) {
    this.merchant_count = merchant_count;
  }
  
  public int getPrbr_id() {
    return this.prbr_id;
  }
  
  public void setPrbr_id(int prbr_id) {
    this.prbr_id = prbr_id;
  }
  
  public String getPrbr_name() {
    return this.prbr_name;
  }
  
  public void setPrbr_name(String prbr_name) {
    this.prbr_name = StringHelper.getRealString(prbr_name);
  }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) {
    this.prma_name = StringHelper.getRealString(prma_name);
  }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) {
    this.prso_id = prso_id;
  }
  
  public String getPrso_name() {
    return this.prso_name;
  }
  
  public void setPrso_name(String prso_name) {
    this.prso_name = StringHelper.getRealString(prso_name);
  }
  
  public int getComment_count() {
    return this.comment_count;
  }
  
  public void setComment_count(int comment_count) {
    this.comment_count = comment_count;
  }
  
  public float getMax_price() {
    return this.max_price;
  }
  
  public void setMax_price(float max_price) {
    this.max_price = max_price;
  }
  
  public float getMin_price() {
    return this.min_price;
  }
  
  public void setMin_price(float min_price) {
    this.min_price = min_price;
  }
  
  public String getPrma_remark() {
    return this.prma_remark;
  }
  
  public void setPrma_remark(String prma_remark) {
    this.prma_remark = StringHelper.getRealString(prma_remark);
  }
  
  public int getProduct_level() {
    return this.product_level;
  }
  
  public void setProduct_level(int product_level) {
    this.product_level = product_level;
  }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public int getPrso_id_two() {
    return this.prso_id_two;
  }
  
  public void setPrso_id_two(int prso_id_two) {
    this.prso_id_two = prso_id_two;
  }
  
  public String getPrso_name_one() {
    return this.prso_name_one;
  }
  
  public void setPrso_name_one(String prso_name_one) {
    this.prso_name_one = StringHelper.getRealString(prso_name_one);
  }
  
  public String getPrso_name_two() {
    return this.prso_name_two;
  }
  
  public void setPrso_name_two(String prso_name_two) {
    this.prso_name_two = StringHelper.getRealString(prso_name_two);
  }
  
  public String getPic_address() {
    return this.pic_address;
  }
  
  public void setPic_address(String pic_address) {
    this.pic_address = StringHelper.getRealString(pic_address);
  }
  
  public String getSmall_pic_address() {
    return this.small_pic_address;
  }
  
  public void setSmall_pic_address(String small_pic_address) {
    this.small_pic_address = StringHelper.getRealString(small_pic_address);
  }
  
  public int getMepr_id() {
    return this.mepr_id;
  }
  
  public void setMepr_id(int mepr_id) {
    this.mepr_id = mepr_id;
  }
  
  public String getMerc_com_name() {
    return this.merc_com_name;
  }
  
  public void setMerc_com_name(String merc_com_name) {
    this.merc_com_name = StringHelper.getRealString(merc_com_name);
  }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) {
    this.merc_id = merc_id;
  }
  
  public String getPrbr_english_name() {
    return this.prbr_english_name;
  }
  
  public void setPrbr_english_name(String prbr_english_name) {
    this.prbr_english_name = StringHelper.getRealString(prbr_english_name);
  }
  
  public Date getUp_time() {
    return this.up_time;
  }
  
  public void setUp_time(Date up_time) {
    this.up_time = up_time;
  }
  
  public float getAbs_price() {
    return this.abs_price;
  }
  
  public void setAbs_price(float abs_price) {
    this.abs_price = abs_price;
  }
  
  public String getPrac_address() {
    return this.prac_address;
  }
  
  public void setPrac_address(String prac_address) {
    this.prac_address = prac_address;
  }
  



  public void setPrbr_name_alias(String prbr_name_alias)
  {
    this.prbr_name_alias = StringHelper.getRealString(prbr_name_alias);
  }
  



  public void setPrma_name_alias(String prma_name_alias)
  {
    this.prma_name_alias = StringHelper.getRealString(prma_name_alias);
  }
  



  public void setPrso_name_alias(String prso_name_alias)
  {
    this.prso_name_alias = StringHelper.getRealString(prso_name_alias);
  }
  
  public String getPrma_ena() {
    return this.prma_ena;
  }
  
  public void setPrma_ena(String prma_ena) {
    this.prma_ena = prma_ena;
  }
}
