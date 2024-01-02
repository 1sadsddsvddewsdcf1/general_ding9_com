package com.ding9.util;

import com.ding9.dao.indexkey.IndexKeyDao;
import com.ding9.dao.indexkey.IndexKeyDaoImpl;
import com.ding9.entity.indexkey.KeywordsOptimize;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;






public class KeywordsOptimizeFactory
{
  private static final Log log = LogFactory.getLog(KeywordsOptimizeFactory.class);
  private static KeywordsOptimizeFactory instance = null;
  private static Map keyword = null;
  
  private static long lasttime = System.currentTimeMillis();
  
  private KeywordsOptimizeFactory() {
    initdata();
  }
  
  private static void initdata() {
    IndexKeyDao dao = null;
    if ((keyword == null) || (System.currentTimeMillis() - lasttime > 3600000L)) {
      dao = new IndexKeyDaoImpl();
      try
      {
        List result = dao.getKeywordsOptimize(Environment.getChannelId());
        if (result.size() > 0) {
          keyword = new HashMap();
          KeywordsOptimize record = null;
          for (int i = 0; i < result.size(); i++) {
            record = (KeywordsOptimize)result.get(i);
            keyword.put(new Integer(record.getKeot_id()), record);
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      finally {
        dao = null;
      }
    }
  }
  

  public static synchronized KeywordsOptimizeFactory getInstance()
  {
    if (instance == null) instance = new KeywordsOptimizeFactory();
    return instance;
  }
  




  public String getKeopTitle(int keotId, Map param)
  {
    initdata();
    String title = "www.ding9.com";
    if ((keyword != null) && 
      (keyword.get(new Integer(keotId)) != null)) {
      KeywordsOptimize key = (KeywordsOptimize)keyword.get(new Integer(keotId));
      
      if (key != null) {
        title = key.getKeop_title();
        if (param != null) {
          Set ket = param.keySet();
          Iterator itor = ket.iterator();
          String str = "";
          while (itor.hasNext()) {
            str = (String)itor.next();
            try {
              title = title.replaceAll(str, param.get(str).toString());
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    

    return title;
  }
  





  public String getKeopKeyWords(int keotId, Map param)
  {
    initdata();
    String title = null;
    if ((keyword != null) && 
      (keyword.get(new Integer(keotId)) != null)) {
      KeywordsOptimize key = (KeywordsOptimize)keyword.get(new Integer(keotId));
      
      if (key != null) {
        title = key.getKeop_keywords();
        if (param != null) {
          Set ket = param.keySet();
          Iterator itor = ket.iterator();
          String str = "";
          while (itor.hasNext()) {
            str = (String)itor.next();
            try {
              title = title.replaceAll(str, param.get(str).toString());
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    

    return title;
  }
  





  public String getKeopDescription(int keotId, Map param)
  {
    initdata();
    String title = null;
    if ((keyword != null) && 
      (keyword.get(new Integer(keotId)) != null)) {
      KeywordsOptimize key = (KeywordsOptimize)keyword.get(new Integer(keotId));
      
      if (key != null) {
        title = key.getKeop_description();
        if (param != null) {
          Set ket = param.keySet();
          Iterator itor = ket.iterator();
          String str = "";
          while (itor.hasNext()) {
            str = (String)itor.next();
            try {
              title = title.replaceAll(str, param.get(str).toString());
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    

    return title;
  }
}
