package com.ding9.result.product;

import com.ding9.entity.merchant.MerchantProductMaxMinPrice;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;








public class ProductPriceMinMax
  implements BaseResult
{
  private MerchantProductMaxMinPrice merchantproduct = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.merchantproduct = new MerchantProductMaxMinPrice();
    this.merchantproduct.setMin_price(resultset.getInt("min_price"));
    return this.merchantproduct;
  }
}
