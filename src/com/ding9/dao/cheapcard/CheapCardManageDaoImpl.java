package com.ding9.dao.cheapcard;

import com.ding9.entity.cheapcard.CheapCard;
import com.ding9.result.cheapcard.CheapCardInfo;
import com.ding9.result.cheapcard.CheapCardSort;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.util.List;

public class CheapCardManageDaoImpl implements CheapCardManageDao
{
  private IDBAccess dba = null;
  







  public List getRecommendCheapCard(int sort_id, int cnt)
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult map = new CheapCardInfo();
    StringBuffer sql = new StringBuffer();
    if (sort_id == 2) {
      sql.append("SELECT   B.CHCA_ID, B.MERC_ID, B.PRSO_ID_ONE, B.CHCA_PIC, B.CHCA_TITLE,");
      sql.append("B.CHCA_REMARK, B.END_TIME, B.CHCA_URL, B.CHCA_TIME, B.CHCA_YN,");
      sql.append("B.USEFUL_LIFE, B.SORT_ID, B.STORE_NAME, B.MARKETPLACE, B.SOWNTOWN,B.INFO_SOURCE, C.PRSO_NAME_ONE, C.PRSO_NAME_ONE_EN");
      sql.append(" FROM CHEAPCARD_RECOMMEND_RELINFO A, CHEAPCARD B, PRODUCT_SORT C");
      sql.append(" WHERE  B.PRSO_ID_ONE = C.PRSO_ID  AND A.CHCA_ID = B.CHCA_ID AND END_TIME >= SYSDATE  AND INFO_STATUS = 1");
      sql.append(" AND A.SORT_ID = ? ORDER BY B.CHCA_ID DESC");
    } else {
      sql.append("SELECT   B.CHCA_ID, B.MERC_ID, B.PRSO_ID_ONE, B.CHCA_PIC, B.CHCA_TITLE,");
      sql.append("B.CHCA_REMARK, B.END_TIME, B.CHCA_URL, B.CHCA_TIME, B.CHCA_YN,");
      sql.append("B.USEFUL_LIFE, B.SORT_ID, B.STORE_NAME, B.MARKETPLACE, B.SOWNTOWN,B.INFO_SOURCE");
      sql.append(" FROM CHEAPCARD B, CHEAPCARD_RECOMMEND_RELINFO  A WHERE  A.CHCA_ID=B.CHCA_ID AND END_TIME>=SYSDATE AND INFO_STATUS=1 AND A.SORT_ID=? ORDER BY B.CHCA_ID DESC");
    }
    this.dba.setParam(new SQLParam(1, 1, sort_id));
    
