package com.ding9.multipleresult;

import com.ding9.sql.BaseResult;
import com.ding9.util.GetImg;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdPlaceAdvertisement implements BaseResult
{
  private com.ding9.multipleentity.AdPlaceAdvertisement adPlaceAdvertisement = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException
  {
    this.adPlaceAdvertisement = new com.ding9.multipleentity.AdPlaceAdvertisement();
    try
    {
      this.adPlaceAdvertisement.setAdad_id(resultset.getInt("adad_id"));
    } catch (Exception localException) {}
    try {
      this.adPlaceAdvertisement.setAd_type(resultset.getInt("ad_type"));
    } catch (Exception localException1) {}
    try {
      this.adPlaceAdvertisement.setAdpl_id(resultset.getInt("adpl_id"));
    } catch (Exception localException2) {}
    try {
      this.adPlaceAdvertisement.setAdpl_type(resultset.getInt("adpl_type"));
    } catch (Exception localException3) {}
    try {
      this.adPlaceAdvertisement.setAdad_address(resultset.getString("adad_address"));
    } catch (Exception localException4) {}
    try {
      String adad_pic = resultset.getString("adad_pic");
      adad_pic = adad_pic.replace("..", "");
      this.adPlaceAdvertisement.setAdad_pic(GetImg.Image(adad_pic, adad_pic));
    } catch (Exception localException5) {}
    try {
      this.adPlaceAdvertisement.setAdpl_size(resultset.getString("adpl_size"));
    } catch (Exception localException6) {}
    try {
      this.adPlaceAdvertisement.setAdad_name(resultset.getString("adad_name"));
    } catch (Exception localException7) {}
    try {
      this.adPlaceAdvertisement.setAdad_word(resultset.getString("adad_word"));
    } catch (Exception localException8) {}
    try {
      this.adPlaceAdvertisement.setChannelId(resultset.getInt("channel"));
    }
    catch (Exception localException9) {}
    return this.adPlaceAdvertisement;
  }
}
