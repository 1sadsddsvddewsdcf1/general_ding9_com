package com.ding9.entity.shopcenter;

import java.util.List;

public class ShopCenter { private int shop_id;
  private int city_id;
  private int type_id_one;
  private String shop_name;
  private String address;
  private String webaddress; private String route; private String park;
  public int getType_id() { return this.type_id; }
  
  private String telephone;
  private String logo_pic;
  public void setType_id(int type_id) { this.type_id = type_id; }
  
  private String figure_pic;
  private String map_pic;
  public String getType_name_two() { return this.type_name_two; }
  
  private String introduction;
  private String detail;
  public int getType_id_one() { return this.type_id_one; }
  
  private int is_display;
  private int is_recommend;
  public void setType_id_one(int type_id_one) { this.type_id_one = type_id_one; }
  
  private List couponType;
  private List pic_coupon;
  public void setType_name_two(String type_name_two) { this.type_name_two = type_name_two; }
  
  private String type_name_two;
  
  public List getPic_coupon() { return this.pic_coupon; }
  
  private String type_name_one;
  
  public String getType_name_one() { return this.type_name_one; }
  
  private int type_id;
  public void setType_name_one(String type_name_one) {
    this.type_name_one = type_name_one;
  }
  
  public void setPic_coupon(List pic_coupon) {
    this.pic_coupon = pic_coupon;
  }
  
  public String getAddress() {
    return this.address;
  }
  
  public List getCouponType() {
    return this.couponType;
  }
  
  public void setCouponType(List couponType) {
    this.couponType = couponType;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public int getCity_id() {
    return this.city_id;
  }
  
  public void setCity_id(int city_id) {
    this.city_id = city_id;
  }
  
  public String getDetail() {
    return this.detail;
  }
  
  public void setDetail(String detail) {
    this.detail = detail;
  }
  
  public String getFigure_pic() {
    return this.figure_pic;
  }
  
  public void setFigure_pic(String figure_pic) {
    this.figure_pic = figure_pic;
  }
  
  public String getIntroduction() {
    return this.introduction;
  }
  
  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }
  
  public int getIs_display() {
    return this.is_display;
  }
  
  public void setIs_display(int is_display) {
    this.is_display = is_display;
  }
  
  public int getIs_recommend() {
    return this.is_recommend;
  }
  
  public void setIs_recommend(int is_recommend) {
    this.is_recommend = is_recommend;
  }
  
  public String getLogo_pic() {
    return this.logo_pic;
  }
  
  public void setLogo_pic(String logo_pic) {
    this.logo_pic = logo_pic;
  }
  
  public String getMap_pic() {
    return this.map_pic;
  }
  
  public void setMap_pic(String map_pic) {
    this.map_pic = map_pic;
  }
  
  public String getPark() {
    return this.park;
  }
  
  public void setPark(String park) {
    this.park = park;
  }
  
  public String getRoute() {
    return this.route;
  }
  
  public void setRoute(String route) {
    this.route = route;
  }
  
  public int getShop_id() {
    return this.shop_id;
  }
  
  public void setShop_id(int shop_id) {
    this.shop_id = shop_id;
  }
  
  public String getShop_name() {
    return this.shop_name;
  }
  
  public void setShop_name(String shop_name) {
    this.shop_name = shop_name;
  }
  
  public String getTelephone() {
    return this.telephone;
  }
  
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  
  public String getWebaddress() {
    return this.webaddress;
  }
  
  public void setWebaddress(String webaddress) {
    this.webaddress = webaddress;
  }
}
