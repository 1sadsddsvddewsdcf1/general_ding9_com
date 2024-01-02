package com.ding9.search.entity.product;

import com.ding9.search.util.StringHelper;






public class ProductBrand
{
  private int prbr_id;
  private String prbr_name = "";
  

  private String prbr_english_name = "";
  
  public String getPrbr_english_name() {
    return this.prbr_english_name;
  }
  
  public void setPrbr_english_name(String prbr_english_name) {
    this.prbr_english_name = StringHelper.getRealString(prbr_english_name);
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
}
