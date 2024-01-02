package com.ding9.util.mail;

import java.util.Vector;


public class MailVO
{
  private String url = "";
  
  private String to = "";
  
  private String from = "";
  
  private String host = "";
  
  private String username = "";
  
  private String password = "";
  
  private String filename = "";
  
  private String subject = "";
  


  Vector file = new Vector();
  
  public void attachfile(String fname)
  {
    this.file.addElement(fname);
  }
  
  public void setFile(Vector file)
  {
    this.file = file;
  }
  
  public void setFilename(String filename) {
    this.filename = filename;
  }
  
  public void setFrom(String from) {
    this.from = from;
  }
  
  public void setHost(String host) {
    this.host = host;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public void setSubject(String subject) {
    this.subject = subject;
  }
  
  public void setTo(String to) {
    this.to = to;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public Vector getFile() {
    return this.file;
  }
  
  public String getFilename() {
    return this.filename;
  }
  
  public String getFrom() {
    return this.from;
  }
  
  public String getHost() {
    return this.host;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public String getSubject() {
    return this.subject;
  }
  
  public String getTo() {
    return this.to;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setUrl(String url)
  {
    this.url = url;
  }
}
