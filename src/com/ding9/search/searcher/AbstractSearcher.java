package com.ding9.search.searcher;

import com.ding9.search.entity.assistant.Counter;
import com.ding9.search.searcher.support.CounterBuilder;
import com.ding9.search.util.Environment;
import com.ding9.search.util.PageParam;
import com.ding9.search.util.Pagination;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.FieldDoc;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopFieldDocs;

public abstract class AbstractSearcher
  implements Searcher
{
  private static final Log log = LogFactory.getLog(AbstractSearcher.class);
  

  private String indexPath;
  
  public static IndexSearcher mySearcher;
  

  public Pagination search(Query query, Filter filter, int topNum, PageParam pageParam, int order_type, String path)
  {
    return search(query, filter, topNum, pageParam, null, order_type, path);
  }
  


  public Pagination searchabs(Query query, Filter filter, int topNum, Sort sort, int order_type, String type, float minprice, int sortsize, String path)
  {
    return null;
  }
  

  public Pagination search(Query query, Filter filter, int topNum, PageParam pageParam, Sort sort, int order_type, String path)
  {
    log.warn("abstract Searcher begin search");
    IndexSearcher mySearcher = 
      SearcherSingleton.getIndexSearcherByPath(path);
    Pagination pagination = null;
    Hits hits = null;
    List records = null;
    
    if (mySearcher != null) {
      try {
        if (sort == null) {
          sort = new Sort();
        }
        
        hits = mySearcher.search(query, filter, sort);
        
        int start = pageParam.getStartRecord();
        int end = pageParam.getEndRecord();
        if (end > hits.length()) {
          end = hits.length();
        }
        








        int docIndex = 0;
        records = new ArrayList();
        
        for (int i = start; i <= end; i++) {
          if (order_type == 1) {
            docIndex = i - 1;
          } else {
            docIndex = hits.length() - i;
          }
          



          Object object = extract(hits.doc(docIndex));
          records.add(object);
        }
        log.warn("records.size()=========" + records.size());
        pagination = new Pagination(records, pageParam.getStart(), 
          pageParam.getSize(), hits.length());
        
        int tmp = 30000 / pageParam.getSize();
        if (pagination.getTotalPage() * pagination.getPageSize() > 30000) {
          pagination.setTotalPage(tmp);
        }
      } catch (Exception e) {
        if (log.isErrorEnabled()) {
          e.printStackTrace();
          log.error("fail at search query:" + e.getLocalizedMessage());
        }
        try
        {
          records = null;
          if (!path.startsWith(
            Environment.getProductParaSort_Index_Dir())) {
            path.equals(
              Environment.getCommentMain_Index_Dir());
          }
        }
        catch (Exception e1)
        {
          if (!log.isErrorEnabled()) {}
        }
      }
      finally
      {
        try
        {
          records = null;
          if (!path.startsWith(
            Environment.getProductParaSort_Index_Dir())) {
            path.equals(
              Environment.getCommentMain_Index_Dir());
          }
        }
        catch (Exception e)
        {
          if (log.isErrorEnabled()) {
            log.error("fail at close index searcher after search:" + 
              e.getLocalizedMessage());
          }
        }
      }
    }
    
    return pagination;
  }
  









  public Counter[] getCounts(Query query, Filter filter, int topNum, Sort sort, String path)
  {
    Counter[] counters = (Counter[])null;
    int sortsize = 0;
    
    if (sort == null) {
      return counters;
    }
    
    sortsize = sort.getSort().length;
    if (sortsize < 1) {
      return counters;
    }
    
    HashMap hmcount = new HashMap();
    HashMap hmextendvalueone = new HashMap();
    HashMap hmextendvaluetwo = new HashMap();
    HashMap hmextendvaluethree = new HashMap();
    HashMap hmextendvaluefour = new HashMap();
    IndexSearcher mySearcher = SearcherSingleton.getIndexSearcherByPath(path);
    try
    {
      if (mySearcher != null) {
        TopFieldDocs docs = mySearcher.search(query, filter, topNum, 
          sort);
        
        for (int i = 0; i < docs.scoreDocs.length; i++) {
          FieldDoc fieldDoc = (FieldDoc)docs.scoreDocs[i];
          Document document = mySearcher.doc(fieldDoc.doc);
          
          for (int j = 0; j < fieldDoc.fields.length; j++)
          {
            String sortValue = document.get(
              docs.fields[j].getField()).toUpperCase();
            String id = sortValue;
            
            hmcount = CounterBuilder.setCounter(hmcount, sortValue);
            
            if (sortsize > 1) {
              j++;
              if (!hmextendvalueone.containsKey(id)) {
                try {
                  sortValue = 
                  
                    document.get(docs.fields[j].getField()).toUpperCase();
                  hmextendvalueone.put(id, sortValue);
                }
                catch (Exception localException1) {}
              }
            }
            

            if (sortsize > 2) {
              j++;
              if (!hmextendvaluetwo.containsKey(id)) {
                try {
                  sortValue = 
                  
                    document.get(docs.fields[j].getField()).toUpperCase();
                  hmextendvaluetwo.put(id, sortValue);
                }
                catch (Exception localException2) {}
              }
            }
            

            if (sortsize > 3) {
              j++;
              if (!hmextendvaluethree.containsKey(id)) {
                try {
                  sortValue = 
                  
                    document.get(docs.fields[j].getField()).toUpperCase();
                  hmextendvaluethree.put(id, sortValue);
                }
                catch (Exception localException3) {}
              }
            }
            

            if (sortsize > 4) {
              j++;
              if (!hmextendvaluefour.containsKey(id)) {
                try {
                  sortValue = 
                  
                    document.get(docs.fields[j].getField()).toUpperCase();
                  hmextendvaluefour.put(id, sortValue);
                }
                catch (Exception localException4) {}
              }
            }
          }
        }
        
        counters = CounterBuilder.getCounters(hmcount, 
          hmextendvalueone, hmextendvaluetwo, hmextendvaluethree, 
          hmextendvaluefour);
      }
    } catch (IOException e) {
      e.printStackTrace();
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
    
    return counters;
  }
  









  public HashMap getDistinctValue(Query query, Filter filter, int topNum, Sort sort, String path)
  {
    HashMap counters = null;
    int sortsize = 0;
    
    if (sort == null) {
      return counters;
    }
    
    sortsize = sort.getSort().length;
    if (sortsize < 1) {
      return counters;
    }
    
    List province = null;
    List payment = null;
    
    IndexSearcher mySearcher = SearcherSingleton.getIndexSearcherByPath(path);
    try
    {
      if (mySearcher != null) {
        TopFieldDocs docs = mySearcher.search(query, filter, topNum, sort);
        

        for (int i = 0; i < docs.scoreDocs.length; i++) {
          FieldDoc fieldDoc = (FieldDoc)docs.scoreDocs[i];
          Document document = mySearcher.doc(fieldDoc.doc);
          
          for (int j = 0; j < fieldDoc.fields.length; j++)
          {
            String sortValue = document.get(
              docs.fields[j].getField());
            if ((sortValue != null) && (!"".equals(sortValue))) {
              if (province == null) {
                province = new ArrayList();
                province.add(sortValue);
              }
              else if (!province.contains(sortValue)) {
                province.add(sortValue);
              }
            }
            
            if (sortsize > 1) {
              j++;
              String[] sortValue2 = document
                .getValues(docs.fields[j].getField());
              if (sortValue2 != null) {
                for (int k = 0; k < sortValue2.length; k++) {
                  if (sortValue2[k] != null) {
                    if (payment == null) {
                      payment = new ArrayList();
                      payment.add(sortValue2[k]);

                    }
                    else if (!payment.contains(sortValue2[k])) {
                      payment.add(sortValue2[k]);
                    }
                  }
                }
              }
            }
          }
        }
        if ((province != null) && 
          (counters == null)) {
          counters = new HashMap();
          counters.put("field_1", province);
        }
        
        if (payment != null) {
          if (counters == null) {
            counters = new HashMap();
            counters.put("field_2", payment);
          } else {
            counters.put("field_2", payment);
          }
        }
      }
    }
    catch (IOException e) {
      e.printStackTrace();
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
    
    return counters;
  }
  

  protected abstract Object extract(Document paramDocument);
  
  public void setIndexPath(String indexPath)
  {
    this.indexPath = indexPath;
  }
  

  public boolean isExistPathOrFile(String indexPath)
  {
    File dirFile = new File(indexPath);
    return dirFile.exists();
  }
}
