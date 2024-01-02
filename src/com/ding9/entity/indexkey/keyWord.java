package com.ding9.entity.indexkey;

public class keyWord {
  private int kw_id;
  private int prso_id_one;
  private String keyword;
  
  public String getKeyword() { return this.keyword; }
  
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }
  
  public int getKw_id() { return this.kw_id; }
  
  public void setKw_id(int kw_id) {
    this.kw_id = kw_id;
  }
  
  public int getPrso_id_one() { return this.prso_id_one; }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
}
