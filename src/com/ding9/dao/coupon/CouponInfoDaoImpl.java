package com.ding9.dao.coupon;

import com.ding9.result.common_salepromotion_info.CommonSalepromotionInfoList;
import com.ding9.result.common_salepromotion_info.CommonSalepromotionInfoType;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.util.List;



public class CouponInfoDaoImpl
  implements CouponInfoDao
{
  public List getCouponInfo(int shopid, int type_id)
  {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new CommonSalepromotionInfoList();
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT B.INFO_ID, B.PRSO_ID_ONE, B.SORT_ID, TITLE, CONTENT, PUB_TIME, MERC_ID, PRMA_ID, USEFUL_LIFE, OUT_DATE, COOPERATE_ID, INFO_SOURCE, SOURCE_URL, INFO_TYPE, INFO_STATUS, REBATE_RANGE, BRAND_NAME, STORE_NAME, MARKETPLACE, PRSO_ID_TWO, PRSO_ID_THREE, PRSO_NAME, SOWNTOWN, PICTURE");
    sql.append(" FROM COMMON_SALEPROMOTION_INFO B,COUPON_RELATION A WHERE  A.INFO_ID=B.INFO_ID AND B.INFO_STATUS=1 AND B.OUT_DATE>SYSDATE AND A.SHOP_ID=? AND A.TYPE_ID=?  ORDER BY A.INFO_ID DESC ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, shopid));
    dba.setParam(new SQLParam(2, 1, type_id));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public List getCouponInfoWith(int shopid) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new CommonSalepromotionInfoList();
    StringBuffer sql = new StringBuffer();
    sql.append("select B.INFO_ID, B.PRSO_ID_ONE, B.SORT_ID, TITLE, CONTENT, PUB_TIME, MERC_ID, PRMA_ID, USEFUL_LIFE, OUT_DATE, COOPERATE_ID, INFO_SOURCE, SOURCE_URL, INFO_TYPE, INFO_STATUS, REBATE_RANGE, BRAND_NAME, STORE_NAME, MARKETPLACE, PRSO_ID_TWO, PRSO_ID_THREE, PRSO_NAME, SOWNTOWN, PICTURE from coupon_relation a ,common_salepromotion_info b where a.SHOP_ID=?  and a.INFO_ID=b.INFO_ID and b.info_status=1 and b.out_date>sysdate order by a.info_id desc ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, shopid));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public List getPicCouponInfo(int shopid) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new CommonSalepromotionInfoList();
    StringBuffer sql = new StringBuffer();
    sql.append("select B.INFO_ID, B.PRSO_ID_ONE, B.SORT_ID, TITLE, CONTENT, PUB_TIME, MERC_ID, PRMA_ID, USEFUL_LIFE, OUT_DATE, COOPERATE_ID, INFO_SOURCE, SOURCE_URL, INFO_TYPE, INFO_STATUS, REBATE_RANGE, BRAND_NAME, STORE_NAME, MARKETPLACE, PRSO_ID_TWO, PRSO_ID_THREE, PRSO_NAME, SOWNTOWN, PICTURE from coupon_relation a ,common_salepromotion_info b where a.SHOP_ID=?  and a.INFO_ID=b.INFO_ID and b.info_type=2 and b.info_status=1 and b.out_date>sysdate order by a.info_id desc  ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, shopid));
    result = dba.queryDataPagination(sql.toString(), index, 2, 1);
    return result;
  }
  
  public List getPicCouponInfo() {
    if ((picCoupon == null) || (System.currentTimeMillis() - lasttime2 > 3600000L)) {
      IDBAccess dba = null;
      BaseResult index = new CommonSalepromotionInfoList();
      StringBuffer sql = new StringBuffer();
      sql.append("select a.shop_id, B.INFO_ID, B.PRSO_ID_ONE, B.SORT_ID, TITLE, CONTENT, PUB_TIME, MERC_ID, PRMA_ID, USEFUL_LIFE, OUT_DATE, COOPERATE_ID, INFO_SOURCE, SOURCE_URL, INFO_TYPE, INFO_STATUS, REBATE_RANGE, BRAND_NAME, STORE_NAME, MARKETPLACE, PRSO_ID_TWO, PRSO_ID_THREE, PRSO_NAME, SOWNTOWN, PICTURE from coupon_relation a ,common_salepromotion_info b where  a.INFO_ID=b.INFO_ID and b.info_type=2 and b.info_status=1 and b.out_date>sysdate and a.shop_id not in(select shop_id from shopcenter where is_recommend!=0 or is_display=1) order by a.info_id desc  ");
      dba = new DBAccessDefaultlImpl();
      picCoupon = dba.queryDataPagination(sql.toString(), index, 2, 1);
      lasttime2 = System.currentTimeMillis();
    }
    return picCoupon;
  }
  
  public List getCouponInfo(int type_id) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new CommonSalepromotionInfoList();
    StringBuffer sql = new StringBuffer();
    sql.append("select B.INFO_ID, B.PRSO_ID_ONE, B.SORT_ID, TITLE, CONTENT, PUB_TIME, MERC_ID, PRMA_ID, USEFUL_LIFE, OUT_DATE, COOPERATE_ID, INFO_SOURCE, SOURCE_URL, INFO_TYPE, INFO_STATUS, REBATE_RANGE, BRAND_NAME, STORE_NAME, MARKETPLACE, PRSO_ID_TWO, PRSO_ID_THREE, PRSO_NAME, SOWNTOWN, PICTURE from coupon_relation a ,common_salepromotion_info b where  a.TYPE_ID=? and a.INFO_ID=b.INFO_ID and b.info_status=1 and b.out_date>sysdate order by a.info_id desc ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, type_id));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public List getCouponDetail(int infoid) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new CommonSalepromotionInfoList();
    StringBuffer sql = new StringBuffer();
    sql.append("select INFO_ID, PRSO_ID_ONE, SORT_ID, TITLE, CONTENT, PUB_TIME, MERC_ID, PRMA_ID, USEFUL_LIFE, OUT_DATE, COOPERATE_ID, INFO_SOURCE, SOURCE_URL, INFO_TYPE, INFO_STATUS, REBATE_RANGE, BRAND_NAME, STORE_NAME, MARKETPLACE, PRSO_ID_TWO, PRSO_ID_THREE, PRSO_NAME, SOWNTOWN, PICTURE from common_salepromotion_info  where INFO_ID=? and  info_status=1 and out_date>sysdate ");
    dba = new DBAccessDefaultlImpl();
    dba.setParam(new SQLParam(1, 1, infoid));
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public List getReommendCouponInfo(String shop_id) {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new CommonSalepromotionInfoList();
    StringBuffer sql = new StringBuffer();
    sql.append("select a.shop_id, B.INFO_ID, B.PRSO_ID_ONE, B.SORT_ID, TITLE, CONTENT, PUB_TIME, MERC_ID, PRMA_ID, USEFUL_LIFE, OUT_DATE, COOPERATE_ID, INFO_SOURCE, SOURCE_URL, INFO_TYPE, INFO_STATUS, REBATE_RANGE, BRAND_NAME, STORE_NAME, MARKETPLACE, PRSO_ID_TWO, PRSO_ID_THREE, PRSO_NAME, SOWNTOWN, PICTURE from coupon_relation a ,common_salepromotion_info b where a.shop_id in (").append(shop_id).append(") and  a.INFO_ID=b.INFO_ID and b.info_status=1 and b.out_date>sysdate order by a.info_id desc ");
    dba = new DBAccessDefaultlImpl();
    result = dba.queryData(sql.toString(), index);
    return result;
  }
  
  public List getOtherCouponInfo() {
    if ((otherCoupon == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      IDBAccess dba = null;
      BaseResult index = new CommonSalepromotionInfoType();
      dba = new DBAccessDefaultlImpl();
      StringBuffer sql = new StringBuffer();
      sql.append("SELECT   '[' || C.COUPON_NAME || ']' || B.TITLE AS TITLE, A.TYPE_ID, A.SHOP_ID, B.INFO_ID, B.PRSO_ID_ONE, B.SORT_ID, TITLE, CONTENT, PUB_TIME, MERC_ID, PRMA_ID, USEFUL_LIFE, OUT_DATE, COOPERATE_ID, INFO_SOURCE, SOURCE_URL, INFO_TYPE, INFO_STATUS, REBATE_RANGE, BRAND_NAME, STORE_NAME, MARKETPLACE, PRSO_ID_TWO, PRSO_ID_THREE, PRSO_NAME, SOWNTOWN, PICTURE");
      sql.append(" FROM  COMMON_SALEPROMOTION_INFO B, COUPON_TYPE C,COUPON_RELATION A");
      sql.append(" WHERE A.INFO_ID = B.INFO_ID AND A.TYPE_ID = C.TYPE_ID  AND A.SHOP_ID = C.SHOP_ID");
      sql.append(" AND B.OUT_DATE > SYSDATE   AND B.INFO_STATUS = 1");
      sql.append(" AND  NOT EXISTS (SELECT 'a' FROM SHOPCENTER WHERE (IS_RECOMMEND != 0 or is_display=1) AND SHOPCENTER.SHOP_ID=A.SHOP_ID)");
      sql.append(" ORDER BY A.INFO_ID DESC");
      otherCoupon = dba.queryData(sql.toString(), index);
      lasttime = System.currentTimeMillis();
    }
    return otherCoupon;
  }
  
  private static List otherCoupon = null;
  private static long lasttime = System.currentTimeMillis();
  private static List picCoupon = null;
  private static long lasttime2 = System.currentTimeMillis();
}
