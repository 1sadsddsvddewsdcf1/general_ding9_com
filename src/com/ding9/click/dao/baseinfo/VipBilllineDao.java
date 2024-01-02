package com.ding9.click.dao.baseinfo;

import java.sql.SQLException;
import java.util.HashMap;

public abstract interface VipBilllineDao
{
  public abstract int validateVipBlCode(int paramInt)
    throws SQLException;
  
  public abstract HashMap getVipBLCodes();
}
