package com.ding9.search.searcher.ProdcutParaSort;

import com.ding9.search.searcher.support.document.DocumentExtractor;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;

public class ProductParaSearcher extends com.ding9.search.searcher.AbstractSearcher
{
  public static ProductParaSearcher productParaSearcher;
  
  public static ProductParaSearcher getInstance(String indexPath)
  {
    if (productParaSearcher == null) {
      productParaSearcher = new ProductParaSearcher(indexPath);
      try {
        mySearcher = new IndexSearcher(indexPath);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return productParaSearcher;
  }
  



  private ProductParaSearcher() {}
  


  public ProductParaSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  
  protected Object extract(Document doc) {
    return DocumentExtractor.getProductPara(doc);
  }
}
