package com.ding9.result.seq;

import com.ding9.entity.seq.Seq;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeqRS
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    Seq vo = new Seq();
    vo.setCurrval(rs.getInt("currval"));
    return vo;
  }
}
