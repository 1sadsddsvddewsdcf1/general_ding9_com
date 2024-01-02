package com.ding9.result.search;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPic implements BaseResult
{
  private com.ding9.entity.search.ProductPic productPic = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.productPic = new com.ding9.entity.search.ProductPic();
    
    this.productPic.setPrac_address(resultset.getString("prac_address"));
    this.productPic.setWeb_address(resultset.getString("web_address"));
    
    return this.productPic;
  }
}
