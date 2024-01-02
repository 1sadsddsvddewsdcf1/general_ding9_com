package com.ding9.result.indexkey;

import com.ding9.entity.indexkey.IndexKey;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class IndexKeyInfo
  implements BaseResult
{
  private IndexKey indexkey = null;
  


  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.indexkey = new IndexKey();
    

    this.indexkey.setText(resultset.getString("text"));
    
    this.indexkey.setKeyWord(resultset.getString("keyWord"));
    

    return this.indexkey;
  }
}
