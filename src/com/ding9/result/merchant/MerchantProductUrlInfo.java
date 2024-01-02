package com.ding9.result.merchant;

import com.ding9.entity.merchant.MerchantProduct;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class MerchantProductUrlInfo
  implements BaseResult
{
  private MerchantProduct merchantproduct = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.merchantproduct = new MerchantProduct();
    this.merchantproduct.setMepr_web_address(resultset.getString("mepr_web_address"));
    return this.merchantproduct;
  }
}
