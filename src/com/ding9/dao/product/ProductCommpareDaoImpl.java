package com.ding9.dao.product;

import com.ding9.entity.product.ProductPic;
import com.ding9.multipleresult.ProdutParameterInfo;
import com.ding9.result.product.ProductCommpareInfo;
import com.ding9.result.product.ProductPicIndex;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;









public class ProductCommpareDaoImpl
  implements ProductCommpareDao
{
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  





  public List getProductInfo(List list_id)
    throws SQLException
  {
    BaseResult produtparameter = null;
    List rec = null;
    List results = new ArrayList();
    for (int i = 0; i < list_id.size(); i++) {
      this.dba = new DBAccessDefaultlImpl();
      produtparameter = new ProductCommpareInfo();
      this.sqlstr = new StringBuffer();
      this.sqlstr.append("SELECT MIN_PRICE,MERCHANT_COUNT,PRODUCT_LEVEL,PRMA_NAME,PRMA_ID");
      this.sqlstr.append(" FROM PRODUCT_MASTER\t WHERE  PRMA_ID=?");
      this.dba.setParam(new SQLParam(1, 1, Integer.parseInt((String)list_id.get(i))));
      rec = this.dba.queryData(this.sqlstr.toString(), produtparameter);
      results.add(rec.get(0));
    }
    

    produtparameter = null;
    this.sqlstr = null;
    return results;
  }
  




  public List getProductPicIndex(List list_id)
    throws SQLException
  {
    String sql = null;
    
    List rec = null;
    List results = new ArrayList();
    ProductPic productpic = null;
    for (int i = 0; i < list_id.size(); i++) {
      this.dba = new DBAccessDefaultlImpl();
      sql = "SELECT WEB_ADDRESS,PRAC_ADDRESS,PRMA_ID FROM PRODUCT_PIC WHERE PRMA_ID =?";
      this.dba.setParam(new SQLParam(1, 1, Integer.parseInt((String)list_id.get(i))));
      BaseResult productpicindex = new ProductPicIndex();
      rec = this.dba.queryData(sql, productpicindex);
      
      productpic = new ProductPic();
      
      if (!rec.isEmpty()) {
        if (rec.size() > 0) {
          results.add(rec.get(0));
        } else {
          productpic.setPrac_address(Environment.getTempProductPicture());
          results.add(productpic);
        }
      } else {
        productpic.setPrac_address(Environment.getTempProductPicture());
        results.add(productpic);
      }
    }
    


    BaseResult productpicindex = null;
    sql = null;
    return results;
  }
  




  public List getProductMasterInfo(String prma_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult produtparameter = new ProdutParameterInfo();
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("SELECT M.PRMA_REMARK, S.PRSO_PARAMETER FROM PRODUCT_MASTER M, PRODUCT_SORT S");
    this.sqlstr.append(" WHERE M.PRSO_ID = S.PRSO_ID AND M.PRMA_ID =? ");
    this.dba.setParam(new SQLParam(1, 1, Integer.parseInt(prma_id)));
    List rec = this.dba.queryData(this.sqlstr.toString(), produtparameter);
    
    produtparameter = null;
    this.sqlstr = null;
    return rec;
  }
}
