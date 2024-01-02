package com.ding9.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract interface BaseResult
{
  public abstract Object getMapRow(ResultSet paramResultSet, int paramInt)
    throws SQLException;
}
