package com.ding9.search.util;

import java.io.File;
import java.io.PrintStream;
import java.util.Properties;

import com.ding9.util.ClassHelper;

public class ConfigManager
{
  private static final String PPATH = ClassHelper.getWebAppClassesPath();
  private static String PFILE = null;
  


  private static File m_file = null;
  


  private static long m_lastModifiedTime = 0L;
  


  private static Properties m_props = null;
  


  private static ConfigManager m_instance = new ConfigManager();
  










  private static void setConfigFile(String filepath)
  {
    PFILE = PPATH + filepath;
    
    m_file = new File(PFILE);
    m_lastModifiedTime = m_file.lastModified();
    if (m_lastModifiedTime == 0L)
    {
      System.err.println(PFILE + " file does not exist!");
    }
    m_props = new Properties();
    try
    {
      m_props.load(new java.io.FileInputStream(PPATH + filepath));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  




  public static synchronized ConfigManager getInstance(String filepath)
  {
    setConfigFile(filepath);
    return m_instance;
  }
  







  public final Object getConfigItem(String name, Object defaultVal)
  {
    long newTime = m_file.lastModified();
    



    if (newTime == 0L)
    {

      if (m_lastModifiedTime == 0L)
      {
        System.err.println(PFILE + 
          " file does not exist!");
      }
      else
      {
        System.err.println(PFILE + 
          " file was deleted!!");
      }
      return defaultVal;
    }
    if (newTime > m_lastModifiedTime)
    {

      m_props.clear();
      try
      {
        m_props.load(new java.io.FileInputStream(PFILE));
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    m_lastModifiedTime = newTime;
    Object val = m_props.getProperty(name);
    if (val == null)
    {
      return defaultVal;
    }
    

    return val;
  }
}
