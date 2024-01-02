package com.ding9.dao.product;

import com.ding9.entity.cityomit.Province;
import com.ding9.entity.comment.MessageRestore;
import com.ding9.entity.commentsonproduct.CommentsOnProduct;
import com.ding9.entity.merchant.Merchant;
import com.ding9.entity.merchant.MerchantPlayment;
import com.ding9.entity.product.ProductParameterName;
import com.ding9.entity.product.ProductParameterValue;
import com.ding9.entity.product.ProductPic;
import com.ding9.entity.product.RebuildPic;
import com.ding9.entity.user.User;
import com.ding9.multipleentity.MuMerchantiProductnfo;
import com.ding9.multipleentity.MuProductInfo;
import com.ding9.multipleentity.MuUserMessage;
import com.ding9.multipleentity.ProductSaleInfo;
import com.ding9.result.article.ArticleMoreInfo;
import com.ding9.result.cityomit.OmitInfo;
import com.ding9.result.comsale.CommonProductSalesInfo;
import com.ding9.result.message.MessageInfo;
import com.ding9.result.message.MessageRestoreInfo;
import com.ding9.result.product.ProductBrandNameInfo;
import com.ding9.result.product.ProductPicIndex;
import com.ding9.result.product.ProductPlayment;
import com.ding9.result.product.ProductPriceInfo;
import com.ding9.result.product.RebuildProductPicInfo;
import com.ding9.result.product.ReviewProductInfo;
import com.ding9.result.product.parameter.ProductParameterGSMTime;
import com.ding9.result.product.parameter.ProductParameterNameResult;
import com.ding9.result.user.UserNameTimeInfo;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.PagedList;
import com.ding9.sql.SQLParam;
import com.ding9.util.Environment;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductDaoImpl implements ProductDao
{
  private IDBAccess dba = null;
  
  private StringBuffer sqlstr = null;
  
  private String sql = null;
  private static Log log = LogFactory.getLog(com.ding9.dao.advertisement.AdvertisementDaoImpl.class);
  







  public List getProductInfo(int prma_id)
    throws SQLException
  {
    List rec = null;
    try {
      this.dba = new DBAccessDefaultlImpl();
      List pic = null;
      List pic2 = null;
      BaseResult produtparameter = new com.ding9.result.product.ProductInfo();
      
      this.sqlstr = new StringBuffer();
      this.sqlstr
        .append("SELECT M.PRSO_ID,M.PRBR_ID,M.MIN_PRICE,M.MAX_PRICE,M.MERCHANT_COUNT,M.COMMENT_COUNT,M.PRODUCT_LEVEL,M.PRMA_REMARK,M.PRMA_NAME");
      this.sqlstr.append(" FROM PRODUCT_MASTER M");
      this.sqlstr.append(" WHERE  M.PRMA_ID=? ");
      this.dba.setParam(new SQLParam(1, 1, prma_id));
      rec = this.dba.queryData(this.sqlstr.toString(), produtparameter);
      this.dba.closeConnection();
      produtparameter = null;
      ProductPic productpic = null;
      this.sqlstr = null;
      if ((!rec.isEmpty()) && 
        (rec.size() > 0)) {
        MuProductInfo info = (MuProductInfo)rec.get(0);
        

        pic = getRebuildPic(prma_id, 2);
        if ((pic != null) && (pic.size() > 0)) {
          RebuildPic repic = (RebuildPic)pic.get(0);
          info.setPicno2(" src=" + Environment.getImageServer() + 
            repic.getLocal_address());
        }
        else {
          pic2 = getProductPicIndex(String.valueOf(prma_id));
          
          if (!pic2.isEmpty()) {
            if (pic2.size() > 0) {
              productpic = (ProductPic)pic2.get(0);
              info.setPicno2(" src=" + 
                productpic.getPrac_address() + 
                " width=160 height=160 ");
            }
          } else {
            info.setPicno2(" src=" + 
              Environment.getTempProductPicture() + 
              " width=160 height=160 ");
          }
        }
        
        pic = getRebuildPic(prma_id, 0);
        if ((pic != null) && (pic.size() > 0)) {
          RebuildPic repic = (RebuildPic)pic.get(0);
          info.setPiclarge(Environment.getImageServer() + 
            repic.getLocal_address());



        }
        else if (!pic2.isEmpty()) {
          if (pic2.size() > 0) {
            productpic = (ProductPic)pic2.get(0);
            info.setPiclarge(productpic.getPrac_address());
          }
        } else {
          info.setPiclarge(Environment.getTempProductPicture());
        }
        
      }
      
    }
    catch (Exception ex)
    {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return rec;
  }
  








  public List getRebuildPic(int prma_id, int rpt_id)
    throws SQLException
  {
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult name = new RebuildProductPicInfo();
      this.sqlstr = new StringBuffer();
      List rec = null;
      if (rpt_id != 0)
      {
        this.sqlstr.append("SELECT local_address FROM rebuild_pic  WHERE prma_id=? and rpt_id=? ");
        this.dba.setParam(new SQLParam(2, 1, rpt_id));
      }
      else {
        this.sqlstr.append("SELECT local_address FROM rebuild_pic  WHERE prma_id=? and rpt_id>=2 order by rpt_id desc ");
      }
      this.dba.setParam(new SQLParam(1, 1, prma_id));
      if (rpt_id != 0) {
        rec = this.dba.queryData(this.sqlstr.toString(), name);
      } else {
        rec = this.dba.queryDataPagination(this.sqlstr.toString(), name, 1, 1);
      }
      this.dba.closeConnection();
      name = null;
      this.sqlstr = null;
      return rec;
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return null;
  }
  






  public List getPrbrNameInfo(int prbr_id)
    throws SQLException
  {
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult name = new ProductBrandNameInfo();
      this.sqlstr = new StringBuffer();
      this.sqlstr.append("SELECT prbr_name");
      this.sqlstr.append(" FROM product_brand ");
      this.sqlstr
        .append(" WHERE prbr_id = ?");
      this.dba.setParam(new SQLParam(1, 1, prbr_id));
      List rec = this.dba.queryData(this.sqlstr.toString(), name);
      this.dba.closeConnection();
      name = null;
      this.sqlstr = null;
      return rec;
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return null;
  }
  











  public List getPatameterInfo(String patamete, int prma_id)
    throws SQLException
  {
    List rec = null;
    if ((patamete != null) && (!"".equals(patamete))) {
      try {
        this.dba = new DBAccessDefaultlImpl();
        BaseResult produtparameter = new com.ding9.result.product.parameter.ProductParameterValueResult();
        this.sqlstr = new StringBuffer();
        this.sqlstr.append("select *");
        this.sqlstr.append(" FROM " + patamete);
        this.sqlstr.append(" where prma_id=? ");
        this.dba.setParam(new SQLParam(1, 1, prma_id));
        rec = this.dba.queryData(this.sqlstr.toString(), produtparameter);
        this.dba.closeConnection();
        produtparameter = null;
        this.sqlstr = null;
      }
      catch (Exception ex)
      {
        if (log.isDebugEnabled()) {
          log.debug("getAds() :" + ex.getMessage());
        }
      }
    }
    return rec;
  }
  






  public List getProductPatameterInfo(String patamete)
    throws SQLException
  {
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult produtparameter = new ProductParameterNameResult();
      this.sqlstr = new StringBuffer();
      
      this.sqlstr.append("SELECT prac_field, prac_field_name");
      this.sqlstr.append(" FROM product_field_name ");
      this.sqlstr.append("WHERE prac_table =? ");
      this.dba.setParam(new SQLParam(1, 5, patamete));
      List rec = this.dba.queryData(this.sqlstr.toString(), produtparameter);
      this.dba.closeConnection();
      produtparameter = null;
      this.sqlstr = null;
      return rec;
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return null;
  }
  






  public List getPatameterGSMTime(int prma_id)
    throws SQLException
  {
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult produtparameter = new ProductParameterGSMTime();
      this.sqlstr = new StringBuffer();
      this.sqlstr.append("SELECT field_65,field_97");
      this.sqlstr.append(" FROM z_parameters31 ");
      this.sqlstr.append("WHERE prma_id =?");
      this.dba.setParam(new SQLParam(1, 1, prma_id));
      List rec = this.dba.queryData(this.sqlstr.toString(), produtparameter);
      this.dba.closeConnection();
      produtparameter = null;
      this.sqlstr = null;
      return rec;
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return null;
  }
  







  public List getMessageInfo(int prma_id, int current_page, int size)
    throws SQLException
  {
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult messageinfo = new MessageInfo();
      
      this.sqlstr = new StringBuffer();
      this.sqlstr
        .append("SELECT ID,AUTHOR_ID,TITLE,CONTENT,SOURCE,SOURCE_URL,DISADVANTAGE,ADVANTAGE,RELEASE_TIME,AUTHOR_NAME");
      this.sqlstr.append(" FROM COMMENTS_ON_PRODUCT  WHERE PRMA_ID=?");
      this.sqlstr.append(" ORDER BY RELEASE_TIME DESC ");
      this.dba.setParam(new SQLParam(1, 1, prma_id));
      List rec = this.dba.queryDataPagination(this.sqlstr.toString(), messageinfo, 
        size, current_page);
      this.dba.closeConnection();
      messageinfo = null;
      this.sqlstr = null;
      
      return rec;
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return null;
  }
  






  public List getUserMessageInfo(int user_id)
    throws SQLException
  {
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult info = new UserNameTimeInfo();
      this.sqlstr = new StringBuffer();
      this.sqlstr
        .append("select user_name,user_date_reg from user_info  where user_id=?");
      this.dba.setParam(new SQLParam(1, 1, user_id));
      List rec = this.dba.queryData(this.sqlstr.toString(), info);
      this.dba.closeConnection();
      info = null;
      this.sqlstr = null;
      
      return rec;
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return null;
  }
  




















  public List getMerchantInfo(int prma_id, int isforestall, int pay, int type, String city, String price, int fag, String credit)
    throws SQLException
  {
    List rec = null;
    try {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult merchant = new com.ding9.multipleresult.MerchantProductInfo();
      String search = "";
      String order = "";
      

      if ("up".equals(price)) {
        order = " ORDER BY p.mepr_price DESC ";
      } else if ("down".equals(price)) {
        order = " ORDER BY p.mepr_price  ";
      } else {
        order = " ORDER BY p.mepr_value DESC ";
      }
      if ("up".equals(credit)) {
        order = " ORDER BY m.COMMENTS_LEVEL desc ";
      } else if ("down".equals(credit)) {
        order = " ORDER BY m.COMMENTS_LEVEL ";
      }
      if ((1 == isforestall) && (" ORDER BY p.mepr_value DESC ".equals(order))) {
        search = " and p.mepr_forestall!=0 ";

      }
      else if ((1 != isforestall) && 
        (" ORDER BY p.mepr_value DESC ".equals(order))) {
        search = " and p.mepr_forestall=0 ";
      }
      if (pay != 0)
        search = search + " and m.merc_payment like '%" + pay + "%' ";
      if (type != 0) {
        if (1 == type)
          search = search + " and m.merc_type =1 ";
        if (2 == type)
          search = search + " and m.merc_type =0 ";
        if (3 == type)
          search = search + " and m.merc_type =2 ";
      }
      if ((city != null) && (!"".equals(city)) && (!"null".equals(city))) {
        search = search + " and m.merc_omit='" + city + "' ";
      }
      


      this.sqlstr = new StringBuffer();
      this.sqlstr.append("SELECT   P.MEPR_PRICE, P.MEPR_FORESTALL, P.MERC_ID, P.MEPR_VALUE, P.MEPR_TIME,");
      this.sqlstr.append("P.UP_TIME, P.MEPR_WEB_ADDRESS, W.MERC_WEB_NAME, M.MERC_OMIT,");
      this.sqlstr.append("M.MERC_TYPE, M.MERC_PHONE, M.COMMENTS_LEVEL, M.MESH_CHAP_LOGO,");
      this.sqlstr.append("M.MERC_COM_NAME,  M.MERC_CITY, M.MERC_EMAIL,");
      this.sqlstr.append("  DECODE (PROVINCE.PROV_NAME, '', '', PROV_NAME)|| DECODE (CITY.CITY_NAME, '', '', '·' || CITY.CITY_NAME)  AS MERC_HOME,  M.COMMENTS_CNT");
      this.sqlstr.append(" FROM MERCHANT_PRODUCT P, MERCHANT_BASEINFO M, MERCHANT_WEBINFO W, PROVINCE, CITY ");
      this.sqlstr.append(" WHERE  M.MERC_ID = P.MERC_ID AND M.MERC_OMIT = PROVINCE.PROV_ID(+) AND M.MERC_ID=W.MERC_ID ");
      this.sqlstr.append(" AND M.MERC_CITY = CITY.CITY_ID(+) AND P.MEPR_YN = 1 AND P.SYS_YN = 1");
      this.sqlstr.append(" AND P.MEPR_PRICE != 0  AND P.MEPR_FORESTALL = 0 AND P.PRMA_ID = ?");
      


      this.sqlstr.append(search);
      this.sqlstr.append(order);
      this.dba.setParam(new SQLParam(1, 1, prma_id));
      if (fag == 0) {
        rec = this.dba.queryDataPagination(this.sqlstr.toString(), merchant, 10, 1);
      } else {
        rec = this.dba.queryData(this.sqlstr.toString(), merchant);
      }
      log.warn(this.sqlstr);
      
      this.dba.closeConnection();
      merchant = null;
      this.sqlstr = null;

    }
    catch (Exception ex)
    {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return rec;
  }
  








  public List getProductCityInfo(int prma_id)
    throws SQLException
  {
    try
    {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult omit = new OmitInfo();
      StringBuffer sql = new StringBuffer("SELECT DISTINCT PROVINCE.PROV_ID,PROVINCE.PROV_NAME");
      sql.append(" FROM MERCHANT_PRODUCT P, MERCHANT_BASEINFO M ,PROVINCE");
      sql.append(" WHERE  P.MERC_ID = M.MERC_ID    AND M.MERC_OMIT=PROVINCE.PROV_ID(+) ");
      sql.append(" AND P.MEPR_YN =1 AND P.SYS_YN =1 AND P.MEPR_PRICE !=0   AND   P.PRMA_ID =?");
      this.dba.setParam(new SQLParam(1, 1, prma_id));
      List rec = this.dba.queryData(sql.toString(), omit);
      this.dba.closeConnection();
      omit = null;
      this.sqlstr = null;
      
      return rec;
    }
    catch (Exception ex) {
      if (log.isDebugEnabled()) {
        log.debug("getAds() :" + ex.getMessage());
      }
    }
    return null;
  }
  









  public List getPlayment(int prma_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult ment = new ProductPlayment();
    String sql = "SELECT DISTINCT M.MERC_PAYMENT FROM MERCHANT_PRODUCT P, MERCHANT_BASEINFO M WHERE  M.MERC_PAYMENT IS NOT NULL AND P.MEPR_YN =1 AND P.SYS_YN =1 AND P.MEPR_PRICE !=0 AND P.MEPR_PRICE IS NOT NULL AND P.MERC_ID = M.MERC_ID AND P.PRMA_ID =?";
    
    this.dba.setParam(new SQLParam(1, 1, prma_id));
    List rec = this.dba.queryData(sql, ment);
    this.dba.closeConnection();
    ment = null;
    this.sqlstr = null;
    
    return rec;
  }
  














  public List getMobileArticle(int memt_id, int reltype, int prma_id, int size)
  {
    List rst = null;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(new SQLParam(1, 1, memt_id));
    this.dba.setParam(new SQLParam(2, 1, reltype));
    this.dba.setParam(new SQLParam(3, 1, prma_id));
    ArticleMoreInfo map = new ArticleMoreInfo();
    
    this.sql = "SELECT a.memt_id, a.article_id, a.display, a.title, a.url, a.release_time FROM article a, article_relation b WHERE a.memt_id =? AND a.article_id = b.article_id AND b.relation_type =? AND b.relation_value =? ORDER BY b.show_order";
    
    if (size != 0) {
      rst = this.dba.queryDataPagination(this.sql, map, size, 1);
    }
    else
    {
      rst = this.dba.queryData(this.sql, map);
    }
    
    this.dba.closeConnection();
    this.sql = null;
    map = null;
    return rst;
  }
  










  public List getAllArticle(int memt_id, int prma_id, int prso_id_one, int prso_id_two, int prso_id_three, int size)
  {
    List rst = null;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(new SQLParam(1, 1, prma_id));
    this.dba.setParam(new SQLParam(2, 1, prso_id_one));
    this.dba.setParam(new SQLParam(3, 1, prso_id_two));
    this.dba.setParam(new SQLParam(4, 1, prso_id_three));
    this.dba.setParam(new SQLParam(5, 1, memt_id));
    this.dba.setParam(new SQLParam(6, 1, size));
    ArticleMoreInfo map = new ArticleMoreInfo();
    
    StringBuffer sql1 = new StringBuffer("SELECT MEMT_ID, ARTICLE_ID, DISPLAY, TITLE, URL, RELEASE_TIME FROM (SELECT MEMT_ID, ARTICLE_ID, DISPLAY, TITLE, URL, RELEASE_TIME FROM  (SELECT A.MEMT_ID, A.ARTICLE_ID, A.DISPLAY, A.TITLE, A.URL, A.RELEASE_TIME,ROWNUM AS PAG_NUM  FROM ARTICLE A, ARTICLE_RELATION B WHERE  A.ARTICLE_ID = B.ARTICLE_ID ");
    sql1.append(" AND ((B.RELATION_TYPE =0 AND B.RELATION_VALUE =?) OR  (B.RELATION_TYPE =1 AND B.RELATION_VALUE =?) OR  (B.RELATION_TYPE =2 AND B.RELATION_VALUE =?) OR  (B.RELATION_TYPE =3 AND B.RELATION_VALUE =?))  AND A.MEMT_ID =?  ORDER BY B.RELATION_VALUE DESC )  WHERE PAG_NUM <=?   ) ALL1  ORDER BY RELEASE_TIME DESC");
    
    rst = this.dba.queryData(sql1.toString(), map);
    
    this.dba.closeConnection();
    sql1 = null;
    map = null;
    return rst;
  }
  





  public List getProductPrise(int prma_id, float prise, int sort_id, int prbr_id)
    throws SQLException
  {
    List rst = null;
    this.dba = new DBAccessDefaultlImpl();
    this.sql = null;
    
    ProductPriceInfo map = new ProductPriceInfo();
    
    if (sort_id != 0) {
      this.sql = "SELECT B.PRMA_ID,B.MIN_PRICE,B.PRMA_NAME,B.MERCHANT_COUNT FROM (SELECT M.PRMA_ID,M.MIN_PRICE,M.PRMA_NAME,M.MERCHANT_COUNT FROM PRODUCT_MASTER M WHERE M.PRSO_ID=?  AND PRMA_ID!=?  AND MERCHANT_COUNT>0 AND ABS(MIN_PRICE-?)<=?/10 ) B ORDER BY B.MERCHANT_COUNT DESC ";
      this.dba.setParam(new SQLParam(1, 1, sort_id));
    } else {
      this.sql = "SELECT B.PRMA_ID,B.MIN_PRICE,B.PRMA_NAME,B.MERCHANT_COUNT FROM (SELECT M.PRMA_ID,M.MIN_PRICE,M.PRMA_NAME,M.MERCHANT_COUNT FROM PRODUCT_MASTER M WHERE M.PRBR_ID=?  AND PRMA_ID!=?  AND MERCHANT_COUNT>0 AND ABS(MIN_PRICE-?)<=?/10) B ORDER BY B.MERCHANT_COUNT DESC  ";
      this.dba.setParam(new SQLParam(1, 1, prbr_id));
    }
    

    this.dba.setParam(new SQLParam(2, 1, prma_id));
    this.dba.setParam(new SQLParam(3, 4, prise));
    this.dba.setParam(new SQLParam(4, 4, prise));
    

    rst = this.dba.queryDataPagination(this.sql, map, 6, 1);
    
    return rst;
  }
  






  public List getReviewInfo(int prma_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult name = new ReviewProductInfo();
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("SELECT rpi_merit,rpi_fefect,rpi_integration");
    this.sqlstr.append(" FROM review_product_info ");
    this.sqlstr.append(" WHERE prma_id =?");
    this.dba.setParam(new SQLParam(1, 1, prma_id));
    List rec = this.dba.queryData(this.sqlstr.toString(), name);
    this.dba.closeConnection();
    name = null;
    this.sqlstr = null;
    return rec;
  }
  








  public List getMerchantProductInfo(int prma_id, int pay, int type, String city, String price, int fag, String credit, List sale)
    throws SQLException
  {
    ArrayList results = null;
    


    MuMerchantiProductnfo merclisttemp = null;
    String name = null;
    List mercinfo = null;
    List mercone = null;
    List cityinfo = null;
    try {
      results = new ArrayList();
      
      if (((price == null) || ("".equals(price)) || ("null".equals(price))) && (
        (credit == null) || ("".equals(credit)) || 
        ("null".equals(credit))))
        mercone = getMerchantInfo(prma_id, 1, pay, type, city, 
          price, fag, credit);
      boolean buy = false;
      
      mercinfo = getMerchantInfo(prma_id, 0, pay, type, city, price, 
        fag, credit);
      for (int i = 0; i < mercinfo.size() + 1; i++)
      {
        if (i == 0) {
          if (mercone != null)
          {
            if (mercone.size() > 0) {
              merclisttemp = (MuMerchantiProductnfo)mercone
                .get(0);
              buy = true;
            }
          }
        } else {
          merclisttemp = (MuMerchantiProductnfo)mercinfo.get(i - 1);
        }
        if ((buy) || (i > 0))
        {
          if (merclisttemp.getMerc_web_name() != null) {
            name = merclisttemp.getMerc_web_name();
          } else
            name = merclisttemp.getMerc_com_name();
          merclisttemp.setMerc_com_name(name);
          if (merclisttemp.getUp_time() != null) {
            merclisttemp.setUp_time(
              merclisttemp.getUp_time().substring(0, 10));
          }
          
          merclisttemp.setPrma_id(prma_id);
          
          if (sale != null) {
            for (int j = 0; j < sale.size(); j++) {
              ProductSaleInfo saleInfo = (ProductSaleInfo)sale
                .get(j);
              if (saleInfo.getMerc_id() == 
                merclisttemp.getMerc_id())
              {
                merclisttemp.setScale_title(saleInfo.getTitle());
              }
            }
          }
          
          results.add(merclisttemp);
        }
      }
    }
    catch (Exception localException) {}
    





    return results;
  }
  





  public List getProductMessageInfo(int prma_id, int current_page, int size, int currentRestore_page, int size_Restore)
    throws SQLException
  {
    ArrayList results = null;
    ArrayList res1 = new ArrayList();
    try {
      results = new ArrayList();
      List res = getMessageInfo(prma_id, current_page, size);
      List user = null;
      List restore = null;
      for (int i = 0; i < res.size(); i++) {
        MuUserMessage mum = new MuUserMessage();
        CommentsOnProduct mm = (CommentsOnProduct)res
          .get(i);
        
        if (mm.getAuthorId() > 0) {
          user = getUserMessageInfo(mm.getAuthorId());
          if (!user.isEmpty()) {
            User u = (User)user.get(0);
            mum.setUser_date_reg(u.getUser_date_reg());
            mum.setUser_name(u.getUser_name());
          }
        }
        restore = getProductMessageRestore(mm.getId(), 
          currentRestore_page, size_Restore);
        
        if (restore != null) {
          mum.setCount(String.valueOf(restore.get(0)));
          mum.setRestore((List)restore.get(1));
        }
        mum.setAuthor_name(mm.getAuthorName());
        mum.setMema_id(mm.getId());
        mum.setMema_content(mm.getContent());
        mum.setMema_defect(mm.getDisadvantage());
        mum.setMema_merit(mm.getAdvantage());
        mum.setMema_time(mm.getReleaseTime());
        mum.setMema_title(mm.getTitle());
        mum.setUrl(mm.getSourceUrl());
        mum.setSource(mm.getSource());
        restore = null;
        results.add(mum);
      }
      
      res1.add(0, String.valueOf(((PagedList)res).getPagecount()));
      res1.add(1, results);
    }
    catch (Exception localException) {}
    



    return res1;
  }
  





  public List getProductMessageRestore(int mema_id, int current_page, int size)
    throws SQLException
  {
    ArrayList results = null;
    List user = null;
    int count = 0;
    ArrayList res1 = new ArrayList();
    try {
      this.dba = new DBAccessDefaultlImpl();
      BaseResult messageinfo = new MessageRestoreInfo();
      
      this.sqlstr = new StringBuffer();
      this.sqlstr.append("SELECT user_id,mere_content,mere_time");
      this.sqlstr.append(" from message_restore ");
      this.sqlstr.append(" where mema_id=?");
      this.sqlstr.append(" ORDER BY mere_id desc ");
      this.dba.setParam(new SQLParam(1, 1, mema_id));
      List res = this.dba.queryDataPagination(this.sqlstr.toString(), messageinfo, 
        size, current_page);
      this.dba.closeConnection();
      messageinfo = null;
      this.sqlstr = null;
      results = new ArrayList();
      count = ((PagedList)res).getRecordcount();
      for (int i = 0; i < res.size(); i++)
      {
        MessageRestore mm = (MessageRestore)res
          .get(i);
        user = getUserMessageInfo(mm.getUser_id());
        if ((user != null) && (user.size() > 0)) {
          User u = (User)user.get(0);
          mm.setUser_name(u.getUser_name());
        }
        results.add(mm);
      }
    }
    catch (Exception localException) {}
    



    res1.add(0, String.valueOf(count));
    res1.add(1, results);
    return res1;
  }
  





  public List getProductPatameterInfo(String patamete, int prma_id)
    throws SQLException
  {
    ArrayList results = null;
    try
    {
      results = new ArrayList();
      List rec1 = getPatameterInfo(patamete, prma_id);
      HashMap hm = (HashMap)rec1.get(0);
      List rec = getProductPatameterInfo(patamete);
      String value = null;
      for (int i = 0; i < rec.size(); i++) {
        ProductParameterName name = (ProductParameterName)rec.get(i);
        ProductParameterValue pv = new ProductParameterValue();
        value = (String)hm.get(name.getField_name());
        if ((value != null) && 
          (value.length() > 0)) {
          pv.setField_name(name.getField_content());
          pv.setField_value(value);
          pv.setParametername(name);
          results.add(pv);
        }
      }
      


      rec1 = null;
      hm = null;
    }
    catch (Exception localException) {}
    



    return results;
  }
  






  public List getSalepromotion(int prma_id)
    throws SQLException
  {
    List recAll = new ArrayList();
    
    this.dba = new DBAccessDefaultlImpl();
    BaseResult name = new CommonProductSalesInfo();
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("SELECT info_id,title,content,pub_time,a.merc_id,useful_life,source_url,info_type,b.mesh_chap_logo,w.merc_web_name,b.merc_phone");
    this.sqlstr.append(" FROM common_salepromotion_info a ,merchant_baseinfo b ,merchant_webinfo w ");
    this.sqlstr.append(" WHERE  a.merc_id=b.merc_id and w.merc_id=b.merc_id and prma_id =? and  info_status=1  and  out_date>sysdate ");
    this.dba.setParam(new SQLParam(1, 1, prma_id));
    List rec = this.dba.queryData(this.sqlstr.toString(), name);
    this.dba.closeConnection();
    name = null;
    this.sqlstr = null;
    return rec;
  }
  








  public List getOmitInfo(int prma_id)
    throws SQLException
  {
    List mercomit = new ArrayList();
    try {
      List res = getProductCityInfo(prma_id);
      

      Province pv = null;
      Province pv_temp = null;
      String temp = null;
      boolean tag = true;
      for (int i = 0; i < res.size(); i++) {
        pv = (Province)res.get(i);
        temp = pv.getProv_name();
        if (mercomit.size() == 0) {
          mercomit.add(pv);
        }
        tag = true;
        for (int j = 0; j < mercomit.size(); j++) {
          pv_temp = (Province)mercomit.get(j);
          if (temp.equals(pv_temp.getProv_name())) {
            tag = false;
          }
        }
        if (tag) {
          mercomit.add(pv);
        }
      }
    }
    catch (Exception localException) {}
    

    return mercomit;
  }
  


  public static HashMap getPlayment()
  {
    HashMap pm = new HashMap();
    pm.put("231101", "货到付款");
    pm.put("241501", "招行一卡通");
    pm.put("241601", "环讯IPS/i付通");
    pm.put("211101", "邮政汇款");
    pm.put("241101", "工行网上支付");
    pm.put("241701", "首信易支付");
    pm.put("241801", "银联电子支付(ChinaPay)");
    pm.put("241201", "建行网上支付");
    pm.put("221101", "银行汇款");
    pm.put("911101", "支付宝");
    pm.put("241901", "快钱");
    pm.put("242001", "云网支付");
    pm.put("911201", "财付通支付");
    pm.put("911301", "YeePay易宝");
    pm.put("911401", "网汇通支付");
    pm.put("911501", "百付通支付");
    pm.put("911601", "网银在线");
    pm.put("911701", "易达信动");
    pm.put("911801", "和讯支付");
    
    return pm;
  }
  




  public List getPayInfo(int prma_id)
    throws SQLException
  {
    ArrayList res_temp = null;
    ArrayList key = null;
    HashMap pm = getPlayment();
    boolean tag = true;
    MerchantPlayment mp = null;
    try {
      res_temp = new ArrayList();
      key = new ArrayList();
      List res = getPlayment(prma_id);
      for (int i = 0; i < res.size(); i++) {
        Merchant mer = (Merchant)res
          .get(i);
        String[] temp = mer.getMerc_playment().split(",");
        for (int j = 0; j < temp.length; j++) {
          mp = new MerchantPlayment();
          res_temp.add(temp[j]);
          tag = true;
          if (i == 0) {
            mp.setKey(temp[j]);
            mp.setValue((String)pm.get(temp[j]));
            key.add(mp);
          } else {
            for (int h = 0; h < key.size(); h++) {
              if (temp[j].equals(((MerchantPlayment)key.get(h)).getKey())) {
                tag = false;
              }
            }
            
            if (tag) {
              mp.setKey(temp[j]);
              mp.setValue((String)pm.get(temp[j]));
              key.add(mp);
            }
          }
        }
      }
    }
    catch (Exception localException) {}
    





    return key;
  }
  





  public List getProductPicIndex(String prmaid)
    throws SQLException
  {
    this.sqlstr = new StringBuffer();
    this.dba = new DBAccessDefaultlImpl();
    int prma_id = Integer.parseInt(prmaid);
    this.dba.setParam(new SQLParam(1, 1, prma_id));
    this.sql = "SELECT product_pic.prma_id,product_pic.web_address,product_pic.prac_address FROM product_pic\tWHERE product_pic.prma_id =?";
    
    BaseResult productpicindex = new ProductPicIndex();
    List rec = this.dba.queryData(this.sql, productpicindex);
    
    this.dba.closeConnection();
    productpicindex = null;
    this.sql = null;
    return rec;
  }
  







  public List getSixProduct(int prma_id, float prise, int sort_id, int prbr_id)
    throws SQLException
  {
    List pic = null;
    List big = getProductPrise(prma_id, prise, sort_id, prbr_id);
    ProductPic productpic = null;
    for (int i = 0; i < big.size(); i++) {
      MuProductInfo info = (MuProductInfo)big
        .get(i);
      pic = getRebuildPic(info.getPrma_id(), 1);
      
      if ((pic != null) && (pic.size() > 0)) {
        RebuildPic repic = (RebuildPic)pic.get(0);
        info.setPrac_address(" src=" + Environment.getImageServer() + 
          repic.getLocal_address());
      } else {
        pic = 
          getProductPicIndex(String.valueOf(info.getPrma_id()));
        if (!pic.isEmpty()) {
          if (pic.size() > 0)
            productpic = (ProductPic)pic.get(0);
          info.setPrac_address(" src=" + productpic.getPrac_address() + 
            " width=80 height=80 ");
        } else {
          info.setPrac_address(" src=" + 
            Environment.getTempProductPicture() + 
            " width=80 height=80 ");
        }
      } }
    this.sqlstr = null;
    
    return big;
  }
}
