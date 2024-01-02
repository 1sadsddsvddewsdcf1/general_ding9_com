package com.ding9.action;

import org.apache.struts.action.ActionForm;

public class BaseQueryForm
  extends ActionForm
{
  private int pagesize;
  private int pageNum;
  private int currentpage;
  
  public int getCurrentpage()
  {
    return this.currentpage;
  }
  
  public void setCurrentpage(int currentpage) {
    this.currentpage = currentpage;
  }
  
  public int getPagesize() {
    return this.pagesize;
  }
  
  public void setPagesize(int pagesize) {
    this.pagesize = pagesize;
  }
  
  public int getPageNum() {
    return this.pageNum;
  }
  
  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }
}
