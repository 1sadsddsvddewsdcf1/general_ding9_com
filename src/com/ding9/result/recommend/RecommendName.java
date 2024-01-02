package com.ding9.result.recommend;

import com.ding9.entity.recommend.RecommendType;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;





public class RecommendName
  implements BaseResult
{
  private RecommendType rminfo = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.rminfo = new RecommendType();
    
    this.rminfo.setRety_name(resultset.getString("rety_name"));
    return this.rminfo;
  }
}
