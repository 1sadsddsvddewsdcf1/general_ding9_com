package com.ding9.click.dao.accesslog;

import com.ding9.click.entity.accesslog.IVipBLAccessLogData;
import java.sql.SQLException;

public abstract interface VipBLAccessLogDao
{
  public abstract int addAccessLog(IVipBLAccessLogData paramIVipBLAccessLogData)
    throws SQLException;
  
  public abstract int addAccessLog(IVipBLAccessLogData[] paramArrayOfIVipBLAccessLogData)
    throws SQLException;
}
