package com.ding9.result.shopcity;

import com.ding9.entity.shopcenter.ShopCenter;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ShopCenterFull
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    ShopCenter map = new ShopCenter();
    int shopId = rs.getInt("shop_id");
    map.setShop_id(shopId);
    map.setAddress(rs.getString("address"));
    map.setDetail(rs.getString("detail"));
    map.setFigure_pic(Environment.getImageServer() + rs.getString("figure_pic"));
    map.setIntroduction(rs.getString("introduction"));
    map.setIs_display(rs.getInt("is_display"));
    String logopic = rs.getString("logo_pic");
    if ((logopic != null) && (!"".equals(logopic.trim())))
      map.setLogo_pic(Environment.getImageServer() + rs.getString("logo_pic"));
    map.setMap_pic(Environment.getImageServer() + rs.getString("map_pic"));
    map.setPark(rs.getString("park"));
    map.setRoute(rs.getString("route"));
    map.setShop_name(rs.getString("shop_name"));
    map.setTelephone(rs.getString("telephone"));
    map.setWebaddress(rs.getString("webaddress"));
    try {
      map.setType_id(rs.getInt("type_id"));
    } catch (Exception localException) {}
    try {
      map.setType_name_two(rs.getString("type_name_two"));
    } catch (Exception localException1) {}
    try {
      map.setType_name_one(rs.getString("type_name_one"));
    } catch (Exception localException2) {}
    try {
      map.setType_id_one(rs.getInt("type_id_one"));
    } catch (Exception localException3) {}
    return map;
  }
}
