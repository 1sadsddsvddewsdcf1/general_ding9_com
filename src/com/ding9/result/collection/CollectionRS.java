package com.ding9.result.collection;

import com.ding9.entity.collection.CollectionVO;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;




public class CollectionRS
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    CollectionVO vo = new CollectionVO();
    try
    {
      vo.setCollection_date(rs.getTimestamp("collection_date"));
    }
    catch (Exception localException) {}
    try {
      vo.setCollection_id(rs.getInt("collection_id"));
    }
    catch (Exception localException1) {}
    try {
      vo.setCollection_type(rs.getInt("collection_type"));
    }
    catch (Exception localException2) {}
    try {
      vo.setCollection_url(rs.getString("collection_url"));
    }
    catch (Exception localException3) {}
    try {
      vo.setRemark(rs.getString("remark"));
    }
    catch (Exception localException4) {}
    try {
      vo.setTitle(rs.getString("title"));
    }
    catch (Exception localException5) {}
    try {
      vo.setUscl_id(rs.getInt("uscl_id"));
    }
    catch (Exception localException6) {}
    try {
      vo.setUser_id(rs.getInt("user_id"));
    }
    catch (Exception localException7) {}
    try {
      vo.setUslb_id(rs.getInt("uslb_id"));
    }
    catch (Exception localException8) {}
    try {
      vo.setLb_name(rs.getString("lb_name"));
    }
    catch (Exception localException9) {}
    try
    {
      vo.setLogo(rs.getString("mesh_chap_logo"));
    }
    catch (Exception localException10) {}
    try {
      vo.setMin_price(rs.getInt("min_price"));
    } catch (Exception localException11) {}
    try {
      vo.setMerchant_count(rs.getInt("merchant_count"));
    } catch (Exception localException12) {}
    try {
      vo.setProduct_level(rs.getInt("product_level"));
    } catch (Exception localException13) {}
    try {
      vo.setLocal_address(rs.getString("local_address"));
    }
    catch (Exception localException14) {}
    return vo;
  }
}
