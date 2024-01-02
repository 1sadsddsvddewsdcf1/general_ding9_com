package com.ding9.result.merchant;

import com.ding9.entity.merchant.Merchant;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class MerchantInfo
  implements BaseResult
{
  private Merchant merchant = null;
  

  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.merchant = new Merchant();
    this.merchant.setMerc_id(resultset.getInt("merc_id"));
    this.merchant.setMerc_web_name(resultset.getString("merc_web_name"));
    this.merchant.setMerc_com_name(resultset.getString("merc_com_name"));
    this.merchant.setMesh_chap_logo(resultset.getString("mesh_chap_logo"));
    this.merchant.setMerc_city(resultset.getString("merc_city"));
    this.merchant.setMerc_omit(resultset.getString("merc_omit"));
    try {
      this.merchant.setMerc_url(resultset.getString("merc_url"));
    } catch (Exception localException) {}
    try {
      this.merchant.setMerc_email(resultset.getString("merc_email"));
    } catch (Exception localException1) {}
    try {
      this.merchant.setMerc_phone(resultset.getString("merc_phone"));
    } catch (Exception localException2) {}
    try {
      this.merchant.setMerc_id_TMP(resultset.getInt("merc_id_tmp"));
    } catch (Exception localException3) {}
    try {
      this.merchant.setMerc_fax(resultset.getString("merc_fax"));
    } catch (Exception localException4) {}
    try {
      this.merchant.setMerc_post(resultset.getString("merc_post"));
    } catch (Exception localException5) {}
    try {
      this.merchant.setMesh_logo_money(resultset.getString("mesh_logo_money"));
    } catch (Exception localException6) {}
    try {
      this.merchant.setMerc_bound(resultset.getString("merc_bound"));
    } catch (Exception localException7) {}
    try {
      this.merchant.setMerc_date(resultset.getString("merc_date"));
    } catch (Exception localException8) {}
    try {
      this.merchant.setMerc_name(resultset.getString("mesh_name"));
    } catch (Exception localException9) {}
    try {
      this.merchant.setMesh_pic(resultset.getString("mesh_pic"));
    } catch (Exception localException10) {}
    try {
      this.merchant.setMesh_into_time(resultset.getString("mesh_into_time"));
    } catch (Exception localException11) {}
    try {
      this.merchant.setMerc_from(resultset.getInt("merc_from"));
    } catch (Exception localException12) {}
    try {
      this.merchant.setMerc_from_id(resultset.getInt("merc_from_id"));
    } catch (Exception localException13) {}
    try {
      this.merchant.setMerc_credit(resultset.getInt("merc_credit"));
    } catch (Exception localException14) {}
    try {
      this.merchant.setMerc_size(resultset.getInt("merc_size"));
    } catch (Exception localException15) {}
    try {
      this.merchant.setSys_yn(resultset.getInt("sys_yn"));
    } catch (Exception localException16) {}
    try {
      this.merchant.setMerc_type(resultset.getInt("merc_type"));
    } catch (Exception localException17) {}
    try {
      this.merchant.setSyus_id(resultset.getInt("syus_id"));
    } catch (Exception localException18) {}
    try {
      this.merchant.setMerc_type(resultset.getInt("merchant_type"));
    } catch (Exception localException19) {}
    try {
      this.merchant.setMerc_js(resultset.getString("merc_js"));
    } catch (Exception localException20) {}
    try {
      this.merchant.setMax_scale(resultset.getString("max_scale"));
    } catch (Exception localException21) {}
    try {
      this.merchant.setScale_explain(resultset.getString("scale_explain"));
    } catch (Exception localException22) {}
    return this.merchant;
  }
}
