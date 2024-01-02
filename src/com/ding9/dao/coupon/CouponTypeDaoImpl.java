package com.ding9.dao.coupon;

import com.ding9.result.coupon.CouponTypeList;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.util.List;


public class CouponTypeDaoImpl
  implements CouponTypeDao
{
  public List getCouponType(int shopid)
  {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new CouponTypeList();
    StringBuffer sql = new StringBuffer();
    sql.append("select TYPE_ID, SHOP_ID, COUPON_NAME from coupon_type where shop_id=? ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, shopid));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
}
