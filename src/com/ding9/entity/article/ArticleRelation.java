package com.ding9.entity.article;

import java.util.List;







public class ArticleRelation
{
  private int article_id;
  private String title;
  private int memt_id;
  private String source_type;
  private String release_time;
  private String url;
  private String source;
  private String author;
  private String source_relation_type;
  private String source_relation_value;
  private String content;
  private int display;
  private String pagination_sign;
  private int total_page;
  private String content_curr_page;
  private List content_per_page;
  private int prso_id_one;
  private String prso_name_one_en;
  
  public List getContent_per_page()
  {
    return this.content_per_page;
  }
  
  public void setContent_per_page(List content_per_page) { this.content_per_page = content_per_page; }
  
  public String getPagination_sign() {
    return this.pagination_sign;
  }
  
  public void setPagination_sign(String pagination_sign) { this.pagination_sign = pagination_sign; }
  
  public int getArticle_id() {
    return this.article_id;
  }
  
  public void setArticle_id(int article_id) { this.article_id = article_id; }
  
  public String getAuthor() {
    return this.author;
  }
  
  public void setAuthor(String author) { this.author = author; }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) { this.content = content; }
  
  public int getDisplay() {
    return this.display;
  }
  
  public void setDisplay(int display) { this.display = display; }
  
  public int getMemt_id() {
    return this.memt_id;
  }
  
  public void setMemt_id(int memt_id) { this.memt_id = memt_id; }
  
  public String getRelease_time() {
    return this.release_time;
  }
  
  public void setRelease_time(String release_time) { this.release_time = release_time; }
  
  public String getSource() {
    return this.source;
  }
  
  public void setSource(String source) { this.source = source; }
  
  public String getSource_relation_type() {
    return this.source_relation_type;
  }
  
  public void setSource_relation_type(String source_relation_type) { this.source_relation_type = source_relation_type; }
  
  public String getSource_relation_value() {
    return this.source_relation_value;
  }
  
  public void setSource_relation_value(String source_relation_value) { this.source_relation_value = source_relation_value; }
  
  public String getSource_type() {
    return this.source_type;
  }
  
  public void setSource_type(String source_type) { this.source_type = source_type; }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) { this.title = title; }
  
  public String getUrl() {
    return this.url;
  }
  
  public void setUrl(String url) { this.url = url; }
  
  public int getTotal_page() {
    return this.total_page;
  }
  
  public void setTotal_page(int total_page) { this.total_page = total_page; }
  
  public String getContent_curr_page() {
    return this.content_curr_page;
  }
  
  public void setContent_curr_page(String content_curr_page) { this.content_curr_page = content_curr_page; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public String getPrso_name_one_en() {
    return this.prso_name_one_en;
  }
  
  public void setPrso_name_one_en(String name) { this.prso_name_one_en = name; }
}
