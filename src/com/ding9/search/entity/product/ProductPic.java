package com.ding9.search.entity.product;

import com.ding9.search.util.StringHelper;





public class ProductPic
{
  private int prpi_id;
  private int prma_id;
  private String prac_address = "";
  

  private String web_address = "";
  
  public String getPrac_address() {
    return this.prac_address;
  }
  
  public void setPrac_address(String prac_address) {
    this.prac_address = StringHelper.getRealString(prac_address);
  }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public int getPrpi_id() {
    return this.prpi_id;
  }
  
  public void setPrpi_id(int prpi_id) {
    this.prpi_id = prpi_id;
  }
  
  public String getWeb_address() {
    return this.web_address;
  }
  
  public void setWeb_address(String web_address) {
    this.web_address = StringHelper.getRealString(web_address);
  }
}
