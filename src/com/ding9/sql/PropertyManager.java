package com.ding9.sql;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;













class PropertyManager
{
  private static Log log = LogFactory.getLog(PropertyManager.class);
  
  private static PropertyManager manager = null;
  private static Object managerLock = new Object();
  private static String file = null;
  private static Properties properties = null;
  private Object propertiesLock = new Object();
  




  public static String getProperty(String name)
  {
    if (manager == null) {
      synchronized (managerLock) {
        if (manager == null) {
          manager = new PropertyManager();
          setFile();
        }
      }
    }
    return manager.getProp(name);
  }
  
  public static void reset() {
    if (manager == null) {
      synchronized (managerLock) {
        if (manager == null) {
          manager = new PropertyManager();
          setFile();
        }
      }
    }
    loadProps();
  }
  
  private static void setFile() {
    try {
      file = manager.getClass().getResource(".").getFile() + "database.conf";
      System.out.println("file--" + file);
      log.isDebugEnabled();
      


      return;
    }
    catch (Exception e)
    {
      if (log.isErrorEnabled()) {
        log.error(e.toString());
      }
      file = null;
    }
  }
  
  public static Enumeration propertyNames()
  {
    if (manager == null) {
      synchronized (managerLock) {
        if (manager == null) {
          manager = new PropertyManager();
          setFile();
        }
      }
    }
    return manager.propNames();
  }
  
  protected String getProp(String name) {
    if (properties == null) {
      synchronized (this.propertiesLock) {
        if (properties == null) {
          loadProps();
        }
      }
    }
    String property = properties.getProperty(name);
    if (property == null) {
      return null;
    }
    
    return property.trim();
  }
  

  protected Enumeration propNames()
  {
    if (properties == null) {
      synchronized (this.propertiesLock) {
        if (properties == null) {
          loadProps();
        }
      }
    }
    return properties.propertyNames();
  }
  
  private static void loadProps() {
    properties = new Properties();
    InputStream in = null;
    try {
      in = new FileInputStream(file);
      properties.load(in);
    }
    catch (Exception e)
    {
      if (log.isErrorEnabled()) {
        log.error("Error reading JDBC properties in PropertyManager.loadProps() " + e.toString());
      }
      return;
    }
    finally {
      try {
        in.close();
      }
      catch (Exception e) {}
    }
  }
}
