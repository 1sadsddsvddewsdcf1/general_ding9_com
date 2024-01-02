package com.ding9.sql;

import java.sql.Connection;
import java.sql.SQLException;

public abstract interface IDBConnection
{
  public abstract void init();
  
  public abstract void start();
  
  public abstract int getSize();
  
  public abstract int getUsed();
  
  public abstract void destroy()
    throws SQLException;
  
  public abstract void restart();
  
  public abstract Connection getConnection()
    throws SQLException;
  
  public abstract boolean closeConnection(Connection paramConnection)
    throws SQLException;
}
