package com.ding9.result.cityomit;

import com.ding9.entity.cityomit.Province;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;









public class OmitInfo
  implements BaseResult
{
  private Province province = null;
  



  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.province = new Province();
    this.province.setProv_id(resultset.getString("prov_id"));
    this.province.setProv_name(resultset.getString("prov_name"));
    return this.province;
  }
}
