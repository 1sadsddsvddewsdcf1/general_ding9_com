package com.ding9.entity.recommend;

public class RecommendUrl {
  private String url;
  private int prma_id;
  private int Count;
  private String prma_url;
  
  public int getCount() { return this.Count; }
  
  public void setCount(int count) {
    this.Count = count;
  }
  
  public int getPrma_id() { return this.prma_id; }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public String getUrl() { return this.url; }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public String getPrma_url() { return this.prma_url; }
  
  public void setPrma_url(String prma_url) {
    this.prma_url = prma_url;
  }
}
