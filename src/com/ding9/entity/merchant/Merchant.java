package com.ding9.entity.merchant;

import com.ding9.util.Character;
import java.util.Date;







public class Merchant
{
  private int merc_id;
  private int merc_id_TMP;
  private String user_name;
  private String user_pass;
  private String merc_com_name;
  private String merc_web_name;
  private String merc_name;
  private String merc_address;
  private String merc_omit;
  private String merc_city;
  private String merc_phone;
  private String merc_handset;
  private String merc_email;
  private String merc_fax;
  private String merc_post;
  private String mesh_logo_money;
  private String merc_bound;
  private String merc_date = Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  private String mesh_name;
  private String mesh_pic;
  private String mesh_chap_logo;
  private String mesh_into_time;
  private int merc_from;
  private int merc_from_id;
  private int merc_credit;
  private int merc_size;
  private int sys_yn;
  private int merc_type;
  private int syus_id;
  private int merchant_type;
  private String merc_js;
  private String max_scale;
  private String merc_url;
  private int parameter_type;
  private String transfer_url;
  private String parameter;
  private String mecr_pricer;
  private String target;
  private int merc_state;
  private String remark;
  private int user_quse;
  private String user_solu;
  private String merc_description;
  private String merc_playment;
  private String merc_freight;
  private String merc_serve;
  private String merc_equip;
  private String grade;
  private String deliveryDate = Character.FieldDateToString(new Date(), "yyyy-MM-dd");
  private String endDate = Character.FieldDateToString(new Date(), "yyyy-MM-dd");
  private String effectiveDate = Character.FieldDateToString(new Date(), "yyyy-MM-dd");
  private String receiveDate = Character.FieldDateToString(new Date(), "yyyy-MM-dd");
  private String scale_explain;
  
  public int getMerc_id() { return this.merc_id; }
  
  public void setMerc_id(int merc_id) {
    this.merc_id = merc_id;
  }
  
  public String getScale_explain() { return this.scale_explain; }
  
  public void setScale_explain(String scale_explain) {
    this.scale_explain = scale_explain;
  }
  
  public String getDeliveryDate() { return this.deliveryDate; }
  
  public void setDeliveryDate(String deliveryDate) {
    this.deliveryDate = deliveryDate;
  }
  
