package com.ding9.result.category;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecommendMerchantInfo implements BaseResult
{
  private com.ding9.entity.category.RecommendMerchantInfo recommendMerchantInfo = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.recommendMerchantInfo = new com.ding9.entity.category.RecommendMerchantInfo();
    
    this.recommendMerchantInfo.setInfo_id(resultset.getInt("info_id"));
    this.recommendMerchantInfo.setMerc_id(resultset.getInt("merc_id"));
    this.recommendMerchantInfo.setRecom_type(resultset.getInt("recom_type"));
    this.recommendMerchantInfo.setSequence_number(resultset.getInt("sequence_number"));
    this.recommendMerchantInfo.setSyus_id(resultset.getInt("syus_id"));
    
    this.recommendMerchantInfo.setMere_adress(resultset.getString("mere_adress"));
    this.recommendMerchantInfo.setMere_logo(resultset.getString("mere_logo"));
    this.recommendMerchantInfo.setMere_name(resultset.getString("mere_name"));
    
    this.recommendMerchantInfo.setMere_time(resultset.getDate("mere_time"));
    
    return this.recommendMerchantInfo;
  }
}
