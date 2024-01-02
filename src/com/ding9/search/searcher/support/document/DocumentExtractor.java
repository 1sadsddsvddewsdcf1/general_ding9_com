package com.ding9.search.searcher.support.document;

import com.ding9.search.entity.article.Article;
import com.ding9.search.entity.cheapcard.CheapCard;
import com.ding9.search.entity.comment.Comment;
import com.ding9.search.entity.comment.RestoreVO;
import com.ding9.search.entity.merchant.MerchantInfo;
import com.ding9.search.entity.merchant.MerchantPicVO;
import com.ding9.search.entity.merchantproduct.MerchantProduct;
import com.ding9.search.entity.product.ProductMaster;
import com.ding9.search.entity.productparasort.ProductPara;
import com.ding9.search.entity.promotion.Promotion;
import com.ding9.search.util.Environment;
import com.ding9.search.util.ParserUtils;
import com.ding9.search.util.StringHelper;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.document.Document;



public abstract class DocumentExtractor
{
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
  
  private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
  





  public static ProductMaster getProductMaster(Document doc)
  {
    ProductMaster pm = new ProductMaster();
    try
    {
      pm.setPrma_id(Integer.parseInt(doc.get("prma_id")));
    } catch (Exception localException) {}
    try {
      pm.setPrma_name(doc.get("prma_name").toUpperCase());
    } catch (Exception localException1) {}
    try {
      pm.setPrma_ena(doc.get("prma_ena"));
    } catch (Exception localException2) {}
    try {
      pm.setPrso_id(Integer.parseInt(doc.get("prso_id")));
    } catch (Exception localException3) {}
    try {
      pm.setPrso_name(doc.get("prso_name").toUpperCase());
    } catch (Exception localException4) {}
    try {
      pm.setPrbr_id(Integer.parseInt(doc.get("prbr_id")));
    } catch (Exception localException5) {}
    try {
      pm.setPrbr_name(doc.get("prbr_name").toUpperCase());
    } catch (Exception localException6) {}
    try {
      pm.setPrbr_english_name(doc.get("prbr_english_name").toUpperCase());
    } catch (Exception localException7) {}
    try {
      pm.setPrma_remark(ParserUtils.parse(doc.get("prma_remark").toUpperCase()));
    } catch (Exception localException8) {}
    try {
      pm.setMerchant_count(Integer.parseInt(doc.get("merchant_count")));
    } catch (Exception localException9) {}
    try {
      pm.setComment_count(Integer.parseInt(doc.get("comment_count")));
    } catch (Exception localException10) {}
    try {
      pm.setProduct_level(Integer.parseInt(doc.get("product_level")));
    } catch (Exception localException11) {}
    try {
      pm.setMin_price(StringHelper.stringToFloat(doc.get("min_price")));
    } catch (Exception localException12) {}
    try {
      pm.setMax_price(StringHelper.stringToFloat(doc.get("max_price")));
    } catch (Exception localException13) {}
    try {
      pm.setPrso_id_one(Integer.parseInt(doc.get("prso_id_one")));
    } catch (Exception localException14) {}
    try {
      pm.setPrso_name_one(doc.get("prso_name_one").toUpperCase());
    } catch (Exception localException15) {}
    try {
      pm.setPrso_id_two(Integer.parseInt(doc.get("prso_id_two")));
    } catch (Exception localException16) {}
    try {
      pm.setPrso_name_two(doc.get("prso_name_two").toUpperCase());
    } catch (Exception localException17) {}
    try {
      pm.setPic_address(doc.get("pic_address"));
      if ("".equals(pm.getPic_address())) {
        pm.setPic_address(Environment.getTempProductPicture());
      } else {
        pm.setPic_address(Environment.getImageServer() + pm.getPic_address().replace("..", ""));
      }
    } catch (Exception localException18) {}
    try {
      pm.setPrac_address(doc.get("prac_address"));
      if ("".equals(pm.getPrac_address())) {
        pm.setPrac_address(Environment.getTempProductPicture());
      } else {
        pm.setPrac_address(Environment.getImageServer() + pm.getPrac_address().replace("..", ""));
      }
    } catch (Exception localException19) {}
    try {
      pm.setSmall_pic_address(doc.get("small_pic_address"));
      if ("".equals(pm.getSmall_pic_address())) {
        pm.setSmall_pic_address(Environment.getTempProductPicture());
      } else {
        pm.setSmall_pic_address(Environment.getImageServer() + pm.getSmall_pic_address().replace("..", ""));
      }
    } catch (Exception localException20) {}
    try {
      pm.setMepr_id(Integer.parseInt(doc.get("mepr_id")));
    } catch (Exception localException21) {}
    try {
      pm.setMerc_product_address(doc.get("merc_product_address"));
    } catch (Exception localException22) {}
    try {
      pm.setMerc_id(Integer.parseInt(doc.get("merc_id")));
    } catch (Exception localException23) {}
    try {
      pm.setMerc_com_name(doc.get("merc_com_name").toUpperCase());
    }
    catch (Exception localException24) {}
    try {
      String[] tmplist = doc.getValues("prma_name_alias") == null ? new String[0] : doc.getValues("prma_name_alias");
      String tmpstr = "";
      for (int i = 0; i < tmplist.length; i++) {
        String str = tmplist[i];
        str = str.replaceAll("<tr>", "");
        str = str.replaceAll("<td>", "");
        str = str.replaceAll("</tr>", "");
        str = str.replaceAll("</td>", "");
        tmpstr = str + ",";
      }
      pm.setPrma_name_alias(tmpstr.toUpperCase());
    } catch (Exception localException25) {}
    try {
      String[] tmplist = doc.getValues("prsoname_alias") == null ? new String[0] : doc.getValues("prsoname_alias");
      String tmpstr = "";
      for (int i = 0; i < tmplist.length; i++) {
        String str = tmplist[i];
        str = str.replaceAll("<tr>", "");
        str = str.replaceAll("<td>", "");
        str = str.replaceAll("</tr>", "");
        str = str.replaceAll("</td>", "");
        tmpstr = str + ",";
      }
      pm.setPrma_name_alias(tmpstr.toUpperCase());
    } catch (Exception localException26) {}
    try {
      String[] tmplist = doc.getValues("prbr_name_alias") == null ? new String[0] : doc.getValues("prbr_name_alias");
      String tmpstr = "";
      for (int i = 0; i < tmplist.length; i++) {
        String str = tmplist[i];
        str = str.replaceAll("<tr>", "");
        str = str.replaceAll("<td>", "");
        str = str.replaceAll("</tr>", "");
        str = str.replaceAll("</td>", "");
        tmpstr = str + ",";
      }
      pm.setPrma_name_alias(tmpstr.toUpperCase());
    } catch (Exception localException27) {}
    return pm;
  }
  





