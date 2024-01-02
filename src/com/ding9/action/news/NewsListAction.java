package com.ding9.action.news;

import com.ding9.dao.advertisement.AdvertisementDaoImpl;
import com.ding9.dao.article.ArticleManageDaoImpl;
import com.ding9.entity.article.MessageManageType;
import com.ding9.sql.PagedList;
import com.ding9.util.Constants;
import com.ding9.util.KeywordsOptimizeFactory;
import com.ding9.util.ProjectEnvironment;
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



public class NewsListAction
  extends Action
{
  private static final Log log = LogFactory.getLog(NewsListAction.class);
  


  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    NewsListForm frm = (NewsListForm)form;
    
    ArticleManageDaoImpl articleManageDaoImpl = new ArticleManageDaoImpl();
    AdvertisementDaoImpl advertisementDaoImpl = new AdvertisementDaoImpl();
    
    int channelId = frm.getChannelId();
    List result = null;
    try
    {
      long starttime = System.currentTimeMillis();
      long begintime = System.currentTimeMillis();
      long endtime = 0L;
      StringBuffer timeresult = new StringBuffer();
      
      request.setAttribute("Top", advertisementDaoImpl.getAds(channelId, 29, 116));
      request.setAttribute("Bottom", advertisementDaoImpl.getAds(channelId, 29, 117));
      if (log.isWarnEnabled()) {
        endtime = System.currentTimeMillis();
        timeresult.append("TopBottom:" + (endtime - begintime) + "  ");
        begintime = System.currentTimeMillis();
      }
      int prso_id_one = frm.getPrso_id_one();
      
      int count_record = 0;
      int count_page = 0;
      int current_page = 1;
      int size = frm.getPage_size();
      String item_start_end = null;
      
      int memt_id = frm.getMemt_id();
      int article_id = frm.getArticle_id();
      int relation_type = frm.getRelation_type();
      
      int relation_value = prso_id_one;
      
      if (size <= 0)
        size = 20;
      if (frm.getCurrent_page() > 0) {
        current_page = frm.getCurrent_page();
      }
      







      result = articleManageDaoImpl.getMessageManageTypeArticle(memt_id);
      request.setAttribute("MemtName", result);
      if (log.isWarnEnabled()) {
        endtime = System.currentTimeMillis();
        timeresult.append("MemtName:" + (endtime - begintime) + "  ");
        begintime = System.currentTimeMillis();
      }
      if ((result != null) && (result.size() > 0)) {
        MessageManageType messageManageType = (MessageManageType)result.get(0);
        Map param = new HashMap();
        
        param.put("@B@", messageManageType.getMemt_name());
        String title = KeywordsOptimizeFactory.getInstance().getKeopTitle(50, param);
        if ((title == null) || (title.equals("")))
          title = KeywordsOptimizeFactory.getInstance().getKeopTitle(7, param);
        String desc = KeywordsOptimizeFactory.getInstance().getKeopDescription(50, param);
        if ((desc == null) || (desc.equals("")))
          desc = KeywordsOptimizeFactory.getInstance().getKeopDescription(7, param);
        String keywords = KeywordsOptimizeFactory.getInstance().getKeopKeyWords(50, param);
        if ((keywords == null) || (keywords.equals("")))
          keywords = KeywordsOptimizeFactory.getInstance().getKeopKeyWords(7, param);
        request.setAttribute("Title", title);
        request.setAttribute("Desc", desc);
        request.setAttribute("KeyWords", keywords);
      }
      request.setAttribute("META", ProjectEnvironment.getMETA());
      if (log.isWarnEnabled()) {
        endtime = System.currentTimeMillis();
        timeresult.append("META:" + (endtime - begintime) + "  ");
        begintime = System.currentTimeMillis();
      }
      result = articleManageDaoImpl.getMessageManageTypeArticle(0, prso_id_one, 0, 8);
      request.setAttribute("MessageManageType", result);
      if (log.isWarnEnabled()) {
        endtime = System.currentTimeMillis();
        timeresult.append("MessageManageType:" + (endtime - begintime) + "  ");
        begintime = System.currentTimeMillis();
      }
      result = articleManageDaoImpl.getMessageManageTypeArticle(memt_id);
      request.setAttribute("MessageManageTypeInfo", result);
      if (log.isWarnEnabled()) {
        endtime = System.currentTimeMillis();
        timeresult.append("MessageManageTypeInfo:" + (endtime - begintime) + "  ");
        begintime = System.currentTimeMillis();
      }
      result = articleManageDaoImpl.getArticleInfo(memt_id, article_id, relation_type, relation_value, size, current_page);
      count_record = ((PagedList)result).getRecordcount();
      if (current_page > ((PagedList)result).getPagecount()) {
        current_page = ((PagedList)result).getPagecount();
        result = articleManageDaoImpl.getArticleInfo(memt_id, article_id, relation_type, relation_value, size, current_page);
      }
      request.setAttribute("ArticleInfo", result);
      if (log.isWarnEnabled()) {
        endtime = System.currentTimeMillis();
        timeresult.append("ArticleInfo:" + (endtime - begintime) + "  ");
        begintime = System.currentTimeMillis();
      }
      log.info("relation_value = " + relation_value);
      request.setAttribute("channelId", Integer.valueOf(relation_value));
      request.setAttribute("channelName", Constants.getChannelName(relation_value));
      
      if (count_record == 0) {
        frm.setCurrent_page(1);
        return null;
      }
      if (count_record % size == 0) {
        count_page = count_record / size;
      } else {
        count_page = count_record / size + 1;
      }
      if (count_page < current_page)
        current_page = count_page;
      frm.setCurrent_page(current_page);
      if (count_page == current_page) {
        item_start_end = (current_page - 1) * size + 1 + "-" + ((current_page - 1) * size + (count_record - (count_page - 1) * size));
      } else {
        item_start_end = (current_page - 1) * size + 1 + "-" + ((current_page - 1) * size + size);
      }
      



      String url = "/news/news-list.do?memt_id=" + memt_id + "&prso_id_one=" + prso_id_one + "&prso_name_one_en=" + frm.getPrso_name_one_en() + "&current_page=";
      request.setAttribute("PageUrl", url);
      

      request.setAttribute("CountRecord", String.valueOf(count_record));
      request.setAttribute("CountPage", String.valueOf(count_page));
      request.setAttribute("CurrentPage", String.valueOf(current_page));
      request.setAttribute("ItemStartEnd", item_start_end);
      
      if (log.isInfoEnabled()) {
        endtime = System.currentTimeMillis();
        timeresult.append("总的开销:" + (endtime - starttime) + "  ");
        request.setAttribute("timeresult", timeresult);
      }
    } catch (Exception ex) {
      if (log.isErrorEnabled()) log.error(getClass().getName() + " : " + ex.getMessage());
      ex.printStackTrace();
    }
    
    return mapping.findForward("index");
  }
}
