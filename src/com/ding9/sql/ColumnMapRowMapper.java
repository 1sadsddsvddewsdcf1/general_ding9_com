package com.ding9.sql;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;








public class ColumnMapRowMapper
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    Map mapOfColValues = new HashMap(columnCount);
    for (int i = 1; i <= columnCount; i++) {
      String key = rsmd.getColumnName(i).toString();
      Object obj = getResultSetValue(rs, i);
      mapOfColValues.put(key, obj);
    }
    return mapOfColValues;
  }
  
  public static Object getResultSetValue(ResultSet rs, int index) throws SQLException {
    Object obj = rs.getObject(index);
    if ((obj instanceof Blob)) {
      obj = rs.getBytes(index);
    }
    else if ((obj instanceof Clob)) {
      obj = rs.getString(index);
    }
    else if ((obj != null) && (obj.getClass().getName().startsWith("oracle.sql.TIMESTAMP"))) {
      obj = rs.getTimestamp(index);
    }
    else if ((obj != null) && (obj.getClass().getName().startsWith("oracle.sql.DATE"))) {
      String metaDataClassName = rs.getMetaData().getColumnClassName(index);
      if (("java.sql.Timestamp".equals(metaDataClassName)) || 
        ("oracle.sql.TIMESTAMP".equals(metaDataClassName))) {
        obj = rs.getTimestamp(index);
      }
      else {
        obj = rs.getDate(index);
      }
    }
    else if ((obj != null) && ((obj instanceof Date)) && 
      ("java.sql.Timestamp".equals(rs.getMetaData().getColumnClassName(index)))) {
      obj = rs.getTimestamp(index);
    }
    
    return obj;
  }
}
