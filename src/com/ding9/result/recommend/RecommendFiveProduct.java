package com.ding9.result.recommend;

import com.ding9.entity.recommend.RecommendProductSort;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;










public class RecommendFiveProduct
  implements BaseResult
{
  private RecommendProductSort rminfo = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.rminfo = new RecommendProductSort();
    
    this.rminfo.setPrma_id(resultset.getInt("prma_id"));
    this.rminfo.setPrma_name(resultset.getString("prma_name"));
    this.rminfo.setPrso_id(resultset.getInt("prso_id"));
    String remark = resultset.getString("prma_remark");
    remark = StringHelper.getSubString(remark, 76) + "...";
    this.rminfo.setPrma_remark(remark);
    this.rminfo.setWeb_address(resultset.getString("web_address"));
    this.rminfo.setPrac_address(resultset.getString("prac_address"));
    

    this.rminfo.setPrso_id_one(resultset.getInt("prso_id_one"));
    
    return this.rminfo;
  }
}
