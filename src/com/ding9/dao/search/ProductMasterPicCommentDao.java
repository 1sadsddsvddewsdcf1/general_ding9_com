package com.ding9.dao.search;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract interface ProductMasterPicCommentDao
{
  public abstract List getProductMaster(int paramInt1, int paramInt2, ArrayList paramArrayList, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws SQLException;
  
  public abstract List getProductPic(int paramInt)
    throws SQLException;
  
  public abstract List getRelationProductBrand(int paramInt, ArrayList paramArrayList, float paramFloat1, float paramFloat2)
    throws SQLException;
}
