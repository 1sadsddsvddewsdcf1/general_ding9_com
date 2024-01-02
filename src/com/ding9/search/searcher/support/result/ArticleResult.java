package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.article.Article;

public class ArticleResult
  extends PaginationResult
{
  private Article[] records = null;
  




  public ArticleResult() {}
  



  public ArticleResult(Article[] records, int current, int page_size, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  





  public ArticleResult(Article[] records, int current, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  


  public Article[] getRecords()
  {
    return this.records;
  }
  



  public void setRecords(Article[] records)
  {
    this.records = records;
  }
}
