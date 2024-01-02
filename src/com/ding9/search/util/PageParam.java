package com.ding9.search.util;


public class PageParam
{
  public static final int DEFAULT_START = 1;
  public static final int DEFAULT_SIZE = 10;
  private int start = 1;
  
  private int size = 10;
  
  public PageParam() {
    this(1, 10);
  }
  
  public PageParam(int start) {
    this(start, 10);
  }
  
  public int getStartRecord() {
    int startRecord = (getStart() - 1) * getSize() + 1;
    
    return startRecord;
  }
  
  public int getEndRecord() {
    int endRecord = getStartRecord() - 1 + getSize();
    
    return endRecord;
  }
  
  public PageParam(int start, int size) {
    setStart(start);
    setSize(size);
  }
  
  public int getSize() {
    return this.size;
  }
  
  public void setSize(int size) {
    if (size > 0) {
      this.size = size;
    } else {
      this.size = 10;
    }
  }
  
  public int getStart() {
    return this.start;
  }
  
  public void setStart(int start) {
    if (start > 0) {
      this.start = start;
    } else {
      this.start = 1;
    }
  }
}
