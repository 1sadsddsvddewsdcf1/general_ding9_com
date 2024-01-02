package com.ding9.result.common_salepromotion_info;

import com.ding9.entity.common_salepromotion_info.CommonSalepromotion;
import com.ding9.sql.BaseResult;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonSalepromotionInfo
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws SQLException
  {
    CommonSalepromotion entity = new CommonSalepromotion();
    try
    {
      entity.setInfo_id(rs.getInt("info_id"));
    } catch (Exception localException) {}
    try {
      entity.setPrso_id_one(rs.getInt("prso_id_one"));
    } catch (Exception localException1) {}
    try {
      entity.setPrso_name_one_en(rs.getString("prso_name_one_en"));
    } catch (Exception localException2) {}
    try {
      entity.setSort_id(rs.getInt("sort_id"));
    } catch (Exception localException3) {}
    try {
      entity.setTitle(rs.getString("title"));
    } catch (Exception localException4) {}
    try {
      entity.setContent(StringHelper.outputStrToHtml(rs.getString("content")));
    } catch (Exception localException5) {}
    try {
      entity.setPub_time(rs.getDate("pub_time"));
    } catch (Exception localException6) {}
    try {
      entity.setMerc_id(rs.getInt("merc_id"));
    } catch (Exception localException7) {}
    try {
      entity.setPrma_id(rs.getInt("prma_id"));
    } catch (Exception localException8) {}
    try {
      entity.setUseful_life(rs.getString("useful_life"));
    } catch (Exception localException9) {}
    try {
      entity.setOut_date(rs.getDate("out_date"));
    } catch (Exception localException10) {}
    try {
      entity.setCooperate_id(rs.getInt("cooperate_id"));
    } catch (Exception localException11) {}
    try {
      entity.setInfo_source(rs.getString("info_source"));
    } catch (Exception localException12) {}
    try {
      entity.setSource_url(rs.getString("source_url"));
    } catch (Exception localException13) {}
    try {
      entity.setInfo_type(rs.getInt("info_type"));
    } catch (Exception localException14) {}
    try {
      entity.setInfo_status(rs.getInt("info_status"));
    } catch (Exception localException15) {}
    try {
      entity.setRebate_range(rs.getString("rebate_range"));
    } catch (Exception localException16) {}
    try {
      entity.setBrand_name(rs.getString("brand_name"));
    } catch (Exception localException17) {}
    try {
      entity.setStore_name(rs.getString("store_name"));
    } catch (Exception localException18) {}
    try {
      entity.setMarketplace(rs.getString("marketplace"));
    } catch (Exception localException19) {}
    try {
      entity.setPrso_id_two(rs.getInt("prso_id_two"));
    } catch (Exception localException20) {}
    try {
      entity.setPrso_id_three(rs.getInt("prso_id_three"));
    } catch (Exception localException21) {}
    try {
      entity.setPrso_name(rs.getString("prso_name"));
    } catch (Exception localException22) {}
    try {
      entity.setSowntown(rs.getString("sowntown"));
    }
    catch (Exception localException23) {}
    return entity;
  }
}
