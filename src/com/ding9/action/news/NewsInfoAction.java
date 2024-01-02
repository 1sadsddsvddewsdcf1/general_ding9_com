package com.ding9.action.news;

import com.ding9.dao.advertisement.AdvertisementDaoImpl;
import com.ding9.dao.article.ArticleManageDaoImpl;
import com.ding9.entity.article.ArticleRelation;
import com.ding9.util.Constants;
import com.ding9.util.KeywordsOptimizeFactory;
import com.ding9.util.ProjectEnvironment;
import com.ding9.util.StringHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class NewsInfoAction
  extends Action
{
  private static final Log log = LogFactory.getLog(NewsInfoAction.class);
  


  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    NewsInfoForm frm = (NewsInfoForm)form;
    
    ArticleManageDaoImpl articleManageDaoImpl = new ArticleManageDaoImpl();
    AdvertisementDaoImpl advertisementDaoImpl = new AdvertisementDaoImpl();
    
    List result = null;
    
    int count_page = 0;
    int current_page = 1;
    
    int channelId = frm.getPrso_id_one();
    
    long starttime = System.currentTimeMillis();
    long begintime = System.currentTimeMillis();
    long endtime = 0L;
    StringBuffer timeresult = new StringBuffer();
    try {
      request.setAttribute("Top", advertisementDaoImpl.getAds(channelId, 30, 118));
      request.setAttribute("Bottom", advertisementDaoImpl.getAds(channelId, 30, 138));
    } catch (Exception ex) {
      if (log.isErrorEnabled()) log.error(getClass().getName() + " : " + ex.getMessage());
    }
    if (log.isInfoEnabled()) {
      endtime = System.currentTimeMillis();
      timeresult.append("TopBottom:" + (endtime - begintime) + "  ");
      begintime = System.currentTimeMillis();
    }
    int article_id = frm.getArticle_id();
    current_page = frm.getCurrent_page();
    
    result = articleManageDaoImpl.getMessageManageTypeByArticleId(article_id);
    request.setAttribute("MemtName", result);
    if (log.isInfoEnabled()) {
      endtime = System.currentTimeMillis();
      timeresult.append("MemtName:" + (endtime - begintime) + "  ");
      begintime = System.currentTimeMillis();
    }
    
    if (log.isInfoEnabled()) {
      endtime = System.currentTimeMillis();
      timeresult.append("META:" + (endtime - begintime) + "  ");
      begintime = System.currentTimeMillis();
    }
    result = articleManageDaoImpl.getMessageManageTypeArticle(0, channelId, 0, 8);
    request.setAttribute("MessageManageType", result);
    if (log.isInfoEnabled()) {
      endtime = System.currentTimeMillis();
      timeresult.append("MessageManageType:" + (endtime - begintime) + "  ");
      begintime = System.currentTimeMillis();
    }
    

    if (current_page == 0) {
      current_page = 1;
    }
    result = articleManageDaoImpl.getArticleInfo(0, article_id, 0, 0, 1, current_page);
    if ((result != null) && (result.size() > 0)) {
      ArticleRelation articleRelation = (ArticleRelation)result.get(0);
      count_page = articleRelation.getTotal_page();
    }
    






















    String url = "/news/news-info.do?article_id=" + article_id + "&prso_id_one=" + frm.getPrso_id_one() + "&prso_name_one_en=" + frm.getPrso_name_one_en() + "&current_page=";
    request.setAttribute("PageUrl", url);
    request.setAttribute("CountPage", Integer.valueOf(count_page));
    request.setAttribute("CurrentPage", Integer.valueOf(current_page));
    
    request.setAttribute("ArticleInfo", result);
    Map param = new HashMap();
    if ((result != null) && (result.size() > 0)) {
      param.put("@B@", ((ArticleRelation)result.get(0)).getTitle());
      param.put("@G@", StringHelper.getSubString(((ArticleRelation)result.get(0)).getContent(), 240));
    } else {
      param.put("@B@", "");
      param.put("@G@", "");
    }
    String title = KeywordsOptimizeFactory.getInstance().getKeopTitle(51, param);
    if ((title == null) || (title.equals("")))
      title = KeywordsOptimizeFactory.getInstance().getKeopTitle(8, param);
    String desc = KeywordsOptimizeFactory.getInstance().getKeopDescription(51, param);
    if ((desc == null) || (desc.equals("")))
      desc = KeywordsOptimizeFactory.getInstance().getKeopDescription(8, param);
    String keywords = KeywordsOptimizeFactory.getInstance().getKeopKeyWords(51, param);
    if ((keywords == null) || (keywords.equals("")))
      keywords = KeywordsOptimizeFactory.getInstance().getKeopKeyWords(8, param);
    request.setAttribute("Title", title);
    request.setAttribute("Desc", desc);
    request.setAttribute("KeyWords", keywords);
    request.setAttribute("META", ProjectEnvironment.getMETA());
    if (log.isInfoEnabled()) {
      endtime = System.currentTimeMillis();
      timeresult.append("ArticleInfo:" + (endtime - begintime) + "  ");
    }
    if (log.isInfoEnabled()) {
      endtime = System.currentTimeMillis();
      timeresult.append("总的开销:" + (endtime - starttime) + "  ");
      request.setAttribute("timeresult", timeresult);
    }
    
    request.setAttribute("channelId", Integer.valueOf(channelId));
    request.setAttribute("channelName", Constants.getChannelName(channelId));
    return mapping.findForward("index");
  }
}
