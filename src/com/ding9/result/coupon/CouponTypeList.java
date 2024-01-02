package com.ding9.result.coupon;

import com.ding9.dao.coupon.CouponInfoDao;
import com.ding9.dao.coupon.CouponInfoDaoImpl;
import com.ding9.entity.coupon.CouponType;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CouponTypeList
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    CouponType type = new CouponType();
    int shopid = rs.getInt("SHOP_ID");
    int typeid = rs.getInt("type_id");
    type.setShop_id(rs.getInt("SHOP_ID"));
    type.setCoupon_name(rs.getString("COUPON_NAME"));
    type.setType_id(rs.getInt("type_id"));
    CouponInfoDao dao = new CouponInfoDaoImpl();
    type.setCoupon_info(dao.getCouponInfo(shopid, typeid));
    return type;
  }
}
