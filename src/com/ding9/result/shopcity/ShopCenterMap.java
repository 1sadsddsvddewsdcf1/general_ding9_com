package com.ding9.result.shopcity;

import com.ding9.entity.shopcenter.ShopCenter;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ShopCenterMap
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    ShopCenter map = new ShopCenter();
    map.setShop_name(rs.getString("shop_name"));
    map.setMap_pic(Environment.getImageServer() + rs.getString("map_pic"));
    map.setShop_id(rs.getInt("shop_id"));
    return map;
  }
}
