package com.ding9.result.recommend;

import com.ding9.entity.commonrecommendproductinfo.CommonRecommendProductInfo;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;








public class RecommendProduct
  implements BaseResult
{
  private CommonRecommendProductInfo rminfo = null;
  

  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    this.rminfo = new CommonRecommendProductInfo();
    
    this.rminfo.setInfoId(rs.getInt("info_id"));
    this.rminfo.setMerchant_count(rs.getInt("merchant_count"));
    this.rminfo.setMin_price(rs.getBigDecimal("min_price"));
    this.rminfo.setOld_price(rs.getBigDecimal("old_price"));
    

    String pic = rs.getString("pic_address");
    if ((pic != null) && (!"".equals(pic))) {
      if (rs.getInt("pic_isupdate") == 0) {
        this.rminfo.setPicAddress(Environment.getImageServer() + pic);
      } else if (rs.getInt("pic_isupdate") == 1) {
        this.rminfo.setPicAddress(Environment.getImageDing9() + pic);
      }
    } else {
      this.rminfo.setPicAddress(Environment.getTempProductPicture());
    }
    this.rminfo.setPicIsupdate(rs.getInt("pic_isupdate"));
    this.rminfo.setPrmaId(rs.getInt("prma_id"));
    this.rminfo.setPrmaName(rs.getString("prma_name"));
    this.rminfo.setPrsoIdOne(rs.getInt("prso_id_one"));
    this.rminfo.setSortId(rs.getInt("sort_id"));
    try {
      this.rminfo.setPrsoNameOne(rs.getString("prso_name_one"));
    } catch (Exception localException) {}
    try {
      this.rminfo.setPrsoNameOneEn(rs.getString("prso_name_one_en"));
    }
    catch (Exception localException1) {}
    return this.rminfo;
  }
}
