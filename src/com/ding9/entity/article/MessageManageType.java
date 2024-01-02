package com.ding9.entity.article;

import java.util.List;







public class MessageManageType
{
  private int memt_id;
  private int prso_id_one;
  private String memt_name;
  private List article_relation;
  private int article_size;
  
  public int getMemt_id()
  {
    return this.memt_id;
  }
  
  public void setMemt_id(int memt_id) { this.memt_id = memt_id; }
  
  public String getMemt_name() {
    return this.memt_name;
  }
  
  public void setMemt_name(String memt_name) { this.memt_name = memt_name; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public List getArticle_relation() {
    return this.article_relation;
  }
  
  public void setArticle_relation(List article_relation) { this.article_relation = article_relation; }
  
  public int getArticle_size() {
    return this.article_size;
  }
  
  public void setArticle_size(int article_size) { this.article_size = article_size; }
}
