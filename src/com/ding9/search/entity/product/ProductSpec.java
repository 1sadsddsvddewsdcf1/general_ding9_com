package com.ding9.search.entity.product;

public class ProductSpec {
  private String prac_id = "";
  private String[] values;
  
  public ProductSpec(String prac_id, String[] values)
  {
    this.prac_id = prac_id;
    this.values = values;
  }
  
  public String getPrac_id() {
    return this.prac_id;
  }
  
  public String[] getValues() {
    return this.values;
  }
  
  public String get(int index) {
    return this.values[index];
  }
}
