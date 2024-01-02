package com.ding9.result.product;

import com.ding9.entity.product.ProductSort;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class ProductSortIndex
  implements BaseResult
{
  private ProductSort productsort = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.productsort = new ProductSort();
    this.productsort.setPrso_id_one(resultset.getInt("prso_id_one"));
    this.productsort.setPrso_id_three(resultset.getInt("prso_id_three"));
    this.productsort.setPrso_name_one(resultset.getString("prso_name_one"));
    this.productsort.setPrso_name_three(resultset.getString("prso_name_three"));
    this.productsort.setPrso_id(resultset.getInt("prso_id"));
    
    return this.productsort;
  }
}
