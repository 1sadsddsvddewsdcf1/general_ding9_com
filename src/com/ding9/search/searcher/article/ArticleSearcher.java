package com.ding9.search.searcher.article;

import com.ding9.search.searcher.AbstractSearcher;
import com.ding9.search.searcher.support.QueryBuilder;
import com.ding9.search.searcher.support.document.DocumentExtractor;
import com.ding9.search.util.Environment;
import com.ding9.search.util.PageParam;
import com.ding9.search.util.Pagination;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;

public class ArticleSearcher extends AbstractSearcher
{
  public static ArticleSearcher articleSearcher;
  
  public static ArticleSearcher getInstance()
  {
    if (articleSearcher == null) {
      articleSearcher = new ArticleSearcher(
        Environment.getArticleMain_Index_Dir());
    }
    return articleSearcher;
  }
  




  public ArticleSearcher() {}
  



  public ArticleSearcher(String indexPath)
  {
    setIndexPath(indexPath);
  }
  
  protected Object extract(Document doc) {
    return DocumentExtractor.getArticle(doc);
  }
  
  public Pagination getRelArticle(int memt_id, int reltype, int relvalue, PageParam pageParam) throws IOException
  {
    AbstractSearcher searcher = null;
    String indexPath = null;
    indexPath = Environment.getArticleMain_Index_Dir();
    
    searcher = getInstance();
    BooleanQuery query = new BooleanQuery();
    String[] fieldNames = { "memt_id" };
    Query keywordQuery = QueryBuilder.createQuery(fieldNames, 
      String.valueOf(memt_id));
    query.add(keywordQuery, BooleanClause.Occur.MUST);
    
    String[] fieldName2 = { "relation_type" };
    keywordQuery = QueryBuilder.createQuery(fieldName2, 
      String.valueOf(reltype));
    query.add(keywordQuery, BooleanClause.Occur.MUST);
    
    String[] fieldName3 = { "relation_value" };
    keywordQuery = QueryBuilder.createQuery(fieldName3, 
      String.valueOf(relvalue));
    query.add(keywordQuery, BooleanClause.Occur.MUST);
    Sort sort = new Sort("release_time", true);
    Pagination pg = searcher.search(query, null, 100000, pageParam, sort, 
      1, indexPath);
    
    return pg;
  }
  
  public static void main(String[] args) throws IOException {
    System.out.println(
      new ArticleSearcher().getRelArticle(4, 1, 6, new PageParam(1, 10)).getRecords());
  }
}
