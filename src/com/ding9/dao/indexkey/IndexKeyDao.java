package com.ding9.dao.indexkey;

import java.sql.SQLException;
import java.util.List;

public abstract interface IndexKeyDao
{
  public abstract List getkeyWord(String paramString)
    throws SQLException;
  
  public abstract List getKeywordsOptimize(int paramInt)
    throws SQLException;
  
  public abstract List getTypekeyWord(int paramInt1, int paramInt2)
    throws SQLException;
}
