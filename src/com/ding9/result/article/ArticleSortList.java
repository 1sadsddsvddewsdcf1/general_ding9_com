package com.ding9.result.article;

import com.ding9.entity.articlesort.ArticleSort;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleSortList implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    ArticleSort enti = new ArticleSort();
    enti.setMemtId(rs.getInt("memt_id"));
    enti.setPrso_id_one(rs.getInt("prso_id_one"));
    enti.setMemtName(rs.getString("sort_name"));
    return enti;
  }
}
