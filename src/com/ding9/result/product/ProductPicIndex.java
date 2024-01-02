package com.ding9.result.product;

import com.ding9.entity.product.ProductPic;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import com.ding9.util.GetImg;
import java.sql.ResultSet;
import java.sql.SQLException;







public class ProductPicIndex
  implements BaseResult
{
  private ProductPic productpic = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.productpic = new ProductPic();
    
    this.productpic.setWeb_address(resultset.getString("web_address"));
    this.productpic.setPrac_address(GetImg.Image(this.productpic.getWeb_address(), Environment.getTempProductPicture()));
    this.productpic.setPrma_id(resultset.getInt("prma_id"));
    return this.productpic;
  }
}
