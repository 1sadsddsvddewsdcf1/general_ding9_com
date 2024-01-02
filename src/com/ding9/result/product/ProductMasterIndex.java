package com.ding9.result.product;

import com.ding9.entity.product.ProductMaster;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;







public class ProductMasterIndex
  implements BaseResult
{
  private ProductMaster productinfo = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.productinfo = new ProductMaster();
    this.productinfo.setPrma_name(resultset.getString("prma_name"));
    this.productinfo.setPrma_id(resultset.getInt("prma_id"));
    
    String remark = resultset.getString("prma_remark");
    remark = StringHelper.getSubString(remark, 76) + "...";
    
    this.productinfo.setPrma_remark(remark);
    this.productinfo.setCompete_sum(resultset.getInt("compete_sum"));
    this.productinfo.setPrso_id(resultset.getInt("prso_id"));
    return this.productinfo;
  }
}
