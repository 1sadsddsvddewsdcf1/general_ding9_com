package com.ding9.dao.coupon;

import java.util.List;

public abstract interface CouponInfoDao
{
  public abstract List getCouponInfo(int paramInt1, int paramInt2);
  
  public abstract List getPicCouponInfo(int paramInt);
  
  public abstract List getCouponInfo(int paramInt);
  
  public abstract List getPicCouponInfo();
  
  public abstract List getOtherCouponInfo();
}
