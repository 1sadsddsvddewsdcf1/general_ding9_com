package com.ding9.dao.search;

import com.ding9.dao.product.ProductDao;
import com.ding9.dao.product.ProductDaoImpl;
import com.ding9.entity.product.RebuildPic;
import com.ding9.result.result.ProductBrand;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.PagedList;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;












public class ProductMasterPicCommentDaoImpl
  implements ProductMasterPicCommentDao
{
  private static Log log = LogFactory.getLog(ProductMasterPicCommentDaoImpl.class);
  








  public List getRelationProductBrand(int prso_id_one, ArrayList keyword, float mepr_price_start, float mepr_price_end)
    throws SQLException
  {
    List result = null;
    StringBuffer sql = new StringBuffer();
    IDBAccess dba = null;
    BaseResult index = new ProductBrand();
    int cnt = 1;
    try {
      if ((keyword != null) && (keyword.size() > 0)) {
        dba = new DBAccessDefaultlImpl();
        sql
          .append(" SELECT COUNT(WORDS.PRMA_ID) PRODUCT_COUNT,PRODUCT_SORT.PRSO_ID_ONE,");
        sql
          .append(" PRODUCT_SORT.PRSO_ID_THREE,PRODUCT_SORT.PRSO_NAME_THREE FROM ");
        sql
          .append(" (  SELECT PRODUCT_MASTER.PRMA_ID,PRODUCT_MASTER.PRSO_ID,COUNT(SEG_DIC_PRODUCT_WORDRELATION.PRMA_ID) WORDTIMES FROM PRODUCT_MASTER INNER JOIN SEG_DIC_PRODUCT_WORDRELATION ON PRODUCT_MASTER.PRMA_ID = SEG_DIC_PRODUCT_WORDRELATION.PRMA_ID AND  PRODUCT_MASTER.MERCHANT_COUNT>0 ");
        
        if (mepr_price_start > 0.0F) {
          sql.append(" AND PRODUCT_MASTER.MIN_PRICE>=? ");
          dba.setParam(new SQLParam(cnt, 4, 
            mepr_price_start));
          cnt++;
        }
        if (mepr_price_end > 0.0F) {
          sql.append(" AND PRODUCT_MASTER.MIN_PRICE<=? ");
          dba.setParam(new SQLParam(cnt, 4, 
            mepr_price_end));
          cnt++;
        }
        if (keyword != null) {
          for (int i = 0; i < keyword.size(); i++) {
            if (i == 0) {
              sql.append(" WHERE  DIC_WORD=? ");
            } else {
              sql.append(" OR DIC_WORD=? ");
            }
            dba.setParam(new SQLParam(cnt + i, 
              5, keyword.get(i)));
          }
        }
        
        sql.append(" GROUP BY PRODUCT_MASTER.PRMA_ID,PRODUCT_MASTER.PRSO_ID");
        if (keyword != null) {
          sql.append(" HAVING COUNT(SEG_DIC_PRODUCT_WORDRELATION.PRMA_ID)>=? ");
          int size = keyword.size();
          dba.setParam(new SQLParam(cnt + size, 
            1, size));
          cnt = cnt + size + 1;
        }
        sql.append(" ORDER BY wordtimes DESC \t)words ");
        sql
          .append(" INNER JOIN product_sort ON words.prso_id = product_sort.prso_id WHERE product_sort.prso_name_three is not null ");
        if (prso_id_one > 0) {
          sql.append(" AND product_sort.prso_id_one=? ");
          dba.setParam(new SQLParam(cnt, 1, 
            prso_id_one));
        } else if (prso_id_one == 0)
        {
          sql.append(" and product_sort.prso_id_one in (1,4,6,8,7,12,15) ");
        }
        
        sql.append(" GROUP BY product_sort.prso_id_one,product_sort.prso_id_three,\tproduct_sort.prso_name_three ORDER BY product_count DESC");
        if (log.isWarnEnabled()) {
          log.warn(sql);
        }
        result = dba.queryData(sql.toString(), index);
      }
    } catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getRelationProductBrand");
        log.debug(sql);
        log.debug(ex.getMessage());
      }
    }
    index = null;
    sql = null;
    return result;
  }
  









  public List getProductMaster(int prbr_id, int prso_id_three, ArrayList keyword, float mepr_price_start, float mepr_price_end, int current_page, int size, int order_asc_desc, int prso_id_one)
    throws SQLException
  {
    List result = null;
    StringBuffer sql = new StringBuffer();
    IDBAccess dba = null;
    BaseResult index = new com.ding9.result.product.ProductMaster();
    PagedList pagedList = new PagedList();
    int count = 0;
    try
    {
      dba = new DBAccessDefaultlImpl();
      
      if ((keyword != null) && (keyword.size() > 0))
      {
        int i = 1;
        sql.append("SELECT  0 AS forestall,M.prbr_id,M.prma_id, M.prma_name, M.prma_remark,M.prso_id, M.min_price,M.merchant_count,M.comment_count,M.product_level from ");
        sql.append(" (select M.prma_id,count(D.Prma_Id)  FROM product_master M INNER JOIN seg_dic_product_wordrelation D ON M.prma_id = D.prma_id where  M.merchant_count > 0 ");
        
        sql.append(" AND ( ");
        
        for (int j = 0; j < keyword.size(); j++) {
          if (j > 0)
            sql.append(" OR ");
          sql.append(" Dic_word='" + keyword.get(j) + "' ");
        }
        sql.append("\t) ");
        sql.append(" GROUP BY M.prma_id ");
        sql.append(" HAVING count(D.Prma_Id) >= " + keyword.size()).append(") seg,product_master M, product_sort psort where seg.prma_id=M.prma_id and psort.prso_id = M.prso_id ");
        
        if (prso_id_three > 0) {
          sql.append(" and M.prso_id=? ");
          dba.setParam(new SQLParam(i, 1, 
            prso_id_three));
          i++;
        }
        
        if (prso_id_one > 0)
        {
          sql.append(" AND psort.prso_id_one = ? ");
          dba.setParam(new SQLParam(i, 1, 
            prso_id_one));
          i++;
        }
        

        if (prbr_id > 0) {
          sql.append(" AND M.prbr_id = ? ");
          dba.setParam(new SQLParam(i, 1, 
            prbr_id));
          i++;
        }
        
        if (mepr_price_start > 0.0F) {
          sql.append(" AND M.min_price>=? ");
          dba.setParam(new SQLParam(i, 4, 
            mepr_price_start));
          i++;
        }
        if (mepr_price_end > 0.0F) {
          sql.append(" AND M.min_price<=? ");
          dba.setParam(new SQLParam(i, 4, 
            mepr_price_end));
          i++;
        }
        
        switch (order_asc_desc) {
        case 2: 
          sql.append(" ORDER BY M.min_price DESC ");
          break;
        case 1: 
          sql.append(" ORDER BY M.min_price ASC ");
          break;
        case 3: 
          sql.append(" ORDER BY M.comment_count DESC");
          break;
        case 4: 
          sql.append(" ORDER BY M.comment_count ASC");
          break;
        case 5: 
          sql.append(" ORDER BY M.merchant_count DESC");
          break;
        case 6: 
          sql.append(" ORDER BY M.merchant_count ASC");
          break;
        default: 
          sql.append(" ORDER BY M.prma_id ASC");
        }
        
        if (log.isWarnEnabled()) {
          log.warn("\n 有分词 : \n" + sql);
        }
        result = dba.queryDataPagination(sql.toString(), index, size, 
          current_page);
        pagedList.addAll(result);
        
        count = ((PagedList)result).getRecordcount();
      } else {
        List temp = null;
        if ((prbr_id == 0) && (mepr_price_start <= 0.0F) && 
          (mepr_price_end <= 0.0F) && (current_page == 1) && 
          (order_asc_desc == 0))
        {

          sql.append("SELECT ");
          sql.append("\t1 AS forestall,");
          sql.append("\tM.prma_name,");
          sql.append("\tM.prma_id,");
          sql.append("\tM.prso_id,");
          sql.append("\tM.prbr_id,");
          sql.append("\tM.prma_remark,");
          sql.append("\tM.min_price,");
          sql
            .append("\tM.merchant_count,M.comment_count,M.product_level ");
          sql.append("FROM ");
          sql.append("\tproduct_master M,");
          sql.append("\tmerchant_product P,");
          sql.append("\tproduct_sort C ");
          sql.append("WHERE M.prso_id=C.prso_id ");
          sql.append(" AND M.merchant_count>0 ");
          if (prso_id_three > 0) {
            sql.append(" AND M.prso_id='" + prso_id_three + "' ");
            sql.append(" AND P.prso_id='" + prso_id_three + "' ");
          }
          if (prso_id_one > 0)
            sql.append(" AND C.prso_id_one='" + prso_id_one + "' ");
          sql.append(" AND M.prma_forestall!=0 ");
          if (prbr_id > 0)
            sql.append(" AND M.prbr_id='" + prbr_id + "' ");
          sql.append("AND M.prma_id=P.prma_id ");
          sql.append("AND P.mepr_forestall!=0 ");
          sql.append("AND P.mepr_yn=1 ");
          sql.append("AND P.sys_yn=1 ");
          sql.append("AND P.mepr_price is not null ");
          sql.append("AND P.mepr_price!=0 ");
          
          sql.append("ORDER BY M.prma_forestall ASC");
          
          if (log.isWarnEnabled()) {
            log.warn("\n 买断位 : \n" + sql);
          }
          temp = dba.queryData(sql.toString(), index);
          if ((temp != null) && (temp.size() > 0))
          {
            count = ((PagedList)temp).getRecordcount();
            pagedList.addAll(temp);
            
            if (result == null)
              result = new ArrayList();
            result.addAll(temp);
          }
        }
        

        sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("0 AS forestall,B.prso_id,");
        sql
          .append("B.prma_name,B.merchant_count,B.comment_count,B.product_level,B.prma_id, B.prbr_id, B.min_price, B.prma_remark ");
        sql.append("FROM product_master B,product_sort D ");
        sql.append("WHERE ");
        sql.append("\tB.prso_id=D.prso_id_three ");
        sql.append("\tAND B.merchant_count>0 ");
        if (prbr_id > 0)
          sql.append("AND B.prbr_id='" + prbr_id + "' ");
        sql.append("\tAND B.prma_forestall =0 ");
        if (prso_id_three > 0)
          sql.append("AND B.prso_id = '" + prso_id_three + "' ");
        if (prso_id_one > 0)
          sql.append("AND D.prso_id_one = '" + prso_id_one + "' ");
        if (mepr_price_start > 0.0F)
          sql.append("AND B.min_price>='" + mepr_price_start + "' ");
        if (mepr_price_end > 0.0F) {
          sql.append("AND B.min_price<='" + mepr_price_end + "' ");
        }
        
        switch (order_asc_desc) {
        case 2: 
          sql.append(" ORDER BY B.min_price DESC ");
          break;
        case 1: 
          sql.append(" ORDER BY B.min_price ASC ");
          break;
        case 3: 
          sql.append(" ORDER BY B.comment_count DESC ");
          break;
        case 4: 
          sql.append(" ORDER BY B.comment_count ASC ");
          break;
        case 5: 
          sql.append(" ORDER BY B.merchant_count DESC ");
          break;
        case 6: 
          sql.append(" ORDER BY B.merchant_count ASC ");
          break;
        default: 
          sql.append(" ORDER BY B.prma_id ASC");
        }
        
        if (log.isWarnEnabled()) {
          log.warn("\n 正常的 : \n" + sql);
        }
        if (result != null) {
          size -= result.size();
        }
        dba = new DBAccessDefaultlImpl();
        
        temp = dba.queryDataPagination(sql.toString(), index, size, 
          current_page);
        
        if ((temp != null) && (temp.size() > 0))
        {
          count = ((PagedList)temp).getRecordcount() + count;
          pagedList.addAll(temp);
          
          if (result == null)
            result = new ArrayList();
          result.addAll(temp);
        }
      }
      if (result != null) {
        for (int i = 0; i < result.size(); i++) {
          com.ding9.entity.product.ProductMaster productMaster = (com.ding9.entity.product.ProductMaster)result
            .get(i);
          List resultPic = null;
          
          ProductDao pro = new ProductDaoImpl();
          resultPic = pro
            .getRebuildPic(productMaster.getPrma_id(), 1);
          if ((resultPic != null) && (resultPic.size() > 0)) {
            RebuildPic pic = (RebuildPic)resultPic.get(0);
            productMaster.setPicture_address(" src=" + 
              Environment.getImageServer() + 
              pic.getLocal_address());
          } else {
            resultPic = getProductPic(productMaster.getPrma_id());
            if ((resultPic != null) && (resultPic.size() > 0)) {
              com.ding9.entity.search.ProductPic productPic = (com.ding9.entity.search.ProductPic)resultPic
                .get(0);
              if ((productPic.getWeb_address() != null) && 
                (!"".equals(productPic.getWeb_address()))) {
                productMaster.setPicture_address(" src=" + 
                  Environment.getImageServer() + 
                  productPic.getWeb_address() + 
                  " width=80 height=80 ");
              } else {
                productMaster.setPicture_address(" src=" + 
                  Environment.getTempProductPicture() + 
                  " width=80 height=80 ");
              }
            } else {
              productMaster.setPicture_address(" src=" + 
                Environment.getTempProductPicture() + 
                " width=80 height=80 ");
            }
          }
          result.set(i, productMaster);
        }
      }
      pagedList.setRecordcount(count);
    } catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getProductMaster");
        log.debug(sql);
        log.debug(ex.getMessage());
      }
    }
    index = null;
    sql = null;
    return pagedList;
  }
  







  public List getProductPic(int prma_id)
    throws SQLException
  {
    List result = null;
    String sql = null;
    IDBAccess dba = null;
    
    BaseResult index = new com.ding9.result.search.ProductPic();
    try {
      dba = new DBAccessDefaultlImpl();
      dba.setParam(new SQLParam(1, 1, prma_id));
      sql = "SELECT prac_address,web_address FROM product_pic WHERE prma_id=? ORDER BY web_address DESC,prac_address DESC";
      result = dba.queryData(sql, index);
    } catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getProductPic");
        log.debug(sql);
        log.debug(ex.getMessage());
      }
    }
    sql = null;
    return result;
  }
}
