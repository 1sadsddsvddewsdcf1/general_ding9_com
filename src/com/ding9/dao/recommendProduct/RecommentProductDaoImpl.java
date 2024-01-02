package com.ding9.dao.recommendProduct;

import com.ding9.result.recommend.RecommendProduct;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;







public class RecommentProductDaoImpl
  implements RecommentProductDao
{
  private static final Log log = LogFactory.getLog(RecommentProductDaoImpl.class);
  
  private IDBAccess dba = null;
  
  private String sql = null;
  







  public List getRecommendProduct(int sortid, int cnt)
  {
    List rst = null;
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult map = new RecommendProduct();
      this.dba.setParam(new SQLParam(1, 1, 
        Environment.getChannelId()));
      this.dba.setParam(new SQLParam(2, 1, 
        Environment.getChannelId()));
      this.dba.setParam(new SQLParam(3, 1, sortid));
      
      this.sql = "SELECT A.INFO_ID ,A.MERCHANT_COUNT,A.MIN_PRICE,A.OLD_PRICE,A.PIC_ADDRESS,A.PIC_ISUPDATE,A.PRMA_ID,A.PRMA_NAME,A.PRSO_ID_ONE,A.SORT_ID,B.PRSO_NAME_ONE,B.PRSO_NAME_ONE_EN FROM COMMON_RECOMMEND_PRODUCT_INFO A ,PRODUCT_SORT B WHERE A.PRSO_ID_ONE=?  AND B.PRSO_ID=?  AND A.SORT_ID=? ORDER BY INFO_ID DESC";
      rst = this.dba.queryDataPagination(this.sql, map, cnt, 1);
      
      this.dba.closeConnection();
      this.sql = null;
      map = null;
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("\n出错信息 getRecommendProduct: " + ex.getMessage());
        log.error("\n执行语句 getRecommendProduct: " + this.sql.toString());
      }
    }
    
    return rst;
  }
  
  public List getRecommendProduct(int sortId, int recomSortId, int cnt) {
    List rst = null;
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult map = new RecommendProduct();
      this.dba.setParam(new SQLParam(1, 1, sortId));
      this.dba.setParam(new SQLParam(2, 1, recomSortId));
      this.sql = "SELECT a.info_id ,a.merchant_count,a.min_price,a.old_price,a.pic_address,a.pic_isupdate,a.prma_id,a.prma_name,a.prso_id_one,a.sort_id FROM common_recommend_product_info a WHERE a.prso_id_one=? AND a.sort_id=? ORDER BY a.info_id DESC";
      rst = this.dba.queryDataPagination(this.sql, map, cnt, 1);
      
      this.dba.closeConnection();
      this.sql = null;
      map = null;
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("\n出错信息 getRecommendProduct: " + ex.getMessage());
        log.error("\n执行语句 getRecommendProduct: " + this.sql.toString());
      }
    }
    
    return rst;
  }
}
