package com.ding9.result.product;

import com.ding9.entity.product.ProductBrand;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;







public class ProductBrandNameInfo
  implements BaseResult
{
  private ProductBrand info = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.info = new ProductBrand();
    this.info.setPrbr_name(resultset.getString("Prbr_name"));
    return this.info;
  }
}
