package com.ding9.result.common_salepromotion_info;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Merchant implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    com.ding9.entity.common_salepromotion_info.Merchant entity = new com.ding9.entity.common_salepromotion_info.Merchant();
    try
    {
      entity.setMerc_name(rs.getString("merc_name"));
    } catch (Exception localException) {}
    try {
      entity.setMerc_address(rs.getString("merc_address"));
    }
    catch (Exception localException1) {}
    return entity;
  }
}
