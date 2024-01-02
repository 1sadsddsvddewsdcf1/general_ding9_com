package com.ding9.search.entity.merchant;

import com.ding9.search.util.StringHelper;

public class MerchantPlayment {
  private String key = "";
  private String value = "";
  
  public String getKey() { return this.key; }
  
  public void setKey(String key) {
    this.key = StringHelper.getRealString(key);
  }
  
  public String getValue() { return this.value; }
  
  public void setValue(String value) {
    this.value = StringHelper.getRealString(value);
  }
}
