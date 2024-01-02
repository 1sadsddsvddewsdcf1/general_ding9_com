package com.ding9.search.server;

import com.ding9.search.entity.assistant.Counter;
import com.ding9.search.entity.comment.Comment;
import com.ding9.search.entity.merchant.MerchantInfo;
import com.ding9.search.entity.product.ProductMaster;
import com.ding9.search.entity.productparasort.ProductPara;
import com.ding9.search.searcher.AbstractSearcher;
import com.ding9.search.searcher.ProdcutParaSort.ProductParaSearcher;
import com.ding9.search.searcher.article.ArticleSearcher;
import com.ding9.search.searcher.cheapcard.CheapCardSearcher;
import com.ding9.search.searcher.comment.CommentSearcher;
import com.ding9.search.searcher.comment.RestoreSearcher;
import com.ding9.search.searcher.merchant.MerchantInfoSearcher;
import com.ding9.search.searcher.merchantproduct.MerchantProductSearcher;
import com.ding9.search.searcher.product.ProductMasterSearcher;
import com.ding9.search.searcher.promotion.PromotionSearcher;
import com.ding9.search.searcher.support.QueryBuilder;
import com.ding9.search.searcher.support.ResultBuilder;
import com.ding9.search.searcher.support.result.ArticleResult;
import com.ding9.search.searcher.support.result.CheapCardResult;
import com.ding9.search.searcher.support.result.CommentResult;
import com.ding9.search.searcher.support.result.MerchantInfoResult;
import com.ding9.search.searcher.support.result.MerchantProductResult;
import com.ding9.search.searcher.support.result.ProductMasterResult;
import com.ding9.search.searcher.support.result.ProductParaResult;
import com.ding9.search.searcher.support.result.PromotionResult;
import com.ding9.search.searcher.support.result.RestoreResult;
import com.ding9.search.segword.lietu.D9LieTu;
import com.ding9.search.service.ISearchService;
import com.ding9.search.util.Environment;
import com.ding9.search.util.PageParam;
import com.ding9.search.util.Pagination;
import com.ding9.search.util.StringHelper;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.RangeQuery;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TermQuery;














