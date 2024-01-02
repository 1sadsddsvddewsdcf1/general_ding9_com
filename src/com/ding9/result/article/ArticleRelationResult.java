package com.ding9.result.article;

import com.ding9.entity.article.ArticleRelation;
import com.ding9.sql.BaseResult;
import com.ding9.util.DateHelper;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRelationResult implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    ArticleRelation articleRelation = new ArticleRelation();
    
    articleRelation.setArticle_id(rs.getInt("article_id"));
    articleRelation.setTitle(rs.getString("title"));
    articleRelation.setMemt_id(rs.getInt("memt_id"));
    articleRelation.setSource_type(rs.getString("source_type"));
    articleRelation.setRelease_time(DateHelper.toString(rs.getTimestamp("release_time"), "yyyy-MM-dd"));
    articleRelation.setUrl(rs.getString("url"));
    articleRelation.setSource(rs.getString("source"));
    articleRelation.setAuthor(rs.getString("author"));
    articleRelation.setSource_relation_type(rs.getString("source_relation_type"));
    articleRelation.setSource_relation_value(rs.getString("source_relation_value"));
    articleRelation.setContent(StringHelper.outputStrToHtml(rs.getString("content")));
    articleRelation.setDisplay(rs.getInt("display"));
    articleRelation.setPagination_sign(rs.getString("pagination_sign"));
    try
    {
      articleRelation.setPrso_id_one(rs.getInt("prso_id_one"));
    } catch (Exception localException) {}
    try {
      articleRelation.setPrso_name_one_en(rs.getString("prso_name_one_en"));
    } catch (Exception localException1) {}
    return articleRelation;
  }
}
