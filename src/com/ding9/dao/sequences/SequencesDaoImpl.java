package com.ding9.dao.sequences;

import com.ding9.entity.sequences.SequencesVO;
import com.ding9.result.sequences.SequencesRS;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import java.util.List;





public class SequencesDaoImpl
  implements SequencesDao
{
  public int getSeqCurrval(String seq)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new SequencesRS();
    String sql = "select " + seq + ".currval from dual";
    
    List list = dba.queryData(sql, rs);
    dba.closeConnection();
    int currval = 0;
    SequencesVO vo = new SequencesVO();
    if ((list != null) && (list.size() > 0)) {
      vo = (SequencesVO)list.get(0);
      currval = vo.getCurrval();
    }
    
    return currval;
  }
  


  public int getSeqNextval(String seq)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new SequencesRS();
    String sql = "select " + seq + ".nextval from dual";
    List list = dba.queryData(sql, rs);
    dba.closeConnection();
    int nextval = 0;
    
    SequencesVO vo = new SequencesVO();
    if ((list != null) && (list.size() > 0)) {
      vo = (SequencesVO)list.get(0);
      nextval = vo.getNextval();
    }
    
    return nextval;
  }
}
