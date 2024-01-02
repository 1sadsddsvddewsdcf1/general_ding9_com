package com.ding9.result.product;

import com.ding9.entity.product.ProductMaster;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;








public class ProductRemarkInfo
  implements BaseResult
{
  private ProductMaster productinfo = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException { this.productinfo = new ProductMaster();
    this.productinfo.setPrma_remark(StringHelper.getSubString(resultset.getString("prma_remark"), 150));
    return this.productinfo;
  }
}
