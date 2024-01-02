package com.ding9.result.merchant;

import com.ding9.entity.merchant.Merchant;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;






public class MerchantSaleInfo
  implements BaseResult
{
  private Merchant merchant = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.merchant = new Merchant();
    




    if ((resultset.getString("mesh_chap_logo") != null) && (!"".equals(resultset.getString("mesh_chap_logo"))))
      this.merchant.setMesh_chap_logo(Environment.getImageServer() + "Updata/Shoppic/" + resultset.getString("mesh_chap_logo")); else {
      this.merchant.setMesh_chap_logo("");
    }
    

    if ((resultset.getString("merc_web_name") != null) && ("".equals(resultset.getString("merc_web_name"))))
      this.merchant.setMerc_web_name(resultset.getString("merc_com_name")); else
      this.merchant.setMerc_web_name(resultset.getString("merc_web_name"));
    this.merchant.setMerc_phone(resultset.getString("merc_phone"));
    return this.merchant;
  }
}
