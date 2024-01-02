package com.ding9.result.product;

import com.ding9.entity.product.ProductSort;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class ProductSortOneId
  implements BaseResult
{
  private ProductSort productsort = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.productsort = new ProductSort();
    this.productsort.setPrso_id_one(resultset.getInt("Prso_id_one"));
    return this.productsort;
  }
}
