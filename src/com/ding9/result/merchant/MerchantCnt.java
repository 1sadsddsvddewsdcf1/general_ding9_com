package com.ding9.result.merchant;

import com.ding9.entity.merchant.Merchant;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class MerchantCnt
  implements BaseResult
{
  private Merchant merchant = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.merchant = new Merchant();
    this.merchant.setMerc_id(resultset.getInt("cnt"));
    
    return this.merchant;
  }
}
