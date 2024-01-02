package com.ding9.dao.search;

import com.ding9.result.product.ProductSearchList;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.PagedList;
import com.ding9.sql.SQLParam;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;






public class ProductSearchBykey
{
  private static Log log = LogFactory.getLog(ProductSearchBykey.class);
  
  public List getProductMaster(int prbr_id, int prso_id_three, ArrayList keyword, float mepr_price_start, float mepr_price_end, int current_page, int size, int order_asc_desc, int prso_id_one) { StringBuffer sql = new StringBuffer();
    IDBAccess dba = null;
    BaseResult index = new ProductSearchList();
    PagedList pagedList = null;
    
    try
    {
      if ((keyword != null) && (keyword.size() > 0)) {
        dba = new DBAccessDefaultlImpl();
        
        int i = 1;
        sql.append("SELECT  M.PRBR_ID,M.PRMA_ID, M.PRMA_NAME, M.PRMA_REMARK,M.PRSO_ID,PSORT.PRSO_ID_ONE, M.MIN_PRICE,M.MERCHANT_COUNT,M.COMMENT_COUNT,M.PRODUCT_LEVEL FROM ");
        sql.append(" (SELECT M.PRMA_ID,COUNT(D.PRMA_ID)  FROM PRODUCT_MASTER M INNER JOIN SEG_DIC_PRODUCT_WORDRELATION D ON M.PRMA_ID = D.PRMA_ID WHERE  M.MERCHANT_COUNT > 0 ");
        
        sql.append(" AND ( ");
        
        for (int j = 0; j < keyword.size(); j++) {
          if (j > 0)
            sql.append(" OR ");
          sql.append(" DIC_WORD='" + keyword.get(j) + "' ");
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
        case 2:  sql.append(" ORDER BY M.min_price DESC "); break;
        case 1:  sql.append(" ORDER BY M.min_price ASC "); break;
        case 3:  sql.append(" ORDER BY M.comment_count DESC"); break;
        case 4:  sql.append(" ORDER BY M.comment_count ASC"); break;
        case 5:  sql.append(" ORDER BY M.merchant_count DESC"); break;
        case 6:  sql.append(" ORDER BY M.merchant_count ASC"); break;
        default:  sql.append(" ORDER BY M.prma_id ASC");
        }
        if (log.isWarnEnabled()) {
          log.warn(sql);
        }
        pagedList = (PagedList)dba.queryDataPagination(sql.toString(), index, size, current_page);
      }
    }
    catch (Exception ex)
    {
      if (log.isDebugEnabled()) {
        log.debug("getProductMaster");
        log.debug(sql);
        log.debug(ex.getMessage());
      }
      log.warn(ex.getMessage());
    }
    index = null;
    sql = null;
    return pagedList;
  }
}
