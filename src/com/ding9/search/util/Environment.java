package com.ding9.search.util;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Environment
{
  private static final Log log = LogFactory.getLog(Environment.class);
  
  public static final String STATUS_RUNNING = "status_running";
  
  public static final String STATUS_INDEXING = "status_indexing";
  
  private static long lasttime = System.currentTimeMillis();
  

  private static HashMap hm = null;
  private static String PROP_FILE = "ding9searchserver.properties";
  
  private static String IMAGE_SERVER = "image_server";
  
  private static String TEMP_PRODUCT_PICTURE = "temp_product_picture";
  
  private static String PRODUCTMASTERMAIN_INDEX_DIR = "productmastermain_index_dir";
  private static String PRODUCTMASTERSORT_INDEX_DIR = "productmastersort_index_dir";
  private static String PRODUCTMASTERBRAND_INDEX_DIR = "productmasterbrand_index_dir";
  
  private static String MERCHANTPRODUCTMAIN_INDEX_DIR = "merchantproductmain_index_dir";
  
  private static String ARTICLEMAIN_INDEX_DIR = "articlemain_index_dir";
  private static String CHEAPCARDMAIN_INDEX_DIR = "cheapcardmain_index_dir";
  private static String PROMOTIONMAIN_INDEX_DIR = "promotionmain_index_dir";
  private static String COMMENTMAIN_INDEX_DIR = "commentmain_index_dir";
  

  private static String MERCHANTINFO_INDEX_DIR = "merchantinfo_index_dir";
  private static String RESTORE_INDEX_DIR = "restore_index_dir";
  private static String RODUCTPARASORT_INDEX_DIR = "productparasort_index_dir";
  
  public static String getRestore_Index_Dir() {
    loadProperties();
    return (String)hm.get(RESTORE_INDEX_DIR);
  }
  
  public static String getMerchantProductMainIndex() {
    loadProperties();
    return (String)hm.get(MERCHANTPRODUCTMAIN_INDEX_DIR);
  }
  
  public static String getMerchantInfo_Index_Dir() {
    loadProperties();
    return (String)hm.get(MERCHANTINFO_INDEX_DIR);
  }
  
  public static String getProductMasterMain_Index_Dir() {
    loadProperties();
    return (String)hm.get(PRODUCTMASTERMAIN_INDEX_DIR);
  }
  
  public static String getProductMasterSort_Index_Dir() {
    loadProperties();
    return (String)hm.get(PRODUCTMASTERSORT_INDEX_DIR);
  }
  
  public static String getProductMasterBrand_Index_Dir() {
    loadProperties();
    return (String)hm.get(PRODUCTMASTERBRAND_INDEX_DIR);
  }
  
  public static String getArticleMain_Index_Dir() {
    loadProperties();
    return (String)hm.get(ARTICLEMAIN_INDEX_DIR);
  }
  
  public static String getCheapCardMain_Index_Dir() {
    loadProperties();
    return (String)hm.get(CHEAPCARDMAIN_INDEX_DIR);
  }
  
  public static String getPromotionMain_Index_Dir() {
    loadProperties();
    return (String)hm.get(PROMOTIONMAIN_INDEX_DIR);
  }
  
  public static String getCommentMain_Index_Dir() {
    loadProperties();
    return (String)hm.get(COMMENTMAIN_INDEX_DIR);
  }
  
  public static String getImageServer() {
    loadProperties();
    return (String)hm.get(IMAGE_SERVER);
  }
  
  public static String getTempProductPicture() {
    loadProperties();
    return (String)hm.get(TEMP_PRODUCT_PICTURE);
  }
  
  public static String getProductParaSort_Index_Dir() { loadProperties();
    return (String)hm.get(RODUCTPARASORT_INDEX_DIR);
  }
  


  public static String get(String prop_name) { return ConfigManager.getInstance(PROP_FILE).getConfigItem(prop_name, "").toString(); }
  
  private static void loadProperties() {
    if ((hm == null) || (System.currentTimeMillis() - lasttime > 120000L)) {
      if (log.isDebugEnabled()) {
        log.debug("重新载入定制信息时间：" + System.currentTimeMillis());
      }
      lasttime = System.currentTimeMillis();
      
      hm = new HashMap();
      
      hm.put(IMAGE_SERVER, ConfigManager.getInstance(PROP_FILE).getConfigItem(IMAGE_SERVER, "").toString());
      
      hm.put(TEMP_PRODUCT_PICTURE, ConfigManager.getInstance(PROP_FILE).getConfigItem(TEMP_PRODUCT_PICTURE, "").toString());
      
      hm.put(PRODUCTMASTERMAIN_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(PRODUCTMASTERMAIN_INDEX_DIR, "").toString());
      
      hm.put(PRODUCTMASTERSORT_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(PRODUCTMASTERSORT_INDEX_DIR, "").toString());
      
      hm.put(PRODUCTMASTERBRAND_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(PRODUCTMASTERBRAND_INDEX_DIR, "").toString());
      
      hm.put(ARTICLEMAIN_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(ARTICLEMAIN_INDEX_DIR, "").toString());
      
      hm.put(CHEAPCARDMAIN_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHEAPCARDMAIN_INDEX_DIR, "").toString());
      
      hm.put(PROMOTIONMAIN_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(PROMOTIONMAIN_INDEX_DIR, "").toString());
      
      hm.put(COMMENTMAIN_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(COMMENTMAIN_INDEX_DIR, "").toString());
      
      hm.put(MERCHANTINFO_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(MERCHANTINFO_INDEX_DIR, "").toString());
      
      hm.put(RESTORE_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(RESTORE_INDEX_DIR, "").toString());
      
      hm.put(MERCHANTPRODUCTMAIN_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(MERCHANTPRODUCTMAIN_INDEX_DIR, "").toString());
      
      hm.put(RODUCTPARASORT_INDEX_DIR, ConfigManager.getInstance(PROP_FILE).getConfigItem(RODUCTPARASORT_INDEX_DIR, "").toString());
    }
  }
}
