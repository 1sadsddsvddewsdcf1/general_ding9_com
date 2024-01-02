package com.ding9.dao.comment;

import java.util.List;

public abstract interface CommentsOnProductDao
{
  public abstract List getCommentInfo(int paramInt);
  
  public abstract List getCommentInfo(int paramInt1, int paramInt2);
}
