package com.ding9.entity.productbrand;



public class ProductBrand
{
  private int prbr_id;
  
  private int prso_id;
  
  private int cnt;
  
  private String prbr_name;
  
  private String prbr_english_name;
  
  private int prso_id_one;
  
  private String prso_name_one_en;
  
  private int prso_id_three;
  
  private String prso_name_three_en;
  

  public String getPrbr_english_name()
  {
    return this.prbr_english_name;
  }
  
  public void setPrbr_english_name(String prbr_english_name) { this.prbr_english_name = prbr_english_name; }
  
  public int getPrbr_id() {
    return this.prbr_id;
  }
  
  public void setPrbr_id(int prbr_id) { this.prbr_id = prbr_id; }
  
  public String getPrbr_name() {
    return this.prbr_name;
  }
  
  public void setPrbr_name(String prbr_name) { this.prbr_name = prbr_name; }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) { this.prso_id = prso_id; }
  
  public int getCnt() {
    return this.cnt;
  }
  
  public void setCnt(int cnt) { this.cnt = cnt; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public String getPrso_name_one_en() {
    return this.prso_name_one_en;
  }
  
  public void setPrso_name_one_en(String name) { this.prso_name_one_en = name; }
  
  public int getPrso_id_three() {
    return this.prso_id_three;
  }
  
  public void setPrso_id_three(int prso_id_three) { this.prso_id_three = prso_id_three; }
  
  public String getPrso_name_three_en() {
    return this.prso_name_three_en;
  }
  
  public void setPrso_name_three_en(String name) { this.prso_name_three_en = name; }
}
