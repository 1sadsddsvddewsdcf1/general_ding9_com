package com.ding9.result.cheapcard;

import com.ding9.entity.cheapcard.CheapCard;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;








public class CheapCardSort
  implements BaseResult
{
  private CheapCard merchant = null;
  
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    this.merchant = new CheapCard();
    
    this.merchant.setSort_id(rs.getInt("sort_id"));
    try {
      this.merchant.setSort_name(rs.getString("sort_name"));
    }
    catch (Exception localException) {}
    
    return this.merchant;
  }
}
