package com.ding9.result.merchant;

import com.ding9.entity.merchant.Merchant;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;








public class MerchantScaleInfo
  implements BaseResult
{
  private Merchant merchant = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.merchant = new Merchant();
    this.merchant.setMax_scale(resultset.getString("max_scale"));
    return this.merchant;
  }
}
