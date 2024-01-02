package com.ding9.result.message;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;







public class CreditAvg
  implements BaseResult
{
  private com.ding9.entity.message.CreditAvg avg = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.avg = new com.ding9.entity.message.CreditAvg();
    
    this.avg.setAvg(resultset.getFloat("avg"));
    
    return this.avg;
  }
}
