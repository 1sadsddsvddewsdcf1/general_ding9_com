package com.ding9.result.comment;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageManage implements BaseResult
{
  private com.ding9.entity.comment.MessageManage messageManage = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.messageManage = new com.ding9.entity.comment.MessageManage();
    
    this.messageManage.setMema_exceptive(resultset.getInt("mema_exceptive"));
    this.messageManage.setMema_gabble(resultset.getInt("mema_gabble"));
    this.messageManage.setMema_id(resultset.getInt("mema_id"));
    this.messageManage.setMema_star(resultset.getInt("mema_star"));
    this.messageManage.setMema_system(resultset.getInt("mema_system"));
    this.messageManage.setMemt_id(resultset.getInt("memt_id"));
    this.messageManage.setPrma_id(resultset.getInt("prma_id"));
    this.messageManage.setPrso_id(resultset.getInt("prso_id"));
    this.messageManage.setUser_id(resultset.getInt("user_id"));
    
    this.messageManage.setMema_content(resultset.getString("mema_content"));
    this.messageManage.setMema_defect(resultset.getString("mema_defect"));
    this.messageManage.setMema_http(resultset.getString("mema_http"));
    this.messageManage.setMema_merit(resultset.getString("mema_merit"));
    this.messageManage.setMema_title(resultset.getString("mema_title"));
    
    this.messageManage.setMema_time(resultset.getDate("mema_time"));
    
    return this.messageManage;
  }
}
