package com.ding9.dao.recommend;

import com.ding9.result.recommend.RecommendMerchantInfoIndex;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;






public class RecommendMerchantInfoDaoImpl
  implements RecommendMerchantInfoDao
{
  private static final Log log = LogFactory.getLog(RecommendMerchantInfoDaoImpl.class);
  
  private IDBAccess dba = null;
  
  private String sql = null;
  private static long lasttime = System.currentTimeMillis();
  private static List results = null;
  



  public List getRecommendMerchantInfo()
    throws SQLException
  {
    if ((results == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      if (log.isWarnEnabled()) {
        log.warn("重新载入评论信息时间：" + System.currentTimeMillis());
      }
      try {
        this.dba = new DBAccessDefaultlImpl();
        BaseResult merchant = new RecommendMerchantInfoIndex();
        this.dba.setParam(new SQLParam(1, 1, 
          Environment.getChannelId()));
        this.sql = "SELECT mere_name,mere_logo,mere_adress,flag FROM recommend_merchant_info WHERE channel_id=? ORDER BY merc_id ASC";
        
        //2014-04-09 取消提示信息 System.out.println("sql..:" + this.sql);
        results = this.dba.queryData(this.sql, merchant);
        this.dba.closeConnection();
        merchant = null;
        this.sql = null;
      }
      catch (Exception ex) {
        if (log.isErrorEnabled()) {
          log.error("\n出错信息 getRecommendMerchantInfo: " + ex.getMessage());
          log.error("\n执行语句 getRecommendMerchantInfo: " + this.sql.toString());
        }
      }
      lasttime = System.currentTimeMillis();
    }
    return results;
  }
  
  public List getRecommendMerchantInfo(int channelId)
  {
    if (log.isWarnEnabled()) {
      log.warn("重新载入推荐商家信息时间：" + (System.currentTimeMillis() - lasttime));
    }
    try {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult merchant = new RecommendMerchantInfoIndex();
      this.dba.setParam(new SQLParam(1, 1, channelId));
      this.sql = "SELECT mere_name,mere_logo,mere_adress FROM recommend_merchant_info WHERE channel_id=? ORDER BY merc_id DESC";
      
      results = this.dba.queryData(this.sql, merchant);
      this.dba.closeConnection();
      merchant = null;
      this.sql = null;
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("\n出错信息 getRecommendMerchantInfo: " + ex.getMessage());
        log.error("\n执行语句 getRecommendMerchantInfo: " + this.sql.toString());
      }
    }
    

    return results;
  }
}
