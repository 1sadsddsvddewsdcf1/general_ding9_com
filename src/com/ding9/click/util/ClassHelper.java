package com.ding9.click.util;

import java.io.PrintStream;
import java.net.URL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;







public class ClassHelper
{
  private static final Log logger = LogFactory.getLog(ClassHelper.class);
  


  public static String getWebAppClassesPath()
  {
    String classesPath = ClassHelper.class.getResource("./ClassHelper.class").toString();
    if (classesPath.toLowerCase().startsWith("file:")) classesPath = classesPath.substring(5);
    if (classesPath.toLowerCase().startsWith("jar:file:")) classesPath = classesPath.substring(9);
    int i = classesPath.indexOf("/WEB-INF/");
    if (i >= 0)
    {
      classesPath = classesPath.substring(0, i) + "/WEB-INF/classes/";
    }
    else {
      classesPath = classesPath.substring(0, classesPath.indexOf("net/jemboo/helper"));
    }
    logger.info("getWebAppClassesPath()=" + classesPath);
    return classesPath;
  }
  




  public static String getWebAppRootPath()
  {
    String classesRootPath = getWebAppClassesPath();
    return classesRootPath.substring(0, classesRootPath.length() - 16);
  }
  



  public static String getClassShortName(Class clazz)
  {
    String className = clazz.getName();
    int i = className.lastIndexOf(".");
    if (i < 0) return className;
    return className.substring(i + 1);
  }
  
  public static void main(String[] args) { System.out.println(ClassHelper.class.getResource("./ClassHelper.xml").toString() + "-----" + getWebAppClassesPath()); }
}
