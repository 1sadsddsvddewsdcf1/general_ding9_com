package com.ding9.dao.collection;

import com.ding9.entity.collection.TagVO;

public abstract interface TagDao
{
  public abstract int insert(TagVO paramTagVO);
  
  public abstract int findByName(String paramString);
}
