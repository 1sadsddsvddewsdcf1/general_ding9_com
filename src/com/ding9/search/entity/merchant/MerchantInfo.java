package com.ding9.search.entity.merchant;

import com.ding9.search.util.Character;
import com.ding9.search.util.StringHelper;
import java.util.Date;
import java.util.List;











public class MerchantInfo
{
  private List picList;
  private int is_tmp;
  private int merc_id;
  private String merc_com_name;
  private String merc_name;
  private String merc_phone;
  private String merc_handset;
  private String merc_address;
  private String merc_omit;
  private String omit_name;
  private String cPY;
  private String merc_city;
  private String city_name;
  private String pPY;
  private String merc_email;
  private String merc_fax;
  private String merc_post;
  private String merc_date = Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  private int merc_type;
  private String merc_msn;
  private String merc_qq;
  private String mesh_chap_logo;
  private int merc_state;
  private int merc_from;
  private int sys_yn;
  private int syus_id;
  private String merc_equip;
  private String[] equip;
  private String merc_payment;
  private String[] payment;
  private String remark;
  private int comments_cnt;
  private int comments_level;
  private int product_cnt;
  private String update_date = Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  
  private String merc_web_name;
  
  private String merc_url;
  
  private String merc_web_size;
  
  private String mesh_logo_money;
  
  private String merc_bound;
  private String[] bound;
  private String mesh_into_time;
  private String merc_description;
  private String merc_serve;
  private String merc_freight;
  private int merc_main_bound;
  
  public int getComments_cnt()
  {
    return this.comments_cnt;
  }
  
  public void setComments_cnt(int comments_cnt) { this.comments_cnt = comments_cnt; }
  
  public int getComments_level() {
    return this.comments_level;
  }
  
  public void setComments_level(int comments_level) { this.comments_level = comments_level; }
  
  public int getIs_tmp() {
    return this.is_tmp;
  }
  
  public void setIs_tmp(int is_tmp) { this.is_tmp = is_tmp; }
  
  public String getMerc_address() {
    return this.merc_address;
  }
  
  public void setMerc_address(String merc_address) { this.merc_address = merc_address; }
  
  public String getMerc_bound() {
    return this.merc_bound;
  }
  
  public void setMerc_bound(String merc_bound) { this.merc_bound = merc_bound; }
  
  public String getMerc_city() {
    return this.merc_city;
  }
  
  public void setMerc_city(String merc_city) { this.merc_city = merc_city; }
  
  public String getMerc_com_name() {
    return this.merc_com_name;
  }
  
  public void setMerc_com_name(String merc_com_name) { this.merc_com_name = merc_com_name; }
  
  public String getMerc_date() {
    return this.merc_date;
  }
  
  public void setMerc_date(String merc_date) { this.merc_date = merc_date; }
  
  public String getMerc_description() {
    return this.merc_description;
  }
  
  public void setMerc_description(String merc_description) { this.merc_description = merc_description; }
  
  public String getMerc_email() {
    return StringHelper.getRealString(this.merc_email);
  }
  
  public void setMerc_email(String merc_email) { this.merc_email = merc_email; }
  
  public String getMerc_equip() {
    return this.merc_equip;
  }
  
  public void setMerc_equip(String merc_equip) { this.merc_equip = merc_equip; }
  
  public String getMerc_fax() {
    return this.merc_fax;
  }
  
  public void setMerc_fax(String merc_fax) { this.merc_fax = merc_fax; }
  
  public String getMerc_freight() {
    return this.merc_freight;
  }
  
  public void setMerc_freight(String merc_freight) { this.merc_freight = merc_freight; }
  
  public int getMerc_from() {
    return this.merc_from;
  }
  
  public void setMerc_from(int merc_from) { this.merc_from = merc_from; }
  
  public String getMerc_handset() {
    return this.merc_handset;
  }
  
  public void setMerc_handset(String merc_handset) { this.merc_handset = merc_handset; }
  
  public int getMerc_id() {
    return this.merc_id;
  }
  
  public void setMerc_id(int merc_id) { this.merc_id = merc_id; }
  
  public int getMerc_main_bound() {
    return this.merc_main_bound;
  }
  
  public void setMerc_main_bound(int merc_main_bound) { this.merc_main_bound = merc_main_bound; }
  
  public String getMerc_msn() {
    return this.merc_msn;
  }
  
  public void setMerc_msn(String merc_msn) { this.merc_msn = merc_msn; }
  
