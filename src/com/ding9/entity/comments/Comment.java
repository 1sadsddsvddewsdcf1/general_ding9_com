package com.ding9.entity.comments;

import java.util.List;

public class Comment
{
  int id;
  String author_name;
  String prma_name;
  String advantage;
  String disadvantage;
  int product_level;
  String title;
  String content;
  String release_time;
  List mr;
  int mrcount;
  
  public int getMrcount() {
    return this.mrcount;
  }
  
  public void setMrcount(int mrcount) { this.mrcount = mrcount; }
  
  public String getRelease_time() {
    return this.release_time;
  }
  
  public void setRelease_time(String release_time) { this.release_time = release_time; }
  
  public String getAdvantage() {
    return this.advantage;
  }
  
  public void setAdvantage(String advantage) { this.advantage = advantage; }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) { this.content = content; }
  
  public String getDisadvantage() {
    return this.disadvantage;
  }
  
  public void setDisadvantage(String disadvantage) { this.disadvantage = disadvantage; }
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) { this.id = id; }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) { this.prma_name = prma_name; }
  
  public int getProduct_level() {
    return this.product_level;
  }
  
  public void setProduct_level(int product_level) { this.product_level = product_level; }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) { this.title = title; }
  
  public String getAuthor_name() {
    return this.author_name;
  }
  
  public void setAuthor_name(String author_name) { this.author_name = author_name; }
  
  public List getMr() {
    return this.mr;
  }
  
  public void setMr(List mr) { this.mr = mr; }
}