  public String getEffectiveDate() { return this.effectiveDate; }
  
  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }
  
  public String getEndDate() { return this.endDate; }
  
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  
  public String getGrade() { return this.grade; }
  
  public void setGrade(String grade) {
    this.grade = grade;
  }
  
  public String getMax_scale() { return this.max_scale; }
  
  public void setMax_scale(String max_scale) {
    this.max_scale = max_scale;
  }
  
  public String getMecr_pricer() { return this.mecr_pricer; }
  
  public void setMecr_pricer(String mecr_pricer) {
    this.mecr_pricer = mecr_pricer;
  }
  
  public String getMerc_address() { return this.merc_address; }
  
  public void setMerc_address(String merc_address) {
    this.merc_address = merc_address;
  }
  
  public String getMerc_bound() { return this.merc_bound; }
  
  public void setMerc_bound(String merc_bound) {
    this.merc_bound = merc_bound;
  }
  
  public String getMerc_city() { return this.merc_city; }
  
  public void setMerc_city(String merc_city) {
    this.merc_city = merc_city;
  }
  
  public String getMerc_com_name() { return this.merc_com_name; }
  
  public void setMerc_com_name(String merc_com_name) {
    this.merc_com_name = merc_com_name;
  }
  
  public int getMerc_credit() { return this.merc_credit; }
  
  public void setMerc_credit(int merc_credit) {
    this.merc_credit = merc_credit;
  }
  
  public String getMerc_date() { return this.merc_date; }
  
  public void setMerc_date(String merc_date) {
    this.merc_date = merc_date;
  }
  
  public String getMerc_description() { return this.merc_description; }
  
  public void setMerc_description(String merc_description) {
    this.merc_description = merc_description;
  }
  
  public String getMerc_email() { return this.merc_email; }
  
  public void setMerc_email(String merc_email) {
    this.merc_email = merc_email;
  }
  
  public String getMerc_equip() { return this.merc_equip; }
  
  public void setMerc_equip(String merc_equip) {
    this.merc_equip = merc_equip;
  }
  
  public String getMerc_fax() { return this.merc_fax; }
  
  public void setMerc_fax(String merc_fax) {
    this.merc_fax = merc_fax;
  }
  
  public String getMerc_freight() { return this.merc_freight; }
  
  public void setMerc_freight(String merc_freight) {
    this.merc_freight = merc_freight;
  }
  
  public int getMerc_from() { return this.merc_from; }
  
  public void setMerc_from(int merc_from) {
    this.merc_from = merc_from;
  }
  
  public int getMerc_from_id() { return this.merc_from_id; }
  
  public void setMerc_from_id(int merc_from_id) {
    this.merc_from_id = merc_from_id;
  }
  
  public String getMerc_handset() { return this.merc_handset; }
  
  public void setMerc_handset(String merc_handset) {
    this.merc_handset = merc_handset;
  }
  
  public int getMerc_id_TMP() { return this.merc_id_TMP; }
  
  public void setMerc_id_TMP(int merc_id_TMP) {
    this.merc_id_TMP = merc_id_TMP;
  }
  
  public String getMerc_js() { return this.merc_js; }
  
  public void setMerc_js(String merc_js) {
    this.merc_js = merc_js;
  }
  
  public String getMerc_name() { return this.merc_name; }
  
  public void setMerc_name(String merc_name) {
    this.merc_name = merc_name;
  }
  
  public String getMerc_omit() { return this.merc_omit; }
  
  public void setMerc_omit(String merc_omit) {
    this.merc_omit = merc_omit;
  }
  
  public String getMerc_phone() { return this.merc_phone; }
  
  public void setMerc_phone(String merc_phone) {
    this.merc_phone = merc_phone;
  }
  
  public String getMerc_playment() { return this.merc_playment; }
  
  public void setMerc_playment(String merc_playment) {
    this.merc_playment = merc_playment;
  }
  
  public String getMerc_post() { return this.merc_post; }
  
  public void setMerc_post(String merc_post) {
    this.merc_post = merc_post;
  }
  
  public String getMerc_serve() { return this.merc_serve; }
  
  public void setMerc_serve(String merc_serve) {
    this.merc_serve = merc_serve;
  }
  
  public int getMerc_size() { return this.merc_size; }
  
  public void setMerc_size(int merc_size) {
    this.merc_size = merc_size;
  }
  
  public int getMerc_state() { return this.merc_state; }
  
  public void setMerc_state(int merc_state) {
    this.merc_state = merc_state;
  }
  
  public int getMerc_type() { return this.merc_type; }
  
  public void setMerc_type(int merc_type) {
    this.merc_type = merc_type;
  }
  
  public String getMerc_url() { return this.merc_url; }
  
  public void setMerc_url(String merc_url) {
    this.merc_url = merc_url;
  }
  
  public String getMerc_web_name() { return this.merc_web_name; }
  
  public void setMerc_web_name(String merc_web_name) {
    this.merc_web_name = merc_web_name;
  }
  
  public int getMerchant_type() { return this.merchant_type; }
  
  public void setMerchant_type(int merchant_type) {
    this.merchant_type = merchant_type;
  }
  
  public String getMesh_chap_logo() { return this.mesh_chap_logo; }
  
  public void setMesh_chap_logo(String mesh_chap_logo) {
    this.mesh_chap_logo = mesh_chap_logo;
  }
  
  public String getMesh_into_time() { return this.mesh_into_time; }
  
  public void setMesh_into_time(String mesh_into_time) {
    this.mesh_into_time = mesh_into_time;
  }
  
  public String getMesh_logo_money() { return this.mesh_logo_money; }
  
  public void setMesh_logo_money(String mesh_logo_money) {
    this.mesh_logo_money = mesh_logo_money;
  }
  
  public String getMesh_name() { return this.mesh_name; }
  
  public void setMesh_name(String mesh_name) {
    this.mesh_name = mesh_name;
  }
  
  public String getMesh_pic() { return this.mesh_pic; }
  
  public void setMesh_pic(String mesh_pic) {
    this.mesh_pic = mesh_pic;
  }
  
  public String getParameter() { return this.parameter; }
  
  public void setParameter(String parameter) {
    this.parameter = parameter;
  }
  
  public int getParameter_type() { return this.parameter_type; }
  
  public void setParameter_type(int parameter_type) {
    this.parameter_type = parameter_type;
  }
  
  public String getReceiveDate() { return this.receiveDate; }
  
  public void setReceiveDate(String receiveDate) {
    this.receiveDate = receiveDate;
  }
  
  public String getRemark() { return this.remark; }
  
  public void setRemark(String remark) {
    this.remark = remark;
  }
  
  public int getSys_yn() { return this.sys_yn; }
  
  public void setSys_yn(int sys_yn) {
    this.sys_yn = sys_yn;
  }
  
  public int getSyus_id() { return this.syus_id; }
  
  public void setSyus_id(int syus_id) {
    this.syus_id = syus_id;
  }
  
  public String getTarget() { return this.target; }
  
  public void setTarget(String target) {
    this.target = target;
  }
  
  public String getTransfer_url() { return this.transfer_url; }
  
  public void setTransfer_url(String transfer_url) {
    this.transfer_url = transfer_url;
  }
  
  public String getUser_name() { return this.user_name; }
  
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }
  
  public String getUser_pass() { return this.user_pass; }
  
  public void setUser_pass(String user_pass) {
    this.user_pass = user_pass;
  }
  
  public int getUser_quse() { return this.user_quse; }
  
  public void setUser_quse(int user_quse) {
    this.user_quse = user_quse;
  }
  
  public String getUser_solu() { return this.user_solu; }
  
  public void setUser_solu(String user_solu) {
    this.user_solu = user_solu;
  }
}