  public static Article getArticle(Document doc)
  {
    Article article = new Article();
    

    try
    {
      article.setArticle_id(Integer.parseInt(doc.get("article_id")));
    }
    catch (Exception localException) {}
    try
    {
      article.setTitle(doc.get("title"));
    }
    catch (Exception localException1) {}
    try
    {
      article.setMemt_id(Integer.parseInt(doc.get("memt_id")));
    }
    catch (Exception localException2) {}
    try
    {
      article.setSource_type(doc.get("source_type"));
    }
    catch (Exception localException3) {}
    try
    {
      String releaseTime = doc.get("release_time");
      if (releaseTime != null) {
        try {
          article.setRelease_time(dateFormat.parse(releaseTime));
        }
        catch (Exception localException4) {}
      }
    }
    catch (Exception localException5) {}
    try {
      article.setUrl(doc.get("url"));
    }
    catch (Exception localException6) {}
    try
    {
      article.setSource(doc.get("source"));
    }
    catch (Exception localException7) {}
    try
    {
      article.setAuthor(doc.get("author"));
    }
    catch (Exception localException8) {}
    try
    {
      article.setSource_relation_type(doc.get("source_relation_type"));
    }
    catch (Exception localException9) {}
    try
    {
      article.setSource_relation_value(doc.get("source_relation_value"));
    }
    catch (Exception localException10) {}
    try
    {
      article.setContent(ParserUtils.parse(doc.get("content")));
    }
    catch (Exception localException11) {}
    


    try
    {
      article.setDisplay(Integer.parseInt(doc.get("display")));
    }
    catch (Exception localException12) {}
    try
    {
      article.setPagination_sign(doc.get("pagination_sign"));
    }
    catch (Exception localException13) {}
    try
    {
      article.setCooperate_id(Integer.parseInt(doc.get("cooperate_id")));
    }
    catch (Exception localException14) {}
    try
    {
      article.setPicture(doc.get("picture"));
      if ("".equals(article.getPicture())) {
        article.setPicture(Environment.getTempProductPicture());
      } else {
        article.setPicture(Environment.getImageServer() + article.getPicture().replace("..", ""));
      }
    }
    catch (Exception localException15) {}
    try
    {
      article.setSort_prso_id_one(Integer.parseInt(doc.get("sort_prso_id_one")));
    }
    catch (Exception localException16) {}
    try
    {
      article.setSort_prso_name_one(doc.get("sort_prso_name_one"));
    }
    catch (Exception localException17) {}
    try
    {
      article.setSort_name(doc.get("sort_name").toUpperCase());
    }
    catch (Exception localException18) {}
    try
    {
      article.setRelation_type(Integer.parseInt(doc.get("relation_type")));
    }
    catch (Exception localException19) {}
    try
    {
      article.setRelation_value(Integer.parseInt(doc.get("relation_value")));
    }
    catch (Exception localException20) {}
    try
    {
      article.setPrma_id(Integer.parseInt(doc.get("prma_id")));
    }
    catch (Exception localException21) {}
    try
    {
      article.setPrma_name(doc.get("prma_name").toUpperCase());
    }
    catch (Exception localException22) {}
    try
    {
      article.setPrso_id_one(Integer.parseInt(doc.get("prso_id_one")));
    }
    catch (Exception localException23) {}
    try
    {
      article.setPrso_name_one(doc.get("prso_name_one").toUpperCase());
    }
    catch (Exception localException24) {}
    try
    {
      article.setPrso_id_two(Integer.parseInt(doc.get("prso_id_two")));
    }
    catch (Exception localException25) {}
    try
    {
      article.setPrso_name_two(doc.get("prso_name_two").toUpperCase());
    }
    catch (Exception localException26) {}
    try
    {
      article.setPrso_id_three(Integer.parseInt(doc.get("prso_id_three")));
    }
    catch (Exception localException27) {}
    try
    {
      article.setPrso_name_three(doc.get("prso_name_three").toUpperCase());
    }
    catch (Exception localException28) {}
    
    return article;
  }
  






