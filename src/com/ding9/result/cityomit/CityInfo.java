package com.ding9.result.cityomit;

import com.ding9.entity.cityomit.City;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;










public class CityInfo
  implements BaseResult
{
  private City city = null;
  



  public Object getMapRow(ResultSet resultset, int i)
    throws SQLException
  {
    this.city = new City();
    this.city.setCity_id(resultset.getString("city_id"));
    this.city.setCity_name(resultset.getString("city_name"));
    this.city.setPurc_id(resultset.getString("purc_id"));
    return this.city;
  }
}
