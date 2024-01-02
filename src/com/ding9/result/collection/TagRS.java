package com.ding9.result.collection;

import com.ding9.entity.collection.TagVO;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;




public class TagRS
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    TagVO vo = new TagVO();
    try
    {
      vo.setLabel_id(rs.getInt("label_id"));
    }
    catch (Exception localException) {}
    try {
      vo.setLb_name(rs.getString("lb_name"));
    }
    catch (Exception localException1) {}
    return vo;
  }
}
