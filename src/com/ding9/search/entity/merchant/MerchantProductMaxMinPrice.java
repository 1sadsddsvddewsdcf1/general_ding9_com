package com.ding9.search.entity.merchant;


public class MerchantProductMaxMinPrice
{
  private float min_price;
  
  private float max_price;
  
  private int merchant_count;
  
  private int prma_id;
  
  public float getMax_price()
  {
    return this.max_price;
  }
  
  public void setMax_price(float max_price) { this.max_price = max_price; }
  
  public int getMerchant_count() {
    return this.merchant_count;
  }
  
  public void setMerchant_count(int merchant_count) { this.merchant_count = merchant_count; }
  
  public float getMin_price() {
    return this.min_price;
  }
  
  public void setMin_price(float min_price) { this.min_price = min_price; }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) { this.prma_id = prma_id; }
}
