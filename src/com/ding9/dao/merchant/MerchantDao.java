package com.ding9.dao.merchant;

import com.ding9.entity.merchant.Merchant;
import java.sql.SQLException;

public abstract interface MerchantDao
{
  public abstract String getMerchantProductUrl(int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract Merchant getMerchantInfo(int paramInt)
    throws SQLException;
}
