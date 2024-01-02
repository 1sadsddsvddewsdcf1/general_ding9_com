package com.ding9.dao.common_salepromotion_info;

import com.ding9.entity.common_salepromotion_info.CommonSalepromotion;
import com.ding9.result.common_salepromotion_info.CommonSalepromotionInfo;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class CommonSalepromotionInfoDaoImpl
  implements CommonSalepromotionInfoDao
{
  private static final Log log = LogFactory.getLog(CommonSalepromotionInfoDaoImpl.class);
  
  private IDBAccess dba = null;
  
  private static HashMap hm = new HashMap();
  
  private static long pretime = System.currentTimeMillis();
  
  public List getCommonSalepromotionInfoSeven(int sort_id, int info_type, int info_status, int page_size) {
    List result = null;
    StringBuffer sql = new StringBuffer();
    
    CommonSalepromotionInfo idx = new CommonSalepromotionInfo();
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      

      sql.append("SELECT a.info_id,a.title ");
      sql.append(",a.prso_id_one");
      sql.append(",decode(sign(a.prso_id_one-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =a.prso_id_one and rownum=1),''),'') as prso_name_one_en ");
      sql.append("FROM common_salepromotion_info a ,salepromotion_relinfo b ");
      sql.append(" WHERE ");
      sql.append(" a.info_id=b.info_id ");
      
      sql.append(" AND a.out_date>=sysdate ");
      sql.append(" AND b.sort_id=" + sort_id + " ");
      if (info_type > -1) {
        sql.append("AND a.info_type=" + info_type + " ");
      }
      sql.append("AND a.info_status=" + info_status + " ");
      


      sql.append("ORDER BY a.info_id DESC ");
      

      if (log.isWarnEnabled()) {
        log.warn(sql);
      }
      result = this.dba.queryDataPagination(sql.toString(), idx, page_size, 1);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql);
      }
    }
    sql = null;
    idx = null;
    
    return result;
  }
  




  public List getCommonSalepromotionInfo(int sort_id, int info_id, int prso_id_one, int prso_id_two, int prso_id_three, String title, String brand_name, String store_name, String marketplace, String sowntown, int merc_id, int prma_id, String info_source, int info_type, int info_status, String orderby, int page_size, int current_page)
  {
    List result = null;
    StringBuffer sql = new StringBuffer();
    
    CommonSalepromotionInfo idx = new CommonSalepromotionInfo();
    
    title = title == null ? "" : title.trim();
    brand_name = brand_name == null ? "" : brand_name.trim();
    store_name = store_name == null ? "" : store_name.trim();
    marketplace = marketplace == null ? "" : marketplace.trim();
    sowntown = sowntown == null ? "" : sowntown.trim();
    info_source = info_source == null ? "" : info_source.trim();
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      

      sql.append("SELECT a.info_id, a.title ");
      sql.append(",a.prso_id_one");
      sql.append(",decode(sign(a.prso_id_one-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =a.prso_id_one and rownum=1),''),'') as prso_name_one_en ");
      sql.append(" FROM common_salepromotion_info a ,salepromotion_relinfo b ");
      sql.append(" WHERE a.info_id=b.info_id AND a.out_date>=sysdate ");
      if (!"".equals(title)) {
        sql.append(" AND a.title like '%" + title + "%' ");
      }
      if (!"".equals(brand_name)) {
        sql.append(" AND a.brand_name like '%" + brand_name + "%' ");
      }
      if (!"".equals(store_name)) {
        sql.append(" AND a.store_name like '%" + store_name + "%' ");
      }
      if (!"".equals(marketplace)) {
        sql.append(" AND a.marketplace like '%" + marketplace + "%' ");
      }
      if (!"".equals(sowntown)) {
        sql.append(" AND a.sowntown like '%" + sowntown + "%' ");
      }
      if (!"".equals(info_source)) {
        sql.append(" AND a.info_source like '%" + info_source + "%' ");
      }
      
      if (sort_id > 0) {
        sql.append("AND b.sort_id=" + sort_id + " ");
      }
      
      if (info_id > 0) {
        sql.append("AND a.info_id=" + info_id + " ");
        sql.append("AND b.info_id=" + info_id + " ");
      }
      
      if (prso_id_one > 0) {
        sql.append("AND a.prso_id_one=" + prso_id_one + " ");
      }
      if (prso_id_two > 0) {
        sql.append("AND a.prso_id_two=" + prso_id_two + " ");
      }
      if (prso_id_three > 0) {
        sql.append("AND a.prso_id_three=" + prso_id_three + " ");
      }
      if (merc_id > 0) {
        sql.append("AND a.merc_id=" + merc_id + " ");
      }
      if (prma_id > 0) {
        sql.append("AND a.prma_id=" + prma_id + " ");
      }
      
      if (info_type > -1) {
        sql.append("AND a.info_type=" + info_type + " ");
      }
      sql.append("AND a.info_status=" + info_status + " ");
      
      if (orderby.equals("")) {
        sql.append("ORDER BY a.info_id DESC");
      } else {
        sql.append("ORDER BY " + orderby);
      }
      
      if (log.isWarnEnabled()) {
        log.warn(sql);
      }
      
      result = this.dba.queryDataPagination(sql.toString(), idx, page_size, current_page);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql);
      }
    }
    sql = null;
    idx = null;
    
    return result;
  }
  
  public List getCommonSalepromotionInfoOne(int info_id) {
    List result = null;
    String sql = null;
    
    CommonSalepromotionInfo idx = new CommonSalepromotionInfo();
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      

      sql = "SELECT INFO_ID ";
      sql = sql + ", PRSO_ID_ONE ";
      sql = sql + ", SORT_ID ";
      sql = sql + ", TITLE ";
      sql = sql + ", CONTENT ";
      sql = sql + ", PUB_TIME ";
      sql = sql + ", MERC_ID ";
      sql = sql + ", PRMA_ID ";
      sql = sql + ", USEFUL_LIFE ";
      sql = sql + ", OUT_DATE ";
      sql = sql + ", COOPERATE_ID ";
      sql = sql + ", INFO_SOURCE ";
      sql = sql + ", SOURCE_URL ";
      sql = sql + ", INFO_TYPE ";
      sql = sql + ", INFO_STATUS ";
      sql = sql + ", REBATE_RANGE ";
      sql = sql + ", BRAND_NAME ";
      sql = sql + ", STORE_NAME ";
      sql = sql + ", MARKETPLACE ";
      sql = sql + ", PRSO_ID_TWO ";
      sql = sql + ", PRSO_ID_THREE ";
      sql = sql + ", PRSO_NAME ";
      sql = sql + ", SOWNTOWN ";
      sql = sql + ", PICTURE ";
      sql = sql + " FROM common_salepromotion_info  ";
      sql = sql + " WHERE ";
      
      sql = sql + " out_date>=sysdate ";
      sql = sql + " AND info_id=" + info_id + " ";
      
      result = this.dba.queryData(sql, idx);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql);
      }
    }
    sql = null;
    idx = null;
    
    return result;
  }
  
  public List getCommonSalepromotionInfo(int sort_id) {
    List result = null;
    String sql = null;
    
    com.ding9.result.common_salepromotion_info.CommonSalepromotionSort idx = new com.ding9.result.common_salepromotion_info.CommonSalepromotionSort();
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      

      sql = "SELECT sort_id, sort_name ";
      sql = sql + " FROM common_salepromotion_sort ";
      if (sort_id == 2)
        sql = sql + "WHERE sort_id=4 OR sort_id=5";
      if (sort_id == 4)
        sql = sql + "WHERE sort_id=2 OR sort_id=5";
      if (sort_id == 5) {
        sql = sql + "WHERE sort_id=2 OR sort_id=4";
      }
      if (log.isWarnEnabled()) {
        log.warn(sql);
      }
      
      result = this.dba.queryData(sql, idx);
      if ((result != null) && (result.size() > 0)) {
        for (int i = 0; i < result.size(); i++)
        {
          com.ding9.entity.common_salepromotion_info.CommonSalepromotionSort entity = (com.ding9.entity.common_salepromotion_info.CommonSalepromotionSort)result.get(i);
          entity.setCommon_salepromotion_info(
            getCommonSalepromotionInfo(entity.getSort_id(), 0, 0, 0, 0, "", "", "", "", "", 0, 0, "", -1, 1, "", 7, 1));
          
          if ((entity.getCommon_salepromotion_info() != null) && 
            (entity.getCommon_salepromotion_info().size() > 0)) {
            result.set(i, entity);
          } else {
            entity.setCommon_salepromotion_info(null);
            result.set(i, entity);
          }
        }
      }
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql);
      }
    }
    sql = null;
    idx = null;
    
    return result;
  }
  
  public List getCommonSalepromotionSort(int sort_id) {
    List result = null;
    String sql = null;
    
    com.ding9.result.common_salepromotion_info.CommonSalepromotionSort idx = new com.ding9.result.common_salepromotion_info.CommonSalepromotionSort();
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      

      sql = "SELECT sort_id, sort_name ";
      sql = sql + " FROM common_salepromotion_sort WHERE sort_id=" + 
        sort_id;
      result = this.dba.queryData(sql, idx);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql);
      }
    }
    sql = null;
    idx = null;
    
    return result;
  }
  
  public List getCommonSalepromotionInfo() {
    List result = null;
    String sql = null;
    
    if (hm != null) {
      result = (List)hm.get("getCommonSalepromotionInfo");
    }
    
    if ((result == null) || 
      (System.currentTimeMillis() - pretime > 1800000L)) {
      com.ding9.result.common_salepromotion_info.CommonSalepromotionSort idx = new com.ding9.result.common_salepromotion_info.CommonSalepromotionSort();
      try
      {
        this.dba = new DBAccessDefaultlImpl();
        

        sql = "SELECT sort_id, sort_name ";
        sql = sql + 
          " FROM common_salepromotion_sort WHERE sort_id=2 OR sort_id=4 OR sort_id=5";
        
        if (log.isWarnEnabled()) {
          log.warn(sql);
        }
        result = this.dba.queryData(sql, idx);
        
        if ((result != null) && (result.size() > 0)) {
          for (int i = 0; i < result.size(); i++)
          {
            com.ding9.entity.common_salepromotion_info.CommonSalepromotionSort entity = (com.ding9.entity.common_salepromotion_info.CommonSalepromotionSort)result
              .get(i);
            entity
              .setCommon_salepromotion_info(getCommonSalepromotionInfoSeven(
              entity.getSort_id(), -1, 1, 7));
            


            if ((entity.getCommon_salepromotion_info() != null) && 
              (entity.getCommon_salepromotion_info().size() > 0)) {
              result.set(i, entity);
            } else {
              entity.setCommon_salepromotion_info(null);
              result.set(i, entity);
            }
          }
        }
      }
      catch (Exception ex) {
        if (log.isErrorEnabled()) {
          log.error("出错信息 : " + ex.getMessage());
          log.error("执行语句 : " + sql);
        }
      }
      sql = null;
      idx = null;
      
      hm.put("getCommonSalepromotionInfo", result);
      pretime = System.currentTimeMillis();
    }
    
    return result;
  }
  
  public List getCommonSalepromotion(int info_id) {
    List result = null;
    List rs = null;
    try
    {
      result = getCommonSalepromotionInfoOne(info_id);
      


      if ((result != null) && (result.size() > 0)) {
        for (int i = 0; i < result.size(); i++) {
          CommonSalepromotion entity = (CommonSalepromotion)result
            .get(i);
          
          if (entity.getPrma_id() > 0) {
            rs = getProductMaster(entity.getPrma_id());
            if ((rs != null) && (rs.size() > 0)) {
              com.ding9.entity.common_salepromotion_info.ProductMaster productMaster = (com.ding9.entity.common_salepromotion_info.ProductMaster)rs
                .get(0);
              entity.setPrma_name(productMaster.getPrma_name());
            }
          }
          if (entity.getMerc_id() > 0) {
            rs = getMerchant(entity.getMerc_id());
            if ((rs != null) && (rs.size() > 0)) {
              com.ding9.entity.common_salepromotion_info.Merchant merchant = (com.ding9.entity.common_salepromotion_info.Merchant)rs.get(0);
              entity.setMerc_name(merchant.getMerc_name());
              entity.setMerc_address(merchant.getMerc_address());
            }
          }
          result.set(i, entity);
        }
      }
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
      }
    }
    
    return result;
  }
  
  private List getProductMaster(int prma_id) {
    List result = null;
    String sql = null;
    
    com.ding9.result.common_salepromotion_info.ProductMaster idx = new com.ding9.result.common_salepromotion_info.ProductMaster();
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      

      sql = "SELECT prma_name   FROM product_master WHERE prma_id=" + prma_id;
      result = this.dba.queryData(sql, idx);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql);
      }
    }
    sql = null;
    idx = null;
    
    return result;
  }
  
  private List getMerchant(int merc_id) {
    List result = null;
    String sql = null;
    
    com.ding9.result.common_salepromotion_info.Merchant idx = new com.ding9.result.common_salepromotion_info.Merchant();
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      
      sql = "SELECT merc_name,merc_address FROM merchant_baseinfo WHERE merc_id=" + merc_id;
      result = this.dba.queryData(sql, idx);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql);
      }
    }
    sql = null;
    idx = null;
    
    return result;
  }
}
