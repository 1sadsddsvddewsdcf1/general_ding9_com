package com.ding9.action.news;

import org.apache.struts.action.ActionForm;

public class NewsListForm extends ActionForm
{
  private static final long serialVersionUID = -8554325222689631739L;
  private int prso_id_one;
  private int relation_type;
  private int relation_value;
  private int page_size;
  private int current_page;
  private int memt_id;
  private int article_id;
  private int channelId;
  private String prso_name_one_en;
  
  public int getArticle_id()
  {
    return this.article_id;
  }
  
  public void setArticle_id(int article_id) {
    this.article_id = article_id;
  }
  
  public int getMemt_id() {
    return this.memt_id;
  }
  
  public void setMemt_id(int memt_id) {
    this.memt_id = memt_id;
  }
  
  public int getCurrent_page() {
    return this.current_page;
  }
  
  public void setCurrent_page(int current_page) {
    this.current_page = current_page;
  }
  
  public int getPage_size() {
    return this.page_size;
  }
  
  public void setPage_size(int page_size) {
    this.page_size = page_size;
  }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public int getRelation_type() {
    return this.relation_type;
  }
  
  public void setRelation_type(int relation_type) {
    this.relation_type = relation_type;
  }
  
  public int getRelation_value() {
    return this.relation_value;
  }
  
  public void setRelation_value(int relation_value) {
    this.relation_value = relation_value;
  }
  
  public int getChannelId() {
    return this.channelId;
  }
  
  public void setChannelId(int channelId) {
    this.channelId = channelId;
  }
  
  public String getPrso_name_one_en()
  {
    return this.prso_name_one_en;
  }
  
  public void setPrso_name_one_en(String prso_name_one_en)
  {
    this.prso_name_one_en = prso_name_one_en;
  }
}
