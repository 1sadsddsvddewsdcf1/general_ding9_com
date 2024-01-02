package com.ding9.dao.productbrand;

import com.ding9.result.productbrand.ProductBrand;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;







public class ProductBrandDaoImpl
  implements ProductBrandDao
{
  private static Log log = LogFactory.getLog(ProductBrandDaoImpl.class);
  private IDBAccess dba = null;
  private StringBuffer sql = null;
  

  public List getProductBrand(int prso_id_three)
    throws SQLException
  {
    List result = null;
    this.sql = new StringBuffer();
    
    BaseResult index = new ProductBrand();
    try {
      this.dba = new DBAccessDefaultlImpl();
      
      this.sql.append("SELECT C.PRBR_ID,C.PRBR_NAME,COUNT(B.PRBR_ID)");
      
      this.sql.append(",decode(sign(B.PRSO_ID-0),1,nvl((SELECT ps.prso_id_one from product_sort ps WHERE ps.prso_id =B.PRSO_ID and rownum=1),''),'') as prso_id_one");
      this.sql.append(",decode(sign(B.PRSO_ID-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =B.PRSO_ID and rownum=1),''),'') as prso_name_one_en");
      this.sql.append(",decode(sign(B.PRSO_ID-0),1,nvl((SELECT ps.prso_id_three from product_sort ps WHERE ps.prso_id =B.PRSO_ID and rownum=1),''),'') as prso_id_three");
      this.sql.append(",decode(sign(B.PRSO_ID-0),1,nvl((SELECT replace(replace(trim(prso_name_three_en),' ','_'),'/','_and_') as prso_name_three_en from product_sort ps WHERE ps.prso_id =B.PRSO_ID and rownum=1),''),'') as prso_name_three_en");
      
      this.sql.append(" FROM PRODUCT_MASTER B, PRODUCT_BRAND C");
      this.sql.append(" WHERE B.PRSO_ID =?   AND B.MERCHANT_COUNT>0  AND B.PRBR_ID = C.PRBR_ID");
      this.sql.append(" GROUP BY C.PRBR_ID,C.PRBR_NAME,B.PRSO_ID ORDER BY COUNT(B.PRBR_ID) DESC");
      this.dba.setParam(new SQLParam(1, 1, prso_id_three));
      


      result = this.dba.queryData(this.sql.toString(), index);
    }
    catch (Exception ex)
    {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + this.sql.toString());
      }
    }
    finally {
      this.dba.closeConnection();
      index = null;
      this.sql = null;
    }
    return result;
  }
  
  public List getProductBrandByPrbrId(int prbr_id) throws SQLException {
    List result = null;
    this.sql = new StringBuffer();
    
    BaseResult index = new ProductBrand();
    try {
      this.dba = new DBAccessDefaultlImpl();
      
      this.sql.append("SELECT prbr_id,prbr_name FROM product_brand WHERE prbr_id=?");
      this.dba.setParam(new SQLParam(1, 1, prbr_id));
      
      result = this.dba.queryData(this.sql.toString(), index);
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + this.sql.toString());
      }
    }
    finally {
      this.dba.closeConnection();
      index = null;
      this.sql = null;
    }
    return result;
  }
}
