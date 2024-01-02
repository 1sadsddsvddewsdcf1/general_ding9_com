package com.ding9.result.recommend;

import com.ding9.entity.recommend.Recommend;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;






public class RecommendIndexInfo
  implements BaseResult
{
  private Recommend rminfo = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.rminfo = new Recommend();
    
    this.rminfo.setRety_id(resultset.getInt("rety_id"));
    return this.rminfo;
  }
}
