package com.ding9.dao.collection;

import com.ding9.dao.sequences.SequencesDao;
import com.ding9.dao.sequences.SequencesDaoImpl;
import com.ding9.entity.collection.TagVO;
import com.ding9.entity.collection.UserTagVO;
import com.ding9.result.collection.UserTagRS;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import java.util.List;








public class UserTagDaoImpl
  implements UserTagDao
{
  TagDao tagDao = new TagDaoImpl();
  SequencesDao seqDao = new SequencesDaoImpl();
  






  public int addLabel(String lb_name, UserTagVO vo)
  {
    int exist = this.tagDao.findByName(lb_name);
    int flag = 0;
    if (exist > 0)
    {
      List list = checkTag(exist, vo.getUser_id(), vo.getType());
      if ((list != null) && (list.size() > 0)) {
        flag = 2;
      } else {
        vo.setLabel_id(exist);
        flag = insert(vo);
      }
    }
    else {
      TagVO lbVO = new TagVO();
      lbVO.setLb_name(lb_name);
      int lb = this.tagDao.insert(lbVO);
      vo.setLabel_id(lb);
      flag = insert(vo);
    }
    
    return flag;
  }
  





  public int delLabel(int pk)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "delete user_label where uslb_id=" + pk;
    int flag = dba.modifyData(sql);
    dba.closeConnection();
    return flag;
  }
  






  public int ModLabel(UserTagVO vo, String lb_name)
  {
    int flag = 0;
    int exist = this.tagDao.findByName(lb_name);
    if (exist > 0)
    {
      if (exist == vo.getLabel_id()) {
        return 1;
      }
      List list = checkTag(exist, vo.getUser_id(), vo.getType());
      if ((list != null) && (list.size() > 0)) {
        return 2;
      }
      vo.setLabel_id(exist);
      flag = modify(vo);
    }
    else {
      TagVO lbVO = new TagVO();
      lbVO.setLb_name(lb_name);
      int lb = this.tagDao.insert(lbVO);
      vo.setLabel_id(lb);
      flag = modify(vo);
    }
    return flag;
  }
  





  public List query(int user_id, int type)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new UserTagRS();
    String sql = "select ub.uslb_id,ub.uslb_id,ub.user_id,lb.lb_name from user_label ub,label lb where ub.label_id=lb.label_id and ub.type=" + 
      type + " and ub.user_id =" + user_id;
    List list = dba.queryData(sql, rs);
    dba.closeConnection();
    return list;
  }
  
  public int modify(UserTagVO vo)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "update user_label set label_id=" + vo.getLabel_id() + 
      " where uslb_id=" + vo.getUslb_id();
    int flag = dba.modifyData(sql);
    dba.closeConnection();
    return flag;
  }
  
  public int insert(UserTagVO vo)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "insert into user_label values(" + vo.getLabel_id() + 
      ",seq_user_label.nextval," + vo.getUser_id() + "," + 
      vo.getType() + ")";
    
    int flag = dba.modifyData(sql);
    dba.closeConnection();
    return flag;
  }
  
  public int add(UserTagVO vo)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    
    String sql = "insert into user_label values(" + vo.getLabel_id() + 
      ",seq_user_label.nextval," + vo.getUser_id() + "," + 
      vo.getType() + ")";
    
    int flag = dba.modifyData(sql);
    dba.closeConnection();
    int pk = this.seqDao.getSeqCurrval("seq_user_label");
    if (flag > 0) {
      return pk;
    }
    return flag;
  }
  
  public List checkTag(int label_id, int user_id, int type)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new UserTagRS();
    
    String sql = "select * from user_label where label_id=" + label_id + 
      " and user_id=" + user_id + " and type=" + type;
    
    List list = dba.queryData(sql, rs);
    dba.closeConnection();
    return list;
  }
  
  public int checkTag(String lb_name, int user_id, int type)
  {
    int uslb_id = 0;
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new UserTagRS();
    StringBuffer sql = new StringBuffer();
    
    sql.append("select uslb_id from label lb left join user_label ul on lb.label_id=ul.label_id");
    sql.append(" where 1=1");
    sql.append(" and lb.lb_name ='" + lb_name + "'");
    sql.append(" and ul.user_id=" + user_id + " and ul.type=" + type);
    List list = dba.queryData(sql.toString(), rs);
    dba.closeConnection();
    
    if (list.size() > 0)
    {
      for (int i = 0; i < list.size(); i++) {
        UserTagVO vo = (UserTagVO)list.get(0);
        uslb_id = vo.getUslb_id();
      }
    }
    

    return uslb_id;
  }
  
  public UserTagVO findByPk(int pk)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new UserTagRS();
    String sql = "select * from user_label where uslb_id=" + pk;
    List list = dba.queryData(sql, rs);
    dba.closeConnection();
    UserTagVO vo = new UserTagVO();
    
    if ((list != null) && (list.size() > 0)) {
      vo = (UserTagVO)list.get(0);
    }
    return vo;
  }
}
