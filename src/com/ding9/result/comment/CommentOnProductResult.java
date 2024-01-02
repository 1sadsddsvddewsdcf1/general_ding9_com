package com.ding9.result.comment;

import com.ding9.entity.commentsonproduct.CommentsOnProduct;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentOnProductResult implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    CommentsOnProduct map = new CommentsOnProduct();
    try {
      map.setId(rs.getInt("id"));
    }
    catch (Exception localException) {}
    map.setTitle(StringHelper.getSubString(rs.getString("title"), 24));
    map.setPrmaId(rs.getInt("prma_id"));
    try {
      map.setPrsoId(rs.getInt("prso_id"));
    }
    catch (Exception localException1) {}
    try {
      map.setChannelId(rs.getInt("channel_id"));
    } catch (Exception localException2) {}
    try {
      map.setPrsoNameOneEn(rs.getString("prso_name_one_en"));
    } catch (Exception localException3) {}
    return map;
  }
}
