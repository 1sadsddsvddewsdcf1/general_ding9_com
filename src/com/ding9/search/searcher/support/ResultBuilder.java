package com.ding9.search.searcher.support;

import com.ding9.search.entity.article.Article;
import com.ding9.search.entity.cheapcard.CheapCard;
import com.ding9.search.entity.comment.Comment;
import com.ding9.search.entity.comment.RestoreVO;
import com.ding9.search.entity.merchant.MerchantInfo;
import com.ding9.search.entity.merchantproduct.MerchantProduct;
import com.ding9.search.entity.product.ProductMaster;
import com.ding9.search.entity.productparasort.ProductPara;
import com.ding9.search.entity.promotion.Promotion;
import com.ding9.search.searcher.support.result.ArticleResult;
import com.ding9.search.searcher.support.result.CheapCardResult;
import com.ding9.search.searcher.support.result.CommentResult;
import com.ding9.search.searcher.support.result.MerchantInfoResult;
import com.ding9.search.searcher.support.result.MerchantProductResult;
import com.ding9.search.searcher.support.result.ProductMasterResult;
import com.ding9.search.searcher.support.result.ProductParaResult;
import com.ding9.search.searcher.support.result.PromotionResult;
import com.ding9.search.searcher.support.result.RestoreResult;
import com.ding9.search.util.Pagination;
import java.util.List;
















public class ResultBuilder
{
  public static ProductMasterResult getProductMasterResult(Pagination pagination)
  {
    ProductMasterResult pr = new ProductMasterResult();
    
    if (pagination == null) {
      return pr;
    }
    
    pr.setCurrent(pagination.getCurrent());
    pr.setPageSize(pagination.getPageSize());
    pr.setRecordCount(pagination.getRecordCount());
    pr.setTotalPage(pagination.getTotalPage());
    
    List recordlist = pagination.getRecords();
    
    ProductMaster[] records = (ProductMaster[])null;
    
    if (recordlist != null) {
      records = new ProductMaster[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((ProductMaster)(ProductMaster)recordlist.get(i));
      }
    }
    
    pr.setRecords(records);
    
    return pr;
  }
  




  public static ArticleResult getArticleResult(Pagination pagination)
  {
    ArticleResult ar = new ArticleResult();
    
    if (pagination == null) {
      return ar;
    }
    
    ar.setCurrent(pagination.getCurrent());
    ar.setPageSize(pagination.getPageSize());
    ar.setRecordCount(pagination.getRecordCount());
    ar.setTotalPage(pagination.getTotalPage());
    
    List recordlist = pagination.getRecords();
    
    Article[] records = (Article[])null;
    
    if (recordlist != null) {
      records = new Article[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((Article)(Article)recordlist.get(i));
      }
    }
    
    ar.setRecords(records);
    
    return ar;
  }
  




  public static CheapCardResult getCheapCardResult(Pagination pagination)
  {
    CheapCardResult ccr = new CheapCardResult();
    
    if (pagination == null) {
      return ccr;
    }
    
    ccr.setCurrent(pagination.getCurrent());
    ccr.setPageSize(pagination.getPageSize());
    ccr.setRecordCount(pagination.getRecordCount());
    ccr.setTotalPage(pagination.getTotalPage());
    
    List recordlist = pagination.getRecords();
    
    CheapCard[] records = (CheapCard[])null;
    
    if (recordlist != null) {
      records = new CheapCard[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((CheapCard)(CheapCard)recordlist.get(i));
      }
    }
    
    ccr.setRecords(records);
    
    return ccr;
  }
  




  public static CommentResult getCommentResult(Pagination pagination)
  {
    CommentResult cr = new CommentResult();
    
    if (pagination == null) {
      return cr;
    }
    
    cr.setCurrent(pagination.getCurrent());
    cr.setPageSize(pagination.getPageSize());
    cr.setRecordCount(pagination.getRecordCount());
    cr.setTotalPage(pagination.getTotalPage());
    
    List recordlist = pagination.getRecords();
    
    Comment[] records = (Comment[])null;
    
    if (recordlist != null) {
      records = new Comment[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((Comment)(Comment)recordlist.get(i));
      }
    }
    
    cr.setRecords(records);
    
    return cr;
  }
  