  public String getMerc_name() {
    return this.merc_name;
  }
  
  public void setMerc_name(String merc_name) { this.merc_name = merc_name; }
  
  public String getMerc_omit() {
    return this.merc_omit;
  }
  
  public void setMerc_omit(String merc_omit) { this.merc_omit = merc_omit; }
  
  public String getMerc_payment() {
    return StringHelper.getRealString(this.merc_payment);
  }
  
  public void setMerc_payment(String merc_payment) { this.merc_payment = merc_payment; }
  
  public String getMerc_phone() {
    return StringHelper.getRealString(this.merc_phone);
  }
  
  public void setMerc_phone(String merc_phone) { this.merc_phone = merc_phone; }
  
  public String getMerc_post() {
    return this.merc_post;
  }
  
  public void setMerc_post(String merc_post) { this.merc_post = merc_post; }
  
  public String getMerc_qq() {
    return this.merc_qq;
  }
  
  public void setMerc_qq(String merc_qq) { this.merc_qq = merc_qq; }
  
  public String getMerc_serve() {
    return this.merc_serve;
  }
  
  public void setMerc_serve(String merc_serve) { this.merc_serve = merc_serve; }
  
  public int getMerc_state() {
    return this.merc_state;
  }
  
  public void setMerc_state(int merc_state) { this.merc_state = merc_state; }
  
  public int getMerc_type() {
    return this.merc_type;
  }
  
  public void setMerc_type(int merc_type) { this.merc_type = merc_type; }
  
  public String getMerc_url() {
    return this.merc_url;
  }
  
  public void setMerc_url(String merc_url) { this.merc_url = merc_url; }
  
  public String getMerc_web_name() {
    return this.merc_web_name;
  }
  
  public void setMerc_web_name(String merc_web_name) { this.merc_web_name = merc_web_name; }
  
  public String getMerc_web_size() {
    return this.merc_web_size;
  }
  
  public void setMerc_web_size(String merc_web_size) { this.merc_web_size = merc_web_size; }
  
  public String getMesh_chap_logo() {
    return this.mesh_chap_logo;
  }
  
  public void setMesh_chap_logo(String mesh_chap_logo) { this.mesh_chap_logo = mesh_chap_logo; }
  
  public String getMesh_into_time() {
    return this.mesh_into_time;
  }
  
  public void setMesh_into_time(String mesh_into_time) { this.mesh_into_time = mesh_into_time; }
  
  public String getMesh_logo_money() {
    return this.mesh_logo_money;
  }
  
  public void setMesh_logo_money(String mesh_logo_money) { this.mesh_logo_money = mesh_logo_money; }
  





























  public int getProduct_cnt()
  {
    return this.product_cnt;
  }
  
  public void setProduct_cnt(int product_cnt) { this.product_cnt = product_cnt; }
  
  public String getRemark() {
    return this.remark;
  }
  
  public void setRemark(String remark) { this.remark = remark; }
  
  public int getSys_yn() {
    return this.sys_yn;
  }
  
  public void setSys_yn(int sys_yn) { this.sys_yn = sys_yn; }
  
  public int getSyus_id() {
    return this.syus_id;
  }
  
  public void setSyus_id(int syus_id) { this.syus_id = syus_id; }
  
  public String getUpdate_date() {
    return this.update_date;
  }
  
  public void setUpdate_date(String update_date) { this.update_date = update_date; }
  
  public List getPicList() {
    return this.picList;
  }
  
  public void setPicList(List picList) { this.picList = picList; }
  
  public String[] getEquip() {
    return this.equip;
  }
  
  public void setEquip(String[] equip) { this.equip = equip; }
  
  public String[] getPayment() {
    return this.payment;
  }
  
  public void setPayment(String[] payment) { this.payment = payment; }
  
  public String getCity_name() {
    return this.city_name;
  }
  
  public void setCity_name(String city_name) { this.city_name = city_name; }
  
  public String getOmit_name() {
    return this.omit_name;
  }
  
  public void setOmit_name(String omit_name) { this.omit_name = omit_name; }
  
  public String[] getBound() {
    return this.bound;
  }
  
  public void setBound(String[] bound) { this.bound = bound; }
  
  public String getCPY() {
    return this.cPY;
  }
  
  public void setCPY(String cpy) { this.cPY = cpy; }
  
  public String getPPY() {
    return this.pPY;
  }
  
  public void setPPY(String ppy) { this.pPY = ppy; }
}
