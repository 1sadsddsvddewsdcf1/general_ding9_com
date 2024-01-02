package com.ding9.result.sequences;

import com.ding9.entity.sequences.SequencesVO;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequencesRS
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    SequencesVO vo = new SequencesVO();
    try {
      vo.setCurrval(rs.getInt("currval"));
    }
    catch (Exception localException) {}
    
    try
    {
      vo.setNextval(rs.getInt("nextval"));
    }
    catch (Exception localException1) {}
    
    return vo;
  }
}
