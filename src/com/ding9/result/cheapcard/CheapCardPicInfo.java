package com.ding9.result.cheapcard;

import com.ding9.entity.cheapcard.CheapCard;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;









public class CheapCardPicInfo
  implements BaseResult
{
  private CheapCard cheapcard = null;
  



  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.cheapcard = new CheapCard();
    this.cheapcard.setChca_pic(Environment.getImageServer() + resultset.getString("chca_pic").substring(3, resultset.getString("chca_pic").length()));
    
    return this.cheapcard;
  }
}
