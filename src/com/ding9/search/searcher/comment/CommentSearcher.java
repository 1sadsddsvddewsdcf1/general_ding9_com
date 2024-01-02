package com.ding9.search.searcher.comment;

import com.ding9.search.searcher.support.document.DocumentExtractor;
import com.ding9.search.util.Environment;
import org.apache.lucene.document.Document;

public class CommentSearcher extends com.ding9.search.searcher.AbstractSearcher
{
  public static CommentSearcher commentSearcher;
  
  public static CommentSearcher getInstance()
  {
    if (commentSearcher == null) {
      commentSearcher = new CommentSearcher(Environment.getCommentMain_Index_Dir());
    }
    return commentSearcher;
  }
  
  private CommentSearcher() {}
  
  public CommentSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  
  protected Object extract(Document doc) {
    return DocumentExtractor.getComment(doc);
  }
}
