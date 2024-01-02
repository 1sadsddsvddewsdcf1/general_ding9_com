package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.product.ProductMaster;

public class ProductMasterResult
  extends PaginationResult
{
  private ProductMaster[] records = null;
  




  public ProductMasterResult() {}
  



  public ProductMasterResult(ProductMaster[] records, int current, int page_size, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  





  public ProductMasterResult(ProductMaster[] records, int current, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  


  public ProductMaster[] getRecords()
  {
    return this.records;
  }
  



  public void setRecords(ProductMaster[] records)
  {
    this.records = records;
  }
}
