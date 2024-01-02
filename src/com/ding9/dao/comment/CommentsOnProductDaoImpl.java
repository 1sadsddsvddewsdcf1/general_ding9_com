package com.ding9.dao.comment;

import com.ding9.result.comment.CommentOnProductResult;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;







public class CommentsOnProductDaoImpl
  implements CommentsOnProductDao
{
  private static Log log = LogFactory.getLog(CommentsOnProductDaoImpl.class);
  private IDBAccess dba = null;
  private static long lasttime = System.currentTimeMillis();
  private static List results = null;
  







  public List getCommentInfo(int size)
  {
    if ((results == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      if (log.isWarnEnabled()) {
        log.warn("重新载入评论信息时间：" + System.currentTimeMillis());
      }
      

      BaseResult ccr = new CommentOnProductResult();
      
      String sql = "SELECT TITLE,PRMA_ID,CHANNEL_ID,decode(sign(CHANNEL_ID-0),1,nvl((SELECT replace(ps.prso_name_one_en,' ','_') as prso_name_one_en from product_sort ps WHERE ps.prso_id =CHANNEL_ID and rownum=1),''),'') as prso_name_one_en FROM RECOMMEND_COMMENTS WHERE CHANNEL_ID=? ORDER BY ID DESC ";
      
      this.dba = new DBAccessDefaultlImpl();
      this.dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
      

      results = this.dba.queryTopData(sql, ccr, size, 1);
      
      lasttime = System.currentTimeMillis();
    }
    return results;
  }
  







  public List getCommentInfo(int channelId, int size)
  {
    if (log.isWarnEnabled()) {
      log.warn("重新载入评论信息时间：" + (System.currentTimeMillis() - lasttime));
    }
    
    BaseResult ccr = new CommentOnProductResult();
    String sql = "SELECT comment_id as id,title,prma_id,prso_id FROM recommend_comments WHERE channel_id=? ORDER BY id DESC ";
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(new SQLParam(1, 1, channelId));
    results = this.dba.queryDataPagination(sql, ccr, size, 1);
    
    return results;
  }
}
