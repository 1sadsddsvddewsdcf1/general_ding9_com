package com.ding9.result.comsale;

import com.ding9.multipleentity.ProductSaleInfo;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonProductSalesInfo implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    ProductSaleInfo enti = new ProductSaleInfo();
    StringHelper stringHelper = new StringHelper();
    
    enti.setMerc_id(rs.getInt("merc_id"));
    enti.setInfo_id(rs.getInt("info_id"));
    
    String temp = rs.getString("pub_time");
    if ((temp != null) && 
      (temp.length() > 10)) {
      temp = temp.substring(0, 10);
    }
    

    enti.setPub_time(temp);
    enti.setUseful_life(rs.getString("useful_life"));
    
    temp = rs.getString("title");
    if ((temp != null) && 
      (temp.length() > 24)) {
      temp = StringHelper.getSubString(temp, 50) + "...";
    }
    

    enti.setTitle(temp);
    
    enti.setSource_url(rs.getString("source_url"));
    
    temp = rs.getString("content");
    if ((temp != null) && 
      (temp.length() > 56)) {
      temp = StringHelper.getSubString(temp, 110) + "...";
    }
    

    enti.setContent(temp);
    
    enti.setInfo_type(rs.getInt("info_type"));
    enti.setMerc_logo(rs.getString("mesh_chap_logo"));
    enti.setMerc_name(rs.getString("merc_web_name"));
    enti.setMerc_phone(rs.getString("merc_phone"));
    return enti;
  }
}
