package com.ding9.result.indexkey;

import com.ding9.entity.indexkey.keyWord;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class KeyWordInfo
  implements BaseResult
{
  private keyWord kw = null;
  


  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.kw = new keyWord();
    this.kw.setKeyword(resultset.getString("hot_keyword"));
    
    return this.kw;
  }
}
