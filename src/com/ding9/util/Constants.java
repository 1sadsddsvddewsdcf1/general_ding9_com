package com.ding9.util;


public class Constants
{
  public static final int COSTUME_SORT_ID = 5;
  
  public static final int GIFT_SORT_ID = 10;
  
  public static final int CHILD_SORT_ID = 14;
  
  public static final int HEADGEAR_SORT_ID = 9;
  
  public static final int BOOK_SORT_ID = 3;
  
  public static final int SPORT_SORT_ID = 13;
  
  public static final String COSTUME_NAME = "服装服饰";
  
  public static final String GIFT_NAME = "礼品鲜花";
  
  public static final String CHILD_NAME = "母婴儿童";
  
  public static final String HEADGEAR_NAME = "精品饰品";
  
  public static final String BOOK_NAME = "图书音像";
  
  public static final String SPORT_NAME = "体育户外";
  
  public static final int COSTUME_SORT_TEXT_ID = 43;
  
  public static final int GIFT_SORT_TEXT_ID = 47;
  
  public static final int CHILD_SORT_TEXT_ID = 51;
  
  public static final int HEADGEAR_SORT_TEXT_ID = 45;
  
  public static final int BOOK_SORT_TEXT_ID = 41;
  
  public static final int SPORT_SORT_TEXT_ID = 49;
  
  public static final int COSTUME_COOPERATE_ID = 44;
  
  public static final int GIFT_COOPERATE_ID = 48;
  
  public static final int CHILD_COOPERATE_ID = 52;
  
  public static final int HEADGEAR_COOPERATE_ID = 46;
  
  public static final int BOOK_COOPERATE_ID = 42;
  
  public static final int SPORT_COOPERATE_ID = 50;
  
  public static final int COSTUME_INFO_TEST = 50;
  
  public static final int COSTUME_INFO_GUIDE = 51;
  
  public static final int GIFT_INFO_TEST = 54;
  
  public static final int GIFT_INFO_GUIDE = 55;
  
  public static final int CHILD_INFO_TEST = 58;
  
  public static final int CHILD_INFO_GUIDE = 59;
  
