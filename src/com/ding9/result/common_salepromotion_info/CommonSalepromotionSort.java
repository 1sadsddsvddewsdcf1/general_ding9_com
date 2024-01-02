package com.ding9.result.common_salepromotion_info;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonSalepromotionSort implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    com.ding9.entity.common_salepromotion_info.CommonSalepromotionSort entity = new com.ding9.entity.common_salepromotion_info.CommonSalepromotionSort();
    try
    {
      entity.setSort_id(rs.getInt("sort_id"));
    } catch (Exception localException) {}
    try {
      entity.setSort_name(rs.getString("sort_name"));
    }
    catch (Exception localException1) {}
    return entity;
  }
}
