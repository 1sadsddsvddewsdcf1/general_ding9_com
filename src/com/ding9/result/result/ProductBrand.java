package com.ding9.result.result;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductBrand implements BaseResult
{
  private com.ding9.entity.result.ProductBrand productBrand = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.productBrand = new com.ding9.entity.result.ProductBrand();
    
    this.productBrand.setProduct_count(resultset.getInt("product_count"));
    this.productBrand.setPrso_id_one(resultset.getInt("prso_id_one"));
    this.productBrand.setPrso_id_three(resultset.getInt("prso_id_three"));
    this.productBrand.setPrso_name_three(resultset.getString("prso_name_three"));
    
    return this.productBrand;
  }
}
