package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.merchant.MerchantInfo;






public class MerchantInfoResult
  extends PaginationResult
{
  private MerchantInfo[] vo = null;
  



  public MerchantInfoResult() {}
  



  public MerchantInfoResult(MerchantInfo[] vo, int current, int page_size, int recordCount)
  {
    setRecords(vo);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  





  public MerchantInfoResult(MerchantInfo[] vo, int current, int recordCount)
  {
    setRecords(vo);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  



  public MerchantInfo[] getRecords()
  {
    return this.vo;
  }
  



  public void setRecords(MerchantInfo[] vo)
  {
    this.vo = vo;
  }
}
