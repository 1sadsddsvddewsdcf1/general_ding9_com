package com.ding9.entity.commonrecommendproductinfo;

import java.math.BigDecimal;

public class CommonRecommendProductInfo {
  private int infoId;
  private int sortId;
  private int prsoIdOne;
  private int prmaId;
  private String prmaName;
  private String picAddress;
  private int picIsupdate;
  private Object min_price;
  private Object old_price;
  private int merchant_count;
  private String prsoNameOne;
  private String prsoNameOneEn;
  
  public int getInfoId() {
    return this.infoId;
  }
  
  public String getPrsoNameOne() { return this.prsoNameOne; }
  
  public void setPrsoNameOne(String prsoNameOne) {
    this.prsoNameOne = prsoNameOne;
  }
  
  public void setInfoId(int infoId) { this.infoId = infoId; }
  
  public int getMerchant_count() {
    return this.merchant_count;
  }
  
  public void setMerchant_count(int merchant_count) { this.merchant_count = merchant_count; }
  
  public Object getMin_price()
  {
    try {
      this.min_price = new Integer(((BigDecimal)this.min_price).intValue());
    }
    catch (Exception localException) {}
    
    return this.min_price;
  }
  
  public void setMin_price(BigDecimal min_price) { this.min_price = min_price; }
  
  public Object getOld_price() {
    try {
      this.old_price = new Integer(((BigDecimal)this.old_price).intValue());
    }
    catch (Exception localException) {}
    
    return this.old_price;
  }
  
  public void setOld_price(BigDecimal old_price) { this.old_price = old_price; }
  
  public String getPicAddress() {
    return this.picAddress;
  }
  
  public void setPicAddress(String picAddress) { this.picAddress = picAddress; }
  
  public int getPicIsupdate() {
    return this.picIsupdate;
  }
  
  public void setPicIsupdate(int picIsupdate) { this.picIsupdate = picIsupdate; }
  
  public int getPrmaId() {
    return this.prmaId;
  }
  
  public void setPrmaId(int prmaId) { this.prmaId = prmaId; }
  
  public String getPrmaName() {
    return this.prmaName;
  }
  
  public void setPrmaName(String prmaName) { this.prmaName = prmaName; }
  
  public int getPrsoIdOne() {
    return this.prsoIdOne;
  }
  
  public void setPrsoIdOne(int prsoIdOne) { this.prsoIdOne = prsoIdOne; }
  
  public int getSortId() {
    return this.sortId;
  }
  
  public void setSortId(int sortId) { this.sortId = sortId; }
  
  public String getPrsoNameOneEn()
  {
    return this.prsoNameOneEn;
  }
  
  public void setPrsoNameOneEn(String prsoNameOneEn) { this.prsoNameOneEn = prsoNameOneEn; }
}
