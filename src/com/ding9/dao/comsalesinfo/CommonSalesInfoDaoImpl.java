package com.ding9.dao.comsalesinfo;

import com.ding9.dao.recommendProduct.RecommentProductDaoImpl;
import com.ding9.result.comsale.CommonSalesInfo;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonSalesInfoDaoImpl
  implements CommonSalesInfoDao
{
  private static final Log log = LogFactory.getLog(RecommentProductDaoImpl.class);
  private IDBAccess dba = null;
  private String sql = null;
  private static long lasttime = System.currentTimeMillis();
  private static List results = null;
  




  public List getSalesInfo(int cnt)
  {
    if ((results == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      if (log.isWarnEnabled()) {
        log.warn("重新载入评论信息时间：" + System.currentTimeMillis());
      }
      
      this.dba = new DBAccessDefaultlImpl();
      CommonSalesInfo map = new CommonSalesInfo();
      this.dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
      


      this.sql = " SELECT CONTENT,INFO_ID,PRSO_ID_ONE,PUB_TIME,TITLE,SOURCE_URL,INFO_TYPE,decode(sign(PRSO_ID_ONE-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =PRSO_ID_ONE and rownum=1),''),'') as prso_name_one_en FROM COMMON_SALEPROMOTION_INFO WHERE PRSO_ID_ONE=? AND INFO_STATUS=1 AND OUT_DATE>=SYSDATE ORDER BY INFO_ID DESC";
      
      results = this.dba.queryDataPagination(this.sql, map, cnt, 1);
      this.dba.closeConnection();
      this.sql = null;
      map = null;
      lasttime = System.currentTimeMillis();
    }
    return results;
  }
}
