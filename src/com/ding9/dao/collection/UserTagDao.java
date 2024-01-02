package com.ding9.dao.collection;

import com.ding9.entity.collection.UserTagVO;
import java.util.List;

public abstract interface UserTagDao
{
  public abstract int addLabel(String paramString, UserTagVO paramUserTagVO);
  
  public abstract int delLabel(int paramInt);
  
  public abstract int ModLabel(UserTagVO paramUserTagVO, String paramString);
  
  public abstract List query(int paramInt1, int paramInt2);
  
  public abstract UserTagVO findByPk(int paramInt);
  
  public abstract int checkTag(String paramString, int paramInt1, int paramInt2);
  
  public abstract int add(UserTagVO paramUserTagVO);
}
