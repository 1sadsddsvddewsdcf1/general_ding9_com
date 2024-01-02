package com.ding9.result.indexkey;

import com.ding9.entity.indexkey.KeywordsOptimize;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;










public class KeyWordsOptimizeInfo
  implements BaseResult
{
  private KeywordsOptimize kw = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException { this.kw = new KeywordsOptimize();
    this.kw.setKeot_id(resultset.getInt("keot_id"));
    this.kw.setKeop_title(resultset.getString("keop_title"));
    this.kw.setKeop_keywords(resultset.getString("keop_keywords"));
    this.kw.setKeop_description(resultset.getString("keop_description"));
    return this.kw;
  }
}
