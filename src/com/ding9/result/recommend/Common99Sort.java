package com.ding9.result.recommend;

import com.ding9.dao.com99recommend.Common99RecommendDaoImpl;
import com.ding9.entity.commonrecommendproductinfo.Common99RecommendSortInfo;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Common99Sort implements BaseResult
{
  private Common99RecommendSortInfo enti = null;
  
  public Object getMapRow(ResultSet rs, int i) throws SQLException { this.enti = new Common99RecommendSortInfo();
    this.enti.setParent_id(rs.getInt("parent_id"));
    this.enti.setPrso_id_one(rs.getInt("prso_id_one"));
    this.enti.setSort_id(rs.getInt("sort_id"));
    this.enti.setSort_name(rs.getString("sort_name"));
    Common99RecommendDaoImpl sub = new Common99RecommendDaoImpl();
    this.enti.setSub(sub.getSubSort(rs.getInt("sort_id")));
    return this.enti;
  }
}
