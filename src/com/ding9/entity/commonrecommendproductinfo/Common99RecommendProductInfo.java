package com.ding9.entity.commonrecommendproductinfo;

public class Common99RecommendProductInfo
{
  private int info_id;
  private int sort_id;
  private int prso_id_one;
  private int pram_id;
  private String prma_name;
  private String prso_name_one_en;
  
  public int getInfo_id()
  {
    return this.info_id;
  }
  
  public void setInfo_id(int info_id) { this.info_id = info_id; }
  
  public int getPram_id() {
    return this.pram_id;
  }
  
  public void setPram_id(int pram_id) { this.pram_id = pram_id; }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) { this.prma_name = prma_name; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public int getSort_id() {
    return this.sort_id;
  }
  
  public void setSort_id(int sort_id) { this.sort_id = sort_id; }
  
  public String getPrso_name_one_en() {
    return this.prso_name_one_en;
  }
  
  public void setPrso_name_one_en(String name) { this.prso_name_one_en = name; }
}
