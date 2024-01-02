package com.ding9.result.product;

import com.ding9.multipleentity.MuProductInfo;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;






public class ProductInfo
  implements BaseResult
{
  private MuProductInfo info = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.info = new MuProductInfo();
    
    String remark = resultset.getString("prma_remark");
    if ((remark != null) && (!"".equals(remark)) && 
      (140 > remark.length())) {
      remark = StringHelper.getSubString(remark, 180) + "...";
    }
    this.info.setPrma_remark(remark);
    this.info.setPrbr_id(resultset.getInt("prbr_id"));
    this.info.setMin_price(resultset.getFloat("min_price"));
    this.info.setMax_price(resultset.getFloat("max_price"));
    this.info.setMerchant_count(resultset.getInt("merchant_count"));
    this.info.setComment_count(resultset.getInt("comment_count"));
    this.info.setPrso_id(resultset.getInt("prso_id"));
    float product_level = resultset.getFloat("product_level");
    int level = Math.round(product_level);
    if (level == 0) { level = 1;
    }
    this.info.setProduct_level(level);
    

    this.info.setPrma_name(resultset.getString("prma_name"));
    


    return this.info;
  }
}
