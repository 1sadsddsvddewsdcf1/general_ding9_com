package com.ding9.dao.advertisement;

import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;














public class AdvertisementDaoImpl
  implements AdvertisementDao
{
  private static Log log = LogFactory.getLog(AdvertisementDaoImpl.class);
  
  private static long lasttime = System.currentTimeMillis();
  private static HashMap results = null;
  private static HashMap allad = null;
  
  private IDBAccess dba = null;
  
  private static List result = null;
  













  public String getAds(int channelId, int adpl_type, int adpl_id)
    throws SQLException
  {
    String ads = null;
    try
    {
      getAds(channelId);
      if ((results != null) && 
        (results.get(adpl_type + "_" + adpl_id) != null)) {
        ads = results.get(adpl_type + "_" + adpl_id).toString();
      }
    } catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return ads;
  }
  













  public String getAds(int adpl_type, int adpl_id)
    throws SQLException
  {
    String ads = null;
    try
    {
      getAds();
      if ((results != null) && 
        (results.get(adpl_type + "_" + adpl_id) != null)) {
        ads = results.get(adpl_type + "_" + adpl_id).toString();
      }
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return ads;
  }
  










  public static HashMap getAds()
    throws SQLException
  {
    if ((results == null) || (System.currentTimeMillis() - lasttime > 120000L)) {
      if (log.isWarnEnabled()) {
        log.warn("重新载入定制信息时间：" + System.currentTimeMillis());
      }
      lasttime = System.currentTimeMillis();
      try
      {
        String ads = null;
        IDBAccess dba = null;
        List result = null;
        BaseResult index = new com.ding9.multipleresult.AdPlaceAdvertisement();
        
        StringBuffer sql = new StringBuffer();
        try {
          dba = new DBAccessDefaultlImpl();
          sql.append("SELECT  A.ADAD_ID,A.AD_TYPE,A.ADAD_WORD,A.ADPL_ID,");
          sql.append("A.ADAD_NAME,A.ADAD_ADDRESS,A.ADAD_PIC,C.ADPL_TYPE,C.ADPL_SIZE");
          sql.append(" FROM AD_ADVERTISEMENT A, AD_PLACE_TYPE B, AD_PLACE C");
          sql.append(" WHERE A.ADPL_ID= C.ADPL_ID AND C.ADPL_TYPE = B.ADPT_ID AND ");
          sql.append("A.ADAD_ENDTIME >= SYSDATE AND B.CHANNEL = ? AND A.DISABLE=1 ");
          dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
          

          result = dba.queryData(sql.toString(), index);
          
          if ((result != null) && (result.size() > 0)) {
            results = new HashMap();
            for (int i = 0; i < result.size(); i++) {
              com.ding9.multipleentity.AdPlaceAdvertisement adPlaceAdvertisement = (com.ding9.multipleentity.AdPlaceAdvertisement)result.get(i);
              ads = null;
              if ((adPlaceAdvertisement.getAd_type() == 1) || (adPlaceAdvertisement.getAd_type() == 2)) {
                String adpl_size = adPlaceAdvertisement.getAdpl_size();
                String[] size = adpl_size.split("×");
                String width = size[0];
                String height = size[1];
                
                if (adPlaceAdvertisement.getAd_type() == 1) {
                  if (adPlaceAdvertisement.getAdad_address() != null) {
                    ads = 
                    
                      "<a href='" + adPlaceAdvertisement.getAdad_address() + "' TARGET='_blank'>" + "\t<IMG SRC='" + adPlaceAdvertisement.getAdad_pic() + "' border='0'  />" + "</A>";
                  } else {
                    ads = "<IMG SRC='" + adPlaceAdvertisement.getAdad_pic() + "' border='0'  />";
                  }
                }
                
                if (adPlaceAdvertisement.getAd_type() == 2)
                  ads = 
                  





                    "<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000' codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0' width='" + width + "' height='" + height + "'>" + "<param name='movie' value='" + adPlaceAdvertisement.getAdad_pic() + "'>" + "<param name='quality' value='high'>" + "<embed src='" + adPlaceAdvertisement.getAdad_pic() + "' quality='high' pluginspage='http://www.macromedia.com/go/getflashplayer' type='application/x-shockwave-flash' width='" + width + "' height='" + height + "'>" + "</embed>" + "</object>";
              }
              if (adPlaceAdvertisement.getAd_type() == 3)
                ads = adPlaceAdvertisement.getAdad_word();
              results.put(adPlaceAdvertisement.getAdpl_type() + "_" + adPlaceAdvertisement.getAdpl_id(), ads);
            }
          }
        }
        catch (Exception ex) {
          if (log.isDebugEnabled()) {
            log.debug("getAds() :" + ex.getMessage());
            log.debug("SQL :" + sql.toString());
          }
        }
        index = null;
      }
      catch (Exception ex) {
        if (log.isErrorEnabled()) {
          log.error(ex.getMessage());
        }
      }
    }
    return results;
  }
  










  public static HashMap getAds(int channelId)
    throws SQLException
  {
    if ((results == null) || (System.currentTimeMillis() - lasttime > 120000L)) {
      if (log.isWarnEnabled()) {
        log.warn("重新载入定制信息时间：" + System.currentTimeMillis());
      }
      lasttime = System.currentTimeMillis();
      try
      {
        String ads = null;
        IDBAccess dba = null;
        List result = null;
        BaseResult index = new com.ding9.multipleresult.AdPlaceAdvertisement();
        
        StringBuffer sql = new StringBuffer();
        try {
          dba = new DBAccessDefaultlImpl();
          sql.append("SELECT  A.ADAD_ID,A.AD_TYPE,A.ADAD_WORD,A.ADPL_ID,");
          sql.append("A.ADAD_NAME,A.ADAD_ADDRESS,A.ADAD_PIC,C.ADPL_TYPE,C.ADPL_SIZE");
          sql.append(" FROM AD_ADVERTISEMENT A, AD_PLACE_TYPE B, AD_PLACE C");
          sql.append(" WHERE A.ADPL_ID= C.ADPL_ID AND C.ADPL_TYPE = B.ADPT_ID AND ");
          sql.append("A.ADAD_ENDTIME >= SYSDATE AND B.CHANNEL = ? AND A.DISABLE=1 ");
          dba.setParam(new SQLParam(1, 1, channelId));
          

          result = dba.queryData(sql.toString(), index);
          
          if ((result != null) && (result.size() > 0)) {
            results = new HashMap();
            for (int i = 0; i < result.size(); i++) {
              com.ding9.multipleentity.AdPlaceAdvertisement adPlaceAdvertisement = (com.ding9.multipleentity.AdPlaceAdvertisement)result.get(i);
              ads = null;
              if ((adPlaceAdvertisement.getAd_type() == 1) || (adPlaceAdvertisement.getAd_type() == 2)) {
                String adpl_size = adPlaceAdvertisement.getAdpl_size();
                String[] size = adpl_size.split("×");
                String width = size[0];
                String height = size[1];
                
                if (adPlaceAdvertisement.getAd_type() == 1) {
                  if (adPlaceAdvertisement.getAdad_address() != null) {
                    ads = 
                    
                      "<a href='" + adPlaceAdvertisement.getAdad_address() + "' TARGET='_blank'>" + "\t<IMG SRC='" + adPlaceAdvertisement.getAdad_pic() + "' border='0'  />" + "</A>";
                  } else {
                    ads = "<IMG SRC='" + adPlaceAdvertisement.getAdad_pic() + "' border='0'  />";
                  }
                }
                
                if (adPlaceAdvertisement.getAd_type() == 2) {
                  ads = 
                  





                    "<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000' codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0' width='" + width + "' height='" + height + "'>" + "<param name='movie' value='" + adPlaceAdvertisement.getAdad_pic() + "'>" + "<param name='quality' value='high'>" + "<embed src='" + adPlaceAdvertisement.getAdad_pic() + "' quality='high' pluginspage='http://www.macromedia.com/go/getflashplayer' type='application/x-shockwave-flash' width='" + width + "' height='" + height + "'>" + "</embed>" + "</object>";
                }
              }
              if (adPlaceAdvertisement.getAd_type() == 3)
                ads = adPlaceAdvertisement.getAdad_word();
              results.put(adPlaceAdvertisement.getAdpl_type() + "_" + adPlaceAdvertisement.getAdpl_id(), ads);
            }
          }
        } catch (Exception ex) {
          if (log.isDebugEnabled()) {
            log.debug("getAds() :" + ex.getMessage());
            log.debug("SQL :" + sql.toString());
          }
        }
        index = null;
      }
      catch (Exception ex) {
        if (log.isErrorEnabled()) {
          log.error(ex.getMessage());
        }
      }
    }
    return results;
  }
  



  public com.ding9.multipleentity.AdPlaceAdvertisement getAdvsByAdadId(int adad_id)
    throws SQLException
  {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new com.ding9.multipleresult.AdPlaceAdvertisement();
    com.ding9.multipleentity.AdPlaceAdvertisement advs = null;
    StringBuffer sql = new StringBuffer();
    try {
      dba = new DBAccessDefaultlImpl();
      sql.append("SELECT A.adad_id,A.AD_TYPE,A.ADAD_WORD,A.ADPL_ID,");
      sql.append("A.ADAD_NAME,A.ADAD_ADDRESS,A.ADAD_PIC,C.ADPL_TYPE,C.ADPL_SIZE,B.CHANNEL ");
      sql.append(" FROM AD_ADVERTISEMENT A, AD_PLACE_TYPE B, AD_PLACE C");
      sql.append(" WHERE A.ADPL_ID= C.ADPL_ID AND C.ADPL_TYPE = B.ADPT_ID AND ");
      sql.append("A.ADAD_ENDTIME >= SYSDATE AND rownum=1 AND A.DISABLE=1 and A.adad_id=? ");
      dba.setParam(new SQLParam(1, 1, adad_id));
      
      result = dba.queryData(sql.toString(), index);
      
      if ((result != null) && (result.size() > 0)) {
        for (int i = 0; i < result.size(); i++) {
          advs = (com.ding9.multipleentity.AdPlaceAdvertisement)result.get(i);
        }
      }
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
        log.debug("SQL :" + sql.toString());
      }
    }
    return advs;
  }
  



  public boolean getIsFuFei(int adad_id)
    throws SQLException
  {
    IDBAccess dba = null;
    int result = 0;
    boolean bl = false;
    com.ding9.multipleentity.AdPlaceAdvertisement advs = null;
    StringBuffer sql = new StringBuffer();
    try {
      dba = new DBAccessDefaultlImpl();
      sql.append(" select count(*) from ad_advisement_click t where t.flat=1 and t.adad_id=? ");
      dba.setParam(new SQLParam(1, 1, adad_id));
      
      result = dba.queryDataNumber(sql.toString());
      
      if (result > 0) {
        bl = true;
      }
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
        log.debug("SQL :" + sql.toString());
      }
    }
    return bl;
  }
  






  public String getAdByChannelId(int prso_id_one, int adpl_type, int adpl_id)
  {
    String ads = null;
    try
    {
      getAllAds();
      if (allad != null) {
        ads = allad.get(prso_id_one + "_" + adpl_type + "_" + adpl_id).toString();
      }
    } catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return ads;
  }
  






  public com.ding9.multipleentity.AdPlaceAdvertisement getAdvsByChannelId(int prso_id_one, int adpl_type, int adpl_id)
    throws SQLException
  {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new com.ding9.multipleresult.AdPlaceAdvertisement();
    com.ding9.multipleentity.AdPlaceAdvertisement advs = null;
    StringBuffer sql = new StringBuffer();
    try {
      dba = new DBAccessDefaultlImpl();
      sql.append("SELECT A.adad_id,A.AD_TYPE,A.ADAD_WORD,A.ADPL_ID,");
      sql.append("A.ADAD_NAME,A.ADAD_ADDRESS,A.ADAD_PIC,C.ADPL_TYPE,C.ADPL_SIZE,B.CHANNEL ");
      sql.append(" FROM AD_ADVERTISEMENT A, AD_PLACE_TYPE B, AD_PLACE C");
      sql.append(" WHERE A.ADPL_ID= C.ADPL_ID AND C.ADPL_TYPE = B.ADPT_ID AND ");
      sql.append("A.ADAD_ENDTIME >= SYSDATE AND B.CHANNEL in(1,4,6,8,12,7,15) and rownum=1 AND A.DISABLE=1  ");
      sql.append(" and B.CHANNEL=? and c.adpl_type=? and a.adpl_id=? ");
      dba.setParam(new SQLParam(1, 1, prso_id_one));
      dba.setParam(new SQLParam(2, 1, adpl_type));
      dba.setParam(new SQLParam(3, 1, adpl_id));
      
      result = dba.queryData(sql.toString(), index);
      
      if ((result != null) && (result.size() > 0)) {
        for (int i = 0; i < result.size(); i++) {
          advs = (com.ding9.multipleentity.AdPlaceAdvertisement)result.get(i);
        }
      }
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
        log.debug("SQL :" + sql.toString());
      }
    }
    return advs;
  }
  






  public com.ding9.multipleentity.AdPlaceAdvertisement getAdvsByTypeId(int adpl_type, int adpl_id)
    throws SQLException
  {
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new com.ding9.multipleresult.AdPlaceAdvertisement();
    com.ding9.multipleentity.AdPlaceAdvertisement advs = null;
    StringBuffer sql = new StringBuffer();
    try {
      dba = new DBAccessDefaultlImpl();
      sql.append("SELECT A.adad_id,A.AD_TYPE,A.ADAD_WORD,A.ADPL_ID,");
      sql.append("A.ADAD_NAME,A.ADAD_ADDRESS,A.ADAD_PIC,C.ADPL_TYPE,C.ADPL_SIZE,B.CHANNEL ");
      sql.append(" FROM AD_ADVERTISEMENT A, AD_PLACE_TYPE B, AD_PLACE C");
      sql.append(" WHERE A.ADPL_ID= C.ADPL_ID AND C.ADPL_TYPE = B.ADPT_ID AND ");
      sql.append("A.ADAD_ENDTIME >= SYSDATE AND rownum=1 AND A.DISABLE=1  ");
      sql.append(" and c.adpl_type=? and a.adpl_id=? ");
      dba.setParam(new SQLParam(1, 1, adpl_type));
      dba.setParam(new SQLParam(2, 1, adpl_id));
      
      result = dba.queryData(sql.toString(), index);
      
      if ((result != null) && (result.size() > 0)) {
        for (int i = 0; i < result.size(); i++) {
          advs = (com.ding9.multipleentity.AdPlaceAdvertisement)result.get(i);
        }
      }
    }
    catch (Exception ex)
    {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
        log.debug("SQL :" + sql.toString());
      }
    }
    return advs;
  }
  


  public static HashMap getAllAds()
  {
    if ((allad == null) || (System.currentTimeMillis() - lasttime > 120000L)) {
      if (log.isWarnEnabled()) {
        log.warn("重新载入所有广告信息：" + System.currentTimeMillis());
      }
      lasttime = System.currentTimeMillis();
      try
      {
        String ads = null;
        IDBAccess dba = null;
        List result = null;
        BaseResult index = new com.ding9.multipleresult.AdPlaceAdvertisement();
        
        StringBuffer sql = new StringBuffer();
        try {
          dba = new DBAccessDefaultlImpl();
          sql.append("SELECT A.ADAD_ID,A.AD_TYPE,A.ADAD_WORD,A.ADPL_ID,");
          sql.append("A.ADAD_NAME,A.ADAD_ADDRESS,A.ADAD_PIC,C.ADPL_TYPE,C.ADPL_SIZE,B.CHANNEL ");
          sql.append(" FROM AD_ADVERTISEMENT A, AD_PLACE_TYPE B, AD_PLACE C");
          sql.append(" WHERE A.ADPL_ID= C.ADPL_ID AND C.ADPL_TYPE = B.ADPT_ID AND ");
          sql.append("A.ADAD_ENDTIME >= SYSDATE AND B.CHANNEL in(1,4,6,8,12,7,15) AND A.DISABLE=1  ");
          



          result = dba.queryData(sql.toString(), index);
          
          if ((result != null) && (result.size() > 0)) {
            allad = new HashMap();
            for (int i = 0; i < result.size(); i++) {
              com.ding9.multipleentity.AdPlaceAdvertisement adPlaceAdvertisement = (com.ding9.multipleentity.AdPlaceAdvertisement)result.get(i);
              ads = null;
              if ((adPlaceAdvertisement.getAd_type() == 1) || (adPlaceAdvertisement.getAd_type() == 2)) {
                String adpl_size = adPlaceAdvertisement.getAdpl_size();
                String[] size = adpl_size.split("×");
                String width = size[0];
                String height = size[1];
                
                if (adPlaceAdvertisement.getAd_type() == 1) {
                  if (adPlaceAdvertisement.getAdad_address() != null) {
                    ads = 
                    
                      "<a href='" + adPlaceAdvertisement.getAdad_address() + "' TARGET='_blank'>" + "\t<IMG SRC='" + adPlaceAdvertisement.getAdad_pic() + "' border='0'  />" + "</A>";
                  } else {
                    ads = "<a href='/' target='_blank'><IMG SRC='" + adPlaceAdvertisement.getAdad_pic() + "' border='0'  /></a>";
                  }
                }
                
                if (adPlaceAdvertisement.getAd_type() == 2)
                  ads = 
                  





                    "<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000' codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0' width='" + width + "' height='" + height + "'>" + "<param name='movie' value='" + adPlaceAdvertisement.getAdad_pic() + "'>" + "<param name='quality' value='high'>" + "<embed src='" + adPlaceAdvertisement.getAdad_pic() + "' quality='high' pluginspage='http://www.macromedia.com/go/getflashplayer' type='application/x-shockwave-flash' width='" + width + "' height='" + height + "'>" + "</embed>" + "</object>";
              }
              if (adPlaceAdvertisement.getAd_type() == 3)
                ads = adPlaceAdvertisement.getAdad_word();
              allad.put(adPlaceAdvertisement.getChannelId() + "_" + adPlaceAdvertisement.getAdpl_type() + "_" + adPlaceAdvertisement.getAdpl_id(), ads);
            }
          }
        }
        catch (Exception ex) {
          if (log.isDebugEnabled()) {
            log.debug("getAds() :" + ex.getMessage());
            log.debug("SQL :" + sql.toString());
          }
        }
        index = null;
      }
      catch (Exception ex) {
        if (log.isErrorEnabled()) {
          log.error(ex.getMessage());
        }
      }
    }
    

    return allad;
  }
  
  public String getLoopAds(int adpl_type, int adpl_id, int focus_width, int focus_height, int text_height) throws SQLException {
    StringBuffer ads = null;
    IDBAccess dba = null;
    List result = null;
    BaseResult index = new com.ding9.multipleresult.AdPlaceAdvertisement();
    
    StringBuffer sql = new StringBuffer();
    try {
      dba = new DBAccessDefaultlImpl();
      sql.append("SELECT   A.ADAD_ID,A.AD_TYPE,A.ADAD_WORD,A.ADPL_ID,A.ADAD_NAME,");
      sql.append("A.ADAD_ADDRESS,\tA.ADAD_PIC,\tC.ADPL_TYPE,C.ADPL_SIZE");
      sql.append(" FROM AD_ADVERTISEMENT A,AD_PLACE_TYPE B ,AD_PLACE C");
      sql.append(" WHERE\tC.ADPL_ID=A.ADPL_ID\tAND\tC.ADPL_TYPE=B.ADPT_ID");
      sql.append(" AND A.ADAD_ENDTIME>=SYSDATE AND B.CHANNEL=?");
      sql.append(" AND C.ADPL_TYPE=?\tAND A.ADPL_ID=? AND A.DISABLE=1 ");
      dba.setParam(new SQLParam(1, 1, Environment.getChannelId()));
      dba.setParam(new SQLParam(2, 1, adpl_type));
      dba.setParam(new SQLParam(3, 1, adpl_id));
      

      result = dba.queryData(sql.toString(), index);
      if (result != null) {
        com.ding9.multipleentity.AdPlaceAdvertisement entity = null;
        



        String[] pics = new String[result.size()];
        String[] links = new String[result.size()];
        String[] texts = new String[result.size()];
        

        if (pics.length > 0) {
          ads = new StringBuffer("");
          for (int i = 0; i < result.size(); i++) {
            entity = (com.ding9.multipleentity.AdPlaceAdvertisement)result.get(i);
            if ((entity.getAdad_pic() != null) && (!entity.getAdad_pic().equals(""))) {
              pics[i] = entity.getAdad_pic();
              texts[i] = entity.getAdad_name();
              links[i] = entity.getAdad_address();
              int j = i + 1;
              ads.append("imgAlt[" + j + "]='" + texts[i] + "'; imgUrl[" + j + "]='").append(pics[i]).append("'; imgtext[" + j + "]='<a href=\"" + links[i] + "\" target=\"_blank\" class=linkblack>" + texts[i] + "</a>'; imgLink[" + j + "]='").append(links[i]).append("';");
            }
          }
        }
      }
    }
    catch (Exception ex)
    {
      if (log.isDebugEnabled()) {
        log.debug("getLoopAds() :" + ex.getMessage());
        log.debug("SQL :" + sql.toString());
      }
    }
    index = null;
    if (ads == null) return null;
    return ads.toString();
  }
  




  public List getAdvertisements(int channelId, int placeTypeId, int placeId, int type, int pagesize, int currentpage)
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult map = new com.ding9.multipleresult.AdPlaceAdvertisement();
    
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT  A.ADAD_ID,a.ad_type,a.adad_word,a.adpl_id,a.adad_name,a.adad_address,a.adad_pic,c.adpl_type,c.adpl_size,b.channel ");
    sql.append("FROM ad_advertisement a, ad_place_type b, ad_place c ");
    sql.append("WHERE a.adpl_id= c.adpl_id AND c.adpl_type = b.adpt_id AND a.adad_endtime >= sysdate AND a.disable=1 ");
    sql.append("AND b.channel =? AND a.adty_id=? AND a.adpl_id=? AND a.ad_type=? ");
    this.dba.setParam(new SQLParam(1, 1, channelId));
    this.dba.setParam(new SQLParam(2, 1, placeTypeId));
    this.dba.setParam(new SQLParam(3, 1, placeId));
    this.dba.setParam(new SQLParam(4, 1, type));
    
    result = this.dba.queryDataPagination(sql.toString(), map, pagesize, currentpage);
    
    sql = null;
    map = null;
    
    return result;
  }
}
