package com.ding9.result.shopcity;

import com.ding9.dao.coupon.CouponInfoDao;
import com.ding9.dao.coupon.CouponInfoDaoImpl;
import com.ding9.dao.coupon.CouponTypeDao;
import com.ding9.dao.coupon.CouponTypeDaoImpl;
import com.ding9.entity.shopcenter.ShopCenter;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import java.sql.ResultSet;
import java.sql.SQLException;




public class ShopCenterList
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    ShopCenter map = new ShopCenter();
    int shopId = rs.getInt("shop_id");
    map.setShop_id(shopId);
    CouponTypeDao dao = new CouponTypeDaoImpl();
    map.setCouponType(dao.getCouponType(shopId));
    map.setIntroduction(rs.getString("INTRODUCTION"));
    map.setFigure_pic(Environment.getImageServer() + rs.getString("FIGURE_PIC"));
    map.setShop_name(rs.getString("SHOP_NAME"));
    CouponInfoDao dao2 = new CouponInfoDaoImpl();
    map.setPic_coupon(dao2.getPicCouponInfo(shopId));
    return map;
  }
}
