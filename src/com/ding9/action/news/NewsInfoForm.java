package com.ding9.action.news;

import org.apache.struts.action.ActionForm;

public class NewsInfoForm extends ActionForm
{
  private static final long serialVersionUID = -356665386053946759L;
  private int channelId;
  private int article_id;
  private int current_page;
  private int prso_id_one;
  private String prso_name_one_en;
  
  public int getChannelId()
  {
    return this.channelId;
  }
  
  public void setChannelId(int channelId) {
    this.channelId = channelId;
  }
  
  public int getCurrent_page() {
    return this.current_page;
  }
  
  public void setCurrent_page(int current_page) {
    this.current_page = current_page;
  }
  
  public int getArticle_id() {
    return this.article_id;
  }
  
  public void setArticle_id(int article_id) {
    this.article_id = article_id;
  }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public String getPrso_name_one_en() {
    return this.prso_name_one_en;
  }
  
  public void setPrso_name_one_en(String prso_name_one_en) {
    this.prso_name_one_en = prso_name_one_en;
  }
}
