package com.ding9.dao.register;

import com.ding9.entity.user.UserAccountInfo;
import java.util.List;

public abstract interface RegisterDao
{
  public abstract int addUser(UserAccountInfo paramUserAccountInfo);
  
  public abstract int modEmail(String paramString1, String paramString2, int paramInt);
  
  public abstract int active(String paramString);
  
  public abstract List checkActive(String paramString1, String paramString2);
}
