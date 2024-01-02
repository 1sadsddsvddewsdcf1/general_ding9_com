package com.ding9.dao.cheapcard;

import java.util.List;

public abstract interface CheapCardManageDao
{
  public abstract List getRecommendCheapCard(int paramInt1, int paramInt2);
  
  public abstract List getCheapCard(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract List getLatestCheap(int paramInt);
  
  public abstract List getCheapcardDetail(int paramInt);
  
  public abstract List getSimilarCheapcard(String paramString, int paramInt);
  
  public abstract List getRelatedCheapcard(int paramInt1, int paramInt2);
  
  public abstract List getOtherCheapCard(int paramInt1, int paramInt2, int paramInt3);
}
