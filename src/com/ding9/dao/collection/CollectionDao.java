package com.ding9.dao.collection;

import com.ding9.entity.collection.CollectionVO;
import java.util.List;

public abstract interface CollectionDao
{
  public abstract int addCollection(CollectionVO paramCollectionVO);
  
  public abstract int delete(int paramInt);
  
  public abstract int modify(CollectionVO paramCollectionVO);
  
  public abstract List query(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract CollectionVO findByPk(int paramInt);
  
  public abstract int saveCollection(CollectionVO paramCollectionVO);
  
  public abstract int getProductCount(int paramInt);
}
