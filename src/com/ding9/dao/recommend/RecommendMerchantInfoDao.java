package com.ding9.dao.recommend;

import java.sql.SQLException;
import java.util.List;

public abstract interface RecommendMerchantInfoDao
{
  public abstract List getRecommendMerchantInfo()
    throws SQLException;
  
  public abstract List getRecommendMerchantInfo(int paramInt);
}
