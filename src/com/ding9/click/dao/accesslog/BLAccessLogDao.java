package com.ding9.click.dao.accesslog;

import com.ding9.click.entity.accesslog.IBLAccessLogData;
import java.sql.SQLException;

public abstract interface BLAccessLogDao
{
  public abstract int addAccessLog(IBLAccessLogData paramIBLAccessLogData)
    throws SQLException;
}
