package com.ding9.result.recommend;

import com.ding9.entity.recommend.RecommendMerchantInfo;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;








public class RecommendMerchantInfoIndex
  implements BaseResult
{
  private RecommendMerchantInfo rminfo = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.rminfo = new RecommendMerchantInfo();
    this.rminfo.setMere_name(resultset.getString("mere_name"));
    this.rminfo.setMere_logo(Environment.getImageServer() + resultset.getString("mere_logo"));
    this.rminfo.setMere_adress(resultset.getString("mere_adress"));
    try {
      this.rminfo.setFlag(resultset.getInt("flag"));
    }
    catch (Exception localException) {}
    return this.rminfo;
  }
}
