package com.ding9.entity.user;



public class UserContactInfo
{
  private String user_omit;
  

  private String user_city;
  

  private String user_phone;
  

  private String user_bain_fax;
  

  private String user_handset;
  

  private String user_address;
  
  private String user_post;
  
  private String user_name_true;
  
  private String user_sex;
  
  private String user_date;
  

  public UserContactInfo()
  {
    this.user_name_true = "";
    this.user_sex = "先生";
    this.user_date = null;
    this.user_omit = "";
    this.user_city = "";
    this.user_phone = "";
    this.user_bain_fax = "";
    this.user_handset = "";
    this.user_address = "";
    this.user_post = "";
  }
  
  public String getUser_name_true() {
    return this.user_name_true;
  }
  
  public void setUser_name_true(String name_true) {
    this.user_name_true = name_true;
  }
  
  public String getUser_sex() {
    return this.user_sex;
  }
  
  public void setUser_sex(String sex) {
    this.user_sex = sex;
  }
  
  public String getUser_date() {
    return this.user_date;
  }
  
  public void setUser_date(String date) {
    this.user_date = date;
  }
  
  public String getUser_omit() {
    return this.user_omit;
  }
  
  public void setUser_omit(String omit) {
    this.user_omit = omit;
  }
  
  public String getUser_city() {
    return this.user_city;
  }
  
  public void setUser_city(String city) {
    this.user_city = city;
  }
  
  public String getUser_phone() {
    return this.user_phone;
  }
  
  public void setUser_phone(String phone) {
    this.user_phone = phone;
  }
  
  public String getUser_bain_fax() {
    return this.user_bain_fax;
  }
  
  public void setUser_bain_fax(String bain_fax) {
    this.user_bain_fax = bain_fax;
  }
  
  public String getUser_handset() {
    return this.user_handset;
  }
  
  public void setUser_handset(String handset) {
    this.user_handset = handset;
  }
  
  public String getUser_address() {
    return this.user_address;
  }
  
  public void setUser_address(String user_address) {
    this.user_address = user_address;
  }
  
  public String getUser_post() {
    return this.user_post;
  }
  
  public void setUser_post(String post) {
    this.user_post = post;
  }
}
