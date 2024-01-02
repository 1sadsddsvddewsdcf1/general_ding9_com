package com.ding9.sql;

import java.util.ArrayList;

public class PagedList extends ArrayList
{
  private static final long serialVersionUID = 1L;
  private int recordcount;
  private int pagecount;
  private int pageSize;
  private int pageNum;
  private boolean hasPreviousPage;
  private boolean hasNextPage;
  private int startRecordIndex;
  private int endRecordIndex;
  
  public PagedList() {}
  
  public PagedList(int initialCapacity)
  {
    super(initialCapacity);
  }
  


  public boolean isHasNextPage()
  {
    if (this.pageNum >= this.pagecount) {
      this.hasNextPage = false;
    } else {
      this.hasNextPage = true;
    }
    return this.hasNextPage;
  }
  

  public boolean isHasPreviousPage()
  {
    if (this.pageNum - 1 > 0) {
      this.hasPreviousPage = true;
    } else {
      this.hasPreviousPage = false;
    }
    return this.hasPreviousPage;
  }
  
  public int getStartRecordIndex() {
    this.startRecordIndex = ((this.pageNum - 1) * this.pageSize + 1);
    if (this.startRecordIndex > getRecordcount()) {
      this.startRecordIndex = getRecordcount();
    }
    return this.startRecordIndex;
  }
  
  public int getEndRecordIndex() {
    this.endRecordIndex = (getPageNum() * getPageSize());
    if (this.endRecordIndex > getRecordcount()) {
      this.endRecordIndex = getRecordcount();
    }
    return this.endRecordIndex;
  }
  
  public int getPageNum() {
    return this.pageNum;
  }
  
  public void setPageNum(int pageNum) { this.pageNum = pageNum; }
  
  public int getCurrentpage() {
    return this.pageNum;
  }
  
  public void setCurrentpage(int currentpage) { this.pageNum = currentpage; }
  
  public int getPagecount() {
    return this.pagecount;
  }
  
  public void setPagecount(int pagecount) { this.pagecount = pagecount; }
  
  public int getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(int pageSize) { this.pageSize = pageSize; }
  
  public int getRecordcount() {
    return this.recordcount;
  }
  
  public void setRecordcount(int recordcount) { this.recordcount = recordcount; }
  




  public int getPreviousPage()
  {
    int previouspage = 1;
    if (this.pageNum > 1) {
      previouspage = this.pageNum - 1;
    }
    return previouspage;
  }
  



  public int getNextPage()
  {
    int nextpage = 1;
    if (this.pageNum >= this.pagecount) {
      nextpage = this.pagecount;
    } else {
      nextpage = this.pageNum + 1;
    }
    return nextpage;
  }
  
  public String toString() {
    return "PagedList:" + super.toString();
  }
}
