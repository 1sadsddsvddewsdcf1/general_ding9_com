package com.ding9.click.dao.baseinfo;

import java.sql.SQLException;
import java.util.HashMap;

public abstract interface BilllineDao
{
  public abstract int validateBlCode(int paramInt)
    throws SQLException;
  
  public abstract HashMap getBLCodes();
}
