package com.ding9.dao.indexkey;

import com.ding9.result.indexkey.KeyWordInfo;
import com.ding9.result.indexkey.KeyWordsOptimizeInfo;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;









public class IndexKeyDaoImpl
  implements IndexKeyDao
{
  private static final Log log = LogFactory.getLog(IndexKeyDaoImpl.class);
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  





  public List getkeyWord(String sort_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult kw = new KeyWordInfo();
    
    this.sqlstr = new StringBuffer();
    
    this.sqlstr.append("select HOT_KEYWORD from KEYWORD_CHANNEL where prso_id_one=? and type_id=1 ");
    this.dba.setParam(new SQLParam(1, 1, Integer.parseInt(sort_id)));
    List rec = this.dba.queryData(this.sqlstr.toString(), kw);
    
    if ((rec == null) || (rec.size() == 0)) {
      this.dba = new DBAccessDefaultlImpl();
      this.sqlstr = new StringBuffer();
      this.sqlstr.append("select HOT_KEYWORD from KEYWORD_CHANNEL where prso_id_one=?  and type_id=1 ");
      this.dba.setParam(new SQLParam(1, 1, 10000007));
      rec = this.dba.queryData(this.sqlstr.toString(), kw);
    }
    this.dba.closeConnection();
    kw = null;
    this.sqlstr = null;
    
    return rec;
  }
  





  public List getTypekeyWord(int channel_id, int type_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult kw = new KeyWordInfo();
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("select HOT_KEYWORD from KEYWORD_CHANNEL where prso_id_one=? and type_id=? ");
    this.dba.setParam(new SQLParam(1, 1, channel_id));
    this.dba.setParam(new SQLParam(2, 1, type_id));
    List rec = this.dba.queryData(this.sqlstr.toString(), kw);
    kw = null;
    this.sqlstr = null;
    
    return rec;
  }
  




  public List getKeywordsOptimize(int channel_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult kwo = new KeyWordsOptimizeInfo();
    
    this.sqlstr = new StringBuffer();
    
    this.sqlstr.append("SELECT A.KEOT_ID\t, A.KEOP_TITLE, A.KEOP_KEYWORDS\t, A.KEOP_DESCRIPTION");
    this.sqlstr.append(" FROM KEYWORDS_OPTIMIZE A, KEYWORDS_OPTIMIZE_TYPE B ");
    this.sqlstr.append(" WHERE  A.KEOT_ID = B.KEOT_ID AND (B.CHANNEL_ID=0 OR B.CHANNEL_ID =?) ");
    
    if (log.isWarnEnabled()) {
      log.warn(this.sqlstr.toString());
    }
    this.dba.setParam(new SQLParam(1, 1, channel_id));
    List rec = this.dba.queryData(this.sqlstr.toString(), kwo);
    
    this.dba.closeConnection();
    kwo = null;
    this.sqlstr = null;
    
    return rec;
  }
}
