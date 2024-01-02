package com.ding9.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProjectEnvironment
{
  private static final Log log = LogFactory.getLog(ProjectEnvironment.class);
  
  private static long lasttime = System.currentTimeMillis();
  



  public static final int NEWSLIST_ITEM_QTY = 8;
  



  public static final int NEWSLIST_ITEM_LEN = 28;
  


  public static final int NEWSLIST_QTY = 20;
  


  public static final int PRMA_REMARK_SIZE = 160;
  


  private static HashMap hm = null;
  
  private static String COMPANY = "company";
  private static String SUBJECT = "subject";
  private static String ROBOTS = "robots";
  private static String COPYRIGHT = "copyright";
  private static String DISTRIBUTION = "distribution";
  




  public static String getMETA()
  {
    StringBuffer result = new StringBuffer();
    loadProperties();
    
    result.append("<META NAME='Author' CONTENT='" + (String)hm.get(COMPANY) + "'/>");
    result.append("<META NAME='Subject' CONTENT='" + (String)hm.get(SUBJECT) + "'/>");
    result.append("<META NAME='Robots' CONTENT='" + (String)hm.get(ROBOTS) + "'/>");
    result.append("<META NAME='Copyright' CONTENT='" + (String)hm.get(COPYRIGHT) + "'/>");
    result.append("<META NAME='Distribution' CONTENT='" + (String)hm.get(DISTRIBUTION) + "'/>");
    
    return result.toString();
  }
  






  public static HashMap getPlayment()
  {
    HashMap pm = new HashMap();
    
    return pm;
  }
  
  private static void loadProperties() {
    if ((hm == null) || (System.currentTimeMillis() - lasttime > 120000L)) {
      if (log.isDebugEnabled()) {
        log.debug("重新载入定制信息时间：" + System.currentTimeMillis());
      }
      lasttime = System.currentTimeMillis();
      
      hm = new HashMap();
    }
  }
  










  public static HashMap getUrlInfos()
  {
    HashMap urlinfo = new HashMap();
    List praminfo = null;
    

    praminfo = new ArrayList();
    urlinfo.put("/index", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "synt_id");
    praminfo.add(1, "page_size");
    praminfo.add(2, "current_page");
    urlinfo.put("/pinglun", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "prma_id");
    praminfo.add(1, "type");
    praminfo.add(2, "current_page");
    urlinfo.put("/product/product-info", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "dell_id");
    praminfo.add(1, "prso_id");
    urlinfo.put("/product/product-compare", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "synt_id");
    praminfo.add(1, "page_size");
    praminfo.add(2, "current_page");
    urlinfo.put("/focus", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "prma_name");
    praminfo.add(1, "prma_id");
    praminfo.add(2, "prbr_id");
    praminfo.add(3, "prso_id_one");
    praminfo.add(4, "prso_id_three");
    praminfo.add(5, "current_page");
    praminfo.add(6, "order_asc_desc");
    praminfo.add(7, "page_size");
    praminfo.add(8, "min_price");
    praminfo.add(9, "max_price");
    praminfo.add(10, "type");
    urlinfo.put("/product/product-type", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "mercid");
    urlinfo.put("/member/tmp", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "merc_id");
    urlinfo.put("/member/merchant", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "merc_id");
    praminfo.add(1, "current_page");
    urlinfo.put("/member/merchant-talk", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "syne_id");
    urlinfo.put("/comment", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "shopid");
    praminfo.add(1, "typeid");
    praminfo.add(2, "infoid");
    urlinfo.put("/shop/coupon-detail", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "synt_id");
    praminfo.add(1, "page_size");
    praminfo.add(2, "current_page");
    urlinfo.put("/event", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "synt_id");
    praminfo.add(1, "page_size");
    praminfo.add(2, "current_page");
    urlinfo.put("/media", praminfo);
    

    praminfo = new ArrayList();
    urlinfo.put("/labe", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "msg");
    urlinfo.put("/switch", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add("key");
    urlinfo.put("/search", praminfo);
    




    praminfo = new ArrayList();
    praminfo.add(0, "article_id");
    praminfo.add(1, "current_page");
    praminfo.add(2, "channelId");
    urlinfo.put("/news/news-info", praminfo);
    
    praminfo = new ArrayList();
    praminfo.add(0, "memt_id");
    praminfo.add(1, "article_id");
    praminfo.add(2, "relation_type");
    praminfo.add(3, "relation_value");
    praminfo.add(4, "prso_id_one");
    praminfo.add(5, "page_size");
    praminfo.add(6, "current_page");
    urlinfo.put("/news/news-list", praminfo);
    
    praminfo = new ArrayList();
    praminfo.add(0, "info_id");
    urlinfo.put("/news-info", praminfo);
    

    praminfo = new ArrayList();
    praminfo.add(0, "prma_id");
    praminfo.add(1, "price");
    praminfo.add(2, "city");
    praminfo.add(3, "prso_id_three");
    praminfo.add(4, "mesfag");
    praminfo.add(5, "credit");
    praminfo.add(6, "pay");
    praminfo.add(7, "all");
    praminfo.add(8, "type");
    praminfo.add(9, "current_page");
    praminfo.add(10, "sort");
    praminfo.add(11, "pageSize");
    urlinfo.put("/product/product-info", praminfo);
    
    praminfo = new ArrayList();
    praminfo.add(0, "memt_id");
    praminfo.add(1, "article_id");
    praminfo.add(2, "info_pic");
    urlinfo.put("/news/info", praminfo);
    
    praminfo = new ArrayList();
    praminfo.add(0, "info_id");
    urlinfo.put("/more-news-info", praminfo);
    
    return urlinfo;
  }
  
  private static HashMap hmchannel = null;
  
  private static void loadChannelInfo() {
    if (hmchannel == null) {
      hmchannel = new HashMap();
      
      hmchannel.put("0", "http://search.ding9.com");
      hmchannel.put("6", Environment.getChannelMobile());
      hmchannel.put("1", Environment.getChannelDigital());
      hmchannel.put("7", Environment.getChannelComputer());
      hmchannel.put("15", Environment.getChannelOffice());
      hmchannel.put("12", Environment.getChannelHea());
      hmchannel.put("8", Environment.getChannelBeauty());
      hmchannel.put("4", Environment.getChannelLove());
    }
  }
  
  public static String getChannelDomainName(String channel_id) {
    loadChannelInfo();
    
    String result = null;
    try
    {
      result = (String)hmchannel.get(channel_id);
    } catch (Exception ex) {
      ex.printStackTrace();
      result = null;
    }
    
    result = result == null ? "" : result.trim();
    
    return result;
  }
}
