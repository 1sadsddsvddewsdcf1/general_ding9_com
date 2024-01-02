package com.ding9.result.merchant;

import com.ding9.entity.merchant.MerchantProduct;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;









public class MerProductInfo
  implements BaseResult
{
  private MerchantProduct merchantproduct = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.merchantproduct = new MerchantProduct();
    this.merchantproduct.setPrma_id(resultset.getInt("prma_id"));
    this.merchantproduct.setPrma_name(resultset.getString("prma_name"));
    
    this.merchantproduct.setMepr_time(resultset.getString("mepr_time"));
    

    String remark = null;
    remark = StringHelper.getSubString(resultset.getString("mepr_remark"), 80);
    this.merchantproduct.setMepr_remark(remark);
    this.merchantproduct.setMepr_price(resultset.getFloat("mepr_price"));
    this.merchantproduct.setPrso_id(resultset.getInt("prso_id"));
    return this.merchantproduct;
  }
}
