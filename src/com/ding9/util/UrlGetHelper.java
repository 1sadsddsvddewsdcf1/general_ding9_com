package com.ding9.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;












public class UrlGetHelper
{
  private static Log log = LogFactory.getLog(UrlGetHelper.class);
  




  public static String getRemoteUrlText(String path)
    throws IOException
  {
    URL url = new URL(path);
    URLConnection urlconn = url.openConnection();
    urlconn.connect();
    
    urlconn.getURL();
    
    InputStream is = urlconn.getInputStream();
    if (is == null) {
      return null;
    }
    


    int i = 0;
    StringWriter sw = new StringWriter();
    BufferedWriter bw = new BufferedWriter(sw);
    while ((i = is.read()) != -1) {
      bw.write(i);
    }
    bw.flush();
    bw.close();
    is.close();
    urlconn = null;
    url = null;
    return sw.getBuffer().toString();
  }
  





  public static boolean getRemoteFileToLocalServer(String sourcepath, String destinationpath)
  {
    boolean result = false;
    

    sourcepath = sourcepath == null ? "" : sourcepath.trim();
    destinationpath = destinationpath == null ? "" : destinationpath.trim();
    try
    {
      URL url = new URL(sourcepath);
      HttpURLConnection connection = (HttpURLConnection)url
        .openConnection();
      DataInputStream in = new DataInputStream(connection.getInputStream());
      DataOutputStream out = new DataOutputStream(new FileOutputStream(destinationpath));
      byte[] buffer = new byte[4096];
      int count = 0;
      
      while ((count = in.read(buffer)) > 0) {
        out.write(buffer, 0, count);
      }
      out.close();
      in.close();
      
      result = true;
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error(ex);
      }
      result = false;
    }
    
    return result;
  }
  





  private static String getDocumentAt(String urlString)
  {
    StringBuffer document = new StringBuffer();
    try {
      URL url = new URL(urlString);
      URLConnection conn = url.openConnection();
      BufferedReader reader = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
      String line = null;
      while ((line = reader.readLine()) != null) {
        document.append(line + "\n");
      }
      reader.close();
    } catch (MalformedURLException e) {
      if (log.isErrorEnabled()) {
        log.error("Unable to connect to URL: " + urlString);
        log.error(e);
      }
    } catch (IOException e) {
      if (log.isErrorEnabled()) {
        log.error("IOException when connecting to URL: " + urlString);
        log.error(e);
      }
    }
    return document.toString();
  }
  




  public static String convertStrFromISO8859ToGb2312(String str)
  {
    String result = null;
    try {
      result = new String(
        String.valueOf(
        str != null ? str.trim() : "").getBytes("ISO-8859-1"), 
        "GB2312");
    }
    catch (Exception ex) {
      result = "";
      if (log.isErrorEnabled()) {
        log.error(ex);
      }
    }
    
    return result;
  }
  




  public static String convertStrFromGb2312ToISO8859(String str)
  {
    String result = null;
    try {
      result = new String(
        String.valueOf(
        str != null ? str.trim() : "").getBytes("GB2312"), 
        "ISO-8859-1");
    }
    catch (Exception ex) {
      result = "";
    }
    
    return result;
  }
}
