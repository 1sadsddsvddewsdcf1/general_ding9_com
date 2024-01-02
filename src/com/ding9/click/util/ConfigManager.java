package com.ding9.click.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import com.ding9.util.ClassHelper;





public class ConfigManager
{
  private static final String PPATH = ClassHelper.getWebAppClassesPath();
  



  private static ConfigManager manager = null;
  



  private static Object managerLock = new Object();
  



  private static String file = null;
  



  private static Properties properties = null;
  



  private Object propertiesLock = new Object();
  







  public static synchronized String getProperty(String name)
  {
    if (manager == null) {
      synchronized (managerLock) {
        if (manager == null) {
          manager = new ConfigManager();
          setFile();
        }
      }
    }
    return manager.getProp(name);
  }
  




  public static synchronized void deleteProperty(String name)
  {
    if (manager == null) {
      synchronized (managerLock) {
        if (manager == null) {
          manager = new ConfigManager();
          setFile();
        }
      }
    }
    manager.deleteProp(name);
  }
  




  public static synchronized void setProperty(String name, String value)
  {
    if (manager == null) {
      synchronized (managerLock) {
        if (manager == null) {
          manager = new ConfigManager();
          setFile();
        }
      }
    }
    
    manager.setProp(name, value);
  }
  



  public static synchronized void reset()
  {
    if (manager == null) {
      synchronized (managerLock) {
        if (manager == null) {
          manager = new ConfigManager();
          setFile();
        }
      }
    }
    loadProps();
  }
  

  private static void setFile()
  {
    try
    {
      file = PPATH + "ding9click.properties";
      return;
    } catch (Exception e) {
      e.printStackTrace();
      file = null;
    }
  }
  







  public static Enumeration propertyNames()
  {
    if (manager == null) {
      synchronized (managerLock) {
        if (manager == null) {
          manager = new ConfigManager();
          setFile();
        }
      }
    }
    return manager.propNames();
  }
  







  protected String getProp(String name)
  {
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
  





  protected void setProp(String name, String value)
  {
    synchronized (this.propertiesLock) {
      if (properties == null) {
        loadProps();
      }
      properties.setProperty(name, value);
      saveProps();
    }
  }
  




  protected void deleteProp(String name)
  {
    synchronized (this.propertiesLock) {
      if (properties == null) {
        loadProps();
      }
      properties.remove(name);
      saveProps();
    }
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
  


  private static void loadProps()
  {
    properties = new Properties();
    InputStream in = null;
    try {
      FileInputStream fis = new FileInputStream(file);
      
      int value = -1;
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      while ((value = fis.read()) != -1) {
        baos.write(value);
      }
      in = new ByteArrayInputStream(baos.toByteArray());
      properties.load(in);
      fis.close();
      baos.close();
    } catch (Exception e) {
      System.err.println(
        "Error reading Jive properties in ConfigManager.loadProps() " + 
        e);
      return;
    } finally {
      try {
        in.close();
      }
      catch (Exception e) {}
    }
  }
  



  private void saveProps()
  {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try {
      properties.store(out, "ding9sso.properties -- " + new Date());
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(out.toByteArray());
      fos.close();
      reset();
    } catch (Exception ioe) {
      ioe.printStackTrace();
    } finally {
      try {
        out.close();
      }
      catch (Exception localException1) {}
    }
  }
}
