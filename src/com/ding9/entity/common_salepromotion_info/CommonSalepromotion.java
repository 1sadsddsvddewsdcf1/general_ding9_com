package com.ding9.entity.common_salepromotion_info;

public class CommonSalepromotion extends CommonSalepromotionInfo {
  private String merc_name;
  private String merc_address;
  private String prma_name;
  
  public String getMerc_address() {
    return this.merc_address;
  }
  
  public void setMerc_address(String address) { this.merc_address = address; }
  
  public String getMerc_name() {
    return this.merc_name;
  }
  
  public void setMerc_name(String name) { this.merc_name = name; }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String name) { this.prma_name = name; }
}
