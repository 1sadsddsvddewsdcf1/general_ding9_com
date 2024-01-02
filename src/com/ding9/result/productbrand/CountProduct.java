package com.ding9.result.productbrand;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountProduct implements BaseResult
{
  private com.ding9.entity.productbrand.CountProduct entity = null;
  
  public Object getMapRow(ResultSet rs, int i) throws SQLException {
    this.entity = new com.ding9.entity.productbrand.CountProduct();
    
    this.entity.setCnt(rs.getInt("CNT"));
    
    return this.entity;
  }
}
