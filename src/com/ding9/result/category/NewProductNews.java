package com.ding9.result.category;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewProductNews
  implements BaseResult
{
  private com.ding9.entity.category.NewProductNews newProductNews = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.newProductNews = new com.ding9.entity.category.NewProductNews();
    this.newProductNews.setAuto_id(resultset.getInt("auto_id"));
    this.newProductNews.setPrso_id_one(resultset.getInt("prso_id_one"));
    this.newProductNews.setPrma_id(resultset.getInt("prma_id"));
    this.newProductNews.setPrso_title(resultset.getString("prso_title"));
    this.newProductNews.setNews_from(resultset.getString("news_from"));
    this.newProductNews.setPrso_counnet(resultset.getString("prso_counnet"));
    this.newProductNews.setSyne_time(resultset.getDate("syne_time"));
    
    return this.newProductNews;
  }
}
