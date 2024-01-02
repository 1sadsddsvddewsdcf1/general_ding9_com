package com.ding9.result.cheapcard;

import com.ding9.entity.cheapcard.CheapCard;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;










public class CheapCardUrlInfo
  implements BaseResult
{
  private CheapCard cheapcard = null;
  



  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.cheapcard = new CheapCard();
    this.cheapcard.setChca_url(resultset.getString("chca_url"));
    return this.cheapcard;
  }
}
