package com.ding9.result.collection;

import com.ding9.entity.collection.UserTagVO;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTagRS implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    UserTagVO vo = new UserTagVO();
    
    try
    {
      vo.setLabel_id(rs.getInt("label_id"));
    }
    catch (Exception localException) {}
    try
    {
      vo.setUser_id(rs.getInt("user_id"));
    }
    catch (Exception localException1) {}
    try
    {
      vo.setUslb_id(rs.getInt("uslb_id"));
    }
    catch (Exception localException2) {}
    try {
      vo.setType(rs.getInt("type"));
    }
    catch (Exception localException3) {}
    try {
      vo.setLb_name(rs.getString("lb_name"));
    }
    catch (Exception localException4) {}
    return vo;
  }
}
