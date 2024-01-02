package com.ding9.dao.article;

import com.ding9.entity.article.Article;
import com.ding9.entity.article.ArticleRelation;
import com.ding9.entity.articlesort.ArticleSort;
import com.ding9.result.article.ArticleInfo;
import com.ding9.result.article.ArticleRelationResult;
import com.ding9.result.article.ArticleSortList;
import com.ding9.result.productsort.ProductSort;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import com.ding9.util.StringHelper;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ArticleManageDaoImpl
  implements ArticleManageDao
{
  private static final Log log = LogFactory.getLog(ArticleManageDaoImpl.class);
  private IDBAccess dba = null;
  private String sql = null;
  private static long lasttime = System.currentTimeMillis();
  private static List results = null;
  




  public List getArticleForIndex(int cnt)
  {
    if ((results == null) || (System.currentTimeMillis() - lasttime > 3600000L))
    {
      this.dba = new DBAccessDefaultlImpl();
      ArticleSortList map = new ArticleSortList();
      this.dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
      this.sql = " SELECT MEMT_ID, PRSO_ID_ONE, SORT_NAME FROM ARTICLE_SORT WHERE  PRSO_ID_ONE=?  ";
      results = this.dba.queryData(this.sql, map);
      this.dba.closeConnection();
      if ((results != null) && (results.size() > 0))
      {
        for (int i = 0; i < results.size(); i++) {
          ArticleSort memt = (ArticleSort)results.get(i);
          memt.setArticle(getArticleDetail(memt.getMemtId(), cnt));
          results.set(i, memt);
        }
      }
      
      this.sql = null;
      map = null;
      lasttime = System.currentTimeMillis();
    }
    return results;
  }
  





  private List getArticleDetail(int memt_id, int end)
  {
    List result = null;
    StringBuffer select = new StringBuffer();
    
    this.dba = new DBAccessDefaultlImpl();
    
    ArticleInfo impl = new ArticleInfo();
    
    select.append("SELECT M.article_id,title,memt_id,source_type,release_time,url,source,author,source_relation_type,source_relation_value,content,display ");
    select.append(",decode(sign(m.memt_id-0),1,nvl((SELECT ar.prso_id_one from article_sort ar WHERE ar.memt_id =m.memt_id and rownum=1),0),0) as prso_id_one ");
    select.append(",decode(sign(m.memt_id-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =(SELECT ar.prso_id_one from article_sort ar WHERE ar.memt_id =m.memt_id) and rownum=1),''),'') as prso_name_one_en ");
    select.append("FROM article M,article_relation D WHERE M.article_id=D.article_id AND memt_id=? AND D.relation_type=1 AND D.relation_value=? ORDER BY D.show_order desc,M.article_id desc ");
    this.dba.setParam(new SQLParam(1, 1, memt_id));
    this.dba.setParam(new SQLParam(2, 1, Environment.getChannelId()));
    
    if (end > 0) {
      result = this.dba.queryDataPagination(select.toString(), impl, end, 1);
    } else {
      result = this.dba.queryData(select.toString(), impl);
    }
    this.dba.closeConnection();
    return result;
  }
  



  public List getArticleForIndex(int memt_id, int cnt, int reltype, int relvalue)
  {
    List rst = null;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(new SQLParam(1, 1, memt_id));
    this.dba.setParam(new SQLParam(2, 1, reltype));
    this.dba.setParam(new SQLParam(3, 1, relvalue));
    
    ArticleInfo map = new ArticleInfo();
    this.sql = "SELECT M.article_id,title,memt_id,source_type,release_time,url,source,author,source_relation_type,source_relation_value,content,display FROM article M,article_relation D WHERE M.article_id=D.article_id AND memt_id=? AND D.relation_type=? AND D.relation_value=? ORDER BY D.show_order desc,M.article_id desc";
    if (cnt < 1) {
      rst = this.dba.queryData(this.sql, map);
    } else {
      rst = this.dba.queryDataPagination(this.sql, map, cnt, 1);
    }
    

    this.sql = null;
    map = null;
    

    return rst;
  }
  







  public List getArticleForIndex(int memt_id, int cnt, int reltype, String relvalue)
  {
    List rst = null;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(new SQLParam(1, 1, memt_id));
    this.dba.setParam(new SQLParam(2, 1, reltype));
    
    ArticleInfo map = new ArticleInfo();
    
    this.sql = ("SELECT M.article_id,title,memt_id,source_type,release_time,url,source,author,source_relation_type,source_relation_value,content,display,D.relation_value,decode(sign(D.relation_value-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =D.relation_value and rownum=1),''),'') as prso_name_one_en FROM article M,article_relation D WHERE M.article_id=D.article_id AND memt_id=? AND D.relation_type=? AND D.relation_value in (" + relvalue + ") ORDER BY D.show_order desc,M.article_id desc ");
    if (cnt < 1) {
      rst = this.dba.queryData(this.sql, map);
    } else {
      rst = this.dba.queryDataPagination(this.sql, map, cnt, 1);
    }
    this.dba.closeConnection();
    this.sql = null;
    map = null;
    return rst;
  }
  
  public List getArticleList(int memt_id, int display, int currPage, int size) {
    List result = null;
    StringBuffer select = new StringBuffer();
    this.dba = new DBAccessDefaultlImpl();
    ArticleInfo impl = new ArticleInfo();
    select.append("SELECT M.SORT_NAME,D.ARTICLE_ID,D.TITLE,D.DISPLAY,D.MEMT_ID,D.RELEASE_TIME,D.URL,D.PICTURE FROM ARTICLE D LEFT JOIN ARTICLE_SORT M ON M.MEMT_ID=D.MEMT_ID WHERE  M.MEMT_ID=? AND D.MEMT_ID=? ");
    if (display == 2)
    {
      select.append(" AND D.DISPLAY=? ");
      this.dba.setParam(new SQLParam(3, 1, display));
    }
    else if (display == 0) {
      select.append(" AND D.DISPLAY!=2 "); }
    select.append("  ORDER BY ARTICLE_ID DESC ");
    this.dba.setParam(new SQLParam(1, 1, memt_id));
    this.dba.setParam(new SQLParam(2, 1, memt_id));
    result = this.dba.queryDataPagination(select.toString(), impl, size, currPage);
    this.dba.closeConnection();
    return result;
  }
  





  public List getMessageManageTypeArticle(int memt_id, int prso_id_one, int start, int end)
  {
    StringBuffer select = new StringBuffer();
    List result = null;
    List rs = null;
    this.dba = new DBAccessDefaultlImpl();
    
    com.ding9.result.article.MessageManageType impl = new com.ding9.result.article.MessageManageType();
    if (memt_id == 0) {
      select.append("SELECT MEMT_ID,PRSO_ID_ONE,SORT_NAME AS MEMT_NAME FROM ARTICLE_SORT WHERE PRSO_ID_ONE=? ");
    } else {
      select.append("SELECT MEMT_ID,PRSO_ID_ONE,SORT_NAME AS MEMT_NAME FROM ARTICLE_SORT WHERE PRSO_ID_ONE=? AND MEMT_ID!=? ");
    }
    this.dba.setParam(new SQLParam(1, 1, prso_id_one));
    if (memt_id != 0) {
      this.dba.setParam(new SQLParam(2, 1, memt_id));
    }
    if (log.isInfoEnabled()) { log.info(select.toString());
    }
    result = this.dba.queryData(select.toString(), impl);
    if ((result != null) && (result.size() > 0)) {
      for (int i = 0; i < result.size(); i++) {
        com.ding9.entity.article.MessageManageType messageManageType = (com.ding9.entity.article.MessageManageType)result.get(i);
        rs = getArticleRelation(messageManageType.getMemt_id(), start, end);
        if ((rs != null) && (rs.size() > 0)) {
          messageManageType.setArticle_relation(rs);
          messageManageType.setArticle_size(rs.size());
          result.set(i, messageManageType);
        }
      }
    }
    
    select = null;
    
    return result;
  }
  





  public List getMessageManageTypeArticle(int memt_id, int start, int end)
  {
    StringBuffer select = new StringBuffer();
    List result = null;
    List rs = null;
    this.dba = new DBAccessDefaultlImpl();
    
    com.ding9.result.article.MessageManageType impl = new com.ding9.result.article.MessageManageType();
    if (memt_id == 0) {
      select.append("SELECT MEMT_ID,PRSO_ID_ONE,SORT_NAME AS MEMT_NAME FROM ARTICLE_SORT WHERE PRSO_ID_ONE=? ");
    } else {
      select.append("SELECT MEMT_ID,PRSO_ID_ONE,SORT_NAME AS MEMT_NAME FROM ARTICLE_SORT WHERE PRSO_ID_ONE=? AND MEMT_ID!=? ");
    }
    this.dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
    if (memt_id != 0) {
      this.dba.setParam(new SQLParam(2, 1, memt_id));
    }
    result = this.dba.queryData(select.toString(), impl);
    if ((result != null) && (result.size() > 0)) {
      for (int i = 0; i < result.size(); i++) {
        com.ding9.entity.article.MessageManageType messageManageType = (com.ding9.entity.article.MessageManageType)result.get(i);
        rs = getArticleRelation(messageManageType.getMemt_id(), start, end);
        if ((rs != null) && (rs.size() > 0)) {
          messageManageType.setArticle_relation(rs);
          messageManageType.setArticle_size(rs.size());
          result.set(i, messageManageType);
        }
      }
    }
    
    select = null;
    
    return result;
  }
  





  public List getMessageManageTypeByArticleId(int article_id)
  {
    StringBuffer select = new StringBuffer();
    List result = null;
    
    this.dba = new DBAccessDefaultlImpl();
    
    com.ding9.result.article.MessageManageType impl = new com.ding9.result.article.MessageManageType();
    
    select.append("SELECT  MEMT_ID,PRSO_ID_ONE,SORT_NAME AS MEMT_NAME FROM ARTICLE_SORT WHERE EXISTS (SELECT 'A' FROM ARTICLE WHERE ARTICLE.MEMT_ID=ARTICLE_SORT.MEMT_ID AND ARTICLE_ID=?) ");
    this.dba.setParam(new SQLParam(1, 1, article_id));
    
    result = this.dba.queryData(select.toString(), impl);
    
    this.dba.closeConnection();
    select = null;
    
    return result;
  }
  





  public List getMessageManageTypeArticle(int memt_id)
  {
    StringBuffer select = new StringBuffer();
    List result = null;
    
    this.dba = new DBAccessDefaultlImpl();
    
    com.ding9.result.article.MessageManageType impl = new com.ding9.result.article.MessageManageType();
    
    select.append("SELECT  MEMT_ID,PRSO_ID_ONE,SORT_NAME AS MEMT_NAME FROM ARTICLE_SORT WHERE MEMT_ID=? ");
    this.dba.setParam(new SQLParam(1, 1, memt_id));
    
    result = this.dba.queryData(select.toString(), impl);
    
    this.dba.closeConnection();
    select = null;
    
    return result;
  }
  




  public List getProductSortByArticleId(int article_id)
    throws SQLException
  {
    List result = null;
    StringBuffer sql = new StringBuffer();
    
    BaseResult index = new ProductSort();
    try {
      this.dba = new DBAccessDefaultlImpl();
      sql.append("SELECT prso_id,prso_id_one,prso_id_two,prso_id_three,prso_name_one,prso_name_two,prso_name_three,prso_table_name,prso_nadir_num,prso_small_num,prso_rake,prso_address,prso_parameter,criterion_flag,prso_label FROM product_sort WHERE prso_id_two=0 AND prso_id_three=0 AND prso_id_one =(SELECT prso_id_one FROM article_sort WHERE memt_id=(SELECT DISTINCT memt_id FROM article WHERE article_id=?))");
      this.dba.setParam(new SQLParam(1, 1, article_id));
      
      result = this.dba.queryDataPagination(sql.toString(), index, 1, 1);
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql.toString());
      }
    }
    finally {
      this.dba.closeConnection();
      index = null;
      sql = null;
    }
    return result;
  }
  





  public List getProductSort(int prso_id_one)
    throws SQLException
  {
    List result = null;
    StringBuffer sql = new StringBuffer();
    
    BaseResult index = new ProductSort();
    try {
      this.dba = new DBAccessDefaultlImpl();
      sql.append("SELECT prso_id,prso_id_one,prso_id_two,prso_id_three,prso_name_one,prso_name_two,prso_name_three,prso_table_name,prso_nadir_num,prso_small_num,prso_rake,prso_address,prso_parameter,criterion_flag,prso_label FROM product_sort WHERE prso_id_two=0 AND prso_id_three=0 AND prso_id_one =(SELECT prso_id_one FROM article_sort WHERE memt_id=?)");
      this.dba.setParam(new SQLParam(1, 1, prso_id_one));
      
      result = this.dba.queryDataPagination(sql.toString(), index, 1, 1);
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("出错信息 : " + ex.getMessage());
        log.error("执行语句 : " + sql.toString());
      }
    }
    finally {
      this.dba.closeConnection();
      index = null;
      sql = null;
    }
    return result;
  }
  






  private List getArticleRelation(int memt_id, int start, int end)
  {
    List result = null;
    StringBuffer select = new StringBuffer();
    
    this.dba = new DBAccessDefaultlImpl();
    
    ArticleRelationResult impl = new ArticleRelationResult();
    select.append("SELECT M.article_id,title,memt_id,source_type,release_time,url,source,author,source_relation_type,source_relation_value,content,display,pagination_sign FROM article M,article_relation D WHERE M.article_id=D.article_id AND memt_id=?  ORDER BY D.article_id desc ");
    
    if (end > 0) {
      select = new StringBuffer();
      
      select.append(" SELECT * FROM (SELECT ROWNUM AS SEQ,CC.* FROM (");
      select.append(" SELECT M.article_id,title,memt_id,source_type,release_time,url,source,author,source_relation_type,source_relation_value,content,display,pagination_sign FROM article M,article_relation D WHERE M.article_id=D.article_id AND memt_id=?  ORDER BY D.article_id desc");
      select.append(" )CC)BB");
      select.append(" WHERE SEQ>=" + start + " AND SEQ<=" + end);
    }
    

    this.dba.setParam(new SQLParam(1, 1, memt_id));
    

    result = this.dba.queryData(select.toString(), impl);
    if ((result != null) && (result.size() > 0)) {
      for (int i = 0; i < result.size(); i++) {
        ArticleRelation articleRelation = (ArticleRelation)result.get(i);
        articleRelation.setTitle(StringHelper.getSubString(articleRelation.getTitle(), 28));
        result.set(i, articleRelation);
      }
    }
    
    this.dba.closeConnection();
    select = null;
    
    return result;
  }
  




  public List getArticleInfo(int memt_id, int article_id, int relation_type, int relation_value, int page_size, int current_page)
  {
    List result = null;
    StringBuffer select = new StringBuffer();
    
    this.dba = new DBAccessDefaultlImpl();
    
    ArticleRelationResult impl = new ArticleRelationResult();
    select.append("SELECT M.article_id,M.title,M.memt_id,M.source_type,M.release_time,M.url,M.source,M.author,M.source_relation_type,M.source_relation_value,M.content,M.display,M.pagination_sign ");
    select.append(",decode(sign(m.memt_id-0),1,nvl((SELECT ar.prso_id_one from article_sort ar WHERE ar.memt_id =m.memt_id and rownum=1),0),0) as prso_id_one ");
    select.append(",decode(sign(m.memt_id-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =(SELECT ar.prso_id_one from article_sort ar WHERE ar.memt_id =m.memt_id) and rownum=1),''),'') as prso_name_one_en ");
    select.append("FROM article M,article_relation D ");
    select.append("WHERE  M.article_id=D.article_id ");
    if (article_id > 0) {
      select.append(" AND M.article_id='" + article_id + "' ");
      select.append(" AND D.article_id='" + article_id + "' ");
    }
    if (memt_id > 0)
    {

      select.append(" AND M.memt_id=" + memt_id + " ");
    }
    if (relation_type > 0)
      select.append(" AND D.relation_type=" + relation_type);
    if (relation_value > 0)
      select.append(" AND D.relation_value=" + relation_value);
    if (article_id == 0) { select.append(" ORDER BY M.article_id DESC ");
    }
    result = this.dba.queryDataPagination(select.toString(), impl, page_size, current_page);
    this.dba.closeConnection();
    select = null;
    if ((article_id > 0) && 
      (result != null) && (result.size() > 0)) {
      ArticleRelation articleRelation = (ArticleRelation)result.get(0);
      
      String content = articleRelation.getContent();
      String pagination_sign = articleRelation.getPagination_sign();
      
      if ((content != null) && (!"".equals(content))) {
        String[] result1 = content.split(pagination_sign);
        articleRelation.setTotal_page(result1.length);
        if (current_page > result1.length) {
          articleRelation.setContent_curr_page(result1[0]);
        } else {
          articleRelation.setContent_curr_page(result1[(current_page - 1)]);
        }
      }
    }
    
    return result;
  }
  
  public List getArticleInfo(int article_id, int page_size, int current_page) {
    List result = null;
    StringBuffer select = new StringBuffer();
    this.dba = new DBAccessDefaultlImpl();
    ArticleInfo impl = new ArticleInfo();
    select.append("SELECT D.SORT_NAME,M.ARTICLE_ID,M.TITLE,M.MEMT_ID,M.SOURCE_TYPE,M.RELEASE_TIME,M.URL,M.SOURCE,M.AUTHOR,M.SOURCE_RELATION_TYPE,M.SOURCE_RELATION_VALUE,M.CONTENT,M.DISPLAY,M.PAGINATION_SIGN,M.PICTURE");
    select.append(" FROM ARTICLE M LEFT JOIN ARTICLE_SORT D ON M.MEMT_ID=D.MEMT_ID");
    select.append(" WHERE M.ARTICLE_ID= ?");
    this.dba.setParam(new SQLParam(1, 1, article_id));
    result = this.dba.queryData(select.toString(), impl);
    this.dba.closeConnection();
    select = null;
    if ((article_id > 0) && (result != null) && (result.size() > 0))
    {
      Article article = (Article)result.get(0);
      String content = article.getContent();
      String pagination_sign = article.getPagination_sign();
      if ((content != null) && (!"".equals(content)))
      {
        String[] result1 = content.split(pagination_sign);
        article.setTotal_page(result1.length);
        if (current_page > result1.length) {
          article.setContent_curr_page(result1[0]);
        } else
          article.setContent_curr_page(result1[(current_page - 1)]);
      }
    }
    return result;
  }
  
  public List getDzftArticleList(int memt_id) {
    List result = null;
    StringBuffer select = new StringBuffer();
    this.dba = new DBAccessDefaultlImpl();
    ArticleInfo impl = new ArticleInfo();
    select.append("SELECT m.sort_name,d.article_id,d.title,d.display,d.memt_id,d.release_time,d.content,d.url,d.picture FROM article d LEFT JOIN article_sort m ON m.memt_id=d.memt_id WHERE m.memt_id=? AND d.memt_id=? AND display=2 ORDER BY article_id DESC ");
    this.dba.setParam(new SQLParam(1, 1, memt_id));
    this.dba.setParam(new SQLParam(2, 1, memt_id));
    result = this.dba.queryData(select.toString(), impl);
    if (log.isInfoEnabled()) { log.info(select.toString());
    }
    return result;
  }
  
  public List getInfoArticleList(int memt_id, int article_id, int currPage, int size) {
    List result = null;
    StringBuffer select = new StringBuffer();
    this.dba = new DBAccessDefaultlImpl();
    ArticleInfo impl = new ArticleInfo();
    select.append("SELECT M.SORT_NAME,D.ARTICLE_ID,D.TITLE,D.MEMT_ID,D.RELEASE_TIME,URL,D.DISPLAY,D.PICTURE FROM ARTICLE D LEFT JOIN ARTICLE_SORT M ON M.MEMT_ID=D.MEMT_ID  WHERE M.MEMT_ID=? AND D.MEMT_ID=?  ORDER BY ARTICLE_ID DESC ");
    this.dba.setParam(new SQLParam(1, 1, memt_id));
    this.dba.setParam(new SQLParam(2, 1, memt_id));
    result = this.dba.queryDataPagination(select.toString(), impl, size, currPage);
    
    return result;
  }
}
