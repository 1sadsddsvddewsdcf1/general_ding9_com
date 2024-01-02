package com.ding9.result.common_salepromotion_info;

import com.ding9.entity.common_salepromotion_info.CommonSalepromotionInfo;
import com.ding9.sql.BaseResult;
import com.ding9.util.Environment;
import com.ding9.util.StringHelper;
import java.sql.ResultSet;
import java.sql.SQLException;











public class CommonSalepromotionInfoList
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    CommonSalepromotionInfo entity = new CommonSalepromotionInfo();
    entity.setInfo_id(rs.getInt("info_id"));
    entity.setPrso_id_one(rs.getInt("prso_id_one"));
    entity.setSort_id(rs.getInt("sort_id"));
    entity.setTitle(rs.getString("title"));
    entity.setContent(StringHelper.outputStrToHtml(rs.getString("content")));
    entity.setPub_time(rs.getDate("pub_time"));
    entity.setMerc_id(rs.getInt("merc_id"));
    entity.setPrma_id(rs.getInt("prma_id"));
    entity.setUseful_life(rs.getString("useful_life"));
    entity.setOut_date(rs.getDate("out_date"));
    entity.setCooperate_id(rs.getInt("cooperate_id"));
    entity.setInfo_source(rs.getString("info_source"));
    entity.setSource_url(rs.getString("source_url"));
    entity.setInfo_type(rs.getInt("info_type"));
    entity.setInfo_status(rs.getInt("info_status"));
    entity.setRebate_range(rs.getString("rebate_range"));
    entity.setBrand_name(rs.getString("brand_name"));
    entity.setStore_name(rs.getString("store_name"));
    entity.setMarketplace(rs.getString("marketplace"));
    entity.setPrso_id_two(rs.getInt("prso_id_two"));
    entity.setPrso_id_three(rs.getInt("prso_id_three"));
    entity.setPrso_name(rs.getString("prso_name"));
    entity.setSowntown(rs.getString("sowntown"));
    entity.setPicture(Environment.getImageServer() + rs.getString("picture"));
    try
    {
      entity.setShop_id(rs.getInt("shop_id"));
    }
    catch (Exception localException) {}
    return entity;
  }
}