  public static Comment getComment(Document doc)
  {
    Comment comment = new Comment();
    


    String[] mere_id = doc.getValues("mere_id");
    String[] user_id = doc.getValues("user_id");
    String[] mere_content = doc.getValues("mere_content");
    String[] mere_time = doc.getValues("mere_time");
    String[] user_name = doc.getValues("user_name");
    RestoreVO vo = null;
    List list = new ArrayList();
    
    if (mere_id != null) {
      for (int i = 0; i < mere_id.length; i++) {
        vo = new RestoreVO();
        vo.setMere_id(Integer.parseInt(mere_id[i]));
        vo.setUser_id(Integer.parseInt(user_id[i]));
        vo.setMere_content(mere_content[i]);
        

        try
        {
          vo.setMere_time(timeFormat.parse(mere_time[i]));
        }
        catch (Exception localException) {}
        vo.setUser_name(user_name[i]);
        list.add(vo);
      }
    }
    comment.setRestore(list);
    

    try
    {
      comment.setRecount(Integer.parseInt(doc.get("recount")));
    }
    catch (Exception localException1) {}
    try {
      comment.setComment_id(Integer.parseInt(doc.get("comment_id")));
    }
    catch (Exception localException2) {}
    try {
      String releaseTime = doc.get("release_time");
      
      if (releaseTime != null) {
        try {
          comment.setRelease_time(timeFormat.parse(releaseTime));
        }
        catch (Exception localException3) {}
      }
    } catch (Exception localException4) {}
    try {
      comment.setSource(doc.get("source").toUpperCase());
    }
    catch (Exception localException5) {}
    try {
      comment.setContent(ParserUtils.parse(doc.get("content")));
    }
    catch (Exception localException6) {}
    try {
      comment.setPrma_id(Integer.parseInt(doc.get("prma_id")));
    }
    catch (Exception localException7) {}
    try {
      comment.setComment_type(doc.get("comment_type"));
    }
    catch (Exception localException8) {}
    try {
      comment.setProduct_level(Integer.parseInt(doc.get("product_level")));
    }
    catch (Exception localException9) {}
    try {
      comment.setAdvantage(doc.get("advantage"));
    }
    catch (Exception localException10) {}
    try {
      comment.setDisadvantage(doc.get("disadvantage"));
    }
    catch (Exception localException11) {}
    try {
      comment.setSource_url(doc.get("source_url"));
    }
    catch (Exception localException12) {}
    try {
      comment.setTitle(doc.get("title"));
    }
    catch (Exception localException13) {}
    try {
      comment.setAuthor_id(Integer.parseInt(doc.get("author_id")));
    }
    catch (Exception localException14) {}
    try {
      comment.setAuthor_name(doc.get("author_name"));
    }
    catch (Exception localException15) {}
    try {
      comment.setHomepage(Integer.parseInt(doc.get("homepage")));
    }
    catch (Exception localException16) {}
    try {
      comment.setUserful_count(Integer.parseInt(doc.get("userful_count")));
    }
    catch (Exception localException17) {}
    try {
      comment.setPrma_name(doc.get("prma_name").toUpperCase());
    }
    catch (Exception localException18) {}
    try {
      comment.setPrso_id(Integer.parseInt(doc.get("prso_id")));
    }
    catch (Exception localException19) {}
    try {
      comment.setPrso_name(doc.get("prso_name").toUpperCase());
    }
    catch (Exception localException20) {}
    try {
      comment.setPrso_id_one(Integer.parseInt(doc.get("prso_id_one")));
    }
    catch (Exception localException21) {}
    try {
      comment.setPrso_name_one(doc.get("prso_name_one").toUpperCase());
    }
    catch (Exception localException22) {}
    try {
      comment.setPrso_id_two(Integer.parseInt(doc.get("prso_id_two")));
    }
    catch (Exception localException23) {}
    try {
      comment.setPrso_name_two(doc.get("prso_name_two").toUpperCase());
    }
    catch (Exception localException24) {}
    try {
      comment.setPic_address(doc.get("pic_address"));
      if ("".equals(comment.getPic_address())) {
        comment.setPic_address(Environment.getTempProductPicture());
      } else {
        comment.setPic_address(Environment.getImageServer() + comment.getPic_address().replace("..", ""));
      }
    }
    catch (Exception localException25) {}
    try {
      comment.setSmall_pic_address(doc.get("small_pic_address"));
      if ("".equals(comment.getSmall_pic_address())) {
        comment.setSmall_pic_address(Environment.getTempProductPicture());
      } else {
        comment.setSmall_pic_address(Environment.getImageServer() + comment.getSmall_pic_address().replace("..", ""));
      }
    }
    catch (Exception localException26) {}
    

    return comment;
  }
  





