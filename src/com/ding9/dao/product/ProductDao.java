package com.ding9.dao.product;

import java.sql.SQLException;
import java.util.List;

public abstract interface ProductDao
{
  public abstract List getProductInfo(int paramInt)
    throws SQLException;
  
  public abstract List getRebuildPic(int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract List getPrbrNameInfo(int paramInt)
    throws SQLException;
  
  public abstract List getProductPatameterInfo(String paramString)
    throws SQLException;
  
  public abstract List getPatameterInfo(String paramString, int paramInt)
    throws SQLException;
  
  public abstract List getMessageInfo(int paramInt1, int paramInt2, int paramInt3)
    throws SQLException;
  
  public abstract List getMerchantInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, int paramInt5, String paramString3)
    throws SQLException;
  
  public abstract List getUserMessageInfo(int paramInt)
    throws SQLException;
  
  public abstract List getPlayment(int paramInt)
    throws SQLException;
  
  public abstract List getProductPrise(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
    throws SQLException;
  
  public abstract List getMobileArticle(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract List getPatameterGSMTime(int paramInt)
    throws SQLException;
  
  public abstract List getReviewInfo(int paramInt)
    throws SQLException;
  
  public abstract List getProductMessageInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    throws SQLException;
  
  public abstract List getMerchantProductInfo(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3, List paramList)
    throws SQLException;
  
  public abstract List getProductPatameterInfo(String paramString, int paramInt)
    throws SQLException;
  
  public abstract List getSalepromotion(int paramInt)
    throws SQLException;
  
  public abstract List getOmitInfo(int paramInt)
    throws SQLException;
  
  public abstract List getPayInfo(int paramInt)
    throws SQLException;
  
  public abstract List getProductPicIndex(String paramString)
    throws SQLException;
  
  public abstract List getProductMessageRestore(int paramInt1, int paramInt2, int paramInt3)
    throws SQLException;
}
