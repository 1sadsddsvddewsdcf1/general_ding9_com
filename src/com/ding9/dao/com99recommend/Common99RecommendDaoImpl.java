package com.ding9.dao.com99recommend;

import com.ding9.dao.recommendProduct.RecommentProductDaoImpl;
import com.ding9.result.recommend.Common99Product;
import com.ding9.result.recommend.Common99Sort;
import com.ding9.result.recommend.Common99SubSort;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.io.PrintStream;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class Common99RecommendDaoImpl
  implements Common99RecommendDao
{
  private static final Log log = LogFactory.getLog(RecommentProductDaoImpl.class);
  private IDBAccess dba = null;
  private String sql = null;
  private static long lasttime = System.currentTimeMillis();
  private static List results = null;
  


  public List getParentSort()
  {
    if ((results == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      if (log.isWarnEnabled()) {
        log.warn("重新载入评论信息时间：" + System.currentTimeMillis());
      }
      this.dba = new DBAccessDefaultlImpl();
      Common99Sort map = new Common99Sort();
      this.dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
      this.sql = " SELECT PARENT_ID,PRSO_ID_ONE,SORT_ID,SORT_NAME FROM COMMON_99_RECOMMEND_SORT_INFO WHERE PARENT_ID=0 AND PRSO_ID_ONE=? ORDER BY SORT_ID ";
      results = this.dba.queryData(this.sql, map);
      this.dba.closeConnection();
      this.sql = null;
      map = null;
      lasttime = System.currentTimeMillis();
    }
    return results;
  }
  



  public List getSubSort(int parentId)
  {
    List rst = null;
    this.dba = new DBAccessDefaultlImpl();
    Common99SubSort map = new Common99SubSort();
    this.dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
    this.dba.setParam(new SQLParam(2, 1, parentId));
    this.sql = " SELECT PARENT_ID,PRSO_ID_ONE,SORT_ID,SORT_NAME FROM COMMON_99_RECOMMEND_SORT_INFO WHERE PRSO_ID_ONE=? AND PARENT_ID=?  ORDER BY SORT_ID ";
    rst = this.dba.queryData(this.sql, map);
    this.dba.closeConnection();
    this.sql = null;
    map = null;
    return rst;
  }
  



  public List getProduct(int sortId, int cnt)
  {
    List rst = null;
    this.dba = new DBAccessDefaultlImpl();
    Common99Product map = new Common99Product();
    this.dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
    this.dba.setParam(new SQLParam(2, 1, sortId));
    
    this.sql = " SELECT INFO_ID,PRMA_ID,PRMA_NAME,PRSO_ID_ONE,SORT_ID,decode(sign(PRSO_ID_ONE-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =PRSO_ID_ONE and rownum=1),''),'') as prso_name_one_en FROM RECOMMEND_99_PRODUCT_INFO WHERE PRSO_ID_ONE=? AND SORT_ID = ? ORDER BY SORT_ID,INFO_ID DESC ";
    rst = this.dba.queryDataPagination(this.sql, map, cnt, 1);
    this.dba.closeConnection();
    this.sql = null;
    map = null;
    return rst;
  }
  
  public static void main(String[] args) {
    Common99RecommendDaoImpl a = new Common99RecommendDaoImpl();
    System.out.println(a.getParentSort());
  }
}
