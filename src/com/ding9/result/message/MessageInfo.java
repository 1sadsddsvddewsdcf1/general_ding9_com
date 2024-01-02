package com.ding9.result.message;

import com.ding9.entity.commentsonproduct.CommentsOnProduct;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;






public class MessageInfo
  implements BaseResult
{
  private CommentsOnProduct message = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.message = new CommentsOnProduct();
    this.message.setAuthorId(resultset.getInt("author_id"));
    this.message.setTitle(resultset.getString("title"));
    this.message.setId(resultset.getInt("id"));
    this.message.setContent(resultset.getString("content"));
    this.message.setDisadvantage(resultset.getString("disadvantage"));
    this.message.setAdvantage(resultset.getString("advantage"));
    this.message.setReleaseTime(resultset.getString("release_time"));
    this.message.setSourceUrl(resultset.getString("source_url"));
    this.message.setSource(resultset.getString("source"));
    this.message.setAuthorName(resultset.getString("author_name"));
    return this.message;
  }
}
