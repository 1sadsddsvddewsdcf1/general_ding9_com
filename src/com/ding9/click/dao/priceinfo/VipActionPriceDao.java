package com.ding9.click.dao.priceinfo;

import java.sql.SQLException;
import java.util.HashMap;

public abstract interface VipActionPriceDao
{
  public abstract int getActionPrice(int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract HashMap getAllActionPrices();
}
