package com.ding9.action;


public class PaginationQuery
  extends BaseQuery
{
  public static final int DEFAULT_CURRENT_PAGE = 1;
  
  public static final int DEFAULT_PAGESIZE = 10;
  
  private int pageSize = 10;
  

  private int currentPage = 1;
  
  public int getCurrentPage() {
    return this.currentPage;
  }
  
  public void setCurrentPage(int currentPage) {
    if (currentPage > 0) {
      this.currentPage = currentPage;
    }
    else {
      this.currentPage = 1;
    }
  }
  
  public int getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(int pageSize) {
    if (pageSize > 0) {
      this.pageSize = pageSize;
    }
    else {
      this.pageSize = 10;
    }
  }
}
