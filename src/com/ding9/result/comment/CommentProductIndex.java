package com.ding9.result.comment;

import com.ding9.entity.comment.CommentCount;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class CommentProductIndex
  implements BaseResult
{
  private CommentCount commentcount = null;
  


  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.commentcount = new CommentCount();
    
    this.commentcount.setCount(resultset.getInt("comment_count"));
    


    return this.commentcount;
  }
}
