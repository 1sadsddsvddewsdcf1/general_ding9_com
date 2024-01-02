package com.ding9.result.category;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMaster implements BaseResult
{
  private com.ding9.entity.product.ProductMaster productMaster = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.productMaster = new com.ding9.entity.product.ProductMaster();
    
    this.productMaster.setPrbr_id(resultset.getInt("prbr_id"));
    this.productMaster.setPrma_id(resultset.getInt("prma_id"));
    this.productMaster.setPrma_name(resultset.getString("prma_name"));
    this.productMaster.setPrma_remark(resultset.getString("prma_remark"));
    this.productMaster.setMin_price(resultset.getFloat("min_price"));
    
    return this.productMaster;
  }
}
