package com.ding9.click.sql;

import com.ding9.click.util.ClassHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Properties;




public class DBConfigManager
{
  private static final String PFILE = ClassHelper.getWebAppClassesPath() + "db.properties";
  


  private File m_file = null;
  private long m_lastModifiedTime = 0L;
  private Properties m_props = null;
  



  private static DBConfigManager m_instance = new DBConfigManager();
  

  private DBConfigManager()
  {
    this.m_file = new File(PFILE);
    this.m_lastModifiedTime = this.m_file.lastModified();
    if (this.m_lastModifiedTime == 0L) {
      System.err.println(PFILE + " file does not exist!");
    }
    this.m_props = new Properties();
    try {
      this.m_props.load(new FileInputStream(PFILE));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  


  public static synchronized DBConfigManager getInstance()
  {
    return m_instance;
  }
  





  public final Object getConfigItem(String name, Object defaultVal)
  {
    long newTime = this.m_file.lastModified();
    
    if (newTime == 0L)
    {
      if (this.m_lastModifiedTime == 0L) {
        System.err.println(PFILE + 
          " file does not exist!");
      } else {
        System.err.println(PFILE + 
          " file was deleted!!");
      }
      return defaultVal; }
    if (newTime > this.m_lastModifiedTime) {
      this.m_props.clear();
      try {
        this.m_props.load(new FileInputStream(PFILE));
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    this.m_lastModifiedTime = newTime;
    Object val = this.m_props.getProperty(name);
    if (val == null) {
      return defaultVal;
    }
    return val;
  }
}
