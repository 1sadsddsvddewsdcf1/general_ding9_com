package com.ding9.result.product;

import com.ding9.dao.search.ProductMasterPicCommentDaoImpl;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductMaster
  implements BaseResult
{
  private static Log log = LogFactory.getLog(ProductMasterPicCommentDaoImpl.class);
  
  private com.ding9.entity.product.ProductMaster productMaster = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.productMaster = new com.ding9.entity.product.ProductMaster();
    try {
      this.productMaster.setPrma_remark(StringHelper.getSubString(resultset.getString("prma_remark"), 160));
      this.productMaster.setPrbr_id(resultset.getInt("prbr_id"));
      this.productMaster.setPrma_id(resultset.getInt("prma_id"));
      this.productMaster.setPrso_id(resultset.getInt("prso_id"));
      this.productMaster.setPrma_name(resultset.getString("prma_name"));
      this.productMaster.setMin_price(resultset.getFloat("min_price"));
      this.productMaster.setMerchant_count(resultset.getInt("merchant_count"));
      this.productMaster.setComment_count(resultset.getInt("comment_count"));
      this.productMaster.setProduct_level(Math.round(resultset.getFloat("product_level")));
      this.productMaster.setForestall(resultset.getInt("forestall"));
    } catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getMapRow");
        log.debug(ex.getMessage());
      }
    }
    return this.productMaster;
  }
}
