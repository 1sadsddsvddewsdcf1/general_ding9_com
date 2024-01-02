package com.ding9.result.productsort;

import com.ding9.entity.productsort.ProductSort;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;

public class ProductType implements BaseResult
{
  private ProductSort entity = null;
  
  public Object getMapRow(ResultSet rs, int i) throws java.sql.SQLException {
    this.entity = new ProductSort();
    try
    {
      this.entity.setPrso_id(rs.getInt("prso_id"));
    } catch (Exception localException) {}
    try {
      this.entity.setPrso_name_three(rs.getString("prso_name_three"));
    } catch (Exception localException1) {}
    try {
      this.entity.setCnt(rs.getInt("cnt"));
    } catch (Exception localException2) {}
    try {
      this.entity.setPrso_id_three(rs.getInt("prso_id"));
    } catch (Exception localException3) {}
    try {
      this.entity.setPrso_id_one(rs.getInt("prso_id_one"));
    } catch (Exception localException4) {}
    try {
      this.entity.setPrso_name_one_en(rs.getString("prso_name_one_en"));
    } catch (Exception localException5) {}
    try {
      this.entity.setPrso_name_three_en(rs.getString("prso_name_three_en"));
    } catch (Exception localException6) {}
    return this.entity;
  }
}
