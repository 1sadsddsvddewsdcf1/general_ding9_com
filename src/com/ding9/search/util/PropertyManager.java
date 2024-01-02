package com.ding9.search.util;

public abstract interface PropertyManager
{
  public abstract String getProperty(String paramString);
  
  public abstract void setProperty(String paramString1, String paramString2);
  
  public abstract void setProperty(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void store();
  
  public abstract void load();
}
