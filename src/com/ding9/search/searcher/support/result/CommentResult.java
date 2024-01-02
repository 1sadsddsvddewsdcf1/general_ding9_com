package com.ding9.search.searcher.support.result;

import com.ding9.search.entity.comment.Comment;

public class CommentResult
  extends PaginationResult
{
  private Comment[] records = null;
  




  public CommentResult() {}
  



  public CommentResult(Comment[] records, int current, int page_size, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setPageSize(page_size);
    setRecordCount(recordCount);
  }
  





  public CommentResult(Comment[] records, int current, int recordCount)
  {
    setRecords(records);
    setCurrent(current);
    setRecordCount(recordCount);
  }
  


  public Comment[] getRecords()
  {
    return this.records;
  }
  



  public void setRecords(Comment[] records)
  {
    this.records = records;
  }
}
