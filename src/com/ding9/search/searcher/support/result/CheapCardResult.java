package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.cheapcard.CheapCard;


public class CheapCardResult
  extends PaginationResult
{
  private CheapCard[] records = null;
  




  public CheapCardResult() {}
  



  public CheapCardResult(CheapCard[] records, int current, int page_size, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  





  public CheapCardResult(CheapCard[] records, int current, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  


  public CheapCard[] getRecords()
  {
    return this.records;
  }
  



  public void setRecords(CheapCard[] records)
  {
    this.records = records;
  }
}
