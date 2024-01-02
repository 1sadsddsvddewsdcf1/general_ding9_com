package com.ding9.util;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class Environment
{
  private static final Log log = LogFactory.getLog(Environment.class);
  
  private static long lasttime = System.currentTimeMillis();
  

  private static HashMap hm = null;
  private static String PROP_FILE = "server.properties";
  private static String IMAGE_SERVER = "image_server";
  private static String MAIN_SERVER = "main_server";
  private static String REWRITE_SWITCH = "rewrite_switch";
  private static String IMG_DING9 = "img_ding9_server";
  private static String TEMP_PRODUCT_PICTURE = "temp_product_picture";
  
  private static String CHANNELID = "channel_id";
  private static String CHANNELMERCHANT = "channel_merchant";
  private static String CHANNELSALE = "channel_sale";
  private static String DOMAINNAME = "domain_name";
  
  private static String CHANNELLOVE = "channel_love";
  private static String CHANNELMOBILE = "channel_mobile";
  private static String CHANNELDIGITAL = "channel_digital";
  private static String CHANNELBEAUTY = "channel_beauty";
  private static String CHANNELD9SENSE = "channel_d9sense";
  

  private static String CHANNELOFFICE = "channel_office";
  private static String CHANNELHEA = "channel_hea";
  private static String CHANNELCOMPUTER = "channel_computer";
  
  private static String CHANNELCOUPON = "channel_coupon";
  private static String CHANNELPROMOTION = "channel_promotion";
  private static String CHANNELCASHREBATE = "channel_cashrebate";
  private static String CHANNELYOUHUI = "channel_youhui";
 
  private static String SHOPCITYID = "shopcity_id"; 
  
  private static String CHANNELSEARCH = "channel_search";
  private static String CHANNELSHOP = "channel_shop";
  private static String CHANNELMAIN = "channel_main";
  private static String CHANNELCOSTUME = "channel_costume";
  private static String CHANNELBOOK = "channel_book";
  private static String CHANNELHEADGEAR = "channel_headgear";
  private static String CHANNELGIFT = "channel_gift";
  private static String CHANNELSPORT = "channel_sport";
  private static String CHANNELCHILD = "channel_child";
  
  public static int CHANNEL_ID = getChannelId();
  public static String CHANNEL_MERCHANT = getChannelMerchant();
  public static String CHANNEL_SALE = getChannelSale();
  
  public static String getChannelShop() {
    loadProperties();
    return (String)hm.get(CHANNELSHOP);
  }
  
  public static String getChannelCostume() {
    loadProperties();
    return (String)hm.get(CHANNELCOSTUME);
  }
  
  public static String getChannelBook() {
    loadProperties();
    return (String)hm.get(CHANNELBOOK);
  }
  
  public static String getChannelHeadgear() {
    loadProperties();
    return (String)hm.get(CHANNELHEADGEAR);
  }
  
  public static String getChannelGift() {
    loadProperties();
    return (String)hm.get(CHANNELGIFT);
  }
  
  public static String getChannelSport() {
    loadProperties();
    return (String)hm.get(CHANNELSPORT);
  }
  
  public static String getChannelChild() {
    loadProperties();
    return (String)hm.get(CHANNELCHILD);
  }
  
  public static String getChannelMain() {
    loadProperties();
    return (String)hm.get(CHANNELMAIN);
  }
  
  public static String getTempProductPicture() {
    loadProperties();
    return (String)hm.get(TEMP_PRODUCT_PICTURE);
  }
  
  public static String getChannelLove() { loadProperties();
    return (String)hm.get(CHANNELLOVE);
  }
  
  public static String getChannelMobile() { loadProperties();
    return (String)hm.get(CHANNELMOBILE);
  }
  
  public static String getChannelDigital() { loadProperties();
    return (String)hm.get(CHANNELDIGITAL);
  }
  
  public static String getChannelSearch() { loadProperties();
    return (String)hm.get(CHANNELSEARCH);
  }
  
  public static String getChannelBeauty() { loadProperties();
    return (String)hm.get(CHANNELBEAUTY);
  }
  
  public static String getImageServer() { loadProperties();
    return (String)hm.get(IMAGE_SERVER);
  }
  
  public static String getImageDing9() { loadProperties();
    return (String)hm.get(IMG_DING9);
  }
  
  public static String getMainServer() { loadProperties();
    return (String)hm.get(MAIN_SERVER);
  }
  
  public static int getChannelId() {
    loadProperties();
    return Integer.parseInt((String)hm.get(CHANNELID));
  }
  
  public static String getChannelMerchant() { loadProperties();
    return (String)hm.get(CHANNELMERCHANT);
  }
  
  public static String getChannelD9Sense() { loadProperties();
    return (String)hm.get(CHANNELD9SENSE);
  }
  
  public static String getChannelOffice() {
    loadProperties();
    return (String)hm.get(CHANNELOFFICE);
  }
  
  public static String getChannelHea() { loadProperties();
    return (String)hm.get(CHANNELHEA);
  }
  
  public static String getChannelComputer() { loadProperties();
    return (String)hm.get(CHANNELCOMPUTER);
  }
  
  public static String getChannelSale() {
    loadProperties();
    return (String)hm.get(CHANNELSALE);
  }
  
  public static String getChannelCoupon() {
    loadProperties();
    return (String)hm.get(CHANNELCOUPON);
  }
  
  public static String getChannelPromotion() { loadProperties();
    return (String)hm.get(CHANNELPROMOTION);
  }
  
  public static String getChannelCashrebate() { loadProperties();
    return (String)hm.get(CHANNELCASHREBATE);
  }
  
  public static String getChannelYouhui() {
    loadProperties();
    return (String)hm.get(CHANNELYOUHUI);
  }
  
  public static String getDomainName() { loadProperties();
    return (String)hm.get(DOMAINNAME);
  }
  
  public static int getShopCityId() { loadProperties();
    return Integer.parseInt((String)hm.get(SHOPCITYID));
  }
  
  public static boolean getRewriteSwitch() {
    
    if ("true".equals(((String)hm.get(REWRITE_SWITCH)).toLowerCase())) {
      return true;
    }
    return false;
  }
  
  private static void loadProperties()
  {
    if ((hm == null) || (System.currentTimeMillis() - lasttime > 120000L)) {
      if (log.isDebugEnabled()) {
        log.debug("重新载入定制信息时间：" + System.currentTimeMillis());
      }
      lasttime = System.currentTimeMillis();
      
      hm = new HashMap();
      hm.put(IMAGE_SERVER, ConfigManager.getInstance(PROP_FILE).getConfigItem(IMAGE_SERVER, "").toString());
      hm.put(IMG_DING9, ConfigManager.getInstance(PROP_FILE).getConfigItem(IMG_DING9, "").toString());
      hm.put(MAIN_SERVER, ConfigManager.getInstance(PROP_FILE).getConfigItem(MAIN_SERVER, "").toString());
      hm.put(REWRITE_SWITCH, ConfigManager.getInstance(PROP_FILE).getConfigItem(REWRITE_SWITCH, "").toString());
      hm.put(TEMP_PRODUCT_PICTURE, ConfigManager.getInstance(PROP_FILE).getConfigItem(TEMP_PRODUCT_PICTURE, "").toString());
      
      hm.put(CHANNELID, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELID, "").toString());
      hm.put(CHANNELMERCHANT, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELMERCHANT, "").toString());
      hm.put(CHANNELSALE, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELSALE, "").toString());
      hm.put(DOMAINNAME, ConfigManager.getInstance(PROP_FILE).getConfigItem(DOMAINNAME, "").toString());
      hm.put(CHANNELLOVE, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELLOVE, "").toString());
      hm.put(CHANNELMOBILE, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELMOBILE, "").toString());
      hm.put(CHANNELDIGITAL, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELDIGITAL, "").toString());
      hm.put(CHANNELBEAUTY, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELBEAUTY, "").toString());
      hm.put(CHANNELD9SENSE, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELD9SENSE, "").toString());
      hm.put(CHANNELOFFICE, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELOFFICE, "").toString());
      hm.put(CHANNELHEA, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELHEA, "").toString());
      hm.put(CHANNELCOMPUTER, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELCOMPUTER, "").toString());
      
      hm.put(CHANNELCOUPON, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELCOUPON, "").toString());
      hm.put(CHANNELPROMOTION, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELPROMOTION, "").toString());
      hm.put(CHANNELCASHREBATE, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELCASHREBATE, "").toString());
      hm.put(CHANNELYOUHUI, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELYOUHUI, "").toString());
      
      hm.put(CHANNELSEARCH, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELSEARCH, "").toString());
      
      hm.put(CHANNELSHOP, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELSHOP, "").toString());
      hm.put(CHANNELMAIN, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELMAIN, "").toString());
      hm.put(CHANNELCOSTUME, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELCOSTUME, "").toString());
      hm.put(CHANNELBOOK, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELBOOK, "").toString());
      hm.put(CHANNELHEADGEAR, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELHEADGEAR, "").toString());
      hm.put(CHANNELGIFT, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELGIFT, "").toString());
      hm.put(CHANNELSPORT, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELSPORT, "").toString());
      hm.put(CHANNELCHILD, ConfigManager.getInstance(PROP_FILE).getConfigItem(CHANNELCHILD, "").toString());
    }
  }
}
