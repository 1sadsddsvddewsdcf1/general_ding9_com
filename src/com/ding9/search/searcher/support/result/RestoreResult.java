package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.comment.RestoreVO;


public class RestoreResult
  extends PaginationResult
{
  private RestoreVO[] vo = null;
  

  public RestoreResult() {}
  
  public RestoreResult(RestoreVO[] vo, int current, int page_size, int recordCount)
  {
    setRecords(vo);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  









  public RestoreResult(RestoreVO[] vo, int current, int recordCount)
  {
    setRecords(vo);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  




  public RestoreVO[] getRecords()
  {
    return this.vo;
  }
  




  public void setRecords(RestoreVO[] vo)
  {
    this.vo = vo;
  }
}