  public static CheapCard getCheapCard(Document doc)
  {
    CheapCard card = new CheapCard();
    
    try
    {
      card.setChca_id(Integer.parseInt(doc.get("chca_id")));
    }
    catch (Exception localException) {}
    
    try
    {
      card.setMerc_id(Integer.parseInt(doc.get("merc_id")));
    }
    catch (Exception localException1) {}
    try
    {
      card.setPrso_id_one(Integer.parseInt(doc.get("prso_id_one")));
    }
    catch (Exception localException2) {}
    try
    {
      card.setChca_pic(doc.get("chca_pic"));
      if ("".equals(card.getChca_pic())) {
        card.setChca_pic(Environment.getTempProductPicture());
      } else {
        card.setChca_pic(Environment.getImageServer() + card.getChca_pic().replace("..", ""));
      }
    }
    catch (Exception localException3) {}
    try
    {
      card.setChca_title(doc.get("chca_title").toUpperCase());
    }
    catch (Exception localException4) {}
    try
    {
      card.setChca_remark(ParserUtils.parse(doc.get("chca_remark")));
    }
    catch (Exception localException5) {}
    try
    {
      String end_time = doc.get("end_time");
      
      if (end_time != null) {
        try
        {
          card.setEnd_time(dateFormat.parse(end_time));
        }
        catch (Exception localException6) {}
      }
    }
    catch (Exception localException7) {}
    try {
      card.setChca_url(doc.get("chca_url"));
    }
    catch (Exception localException8) {}
    try
    {
      String chca_time = doc.get("chca_time");
      if (chca_time != null) {
        try {
          card.setChca_time(dateFormat.parse(chca_time));
        }
        catch (Exception localException9) {}
      }
    }
    catch (Exception localException10) {}
    try {
      card.setInfo_source(doc.get("info_source"));
    }
    catch (Exception localException11) {}
    try
    {
      card.setUseful_life(doc.get("useful_life"));
    }
    catch (Exception localException12) {}
    try
    {
      card.setSort_id(Integer.parseInt(doc.get("sort_id")));
    }
    catch (Exception localException13) {}
    try
    {
      card.setCooperate_id(Integer.parseInt(doc.get("cooperate_id")));
    }
    catch (Exception localException14) {}
    try
    {
      card.setBrand_name(doc.get("brand_name").toUpperCase());
    }
    catch (Exception localException15) {}
    try
    {
      card.setStore_name(doc.get("store_name").toUpperCase());
    }
    catch (Exception localException16) {}
    try
    {
      card.setMarketplace(doc.get("marketplace"));
    }
    catch (Exception localException17) {}
    try
    {
      card.setSowntown(doc.get("sowntown"));
    }
    catch (Exception localException18) {}
    try
    {
      card.setSort_name(doc.get("sort_name").toUpperCase());
    }
    catch (Exception localException19) {}
    try
    {
      card.setRecommend_sort_id(Integer.parseInt(doc.get("recommend_sort_id")));
    }
    catch (Exception localException20) {}
    try
    {
      card.setRecommend_sort_name(doc.get("recommend_sort_name"));
    }
    catch (Exception localException21) {}
    


    return card;
  }
  






