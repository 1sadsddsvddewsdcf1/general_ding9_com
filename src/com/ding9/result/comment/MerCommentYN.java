package com.ding9.result.comment;

import com.ding9.entity.comment.MerchantComment;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;








public class MerCommentYN
  implements BaseResult
{
  private MerchantComment mc = null;
  


  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.mc = new MerchantComment();
    this.mc.setClick_y(resultset.getInt("click_y"));
    this.mc.setClick_n(resultset.getInt("click_n"));
    return this.mc;
  }
}
