package com.ding9.search.util;

import java.util.ArrayList;
import java.util.List;

public class Pagination
{
  private List records = new ArrayList();
  

  private int recordCount = 0;
  

  private int current = 1;
  
  int totalPage = 0;
  


  PageItem nextPage;
  


  PageItem previousPage;
  


  private static final int DEFAULT_PAGE_SIZE = 10;
  

  private int pageSize = 10;
  




  public Pagination() {}
  



  public Pagination(List records, int current, int page_size, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
    setTotalPage();
  }
  





  public Pagination(List records, int current, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setRecordCount(recordCount);
    setTotalPage();
  }
  



  public List getRecords()
  {
    return this.records;
  }
  



  public void setRecords(List records)
  {
    this.records = records;
  }
  



  public int getNext()
  {
    int next = getCurrent();
    
    if (getStart() + getPageSize() - 1 < this.recordCount) {
      next = getCurrent() + 1;
    }
    
    return next;
  }
  


  public PageItem getNextPage()
  {
    if (getNext() > getCurrent()) {
      this.nextPage = new PageItem(getNext(), 1 + getCurrent() * getPageSize());
    } else {
      this.nextPage = new PageItem(getCurrent(), 1 + (getCurrent() - 1) * getPageSize());
    }
    
    return this.nextPage;
  }
  



  public PageItem getPreviousPage()
  {
    if (getPrevious() > 1) {
      this.previousPage = new PageItem(getPrevious(), 1 + (getPrevious() - 1) * getPageSize());
    } else {
      this.nextPage = new PageItem(getCurrent(), 1 + (getCurrent() - 1) * getPageSize());
    }
    
    return this.previousPage;
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
    if (getCurrent() > 6) {
      int[] numbers = { getCurrent() - 5, 
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
    if (((getCurrent() + 5) * getPageSize() + 1 < getRecordCount()) && (getCurrent() + 5 < getTotalPage())) {
      int[] numbers = { this.current + 1, 
        this.current + 2, 
        this.current + 3, 
        this.current + 4, 
        this.current + 5 };
      
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
  


  public void setTotalPage(int tpage)
  {
    this.totalPage = (tpage > 0 ? tpage : 0);
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
}
