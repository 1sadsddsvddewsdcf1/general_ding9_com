package com.ding9.result.comsale;

import com.ding9.entity.commonsalepromotioninfo.CommonSalepromotionInfo;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonSalesInfo implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    CommonSalepromotionInfo enti = new CommonSalepromotionInfo();
    enti.setContent(rs.getString("content"));
    enti.setInfo_id(rs.getInt("info_id"));
    enti.setPrso_id_one(rs.getInt("prso_id_one"));
    enti.setPub_time(rs.getString("pub_time"));
    
    enti.setTitle(rs.getString("title"));
    enti.setSource_url(rs.getString("source_url"));
    enti.setInfo_type(rs.getInt("info_type"));
    try {
      enti.setPrso_name_one_en(rs.getString("prso_name_one_en"));
    } catch (Exception localException) {}
    return enti;
  }
}
