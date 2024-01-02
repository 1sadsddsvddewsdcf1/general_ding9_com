package com.ding9.entity.indexkey;

public class KeywordsOptimize {
  private int keop_id;
  private int keot_id;
  private String keop_title;
  private String keop_keywords;
  private String keop_description;
  
  public String getKeop_description() { return this.keop_description; }
  
  public void setKeop_description(String keop_description) {
    this.keop_description = keop_description;
  }
  
  public int getKeop_id() { return this.keop_id; }
  
  public void setKeop_id(int keop_id) {
    this.keop_id = keop_id;
  }
  
  public String getKeop_keywords() { return this.keop_keywords; }
  
  public void setKeop_keywords(String keop_keywords) {
    this.keop_keywords = keop_keywords;
  }
  
  public String getKeop_title() { return this.keop_title; }
  
  public void setKeop_title(String keop_title) {
    this.keop_title = keop_title;
  }
  
  public int getKeot_id() { return this.keot_id; }
  
  public void setKeot_id(int keot_id) {
    this.keot_id = keot_id;
  }
}
