package com.ding9.search.searcher.product;

import com.ding9.search.entity.product.ProductMaster;
import com.ding9.search.searcher.AbstractSearcher;
import com.ding9.search.searcher.SearcherSingleton;
import com.ding9.search.searcher.support.document.DocumentExtractor;
import com.ding9.search.util.Environment;
import com.ding9.search.util.Pagination;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;



public class ProductMasterSearcher
  extends AbstractSearcher
{
  private static final Log log = LogFactory.getLog(ProductMasterSearcher.class);
  public static ProductMasterSearcher productMasterSearch;
  
  public static ProductMasterSearcher getInstance() { if (productMasterSearch == null) {
      productMasterSearch = new ProductMasterSearcher(Environment.getProductMasterMain_Index_Dir());
    }
    
    return productMasterSearch;
  }
  


  public ProductMasterSearcher() {}
  


  private ProductMasterSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  
  protected Object extract(Document doc) {
    return DocumentExtractor.getProductMaster(doc);
  }
  
  public Pagination searchabs(Query query, Filter filter, int topNum, Sort sort, int order_type, String type, float minprice, int sortsize, String path)
  {
    IndexSearcher mySearcher = SearcherSingleton.getIndexSearcherByPath(Environment.getProductMasterMain_Index_Dir());
    Pagination pagination = null;
    int tmpsortsize = sortsize;
    sortsize = type.equals("diffPrmaidbrand") ? 20 : sortsize;
    
    if (mySearcher != null) {
      try {
        Hits hits = mySearcher.search(query, sort);
        long pretime = System.currentTimeMillis();
        System.out.println("productmasteresearch begin search");
        
        System.out.println("search type = " + type);
        System.out.println("cost time is ==========" + (System.currentTimeMillis() - pretime));
        int docIndex = 0;
        List records = new ArrayList();
        float value = 0.0F;
        
        int recordLength = 0;
        if (hits.length() > 200) {
          recordLength = 200;
        } else {
          recordLength = hits.length();
        }
        for (int i = 1; i <= recordLength; i++) {
          if (order_type == 1) {
            docIndex = i - 1;
          } else {
            docIndex = hits.length() - i;
          }
          

          Object object = extract(hits.doc(docIndex));
          
          ProductMaster pm = (ProductMaster)object;
          if (pm.getMin_price() > minprice) {
            pm.setAbs_price(pm.getMin_price() - minprice);
          } else {
            pm.setAbs_price(minprice - pm.getMin_price());
          }
          object = pm;
          records.add(object);
        }
        

























        if ((type.equals("diffPrmaidbrand")) || (type.equals("samePrmaidbrand"))) {
          records = records.size() > tmpsortsize ? records.subList(0, tmpsortsize) : records;
        }
        tmpsortsize = tmpsortsize > records.size() ? records.size() : tmpsortsize;
        pagination = new Pagination(records, 1, tmpsortsize, tmpsortsize);
      }
      catch (Exception e) {
        if (log.isErrorEnabled()) {
          e.printStackTrace();
          log.error("fail at search query:" + 
            e.getLocalizedMessage());
        }
        try
        {
          if (!path.startsWith(Environment.getProductParaSort_Index_Dir())) {
            path.equals(Environment.getCommentMain_Index_Dir());
          }
        }
        catch (Exception e1) {
          if (!log.isErrorEnabled()) {}
        }
      }
      finally
      {
        try
        {
          if (!path.startsWith(Environment.getProductParaSort_Index_Dir())) {
            path.equals(Environment.getCommentMain_Index_Dir());
          }
        }
        catch (Exception e) {
          if (log.isErrorEnabled()) {
            log.error("fail at close index searcher after search:" + 
              e.getLocalizedMessage());
          }
        }
      }
    }
    return pagination;
  }
}
