package com.ding9.entity.recommend;

public class RecommendProductSort
{
  private int prma_id;
  private String prma_name;
  private int prso_id;
  private int prso_id_one;
  private String prma_remark;
  private String web_address;
  private String prac_address;
  
  public String getPrac_address()
  {
    return this.prac_address;
  }
  
  public void setPrac_address(String prac_address) { this.prac_address = prac_address; }
  
  public String getWeb_address() {
    return this.web_address;
  }
  
  public void setWeb_address(String web_address) { this.web_address = web_address; }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) { this.prma_id = prma_id; }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) { this.prma_name = prma_name; }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) { this.prso_id = prso_id; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public String getPrma_remark() {
    return this.prma_remark;
  }
  
  public void setPrma_remark(String prma_remark) { this.prma_remark = prma_remark; }
}
