package com.ding9.click.service;

import com.ding9.click.entity.accesslog.IBLAccessLogData;
import com.ding9.click.entity.accesslog.IVipBLAccessLogData;
import java.util.HashMap;

public abstract interface IAccessLogService
{
  public abstract int addAccessLog(IBLAccessLogData paramIBLAccessLogData, String paramString1, String paramString2);
  
  public abstract int addVipAccessLog(IVipBLAccessLogData paramIVipBLAccessLogData, String paramString1, String paramString2);
  
  public abstract int addVipAccessLog(IVipBLAccessLogData[] paramArrayOfIVipBLAccessLogData);
  
  public abstract HashMap getBLCodes(int paramInt, String paramString1, String paramString2);
  
  public abstract HashMap getVipBLCodes(int paramInt, String paramString1, String paramString2);
  
  public abstract HashMap getVipAllPrices();
}
