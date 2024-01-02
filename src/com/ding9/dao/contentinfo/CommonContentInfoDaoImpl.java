package com.ding9.dao.contentinfo;

import com.ding9.dao.recommendProduct.RecommentProductDaoImpl;
import com.ding9.result.contentinfo.ContentInfoResult;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonContentInfoDaoImpl
  implements CommonContentInfoDao
{
  private static final Log log = LogFactory.getLog(RecommentProductDaoImpl.class);
  private IDBAccess dba = null;
  private String sql = null;
  





  public List getContentInfo(int infoid)
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult map = new ContentInfoResult();
    this.dba.setParam(new SQLParam(1, 1, infoid));
    
    this.sql = "SELECT CONTENT,INFO_ID,TITLE FROM COMMON_CONTENT_INFO WHERE INFO_ID=? ";
    List rst = this.dba.queryData(this.sql, map);
    
    this.dba.closeConnection();
    this.sql = null;
    
    return rst;
  }
}
