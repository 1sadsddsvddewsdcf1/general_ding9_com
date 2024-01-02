package com.ding9.dao.com99recommend;

import java.util.List;

public abstract interface Common99RecommendDao
{
  public abstract List getParentSort();
  
  public abstract List getSubSort(int paramInt);
  
  public abstract List getProduct(int paramInt1, int paramInt2);
}
