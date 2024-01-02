package com.ding9.result.regiontype;

import com.ding9.dao.regiontype.RegionTypeDao;
import com.ding9.dao.regiontype.RegionTypeDaoImpl;
import com.ding9.entity.regiontype.RegionType;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegionTypeList
  implements BaseResult
{
  public Object getMapRow(ResultSet rs, int i)
    throws SQLException
  {
    RegionType map = new RegionType();
    int sc = rs.getInt("type_id_two");
    map.setType_id_two(sc);
    map.setType_id_one(rs.getInt("type_id_one"));
    map.setType_name_one(rs.getString("type_name_one"));
    map.setType_name_two(rs.getString("type_name_two"));
    RegionTypeDao dao = new RegionTypeDaoImpl();
    map.setScshop(dao.getShop(sc));
    return map;
  }
}
