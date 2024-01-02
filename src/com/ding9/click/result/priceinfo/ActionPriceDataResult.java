package com.ding9.click.result.priceinfo;

import com.ding9.click.entity.priceinfo.IActionPriceData;
import com.ding9.click.entity.priceinfo.impl.ActionPriceData;
import com.ding9.click.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActionPriceDataResult implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    IActionPriceData apdata = new ActionPriceData();
    try
    {
      apdata.setCooperate_id(rs.getInt("cooperate_id"));
    } catch (Exception localException) {}
    try {
      apdata.setCooperate_name(rs.getString("cooperate_name"));
    } catch (Exception localException1) {}
    try {
      apdata.setAction_price(rs.getInt("action_price"));
    }
    catch (Exception localException2) {}
    return apdata;
  }
}
