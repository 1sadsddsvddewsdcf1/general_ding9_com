package com.ding9.result.product;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;








public class ReviewProductInfo
  implements BaseResult
{
  private com.ding9.entity.product.ReviewProductInfo pro = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.pro = new com.ding9.entity.product.ReviewProductInfo();
    this.pro.setRpi_merit(resultset.getString("rpi_merit"));
    this.pro.setRpi_fefect(resultset.getString("rpi_fefect"));
    this.pro.setRpi_integration(resultset.getString("rpi_integration"));
    return this.pro;
  }
}