  public static Promotion getPromotion(Document doc)
  {
    Promotion promotion = new Promotion();
    
    try
    {
      promotion.setInfo_id(Integer.parseInt(doc.get("info_id")));
    }
    catch (Exception localException) {}
    try {
      promotion.setPrso_id_one(Integer.parseInt(doc.get("prso_id_one")));
    }
    catch (Exception localException1) {}
    try {
      promotion.setPrso_id_two(Integer.parseInt(doc.get("prso_id_two")));
    }
    catch (Exception localException2) {}
    try {
      promotion.setPrso_id_three(Integer.parseInt(doc.get("prso_id_three")));
    }
    catch (Exception localException3) {}
    try {
      promotion.setPrso_name(doc.get("prso_name").toUpperCase());
    }
    catch (Exception localException4) {}
    try {
      promotion.setSort_id(Integer.parseInt(doc.get("sort_id")));
    }
    catch (Exception localException5) {}
    try {
      promotion.setTitle(doc.get("title").toUpperCase());
    }
    catch (Exception localException6) {}
    try {
      promotion.setRebate_range(doc.get("rebate_range"));
    }
    catch (Exception localException7) {}
    try {
      promotion.setContent(ParserUtils.parse(doc.get("content")));
    }
    catch (Exception localException8) {}
    try {
      promotion.setBrand_name(doc.get("brand_name").toUpperCase());
    }
    catch (Exception localException9) {}
    try {
      promotion.setStore_name(doc.get("store_name").toUpperCase());
    }
    catch (Exception localException10) {}
    try {
      promotion.setMarketplace(doc.get("marketplace"));
    }
    catch (Exception localException11) {}
    try {
      promotion.setSowntown(doc.get("sowntown"));
    }
    catch (Exception localException12) {}
    try {
      String pub_time = doc.get("pub_time");
      if (pub_time != null) {
        try {
          promotion.setPub_time(dateFormat.parse(pub_time));
        }
        catch (Exception localException13) {}
      }
    }
    catch (Exception localException14) {}
    try {
      promotion.setMerc_id(Integer.parseInt(doc.get("merc_id")));
    }
    catch (Exception localException15) {}
    try {
      promotion.setPrma_id(Integer.parseInt(doc.get("prma_id")));
    }
    catch (Exception localException16) {}
    try {
      promotion.setUseful_life(doc.get("useful_life"));
    }
    catch (Exception localException17) {}
    try {
      String out_date = doc.get("out_date");
      if (out_date != null) {
        try {
          promotion.setOut_date(dateFormat.parse(out_date));
        }
        catch (Exception localException18) {}
      }
    }
    catch (Exception localException19) {}
    try {
      promotion.setCooperate_id(Integer.parseInt(doc.get("cooperate_id")));
    }
    catch (Exception localException20) {}
    try {
      promotion.setInfo_source(doc.get("info_source"));
    }
    catch (Exception localException21) {}
    try {
      promotion.setSource_url(doc.get("source_url"));
    }
    catch (Exception localException22) {}
    try {
      promotion.setInfo_type(Integer.parseInt(doc.get("info_type")));
    }
    catch (Exception localException23) {}
    try {
      promotion.setPicture(doc.get("picture"));
      if ("".equals(promotion.getPicture())) {
        promotion.setPicture(Environment.getTempProductPicture());
      } else {
        promotion.setPicture(Environment.getImageServer() + promotion.getPicture().replace("..", ""));
      }
    }
    catch (Exception localException24) {}
    try {
      String begin_date = doc.get("begin_date");
      if (begin_date != null) {
        try {
          promotion.setBegin_date(dateFormat.parse(begin_date));
        }
        catch (Exception localException25) {}
      }
    }
    catch (Exception localException26) {}
    try {
      promotion.setPrma_name(doc.get("prma_name"));
    }
    catch (Exception localException27) {}
    try {
      promotion.setCoupon_type_id(Integer.parseInt(doc.get("coupon_type_id")));
    }
    catch (Exception localException28) {}
    try {
      promotion.setShop_id(Integer.parseInt(doc.get("shop_id")));
    }
    catch (Exception localException29) {}
    

    return promotion;
  }
  







