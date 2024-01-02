package com.ding9.result.product.parameter;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import org.apache.log4j.Logger;









public class ProductParameterValueResult
  implements BaseResult
{
  private static Logger log = Logger.getLogger(ProductParameterValueResult.class);
  

  HashMap hm = null;
  ResultSetMetaData rsmd = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.hm = new HashMap();
    int columnCount = 0;
    String key = null;
    String value = null;
    if (resultset != null) {
      this.rsmd = resultset.getMetaData();
      columnCount = this.rsmd.getColumnCount();
      for (int col = 1; col <= columnCount; col++) {
        key = this.rsmd.getColumnName(col).toString().toLowerCase();
        value = resultset.getString(col);
        if (value != null) value = value.trim();
        this.hm.put(key, value);
      }
    }
    
    return this.hm;
  }
}
