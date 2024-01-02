package com.ding9.result.contentinfo;

import com.ding9.entity.commoncontentinfo.CommonContentInfo;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentInfoResult implements BaseResult
{
  private CommonContentInfo channelinfo = null;
  
  public Object getMapRow(ResultSet rs, int i) throws SQLException {
    this.channelinfo = new CommonContentInfo();
    
    this.channelinfo.setContent(rs.getString("content"));
    this.channelinfo.setInfoId(rs.getInt("info_id"));
    this.channelinfo.setTitle(rs.getString("title"));
    
    return this.channelinfo;
  }
}
