package com.ding9.search.searcher.support.result;

import com.ding9.search.util.PageItem;



public class PaginationResult
{
  private int recordCount = 0;
  

  private int current = 1;
  
  private int totalPage = 1;
  
  private int start = 1;
  
  private int end = 1;
  
  private int previous = 1;
  
  private int next = 1;
  



  private boolean hasNextPage;
  


  private boolean hasPreviousPage;
  


  private static final int DEFAULT_PAGE_SIZE = 10;
  


  private int pageSize = 10;
  






  public int getNext()
  {
    int next = getCurrent();
    
    if ((getStart() + getPageSize() - 1 < this.recordCount) && (getCurrent() + 1 <= getTotalPage())) {
      next = getCurrent() + 1;
    }
    
    return next;
  }
  


































  public int getCurrent()
  {
    return this.current;
  }
  



  public void setCurrent(int current)
  {
    this.current = (current > 0 ? current : 1);
  }
  



  public int getPrevious()
  {
    int previous = 1;
    
    if (getCurrent() > 1) {
      previous = getCurrent() - 1;
    }
    
    return previous;
  }
  


  public PageItem[] getBefore()
  {
    if (getCurrent() > 11) {
      int[] numbers = { getCurrent() - 10, 
        getCurrent() - 9, 
        getCurrent() - 8, 
        getCurrent() - 7, 
        getCurrent() - 6, 
        getCurrent() - 5, 
        getCurrent() - 4, 
        getCurrent() - 3, 
        getCurrent() - 2, 
        getCurrent() - 1 };
      
      PageItem[] items = new PageItem[numbers.length];
      
      for (int i = 0; i < numbers.length; i++) {
        items[i] = new PageItem(numbers[i], 
          (numbers[i] - 1) * getPageSize() + 1);
      }
      
      return items;
    }
    int[] numbers = new int[getCurrent() - 1];
    
    PageItem[] items = new PageItem[numbers.length];
    
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = (i * getPageSize() + 1);
      items[i] = new PageItem(i + 1, numbers[i]);
    }
    
    return items;
  }
  




  public PageItem[] getAfter()
  {
    if (((getCurrent() + 10) * getPageSize() + 1 < getRecordCount()) && (getCurrent() + 10 < getTotalPage())) {
      int[] numbers = { this.current + 1, 
        this.current + 2, 
        this.current + 3, 
        this.current + 4, 
        this.current + 5, 
        this.current + 6, 
        this.current + 7, 
        this.current + 8, 
        this.current + 9 };
      
      PageItem[] items = new PageItem[numbers.length];
      
      for (int i = 0; i < numbers.length; i++) {
        items[i] = new PageItem(numbers[i], 
          (numbers[i] - 1) * getPageSize() + 1);
      }
      
      return items;
    }
    int[] numbers = new int[(getTotalPage() * getPageSize() - getStart()) / getPageSize()];
    
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = (getCurrent() + (i + 1));
    }
    
    PageItem[] items = new PageItem[numbers.length];
    
    for (int i = 0; i < numbers.length; i++) {
      items[i] = new PageItem(numbers[i], 
        (numbers[i] - 1) * getPageSize() + 1);
    }
    
    return items;
  }
  



  public int getStart()
  {
    int start = 1;
    
    start = 1 + (getCurrent() - 1) * getPageSize();
    
    return start;
  }
  



  public int getEnd()
  {
    int end = 1;
    
    end = getStart() - 1 + getPageSize();
    if (end > this.recordCount) { end = this.recordCount;
    }
    return end;
  }
  



  public int getRecordCount()
  {
    return this.recordCount;
  }
  



  public void setRecordCount(int recordCount)
  {
    this.recordCount = (recordCount > 0 ? recordCount : 0);
  }
  



  public int getPageSize()
  {
    return this.pageSize;
  }
  



  public void setPageSize(int pageSize)
  {
    this.pageSize = (pageSize > 0 ? pageSize : 10);
  }
  



















  public void setTotalPage()
  {
    if (this.recordCount % this.pageSize == 0) {
      this.totalPage = (this.recordCount / this.pageSize);
    }
    else {
      this.totalPage = (this.recordCount / this.pageSize + 1);
    }
  }
  


  public int getTotalPage()
  {
    return this.totalPage;
  }
  


  public boolean isHasNextPage()
  {
    if ((getCurrent() >= getNext()) || (getCurrent() >= getTotalPage())) {
      this.hasNextPage = false;
    } else {
      this.hasNextPage = true;
    }
    return this.hasNextPage;
  }
  



  public boolean isHasPreviousPage()
  {
    if (getCurrent() <= getPrevious()) {
      this.hasPreviousPage = false;
    } else {
      this.hasPreviousPage = true;
    }
    return this.hasPreviousPage;
  }
  
  public void setTotalPage(int totalPage)
  {
    this.totalPage = totalPage;
  }
  
  public void setEnd(int end) {
    this.end = end;
  }
  
  public void setStart(int start) {
    this.start = start;
  }
  
  public void setNext(int next) {
    this.next = next;
  }
  
  public void setPrevious(int previous) {
    this.previous = previous;
  }
}
