package com.ding9.dao.shopcenter;

import com.ding9.dao.coupon.CouponInfoDaoImpl;
import com.ding9.result.shopcity.ShopCenterFull;
import com.ding9.result.shopcity.ShopCenterList;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.io.PrintStream;
import java.util.List;

public class ShopCenterDaoImpl
  implements ShopCenterDao
{
  public List getRecommendShopCenter()
  {
    if ((recommendShop == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      IDBAccess dba = null;
      BaseResult index = new ShopCenterList();
      StringBuffer sql = new StringBuffer();
      sql.append("select shop_id,shop_name,figure_pic,introduction,detail  from shopcenter where is_recommend>0 and city_id=? and is_display=0 order by is_recommend ");
      dba = new DBAccessDefaultlImpl();
      dba.setParam(new SQLParam(1, 1, Environment.getShopCityId()));
      recommendShop = dba.queryData(sql.toString(), index);
      lasttime = System.currentTimeMillis();
    }
    return recommendShop;
  }
  
  public List getShopCenter(int shopid) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new ShopCenterFull();
    StringBuffer sql = new StringBuffer();
    sql.append("select a.shop_id,  a.city_id,  a.shop_name,address,  webaddress,  route,park,  telephone,  logo_pic,");
    sql.append(" figure_pic,  map_pic,  introduction,  detail,is_display,  is_recommend,b.type_name_two,b.type_name_one  from shopcenter a,region_type b where   a.city_id=b.city_id and a.type_id=b.type_id and a.city_id=?  and shop_id=?  and is_display=0 ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, Environment.getShopCityId()));
    dba.setParam(new SQLParam(2, 1, shopid));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public List getQuShopCenter(int type_id_one) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new ShopCenterFull();
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT B.SHOP_ID, B.CITY_ID, B.TYPE_ID, B.SHOP_NAME, B.ADDRESS, B.WEBADDRESS, B.ROUTE, PARK, TELEPHONE, LOGO_PIC, FIGURE_PIC, MAP_PIC, INTRODUCTION, IS_DISPLAY, IS_RECOMMEND, DETAIL FROM REGION_TYPE A,SHOPCENTER B WHERE  A.TYPE_ID=B.TYPE_ID AND A.CITY_ID=? AND B.CITY_ID=? AND TYPE_ID_TWO!=0 AND TYPE_ID_ONE=? and B.is_display=0 ORDER BY B.SHOP_ID DESC");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, Environment.getShopCityId()));
    dba.setParam(new SQLParam(2, 1, Environment.getShopCityId()));
    dba.setParam(new SQLParam(3, 1, type_id_one));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public static void main(String[] args) {
    CouponInfoDaoImpl cdao = new CouponInfoDaoImpl();
    System.out.println(cdao.getCouponInfoWith(7));
  }
  
  private static List recommendShop = null;
  private static long lasttime = System.currentTimeMillis();
}
