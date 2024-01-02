package com.ding9.search.searcher.cheapcard;

import com.ding9.search.searcher.support.document.DocumentExtractor;
import com.ding9.search.util.Environment;
import org.apache.lucene.document.Document;

public class CheapCardSearcher extends com.ding9.search.searcher.AbstractSearcher
{
  public static CheapCardSearcher cheapCardSearcher;
  
  public static CheapCardSearcher getInstance()
  {
    if (cheapCardSearcher == null) {
      cheapCardSearcher = new CheapCardSearcher(Environment.getCheapCardMain_Index_Dir());
    }
    return cheapCardSearcher;
  }
  



  private CheapCardSearcher() {}
  


  public CheapCardSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  
  protected Object extract(Document doc) {
    return DocumentExtractor.getCheapCard(doc);
  }
}
