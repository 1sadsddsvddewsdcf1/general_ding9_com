package com.ding9.click.result.baseinfo;

import com.ding9.click.entity.baseinfo.IBilllineData;
import com.ding9.click.entity.baseinfo.impl.BilllineData;
import com.ding9.click.sql.BaseResult;
import com.ding9.click.util.DateHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BilllineDataResult implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    IBilllineData bldata = new BilllineData();
    try
    {
      bldata.setBl_id(rs.getInt("bl_id"));
    } catch (Exception localException) {}
    try {
      bldata.setBl_name(rs.getString("bl_name"));
    } catch (Exception localException1) {}
    try {
      bldata.setBl_url(rs.getString("bl_url"));
    } catch (Exception localException2) {}
    try {
      bldata.setBl_status(rs.getInt("bl_status"));
    } catch (Exception localException3) {}
    try {
      bldata.setCreate_time(DateHelper.toString(rs.getTimestamp("apply_time"), "yyyy-MM-dd"));
    } catch (Exception localException4) {}
    try {
      bldata.setBl_remark(rs.getString("bl_remark"));
    }
    catch (Exception localException5) {}
    return bldata;
  }
}
