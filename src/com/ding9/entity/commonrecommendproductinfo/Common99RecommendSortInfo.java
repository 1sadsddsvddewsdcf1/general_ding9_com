package com.ding9.entity.commonrecommendproductinfo;

import java.util.List;

public class Common99RecommendSortInfo {
  private int sort_id;
  private int prso_id_one;
  private String sort_name;
  private int parent_id;
  private List sub;
  private List com99info;
  
  public int getParent_id() { return this.parent_id; }
  
  public void setParent_id(int parent_id) {
    this.parent_id = parent_id;
  }
  
  public int getPrso_id_one() { return this.prso_id_one; }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public int getSort_id() { return this.sort_id; }
  
  public List getCom99info() {
    return this.com99info;
  }
  
  public void setCom99info(List com99info) { this.com99info = com99info; }
  
  public List getSub() {
    return this.sub;
  }
  
  public void setSub(List sub) { this.sub = sub; }
  
  public void setSort_id(int sort_id) {
    this.sort_id = sort_id;
  }
  
  public String getSort_name() { return this.sort_name; }
  
  public void setSort_name(String sort_name) {
    this.sort_name = sort_name;
  }
}
