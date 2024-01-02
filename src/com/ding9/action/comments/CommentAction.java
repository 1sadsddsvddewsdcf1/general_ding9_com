package com.ding9.action.comments;

import com.ding9.action.PaginationQuery;
import com.ding9.dao.comments.CommentsDaoImpl;
import com.ding9.sql.PagedList;
import com.ding9.sso.SSOAppManager;
import com.ding9.util.SplitPage;
import com.ding9.util.StringHelper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;




public class CommentAction
  extends DispatchAction
{
  private static final Log log = LogFactory.getLog(CommentAction.class);
  private ActionMessages messages = new ActionMessages();
  
  private ActionErrors errors = new ActionErrors();
  
  public ActionForward listComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    CommentForm commentform = (CommentForm)form;
    PaginationQuery recomQuery = new PaginationQuery();
    String pageNum = StringHelper.formatNullValue(request.getParameter("pageNum"), Integer.toString(recomQuery.getCurrentPage()));
    String pageSize = "10";
    commentform.setPageNum(Integer.parseInt(pageNum));
    commentform.setPagesize(Integer.parseInt(pageSize));
    int current_page = commentform.getPageNum();
    
    if (current_page == 0) {
      current_page = 1;
      commentform.setPageNum(current_page);
    }
    int size = commentform.getPagesize();
    if (size == 0) {
      size = 10;
      commentform.setPagesize(size);
    }
    recomQuery.setPageSize(commentform.getPagesize());
    recomQuery.setCurrentPage(commentform.getCurrentpage());
    
    CommentsDaoImpl cdi = new CommentsDaoImpl();
    

















    Integer user_id = Integer.valueOf(new SSOAppManager(request, response).findUserId());
    log.info("user_id = " + user_id);
    List list = cdi.getCommentsList(user_id.intValue(), 
      recomQuery.getPageSize(), 
      recomQuery.getCurrentPage());
    






    if (list != null)
    {
      SplitPage pagel = new SplitPage();
      PagedList cu = (PagedList)list;
      
      StringBuffer url = new StringBuffer("comments.do?method=listComment");
      request.setAttribute("url", url.toString());
      request.setAttribute("pagelist", pagel
      
        .SplitPage(cu.getCurrentpage(), cu.getPagecount(), "&pagesize=" + size + "&currentpage="));
    }
    

    request.setAttribute("results", list);
    


    return mapping.findForward("list");
  }
  
  public ActionForward listCommentCredit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    CommentForm commentform = (CommentForm)form;
    PaginationQuery recomQuery = new PaginationQuery();
    String pageNum = StringHelper.formatNullValue(request.getParameter("pageNum"), Integer.toString(recomQuery.getCurrentPage()));
    String pageSize = "10";
    commentform.setPageNum(Integer.parseInt(pageNum));
    commentform.setPagesize(Integer.parseInt(pageSize));
    int current_page = commentform.getPageNum();
    
    if (current_page == 0) {
      current_page = 1;
      commentform.setPageNum(current_page);
    }
    int size = commentform.getPagesize();
    if (size == 0) {
      size = 10;
      commentform.setPagesize(size);
    }
    recomQuery.setPageSize(commentform.getPagesize());
    recomQuery.setCurrentPage(commentform.getCurrentpage());
    
    CommentsDaoImpl cdi = new CommentsDaoImpl();
    















    Integer user_id = Integer.valueOf(new SSOAppManager(request, response).findUserId());
    
    List list = cdi.getCommentCreditList(user_id.intValue(), 
      recomQuery.getPageSize(), 
      recomQuery.getCurrentPage());
    






    if (list != null)
    {
      SplitPage pagel = new SplitPage();
      PagedList cu = (PagedList)list;
      
      StringBuffer url = new StringBuffer("comments.do?method=listCommentCredit");
      request.setAttribute("url", url.toString());
      request.setAttribute("pagelist", pagel
      
        .SplitPage(cu.getCurrentpage(), cu.getPagecount(), "&pagesize=" + size + "&currentpage="));
    }
    

    request.setAttribute("results", list);
    


    return mapping.findForward("cclist");
  }
  
  public ActionForward deleteComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    CommentForm cf = (CommentForm)form;
    
    if (!this.messages.isEmpty()) {
      this.messages.clear();
    }
    if (!this.errors.isEmpty()) {
      this.errors.clear();
    }
    
    CommentsDaoImpl dao = new CommentsDaoImpl();
    int result = dao.deleteComments(cf.getId());
    
    if (result > 0) {
      this.messages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "msg.delete.success", "评论"));
      saveMessages(request, this.messages);
    } else {
      this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "msg.delete.unsuccess", "评论"));
      saveErrors(request, this.errors);
    }
    
    return listComment(mapping, cf, request, response);
  }
  
  public ActionForward addRestore(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    if (!this.messages.isEmpty()) {
      this.messages.clear();
    }
    if (!this.errors.isEmpty()) {
      this.errors.clear();
    }
    
    CommentForm cf = (CommentForm)form;
    

    int user_id = new SSOAppManager(request, response).findUserId();
    CommentsDaoImpl dao = new CommentsDaoImpl();
    int result = dao.insertProductComment(cf.getId(), cf.getRes_content(), user_id);
    
    if (result > 0) {
      this.messages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "msg.add.success", "回复"));
      saveMessages(request, this.messages);
    } else {
      this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "msg.add.unsuccess", "回复"));
      saveErrors(request, this.errors);
    }
    







    return listComment(mapping, cf, request, response);
  }
}
