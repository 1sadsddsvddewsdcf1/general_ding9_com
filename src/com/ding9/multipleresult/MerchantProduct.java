package com.ding9.multipleresult;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MerchantProduct implements BaseResult
{
  private com.ding9.multipleentity.MerchantProduct merchantProduct = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.merchantProduct = new com.ding9.multipleentity.MerchantProduct();
    
    this.merchantProduct.setMepr_id(resultset.getInt("mepr_id"));
    this.merchantProduct.setMerc_id(resultset.getInt("merc_id"));
    this.merchantProduct.setPrma_id(resultset.getInt("prma_id"));
    this.merchantProduct.setPrso_id(resultset.getInt("prso_id"));
    this.merchantProduct.setMepr_price(resultset.getFloat("mepr_price"));
    this.merchantProduct.setMepr_weight(resultset.getFloat("mepr_weight"));
    
    this.merchantProduct.setMepr_address(resultset.getString("mepr_address"));
    this.merchantProduct.setMepr_contect(resultset.getString("mepr_contect"));
    this.merchantProduct.setMepr_remark(resultset.getString("mepr_remark"));
    this.merchantProduct.setMepr_web_address(resultset.getString("mepr_web_address"));
    this.merchantProduct.setPrma_name(resultset.getString("prma_name"));
    
    return this.merchantProduct;
  }
}
