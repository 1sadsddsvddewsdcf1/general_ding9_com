package com.ding9.click.result.accesslog;

import com.ding9.click.entity.accesslog.IBLAccessLogData;
import com.ding9.click.entity.accesslog.impl.BLAccessLogData;
import com.ding9.click.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BLAccessLogDataResult implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    IBLAccessLogData accesslog = new BLAccessLogData();
    

    return accesslog;
  }
}
