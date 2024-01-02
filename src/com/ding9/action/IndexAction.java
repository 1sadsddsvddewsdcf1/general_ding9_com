package com.ding9.action;

import com.ding9.dao.advertisement.AdvertisementDao;
import com.ding9.dao.advertisement.AdvertisementDaoImpl;
import com.ding9.dao.article.ArticleManageDao;
import com.ding9.dao.article.ArticleManageDaoImpl;
import com.ding9.dao.comment.CommentsOnProductDao;
import com.ding9.dao.comment.CommentsOnProductDaoImpl;
import com.ding9.dao.contentinfo.CommonContentInfoDao;
import com.ding9.dao.contentinfo.CommonContentInfoDaoImpl;
import com.ding9.dao.productsort.ProductSortDao;
import com.ding9.dao.productsort.ProductSortDaoImpl;
import com.ding9.dao.recommend.RecommendMerchantInfoDao;
import com.ding9.dao.recommend.RecommendMerchantInfoDaoImpl;
import com.ding9.dao.recommendProduct.RecommentProductDao;
import com.ding9.dao.recommendProduct.RecommentProductDaoImpl;
import com.ding9.entity.commoncontentinfo.CommonContentInfo;
import com.ding9.entity.productsort.ProductSort;
import com.ding9.util.Constants;
import com.ding9.util.Environment;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class IndexAction
  extends Action
{
  private final Log log = LogFactory.getLog(getClass().getName());
  


  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int channelId = 0;
    

    String requestURI = request.getRequestURI();
    String requestURL = request.getRequestURL().toString();
    int index = requestURL.indexOf(requestURI);
    String domain = requestURL.substring(0, index);
    
    if (Environment.getChannelBook().equals(domain)) {
      channelId = 3;
    } else if (Environment.getChannelCostume().equals(domain)) {
      channelId = 5;
    } else if (Environment.getChannelHeadgear().equals(domain)) {
      channelId = 9;
    } else if (Environment.getChannelGift().equals(domain)) {
      channelId = 10;
    } else if (Environment.getChannelSport().equals(domain)) {
      channelId = 13;
    } else if (Environment.getChannelChild().equals(domain)) {
      channelId = 14;
    }
    
    if (this.log.isInfoEnabled()) {
      this.log.info("domain : " + domain);
      this.log.info("channelId : " + channelId);
    }
    

    request.setAttribute("folder", Constants.getFolder(channelId));
    

    getSortText(request, channelId);
    
    getArticles(request, channelId);
    
    getAdvertisements(request, channelId);
    
    getRecommentProducts(request, channelId);
    

    getComments(request, channelId);
    
    getRecommendMerchants(request, channelId);
    

    request.setAttribute("ChannelId", Integer.valueOf(channelId));
    

    ProductSortDao psDao = new ProductSortDaoImpl();
    List ls = null;
    try {
      ls = psDao.getOneProductSort(channelId);
    } catch (SQLException e) {
      if (this.log.isErrorEnabled()) {
        this.log.error("SQLException: " + e.getMessage());
      }
    }
    if ((ls != null) && (ls.size() > 0)) {
      ProductSort ps = (ProductSort)ls.get(0);
      
      String pnoe = StringUtils.trimToEmpty(ps.getPrso_name_one_en());
      if (StringUtils.isBlank(pnoe)) {
        pnoe = StringUtils.substringBetween(domain, "//", ".");
      }
      request.setAttribute("PrsoNameOneEn", pnoe);
    }
    

    request.setAttribute("MainServer", Environment.getMainServer());
    
    request.setAttribute("ChannelBeauty", Environment.getChannelBeauty());
    
    return mapping.findForward("success");
  }
  





  private void getSortText(HttpServletRequest request, int sortId)
  {
    int[] infoId = Constants.getTextType(sortId);
    
    CommonContentInfoDao contentDao = new CommonContentInfoDaoImpl();
    CommonContentInfo sortVO = null;
    CommonContentInfo cooperateVO = null;
    




    List sortList = contentDao.getContentInfo(infoId[0]);
    if ((sortList != null) && (sortList.size() > 0)) {
      sortVO = (CommonContentInfo)sortList.get(0);
    }
    List cooperateList = contentDao.getContentInfo(infoId[1]);
    if ((cooperateList != null) && (cooperateList.size() > 0)) {
      cooperateVO = (CommonContentInfo)cooperateList.get(0);
    }
    

    request.setAttribute("sortVO", sortVO);
    String content = cooperateVO.getContent();
    content = content.replaceAll("teH1", "teH1bottom");
    cooperateVO.setContent(content);
    request.setAttribute("cooperateVO", cooperateVO);
  }
  





  private void getArticles(HttpServletRequest request, int sortId)
  {
    long begintime = System.currentTimeMillis();
    int[] infoParams = Constants.getInfoId(sortId);
    
    ArticleManageDao articledao = new ArticleManageDaoImpl();
    List evaList = null;
    List direList = null;
    


    evaList = articledao.getArticleForIndex(infoParams[0], 12, 1, sortId);
    



    direList = articledao.getArticleForIndex(infoParams[1], 8, 1, sortId);
    
    try
    {
      if (this.log.isWarnEnabled()) {
        this.log.warn("(产品评测、专业导购)  所用时间: " + (
          System.currentTimeMillis() - begintime));
      }
    } catch (Exception ex) {
      if (this.log.isErrorEnabled()) {
        this.log.error(ex);
      }
    }
    
    request.setAttribute("evaList", evaList);
    request.setAttribute("direList", direList);
    request.setAttribute("eva_info_id", Integer.valueOf(infoParams[0]));
    request.setAttribute("dire_info_id", Integer.valueOf(infoParams[1]));
  }
  






  private void getAdvertisements(HttpServletRequest request, int channelId)
  {
    long begintime = System.currentTimeMillis();
    
    int[] adParams = Constants.getAdId(channelId);
    
    AdvertisementDao adDao = new AdvertisementDaoImpl();
    List playPicAds = null;
    List bottomPicAds = null;
    List middlePicAds = null;
    List textAds = null;
    

    playPicAds = adDao.getAdvertisements(channelId, adParams[0], adParams[1], 1, 8, 1);
    bottomPicAds = adDao.getAdvertisements(channelId, adParams[0], adParams[3], 1, 8, 1);
    middlePicAds = adDao.getAdvertisements(channelId, adParams[0], adParams[4], 1, 8, 1);
    


    textAds = adDao.getAdvertisements(channelId, adParams[0], adParams[2], 3, 8, 1);
    


    String middleFlashAds = null;
    String middleButtonAds = null;
    try {
      middleFlashAds = adDao.getAds(channelId, adParams[0], adParams[5]);
      middleButtonAds = adDao.getAds(channelId, adParams[0], adParams[6]);
    } catch (Exception ex) {
      if (this.log.isErrorEnabled()) {
        this.log.error(ex);
      }
    }
    try
    {
      if (this.log.isWarnEnabled()) {
        this.log.warn("(文字广告、广告) 所用时间: " + (
          System.currentTimeMillis() - begintime));
      }
    } catch (Exception ex) {
      if (this.log.isErrorEnabled()) {
        this.log.error(ex.getMessage());
      }
    }
    request.setAttribute("playPicAds", playPicAds);
    request.setAttribute("bottomPicAds", bottomPicAds);
    request.setAttribute("middlePicAds", middlePicAds);
    request.setAttribute("textAds", textAds);
    
    request.setAttribute("middleFlashAds", middleFlashAds);
    request.setAttribute("middleButtonAds", middleButtonAds);
  }
  





  private void getRecommentProducts(HttpServletRequest request, int sortId)
  {
    long begintime = System.currentTimeMillis();
    
    int[] recomProParams = Constants.getRecomProductTypeId(sortId);
    
    RecommentProductDao dao = new RecommentProductDaoImpl();
    List recomProducts = null;
    List hotProducts = null;
    List oneHotProducts = null;
    List twoHotProducts = null;
    


    recomProducts = dao.getRecommendProduct(sortId, recomProParams[0], 12);
    



    hotProducts = dao.getRecommendProduct(sortId, recomProParams[1], 6);
    
    if (hotProducts != null) {
      int size = hotProducts.size();
      if (size <= 3) {
        oneHotProducts = hotProducts;
      } else if (size <= 6) {
        oneHotProducts = hotProducts.subList(0, 3);
        twoHotProducts = hotProducts.subList(3, 6);
      }
    }
    
    try
    {
      if (this.log.isWarnEnabled()) {
        this.log.warn("(精品推荐) 所用时间: " + (
          System.currentTimeMillis() - begintime));
      }
    } catch (Exception ex) {
      if (this.log.isErrorEnabled()) {
        this.log.error(ex.getMessage());
      }
    }
    request.setAttribute("recomProducts", recomProducts);
    request.setAttribute("oneHotProducts", oneHotProducts);
    request.setAttribute("twoHotProducts", twoHotProducts);
  }
  





  private void getComments(HttpServletRequest request, int channelId)
  {
    long begintime = System.currentTimeMillis();
    CommentsOnProductDao commentDao = new CommentsOnProductDaoImpl();
    List comments = null;
    


    comments = commentDao.getCommentInfo(channelId, 14);
    

    try
    {
      if (this.log.isWarnEnabled()) {
        this.log.warn("(用户评论)  所用时间: " + (
          System.currentTimeMillis() - begintime));
      }
    } catch (Exception ex) {
      if (this.log.isErrorEnabled()) {
        this.log.error(ex);
      }
    }
    request.setAttribute("comments", comments);
  }
  





  private void getRecommendMerchants(HttpServletRequest request, int channelId)
  {
    long begintime = System.currentTimeMillis();
    RecommendMerchantInfoDao merchantDao = new RecommendMerchantInfoDaoImpl();
    List merchants = null;
    


    merchants = merchantDao.getRecommendMerchantInfo(channelId);
    

    try
    {
      if (this.log.isWarnEnabled()) {
        this.log.warn("(推荐商家) 所用时间: " + (
          System.currentTimeMillis() - begintime));
      }
    } catch (Exception ex) {
      if (this.log.isErrorEnabled()) {
        this.log.error(ex);
      }
    }
    
    if (merchants.size() > 12) {
      merchants = merchants.subList(0, 12);
    }
    request.setAttribute("merchants", merchants);
  }
}
