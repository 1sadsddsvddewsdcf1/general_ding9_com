package com.ding9.result.search;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductBrand implements BaseResult
{
  private com.ding9.entity.search.ProductBrand productBrand = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.productBrand = new com.ding9.entity.search.ProductBrand();
    
    this.productBrand.setId(resultset.getInt("prbr_id"));
    this.productBrand.setName(resultset.getString("prbr_name"));
    
    return this.productBrand;
  }
}
