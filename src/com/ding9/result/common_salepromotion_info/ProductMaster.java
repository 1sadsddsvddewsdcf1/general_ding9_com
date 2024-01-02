package com.ding9.result.common_salepromotion_info;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMaster implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    com.ding9.entity.common_salepromotion_info.ProductMaster entity = new com.ding9.entity.common_salepromotion_info.ProductMaster();
    
    entity.setPrma_name(rs.getString("prma_name"));
    
    return entity;
  }
}
