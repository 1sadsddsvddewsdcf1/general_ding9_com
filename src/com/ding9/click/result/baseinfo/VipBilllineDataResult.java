package com.ding9.click.result.baseinfo;

import com.ding9.click.entity.baseinfo.IVipBilllineData;
import com.ding9.click.entity.baseinfo.impl.VipBilllineData;
import com.ding9.click.sql.BaseResult;
import com.ding9.click.util.DateHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VipBilllineDataResult implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    IVipBilllineData vipbldata = new VipBilllineData();
    try
    {
      vipbldata.setVipbl_id(rs.getInt("vipbl_id"));
    } catch (Exception localException) {}
    try {
      vipbldata.setVipbl_name(rs.getString("vipbl_name"));
    } catch (Exception localException1) {}
    try {
      vipbldata.setVipbl_url(rs.getString("vipbl_url"));
    } catch (Exception localException2) {}
    try {
      vipbldata.setVipbl_status(rs.getInt("vipbl_status"));
    } catch (Exception localException3) {}
    try {
      vipbldata.setCreate_time(DateHelper.toString(rs.getTimestamp("apply_time"), "yyyy-MM-dd"));
    } catch (Exception localException4) {}
    try {
      vipbldata.setVipbl_remark(rs.getString("vipbl_remark"));
    }
    catch (Exception localException5) {}
    return vipbldata;
  }
}