  public static final int HEADGEAR_INFO_TEST = 52;
  public static final int HEADGEAR_INFO_GUIDE = 53;
  public static final int BOOK_INFO_TEST = 48;
  public static final int BOOK_INFO_GUIDE = 49;
  public static final int SPORT_INFO_TEST = 56;
  public static final int SPORT_INFO_GUIDE = 57;
  public static final int COSTUME_AD_PLACE_TYPE = 88;
  public static final int COSTUME_PLAY_Ad = 437;
  public static final int COSTUME_TEXT_AD = 438;
  public static final int COSTUME_BOTTOM_AD = 439;
  public static final int COSTUME_MIDDLE_AD = 440;
  public static final int COSTUME_MIDDLE_BANNER_AD = 589;
  public static final int COSTUME_MIDDLE_BUTTON_AD = 580;
  public static final int GIFT_AD_PLACE_TYPE = 98;
  public static final int GIFT_PLAY_Ad = 469;
  public static final int GIFT_TEXT_AD = 470;
  public static final int GIFT_BOTTOM_AD = 471;
  public static final int GIFT_MIDDLE_AD = 472;
  public static final int GIFT_MIDDLE_BANNER_AD = 581;
  public static final int GIFT_MIDDLE_BUTTON_AD = 582;
  public static final int CHILD_AD_PLACE_TYPE = 108;
  public static final int CHILD_PLAY_Ad = 501;
  public static final int CHILD_TEXT_AD = 502;
  public static final int CHILD_BOTTOM_AD = 503;
  public static final int CHILD_MIDDLE_AD = 504;
  public static final int CHILD_MIDDLE_BANNER_AD = 583;
  public static final int CHILD_MIDDLE_BUTTON_AD = 584;
  public static final int HEADGEAR_AD_PLACE_TYPE = 93;
  public static final int HEADGEAR_PLAY_Ad = 453;
  public static final int HEADGEAR_TEXT_AD = 454;
  public static final int HEADGEAR_BOTTOM_AD = 455;
  public static final int HEADGEAR_MIDDLE_AD = 456;
  public static final int HEADGEAR_MIDDLE_BANNER_AD = 590;
  public static final int HEADGEAR_MIDDLE_BUTTON_AD = 591;
  public static final int BOOK_AD_PLACE_TYPE = 83;
  public static final int BOOK_PLAY_Ad = 421;
  public static final int BOOK_TEXT_AD = 422;
  public static final int BOOK_BOTTOM_AD = 423;
  public static final int BOOK_MIDDLE_AD = 424;
  public static final int BOOK_MIDDLE_BANNER_AD = 585;
  public static final int BOOK_MIDDLE_BUTTON_AD = 586;
  public static final int SPORT_AD_PLACE_TYPE = 103;
  public static final int SPORT_PLAY_Ad = 485;
  public static final int SPORT_TEXT_AD = 486;
  public static final int SPORT_BOTTOM_AD = 487;
  public static final int SPORT_MIDDLE_AD = 488;
  public static final int SPORT_MIDDLE_BANNER_AD = 587;
  public static final int SPORT_MIDDLE_BUTTON_AD = 588;
  public static final int BOOK_RECOM_PRODUCT = 69;
  public static final int BOOK_HOT_PRODUCT = 70;
  public static final int COSTUME_RECOM_PRODUCT = 71;
  public static final int COSTUME_HOT_PRODUCT = 72;
  public static final int HEADGEAR_RECOM_PRODUCT = 73;
  public static final int HEADGEAR_HOT_PRODUCT = 74;
  public static final int GIFT_RECOM_PRODUCT = 75;
  public static final int GIFT_HOT_PRODUCT = 76;
  public static final int SPORT_RECOM_PRODUCT = 77;
  public static final int SPORT_HOT_PRODUCT = 78;
  public static final int CHILD_RECOM_PRODUCT = 79;
  public static final int CHILD_HOT_PRODUCT = 80;
  public static final String COSTUME_FOLDER = "/images/fzfs/";
  public static final String GIFT_FOLDER = "/images/lpxh/";
  public static final String CHILD_FOLDER = "/images/myet/";
  public static final String HEADGEAR_FOLDER = "/images/sssb/";
  public static final String BOOK_FOLDER = "/images/tsyx/";
  public static final String SPORT_FOLDER = "/images/tyhw/";
  public static final String COSTUME_DOMAIN = Environment.getChannelCostume();//2014-03-06 
  public static final String GIFT_DOMAIN = Environment.getChannelGift();
  public static final String CHILD_DOMAIN = Environment.getChannelChild();
  public static final String HEADGEAR_DOMAIN = Environment.getChannelHeadgear();
  public static final String BOOK_DOMAIN = Environment.getChannelBook();
  public static final String SPORT_DOMAIN = Environment.getChannelSport();
  






  public static String getChannelName(int channelId)
  {
    String channelName = null;
    switch (channelId) {
    case 5: 
      channelName = "服装服饰";
      break;
    case 10: 
      channelName = "礼品鲜花";
      break;
    case 14: 
      channelName = "母婴儿童";
      break;
    case 9: 
      channelName = "精品饰品";
      break;
    case 3: 
      channelName = "图书音像";
      break;
    case 13: 
      channelName = "体育户外";
      break;
    }
    
    
    return channelName;
  }
  






  public static String getChannelDomain(int channelId)
  {
    String channelDomain = null;
    switch (channelId) {
    case 5: 
      channelDomain = COSTUME_DOMAIN;
      break;
    case 10: 
      channelDomain = GIFT_DOMAIN;
      break;
    case 14: 
      channelDomain = CHILD_DOMAIN;
      break;
    case 9: 
      channelDomain = HEADGEAR_DOMAIN;
      break;
    case 3: 
      channelDomain = BOOK_DOMAIN;
      break;
    case 13: 
      channelDomain = SPORT_DOMAIN;
      break;
    }
    
    
    return channelDomain;
  }
  






