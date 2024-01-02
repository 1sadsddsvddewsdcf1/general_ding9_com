package com.ding9.result.search;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSort implements BaseResult
{
  private com.ding9.entity.search.ProductSort productSort = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.productSort = new com.ding9.entity.search.ProductSort();
    
    this.productSort.setPrso_id_one(resultset.getInt("prso_id_one"));
    this.productSort.setPrso_id_two(resultset.getInt("prso_id_two"));
    this.productSort.setPrso_id_three(resultset.getInt("prso_id_three"));
    
    this.productSort.setPrso_name_one(resultset.getString("prso_name_one"));
    this.productSort.setPrso_name_two(resultset.getString("prso_name_two"));
    this.productSort.setPrso_name_three(resultset.getString("prso_name_three"));
    return this.productSort;
  }
}
