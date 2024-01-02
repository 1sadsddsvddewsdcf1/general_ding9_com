package com.ding9.dao.cheapcard;

import java.sql.SQLException;
import java.util.List;

public abstract interface CheapCardDao
{
  public abstract List getCheapCardIndex()
    throws SQLException;
  
  public abstract List getCheapCardPic(int paramInt)
    throws SQLException;
}
