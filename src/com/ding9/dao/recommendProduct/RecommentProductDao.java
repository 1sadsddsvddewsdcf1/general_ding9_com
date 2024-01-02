package com.ding9.dao.recommendProduct;

import java.util.List;

public abstract interface RecommentProductDao
{
  public abstract List getRecommendProduct(int paramInt1, int paramInt2);
  
  public abstract List getRecommendProduct(int paramInt1, int paramInt2, int paramInt3);
}
