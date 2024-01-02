package com.ding9.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;














public class URLGrabber
{
  public static InputStream getDocumentAsInputStream(URL url)
    throws IOException
  {
    InputStream in = url.openStream();
    return in;
  }
  




  public static InputStream getDocumentAsInputStream(String url)
    throws MalformedURLException, IOException
  {
    URL u = new URL(url);
    return getDocumentAsInputStream(u);
  }
  



  public static String getDocumentAsString(URL url)
    throws IOException
  {
    StringBuffer result = new StringBuffer();
    InputStream in = url.openStream();
    int c;
    while ((c = in.read()) != -1) { //int c;
      result.append((char)c);
    }
    return result.toString();
  }
  




  public static String getDocumentAsString(String url)
    throws MalformedURLException, IOException
  {
    URL u = new URL(url);
    return getDocumentAsString(u);
  }
}
