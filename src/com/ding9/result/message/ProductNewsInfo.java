package com.ding9.result.message;

import com.ding9.entity.message.NewProductNews;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;







public class ProductNewsInfo
  implements BaseResult
{
  private NewProductNews message = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.message = new NewProductNews();
    this.message.setPrso_title(resultset.getString("prso_title"));
    this.message.setNews_from(resultset.getString("news_from"));
    this.message.setSyne_time(resultset.getString("syne_time"));
    this.message.setPrso_counnet(StringHelper.outputStrToHtml(resultset.getString("prso_counnet")));
    
    return this.message;
  }
}
