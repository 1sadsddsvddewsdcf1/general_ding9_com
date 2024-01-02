package com.ding9.search.searcher.support;

import com.ding9.search.index.support.analysis.CnAnalyzer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.Query;

public abstract class QueryBuilder
{
  private static final Log LOG = LogFactory.getLog(QueryBuilder.class);
  



  private static final Analyzer analyzer = new CnAnalyzer();
  
  public static Query createQuery(String fieldName, String word)
  {
    return createQuery(new String[] { fieldName }, word);
  }
  
  public static Query createQuery(String[] fieldNames, String word) {
    Query query = null;
    try
    {
      QueryParser parser = new MultiFieldQueryParser(fieldNames, analyzer);
      parser.setDefaultOperator(QueryParser.AND_OPERATOR);
      
      query = parser.parse(word);
    } catch (Exception e) {
      LOG.error("error:" + e.getLocalizedMessage());
    }
    
    return query;
  }
  
  public static Query createMulFieldQuery(String[] word, String[] fields, BooleanClause.Occur[] flags) {
    Query query = null;
    try {
      query = MultiFieldQueryParser.parse(word, fields, flags, analyzer);
    } catch (Exception e) {
      LOG.error("error:" + e.getLocalizedMessage());
    }
    
    return query;
  }
}
