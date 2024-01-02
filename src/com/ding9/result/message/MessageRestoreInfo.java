package com.ding9.result.message;

import com.ding9.entity.comment.MessageRestore;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;







public class MessageRestoreInfo
  implements BaseResult
{
  private MessageRestore message = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.message = new MessageRestore();
    this.message.setUser_id(resultset.getInt("user_id"));
    this.message.setMere_content(resultset.getString("mere_content"));
    this.message.setMere_time(resultset.getString("mere_time"));
    
    return this.message;
  }
}
