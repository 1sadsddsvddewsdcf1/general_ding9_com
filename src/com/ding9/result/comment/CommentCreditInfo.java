package com.ding9.result.comment;

import com.ding9.entity.comment.CommentCredit;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class CommentCreditInfo
  implements BaseResult
{
  private CommentCredit cc = null;
  


  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.cc = new CommentCredit();
    this.cc.setCocr_id(resultset.getInt("cocr_id"));
    this.cc.setCocr_reason(resultset.getString("cocr_reason"));
    this.cc.setCocr_time(resultset.getString("cocr_time"));
    this.cc.setCocr_user_id(resultset.getInt("cocr_user_id"));
    this.cc.setOrde_id(resultset.getInt("orde_id"));
    this.cc.setUser_id(resultset.getInt("user_id"));
    return this.cc;
  }
}
