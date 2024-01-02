package com.ding9.util;

import java.io.IOException;
import java.io.PrintStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;


public class CommSyn
{
  private String url;
  private int connectTimeout = 20000;
  private int soTimeout = 30000;
  


  public void setUrl(String url)
  {
    this.url = url;
  }
  
  public void setConnectTimeout(int connectTimeout) {
    this.connectTimeout = connectTimeout;
  }
  
  public void setSoTimeout(int soTimeout) {
    this.soTimeout = soTimeout;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public int getConnectTimeout() {
    return this.connectTimeout;
  }
  

  public int getSoTimeout() { return this.soTimeout; }
  
  public int doSyn() {
    HttpClient client = null;
    GetMethod get = null;
    int status = 0;
    try {
      MultiThreadedHttpConnectionManager connectionManager = 
        new MultiThreadedHttpConnectionManager();
      HttpConnectionParams params = connectionManager.getParams();
      params.setConnectionTimeout(this.connectTimeout);
      params.setSoTimeout(this.soTimeout);
      client = new HttpClient(connectionManager);
      get = new GetMethod(this.url);
      get.setFollowRedirects(true);
      client.executeMethod(get);
      status = get.getStatusCode();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    finally {
      get.releaseConnection();
    }
    return status;
  }
  
  public static void main(String[] args) { CommSyn syn = new CommSyn();
    syn.setUrl("http://www.cosme-de.com/gb/product/product_page.html?pdid=1528&refCur=CNY");
    int status = syn.doSyn();
    System.out.println("status=" + status);
    System.out.println("status=" + status);
    System.out.println("status=" + status);
  }
}
