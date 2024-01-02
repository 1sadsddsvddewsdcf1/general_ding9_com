package com.ding9.result.merchant;

import com.ding9.entity.merchant.MerchantProductMaster;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import com.ding9.util.GetImg;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;






public class MerchantProductMasterInfo
  implements BaseResult
{
  private MerchantProductMaster info = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.info = new MerchantProductMaster();
    
    this.info.setPrma_id(resultset.getInt("prma_id"));
    
    String remark = resultset.getString("mepr_remark");
    



    remark = StringHelper.getSubString(remark, 150);
    
    this.info.setMepr_remark(remark);
    
    this.info.setMepr_price(resultset.getFloat("mepr_price"));
    this.info.setMin_price(resultset.getFloat("min_price"));
    this.info.setMerchant_count(resultset.getInt("merchant_count"));
    this.info.setComment_count(resultset.getInt("comment_count"));
    float product_level = resultset.getFloat("product_level");
    int level = Math.round(product_level);
    if (level == 0) level = 1;
    this.info.setProduct_level(level);
    this.info.setPrma_name(resultset.getString("prma_name"));
    this.info.setPrac_address(resultset.getString("prac_address"));
    this.info.setWeb_address(resultset.getString("web_address"));
    this.info.setPrac_address(GetImg.Image(this.info.getWeb_address(), Environment.getTempProductPicture()));
    return this.info;
  }
}
