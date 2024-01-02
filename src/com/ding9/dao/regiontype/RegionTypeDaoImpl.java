package com.ding9.dao.regiontype;

import com.ding9.result.regiontype.RegionTypeList;
import com.ding9.result.shopcity.ShopCenterFull;
import com.ding9.result.shopcity.ShopCenterMap;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.util.List;


public class RegionTypeDaoImpl
  implements RegionTypeDao
{
  public List getRegionShop()
  {
    if ((regionShop == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      IDBAccess dba = null;
      BaseResult index = new RegionTypeList();
      StringBuffer sql = new StringBuffer();
      sql.append("select TYPE_ID, CITY_ID, TYPE_ID_ONE, TYPE_ID_TWO, TYPE_NAME_ONE, TYPE_NAME_TWO from region_type where city_id=?  and type_id_two!=0 order by type_id desc");
      dba = new DBAccessDefaultlImpl();
      dba.setParam(new SQLParam(1, 1, Environment.getShopCityId()));
      regionShop = dba.queryData(sql.toString(), index);
      lasttime = System.currentTimeMillis();
    }
    return regionShop;
  }
  
  public List getShop(int type_id_two) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new ShopCenterMap();
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT B.SHOP_ID,B.SHOP_NAME,B.MAP_PIC FROM REGION_TYPE A ,SHOPCENTER B WHERE  A.TYPE_ID=B.TYPE_ID AND A.TYPE_ID_TWO=? AND A.CITY_ID=? AND B.IS_DISPLAY=0 ORDER BY B.SHOP_ID DESC");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(2, 1, Environment.getShopCityId()));
    dba.setParam(new SQLParam(1, 1, type_id_two));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public List getNextShop(int shop_id) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new ShopCenterFull();
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT A.SHOP_ID, a.CITY_ID, a.TYPE_ID, SHOP_NAME, ADDRESS, WEBADDRESS, ROUTE, PARK, TELEPHONE, LOGO_PIC, FIGURE_PIC, MAP_PIC, INTRODUCTION, IS_DISPLAY, IS_RECOMMEND, DETAIL FROM SHOPCENTER A ,( SELECT TYPE_ID FROM SHOPCENTER WHERE SHOP_ID=?) B WHERE A.TYPE_ID=B.TYPE_ID AND A.SHOP_ID!=? AND A.is_display=0 ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, shop_id));
    dba.setParam(new SQLParam(2, 1, shop_id));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public List getTypeIDOne() {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new ShopCenterFull();
    StringBuffer sql = new StringBuffer();
    sql.append(" select a.SHOP_ID, a.CITY_ID, b.TYPE_ID, SHOP_NAME, ADDRESS, WEBADDRESS, ROUTE, PARK, TELEPHONE, LOGO_PIC, FIGURE_PIC, MAP_PIC, INTRODUCTION, IS_DISPLAY, IS_RECOMMEND, DETAIL ,b.type_name_one,b.type_id_one from shopcenter a,region_type b where a.type_id=b.type_id  and a.city_id=b.city_id and a.city_id=? and a.is_display=0 order by b.type_id_one desc,a.shop_id desc  ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, Environment.getShopCityId()));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  private static List regionShop = null;
  private static long lasttime = System.currentTimeMillis();
}
