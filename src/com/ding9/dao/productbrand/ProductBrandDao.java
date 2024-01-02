package com.ding9.dao.productbrand;

import java.sql.SQLException;
import java.util.List;

public abstract interface ProductBrandDao
{
  public abstract List getProductBrand(int paramInt)
    throws SQLException;
}
