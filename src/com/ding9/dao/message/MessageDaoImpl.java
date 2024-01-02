package com.ding9.dao.message;

import com.ding9.entity.seq.Seq;
import com.ding9.result.seq.SeqRS;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.util.Iterator;
import java.util.List;










public class MessageDaoImpl
  implements MessageDao
{
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  






  public int insertProductComent(int mema_id, String mere_content, int user_id)
  {
    int rst = 0;
    this.dba = new DBAccessDefaultlImpl();
    String sql = "insert into message_restore(MERE_ID, MEMA_ID, USER_ID, MERE_CONTENT, MERE_TIME) values(SEQ_MESSAGE_RESTORE.nextval," + mema_id + ", " + user_id + ",'" + mere_content + "',sysdate )";
    rst = this.dba.modifyData(sql);
    return rst;
  }
  



  public int insertAppraise(int prma_id, String title, String merit, String defect, String content, int radiobutton, int user_id)
  {
    int rst = 0;
    this.dba = new DBAccessDefaultlImpl();
    String sql = "insert into comments_on_product(id,release_time,content,prma_id,product_level,advantage,disadvantage,title,author_id) values (SEQ_COMMENTS_ON_PRODUCT.nextval,sysdate,'" + content + "',?,?,?,?,?,?)";
    
    this.dba.setParam(new SQLParam(1, 1, prma_id));
    this.dba.setParam(new SQLParam(2, 1, radiobutton));
    this.dba.setParam(new SQLParam(3, 5, merit));
    this.dba.setParam(new SQLParam(4, 5, defect));
    this.dba.setParam(new SQLParam(5, 5, title));
    this.dba.setParam(new SQLParam(6, 1, user_id));
    rst = this.dba.modifyData(sql);
    
    return rst;
  }
  
  public int getSEQ()
  {
    BaseResult rs = new SeqRS();
    this.dba = new DBAccessDefaultlImpl();
    String sql = "select seq_comments_on_product.currval from dual";
    List list = this.dba.queryData(sql, rs);
    this.dba.closeConnection();
    
    int seq = 0;
    Iterator it = list.iterator();
    while (it.hasNext()) {
      Seq vo = (Seq)it.next();
      seq = vo.getCurrval();
    }
    return seq;
  }
}
