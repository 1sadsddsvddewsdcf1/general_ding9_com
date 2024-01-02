package com.ding9.result.article;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageManageType implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    com.ding9.entity.article.MessageManageType entity = new com.ding9.entity.article.MessageManageType();
    
    entity.setMemt_id(rs.getInt("memt_id"));
    entity.setPrso_id_one(rs.getInt("prso_id_one"));
    entity.setMemt_name(rs.getString("memt_name"));
    
    return entity;
  }
}
