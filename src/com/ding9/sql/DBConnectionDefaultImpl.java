package com.ding9.sql;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;













class DBConnectionDefaultImpl
{
  private static Log log = LogFactory.getLog(DBConnectionDefaultImpl.class);
  
  private static DataSource ds = null;
  





  private static void init()
  {
    try
    {
      Context env = (Context)new InitialContext().lookup("java:comp/env");
      ds = (DataSource)env.lookup("jdbc/d9search");
      if ((ds == null) && 
        (log.isWarnEnabled())) {
        log.warn("`jdbc/d9search' is an unknown DataSource");
      }
    }
    catch (NamingException e)
    {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
    }
    catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
    }
  }
  


  public void destroy()
  {
    ds = null;
  }
  



  public static Connection getConnection()
    throws SQLException
  {
    Connection conn = null;
    
    if (ds == null) {
      init();
    }
    
    conn = ds.getConnection();
    
    return conn;
  }
  

  public static boolean closeConnection(Connection conn)
    throws SQLException
  {
    boolean result = false;
    try
    {
      conn.close();
      conn = null;
    }
    catch (SQLException localSQLException) {}
    


    return result;
  }
}
