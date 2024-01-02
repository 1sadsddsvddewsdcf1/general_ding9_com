package com.ding9.sql;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;







public class DBAccessDefaultlImpl
  implements IDBAccess
{
  private static Log log = LogFactory.getLog(DBAccessDefaultlImpl.class);
  

  protected Map paramMap;
  


  public DBAccessDefaultlImpl()
  {
    this.paramMap = new HashMap();
  }
  

  public Connection getConnection()
    throws SQLException
  {
    Connection conn = null;
    
    conn = DBConnectionDefaultImpl.getConnection();
    
    return conn;
  }
  

  private void closeConn(Connection conn)
  {
    try
    {
      if (conn != null) {
        conn.close();
        conn = null;
      }
      this.paramMap = null;
    }
    catch (SQLException ex) {
      if (log.isErrorEnabled()) {
        log.error(ex);
      }
    }
  }
  





  public void closeConnection() {}
  




  protected void finalize() {}
  




  public int modifyData(String sbsql)
  {
    Connection conn = null;
    int sqlresult = -1;
    PreparedStatement pstmt = null;
    label224:
    try {
      conn = getConnection();
      
      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement(sbsql.toString());
      setQueryParam(pstmt);
      sqlresult = pstmt.executeUpdate();
      conn.commit();
    }
    catch (SQLException ex) {
      sqlresult = -1;
      ex.printStackTrace();
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex);
      }
      try {
        conn.rollback();
      }
      catch (SQLException exs) {
        if (!log.isErrorEnabled()) break label224; 
      log.error(sbsql + exs.toString());}
    }
    finally
    {
      try
      {
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      }
      catch (SQLException ex) {
        sqlresult = -1;
        if (log.isErrorEnabled()) {
          log.error(sbsql + ex.toString());
        }
      }
    }
    
    closeConn(conn);
    return sqlresult;
  }
  




  public List queryData(String sbsql, BaseResult results)
  {
    Connection conn = null;
    
    List result = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    int i = 0;
    try {
      conn = getConnection();
      

      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement(sbsql.toString());
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      


      if (rs != null)
      {
        result = new ArrayList();
        while (rs.next())
        {
          Object object = results.getMapRow(rs, i);
          result.add(i, object);
          i++;
        }
        rs.close();
        rs = null;
      }
      conn.commit();
    }
    catch (SQLException ex)
    {
      result = null;
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex.toString());
      }
    }
    catch (Exception ex) {
      result = null;
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex.toString());
      }
    }
    finally {
      try {
        if (rs != null) {
          rs.close();
          rs = null;
        }
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      }
      catch (SQLException ex) {
        result = null;
        if (log.isErrorEnabled()) {
          log.error(sbsql + ex.toString());
        }
      }
    }
    
    closeConn(conn);
    return result;
  }
  
  public List queryForPagedList(String sbsql, BaseResult results) {
    Connection conn = null;
    
    List result = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    int i = 0;
    try {
      conn = getConnection();
      

      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement(sbsql.toString());
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      


      if (rs != null)
      {
        result = new PagedList();
        while (rs.next())
        {
          Object object = results.getMapRow(rs, i);
          if (object != null) {
            result.add(i, object);
            i++;
          }
        }
        rs.close();
        rs = null;
      }
      conn.commit();
    }
    catch (SQLException ex)
    {
      result = null;
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex.toString());
      }
    }
    catch (Exception ex) {
      result = null;
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex.toString());
      }
    }
    finally {
      try {
        if (rs != null) {
          rs.close();
          rs = null;
        }
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      }
      catch (SQLException ex) {
        result = null;
        if (log.isErrorEnabled()) {
          log.error(sbsql + ex.toString());
        }
      }
    }
    
    closeConn(conn);
    return result;
  }
  


  public List queryForList(String sbsql)
  {
    BaseResult results = new ColumnMapRowMapper();
    return queryData(sbsql, results);
  }
  

  public int queryDataNumber(String sbsql)
  {
    Connection conn = null;
    
    int sqlresult = 0;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    try
    {
      conn = getConnection();
      
      conn.setAutoCommit(false);
      if (sbsql.indexOf("from") > -1) {
        sbsql = sbsql.substring(sbsql.indexOf("from") + 4);
      } else if (sbsql.indexOf("FROM") > -1) {
        sbsql = sbsql.substring(sbsql.indexOf("FROM") + 4);
      }
      pstmt = conn.prepareStatement("select count(*) from " + sbsql.toString());
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      

      if ((rs != null) && 
        (rs.next())) {
        sqlresult = rs.getInt(1);
      }
      
      conn.commit();
    }
    catch (SQLException ex) {
      sqlresult = -1;
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex.toString());
      }
    }
    finally {
      try {
        if (rs != null) {
          rs.close();
          rs = null;
        }
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      }
      catch (SQLException ex) {
        sqlresult = -1;
        if (log.isErrorEnabled()) {
          log.error(sbsql + ex.toString());
        }
      }
    }
    closeConn(conn);
    return sqlresult;
  }
  





  private int queryTotNumber(String sbsql)
  {
    Connection conn = null;
    
    int sqlresult = 0;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    try
    {
      conn = getConnection();
      
      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement("select count(*) from (" + sbsql.toString() + 
        ") A");
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      

      if ((rs != null) && 
        (rs.next())) {
        sqlresult = rs.getInt(1);
      }
      
      conn.commit();
    }
    catch (SQLException ex) {
      sqlresult = -1;
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex.toString());
      }
    }
    finally {
      try {
        if (rs != null) {
          rs.close();
          rs = null;
        }
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      }
      catch (SQLException ex) {
        sqlresult = -1;
        if (log.isErrorEnabled()) {
          log.error(sbsql + ex.toString());
        }
      }
    }
    try {
      if (conn != null) {
        conn.close();
        conn = null;
      }
    }
    catch (SQLException ex) {
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex);
      }
    }
    
    return sqlresult;
  }
  







  public List queryDataPagination(String sbsql, BaseResult results, int pagesize, int currentpage)
  {
    Connection conn = null;
    
    PagedList sqlresult = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    
    int beginrecord = 0;
    int endrecord = 0;
    int pagecount = 0;
    StringBuffer sbselsqlc = new StringBuffer();
    int i = 0;
    try {
      sqlresult = new PagedList();
      sqlresult.setCurrentpage(currentpage);
      sqlresult.setPageSize(pagesize);
      int recordcount = queryTotNumber(sbsql);
      if (pagesize != 0) {
        if (recordcount % pagesize == 0) {
          pagecount = recordcount / pagesize;
        }
        else {
          pagecount = recordcount / pagesize + 1;
        }
      }
      sqlresult.setPagecount(pagecount);
      sqlresult.setRecordcount(recordcount);
      if (currentpage > pagecount) {
        currentpage = 1;
        sqlresult.setCurrentpage(currentpage);
      }
      




      beginrecord = (currentpage - 1) * pagesize + 1;
      endrecord = (currentpage - 1) * pagesize + pagesize;
      
      sbselsqlc.append(
        "select * from (select a.*,rownum as pagination_row_id from (");
      sbselsqlc.append(sbsql.toString());
      sbselsqlc.append(") a)  where pagination_row_id between ");
      sbselsqlc.append(beginrecord + " and " + endrecord);
      




      conn = getConnection();
      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement(sbselsqlc.toString());
      
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      

      if (rs != null) {
        while (rs.next()) {
          Object object = results.getMapRow(rs, i);
          sqlresult.add(i, object);
          i++;
        }
        rs.close();
        rs = null;
      }
      conn.commit();
    } catch (SQLException ex) {
      sqlresult = null;
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex.toString());
      }
    } catch (Exception ex) {
      sqlresult = null;
      if (log.isErrorEnabled()) {
        log.error(sbsql + ex.toString());
      }
    } finally {
      try {
        if (rs != null) {
          rs.close();
          rs = null;
        }
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      } catch (SQLException ex) {
        sqlresult = null;
        if (log.isErrorEnabled()) {
          log.error(sbsql + ex.toString());
        }
      }
    }
    
    closeConn(conn);
    return sqlresult;
  }
  
  public List queryTopData(String sbsql, BaseResult results, int pagesize, int currentpage) {
    Connection conn = null;
    
    PagedList sqlresult = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    
    int beginrecord = 0;
    int endrecord = 0;
    int pagecount = 0;
    StringBuffer sbselsqlc = new StringBuffer();
    int i = 0;
    
    sqlresult = new PagedList();
    sqlresult.setCurrentpage(currentpage);
    sqlresult.setPageSize(pagesize);
    sqlresult.setPagecount(pagecount);
    if (currentpage > pagecount) {
      currentpage = 1;
      sqlresult.setCurrentpage(currentpage);
    }
    

    beginrecord = (currentpage - 1) * pagesize + 1;
    endrecord = (currentpage - 1) * pagesize + pagesize;
    
    sbselsqlc.append("select * from (select a.*,rownum as pagination_row_id from (");
    sbselsqlc.append(sbsql.toString());
    sbselsqlc.append(") a)  where pagination_row_id between ");
    sbselsqlc.append(beginrecord + " and " + endrecord);
    



    try
    {
      conn = getConnection();
      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement(sbselsqlc.toString());
      
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      

      if (rs != null) {
        while (rs.next()) {
          Object object = results.getMapRow(rs, i);
          sqlresult.add(i, object);
          i++;
        }
        rs.close();
        rs = null;
      }
      conn.commit();
    } catch (SQLException ex) {
      sqlresult = null;
      if (log.isErrorEnabled()) {
        log.error("SQLException: " + sbsql + ex.getMessage());
        ex.printStackTrace();
      }
    } catch (Exception ex) {
      sqlresult = null;
      if (log.isErrorEnabled()) {
        log.error("Exception: " + sbsql + ex.getMessage());
        ex.printStackTrace();
      }
    } finally {
      try {
        if (rs != null) {
          rs.close();
          rs = null;
        }
        if (pstmt != null) {
          pstmt.close();
          pstmt = null;
        }
      } catch (SQLException ex) {
        sqlresult = null;
        if (log.isErrorEnabled()) {
          log.error(sbsql + ex.toString());
        }
      }
    }
    
    closeConn(conn);
    return sqlresult;
  }
  
  public void setParam(SQLParam param)
  {
    if (param != null) {
      this.paramMap.put(new Integer(param.getIndex()), param);
    }
  }
  
  protected void setQueryParam(PreparedStatement pstmt) throws SQLException {
    if ((pstmt != null) && (this.paramMap.size() > 0))
    {
      Iterator itrParam = this.paramMap.values().iterator();
      SQLParam param = null;
      while (itrParam.hasNext()) {
        param = (SQLParam)itrParam.next();
        switch (param.getParamType())
        {
        case 1: 
          pstmt.setInt(param.getIndex(), param.getInt());
          break;
        
        case 2: 
          pstmt.setLong(param.getIndex(), param.getLong());
          break;
        
        case 3: 
          pstmt.setDouble(param.getIndex(), param.getDouble());
          break;
        
        case 4: 
          pstmt.setFloat(param.getIndex(), param.getFloat());
          break;
        
        case 5: 
          pstmt.setString(param.getIndex(), param.getString());
          break;
        case 6: 
          if (param.getValue() != null) {
            pstmt.setTimestamp(param.getIndex(), new Timestamp(param.getDate().getTime()));
          } else {
            pstmt.setTimestamp(param.getIndex(), null);
          }
          break;
        case 7: 
          String str = param.getString();
          if (str != null) {
            pstmt.setCharacterStream(param.getIndex(), new StringReader(str), str.length());
          } else {
            pstmt.setString(param.getIndex(), "");
          }
          break;
        default: 
          pstmt.setObject(param.getIndex(), param.getValue());
        }
      }
    }
  }
}
