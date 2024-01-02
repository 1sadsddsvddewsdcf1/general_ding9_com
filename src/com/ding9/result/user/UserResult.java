package com.ding9.result.user;

import com.ding9.entity.user.UserAccountInfo;
import com.ding9.entity.user.UserContactInfo;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;

public class UserResult implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i) throws java.sql.SQLException
  {
    UserAccountInfo user = new UserAccountInfo();
    try {
      user.setUser_id(rs.getInt("user_id"));
    } catch (Exception localException) {}
    try {
      user.setUser_id_tmp(rs.getInt("user_id_tmp"));
    } catch (Exception localException1) {}
    try {
      user.setUser_name(rs.getString("user_name"));
    } catch (Exception localException2) {}
    try {
      user.setUser_pass(rs.getString("user_pass"));
    } catch (Exception localException3) {}
    try {
      user.setUser_email(rs.getString("user_email"));
    } catch (Exception localException4) {}
    try {
      user.setUser_date_reg(rs.getTimestamp("user_date_reg"));
    } catch (Exception localException5) {}
    try {
      user.setUser_sn(rs.getString("user_sn"));
    } catch (Exception localException6) {}
    try {
      user.setUser_check(rs.getInt("user_check"));
    } catch (Exception localException7) {}
    try {
      user.setUser_journal(rs.getInt("user_journal"));
    } catch (Exception localException8) {}
    try {
      user.setUser_credit(rs.getInt("user_credit"));
    } catch (Exception localException9) {}
    try {
      user.setUser_screen(rs.getInt("user_screen"));
    } catch (Exception localException10) {}
    try {
      user.getContact().setUser_name_true(rs.getString("user_name_true"));
    } catch (Exception localException11) {}
    try {
      user.getContact().setUser_sex(rs.getString("user_sex"));
    } catch (Exception localException12) {}
    try {
      user.getContact().setUser_date(rs.getDate("user_date").toString());
    } catch (Exception localException13) {}
    try {
      user.getContact().setUser_omit(rs.getString("user_omit"));
    } catch (Exception localException14) {}
    try {
      user.getContact().setUser_city(rs.getString("user_city"));
    }
    catch (Exception localException15) {}
    try {
      user.getContact().setUser_phone(rs.getString("user_phone"));
    } catch (Exception localException16) {}
    try {
      user.getContact().setUser_bain_fax(rs.getString("user_bain_fax"));
    } catch (Exception localException17) {}
    try {
      user.getContact().setUser_handset(rs.getString("user_handset"));
    } catch (Exception localException18) {}
    try {
      user.getContact().setUser_address(rs.getString("user_address"));
    } catch (Exception localException19) {}
    try {
      user.getContact().setUser_post(rs.getString("user_post"));
    } catch (Exception localException20) {}
    try {
      user.setUser_quse(rs.getInt("user_quse"));
    } catch (Exception localException21) {}
    try {
      user.setUser_solu(rs.getString("user_solu"));
    } catch (Exception localException22) {}
    try {
      user.setMerchant_tig(rs.getString("merchant_tig"));
    } catch (Exception localException23) {}
    try {
      user.setUser_merchant(rs.getString("user_merchant"));
    } catch (Exception localException24) {}
    try {
      user.setSource_userid(rs.getInt("source_userid"));
    }
    catch (Exception localException25) {}
    


    try
    {
      user.setSource_username(rs.getString("source_username"));
    } catch (Exception localException26) {}
    try {
      user.setSource_useremail(rs.getString("source_useremail"));
    } catch (Exception localException27) {}
    try {
      user.setIs_using(rs.getInt("is_using"));
    }
    catch (Exception localException28) {}
    
    return user;
  }
}
