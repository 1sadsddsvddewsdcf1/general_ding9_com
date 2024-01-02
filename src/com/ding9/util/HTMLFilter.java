package com.ding9.util;



public final class HTMLFilter
{
  private static final String HTML_START_P = "<p>";
  

  private static final String HTML_END_P = "</p>";
  

  private static final String HTML_BR = "<br>";
  

  private static final String HTML_BR_SLANT = "<br/>";
  

  public static String filter(String message)
  {
    if (message == null)
      return null;
    String str = message.toLowerCase().replaceAll("<p>", "");
    str = str.replaceAll("</p>", "");
    str = str.replaceAll("<br>", "");
    str = str.replaceAll("<br/>", "");
    return str;
  }
}