  public static PromotionResult getPromotionResult(Pagination pagination)
  {
    PromotionResult pr = new PromotionResult();
    
    if (pagination == null) {
      return pr;
    }
    
    pr.setCurrent(pagination.getCurrent());
    pr.setPageSize(pagination.getPageSize());
    pr.setRecordCount(pagination.getRecordCount());
    pr.setTotalPage(pagination.getTotalPage());
    
    List recordlist = pagination.getRecords();
    
    Promotion[] records = (Promotion[])null;
    
    if (recordlist != null) {
      records = new Promotion[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((Promotion)(Promotion)recordlist.get(i));
      }
    }
    
    pr.setRecords(records);
    
    return pr;
  }
  






  public static MerchantInfoResult getMerchantInfoResult(Pagination pagination)
  {
    MerchantInfoResult mr = new MerchantInfoResult();
    if (pagination == null) {
      return mr;
    }
    
    mr.setCurrent(pagination.getCurrent());
    mr.setPageSize(pagination.getPageSize());
    mr.setRecordCount(pagination.getRecordCount());
    mr.setTotalPage(pagination.getTotalPage());
    List recordlist = pagination.getRecords();
    MerchantInfo[] records = (MerchantInfo[])null;
    
    if (recordlist != null) {
      records = new MerchantInfo[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((MerchantInfo)(MerchantInfo)recordlist.get(i));
      }
    }
    
    mr.setRecords(records);
    return mr;
  }
  




  public static RestoreResult getRestoreResult(Pagination pagination)
  {
    RestoreResult rr = new RestoreResult();
    if (pagination == null) {
      return rr;
    }
    
    rr.setCurrent(pagination.getCurrent());
    rr.setPageSize(pagination.getPageSize());
    rr.setRecordCount(pagination.getRecordCount());
    rr.setTotalPage(pagination.getTotalPage());
    List recordlist = pagination.getRecords();
    
    RestoreVO[] records = (RestoreVO[])null;
    
    if (recordlist != null) {
      records = new RestoreVO[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((RestoreVO)(RestoreVO)recordlist.get(i));
      }
    }
    
    rr.setRecords(records);
    return rr;
  }
  





  public static MerchantProductResult getMerchantProductResult(Pagination pagination)
  {
    MerchantProductResult pr = new MerchantProductResult();
    
    if (pagination == null) {
      return pr;
    }
    
    pr.setCurrent(pagination.getCurrent());
    pr.setPageSize(pagination.getPageSize());
    pr.setRecordCount(pagination.getRecordCount());
    pr.setTotalPage(pagination.getTotalPage());
    List recordlist = pagination.getRecords();
    
    MerchantProduct[] records = (MerchantProduct[])null;
    
    if (recordlist != null) {
      records = new MerchantProduct[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((MerchantProduct)(MerchantProduct)recordlist.get(i));
      }
    }
    
    pr.setRecords(records);
    
    return pr;
  }
  




  public static ProductParaResult getProdctParaResult(Pagination pagination)
  {
    ProductParaResult cr = new ProductParaResult();
    
    if (pagination == null) {
      return cr;
    }
    
    cr.setCurrent(pagination.getCurrent());
    cr.setPageSize(pagination.getPageSize());
    cr.setRecordCount(pagination.getRecordCount());
    
    cr.setTotalPage(pagination.getTotalPage());
    List recordlist = pagination.getRecords();
    
    ProductPara[] records = (ProductPara[])null;
    
    if (recordlist != null) {
      records = new ProductPara[recordlist.size()];
      for (int i = 0; i < recordlist.size(); i++) {
        records[i] = ((ProductPara)(ProductPara)recordlist.get(i));
      }
    }
    
    cr.setRecords(records);
    
    return cr;
  }
}
