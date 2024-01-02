package com.ding9.entity.message;

public class NewProductNews {
  private int pauto_id;
  private int prso_id_one;
  private int prma_id;
  private String prso_title;
  private String news_from;
  private String prso_counnet;
  private String syne_time;
  
  public String getNews_from() { return this.news_from; }
  
  public void setNews_from(String news_from) {
    this.news_from = news_from;
  }
  
  public int getPauto_id() { return this.pauto_id; }
  
  public void setPauto_id(int pauto_id) {
    this.pauto_id = pauto_id;
  }
  
  public int getPrma_id() { return this.prma_id; }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public String getPrso_counnet() { return this.prso_counnet; }
  
  public void setPrso_counnet(String prso_counnet) {
    this.prso_counnet = prso_counnet;
  }
  
  public int getPrso_id_one() { return this.prso_id_one; }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public String getPrso_title() { return this.prso_title; }
  
  public void setPrso_title(String prso_title) {
    this.prso_title = prso_title;
  }
  
  public String getSyne_time() { return this.syne_time; }
  
  public void setSyne_time(String syne_time) {
    this.syne_time = syne_time;
  }
}
