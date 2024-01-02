package com.ding9.sql;

import java.io.IOException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;











class DefaultDBConnectionPool
{
  private static Log log = LogFactory.getLog(DefaultDBConnectionPool.class);
  
  public DbConnectionPool connectionPool = null;
  public boolean newpool = false;
  private String driver;
  private String server;
  private String username;
  private String password;
  private int minConnections; private int maxConnections; private int connectionTimeout; private int maxFreetimeout; private boolean debug; private Object initLock = new Object();
  


  public DefaultDBConnectionPool(HashMap hm)
  {
    ConnectionPoolInit(hm);
    start();
  }
  
  private void ConnectionPoolInit(HashMap hm) {
    try {
      this.driver = ((String)hm.get("driver"));
      this.server = ((String)hm.get("url"));
      this.username = ((String)hm.get("username"));
      this.password = ((String)hm.get("password"));
      this.minConnections = Integer.parseInt((String)hm.get("minconnections"));
      this.maxConnections = Integer.parseInt((String)hm.get("maxconnections"));
      this.connectionTimeout = Integer.parseInt((String)hm.get("connectiontimeout"));
      this.maxFreetimeout = Integer.parseInt((String)hm.get("maxfreetimeout"));
      this.debug = Boolean.valueOf((String)hm.get("debug")).booleanValue();
      
      if (log.isDebugEnabled()) {
        log.debug("this.driver  :  " + this.driver);
        log.debug("this.server  :  " + this.server);
        log.debug("this.username  :  " + this.username);
        log.debug("this.password  :  " + this.password);
        log.debug("this.minConnections  :  " + this.minConnections);
        log.debug("this.maxConnections  :  " + this.maxConnections);
        log.debug("this.connectionTimeout  :  " + this.connectionTimeout);
        log.debug("this.maxFreetimeout  :  " + this.maxFreetimeout);
        log.debug("this.debug  :  " + this.debug);
      }
    }
    catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.debug(e.toString());
      }
    }
  }
  



  public void init() {}
  



  public Connection getConnection()
  {
    if (this.connectionPool == null) {
      synchronized (this.initLock) {
        if (this.connectionPool == null) {
          return null;
        }
      }
    }
    return new ConnectionWrapper(this.connectionPool.getConnection(), this.connectionPool);
  }
  
  public int getUseCount() {
    if (this.connectionPool == null) {
      synchronized (this.initLock) {
        if (this.connectionPool == null) {
          return -1;
        }
      }
    }
    return this.connectionPool.getUseCount();
  }
  
  public int getSize() {
    if (this.connectionPool == null) {
      synchronized (this.initLock) {
        if (this.connectionPool == null) {
          return -1;
        }
      }
    }
    return this.connectionPool.getSize();
  }
  


  public void start()
  {
    synchronized (this.initLock) {
      try {
        if (this.connectionPool == null) {
          init();
          this.connectionPool = new DbConnectionPool();
        }
      }
      catch (IOException ioe) {
        if (log.isErrorEnabled()) {
          log.error("Error starting DbConnectionDefaultPool: " + ioe.toString());
        }
      }
    }
  }
  




  public void restart()
  {
    destroy();
    
    start();
  }
  



  public void destroy()
  {
    if (this.connectionPool != null) {
      try {
        this.connectionPool.destroy();
      }
      catch (Exception e) {
        if (log.isErrorEnabled()) {
          log.error("destroy connection pool error......");
        }
      }
    }
  }
  
  private class DbConnectionPool implements Runnable
  {
    private Log log = LogFactory.getLog(DbConnectionPool.class);
    
    private Thread runner;
    
    private Connection[] connPool;
    
    private int[] connStatus;
    private long[] connLockTime;
    private long[] connCreateDate;
    private String[] connID;
    private boolean available = true;
    private long poolLockTime;
    private int currConnections;
    private int maxConnMSec;
    private int connLast;
    
    public DbConnectionPool()
      throws IOException
    {
      this.connPool = new Connection[DefaultDBConnectionPool.this.maxConnections];
      this.connStatus = new int[DefaultDBConnectionPool.this.maxConnections];
      this.connLockTime = new long[DefaultDBConnectionPool.this.maxConnections];
      this.connCreateDate = new long[DefaultDBConnectionPool.this.maxConnections];
      this.connID = new String[DefaultDBConnectionPool.this.maxConnections];
      
      this.poolLockTime = System.currentTimeMillis();
      
      this.currConnections = DefaultDBConnectionPool.this.minConnections;
      
      this.maxConnMSec = DefaultDBConnectionPool.this.connectionTimeout;
      
      boolean connectionsSucceeded = false;
      int dbLoop = 5;
      try
      {
        for (int i = 1; i < dbLoop; i++) {
          try {
            for (int j = 0; j < this.currConnections; j++) {
              createConn(j);
            }
            connectionsSucceeded = true;
          }
          catch (SQLException e)
          {
            if (this.log.isErrorEnabled()) {
              this.log.error("--->Attempt (" + String.valueOf(i) + 
                " of " + String.valueOf(dbLoop) + 
                ") failed to create new connections set at startup: ");
              this.log.error("    " + e.toString());
              this.log.error("    Will try again in 10 seconds...");
            }
            try {
              Thread.sleep(10000L);
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
        if (!connectionsSucceeded) {
          if (this.log.isErrorEnabled()) {
            this.log.error("\r\nAll attempts at connecting to Database exhausted");
          }
          throw new IOException();
        }
        
        if (this.log.isDebugEnabled()) {
          this.log.debug("connection pool started...");
        }
      }
      catch (Exception e)
      {
        if (this.log.isErrorEnabled()) {
          this.log.error(e.toString());
        }
        throw new IOException();
      }
      
      this.runner = new Thread(this);
      this.runner.start();
    }
    
    public void run()
    {
      boolean forever = true;
      Statement stmt = null;
      
      while (forever) {
        if (System.currentTimeMillis() - this.poolLockTime > DefaultDBConnectionPool.this.maxFreetimeout) {
          destroy();
          DefaultDBConnectionPool.this.connectionPool = null;
          if (this.log.isDebugEnabled()) {
            this.log.debug("Max free timeout !!! Destroy pool....");
          }
          return;
        }
        
        for (int i = 0; i < this.currConnections; i++) {
          long age = System.currentTimeMillis() - this.connCreateDate[i];
          long runage = System.currentTimeMillis() - this.connLockTime[i];
          try
          {
            synchronized (this.connStatus)
            {
              if ((this.connStatus[i] > 0) && (runage > this.maxConnMSec)) {
                if (this.log.isDebugEnabled()) {
                  this.log.debug("connection " + i + " timeout!!");
                }
                freeConnection(this.connPool[i]);
              }
              
              if ((this.connStatus[i] > 0) && (!this.connPool[i].isClosed()))
              {





















                try
                {






















                  if (stmt == null) continue;
                  stmt.close();
                }
                catch (SQLException localSQLException1) {}
              }
              if ((age > 2 * this.maxConnMSec) && (this.connStatus[i] == 0))
              {
                if (this.log.isDebugEnabled()) {
                  this.log.debug("connection " + i + " maxtimeout!!");
                }
                throw new SQLException();
              }
              
              if (this.connPool[i].isClosed()) {
                if (this.log.isDebugEnabled()) {
                  this.log.debug("connection " + i + " isclosed!!");
                }
                throw new SQLException();
              }
              
              stmt = this.connPool[i].createStatement();
              this.connStatus[i] = 0;
            }
          }
          catch (SQLException e)
          {
            try {
              this.connPool[i].close();
              if ((this.currConnections > DefaultDBConnectionPool.this.minConnections) && (i == this.currConnections - 1) && 
                (this.connPool[i].isClosed())) {
                this.currConnections -= 1;
                if (this.log.isDebugEnabled()) {
                  this.log.debug("cancel connection " + String.valueOf(i));
                }
              }
              else {
                createConn(i);
              }
            }
            catch (SQLException e1) {
              if (this.log.isErrorEnabled()) {
                this.log.error("Failed: " + e1.toString());
              }
              this.connStatus[i] = 0;
            }
          }
          finally {
            try {
              if (stmt != null) {
                stmt.close();
              }
            }
            catch (SQLException localSQLException2) {}
          }
          try
          {
            if (stmt != null) {
              stmt.close();
            }
          }
          catch (SQLException localSQLException3) {}
        }
        

        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException e) {
          return;
        }
      }
    }
    
    public Connection getConnection()
    {
      this.poolLockTime = System.currentTimeMillis();
      
      Connection conn = null;
      
      if (this.available) {
        boolean gotOne = false;
        
        for (int outerloop = 1; outerloop <= 5; outerloop++)
        {
          try {
            int loop = 0;
            int roundRobin = this.connLast + 1;
            if (roundRobin >= this.currConnections) {
              roundRobin = 0;
            }
            do {
              synchronized (this.connStatus) {
                if ((this.connStatus[roundRobin] < 1) && 
                  (!this.connPool[roundRobin].isClosed())) {
                  conn = this.connPool[roundRobin];
                  this.connStatus[roundRobin] = 1;
                  this.connLockTime[roundRobin] = System.currentTimeMillis();
                  this.connLast = roundRobin;
                  gotOne = true;
                  break;
                }
                
                loop++;
                roundRobin++;
                if (roundRobin >= this.currConnections) {
                  roundRobin = 0;
                }
              }
              

              if (gotOne) break; } while (loop < this.currConnections);
          }
          catch (SQLException localSQLException1) {}
          
          if (gotOne) {
            break;
          }
          
          synchronized (this) {
            if (this.currConnections < DefaultDBConnectionPool.this.maxConnections) {
              try {
                createConn(this.currConnections);
                this.currConnections += 1;
              }
              catch (SQLException e) {
                if (this.log.isErrorEnabled()) {
                  this.log.error("Unable to create new connection: " + e.toString());
                }
              }
            }
          }
          try
          {
            Thread.sleep(2000L);
          }
          catch (InterruptedException localInterruptedException) {}
          if (this.log.isDebugEnabled()) {
            this.log.debug(
              "-----> Connections Exhausted!  Will wait and try again in loop " + 
              
              String.valueOf(outerloop));
          }
          
        }
        

      }
      else if (this.log.isDebugEnabled()) {
        this.log.debug(
          "Unsuccessful getConnection() request during destroy()");
      }
      

      if (this.log.isDebugEnabled()) {
        this.log.debug("get connection " + idOfConnection(conn));
      }
      return conn;
    }
    
    public int idOfConnection(Connection conn)
    {
      String tag;
      try
      {
        tag = conn.toString();
      } catch (NullPointerException e1) {
        //String tag;
        tag = "none";
      }
      
      int match = -1;
      
      for (int i = 0; i < this.currConnections; i++) {
        if (this.connID[i].equals(tag)) {
          match = i;
          break;
        }
      }
      return match;
    }
    
    public void freeConnection(Connection conn) {
      int thisconn = idOfConnection(conn);
      if (thisconn >= 0) {
        this.connStatus[thisconn] = 0;
        if (this.log.isDebugEnabled()) {
          this.log.debug("release connection " + idOfConnection(conn));
        }
        
      }
      else if (this.log.isDebugEnabled()) {
        this.log.debug("----> Could not free connection!!!");
      }
    }
    
    private void createConn(int i) throws SQLException
    {
      Date now = new Date();
      try {
        Class.forName(DefaultDBConnectionPool.this.driver);
        this.connPool[i] = DriverManager.getConnection(DefaultDBConnectionPool.this.server, DefaultDBConnectionPool.this.username, DefaultDBConnectionPool.this.password);
        this.connStatus[i] = 0;
        this.connID[i] = this.connPool[i].toString();
        this.connLockTime[i] = 0L;
        this.connCreateDate[i] = now.getTime();
        
        if (this.log.isDebugEnabled()) {
          this.log.debug("Creating connection " + String.valueOf(i));
        }
      }
      catch (ClassNotFoundException e2) {
        if (this.log.isErrorEnabled()) {
          this.log.error(e2.toString());
        }
        throw new SQLException(e2.getMessage());
      }
    }
    
    public void destroy(int millis) throws SQLException {
      this.available = false;
      
      this.runner.interrupt();
      try
      {
        this.runner.join(millis);
      }
      catch (InterruptedException localInterruptedException) {}
      

      for (int i = 0; i < this.currConnections; i++) {
        try {
          this.connPool[i].close();
        }
        catch (SQLException e1) {
          if (this.log.isDebugEnabled()) {
            this.log.debug("Cannot close connections on Destroy");
          }
        }
      }
      if (this.log.isDebugEnabled()) {
        this.log.debug("connection pool destroyed...");
      }
    }
    
    public void destroy()
    {
      try {
        destroy(20000);
        DefaultDBConnectionPool.this.connectionPool = null;
      }
      catch (SQLException localSQLException) {}
    }
    
    public int getUseCount() {
      int useCount = 0;
      synchronized (this.connStatus) {
        for (int i = 0; i < this.currConnections; i++) {
          if (this.connStatus[i] > 0) {
            useCount++;
          }
        }
      }
      return useCount;
    }
    
    public int getSize() {
      return this.currConnections;
    }
  }
  
  public class ConnectionWrapper
    implements Connection
  {
    private Log log = LogFactory.getLog(ConnectionWrapper.class);
    
    private Connection connection;
    private DefaultDBConnectionPool.DbConnectionPool connectionPool;
    private Statement stmt = null;
    
    public ConnectionWrapper(Connection connection, DefaultDBConnectionPool.DbConnectionPool connectionPool)
    {
      this.connection = connection;
      this.connectionPool = connectionPool;
    }
    
    public void close() {
      try {
        if (this.stmt != null) {
          this.stmt.close();
          this.stmt = null;
          if (this.log.isDebugEnabled()) {
            this.log.debug("statement closed...");
          }
        }
      }
      catch (Exception e) {
        if (this.log.isErrorEnabled()) {
          this.log.error("statement close error...." + e.toString());
        }
      }
      this.connectionPool.freeConnection(this.connection);
      this.connection = null;
      this.connectionPool = null;
    }
    
    public void setHoldability(int holdability) throws SQLException {
      this.connection.setHoldability(holdability);
    }
    
    public int getHoldability() throws SQLException {
      return this.connection.getHoldability();
    }
    
    public Savepoint setSavepoint() throws SQLException {
      return this.connection.setSavepoint();
    }
    
    public Savepoint setSavepoint(String name) throws SQLException {
      return this.connection.setSavepoint(name);
    }
    
    public void rollback(Savepoint savepoint) throws SQLException {
      this.connection.rollback(savepoint);
    }
    
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
      this.connection.releaseSavepoint(savepoint);
    }
    

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException
    {
      return this.connection.createStatement(resultSetType, resultSetConcurrency, 
        resultSetHoldability);
    }
    

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException
    {
      return this.connection.prepareStatement(sql, resultSetType, 
        resultSetConcurrency, 
        resultSetHoldability);
    }
    

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException
    {
      return this.connection.prepareCall(sql, resultSetType, resultSetConcurrency, 
        resultSetHoldability);
    }
    
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException
    {
      return this.connection.prepareStatement(sql, autoGeneratedKeys);
    }
    
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException
    {
      return this.connection.prepareStatement(sql, columnIndexes);
    }
    
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException
    {
      return this.connection.prepareStatement(sql, columnNames);
    }
    
    public Statement createStatement() throws SQLException {
      this.stmt = this.connection.createStatement();
      return this.stmt;
    }
    
    public PreparedStatement prepareStatement(String sql) throws SQLException {
      return this.connection.prepareStatement(sql);
    }
    
    public CallableStatement prepareCall(String sql) throws SQLException {
      return this.connection.prepareCall(sql);
    }
    
    public String nativeSQL(String sql) throws SQLException {
      return this.connection.nativeSQL(sql);
    }
    
    public void setAutoCommit(boolean autoCommit) throws SQLException {
      this.connection.setAutoCommit(autoCommit);
    }
    
    public boolean getAutoCommit() throws SQLException {
      return this.connection.getAutoCommit();
    }
    
    public void commit() throws SQLException {
      this.connection.commit();
    }
    
    public void rollback() throws SQLException {
      this.connection.rollback();
    }
    
    public boolean isClosed() throws SQLException {
      return this.connection.isClosed();
    }
    
    public DatabaseMetaData getMetaData() throws SQLException {
      return this.connection.getMetaData();
    }
    
    public void setReadOnly(boolean readOnly) throws SQLException {
      this.connection.setReadOnly(readOnly);
    }
    
    public boolean isReadOnly() throws SQLException {
      return this.connection.isReadOnly();
    }
    
    public void setCatalog(String catalog) throws SQLException {
      this.connection.setCatalog(catalog);
    }
    
    public String getCatalog() throws SQLException {
      return this.connection.getCatalog();
    }
    
    public void setTransactionIsolation(int level) throws SQLException {
      this.connection.setTransactionIsolation(level);
    }
    
    public int getTransactionIsolation() throws SQLException {
      return this.connection.getTransactionIsolation();
    }
    
    public SQLWarning getWarnings() throws SQLException {
      return this.connection.getWarnings();
    }
    
    public void clearWarnings() throws SQLException {
      this.connection.clearWarnings();
    }
    
    public Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException
    {
      return this.connection.createStatement(resultSetType, resultSetConcurrency);
    }
    
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException
    {
      return this.connection.prepareStatement(sql, resultSetType, 
        resultSetConcurrency);
    }
    
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException
    {
      return this.connection.prepareCall(sql, resultSetType, resultSetConcurrency);
    }
    
    public Map getTypeMap() throws SQLException {
      return this.connection.getTypeMap();
    }
    

	public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public Blob createBlob() throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public Clob createClob() throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public NClob createNClob() throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public SQLXML createSQLXML() throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public Properties getClientInfo() throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public String getClientInfo(String arg0) throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public boolean isValid(int arg0) throws SQLException {
		// TODO 自动生成方法存根
		return false;
	}

	public void setClientInfo(Properties arg0) throws SQLClientInfoException {
		// TODO 自动生成方法存根
		
	}

	public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
		// TODO 自动生成方法存根
		
	}

	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO 自动生成方法存根
		return false;
	}

	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO 自动生成方法存根
		return null;
	}

	public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
		// TODO 自动生成方法存根
		
	}
  }
}
