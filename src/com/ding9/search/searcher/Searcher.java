package com.ding9.search.searcher;

import com.ding9.search.util.PageParam;
import com.ding9.search.util.Pagination;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;

public abstract interface Searcher
{
  public abstract Pagination search(Query paramQuery, Filter paramFilter, int paramInt1, PageParam paramPageParam, int paramInt2, String paramString);
  
  public abstract Pagination search(Query paramQuery, Filter paramFilter, int paramInt1, PageParam paramPageParam, Sort paramSort, int paramInt2, String paramString);
}
