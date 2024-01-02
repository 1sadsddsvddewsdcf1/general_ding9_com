package com.ding9.click.client;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface IAccessLogApi
{
  public abstract int addAccessLogInfo(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract int addAccessLogInfo(int paramInt, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract int addVipAccessLogInfo(int paramInt, boolean paramBoolean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract int addVipAccessLogInfo(int paramInt1, int paramInt2, boolean paramBoolean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract int addVipAdvAccessLogInfo(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract int addVipD9senseAccessLogInfo(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract int addVipGoGoAccessLogInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract int addVipAccessLogInfo(Map paramMap, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract int addVipAccessLogInfo(List paramList, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
}
