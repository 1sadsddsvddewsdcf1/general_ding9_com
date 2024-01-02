package com.ding9.dao.common_salepromotion_info;

import java.util.List;

public abstract interface CommonSalepromotionInfoDao
{
  public abstract List getCommonSalepromotionInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt6, int paramInt7, String paramString6, int paramInt8, int paramInt9, String paramString7, int paramInt10, int paramInt11);
  
  public abstract List getCommonSalepromotionInfo(int paramInt);
  
  public abstract List getCommonSalepromotionSort(int paramInt);
  
  public abstract List getCommonSalepromotionInfo();
  
  public abstract List getCommonSalepromotion(int paramInt);
}
