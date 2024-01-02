package com.ding9.result.productbrand;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductBrand implements BaseResult
{
  private com.ding9.entity.productbrand.ProductBrand entity = null;
  
  public Object getMapRow(ResultSet rs, int i) throws SQLException {
    this.entity = new com.ding9.entity.productbrand.ProductBrand();
    
    this.entity.setPrbr_id(rs.getInt("prbr_id"));
    this.entity.setPrbr_name(rs.getString("prbr_name"));
    try {
      this.entity.setCnt(rs.getInt(3));
    } catch (Exception localException) {}
    try {
      this.entity.setPrso_id_one(rs.getInt("prso_id_one"));
    } catch (Exception localException1) {}
    try {
      this.entity.setPrso_name_one_en(rs.getString("prso_name_one_en"));
    } catch (Exception localException2) {}
    try {
      this.entity.setPrso_id_three(rs.getInt("prso_id_three"));
    } catch (Exception localException3) {}
    try {
      this.entity.setPrso_name_three_en(rs.getString("prso_name_three_en"));
    }
    catch (Exception localException4) {}
    return this.entity;
  }
}
