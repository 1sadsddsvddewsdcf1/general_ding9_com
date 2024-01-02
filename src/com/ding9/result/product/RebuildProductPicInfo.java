package com.ding9.result.product;

import com.ding9.entity.product.RebuildPic;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;







public class RebuildProductPicInfo
  implements BaseResult
{
  private RebuildPic info = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.info = new RebuildPic();
    try {
      this.info.setLocal_address(resultset.getString("local_address"));
    }
    catch (Exception localException) {}
    

    return this.info;
  }
}
