package com.ding9.result.message;

import com.ding9.entity.message.Credit;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class MercCreditInfo
  implements BaseResult
{
  private Credit cc = null;
  


  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.cc = new Credit();
    this.cc.setCocr_id(resultset.getInt("cocr_id"));
    this.cc.setCocr_reason(resultset.getString("cocr_reason"));
    this.cc.setCogr_credit(resultset.getInt("cogr_credit"));
    this.cc.setCocr_time(resultset.getString("cocr_time"));
    this.cc.setName(resultset.getString("user_name"));
    this.cc.setOrde_id(resultset.getInt("orde_id"));
    this.cc.setUser_id(resultset.getInt("user_id"));
    return this.cc;
  }
}
