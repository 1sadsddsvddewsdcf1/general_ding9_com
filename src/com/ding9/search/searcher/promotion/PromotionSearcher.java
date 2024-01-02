package com.ding9.search.searcher.promotion;

import com.ding9.search.searcher.support.document.DocumentExtractor;
import com.ding9.search.util.Environment;
import org.apache.lucene.document.Document;

public class PromotionSearcher extends com.ding9.search.searcher.AbstractSearcher
{
  public static PromotionSearcher promotionSearcher;
  
  public static PromotionSearcher getInstance()
  {
    if (promotionSearcher == null) {
      promotionSearcher = new PromotionSearcher(Environment.getPromotionMain_Index_Dir());
    }
    return promotionSearcher;
  }
  


  private PromotionSearcher() {}
  


  public PromotionSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  
  protected Object extract(Document doc) {
    return DocumentExtractor.getPromotion(doc);
  }
}
