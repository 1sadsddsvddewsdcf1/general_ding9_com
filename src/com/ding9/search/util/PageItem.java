package com.ding9.search.util;

public class PageItem
{
  int page;
  int start;
  
  public PageItem(int page, int start) {
    this.page = page;
    this.start = start;
  }
  
  public int getPage() {
    return this.page;
  }
  
  public void setPage(int page) {
    this.page = page;
  }
  
  public int getStart() {
    return this.start;
  }
  
  public void setStart(int start) {
    this.start = start;
  }
}