  public static int[] getTextType(int channelId)
  {
    int[] textType = new int[2];
    switch (channelId) {
    case 5: 
      textType[0] = 43;
      textType[1] = 44;
      break;
    case 10: 
      textType[0] = 47;
      textType[1] = 48;
      break;
    case 14: 
      textType[0] = 51;
      textType[1] = 52;
      break;
    case 9: 
      textType[0] = 45;
      textType[1] = 46;
      break;
    case 3: 
      textType[0] = 41;
      textType[1] = 42;
      break;
    case 13: 
      textType[0] = 49;
      textType[1] = 50;
      break;
    }
    
    
    return textType;
  }
  
  public static int[] getInfoId(int channelId) {
    int[] infoId = new int[2];
    switch (channelId) {
    case 5: 
      infoId[0] = 50;
      infoId[1] = 51;
      break;
    case 10: 
      infoId[0] = 54;
      infoId[1] = 55;
      break;
    case 14: 
      infoId[0] = 58;
      infoId[1] = 59;
      break;
    case 9: 
      infoId[0] = 52;
      infoId[1] = 53;
      break;
    case 3: 
      infoId[0] = 48;
      infoId[1] = 49;
      break;
    case 13: 
      infoId[0] = 56;
      infoId[1] = 57;
      break;
    }
    
    
    return infoId;
  }
  
  public static String getFolder(int channelId) {
    String folder = null;
    switch (channelId) {
    case 5: 
      folder = "/images/fzfs/";
      break;
    case 10: 
      folder = "/images/lpxh/";
      break;
    case 14: 
      folder = "/images/myet/";
      break;
    case 9: 
      folder = "/images/sssb/";
      break;
    case 3: 
      folder = "/images/tsyx/";
      break;
    case 13: 
      folder = "/images/tyhw/";
      break;
    }
    
    
    return folder;
  }
  
  public static int[] getAdId(int channelId) {
    int[] adId = new int[7];
    switch (channelId) {
    case 5: 
      adId[0] = 88;
      adId[1] = 437;
      adId[2] = 438;
      adId[3] = 439;
      adId[4] = 440;
      adId[5] = 589;
      adId[6] = 580;
      break;
    case 10: 
      adId[0] = 98;
      adId[1] = 469;
      adId[2] = 470;
      adId[3] = 471;
      adId[4] = 472;
      adId[5] = 581;
      adId[6] = 582;
      break;
    case 14: 
      adId[0] = 108;
      adId[1] = 501;
      adId[2] = 502;
      adId[3] = 503;
      adId[4] = 504;
      adId[5] = 583;
      adId[6] = 584;
      break;
    case 9: 
      adId[0] = 93;
      adId[1] = 453;
      adId[2] = 454;
      adId[3] = 455;
      adId[4] = 456;
      adId[5] = 590;
      adId[6] = 591;
      break;
    case 3: 
      adId[0] = 83;
      adId[1] = 421;
      adId[2] = 422;
      adId[3] = 423;
      adId[4] = 424;
      adId[5] = 585;
      adId[6] = 586;
      break;
    case 13: 
      adId[0] = 103;
      adId[1] = 485;
      adId[2] = 486;
      adId[3] = 487;
      adId[4] = 488;
      adId[5] = 587;
      adId[6] = 588;
      break;
    }
    
    
    return adId;
  }
  
  public static int[] getRecomProductTypeId(int channelId) {
    int[] typeId = new int[2];
    switch (channelId) {
    case 5: 
      typeId[0] = 71;
      typeId[1] = 72;
      break;
    case 10: 
      typeId[0] = 75;
      typeId[1] = 76;
      break;
    case 14: 
      typeId[0] = 79;
      typeId[1] = 80;
      break;
    case 9: 
      typeId[0] = 73;
      typeId[1] = 74;
      break;
    case 3: 
      typeId[0] = 69;
      typeId[1] = 70;
      break;
    case 13: 
      typeId[0] = 77;
      typeId[1] = 78;
      break;
    }
    
    
    return typeId;
  }
}
