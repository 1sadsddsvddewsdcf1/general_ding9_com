package com.ding9.multipleentity;

public class MuCheapCardInfo {
  private String web_name;
  private String web_url;
  private String web_logo;
  private String sort_name;
  private String title;
  private String end_time;
  private String scale;
  private int card_id;
  private int merc_id;
  
  public int getCard_id() { return this.card_id; }
  
  public void setCard_id(int card_id) {
    this.card_id = card_id;
  }
  
  public int getMerc_id() { return this.merc_id; }
  
  public void setMerc_id(int merc_id) {
    this.merc_id = merc_id;
  }
  
  public String getScale() { return this.scale; }
  
  public void setScale(String scale) {
    this.scale = scale;
  }
  
  public String getSort_name() { return this.sort_name; }
  
  public void setSort_name(String sort_name) {
    this.sort_name = sort_name;
  }
  
  public String getEnd_time() {
    return this.end_time;
  }
  
  public void setEnd_time(String end_time) { this.end_time = end_time; }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) { this.title = title; }
  
  public String getWeb_logo() {
    return this.web_logo;
  }
  
  public void setWeb_logo(String web_logo) { this.web_logo = web_logo; }
  
  public String getWeb_name() {
    return this.web_name;
  }
  
  public void setWeb_name(String web_name) { this.web_name = web_name; }
  
  public String getWeb_url() {
    return this.web_url;
  }
  
  public void setWeb_url(String web_url) { this.web_url = web_url; }
}