  public static MerchantInfo getMerchantInfo(Document doc)
  {
    MerchantInfo vo = new MerchantInfo();
    

    try
    {
      vo.setIs_tmp(Integer.parseInt(doc.get("is_tmp")));
    }
    catch (Exception localException) {}
    
    try
    {
      vo.setMerc_id(Integer.parseInt(doc.get("merc_id")));
    }
    catch (Exception localException1) {}
    try
    {
      vo.setMerc_com_name(doc.get("merc_com_name"));
    }
    catch (Exception localException2) {}
    try
    {
      vo.setMerc_name(doc.get("merc_name"));
    }
    catch (Exception localException3) {}
    try
    {
      vo.setMerc_phone(doc.get("merc_phone"));
    }
    catch (Exception localException4) {}
    try
    {
      vo.setMerc_handset(doc.get("merc_handset"));
    }
    catch (Exception localException5) {}
    try
    {
      vo.setMerc_address(doc.get("merc_address"));
    }
    catch (Exception localException6) {}
    try
    {
      vo.setMerc_omit(doc.get("merc_omit"));
    }
    catch (Exception localException7) {}
    
    try
    {
      vo.setOmit_name(doc.get("omit"));
    }
    catch (Exception localException8) {}
    try
    {
      vo.setPPY(doc.get("ppy"));
    }
    catch (Exception localException9) {}
    try
    {
      vo.setMerc_city(doc.get("merc_city"));
    }
    catch (Exception localException10) {}
    try
    {
      vo.setCity_name(doc.get("city"));
    }
    catch (Exception localException11) {}
    try
    {
      vo.setCPY(doc.get("cpy"));
    }
    catch (Exception localException12) {}
    try
    {
      vo.setMerc_email(doc.get("merc_email"));
    }
    catch (Exception localException13) {}
    try
    {
      vo.setMerc_fax(doc.get("merc_fax"));
    }
    catch (Exception localException14) {}
    try
    {
      vo.setMerc_post(doc.get("merc_post"));
    }
    catch (Exception localException15) {}
    try
    {
      vo.setMerc_date(doc.get("merc_date"));
    }
    catch (Exception localException16) {}
    try {
      vo.setMerc_type(Integer.parseInt(doc.get("merc_type")));
    }
    catch (Exception localException17) {}
    try
    {
      vo.setMerc_msn(doc.get("merc_msn"));
    }
    catch (Exception localException18) {}
    try
    {
      vo.setMerc_qq(doc.get("merc_qq"));
    }
    catch (Exception localException19) {}
    try
    {
      vo.setMesh_chap_logo(doc.get("mesh_chap_logo"));
    }
    catch (Exception localException20) {}
    try
    {
      vo.setMerc_state(Integer.parseInt(doc.get("merc_state")));
    }
    catch (Exception localException21) {}
    try
    {
      vo.setMerc_from(Integer.parseInt(doc.get("merc_from")));
    }
    catch (Exception localException22) {}
    try
    {
      vo.setSys_yn(Integer.parseInt(doc.get("sys_yn")));
    }
    catch (Exception localException23) {}
    try
    {
      vo.setSyus_id(Integer.parseInt(doc.get("syus_id")));
    }
    catch (Exception localException24) {}
    try {
      vo.setMerc_equip(doc.get("merc_equip"));
    }
    catch (Exception localException25) {}
    try
    {
      vo.setEquip(doc.getValues("equip"));
    }
    catch (Exception localException26) {}
    try {
      vo.setPayment(doc.getValues("payment"));
    }
    catch (Exception localException27) {}
    try
    {
      vo.setMerc_payment(doc.get("merc_payment"));
    }
    catch (Exception localException28) {}
    try
    {
      vo.setRemark(doc.get("remark"));
    }
    catch (Exception localException29) {}
    try
    {
      vo.setComments_cnt(Integer.parseInt(doc.get("comments_cnt")));
    }
    catch (Exception localException30) {}
    try
    {
      vo.setComments_level(Integer.parseInt(doc.get("comments_level")));
    }
    catch (Exception localException31) {}
    try
    {
      vo.setProduct_cnt(Integer.parseInt(doc.get("product_cnt")));
    }
    catch (Exception localException32) {}
    try
    {
      vo.setUpdate_date(doc.get("update_date"));
    }
    catch (Exception localException33) {}
    
    try
    {
      vo.setMerc_web_name(doc.get("merc_web_name"));
    }
    catch (Exception localException34) {}
    try {
      vo.setMerc_url(doc.get("merc_url"));
    }
    catch (Exception localException35) {}
    try
    {
      vo.setMerc_web_size(doc.get("merc_web_size"));
    }
    catch (Exception localException36) {}
    


    try
    {
      vo.setMerc_bound(doc.get("merc_bound"));
    }
    catch (Exception localException37) {}
    try {
      vo.setBound(doc.getValues("bound"));
    }
    catch (Exception localException38) {}
    try
    {
      vo.setMesh_into_time(doc.get("mesh_into_time"));
    }
    catch (Exception localException39) {}
    try {
      vo.setMerc_description(doc.get("merc_description"));
    }
    catch (Exception localException40) {}
    try {
      vo.setMerc_serve(doc.get("merc_serve"));
    }
    catch (Exception localException41) {}
    try {
      vo.setMerc_freight(doc.get("merc_freight"));
    }
    catch (Exception localException42) {}
    try {
      vo.setMerc_main_bound(Integer.parseInt(doc.get("merc_main_bound")));
    }
    catch (Exception localException43) {}
    try {
      vo.setMesh_logo_money(doc.get("mesh_logo_money"));
    }
    catch (Exception localException44) {}
    


    String[] id = doc.getValues("id");
    String[] sort_id = doc.getValues("sort_id");
    String[] images_source = doc.getValues("images_source");
    String[] images_info = doc.getValues("images_info");
    String[] update_time = doc.getValues("update_time");
    
    MerchantPicVO picVO = null;
    
    List picList = new ArrayList();
    
    if (id != null) {
      for (int i = 0; i < id.length; i++) {
        picVO = new MerchantPicVO();
        picVO.setId(Integer.parseInt(id[i]));
        picVO.setSort_id(Integer.parseInt(sort_id[i]));
        picVO.setImages_source(images_source[i]);
        picVO.setImages_info(images_info[i]);
        picVO.setUpdate_time(update_time[i]);
        picList.add(picVO);
      }
    }
    vo.setPicList(picList);
    


    return vo;
  }
  







