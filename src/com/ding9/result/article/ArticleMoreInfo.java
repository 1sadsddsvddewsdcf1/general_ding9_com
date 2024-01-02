package com.ding9.result.article;

import com.ding9.entity.article.Article;
import com.ding9.sql.BaseResult;
import com.ding9.util.DateHelper;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMoreInfo implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    Article enti = new Article();
    enti.setArticleId(rs.getInt("article_id"));
    enti.setTitle(StringHelper.getSubString(rs.getString("title"), 34));
    enti.setUrl(rs.getString("url"));
    enti.setMemtId(rs.getInt("memt_id"));
    enti.setReleaseTime(DateHelper.toString(rs.getTimestamp("release_time"), "yyyy-MM-dd"));
    enti.setDisplay(rs.getInt("display"));
    return enti;
  }
}
