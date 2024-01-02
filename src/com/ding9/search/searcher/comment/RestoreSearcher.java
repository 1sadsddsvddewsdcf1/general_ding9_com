package com.ding9.search.searcher.comment;

import com.ding9.search.searcher.AbstractSearcher;
import com.ding9.search.searcher.support.document.DocumentExtractor;
import com.ding9.search.util.Environment;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;






public class RestoreSearcher
  extends AbstractSearcher
{
  public static RestoreSearcher restoreSearcher;
  
  public static RestoreSearcher getInstance()
  {
    if (restoreSearcher == null) {
      restoreSearcher = new RestoreSearcher(Environment.getRestore_Index_Dir());
      try {
        mySearcher = new IndexSearcher(Environment.getRestore_Index_Dir());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return restoreSearcher;
  }
  


  private RestoreSearcher() {}
  

  public RestoreSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  


  protected Object extract(Document doc)
  {
    return DocumentExtractor.getRestore(doc);
  }
}
