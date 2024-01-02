package com.ding9.util;


public class HTMLFI
{
  private static final String HTML_P = "<p>";
  private static final String HTML_P2 = "</p>";
  private static final String HLTM_BR = "<br>";
  
  public static String toHTML(String msg)
  {
    String str = msg.toLowerCase();
    if (msg != null) {
      str = str.replaceAll("<p>", "");
      str = str.replaceAll("</p>", "");
      str = str.replaceAll("<br>", "");
    }
    return str;
  }
}
