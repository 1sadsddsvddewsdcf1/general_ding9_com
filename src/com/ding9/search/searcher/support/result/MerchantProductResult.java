package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.merchantproduct.MerchantProduct;



public class MerchantProductResult
  extends PaginationResult
{
  private MerchantProduct[] records = null;
  




  public MerchantProductResult() {}
  



  public MerchantProductResult(MerchantProduct[] records, int current, int page_size, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  





  public MerchantProductResult(MerchantProduct[] records, int current, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  


  public MerchantProduct[] getRecords()
  {
    return this.records;
  }
  



  public void setRecords(MerchantProduct[] records)
  {
    this.records = records;
  }
}
