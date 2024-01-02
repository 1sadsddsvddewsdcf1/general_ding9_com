package com.ding9.dao.productsort;

import java.sql.SQLException;
import java.util.List;

public abstract interface ProductSortDao
{
  public abstract List getProductSort()
    throws SQLException;
  
  public abstract List getProductSort(int paramInt)
    throws SQLException;
  
  public abstract List getOneProductSort(int paramInt)
    throws SQLException;
  
  public abstract List getThreeGrade(int paramInt)
    throws SQLException;
}