  public static RestoreVO getRestore(Document doc)
  {
    RestoreVO vo = new RestoreVO();
    try
    {
      vo.setMere_id(Integer.parseInt(doc.get("mere_id")));
    }
    catch (Exception localException) {}
    try {
      vo.setMema_id(Integer.parseInt(doc.get("mema_id")));
    }
    catch (Exception localException1) {}
    try {
      vo.setUser_id(Integer.parseInt(doc.get("user_id")));
    }
    catch (Exception localException2) {}
    try {
      vo.setMere_content(ParserUtils.parse(doc.get("mere_content")));
    }
    catch (Exception localException3) {}
    
    try
    {
      vo.setMere_time(dateFormat.parse(doc.get("mere_time")));
    }
    catch (Exception localException4) {}
    try {
      vo.setUser_name(doc.get("user_name"));
    }
    catch (Exception localException5) {}
    return vo;
  }
  
  public static MerchantProduct getMerchantProduct(Document doc) {
    MerchantProduct vo = new MerchantProduct();
    try
    {
      vo.setMeprPrice(new BigDecimal(doc.get("mepr_price")));
    }
    catch (Exception localException) {}
    try {
      vo.setPrmaId(Integer.parseInt(doc.get("prma_id")));
    }
    catch (Exception localException1) {}
    try {
      vo.setMercId(Integer.parseInt(doc.get("merc_id")));
    }
    catch (Exception localException2) {}
    try {
      vo.setPrmaName(doc.get("prma_name"));
    }
    catch (Exception localException3) {}
    try {
      vo.setPrma_ena(doc.get("prma_ena"));
    } catch (Exception localException4) {}
    try {
      vo.setPrma_remark(doc.get("prma_remark"));
    }
    catch (Exception localException5) {}
    try {
      vo.setProduct_level(Integer.parseInt(doc.get("product_level")));
    }
    catch (Exception localException6) {}
    try {
      vo.setComment_count(Integer.parseInt(doc.get("comment_count")));
    }
    catch (Exception localException7) {}
    try {
      vo.setMesh_logo(doc.get("mesh_logo"));
    }
    catch (Exception localException8) {}
    try {
      vo.setMerc_com_name(doc.get("merc_com_name"));
    }
    catch (Exception localException9) {}
    try {
      vo.setMerc_phone(doc.get("merc_phone"));
    }
    catch (Exception localException10) {}
    try {
      vo.setComments_cnt(Integer.parseInt(doc.get("comments_cnt")));
    }
    catch (Exception localException11) {}
    try {
      vo.setMerc_province(doc.get("merc_province"));
    } catch (Exception localException12) {}
    try {
      vo.setMerc_city(doc.get("merc_city"));
    }
    catch (Exception localException13) {}
    try {
      vo.setMerc_email(doc.get("merc_email"));
    }
    catch (Exception localException14) {}
    try {
      vo.setComments_level(Integer.parseInt(doc.get("comments_level")));
    }
    catch (Exception localException15) {}
    try {
      vo.setMerc_payment(doc.get("merc_payment"));
    }
    catch (Exception localException16) {}
    try {
      vo.setProduct_pic(doc.get("product_pic"));
    }
    catch (Exception localException17) {}
    try {
      vo.setMeprWebAddress(doc.get("mepr_web_address"));
    }
    catch (Exception localException18) {}
    try {
      vo.setSmall_pic_address(doc.get("small_pic_address"));
    } catch (Exception localException19) {}
    return vo;
  }
  



  public static ProductPara getProductPara(Document doc)
  {
    ProductPara ppara = new ProductPara();
    try
    {
      ppara.setPrma_id(Integer.parseInt(doc.get("prma_id")));
    }
    catch (Exception localException) {}
    try {
      ppara.setPrso_id(Integer.parseInt(doc.get("prso_id")));
    }
    catch (Exception localException1) {}
    try {
      ppara.setPrso_id_one(Integer.parseInt(doc.get("prso_id_one")));
    }
    catch (Exception localException2) {}
    try {
      ppara.setPrso_id_two(Integer.parseInt(doc.get("prso_id_two")));
    } catch (Exception localException3) {}
    try {
      ppara.setPrso_id_three(Integer.parseInt(doc.get("prso_id_three")));
    }
    catch (Exception localException4) {}
    try {
      ppara.setParam_name(doc.get("param_name"));
    }
    catch (Exception localException5) {}
    try {
      ppara.setParam_value(doc.get("param_value"));
    } catch (Exception localException6) {}
    return ppara;
  }
}
