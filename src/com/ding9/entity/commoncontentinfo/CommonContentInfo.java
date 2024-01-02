package com.ding9.entity.commoncontentinfo;

public class CommonContentInfo {
  private int infoId;
  private String title;
  private String content;
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) { this.content = content; }
  
  public int getInfoId() {
    return this.infoId;
  }
  
  public void setInfoId(int infoId) { this.infoId = infoId; }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) { this.title = title; }
}
