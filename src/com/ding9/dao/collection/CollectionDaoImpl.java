package com.ding9.dao.collection;

import com.ding9.entity.collection.CollectionVO;
import com.ding9.entity.collection.TagVO;
import com.ding9.entity.collection.UserTagVO;
import com.ding9.result.collection.CollectionRS;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.io.PrintStream;
import java.util.List;







public class CollectionDaoImpl
  implements CollectionDao
{
  UserTagDao userTagDao = new UserTagDaoImpl();
  TagDao tagDao = new TagDaoImpl();
  

  public int saveCollection(CollectionVO vo)
  {
    List list = isCollection(vo.getCollection_id(), 
      vo.getCollection_type(), vo.getUser_id());
    
    if ((list != null) && (list.size() > 0)) {
      return 2;
    }
    
    int flag = 0;
    


    if ((vo.getTag() == null) || ("".equals(vo.getTag()))) {
      vo.setUslb_id(0);
      flag = addCollection(vo);
    }
    
    int uslb_id = 0;
    if ((vo.getTag() != null) || (!"".equals(vo.getTag()))) {
      uslb_id = this.userTagDao.checkTag(vo.getTag(), vo.getUser_id(), 
        vo.getCollection_type());
      
      if (uslb_id > 0) {
        vo.setUslb_id(uslb_id);
        flag = addCollection(vo);
      }
      else
      {
        int tag_pk = this.tagDao.findByName(vo.getTag());
        
        UserTagVO userTagVO = new UserTagVO();
        userTagVO.setType(vo.getCollection_type());
        userTagVO.setUser_id(vo.getUser_id());
        
        if (tag_pk > 0)
        {
          userTagVO.setLabel_id(tag_pk);
          int us_pk = this.userTagDao.add(userTagVO);
          vo.setUslb_id(us_pk);
          flag = addCollection(vo);
        }
        else
        {
          TagVO tagVO = new TagVO();
          tagVO.setLb_name(vo.getTag());
          int tag_id = this.tagDao.insert(tagVO);
          userTagVO.setLabel_id(tag_id);
          int us_pk = this.userTagDao.add(userTagVO);
          vo.setUslb_id(us_pk);
          flag = addCollection(vo);
        }
      }
    }
    

    return flag;
  }
  










  public int addCollection(CollectionVO vo)
  {
    List list = isCollection(vo.getCollection_id(), 
      vo.getCollection_type(), vo.getUser_id());
    
    if ((list != null) && (list.size() > 0)) {
      return 2;
    }
    
    IDBAccess dba = new DBAccessDefaultlImpl();
    int i = 1;
    String sql = "insert into user_collection values(seq_user_collection.nextval,?,?,?,?,?,?,sysdate,?)";
    
    dba.setParam(SQLParam.createIntParam(i++, vo.getUslb_id()));
    dba.setParam(SQLParam.createIntParam(i++, vo.getUser_id()));
    dba.setParam(SQLParam.createIntParam(i++, vo.getCollection_type()));
    dba.setParam(SQLParam.createIntParam(i++, vo.getCollection_id()));
    
    dba.setParam(SQLParam.createStringParam(i++, vo.getCollection_url()));
    dba.setParam(SQLParam.createStringParam(i++, vo.getRemark()));
    dba.setParam(SQLParam.createStringParam(i++, vo.getTitle()));
    
    int flag = dba.modifyData(sql);
    dba.closeConnection();
    return flag;
  }
  





  public int delete(int pk)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "delete user_collection where uscl_id=" + pk;
    int flag = dba.modifyData(sql);
    dba.closeConnection();
    return flag;
  }
  





  public int modify(CollectionVO vo)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    StringBuffer sql = new StringBuffer();
    int i = 1;
    sql.append("update user_collection c set c.user_id=c.user_id");
    
    if (vo.getUslb_id() > 0) {
      sql.append(",uslb_id=?");
      dba.setParam(SQLParam.createIntParam(i++, vo.getUslb_id()));
    }
    
    if ((vo.getRemark() != null) && (!"".equals(vo.getRemark()))) {
      sql.append(",remark=?");
      dba.setParam(SQLParam.createStringParam(i++, vo.getRemark()));
    }
    
    if ((vo.getTitle() != null) && (!"".equals(vo.getTitle()))) {
      sql.append(",title=?");
      dba.setParam(SQLParam.createStringParam(i++, vo.getTitle()));
    }
    
    sql.append(" where uscl_id=" + vo.getUscl_id());
    
    System.out.println("~~~SQL:" + sql.toString());
    
    int flag = dba.modifyData(sql.toString());
    dba.closeConnection();
    return flag;
  }
  









  public List query(int user_id, int uslb_id, int type)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    StringBuffer sql = new StringBuffer();
    BaseResult rs = new CollectionRS();
    if (type == 1)
    {
      sql.append("select pm.min_price,pm.merchant_count,pm.product_level,rp.web_address as local_address,uc.*,l.lb_name from user_collection uc ");
      sql
        .append(" left join user_label ul on uc.uslb_id=ul.uslb_id left join label l on ul.label_id=l.label_id");
      sql
        .append(" left join product_master pm on pm.prma_id=uc.collection_id left join product_pic rp on uc.collection_id=rp.prma_id ");
    }
    
    if (type == 2)
    {
      sql.append("select mb.mesh_chap_logo,uc.*,l.lb_name from user_collection uc left join user_label ul on uc.uslb_id=ul.uslb_id left join label l on ul.label_id=l.label_id left join merchant_baseinfo mb on mb.merc_id=uc.collection_id");
    }
    
    if (type == 3)
    {
      sql.append("select uc.*,l.lb_name from user_collection uc left join user_label ul on uc.uslb_id=ul.uslb_id left join label l on ul.label_id=l.label_id");
    }
    
    int i = 1;
    sql.append(" where uc.user_id=?");
    
    dba.setParam(SQLParam.createIntParam(i++, user_id));
    if (uslb_id > 0) {
      sql.append(" and uc.uslb_id=?");
      dba.setParam(SQLParam.createIntParam(i++, uslb_id));
    }
    
    sql.append(" and uc.collection_type=? order by uc.collection_date desc");
    dba.setParam(SQLParam.createIntParam(i++, type));
    
    List list = dba.queryData(sql.toString(), rs);
    dba.closeConnection();
    return list;
  }
  
  public List isCollection(int collection_id, int collection_type, int user_id)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new CollectionRS();
    String sql = "select * from user_collection where collection_id=" + 
      collection_id + " and user_id =" + user_id + " and collection_type=" + collection_type;
    List list = dba.queryData(sql, rs);
    dba.closeConnection();
    return list;
  }
  
  public CollectionVO findByPk(int pk)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new CollectionRS();
    String sql = "select * from user_collection where uscl_id=" + pk;
    List list = dba.queryData(sql, rs);
    dba.closeConnection();
    CollectionVO vo = new CollectionVO();
    if ((list != null) && (list.size() > 0)) {
      vo = (CollectionVO)list.get(0);
    }
    return vo;
  }
  
  public int getProductCount(int collection_id)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "select * from user_collection where collection_id =" + collection_id;
    int count = dba.queryDataNumber(sql);
    return count;
  }
}
