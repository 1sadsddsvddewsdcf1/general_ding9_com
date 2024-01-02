package com.ding9.result.product;

import com.ding9.dao.product.ProductDao;
import com.ding9.dao.product.ProductDaoImpl;
import com.ding9.dao.search.ProductMasterPicCommentDao;
import com.ding9.dao.search.ProductMasterPicCommentDaoImpl;
import com.ding9.entity.product.ProductMaster;
import com.ding9.entity.product.RebuildPic;
import com.ding9.entity.search.ProductPic;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;

public class ProductSearchList implements BaseResult
{
  private static Log log = org.apache.commons.logging.LogFactory.getLog(ProductMasterPicCommentDaoImpl.class);
  
  private ProductMaster productMaster = null;
  private ProductMasterPicCommentDao pic = null;
  private List resultPic = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.productMaster = new ProductMaster();
    this.productMaster.setPrma_remark(StringHelper.getSubString(resultset.getString("prma_remark"), 160));
    try {
      this.productMaster.setPrbr_id(resultset.getInt("prbr_id"));
    }
    catch (Exception localException) {}
    
    this.productMaster.setPrma_id(resultset.getInt("prma_id"));
    
    ProductDao pro = new ProductDaoImpl();
    this.resultPic = pro.getRebuildPic(this.productMaster.getPrma_id(), 1);
    if ((this.resultPic != null) && (this.resultPic.size() > 0)) {
      RebuildPic pic = (RebuildPic)this.resultPic.get(0);
      this.productMaster.setPicture_address(" src=" + Environment.getImageServer() + pic.getLocal_address());
    } else {
      this.pic = new ProductMasterPicCommentDaoImpl();
      this.resultPic = this.pic.getProductPic(this.productMaster.getPrma_id());
      if ((this.resultPic != null) && (this.resultPic.size() > 0)) {
        ProductPic productPic = (ProductPic)this.resultPic.get(0);
        if ((productPic.getWeb_address() != null) && (!"".equals(productPic.getWeb_address()))) {
          this.productMaster.setPicture_address(" src=" + Environment.getImageServer() + productPic.getWeb_address() + " width=80 height=80 ");
        } else {
          this.productMaster.setPicture_address(" src=" + Environment.getTempProductPicture() + " width=80 height=80 ");
        }
      } else {
        this.productMaster.setPicture_address(" src=" + Environment.getTempProductPicture() + " width=80 height=80 ");
      }
    }
    












    this.productMaster.setPrso_id(resultset.getInt("prso_id"));
    this.productMaster.setPrso_id_one(resultset.getInt("prso_id_one"));
    this.productMaster.setPrma_name(resultset.getString("prma_name"));
    this.productMaster.setMin_price(resultset.getFloat("min_price"));
    this.productMaster.setMerchant_count(resultset.getInt("merchant_count"));
    this.productMaster.setComment_count(resultset.getInt("comment_count"));
    this.productMaster.setProduct_level(Math.round(resultset.getFloat("product_level")));
    

    return this.productMaster;
  }
}
