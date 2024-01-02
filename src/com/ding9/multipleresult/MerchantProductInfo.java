package com.ding9.multipleresult;

import com.ding9.multipleentity.MuMerchantiProductnfo;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;






public class MerchantProductInfo
  implements BaseResult
{
  private MuMerchantiProductnfo merchantProduct = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.merchantProduct = new MuMerchantiProductnfo();
    
    if (resultset.getString("mepr_price") == null) {
      this.merchantProduct.setMepr_price("");
    } else {
      this.merchantProduct.setMepr_price(resultset.getString("mepr_price"));
    }
    this.merchantProduct.setMepr_time(resultset.getString("mepr_time"));
    this.merchantProduct.setMepr_web_address(resultset.getString("mepr_web_address"));
    this.merchantProduct.setMerc_id(resultset.getInt("merc_id"));
    this.merchantProduct.setMerc_web_name(resultset.getString("merc_web_name"));
    this.merchantProduct.setMepr_forestall(String.valueOf(resultset.getInt("mepr_forestall")));
    

    if ((resultset.getString("mesh_chap_logo") != null) && (!"".equals(resultset.getString("mesh_chap_logo")))) {
      this.merchantProduct.setMesh_chap_logo(Environment.getImageServer() + resultset.getString("mesh_chap_logo"));
    }
    
    this.merchantProduct.setUp_time(resultset.getString("up_time"));
    this.merchantProduct.setMerc_com_name(resultset.getString("merc_com_name"));
    this.merchantProduct.setMerc_phone(resultset.getString("merc_phone"));
    
    int type = resultset.getInt("merc_type");
    
    if (type == 0) {
      this.merchantProduct.setMerc_type("实体商城");
    } else if (1 == type)
      this.merchantProduct.setMerc_type("网上商城"); else {
      this.merchantProduct.setMerc_type("网上/实体");
    }
    int merc_credit = resultset.getInt("Comments_Level");
    if (merc_credit == 0)
      this.merchantProduct.setMerc_credit(5); else {
      this.merchantProduct.setMerc_credit(resultset.getInt("Comments_Level"));
    }
    this.merchantProduct.setMerc_city(resultset.getString("merc_city"));
    this.merchantProduct.setMerc_omit(resultset.getString("merc_omit"));
    this.merchantProduct.setMerc_email(resultset.getString("merc_email"));
    try {
      this.merchantProduct.setMerc_home(resultset.getString("merc_home"));
    } catch (Exception localException) {}
    try {
      this.merchantProduct.setCom_url(String.valueOf(resultset.getInt("comments_cnt")));
    } catch (Exception localException1) {}
    return this.merchantProduct;
  }
}
