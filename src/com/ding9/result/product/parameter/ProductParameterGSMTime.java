package com.ding9.result.product.parameter;

import com.ding9.entity.product.ProductParameterGSMIime;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;




public class ProductParameterGSMTime
  implements BaseResult
{
  ProductParameterGSMIime ppn = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException { this.ppn = new ProductParameterGSMIime();
    this.ppn.setField_65(resultset.getString("field_65"));
    this.ppn.setField_97(resultset.getString("field_97"));
    
    return this.ppn;
  }
}
