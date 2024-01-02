package com.ding9.dao.product;

import java.sql.SQLException;
import java.util.List;

public abstract interface ProductCommpareDao
{
  public abstract List getProductInfo(List paramList)
    throws SQLException;
  
  public abstract List getProductPicIndex(List paramList)
    throws SQLException;
}
