package com.ding9.action.register;

import com.ding9.entity.user.UserContactInfo;
import java.sql.Timestamp;
import org.apache.struts.action.ActionForm;






























public class RegisterAF
  extends ActionForm
{
  private int user_id;
  private int user_id_tmp;
  private String user_name;
  private String user_pass;
  private String user_email;
  private Timestamp user_date_reg;
  private String user_sn;
  private int user_check;
  private int user_journal;
  private int user_credit;
  private int user_screen;
  private UserContactInfo contact;
  private int user_quse;
  private String user_solu;
  private String merchant_tig;
  private String user_merchant;
  private int source_userid;
  private String source_username;
  private String source_useremail;
  private int is_using;
  
  public UserContactInfo getContact()
  {
    return this.contact;
  }
  
  public void setContact(UserContactInfo contact) {
    this.contact = contact;
  }
  
  public int getIs_using() {
    return this.is_using;
  }
  
  public void setIs_using(int is_using) {
    this.is_using = is_using;
  }
  
  public String getMerchant_tig() {
    return this.merchant_tig;
  }
  
  public void setMerchant_tig(String merchant_tig) {
    this.merchant_tig = merchant_tig;
  }
  
  public String getSource_useremail() {
    return this.source_useremail;
  }
  
  public void setSource_useremail(String source_useremail) {
    this.source_useremail = source_useremail;
  }
  
  public int getSource_userid() {
    return this.source_userid;
  }
  
  public void setSource_userid(int source_userid) {
    this.source_userid = source_userid;
  }
  
  public String getSource_username() {
    return this.source_username;
  }
  
  public void setSource_username(String source_username) {
    this.source_username = source_username;
  }
  
  public int getUser_check() {
    return this.user_check;
  }
  
  public void setUser_check(int user_check) {
    this.user_check = user_check;
  }
  
  public int getUser_credit() {
    return this.user_credit;
  }
  
  public void setUser_credit(int user_credit) {
    this.user_credit = user_credit;
  }
  
  public Timestamp getUser_date_reg() {
    return this.user_date_reg;
  }
  
  public void setUser_date_reg(Timestamp user_date_reg) {
    this.user_date_reg = user_date_reg;
  }
  
  public String getUser_email() {
    return this.user_email;
  }
  
  public void setUser_email(String user_email) {
    this.user_email = user_email;
  }
  
  public int getUser_id() {
    return this.user_id;
  }
  
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  
  public int getUser_id_tmp() {
    return this.user_id_tmp;
  }
  
  public void setUser_id_tmp(int user_id_tmp) {
    this.user_id_tmp = user_id_tmp;
  }
  
  public int getUser_journal() {
    return this.user_journal;
  }
  
  public void setUser_journal(int user_journal) {
    this.user_journal = user_journal;
  }
  
  public String getUser_merchant() {
    return this.user_merchant;
  }
  
  public void setUser_merchant(String user_merchant) {
    this.user_merchant = user_merchant;
  }
  
  public String getUser_name() {
    return this.user_name;
  }
  
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }
  
  public String getUser_pass() {
    return this.user_pass;
  }
  
  public void setUser_pass(String user_pass) {
    this.user_pass = user_pass;
  }
  
  public int getUser_quse() {
    return this.user_quse;
  }
  
  public void setUser_quse(int user_quse) {
    this.user_quse = user_quse;
  }
  
  public int getUser_screen() {
    return this.user_screen;
  }
  
  public void setUser_screen(int user_screen) {
    this.user_screen = user_screen;
  }
  
  public String getUser_sn() {
    return this.user_sn;
  }
  
  public void setUser_sn(String user_sn) {
    this.user_sn = user_sn;
  }
  
  public String getUser_solu() {
    return this.user_solu;
  }
  
  public void setUser_solu(String user_solu) {
    this.user_solu = user_solu;
  }
}
