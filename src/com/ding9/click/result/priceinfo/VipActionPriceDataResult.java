package com.ding9.click.result.priceinfo;

import com.ding9.click.entity.priceinfo.IVipActionPriceData;
import com.ding9.click.entity.priceinfo.impl.VipActionPriceData;
import com.ding9.click.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VipActionPriceDataResult implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    IVipActionPriceData vipapdata = new VipActionPriceData();
    try
    {
      vipapdata.setVipbl_id(rs.getInt("vipbl_id"));
    } catch (Exception localException) {}
    try {
      vipapdata.setCooperate_id(rs.getInt("cooperate_id"));
    } catch (Exception localException1) {}
    try {
      vipapdata.setAction_price(rs.getInt("action_price"));
    }
    catch (Exception localException2) {}
    return vipapdata;
  }
}
