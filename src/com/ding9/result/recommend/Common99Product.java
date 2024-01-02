package com.ding9.result.recommend;

import com.ding9.entity.commonrecommendproductinfo.Common99RecommendProductInfo;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Common99Product implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    Common99RecommendProductInfo enti = new Common99RecommendProductInfo();
    enti.setInfo_id(rs.getInt("info_id"));
    enti.setPram_id(rs.getInt("prma_id"));
    enti.setPrma_name(com.ding9.util.StringHelper.getSubString(rs.getString("prma_name"), 22));
    enti.setPrso_id_one(rs.getInt("prso_id_one"));
    enti.setSort_id(rs.getInt("sort_id"));
    try {
      enti.setPrso_name_one_en(rs.getString("prso_name_one_en"));
    } catch (Exception localException) {}
    return enti;
  }
}
