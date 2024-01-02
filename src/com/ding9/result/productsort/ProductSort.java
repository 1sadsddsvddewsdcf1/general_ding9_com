package com.ding9.result.productsort;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSort implements BaseResult
{
  private com.ding9.entity.productsort.ProductSort entity = null;
  
  public Object getMapRow(ResultSet rs, int i) throws SQLException {
    this.entity = new com.ding9.entity.productsort.ProductSort();
    try
    {
      this.entity.setPrso_id(rs.getInt("prso_id"));
    } catch (Exception localException) {}
    try {
      this.entity.setPrso_id_one(rs.getInt("prso_id_one"));
    } catch (Exception localException1) {}
    try {
      this.entity.setPrso_id_two(rs.getInt("prso_id_two"));
    } catch (Exception localException2) {}
    try {
      this.entity.setPrso_id_three(rs.getInt("prso_id_three"));
    } catch (Exception localException3) {}
    try {
      this.entity.setPrso_name_one(rs.getString("prso_name_one"));
    } catch (Exception localException4) {}
    try {
      this.entity.setPrso_name_two(rs.getString("prso_name_two"));
    } catch (Exception localException5) {}
    try {
      this.entity.setPrso_name_three(rs.getString("prso_name_three"));
    } catch (Exception localException6) {}
    try {
      this.entity.setPrso_table_name(rs.getString("prso_table_name"));
    } catch (Exception localException7) {}
    try {
      this.entity.setPrso_nadir_num(rs.getFloat("prso_nadir_num"));
    } catch (Exception localException8) {}
    try {
      this.entity.setPrso_small_num(rs.getFloat("prso_small_num"));
    } catch (Exception localException9) {}
    try {
      this.entity.setPrso_rake(rs.getFloat("prso_rake"));
    } catch (Exception localException10) {}
    try {
      this.entity.setPrso_address(rs.getString("prso_address"));
    } catch (Exception localException11) {}
    try {
      this.entity.setPrso_parameter(rs.getString("prso_parameter"));
    } catch (Exception localException12) {}
    try {
      this.entity.setCriterion_flat(rs.getInt("criterion_flag"));
    } catch (Exception localException13) {}
    try {
      this.entity.setPrso_label(rs.getInt("prso_label"));
    }
    catch (Exception localException14) {}
    try {
      this.entity.setPrso_name_one_en(rs.getString("prso_name_one_en"));
    } catch (Exception localException15) {}
    try {
      this.entity.setPrso_name_two_en(rs.getString("prso_name_two_en"));
    } catch (Exception localException16) {}
    try {
      this.entity.setPrso_name_three_en(rs.getString("prso_name_three_en"));
    } catch (Exception localException17) {}
    return this.entity;
  }
}
