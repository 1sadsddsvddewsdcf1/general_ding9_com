package com.ding9.multipleresult;

import com.ding9.multipleentity.MuProductInfo;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MuProductInfoList
  implements BaseResult
{
  private MuProductInfo rst = null;
  
  public Object getMapRow(ResultSet rs, int i) throws SQLException {
    this.rst = new MuProductInfo();
    try {
      this.rst.setMax_price(rs.getFloat("max_price"));
      this.rst.setMin_price(rs.getFloat("min_price"));
      this.rst.setMerchant_count(rs.getInt("merchant_count"));
    }
    catch (Exception localException) {}
    try {
      this.rst.setProduct_level(rs.getInt("product_level"));
      this.rst.setComment_count(rs.getInt("comment_count"));
    }
    catch (Exception localException1) {}
    
    return this.rst;
  }
}
