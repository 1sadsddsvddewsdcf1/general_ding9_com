package com.ding9.dao.collection;

import com.ding9.dao.sequences.SequencesDao;
import com.ding9.dao.sequences.SequencesDaoImpl;
import com.ding9.entity.collection.TagVO;
import com.ding9.result.collection.TagRS;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import java.util.List;






public class TagDaoImpl
  implements TagDao
{
  SequencesDao seqDao = new SequencesDaoImpl();
  




  public int insert(TagVO vo)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "insert into label values(seq_label.nextval,'" + vo.getLb_name() + "')";
    int flag = dba.modifyData(sql);
    dba.closeConnection();
    int pk = this.seqDao.getSeqCurrval("seq_label");
    if (flag > 0) {
      return pk;
    }
    return flag;
  }
  




  public int update(TagVO vo)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "update label set lb_name='" + vo.getLb_name() + "' where label_id=" + vo.getLabel_id();
    int flag = dba.modifyData(sql);
    dba.closeConnection();
    return flag;
  }
  





  public int findByName(String lb_name)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new TagRS();
    String sql = "select * from label where lb_name='" + lb_name.trim() + "'";
    List list = dba.queryData(sql, rs);
    dba.closeConnection();
    TagVO vo = new TagVO();
    vo.setLabel_id(0);
    if ((list != null) && (list.size() > 0)) {
      vo = (TagVO)list.get(0);
    }
    return vo.getLabel_id();
  }
}
