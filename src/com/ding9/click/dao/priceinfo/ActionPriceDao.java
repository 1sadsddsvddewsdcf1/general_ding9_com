package com.ding9.click.dao.priceinfo;

import java.sql.SQLException;
import java.util.HashMap;

public abstract interface ActionPriceDao
{
  public abstract int getActionPrice(int paramInt)
    throws SQLException;
  
  public abstract HashMap getAllActionPrices();
}
