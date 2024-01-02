package com.ding9.result.cheapcard;

import com.ding9.entity.merchant.Merchant;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;










public class CheapCardListInfo
  implements BaseResult
{
  private Merchant merchant = null;
  



  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.merchant = new Merchant();
    String temp = resultset.getString("mesh_chap_logo");
    if ((!temp.equals("")) && (temp != null)) temp = Environment.getImageServer() + "Updata/Shoppic/" + temp; else {
      temp = Environment.getImageServer() + "Updata/Shoppic/want.gif";
    }
    
    this.merchant.setMesh_chap_logo(temp);
    this.merchant.setMerc_url(resultset.getString("merc_url"));
    this.merchant.setMerc_id(resultset.getInt("merc_id"));
    this.merchant.setMerc_web_name(resultset.getString("merc_web_name"));
    this.merchant.setScale_explain(resultset.getString("scale_explain"));
    
    return this.merchant;
  }
}
