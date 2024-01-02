package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.promotion.Promotion;

public class PromotionResult
  extends PaginationResult
{
  private Promotion[] records = null;
  




  public PromotionResult() {}
  



  public PromotionResult(Promotion[] records, int current, int page_size, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  





  public PromotionResult(Promotion[] records, int current, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  


  public Promotion[] getRecords()
  {
    return this.records;
  }
  



  public void setRecords(Promotion[] records)
  {
    this.records = records;
  }
}
