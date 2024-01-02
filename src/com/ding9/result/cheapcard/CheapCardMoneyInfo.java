package com.ding9.result.cheapcard;

import com.ding9.entity.cheapcard.CheapCard;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;










public class CheapCardMoneyInfo
  implements BaseResult
{
  private CheapCard cheapcard = null;
  



  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.cheapcard = new CheapCard();
    this.cheapcard.setMerc_id(resultset.getInt("merc_id"));
    this.cheapcard.setChca_id(resultset.getInt("chca_id"));
    this.cheapcard.setPrso_id_one(resultset.getInt("prso_id_one"));
    this.cheapcard.setEnd_time(resultset.getString("end_time"));
    this.cheapcard.setChca_title(resultset.getString("chca_title"));
    String temp = resultset.getString("chca_pic");
    if ((!"".equals(temp)) && (temp != null)) this.cheapcard.setChca_pic(temp); else {
      this.cheapcard.setChca_pic(Environment.getImageServer() + "Updata/Shoppic/want.gif");
    }
    return this.cheapcard;
  }
}
