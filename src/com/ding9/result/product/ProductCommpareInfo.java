package com.ding9.result.product;

import com.ding9.multipleentity.MuProductInfo;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import com.ding9.util.GetImg;
import java.sql.ResultSet;
import java.sql.SQLException;






public class ProductCommpareInfo
  implements BaseResult
{
  private MuProductInfo info = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.info = new MuProductInfo();
    try {
      this.info.setPrma_id(resultset.getInt("prma_id"));
      this.info.setMin_price(resultset.getFloat("min_price"));
      this.info.setMerchant_count(resultset.getInt("merchant_count"));
      
      float product_level = resultset.getFloat("product_level");
      int level = Math.round(product_level);
      if (level == 0)
        level = 1;
      this.info.setProduct_level(level);
      this.info.setPrma_name(resultset.getString("prma_name"));
      this.info.setPrac_address(GetImg.Image(this.info.getWeb_address(), Environment.getImageServer() + "Updata/Shoppic/want.gif"));
    }
    catch (Exception localException) {}
    

    return this.info;
  }
}
