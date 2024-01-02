package com.ding9.search.searcher.merchant;

import com.ding9.search.searcher.AbstractSearcher;
import com.ding9.search.searcher.support.document.DocumentExtractor;
import com.ding9.search.util.Environment;
import org.apache.lucene.document.Document;




public class MerchantInfoSearcher
  extends AbstractSearcher
{
  public static MerchantInfoSearcher merchantInfoSearcher;
  
  public static MerchantInfoSearcher getInstance()
  {
    if (merchantInfoSearcher == null) {
      merchantInfoSearcher = new MerchantInfoSearcher(Environment.getMerchantInfo_Index_Dir());
    }
    return merchantInfoSearcher;
  }
  



  public MerchantInfoSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  
  protected Object extract(Document doc) {
    return DocumentExtractor.getMerchantInfo(doc);
  }
}
