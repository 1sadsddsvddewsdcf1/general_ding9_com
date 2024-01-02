package com.ding9.entity.result;

public class ProductBrand
{
  private int product_count;
  private int prso_id_one;
  private int prso_id_three;
  private String prso_name_three;
  
  public int getProduct_count() {
    return this.product_count;
  }
  
  public void setProduct_count(int product_count) { this.product_count = product_count; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public int getPrso_id_three() {
    return this.prso_id_three;
  }
  
  public void setPrso_id_three(int prso_id_three) { this.prso_id_three = prso_id_three; }
  
  public String getPrso_name_three() {
    return this.prso_name_three;
  }
  
  public void setPrso_name_three(String prso_name_three) { this.prso_name_three = prso_name_three; }
}
