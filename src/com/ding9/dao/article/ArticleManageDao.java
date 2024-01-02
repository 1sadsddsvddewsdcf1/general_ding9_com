package com.ding9.dao.article;

import java.util.List;

public abstract interface ArticleManageDao
{
  public abstract List getArticleForIndex(int paramInt);
  
  public abstract List getArticleForIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract List getArticleForIndex(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract List getArticleList(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract List getMessageManageTypeArticle(int paramInt);
  
  public abstract List getMessageManageTypeArticle(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract List getArticleInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract List getArticleInfo(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract List getDzftArticleList(int paramInt);
  
  public abstract List getInfoArticleList(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}