public class SearchService
  implements ISearchService
{
  private static final Log log = LogFactory.getLog(SearchService.class);
  
  private static D9LieTu d9lietu = new D9LieTu();
  private int topNum = 30000;
  private Filter filter = null;
  



















  public ProductMasterResult getStandardProducts(String keyword, int page_no, int page_size, boolean searchlogic)
  {
    return getStandardProducts(keyword, 0, 0, 0.0F, 0.0F, 
      101, page_no, page_size, 
      searchlogic);
  }
  






















  public ProductMasterResult getStandardProducts(String keyword, int prso_id, int page_no, int page_size, boolean searchlogic)
  {
    return getStandardProducts(keyword, prso_id, 0, 0.0F, 0.0F, 
      101, page_no, page_size, 
      searchlogic);
  }
  
























  public ProductMasterResult getStandardProducts(String keyword, int prso_id, int prbr_id, int page_no, int page_size, boolean searchlogic)
  {
    return getStandardProducts(keyword, prso_id, prbr_id, 0.0F, 0.0F, 
      101, page_no, page_size, 
      searchlogic);
  }
  























  public ProductMasterResult getStandardProducts(String keyword, int prso_id, int prbr_id, int prma_id, int page_no, int page_size, boolean searchlogic, String type)
  {
    return getStandardProducts(keyword, prso_id, prbr_id, prma_id, 0.0F, 0.0F, 
      101, page_no, page_size, 
      searchlogic, type);
  }
  



















































  public ProductMasterResult getStandardProducts(String keyword, int prso_id, int prbr_id, float min_price, float max_price, int sort_type, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    

    keyword = StringHelper.getRealString(keyword);
    

    int order_type = 1;
    
    if (min_price < 0.0F) {
      min_price = 0.0F;
    }
    if (min_price > 9999999.0F) {
      min_price = 9999999.0F;
    }
    if ((min_price > 0.0F) && (max_price == 0.0F)) {
      max_price = 9999999.0F;
    }
    if (max_price < min_price) {
      max_price = min_price;
    }
    

    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    




    indexPath = Environment.getProductMasterMain_Index_Dir();
    

    searcher = ProductMasterSearcher.getInstance();
    

    PageParam pageParam = new PageParam(page_no, page_size);
    

    BooleanQuery query = new BooleanQuery();
    BooleanQuery.setMaxClauseCount(999999999);
    

    if (!"".equals(keyword)) {
      Query keywordQuery = QueryBuilder.createQuery(
        getFieldNames(1), keyword);
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    

    if (prbr_id > 0) {
      Query prbrQuery = QueryBuilder.createQuery(getFieldNames(3), 
        String.valueOf(prbr_id));
      query.add(prbrQuery, BooleanClause.Occur.MUST);
    }
    

    if (prso_id > -1) {
      Query prbrQuery = QueryBuilder.createQuery(new String[] { "prso_id_one", "prso_id_two", "prso_id" }, 
        String.valueOf(prso_id));
      query.add(prbrQuery, BooleanClause.Occur.MUST);
    }
    

    if ((min_price > 0.0F) || (max_price > 0.0F)) {
      Term begin_price = new Term("min_price", 
        StringHelper.floatToString(min_price));
      Term end_price = new Term("min_price", 
        StringHelper.floatToString(max_price));
      
      RangeQuery priceQuery = new RangeQuery(begin_price, end_price, true);
      query.add(priceQuery, BooleanClause.Occur.MUST);
    }
    

    Term begin_mcount = new Term("merchant_count", "0");
    Term end_mcount = new Term("merchant_count", "99999999");
    RangeQuery mcountQuery = new RangeQuery(begin_mcount, end_mcount, true);
    query.add(mcountQuery, BooleanClause.Occur.MUST);
    




    Sort sort = null;
    switch (sort_type)
    {

    case 101: 
      sort = new Sort(new SortField[] { new SortField("merchant_count", 4, true) });
      break;
    

    case 102: 
      sort = new Sort(new SortField[] { new SortField("min_price", 5, true) });
      order_type = 0;
      break;
    

    case 103: 
      sort = new Sort(new SortField[] { new SortField("min_price", 5, true) });
      order_type = 1;
      break;
    

    case 104: 
      sort = new Sort(new SortField[] { new SortField("comment_count", 4, true) });
      order_type = 0;
      break;
    

    case 105: 
      sort = new Sort(new SortField[] { new SortField("comment_count", 4, true) });
      order_type = 1;
      break;
    

    case 106: 
      sort = new Sort(new SortField[] { new SortField("merchant_count", 4, true) });
      order_type = 0;
      break;
    

    case 107: 
      sort = new Sort(new SortField[] { new SortField("merchant_count", 4, true) });
      order_type = 1;
      break;
    
    default: 
      sort = new Sort(new SortField[] { new SortField("merchant_count", 4, true) });
    }
    
    
    pretime = System.currentTimeMillis();
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, order_type, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    ProductMasterResult pr = null;
    
    pr = ResultBuilder.getProductMasterResult(pagination);
    
    return pr;
  }
  



























  public Counter[] getProductBrandCounts(String keyword, int prso_id, int prbr_id, float min_price, float max_price, boolean searchlogic)
  {
    Counter[] counters = (Counter[])null;
    
    long pretime = System.currentTimeMillis();
    

    keyword = StringHelper.getRealString(keyword);
    

    if (min_price < 0.0F) {
      min_price = 0.0F;
    }
    if (min_price > 9999999.0F) {
      min_price = 9999999.0F;
    }
    if ((min_price > 0.0F) && (max_price == 0.0F)) {
      max_price = 9999999.0F;
    }
    if (max_price < min_price) {
      max_price = min_price;
    }
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    




    indexPath = Environment.getProductMasterMain_Index_Dir();
    

    searcher = ProductMasterSearcher.getInstance();
    

    BooleanQuery query = new BooleanQuery();
    BooleanQuery.setMaxClauseCount(999999999);
    

    if (!"".equals(keyword)) {
      Query keywordQuery = QueryBuilder.createQuery(
        getFieldNames(1), keyword);
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    
    if (prso_id > -1) {
      Query keywordQuery = QueryBuilder.createQuery(new String[] { "prso_id_one", "prso_id_two", "prso_id" }, String.valueOf(prso_id));
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    

    if (prbr_id > 0) {
      Query prbrQuery = QueryBuilder.createQuery(getFieldNames(3), 
        String.valueOf(prbr_id));
      query.add(prbrQuery, BooleanClause.Occur.MUST);
    }
    

    if ((min_price > 0.0F) || (max_price > 0.0F)) {
      Term begin_price = new Term("min_price", 
        StringHelper.floatToString(min_price));
      Term end_price = new Term("min_price", 
        StringHelper.floatToString(max_price));
      
      RangeQuery priceQuery = new RangeQuery(begin_price, end_price, true);
      query.add(priceQuery, BooleanClause.Occur.MUST);
    }
    
    Term begin_mcount = new Term("merchant_count", "0");
    Term end_mcount = new Term("merchant_count", "99999999");
    RangeQuery mcountQuery = new RangeQuery(begin_mcount, end_mcount, true);
    query.add(mcountQuery, BooleanClause.Occur.MUST);
    


    Sort sort = null;
    






    sort = new Sort(new SortField[] {
      new SortField("prso_id", 4, true), 
      new SortField("prso_name", 3, true), 
      new SortField("prso_id_one", 4, true) });
    
    pretime = System.currentTimeMillis();
    
    Filter filter = null;
    

    counters = searcher.getCounts(query, filter, this.topNum, sort, indexPath);
    
    for (int i = 0; i < counters.length; i++) {
      if ((counters[i].getValue().trim().equals("0")) || (counters[i].getValue().trim().equals(""))) {
        counters[i].setExtend_value_one("暂无分类商品");
      }
    }
    for (int i = counters.length - 1; i > 1; i--) {
      for (int j = 0; j < i; j++) {
        if (counters[j].getCount() < counters[(j + 1)].getCount()) {
          Counter tmp = counters[j];
          counters[j] = counters[(j + 1)];
          counters[(j + 1)] = tmp;
        }
      }
    }
    











    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    return counters;
  }
  





  private String toLowerCase(String str)
  {
    str = (str == null ? "" : str.trim()).toLowerCase();
    
    return str;
  }
  






  private String[] getFieldNames(int type)
  {
    if (type == 1) {
      String[] fieldNames = { "prma_name", 
        "prma_name_alias", 
        "prso_name", 
        "prso_name_alias", 
        "prbr_name", 
        "prbr_english_name", 
        "prbr_name_alias" };
      

      return fieldNames;
    }
    

    if (type == 2) {
      String[] fieldNames = { "prso_id" };
      

      return fieldNames;
    }
    

    if (type == 3) {
      String[] fieldNames = { "prbr_id" };
      

      return fieldNames;
    }
    
    if (type == 4) {
      String[] fieldNames = { "prma_id" };
      

      return fieldNames;
    }
    
    if (type == 5) {
      String[] fieldNames = { "prso_id_two" };
      

      return fieldNames;
    }
    return null;
  }
  



















  public ArticleResult getArticles(String keyword, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    
    keyword = StringHelper.getRealString(keyword);
    

    if ("".equals(keyword)) {
      return null;
    }
    

    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getArticleMain_Index_Dir();
    
    searcher = ArticleSearcher.getInstance();
    


    PageParam pageParam = new PageParam(page_no, page_size);
    

    String[] fieldNames = { "title" };
    
    Query query = QueryBuilder.createQuery(fieldNames, keyword);
    

    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("article_id", 4, true) });
    pretime = System.currentTimeMillis();
    
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, 
      1, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    ArticleResult pr = null;
    
    pr = ResultBuilder.getArticleResult(pagination);
    
    return pr;
  }
  



















  public CheapCardResult getCheapCards(String keyword, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    
    keyword = StringHelper.getRealString(keyword);
    

    if ("".equals(keyword)) {
      return null;
    }
    

    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getCheapCardMain_Index_Dir();
    
    searcher = CheapCardSearcher.getInstance();
    


    PageParam pageParam = new PageParam(page_no, page_size);
    

    String[] fieldNames = { "brand_name", "chca_title", "sowntown", 
      "store_name", "marketplace" };
    
    Query query = QueryBuilder.createQuery(fieldNames, keyword);
    

    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("chca_time", 3, true) });
    pretime = System.currentTimeMillis();
    
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, 
      1, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    CheapCardResult pr = null;
    
    pr = ResultBuilder.getCheapCardResult(pagination);
    
    return pr;
  }
  









  public CommentResult getComments(int prma_id, int page_no, int page_size, boolean searchlogic)
  {
    page_no = page_no > 0 ? page_no : 1;
    
    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getCommentMain_Index_Dir();
    
    searcher = CommentSearcher.getInstance();
    


    PageParam pageParam = new PageParam(page_no, page_size);
    


    if (prma_id < 1) {
      return null;
    }
    
    String[] fieldNames = { "prma_id" };
    
    Query query = QueryBuilder.createQuery(fieldNames, String.valueOf(prma_id));
    

    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("release_time", 3, true) });
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, 
      1, indexPath);
    
    CommentResult pr = null;
    
    pr = ResultBuilder.getCommentResult(pagination);
    
    return pr;
  }
  










  public CommentResult getComments(int page_no, int page_size, boolean searchlogic)
  {
    page_no = page_no > 0 ? page_no : 1;
    
    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    String indexPath = Environment.getCommentMain_Index_Dir();
    
    AbstractSearcher searcher = null;
    searcher = CommentSearcher.getInstance();
    
    PageParam pageParam = new PageParam(page_no, page_size);
    
    BooleanQuery query = new BooleanQuery();
    BooleanQuery.setMaxClauseCount(999999999);
    
    Term spid = new Term("prma_id", "1");
    Term epid = new Term("prma_id", "9999999");
    RangeQuery priceQuery = new RangeQuery(spid, epid, true);
    query.add(priceQuery, BooleanClause.Occur.MUST);
    


    Sort sort = null;
    sort = new Sort(new SortField[] { new SortField("release_time", 3, true) });
    Pagination pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, 
      1, indexPath);
    
    CommentResult pr = ResultBuilder.getCommentResult(pagination);
    
    return pr;
  }
  



















  public CommentResult getComments(String keyword, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    
    keyword = StringHelper.getRealString(keyword);
    

    if ("".equals(keyword)) {
      return null;
    }
    

    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getCommentMain_Index_Dir();
    
    searcher = CommentSearcher.getInstance();
    


    PageParam pageParam = new PageParam(page_no, page_size);
    

    String[] fieldNames = { "title", "prma_name" };
    
    Query query = QueryBuilder.createQuery(fieldNames, keyword);
    

    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("comment_id", 4, true) });
    pretime = System.currentTimeMillis();
    
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, 
      1, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    CommentResult pr = null;
    
    pr = ResultBuilder.getCommentResult(pagination);
    
    return pr;
  }
  





















  public CommentResult getComments(String keyword, int prso_id, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    
    if (prso_id < 1) {
      return getComments(keyword, page_no, page_size, searchlogic);
    }
    
    keyword = StringHelper.getRealString(keyword);
    

    if ("".equals(keyword)) {
      return null;
    }
    


    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getCommentMain_Index_Dir();
    

    searcher = CommentSearcher.getInstance();
    
    PageParam pageParam = new PageParam(page_no, page_size);
    

    String[] fieldNames = { "title", "prma_name" };
    
    BooleanQuery allQuery = new BooleanQuery();
    Query query = QueryBuilder.createQuery(fieldNames, keyword);
    allQuery.add(query, BooleanClause.Occur.MUST);
    
    Query chanQuery = new TermQuery(new Term("prso_id_one", 
      String.valueOf(prso_id)));
    allQuery.add(chanQuery, BooleanClause.Occur.MUST);
    

    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("comment_id", 4, true) });
    pretime = System.currentTimeMillis();
    
    pagination = searcher.search(allQuery, null, this.topNum, pageParam, sort, 
      1, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    CommentResult pr = null;
    
    pr = ResultBuilder.getCommentResult(pagination);
    
    return pr;
  }
  



















  public CommentResult getComments(String keyword, int prma_id, int prso_id, int sort_type, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    

    keyword = StringHelper.getRealString(keyword);
    

    int order_type = 1;
    
    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getCommentMain_Index_Dir();
    

    searcher = CommentSearcher.getInstance();
    
    PageParam pageParam = new PageParam(page_no, page_size);
    

    BooleanQuery query = new BooleanQuery();
    BooleanQuery.setMaxClauseCount(999999999);
    

    if (!"".equals(keyword)) {
      Query keywordQuery = QueryBuilder.createQuery(
        new String[] { "title", "prma_name" }, keyword);
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    

    if (prma_id > 0) {
      Query prbrQuery = QueryBuilder.createQuery(new String[] { "prma_id" }, 
        String.valueOf(prma_id));
      query.add(prbrQuery, BooleanClause.Occur.MUST);
    }
    
    if (prso_id > -1) {
      Query prbrQuery = QueryBuilder.createQuery(new String[] { "prso_id_one", "prso_id_two", "prso_id" }, 
        String.valueOf(prso_id));
      query.add(prbrQuery, BooleanClause.Occur.MUST);
    }
    



    Sort sort = null;
    switch (sort_type)
    {

    case 101: 
      sort = new Sort(new SortField[] { new SortField("userful_count", 4, true) });
      break;
    

    case 102: 
      sort = new Sort(new SortField[] { new SortField("userful_count", 4, true) });
      order_type = 0;
      break;
    

    case 103: 
      sort = new Sort(new SortField[] { new SortField("prma_id", 4, true) });
      order_type = 0;
      break;
    

    case 104: 
      sort = new Sort(new SortField[] { new SortField("prma_id", 4, true) });
      order_type = 1;
      break;
    

    default: 
      sort = new Sort(new SortField[] { new SortField("userful_count", 4, true) });
    }
    
    System.out.println("query:" + query.toString());
    System.out.println("order_type:" + order_type);
    pretime = System.currentTimeMillis();
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, order_type, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    CommentResult pr = null;
    
    pr = ResultBuilder.getCommentResult(pagination);
    
    return pr;
  }
  



















  public PromotionResult getPromotions(String keyword, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    
    keyword = StringHelper.getRealString(keyword);
    

    if ("".equals(keyword)) {
      return null;
    }
    

    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getPromotionMain_Index_Dir();
    

    searcher = PromotionSearcher.getInstance();
    
    PageParam pageParam = new PageParam(page_no, page_size);
    

    String[] fieldNames = { "title", "prma_name", "store_name", 
      "brand_name", "sowntown", "marketplace" };
    
    Query query = QueryBuilder.createQuery(fieldNames, keyword);
    

    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("info_id", 4, true) });
    pretime = System.currentTimeMillis();
    
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, 
      1, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    PromotionResult pr = null;
    
    pr = ResultBuilder.getPromotionResult(pagination);
    
    return pr;
  }
  










  public MerchantInfoResult getMerchantInfo(int merc_id, int is_tmp, String omit, String city, int type, String keyword, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    keyword = StringHelper.getRealString(keyword);
    

    if ((merc_id == -1) && (is_tmp == -1) && ((omit == null) || ("-1".equals(omit))) && ((city == null) || ("-1".equals(city))) && 
      (type == -1) && ("".equals(keyword))) {
      return null;
    }
    

    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getMerchantInfo_Index_Dir();
    
    searcher = MerchantInfoSearcher.getInstance();
    
    PageParam pageParam = new PageParam(page_no, page_size);
    








    String[] field_key = { "merc_web_name", "merc_com_name", "merc_url" };
    String[] field_tmp = { "is_tmp" };
    String[] field_omit = { "merc_omit" };
    String[] field_city = { "merc_city" };
    String[] field_type = { "merc_type" };
    
    String[] field_id = { "merc_id" };
    
    BooleanQuery query = new BooleanQuery();
    

    if (merc_id > -1) {
      Query idQuery = QueryBuilder.createQuery(field_id, 
        String.valueOf(merc_id));
      query.add(idQuery, BooleanClause.Occur.MUST);
    }
    

    if (is_tmp > -1) {
      Query tmpQuery = QueryBuilder.createQuery(field_tmp, 
        String.valueOf(is_tmp));
      query.add(tmpQuery, BooleanClause.Occur.MUST);
    }
    

    if ((!"".equals(keyword)) && (keyword != null)) {
      Query keywordQuery = QueryBuilder.createQuery(field_key, keyword);
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    

    if ((omit != null) && (Integer.parseInt(omit) > -1)) {
      Query omitQuery = QueryBuilder.createQuery(field_omit, omit);
      query.add(omitQuery, BooleanClause.Occur.MUST);
    }
    

    if ((city != null) && (Integer.parseInt(city) > -1)) {
      Query cityQuery = QueryBuilder.createQuery(field_city, city);
      query.add(cityQuery, BooleanClause.Occur.MUST);
    }
    

    if (type > -1) {
      Query typeQuery = QueryBuilder.createQuery(field_type, 
        String.valueOf(type));
      query.add(typeQuery, BooleanClause.Occur.MUST);
    }
    






    pretime = System.currentTimeMillis();
    Sort sort1 = new Sort("merc_id", true);
    sort1 = new Sort(new SortField[] { new SortField("merc_id", 4, true) });
    System.out.println("sort:" + sort1);
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort1, 1, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    MerchantInfoResult mr = null;
    mr = ResultBuilder.getMerchantInfoResult(pagination);
    
    return mr;
  }
  





  public MerchantInfo getMerchantDetail(int merc_id)
  {
    MerchantInfoResult rs = getMerchantInfo(merc_id, -1, "-1", "-1", 1, null, 1, 10, true);
    Object[] obj = rs.getRecords();
    MerchantInfo vo = null;
    if ((obj != null) && (obj.length > 0)) {
      vo = (MerchantInfo)obj[0];
    }
    return vo;
  }
  








  public RestoreResult getRestore(int mema_id, int page_no, int page_size)
  {
    long pretime = System.currentTimeMillis();
    
    if (mema_id < 0) {
      return null;
    }
    
    page_no = page_no > 0 ? page_no : 1;
    

    page_size = (page_size > 0) && (page_size <= 50) ? page_size : 10;
    
    pretime = System.currentTimeMillis();
    
    Pagination pagination = null;
    AbstractSearcher searcher = null;
    String indexPath = null;
    indexPath = Environment.getRestore_Index_Dir();
    
    searcher = RestoreSearcher.getInstance();
    
    PageParam pageParam = new PageParam(page_no, page_size);
    

    String[] fieldNames = { "mema_id" };
    
    Query query = QueryBuilder.createQuery(fieldNames, String.valueOf(mema_id));
    

    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("mere_id", 4, true) });
    pretime = System.currentTimeMillis();
    
    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, 
      1, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    RestoreResult rr = null;
    rr = ResultBuilder.getRestoreResult(pagination);
    return rr;
  }
  
















  public MerchantProductResult getMerchantProduct(int prma_id, int prso_id, int merc_id, String keyword, float min_price, float max_price, String merc_province, String merc_payment, int sort_type, int page_no, int page_size, boolean searchlogic)
  {
    keyword = StringHelper.getRealString(keyword);
    

    int order_type = 1;
    

    if (min_price < 0.0F) {
      min_price = 0.0F;
    }
    if (min_price > 9999999.0F) {
      min_price = 9999999.0F;
    }
    if ((min_price > 0.0F) && (max_price == 0.0F)) {
      max_price = 9999999.0F;
    }
    if (max_price < min_price) {
      max_price = min_price;
    }
    

    page_no = page_no > 0 ? page_no : 1;
    

    page_size = page_size == 0 ? 10 : page_size;
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getMerchantProductMainIndex();
    
    searcher = MerchantProductSearcher.getInstance();
    
    PageParam pageParam = new PageParam(page_no, page_size);
    

    BooleanQuery query = new BooleanQuery();
    BooleanQuery.setMaxClauseCount(999999999);
    

    if (!"".equals(keyword)) {
      String[] fieldNames = { "prma_name" };
      Query keywordQuery = QueryBuilder.createQuery(fieldNames, String.valueOf(keyword));
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    

    if (prma_id != 0) {
      String[] fieldNames = { "prma_id" };
      Query keywordQuery = QueryBuilder.createQuery(fieldNames, String.valueOf(prma_id));
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    

    if (!"".equals(merc_province)) {
      String[] fieldNames = { "merc_province" };
      Query keywordQuery = QueryBuilder.createQuery(fieldNames, String.valueOf(merc_province));
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    
    if (!"".equals(merc_payment)) {
      String[] fieldNames = { "merc_payment" };
      Query keywordQuery = QueryBuilder.createQuery(fieldNames, String.valueOf(merc_payment));
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    
    if (merc_id != 0) {
      String[] fieldNames = { "merc_id" };
      Query keywordQuery = QueryBuilder.createQuery(fieldNames, String.valueOf(merc_id));
      query.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    

    if ((min_price > 0.0F) || (max_price > 0.0F)) {
      Term begin_price = new Term("mepr_price", 
        StringHelper.floatToString(min_price));
      Term end_price = new Term("mepr_price", 
        StringHelper.floatToString(max_price));
      
      RangeQuery priceQuery = new RangeQuery(begin_price, end_price, true);
      query.add(priceQuery, BooleanClause.Occur.MUST);
    }
    




    Sort sort = null;
    switch (sort_type)
    {

    case 201: 
      sort = new Sort(new SortField[] { new SortField("meprPrice", 4, true) });
      order_type = 0;
      break;
    

    case 202: 
      sort = new Sort(new SortField[] { new SortField("meprPrice", 4, true) });
      
      break;
    

    case 203: 
      sort = new Sort(new SortField[] { new SortField("comments_level", 4, true) });
      order_type = 0;
      break;
    

    case 204: 
      sort = new Sort(new SortField[] { new SortField("comments_level", 4, true) });
    }
    
    


    pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, order_type, indexPath);
    
    MerchantProductResult pr = null;
    
    pr = ResultBuilder.getMerchantProductResult(pagination);
    
    return pr;
  }
  










  public ArticleResult getRelatedArticle(int memt_id, int prma_id, int prso_id_one, int prso_id_two, int prso_id_three, int size)
    throws IOException
  {
    PageParam pageParam = new PageParam(1, size);
    
    Pagination hit = getRelArticle(memt_id, 0, prma_id, pageParam);
    int length1 = hit.getRecordCount();
    

    if (length1 < size) {
      pageParam = new PageParam(1, size - length1);
      Pagination hittmp = getRelArticle(memt_id, 3, prso_id_three, pageParam);
      hit.getRecords().addAll(hittmp.getRecords());
      int leng2 = hittmp.getRecordCount() + length1;
      
      if (leng2 < size) {
        pageParam = new PageParam(1, size - leng2);
        hittmp = getRelArticle(memt_id, 2, prso_id_two, pageParam);
        hit.getRecords().addAll(hittmp.getRecords());
        leng2 += hittmp.getRecordCount();
        
        if (leng2 < size) {
          pageParam = new PageParam(1, size - leng2);
          hittmp = getRelArticle(memt_id, 1, prso_id_one, pageParam);
          hit.getRecords().addAll(hittmp.getRecords());
        }
      }
    }
    

    ArticleResult pr = null;
    
    pr = ResultBuilder.getArticleResult(hit);
    


    return pr;
  }
  





  private Pagination getRelArticle(int memt_id, int reltype, int relvalue, PageParam pageParam)
    throws IOException
  {
    AbstractSearcher searcher = null;
    String indexPath = null;
    indexPath = Environment.getArticleMain_Index_Dir();
    
    searcher = ArticleSearcher.getInstance();
    BooleanQuery query = new BooleanQuery();
    String[] fieldNames = { "memt_id" };
    Query keywordQuery = QueryBuilder.createQuery(fieldNames, String.valueOf(memt_id));
    query.add(keywordQuery, BooleanClause.Occur.MUST);
    
    String[] fieldName2 = { "relation_type" };
    keywordQuery = QueryBuilder.createQuery(fieldName2, String.valueOf(reltype));
    query.add(keywordQuery, BooleanClause.Occur.MUST);
    
    String[] fieldName3 = { "relation_value" };
    keywordQuery = QueryBuilder.createQuery(fieldName3, String.valueOf(relvalue));
    query.add(keywordQuery, BooleanClause.Occur.MUST);
    Sort sort = new Sort("release_time", true);
    sort = new Sort(new SortField[] { new SortField("release_time", 3, true) });
    Pagination pg = searcher.search(query, this.filter, this.topNum, pageParam, sort, 1, indexPath);
    log.warn(pg);
    return pg;
  }
  









  public ProductParaResult getProductParaSort(String keyword, int prso_id, int page_no, int page_size, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    
    if (prso_id < 1) {
      return null;
    }
    
    keyword = StringHelper.getRealString(keyword);
    
    page_no = page_no > 0 ? page_no : 1;
    

    page_size = page_size == 0 ? 10 : page_size;
    
    pretime = System.currentTimeMillis();
    

    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(
        toLowerCase(keyword), searchlogic);
    }
    if (log.isWarnEnabled()) {
      log.warn("seg word : " + keyword);
      log.warn("seg word cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    Pagination pagination = null;
    
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getProductParaSort_Index_Dir() + prso_id;
    
    File dirFile = new File(indexPath);
    if (!dirFile.exists()) {
      return null;
    }
    dirFile = null;
    

    searcher = ProductParaSearcher.getInstance(indexPath);
    

    PageParam pageParam = new PageParam(page_no, page_size);
    

    String[] fieldNames = { "prma_id", "param_name" };
    
    BooleanQuery allQuery = new BooleanQuery();
    
    if (!"".equals(keyword)) {
      Query keywordQuery = QueryBuilder.createQuery(
        fieldNames, keyword);
      allQuery.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    Query chanQuery = new TermQuery(new Term("prso_id", 
      String.valueOf(prso_id)));
    allQuery.add(chanQuery, BooleanClause.Occur.MUST);
    

    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("prma_id", 4, true) });
    pretime = System.currentTimeMillis();
    
    log.warn("getProductParaSort before search...: ");
    pagination = searcher.search(allQuery, null, this.topNum, pageParam, sort, 
      1, indexPath);
    
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    
    ProductParaResult pr = null;
    
    pr = ResultBuilder.getProdctParaResult(pagination);
    
    return pr;
  }
  








  public List getProductParaVal(String strprma_id, int prso_id, boolean searchlogic)
  {
    long pretime = System.currentTimeMillis();
    if (prso_id < 1) {
      return null;
    }
    ArrayList alprma_id = new ArrayList();
    List rslist = new ArrayList();
    String tempPath1url = strprma_id;
    int urlIndex = 0;
    while (tempPath1url.indexOf(",") >= 0) {
      urlIndex++;
      String tempStr = tempPath1url.substring(0, tempPath1url.indexOf(","));
      alprma_id.add(tempStr);
      tempPath1url = tempPath1url.substring(tempPath1url.indexOf(",") + 1, tempPath1url.length());
    }
    
    int page_no = 1;
    int page_size = 999999999;
    pretime = System.currentTimeMillis();
    Pagination pagination = null;
    AbstractSearcher searcher = null;
    
    String indexPath = null;
    indexPath = Environment.getProductParaSort_Index_Dir() + prso_id;
    File dirFile = new File(indexPath);
    if (!dirFile.exists()) {
      return null;
    }
    dirFile = null;
    

    searcher = ProductParaSearcher.getInstance(indexPath);
    
    PageParam pageParam = new PageParam(page_no, page_size);
    BooleanQuery allQuery = new BooleanQuery();
    String[] fieldNames = { "prma_id" };
    fieldNames = new String[alprma_id.size()];
    String[] word = new String[alprma_id.size()];
    BooleanClause.Occur[] flags = new BooleanClause.Occur[alprma_id.size()];
    
    for (int i = 0; i < alprma_id.size(); i++) {
      fieldNames[i] = "prma_id";
      word[i] = alprma_id.get(i).toString().trim();
      
      flags[i] = BooleanClause.Occur.SHOULD;
    }
    Query query = QueryBuilder.createMulFieldQuery(word, fieldNames, flags);
    allQuery.add(query, BooleanClause.Occur.MUST);
    Query chanQuery = new TermQuery(new Term("prso_id", 
      String.valueOf(prso_id)));
    allQuery.add(chanQuery, BooleanClause.Occur.MUST);
    
    Sort sort = null;
    

    sort = new Sort(new SortField[] { new SortField("prma_id", 4, true) });
    pretime = System.currentTimeMillis();
    pagination = searcher.search(allQuery, null, this.topNum, pageParam, sort, 1, indexPath);
    if (log.isWarnEnabled()) {
      log.warn("search cost time : " + (
        System.currentTimeMillis() - pretime));
      pretime = System.currentTimeMillis();
    }
    ProductParaResult pr = null;
    pr = ResultBuilder.getProdctParaResult(pagination);
    

    ProductPara pm = null;
    LinkedHashMap singlepro = new LinkedHashMap();
    HashMap allpro = new HashMap();
    Object[] result = pr.getRecords();
    if (result != null)
    {
      for (int i = 0; i < result.length; i++) {
        pm = (ProductPara)result[i];
        if (pm != null)
        {
          if (!"".equals(pm.getParam_value().trim())) {
            allpro.put(pm.getParam_name() + ":" + pm.getPrma_id(), pm.getParam_value());
            if (!singlepro.containsKey(pm.getParam_name().trim())) {
              singlepro.put(pm.getParam_name().trim(), pm.getParam_name().trim());
            }
          }
        }
      }
      
      Set keySet = singlepro.keySet();
      String tmpvalue = "";
      for (Iterator iter = keySet.iterator(); iter.hasNext();) {
        String key = (String)iter.next();
        LinkedHashMap rs = new LinkedHashMap();
        rs.put(key, key);
        for (int i = 0; i < alprma_id.size(); i++) {
          tmpvalue = allpro.get(key + ":" + alprma_id.get(i).toString().trim()) == null ? "" : allpro.get(key + ":" + alprma_id.get(i).toString().trim()).toString();
          tmpvalue = tmpvalue.equals("null") ? "" : tmpvalue;
          rs.put(alprma_id.get(i).toString().trim(), tmpvalue);
        }
        rslist.add(rs);
      }
    }
    



    return rslist;
  }
  



  public HashMap getMerchantInfoByPrmaId(int prma_id)
  {
    AbstractSearcher searcher = null;
    String indexPath = null;
    indexPath = Environment.getMerchantProductMainIndex();
    
    searcher = MerchantProductSearcher.getInstance();
    
    BooleanQuery query = new BooleanQuery();
    

    if (prma_id > 0) {
      String[] fields = { "prma_id" };
      Query prbrQuery = QueryBuilder.createQuery(fields, 
        String.valueOf(prma_id));
      query.add(prbrQuery, BooleanClause.Occur.MUST);
    }
    


    Sort sort = null;
    




    sort = new Sort(new SortField[] {
      new SortField("merc_province", 3, true), 
      new SortField("merc_payment", 3, true) });
    

    Filter filter = null;
    

    HashMap counters = searcher.getDistinctValue(query, filter, this.topNum, sort, indexPath);
    



    return counters;
  }
  







  public ProductMasterResult getStandardProducts(String keyword, int prso_id, int prbr_id, int prma_id, float min_price, float max_price, int sort_type, int page_no, int page_size, boolean searchlogic, String type)
  {
    System.out.println("begin getStandardProducts");
    long pretime = System.currentTimeMillis();
    
    keyword = StringHelper.getRealString(keyword);
    
    int order_type = 1;
    
    min_price = min_price < 0.0F ? 0.0F : min_price;
    min_price = min_price > 9999999.0F ? 9999999.0F : min_price;
    max_price = max_price < 0.0F ? 0.0F : max_price;
    max_price = max_price > 9999999.0F ? 9999999.0F : max_price;
    max_price = max_price < min_price ? min_price : max_price;
    
    page_no = page_no > 0 ? page_no : 1;
    
    page_size = page_size == 0 ? 10 : page_size;
    pretime = System.currentTimeMillis();
    
    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(toLowerCase(keyword), searchlogic);
    }
    Pagination pagination = null;
    AbstractSearcher searcher = null;
    String indexPath = Environment.getProductMasterMain_Index_Dir();
    searcher = ProductMasterSearcher.getInstance();
    
    PageParam pageParam = new PageParam(page_no, page_size);
    
    BooleanQuery allQuery = new BooleanQuery();
    BooleanQuery.setMaxClauseCount(999999999);
    ProductMaster pm = new ProductMaster();
    
    List fieldList = new ArrayList();
    List valueList = new ArrayList();
    List<BooleanClause.Occur> qflagsList = new ArrayList();
    if (type.equals("samebrand"))
    {
      if (prso_id > 0) {
        fieldList.add("prso_id");
        valueList.add(String.valueOf(prso_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      if (prbr_id > 0) {
        fieldList.add("prbr_id");
        valueList.add(String.valueOf(prbr_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      fieldList.add("prbr_id");
      valueList.add(String.valueOf(0));
      qflagsList.add(BooleanClause.Occur.MUST_NOT);
      
      if (prma_id > 0) {
        fieldList.add("prma_id");
        valueList.add(String.valueOf(prma_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
    } else if (type.equals("fightbrand")) {
      BooleanQuery query = new BooleanQuery();
      
      int tmpprso_id = prso_id;
      if (prso_id > 0)
      {
        Query mulquery = QueryBuilder.createQuery("prso_id", String.valueOf(prso_id));
        query.add(mulquery, BooleanClause.Occur.MUST);
        
        Sort sort = new Sort("prso_id", true);
        sort = new Sort(new SortField[] { new SortField("prso_id", 4, true) });
        order_type = 1;
        
        PageParam tempPageParam = new PageParam(1, 1);
        pagination = searcher.search(query, this.filter, this.topNum, tempPageParam, sort, order_type, indexPath);
        ProductMasterResult pr = null;
        pr = ResultBuilder.getProductMasterResult(pagination);
        Object[] result = (Object[])null;
        result = pr.getRecords();
        if (result != null) {
          for (int i = 0; i < result.length; i++) {
            pm = (ProductMaster)result[i];
          }
        }
        if (pm.getPrso_id() == prso_id) {
          prso_id = pm.getPrso_id_two();
        }
        searcher = ProductMasterSearcher.getInstance();
      }
      
      if (prso_id > 0) {
        fieldList.add("prso_id_two");
        valueList.add(String.valueOf(prso_id));
        qflagsList.add(BooleanClause.Occur.MUST);
        fieldList.add("prso_id");
        valueList.add(String.valueOf(tmpprso_id));
        qflagsList.add(BooleanClause.Occur.MUST_NOT);
      }
      
      if (prbr_id > 0) {
        fieldList.add("prbr_id");
        valueList.add(String.valueOf(prbr_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      if (prma_id > 0) {
        fieldList.add("prma_id");
        valueList.add(String.valueOf(prma_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
    } else if ((type.equals("samePrmaidbrand")) || (type.equals("diffPrmaidbrand"))) {
      BooleanQuery query = new BooleanQuery();
      
      if (prma_id > 0)
      {
        Query mulquery = QueryBuilder.createQuery("prma_id", String.valueOf(prma_id));
        query.add(mulquery, BooleanClause.Occur.MUST);
        
        Sort sort = new Sort("prma_id", true);
        sort = new Sort(new SortField[] { new SortField("prma_id", 4, true) });
        order_type = 1;
        pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, order_type, indexPath);
        ProductMasterResult pr = null;
        pr = ResultBuilder.getProductMasterResult(pagination);
        Object[] result = (Object[])null;
        result = pr.getRecords();
        if (result != null) {
          for (int i = 0; i < result.length; i++) {
            pm = (ProductMaster)result[i];
          }
        }
      }
      if (pm != null)
      {
        prso_id = pm.getPrso_id();
        if (prso_id > 0) {
          fieldList.add("prso_id");
          valueList.add(String.valueOf(prso_id));
          qflagsList.add(BooleanClause.Occur.MUST);
        }
        
        if (type.equals("samePrmaidbrand"))
        {
          int tmpprbr_id = pm.getPrbr_id() > 0 ? pm.getPrbr_id() : -111;
          fieldList.add("prbr_id");
          valueList.add(String.valueOf(tmpprbr_id));
          qflagsList.add(BooleanClause.Occur.MUST);
        } else { type.equals("diffPrmaidbrand");
        }
        



        if (prma_id > 0) {
          fieldList.add("prma_id");
          valueList.add(String.valueOf(prma_id));
          qflagsList.add(BooleanClause.Occur.MUST_NOT);
        }
      }
    }
    else {
      if (prso_id > 0) {
        fieldList.add("prso_id");
        valueList.add(String.valueOf(prso_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      if (prbr_id > 0) {
        fieldList.add("prbr_id");
        valueList.add(String.valueOf(prbr_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      if (prma_id > 0) {
        fieldList.add("prma_id");
        valueList.add(String.valueOf(prma_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
    }
    if ((fieldList.size() == valueList.size() ? 1 : 0) == (qflagsList.size() > 0 ? 1 : 0)) {
      String[] fieldNames = new String[fieldList.size()];
      String[] word = new String[valueList.size()];
      BooleanClause.Occur[] flags = new BooleanClause.Occur[qflagsList.size()];
      
      for (int i = 0; i < fieldNames.length; i++) {
        fieldNames[i] = ((String)fieldList.get(i));
        word[i] = ((String)valueList.get(i));
        flags[i] = ((BooleanClause.Occur)qflagsList.get(i));
      }
      
      Query mulquery = QueryBuilder.createMulFieldQuery(word, fieldNames, flags);
      allQuery.add(mulquery, BooleanClause.Occur.MUST);
    }
    

    if (!"".equals(keyword)) {
      Query keywordQuery = QueryBuilder.createQuery(
        getFieldNames(1), keyword);
      allQuery.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    
    if ((min_price > 0.0F) || (max_price > 0.0F)) {
      Term begin_price = new Term("min_price", 
        StringHelper.floatToString(min_price));
      Term end_price = new Term("min_price", 
        StringHelper.floatToString(max_price));
      
      RangeQuery priceQuery = new RangeQuery(begin_price, end_price, true);
      allQuery.add(priceQuery, BooleanClause.Occur.MUST);
    }
    
    Term begin_mcount = new Term("merchant_count", "0");
    Term end_mcount = new Term("merchant_count", "99999999");
    RangeQuery mcountQuery = new RangeQuery(begin_mcount, end_mcount, true);
    allQuery.add(mcountQuery, BooleanClause.Occur.MUST);
    
    Sort sort = null;
    switch (sort_type)
    {

    case 101: 
      sort = new Sort(new SortField[] { new SortField("merchant_count", 4, true) });
      break;
    

    case 102: 
      sort = new Sort(new SortField[] { new SortField("min_price", 5, true) });
      order_type = 0;
      break;
    

    case 103: 
      sort = new Sort(new SortField[] { new SortField("min_price", 5, true) });
      order_type = 1;
      break;
    

    case 104: 
      sort = new Sort(new SortField[] { new SortField("comment_count", 4, true) });
      order_type = 0;
      break;
    

    case 105: 
      sort = new Sort(new SortField[] { new SortField("comment_count", 4, true) });
      order_type = 1;
      break;
    

    case 106: 
      sort = new Sort(new SortField[] { new SortField("merchant_count", 4, true) });
      order_type = 0;
      break;
    

    case 107: 
      sort = new Sort(new SortField[] { new SortField("merchant_count", 4, true) });
      order_type = 1;
      break;
    

    case 108: 
      sort = new Sort(new SortField[] { new SortField("prma_id", 4, true) });
      order_type = 0;
      break;
    

    case 109: 
      sort = new Sort(new SortField[] { new SortField("prma_id", 4, true) });
      order_type = 1;
      break;
    

    default: 
      sort = new Sort(new SortField[] { new SortField("merchant_count", 4, true) });
    }
    
    log.warn("type==" + type);
    if ((type.equals("diffPrmaidbrand")) || (type.equals("samePrmaidbrand"))) {
      pagination = searcher.searchabs(allQuery, null, this.topNum, sort, order_type, type, pm.getMin_price(), page_size, indexPath);
    } else {
      pagination = searcher.search(allQuery, null, this.topNum, pageParam, sort, order_type, indexPath);
    }
    ProductMasterResult pr = null;
    pr = ResultBuilder.getProductMasterResult(pagination);
    return pr;
  }
  






















  public Counter[] getProductBrandCounts(String keyword, int prso_id, int prbr_id, int prma_id, float min_price, float max_price, boolean searchlogic, String type)
  {
    Counter[] counters = (Counter[])null;
    
    long pretime = System.currentTimeMillis();
    
    keyword = StringHelper.getRealString(keyword);
    
    int order_type = 1;
    
    min_price = min_price < 0.0F ? 0.0F : min_price;
    min_price = min_price > 9999999.0F ? 9999999.0F : min_price;
    max_price = max_price < 0.0F ? 0.0F : max_price;
    max_price = max_price > 9999999.0F ? 9999999.0F : max_price;
    max_price = max_price < min_price ? min_price : max_price;
    pretime = System.currentTimeMillis();
    
    if ((!"".equals(keyword)) && (keyword.length() > 0)) {
      keyword = d9lietu.getNormalSegResultWithLogic(toLowerCase(keyword), searchlogic);
    }
    Pagination pagination = null;
    AbstractSearcher searcher = null;
    String indexPath = Environment.getProductMasterMain_Index_Dir();
    searcher = ProductMasterSearcher.getInstance();
    
    PageParam pageParam = new PageParam(1, 1);
    
    BooleanQuery allQuery = new BooleanQuery();
    ProductMaster pm = new ProductMaster();
    
    List fieldList = new ArrayList();
    List valueList = new ArrayList();
    List<BooleanClause.Occur> qflagsList = new ArrayList();
    if (type.equals("samebrand"))
    {
      if (prso_id > 0) {
        fieldList.add("prso_id");
        valueList.add(String.valueOf(prso_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      if (prbr_id > 0) {
        fieldList.add("prbr_id");
        valueList.add(String.valueOf(prbr_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      fieldList.add("prbr_id");
      valueList.add(String.valueOf(0));
      qflagsList.add(BooleanClause.Occur.MUST_NOT);
      
      if (prma_id > 0) {
        fieldList.add("prma_id");
        valueList.add(String.valueOf(prma_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
    } else if (type.equals("fightbrand")) {
      BooleanQuery query = new BooleanQuery();
      
      int tmpprso_id = prso_id;
      if (prso_id > 0)
      {
        Query mulquery = QueryBuilder.createQuery("prso_id", String.valueOf(prso_id));
        query.add(mulquery, BooleanClause.Occur.MUST);
        
        Sort sort = new Sort("prso_id", true);
        sort = new Sort(new SortField[] { new SortField("prso_id", 4, true) });
        order_type = 1;
        
        pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, order_type, indexPath);
        ProductMasterResult pr = null;
        pr = ResultBuilder.getProductMasterResult(pagination);
        Object[] result = (Object[])null;
        result = pr.getRecords();
        if (result != null) {
          for (int i = 0; i < result.length; i++) {
            pm = (ProductMaster)result[i];
          }
        }
        if (pm.getPrso_id() == prso_id) {
          prso_id = pm.getPrso_id_two();
        }
        searcher = ProductMasterSearcher.getInstance();
      }
      
      if (prso_id > 0) {
        fieldList.add("prso_id_two");
        valueList.add(String.valueOf(prso_id));
        qflagsList.add(BooleanClause.Occur.MUST);
        fieldList.add("prso_id");
        valueList.add(String.valueOf(tmpprso_id));
        qflagsList.add(BooleanClause.Occur.MUST_NOT);
      }
      
      if (prbr_id > 0) {
        fieldList.add("prbr_id");
        valueList.add(String.valueOf(prbr_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      if (prma_id > 0) {
        fieldList.add("prma_id");
        
        qflagsList.add(BooleanClause.Occur.MUST);
      }
    } else if ((type.equals("samePrmaidbrand")) || (type.equals("diffPrmaidbrand"))) {
      BooleanQuery query = new BooleanQuery();
      
      if (prma_id > 0)
      {
        Query mulquery = QueryBuilder.createQuery("prma_id", String.valueOf(prma_id));
        query.add(mulquery, BooleanClause.Occur.MUST);
        
        Sort sort = new Sort("prma_id", true);
        sort = new Sort(new SortField[] { new SortField("prma_id", 4, true) });
        order_type = 1;
        pagination = searcher.search(query, this.filter, this.topNum, pageParam, sort, order_type, indexPath);
        ProductMasterResult pr = null;
        pr = ResultBuilder.getProductMasterResult(pagination);
        Object[] result = (Object[])null;
        result = pr.getRecords();
        if (result != null) {
          for (int i = 0; i < result.length; i++) {
            pm = (ProductMaster)result[i];
          }
        }
      }
      if (pm != null)
      {
        prso_id = pm.getPrso_id();
        if (prso_id > 0) {
          fieldList.add("prso_id");
          valueList.add(String.valueOf(prso_id));
          qflagsList.add(BooleanClause.Occur.MUST);
        }
        
        if (type.equals("samePrmaidbrand"))
        {
          int tmpprbr_id = pm.getPrbr_id() > 0 ? pm.getPrbr_id() : -111;
          fieldList.add("prbr_id");
          valueList.add(String.valueOf(tmpprbr_id));
          qflagsList.add(BooleanClause.Occur.MUST);
        } else if (type.equals("diffPrmaidbrand")) {
          fieldList.add("prbr_id");
          valueList.add(String.valueOf(pm.getPrbr_id()));
          qflagsList.add(BooleanClause.Occur.MUST_NOT);
        }
        
        if (prma_id > 0) {
          fieldList.add("prma_id");
          valueList.add(String.valueOf(prma_id));
          qflagsList.add(BooleanClause.Occur.MUST_NOT);
        }
      }
    }
    else {
      if (prso_id > 0) {
        fieldList.add("prso_id");
        valueList.add(String.valueOf(prso_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      if (prbr_id > 0) {
        fieldList.add("prbr_id");
        valueList.add(String.valueOf(prbr_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
      
      if (prma_id > 0) {
        fieldList.add("prma_id");
        valueList.add(String.valueOf(prma_id));
        qflagsList.add(BooleanClause.Occur.MUST);
      }
    }
    if ((fieldList.size() == valueList.size() ? 1 : 0) == (qflagsList.size() > 0 ? 1 : 0)) {
      String[] fieldNames = new String[fieldList.size()];
      String[] word = new String[valueList.size()];
      BooleanClause.Occur[] flags = new BooleanClause.Occur[qflagsList.size()];
      
      for (int i = 0; i < fieldNames.length; i++) {
        fieldNames[i] = ((String)fieldList.get(i));
        word[i] = ((String)valueList.get(i));
        flags[i] = ((BooleanClause.Occur)qflagsList.get(i));
      }
      
      Query mulquery = QueryBuilder.createMulFieldQuery(word, fieldNames, flags);
      allQuery.add(mulquery, BooleanClause.Occur.MUST);
    }
    

    if (!"".equals(keyword)) {
      Query keywordQuery = QueryBuilder.createQuery(
        getFieldNames(1), keyword);
      allQuery.add(keywordQuery, BooleanClause.Occur.MUST);
    }
    
    if ((min_price > 0.0F) || (max_price > 0.0F)) {
      Term begin_price = new Term("min_price", 
        StringHelper.floatToString(min_price));
      Term end_price = new Term("min_price", 
        StringHelper.floatToString(max_price));
      
      RangeQuery priceQuery = new RangeQuery(begin_price, end_price, true);
      allQuery.add(priceQuery, BooleanClause.Occur.MUST);
    }
    

    Term begin_mcount = new Term("merchant_count", "0");
    Term end_mcount = new Term("merchant_count", "99999999");
    RangeQuery mcountQuery = new RangeQuery(begin_mcount, end_mcount, true);
    allQuery.add(mcountQuery, BooleanClause.Occur.MUST);
    
    Sort sort = null;
    
    if (type.endsWith("samebrand"))
    {



      sort = new Sort(new SortField[] {
        new SortField("prbr_id", 4, true), 
        new SortField("prbr_name", 3, true), 
        new SortField("prso_id_one", 4, true) });

    }
    else
    {

      sort = new Sort(new SortField[] {
        new SortField("prso_id", 4, true), 
        new SortField("prso_name", 3, true), 
        new SortField("prso_id_one", 4, true) });
    }
    
    pretime = System.currentTimeMillis();
    Filter filter = null;
    
    counters = searcher.getCounts(allQuery, filter, this.topNum, sort, indexPath);
    
    for (int i = 0; i < counters.length; i++) {
      if ((counters[i].getValue().trim().equals("0")) || (counters[i].getValue().trim().equals(""))) {
        counters[i].setExtend_value_one("暂无分类商品");
      }
    }
    if (counters != null) {
      for (int i = counters.length - 1; i > 1; i--) {
        for (int j = 0; j < i; j++)
          if (counters[j].getCount() < counters[(j + 1)].getCount()) {
            Counter tmp = counters[j];
            counters[j] = counters[(j + 1)];
            counters[(j + 1)] = tmp;
          }
      }
    }
    return counters;
  }
  
  public int testXFireSpeed()
  {
    return 0;
  }
  
  public static void main(String[] args) throws IOException {
    CommentResult pr = null;
    Comment[] pr1 = (Comment[])null;
    
    ISearchService service = new SearchService();
    pr = service.getComments("手机", 0, 6, 102, 1, 5, true);
    System.out.println(pr.getRecordCount());
  }
}
