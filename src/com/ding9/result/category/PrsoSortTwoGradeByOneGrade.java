package com.ding9.result.category;

import com.ding9.entity.category.PrsoSort;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrsoSortTwoGradeByOneGrade implements BaseResult
{
  private PrsoSort prsoSort = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.prsoSort = new PrsoSort();
    
    this.prsoSort.setId(resultset.getInt("prso_id_two"));
    this.prsoSort.setName(resultset.getString("prso_name_two"));
    

    return this.prsoSort;
  }
}
