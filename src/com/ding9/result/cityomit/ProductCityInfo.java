package com.ding9.result.cityomit;

import com.ding9.entity.merchant.Merchant;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;








public class ProductCityInfo
  implements BaseResult
{
  private Merchant city = null;
  



  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.city = new Merchant();
    this.city.setMerc_city(resultset.getString("merc_city"));
    return this.city;
  }
}
