package com.ding9.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract interface IDBAccess
{
  public abstract Connection getConnection()
    throws SQLException;
  
  public abstract void closeConnection();
  
  public abstract int modifyData(String paramString);
  
  public abstract List queryData(String paramString, BaseResult paramBaseResult);
  
  public abstract int queryDataNumber(String paramString);
  
  public abstract List queryDataPagination(String paramString, BaseResult paramBaseResult, int paramInt1, int paramInt2);
  
  public abstract List queryTopData(String paramString, BaseResult paramBaseResult, int paramInt1, int paramInt2);
  
  public abstract void setParam(SQLParam paramSQLParam);
}
