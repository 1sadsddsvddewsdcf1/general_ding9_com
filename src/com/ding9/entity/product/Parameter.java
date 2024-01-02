package com.ding9.entity.product;

import java.util.List;

public class Parameter {
  private String para_name;
  private List para_value;
  
  public String getPara_name() {
    return this.para_name;
  }
  
  public void setPara_name(String para_name) { this.para_name = para_name; }
  
  public List getPara_value() {
    return this.para_value;
  }
  
  public void setPara_value(List para_value) { this.para_value = para_value; }
}
