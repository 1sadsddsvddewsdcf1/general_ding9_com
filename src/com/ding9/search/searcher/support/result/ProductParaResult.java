package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.productparasort.ProductPara;

public class ProductParaResult extends PaginationResult {
  private ProductPara[] records = null;
  




  public ProductParaResult() {}
  



  public ProductParaResult(ProductPara[] records, int current, int page_size, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  





  public ProductParaResult(ProductPara[] records, int current, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  


  public ProductPara[] getRecords()
  {
    return this.records;
  }
  



  public void setRecords(ProductPara[] records)
  {
    this.records = records;
  }
}
