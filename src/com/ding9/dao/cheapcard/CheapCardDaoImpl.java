package com.ding9.dao.cheapcard;

import com.ding9.result.cheapcard.CheapCardIndex;
import com.ding9.result.cheapcard.CheapCardPicInfo;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.sql.SQLException;
import java.util.List;









public class CheapCardDaoImpl
  implements CheapCardDao
{
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  private static long lasttime = System.currentTimeMillis();
  private static List results = null;
  




  public List getCheapCardIndex()
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult cheapcard = new CheapCardIndex();
    
    this.sqlstr = new StringBuffer();
    
    this.sqlstr.append("SELECT chca_id,chca_title,chca_url ");
    this.sqlstr.append(" FROM cheapcard ");
    this.sqlstr.append(" where end_time >= sysdate ");
    this.sqlstr.append(" ORDER BY chca_id DESC");
    
    List results = this.dba.queryDataPagination(this.sqlstr.toString(), cheapcard, 5, 1);
    
    this.dba.closeConnection();
    cheapcard = null;
    this.sqlstr = null;
    
    return results;
  }
  


  public List getCheapCard()
  {
    if ((results == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult cheapcard = new CheapCardIndex();
      this.dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
      String sql = " select chca_id,chca_title, chca_pic,chca_url from cheapcard where end_time >= sysdate and prso_id_one=? order by chca_id desc";
      results = this.dba.queryData(sql, cheapcard);
      
      this.dba.closeConnection();
      cheapcard = null;
      lasttime = System.currentTimeMillis();
    }
    
    return results;
  }
  















































































































































  public List getCheapCardPic(int chca_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult cheapcard = new CheapCardPicInfo();
    
    this.sqlstr = new StringBuffer();
    
    this.sqlstr.append("select distinct chca_pic  ");
    this.sqlstr.append(" from cheapcard ");
    this.sqlstr.append(" where chca_id=" + chca_id);
    
    List rec = this.dba.queryData(this.sqlstr.toString(), cheapcard);
    this.dba.closeConnection();
    cheapcard = null;
    this.sqlstr = null;
    
    return rec;
  }
}
