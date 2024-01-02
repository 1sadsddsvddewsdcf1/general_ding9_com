package com.ding9.result.recommend;

import com.ding9.entity.recommend.RecommendProductMastProSort;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;





public class RecommendProdutMastProSortIndex
  implements BaseResult
{
  private RecommendProductMastProSort rminfo = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.rminfo = new RecommendProductMastProSort();
    this.rminfo.setPrma_id(resultset.getInt("prma_id"));
    this.rminfo.setPrma_name(resultset.getString("prma_name"));
    this.rminfo.setPrso_id(resultset.getInt("prso_id"));
    this.rminfo.setPrso_id_one(resultset.getInt("prso_id_one"));
    this.rminfo.setRety_id(resultset.getInt("rety_id"));
    
    return this.rminfo;
  }
}
