package com.ding9.entity.coupon;

import java.util.List;

public class CouponType {
  private int type_id;
  private int shop_id;
  private String coupon_name;
  private List coupon_info;
  
  public List getCoupon_info() { return this.coupon_info; }
  
  public void setCoupon_info(List coupon_info)
  {
    this.coupon_info = coupon_info;
  }
  
  public String getCoupon_name() {
    return this.coupon_name;
  }
  
  public void setCoupon_name(String coupon_name) {
    this.coupon_name = coupon_name;
  }
  
  public int getShop_id() {
    return this.shop_id;
  }
  
  public void setShop_id(int shop_id) {
    this.shop_id = shop_id;
  }
  
  public int getType_id() {
    return this.type_id;
  }
  
  public void setType_id(int type_id) {
    this.type_id = type_id;
  }
}
