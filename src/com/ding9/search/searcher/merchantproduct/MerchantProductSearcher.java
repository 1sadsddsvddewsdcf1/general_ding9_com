package com.ding9.search.searcher.merchantproduct;

import com.ding9.search.searcher.support.document.DocumentExtractor;
import com.ding9.search.util.Environment;
import org.apache.lucene.document.Document;

public class MerchantProductSearcher extends com.ding9.search.searcher.AbstractSearcher
{
  public static MerchantProductSearcher merchantProductSearcher;
  
  public static MerchantProductSearcher getInstance()
  {
    if (merchantProductSearcher == null) {
      merchantProductSearcher = new MerchantProductSearcher(Environment.getMerchantProductMainIndex());
    }
    return merchantProductSearcher;
  }
  



  public MerchantProductSearcher() {}
  


  public MerchantProductSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  
  protected Object extract(Document doc) {
    return DocumentExtractor.getMerchantProduct(doc);
  }
}
