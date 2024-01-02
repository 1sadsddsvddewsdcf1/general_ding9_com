package com.ding9.result.merchant;

import com.ding9.entity.merchant.MerchantProductSale;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import com.ding9.util.GetImg;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;





public class MerchantSaleProduct
  implements BaseResult
{
  private MerchantProductSale merchantproduct = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException { this.merchantproduct = new MerchantProductSale();
    this.merchantproduct.setPrma_id(resultset.getInt("prma_id"));
    this.merchantproduct.setPrma_name(resultset.getString("prma_name"));
    


    if (resultset.getString("mepr_time").length() > 0) {
      this.merchantproduct.setDay(resultset.getString("mepr_time").substring(0, 10));
      this.merchantproduct.setTime(resultset.getString("mepr_time").substring(10, resultset.getString("mepr_time").length() - 2));
    }
    

    String remark = null;
    remark = StringHelper.getSubString(resultset.getString("mepr_remark"), 80);
    this.merchantproduct.setMepr_remark(remark);
    this.merchantproduct.setMepr_price(resultset.getFloat("mepr_price"));
    
    this.merchantproduct.setPrso_id(resultset.getInt("prso_id"));
    
    this.merchantproduct.setPrac_address(resultset.getString("prac_address"));
    this.merchantproduct.setWeb_address(resultset.getString("web_address"));
    this.merchantproduct.setPrac_address(GetImg.Image(this.merchantproduct.getWeb_address(), Environment.getTempProductPicture()));
    
    return this.merchantproduct;
  }
}
