package com.ding9.search.searcher;

import com.ding9.search.util.Environment;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.search.IndexSearcher;


public class SearcherSingleton
{
  private static IndexSearcher articleSearcher = null;
  private static IndexSearcher merchantProductSearcher = null;
  private static IndexSearcher cheapCardSearcher = null;
  private static IndexSearcher commentSearcher = null;
  private static IndexSearcher merchantInfoSearcher = null;
  private static IndexSearcher productMasterSearcher = null;
  private static IndexSearcher promotionSearcher = null;
  private static IndexSearcher restoreSearcher = null;
  
  private static final Log log = LogFactory.getLog(SearcherSingleton.class);
  
  public static IndexSearcher getArticleSearcher(String path) {
    try {
      if (articleSearcher == null) {
        articleSearcher = new IndexSearcher(path);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return articleSearcher;
  }
  
  public static IndexSearcher getCheapCardSearcher(String path) {
    try {
      if (cheapCardSearcher == null) {
        cheapCardSearcher = new IndexSearcher(path);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return cheapCardSearcher;
  }
  
  public static IndexSearcher getCommentSearcher(String path) {
    try {
      if (commentSearcher == null) {
        commentSearcher = new IndexSearcher(path);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return commentSearcher;
  }
  
  public static IndexSearcher getMerchantInfoSearcher(String path) {
    try {
      if (merchantInfoSearcher == null) {
        merchantInfoSearcher = new IndexSearcher(path);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return merchantInfoSearcher;
  }
  
  public static IndexSearcher getProductMasterMainSearcher(String path) {
    try {
      if (productMasterSearcher == null) {
        productMasterSearcher = new IndexSearcher(path);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return productMasterSearcher;
  }
  
  public static IndexSearcher getPromotionSearcher(String path) {
    try {
      if (promotionSearcher == null) {
        promotionSearcher = new IndexSearcher(path);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return promotionSearcher;
  }
  
  public static IndexSearcher getRestoreSearcher(String path) {
    try {
      if (restoreSearcher == null) {
        restoreSearcher = new IndexSearcher(path);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return restoreSearcher;
  }
  
  public static IndexSearcher getMerchantProductSearcher(String path) {
    try {
      if (merchantProductSearcher == null) {
        merchantProductSearcher = new IndexSearcher(path);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return merchantProductSearcher;
  }
  
  public static IndexSearcher getIndexSearcherByPath(String path)
  {
    IndexSearcher is = null;
    log.warn("path:=" + path);
    
    if (path.equals(Environment.getArticleMain_Index_Dir())) {
      return getArticleSearcher(path);
    }
    if (path.equals(Environment.getCheapCardMain_Index_Dir())) {
      return getCheapCardSearcher(path);
    }
    if (path.equals(Environment.getCommentMain_Index_Dir())) {
      return getCommentSearcher(path);
    }
    if (path.equals(Environment.getMerchantInfo_Index_Dir())) {
      return getMerchantInfoSearcher(path);
    }
    if (path.equals(Environment.getMerchantProductMainIndex())) {
      return getMerchantProductSearcher(path);
    }
    if (path.equals(Environment.getProductMasterMain_Index_Dir())) {
      return getProductMasterMainSearcher(path);
    }
    if (path.equals(Environment.getPromotionMain_Index_Dir())) {
      return getPromotionSearcher(path);
    }
    if (path.equals(Environment.getRestore_Index_Dir())) {
      return getRestoreSearcher(path);
    }
    
    return is;
  }
}
