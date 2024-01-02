package com.ding9.result.category;

import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheapCard implements BaseResult
{
  private com.ding9.entity.category.CheapCard cheapcard = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.cheapcard = new com.ding9.entity.category.CheapCard();
    
    this.cheapcard.setChca_id(resultset.getInt("chca_id"));
    this.cheapcard.setMerc_id(resultset.getInt("merc_id"));
    this.cheapcard.setPrso_id_one(resultset.getInt("prso_id_one"));
    
    this.cheapcard.setChca_pic(resultset.getString("chca_pic"));
    this.cheapcard.setChca_remark(resultset.getString("chca_remark"));
    this.cheapcard.setChca_title(resultset.getString("chca_title"));
    this.cheapcard.setChca_url(resultset.getString("chca_url"));
    
    this.cheapcard.setChca_time(resultset.getDate("chca_time"));
    this.cheapcard.setEnd_time(resultset.getDate("end_time"));
    
    return this.cheapcard;
  }
}
