package com.ding9.result.cheapcard;

import com.ding9.entity.cheapcard.CheapCard;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;








public class CheapCardIndex
  implements BaseResult
{
  private CheapCard cheapcard = null;
  



  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    this.cheapcard = new CheapCard();
    

    this.cheapcard.setChca_id(rs.getInt("chca_id"));
    



    this.cheapcard.setChca_title(rs.getString("chca_title"));
    this.cheapcard.setChca_pic(Environment.getImageServer() + rs.getString("chca_pic"));
    this.cheapcard.setChca_url(rs.getString("chca_url"));
    
    return this.cheapcard;
  }
}
