package com.ding9.result.message;

import com.ding9.entity.message.MessageManage;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;







public class MessageListInfo
  implements BaseResult
{
  private MessageManage message = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.message = new MessageManage();
    this.message.setMemt_id(resultset.getInt("memt_id"));
    this.message.setMema_id(resultset.getInt("mema_id"));
    this.message.setMema_title(resultset.getString("mema_title"));
    
    this.message.setMema_content(StringHelper.outputStrToHtml(resultset.getString("mema_content")));
    
    this.message.setMema_http(resultset.getString("mema_http"));
    this.message.setMema_time(resultset.getString("mema_time"));
    
    return this.message;
  }
}
