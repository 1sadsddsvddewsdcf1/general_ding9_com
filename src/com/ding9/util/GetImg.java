package com.ding9.util;






















public class GetImg
{
  public static String Image(String localimg, String blankimg)
  {
    String url = null;
    if ((localimg != null) && (!"".equals(localimg))) {
      url = Environment.getImageServer() + localimg;
    } else {
      url = blankimg;
    }
    


    return url;
  }
}
