package com.ding9.entity.articlesort;

import java.util.List;

public class ArticleSort {
  private int memtId;
  private String memtName;
  private int prso_id_one;
  private List article;
  
  public int getMemtId() {
    return this.memtId;
  }
  
  public int getPrso_id_one() { return this.prso_id_one; }
  
  public List getArticle() {
    return this.article;
  }
  
  public void setArticle(List article) { this.article = article; }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public void setMemtId(int memtId) { this.memtId = memtId; }
  
  public String getMemtName() {
    return this.memtName;
  }
  
  public void setMemtName(String memtName) { this.memtName = memtName; }
}
