package com.ding9.result.article;

import com.ding9.entity.article.Article;
import com.ding9.sql.BaseResult;
import com.ding9.util.DateHelper;
import com.ding9.util.Environment;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleInfo implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    Article enti = new Article();
    try {
      enti.setContent(rs.getString("content"));
    } catch (Exception localException) {}
    try {
      enti.setTitle(StringHelper.getSubString(rs.getString("title"), 36));
    } catch (Exception localException1) {}
    try {
      enti.setUrl(rs.getString("url"));
    } catch (Exception localException2) {}
    try {
      enti.setMemtId(rs.getInt("memt_id"));
    } catch (Exception localException3) {}
    try {
      enti.setDisplay(rs.getInt("display"));
    } catch (Exception localException4) {}
    try {
      enti.setArticleId(rs.getInt("article_id"));
    } catch (Exception localException5) {}
    try {
      enti.setSourceType(rs.getString("source_type"));
    } catch (Exception localException6) {}
    try {
      enti.setReleaseTime(DateHelper.toString(rs.getTimestamp("release_time"), "yyyy-MM-dd"));
    } catch (Exception localException7) {}
    try {
      enti.setPicture(Environment.getImageServer() + rs.getString("picture"));
    } catch (Exception localException8) {}
    try {
      enti.setSortName(rs.getString("sort_name"));
    } catch (Exception localException9) {}
    try {
      enti.setRelationValue(rs.getInt("relation_value"));
    } catch (Exception localException10) {}
    try {
      enti.setSource(rs.getString("source"));
    } catch (Exception localException11) {}
    try {
      enti.setAuthor(rs.getString("author"));
    } catch (Exception localException12) {}
    try {
      enti.setPagination_sign(rs.getString("pagination_sign"));
    } catch (Exception localException13) {}
    try {
      enti.setPrsoIdOne(rs.getInt("prso_id_one"));
    } catch (Exception localException14) {}
    try {
      enti.setPrsoNameOneEn(rs.getString("prso_name_one_en"));
    } catch (Exception localException15) {}
    return enti;
  }
}
