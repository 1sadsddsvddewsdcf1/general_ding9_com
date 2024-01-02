package com.ding9.dao.advertisement;

import com.ding9.multipleentity.AdPlaceAdvertisement;
import java.sql.SQLException;
import java.util.List;

public abstract interface AdvertisementDao
{
  public abstract String getAds(int paramInt1, int paramInt2, int paramInt3)
    throws SQLException;
  
  public abstract String getAdByChannelId(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String getLoopAds(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    throws SQLException;
  
  public abstract List getAdvertisements(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract String getAds(int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract AdPlaceAdvertisement getAdvsByChannelId(int paramInt1, int paramInt2, int paramInt3)
    throws SQLException;
  
  public abstract AdPlaceAdvertisement getAdvsByTypeId(int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract AdPlaceAdvertisement getAdvsByAdadId(int paramInt)
    throws SQLException;
  
  public abstract boolean getIsFuFei(int paramInt)
    throws SQLException;
}
