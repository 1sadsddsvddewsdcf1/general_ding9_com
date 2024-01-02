package com.ding9.result.category;

import com.ding9.entity.category.ProductMaster;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMasterCheap implements BaseResult
{
  private ProductMaster productMaster = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.productMaster = new ProductMaster();
    
    this.productMaster.setPrbr_id(resultset.getInt("prbr_id"));
    this.productMaster.setPrma_id(resultset.getInt("prma_id"));
    this.productMaster.setPrma_new(resultset.getInt("prma_new"));
    this.productMaster.setPrma_sell(resultset.getInt("prma_sell"));
    this.productMaster.setPrma_sum(resultset.getInt("prma_sum"));
    this.productMaster.setPrma_visit(resultset.getInt("prma_visit"));
    this.productMaster.setPrso_id(resultset.getInt("prso_id"));
    this.productMaster.setPrma_cheap(resultset.getInt("prma_cheap"));
    
    this.productMaster.setPrma_name(resultset.getString("prma_name"));
    this.productMaster.setPrma_mpm(resultset.getString("prma_mpm"));
    this.productMaster.setPrma_remark(resultset.getString("prma_remark"));
    this.productMaster.setPrma_upc(resultset.getString("prma_upc"));
    
    this.productMaster.setPrac_address(resultset.getString("prac_address"));
    if ((resultset.getString("web_address") != null) && (!resultset.getString("web_address").equals(""))) {
      this.productMaster.setWeb_address(Environment.getImageServer() + resultset.getString("web_address"));
    } else {
      this.productMaster.setWeb_address(Environment.getImageServer() + "Updata/Shoppic/want.gif");
    }
    return this.productMaster;
  }
}
