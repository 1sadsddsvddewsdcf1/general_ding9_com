package com.ding9.result.category;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageManager implements BaseResult
{
  private com.ding9.entity.category.MessageManager messageManager = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.messageManager = new com.ding9.entity.category.MessageManager();
    
    this.messageManager.setMema_id(resultset.getInt("mema_id"));
    this.messageManager.setMemt_id(resultset.getInt("memt_id"));
    this.messageManager.setPrso_id(resultset.getInt("prso_id"));
    
    this.messageManager.setMema_title(resultset.getString("mema_title"));
    this.messageManager.setMema_content(resultset.getString("mema_content"));
    this.messageManager.setMema_time(resultset.getDate("mema_time"));
    
    return this.messageManager;
  }
}
