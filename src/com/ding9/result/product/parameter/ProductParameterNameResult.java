package com.ding9.result.product.parameter;

import com.ding9.entity.product.ProductParameterName;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class ProductParameterNameResult
  implements BaseResult
{
  ProductParameterName ppn = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.ppn = new ProductParameterName();
    

    this.ppn.setField_name(resultset.getString("prac_field"));
    this.ppn.setField_content(resultset.getString("prac_field_name"));
    
    return this.ppn;
  }
}