    List rec = this.dba.queryDataPagination(sql.toString(), map, cnt, 1);
    return rec;
  }
  










  public List getCheapCard(int sort_id, int pagenum, int pagesize)
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult map = new CheapCardInfo();
    StringBuffer sql = null;
    if (sort_id == 2) {
      sql = new StringBuffer(" select a.CHCA_ID, a.MERC_ID, a.PRSO_ID_ONE, a.CHCA_PIC, a.CHCA_TITLE,a.CHCA_REMARK, a.END_TIME, a.CHCA_URL, a.CHCA_TIME, a.CHCA_YN,");
      sql.append("a.USEFUL_LIFE, a.SORT_ID, a.STORE_NAME, a.MARKETPLACE, a.SOWNTOWN,a.INFO_SOURCE,b.sort_name,c.prso_name_one,replace(c.prso_name_one_en,' ','_') as prso_name_one_en ");
      sql.append("from cheapcard a ,cheapcard_sort b,product_sort c ");
      sql.append("where a.sort_id=b.sort_id and a.prso_id_one=c.prso_id and end_time>=sysdate and info_status=1 and a.sort_id=? ");
      sql.append("order by a.chca_id desc ");
    } else {
      sql = new StringBuffer(" select a.CHCA_ID, a.MERC_ID, a.PRSO_ID_ONE, a.CHCA_PIC, a.CHCA_TITLE,a.CHCA_REMARK, a.END_TIME, a.CHCA_URL, a.CHCA_TIME, a.CHCA_YN,");
      sql.append("a.USEFUL_LIFE, a.SORT_ID, a.STORE_NAME, a.MARKETPLACE, a.SOWNTOWN,a.INFO_SOURCE,b.sort_name from cheapcard a ,cheapcard_sort b where a.sort_id=b.sort_id and end_time>=sysdate and info_status=1 and a.sort_id=? order by a.chca_id desc ");
    }
    this.dba.setParam(new SQLParam(1, 1, sort_id));
    List rec = this.dba.queryDataPagination(sql.toString(), map, pagesize, pagenum);
    return rec;
  }
  




  public List getOtherCheapCard(int sort_id, int pagenum, int pagesize)
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult map = new CheapCardSort();
    String sql = "select sort_id,sort_name from cheapcard_sort where sort_id!=?";
    this.dba.setParam(new SQLParam(1, 1, sort_id));
    List sortid = this.dba.queryData(sql, map);
    CheapCardManageDao dao = new CheapCardManageDaoImpl();
    for (int i = 0; i < sortid.size(); i++) {
      CheapCard card = (CheapCard)sortid.get(i);
      card.setCheapcard(dao.getCheapCard(card.getSort_id(), pagenum, pagesize));
    }
    return sortid;
  }
  





  public List getLatestCheap(int order)
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult map = new CheapCardInfo();
    StringBuffer sql = new StringBuffer(" select CHCA_ID, MERC_ID, PRSO_ID_ONE, CHCA_PIC, CHCA_TITLE,CHCA_REMARK, END_TIME, CHCA_URL, CHCA_TIME, CHCA_YN,");
    sql.append("USEFUL_LIFE, SORT_ID, STORE_NAME, MARKETPLACE, SOWNTOWN,INFO_SOURCE ");
    sql.append(",decode(sign(PRSO_ID_ONE-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =PRSO_ID_ONE and rownum=1),''),'') as prso_name_one_en ");
    sql.append("from cheapcard where  end_time>=sysdate and info_status=1");
    
    if (order == 1) {
      sql.append(" order by chca_id desc ");
    } else if (order == 2) {
      sql.append(" order by end_time  ");
    }
    
    List rec = this.dba.queryDataPagination(sql.toString(), map, 6, 1);
    return rec;
  }
  


  public List getCheapcardDetail(int chca_id)
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult map = new CheapCardInfo();
    StringBuffer sql = new StringBuffer(" select a.CHCA_ID, a.MERC_ID, a.PRSO_ID_ONE, a.CHCA_PIC, a.CHCA_TITLE,a.CHCA_REMARK, a.END_TIME, a.CHCA_URL, a.CHCA_TIME, a.CHCA_YN,");
    sql.append("a.USEFUL_LIFE, a.SORT_ID, a.STORE_NAME, a.MARKETPLACE, a.SOWNTOWN,a.INFO_SOURCE,b.sort_name from cheapcard a ,cheapcard_sort b where a.sort_id=b.sort_id and end_time>=sysdate and info_status=1 and chca_id =? ");
    this.dba.setParam(new SQLParam(1, 1, chca_id));
    List rec = this.dba.queryData(sql.toString(), map);
    return rec;
  }
  




  public List getSimilarCheapcard(String marketPlace, int chca_id)
  {
    this.dba = new DBAccessDefaultlImpl();
    
    BaseResult map = new CheapCardInfo();
    StringBuffer sql = new StringBuffer(" select CHCA_ID, MERC_ID, PRSO_ID_ONE, CHCA_PIC, CHCA_TITLE,CHCA_REMARK, END_TIME, CHCA_URL, CHCA_TIME, CHCA_YN,");
    sql.append("USEFUL_LIFE, SORT_ID, STORE_NAME, MARKETPLACE, SOWNTOWN,INFO_SOURCE ");
    sql.append(",decode(sign(prso_id_one-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =prso_id_one and rownum=1),''),'') as prso_name_one_en ");
    sql.append("from cheapcard where marketplace=? and end_time>=sysdate and info_status=1 and chca_id!=? ");
    
    this.dba.setParam(new SQLParam(1, 5, marketPlace));
    this.dba.setParam(new SQLParam(2, 1, chca_id));
    
    List rec = this.dba.queryData(sql.toString(), map);
    return rec;
  }
  


  public List getRelatedCheapcard(int prso_id_one, int chca_id)
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult map = new CheapCardInfo();
    
    StringBuffer sql = new StringBuffer(" select CHCA_ID, MERC_ID, PRSO_ID_ONE, CHCA_PIC, CHCA_TITLE,CHCA_REMARK, END_TIME, CHCA_URL, CHCA_TIME, CHCA_YN,");
    sql.append("USEFUL_LIFE, SORT_ID, STORE_NAME, MARKETPLACE, SOWNTOWN,INFO_SOURCE ");
    sql.append(",decode(sign(prso_id_one-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =prso_id_one and rownum=1),''),'') as prso_name_one_en ");
    sql.append("from cheapcard where prso_id_one=? and end_time>=sysdate and info_status=1 and chca_id!=?  ");
    
    this.dba.setParam(new SQLParam(1, 1, prso_id_one));
    this.dba.setParam(new SQLParam(2, 1, chca_id));
    
    List rec = this.dba.queryData(sql.toString(), map);
    return rec;
  }
}
