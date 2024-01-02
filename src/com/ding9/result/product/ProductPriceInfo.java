package com.ding9.result.product;

import com.ding9.multipleentity.MuProductInfo;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;








public class ProductPriceInfo
  implements BaseResult
{
  private MuProductInfo info = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.info = new MuProductInfo();
    this.info.setPrma_id(resultset.getInt("prma_id"));
    this.info.setMin_price(resultset.getFloat("min_price"));
    this.info.setPrma_name(resultset.getString("prma_name"));
    return this.info;
  }
}
