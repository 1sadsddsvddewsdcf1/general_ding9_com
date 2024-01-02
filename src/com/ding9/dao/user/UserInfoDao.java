package com.ding9.dao.user;

import com.ding9.entity.user.UserAccountInfo;

public abstract interface UserInfoDao
{
  public abstract int insert(UserAccountInfo paramUserAccountInfo);
  
  public abstract UserAccountInfo findById(int paramInt);
  
  public abstract UserAccountInfo findByName(String paramString);
  
  public abstract UserAccountInfo findByEmail(String paramString);
  
  public abstract UserAccountInfo findByAccount(String paramString1, String paramString2);
  
  public abstract Integer findUserCheck(String paramString);
  
  public abstract int update(UserAccountInfo paramUserAccountInfo);
  
  public abstract int updateEmail(String paramString, int paramInt);
  
  public abstract int updatePassword(String paramString, int paramInt);
  
  public abstract int updateQuestion(int paramInt1, String paramString, int paramInt2);
}
