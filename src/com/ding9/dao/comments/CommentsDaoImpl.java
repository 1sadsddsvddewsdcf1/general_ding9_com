package com.ding9.dao.comments;

import com.ding9.entity.comments.Comment;
import com.ding9.entity.comments.CommentCredit;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommentsDaoImpl
{
  public List getCommentsList(int authorid, int pagesize, int pagenum)
  {
    List rst = null;
    int i = 1;
    CommentResult map = new CommentResult();
    IDBAccess dba = new DBAccessDefaultlImpl();
    
    StringBuffer sql = new StringBuffer();
    sql.append(" SELECT id,cop.Product_level,author_name,prma_name,Advantage,Content,Disadvantage,title,cop.release_time from comments_on_product cop inner join product_master pm on cop.prma_id=pm.prma_id where cop.author_id=? ");
    


    dba.setParam(new SQLParam(i, 1, authorid));
    i++;
    

    sql.append(" order by cop.id desc");
    rst = dba.queryDataPagination(sql.toString(), map, pagesize, pagenum);
    










    return rst;
  }
  
  public List getCommentCreditList(int userid, int pagesize, int pagenum) {
    List rst = null;
    int i = 1;
    CommentCreditResult map = new CommentCreditResult();
    IDBAccess dba = new DBAccessDefaultlImpl();
    
    StringBuffer sql = new StringBuffer();
    sql.append(" select cc.cocr_id,cc.cocr_reason,cc.cocr_time,mb.merc_com_name from comment_credit cc inner join merchant_baseinfo mb on cc.cocr_user_id=mb.merc_id where cc.user_id=? ");
    


    dba.setParam(new SQLParam(i, 1, userid));
    i++;
    

    sql.append(" order by cc.cocr_id desc");
    rst = dba.queryDataPagination(sql.toString(), map, pagesize, pagenum);
    










    return rst;
  }
  
  public List getCommentRestoreList(int memaid) {
    List rst = null;
    int i = 1;
    CommentRestoreResult map = new CommentRestoreResult();
    IDBAccess dba = new DBAccessDefaultlImpl();
    
    StringBuffer sql = new StringBuffer();
    sql.append(" SELECT mr.mere_content from comments_on_product cop inner join message_restore mr on cop.id = mr.mema_id where mr.mema_id=? ");
    


    dba.setParam(new SQLParam(i, 1, memaid));
    i++;
    


    rst = dba.queryData(sql.toString(), map);
    










    return rst;
  }
  
  public int insertProductComment(int mema_id, String mere_content, int user_id) {
    int rst = 0;
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "insert into message_restore(MERE_ID, MEMA_ID, USER_ID, MERE_CONTENT, MERE_TIME) values(SEQ_MESSAGE_RESTORE.nextval," + mema_id + ", " + user_id + ",'" + mere_content + "',sysdate )";
    rst = dba.modifyData(sql);
    return rst;
  }
  
  public int deleteComments(int id)
  {
    int rst = 0;
    rst = deleteProductComment(id);
    
    if (rst > 0)
    {
      IDBAccess dba = new DBAccessDefaultlImpl();
      String sql = "delete from comments_on_product where id=" + id;
      rst = dba.modifyData(sql);
    }
    return rst;
  }
  
  public int deleteProductComment(int mema_id) {
    int rst = 0;
    IDBAccess dba = new DBAccessDefaultlImpl();
    String sql = "delete from message_restore where mema_id=" + mema_id;
    rst = dba.modifyData(sql);
    return rst;
  }
  
  private class CommentRestoreResult implements BaseResult {
    private CommentRestoreResult() {}
    
    public Object getMapRow(ResultSet rs, int i) throws SQLException { String cr = "";
      try {
        cr = rs.getString("mere_content");
      }
      catch (SQLException localSQLException) {}
      return cr;
    }
  }
  
  private class CommentCreditResult implements BaseResult {
    private CommentCreditResult() {}
    
    public Object getMapRow(ResultSet rs, int i) throws SQLException { CommentCredit cc = new CommentCredit();
      try {
        cc.setCocr_id(rs.getInt("cocr_id"));
      } catch (SQLException localSQLException) {}
      try {
        cc.setMerc_com_name(rs.getString("Merc_com_name"));
      } catch (Exception localException) {}
      try {
        cc.setCocr_reason(rs.getString("Cocr_reason"));
      } catch (Exception localException1) {}
      try {
        cc.setCocr_time(rs.getString("Cocr_time"));
      }
      catch (Exception localException2) {}
      return cc;
    }
  }
  
  private class CommentResult implements BaseResult {
    private CommentResult() {}
    
    public Object getMapRow(ResultSet rs, int i) throws SQLException { Comment comment = new Comment();
      try {
        comment.setId(rs.getInt("id"));
      } catch (SQLException localSQLException) {}
      try {
        comment.setProduct_level(rs.getInt("Product_level"));
      } catch (Exception localException) {}
      try {
        comment.setAuthor_name(rs.getString("author_name"));
      } catch (Exception localException1) {}
      try {
        comment.setPrma_name(rs.getString("prma_name"));
      } catch (Exception localException2) {}
      try {
        comment.setAdvantage(rs.getString("Advantage"));
      } catch (Exception localException3) {}
      try {
        comment.setContent(rs.getString("Content"));
      } catch (Exception localException4) {}
      try {
        comment.setDisadvantage(rs.getString("Disadvantage"));
      } catch (Exception localException5) {}
      try {
        comment.setTitle(rs.getString("title"));
      } catch (Exception localException6) {}
      try {
        comment.setRelease_time(rs.getString("release_time"));
      } catch (Exception localException7) {}
      try {
        comment.setMr(CommentsDaoImpl.this.getCommentRestoreList(comment.getId()));
      } catch (Exception localException8) {}
      comment.setMrcount(comment.getMr().size());
      
      return comment;
    }
  }
}
