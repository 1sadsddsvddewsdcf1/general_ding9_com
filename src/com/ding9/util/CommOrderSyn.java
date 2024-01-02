package com.ding9.util;

import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;


public class CommOrderSyn
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
  
  public int getSoTimeout() {
    return this.soTimeout;
  }
  
  public String doSyn() {
    HttpClient client = null;
    GetMethod get = null;
    String response = null;
    try {
      MultiThreadedHttpConnectionManager connectionManager = 
        new MultiThreadedHttpConnectionManager();
      HttpConnectionParams params = connectionManager.getParams();
      params.setConnectionTimeout(this.connectTimeout);
      params.setSoTimeout(this.soTimeout);
      client = new HttpClient(connectionManager);
      get = new GetMethod(this.url);
      get.setFollowRedirects(false);
      client.executeMethod(get);
      response = get.getResponseBodyAsString();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    finally {
      get.releaseConnection();
    }
    return response;
  }
}
