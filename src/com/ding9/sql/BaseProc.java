package com.ding9.sql;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

public abstract interface BaseProc
{
  public abstract Object getPama(CallableStatement paramCallableStatement, List paramList)
    throws SQLException;
}
