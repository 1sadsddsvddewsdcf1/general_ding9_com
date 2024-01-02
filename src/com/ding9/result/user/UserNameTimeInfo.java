package com.ding9.result.user;

import com.ding9.entity.user.User;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;







public class UserNameTimeInfo
  implements BaseResult
{
  private User info = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.info = new User();
    this.info.setUser_name(resultset.getString("user_name"));
    this.info.setUser_date_reg(resultset.getString("user_date_reg"));
    return this.info;
  }
}
