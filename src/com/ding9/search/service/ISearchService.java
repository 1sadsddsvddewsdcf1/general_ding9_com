package com.ding9.search.service;

import com.ding9.search.entity.assistant.Counter;
import com.ding9.search.entity.merchant.MerchantInfo;
import com.ding9.search.searcher.support.result.ArticleResult;
import com.ding9.search.searcher.support.result.CheapCardResult;
import com.ding9.search.searcher.support.result.CommentResult;
import com.ding9.search.searcher.support.result.MerchantInfoResult;
import com.ding9.search.searcher.support.result.MerchantProductResult;
import com.ding9.search.searcher.support.result.ProductMasterResult;
import com.ding9.search.searcher.support.result.ProductParaResult;
import com.ding9.search.searcher.support.result.PromotionResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public abstract interface ISearchService
{
  public abstract ProductMasterResult getStandardProducts(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract ProductMasterResult getStandardProducts(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract ProductMasterResult getStandardProducts(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public abstract ProductMasterResult getStandardProducts(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, String paramString2);
  
  public abstract Counter[] getProductBrandCounts(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract Counter[] getProductBrandCounts(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, boolean paramBoolean, String paramString2);
  
  public abstract ArticleResult getArticles(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract CheapCardResult getCheapCards(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract CommentResult getComments(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract CommentResult getComments(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract CommentResult getComments(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract CommentResult getComments(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract CommentResult getComments(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public abstract PromotionResult getPromotions(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract MerchantInfoResult getMerchantInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public abstract MerchantInfo getMerchantDetail(int paramInt);
  
  public abstract MerchantProductResult getMerchantProduct(int paramInt1, int paramInt2, int paramInt3, String paramString1, float paramFloat1, float paramFloat2, String paramString2, String paramString3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);
  
  public abstract ArticleResult getRelatedArticle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws IOException;
  
  public abstract ProductParaResult getProductParaSort(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract List getProductParaVal(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract HashMap getMerchantInfoByPrmaId(int paramInt);
  
  public abstract int testXFireSpeed();
}
