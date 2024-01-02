package com.ding9.result.product;

import com.ding9.entity.merchant.Merchant;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;







public class ProductPlayment
  implements BaseResult
{
  private Merchant mer = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.mer = new Merchant();
    this.mer.setMerc_playment(resultset.getString("merc_payment"));
    return this.mer;
  }
}
