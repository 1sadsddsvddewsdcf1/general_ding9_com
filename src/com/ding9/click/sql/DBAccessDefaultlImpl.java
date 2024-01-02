package com.ding9.click.sql;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
    label184:
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
        log.error(ex);
      }
      try {
        conn.rollback();
      }
      catch (SQLException exs) {
        if (!log.isErrorEnabled()) break label184; 
      log.error(exs.toString());}
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
        System.out.println(ex.toString());
        if (log.isErrorEnabled()) {
          log.error(ex.toString());
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
      
      result = new ArrayList();
      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement(sbsql.toString());
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      conn.commit();
      

      if (rs != null)
      {

        while (rs.next())
        {
          Object object = results.getMapRow(rs, i);
          result.add(i, object);
          i++;
        }
        rs.close();
        rs = null;
      }
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
      result = null;
      if (log.isErrorEnabled()) {
        log.error(ex.toString());
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
      result = null;
      if (log.isErrorEnabled()) {
        log.error(ex.toString());
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
          log.error(ex.toString());
        }
      }
    }
    
    closeConn(conn);
    return result;
  }
  




  public String queryData(String sbsql)
  {
    Connection conn = null;
    
    String result = null;
    
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    try
    {
      conn = getConnection();
      
      conn.setAutoCommit(false);
      pstmt = conn.prepareStatement(sbsql.toString());
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      conn.commit();
      

      if (rs != null)
      {

        while (rs.next())
        {
          result = rs.getString(1);
        }
        rs.close();
        rs = null;
      }
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
      result = null;
      if (log.isErrorEnabled()) {
        log.error(ex.toString());
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
      result = null;
      if (log.isErrorEnabled()) {
        log.error(ex.toString());
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
        ex.printStackTrace();
        result = null;
        if (log.isErrorEnabled()) {
          log.error(ex.toString());
        }
      }
    }
    
    closeConn(conn);
    
    return result;
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
        sbsql = "select count(*) from " + sbsql.substring(sbsql.indexOf("from") + 4);
      }
      else if (sbsql.indexOf("FROM") > -1) {
        sbsql = "select count(*) from " + sbsql.substring(sbsql.indexOf("FROM") + 4);
      }
      else {
        sbsql = "select count(*) from (" + sbsql + ") A_counter";
      }
      pstmt = conn.prepareStatement(sbsql);
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      conn.commit();
      
      if ((rs != null) && 
        (rs.next())) {
        sqlresult = rs.getInt(1);
      }
    }
    catch (SQLException ex)
    {
      sqlresult = -1;
      if (log.isErrorEnabled()) {
        log.error(ex.toString());
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
          log.error(ex.toString());
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
      if (sbsql.indexOf("from") > -1) {
        sbsql = "select count(*) from " + sbsql.substring(sbsql.indexOf("from") + 4);
      }
      else if (sbsql.indexOf("FROM") > -1) {
        sbsql = "select count(*) from " + sbsql.substring(sbsql.indexOf("FROM") + 4);
      }
      else {
        sbsql = "select count(*) from (" + sbsql + ") A_counter";
      }
      pstmt = conn.prepareStatement(sbsql);
      setQueryParam(pstmt);
      rs = pstmt.executeQuery();
      conn.commit();
      
      if ((rs != null) && 
        (rs.next())) {
        sqlresult = rs.getInt(1);
      }
    }
    catch (SQLException ex)
    {
      sqlresult = -1;
      if (log.isErrorEnabled()) {
        log.error(ex.toString());
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
          log.error(ex.toString());
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
        log.error(ex);
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
    try
    {
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
      conn.commit();
      

      if (rs != null)
      {

        while (rs.next())
        {
          Object object = results.getMapRow(rs, i);
          sqlresult.add(i, object);
          i++;
        }
        rs.close();
        rs = null;
      }
    }
    catch (Exception ex) {
      sqlresult = null;
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
        sqlresult = null;
        if (log.isErrorEnabled()) {
          log.error(ex.toString());
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
        
        default: 
          pstmt.setObject(param.getIndex(), param.getValue());
        }
      }
    }
  }
}
