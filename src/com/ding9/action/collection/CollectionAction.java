package com.ding9.action.collection;

import com.ding9.dao.collection.CollectionDao;
import com.ding9.dao.collection.CollectionDaoImpl;
import com.ding9.dao.collection.UserTagDao;
import com.ding9.dao.collection.UserTagDaoImpl;
import com.ding9.entity.collection.CollectionVO;
import com.ding9.sso.SSOAppManager;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;





public class CollectionAction
  extends DispatchAction
{
  UserTagDao tagDao = new UserTagDaoImpl();
  
  CollectionDao collectionDao = new CollectionDaoImpl();
  
  private int getUserId(HttpServletRequest request, HttpServletResponse response)
  {
    return new SSOAppManager(request, response).findUserId();
  }
  

  public ActionForward toSave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int user_id = getUserId(request, response);
    


    String url = request.getParameter("url");
    int id = Integer.parseInt(request.getParameter("id"));
    int type = Integer.parseInt(request.getParameter("type"));
    String title = request.getParameter("title");
    List list = this.tagDao.query(user_id, type);
    
    request.setAttribute("list", list);
    request.setAttribute("url", url);
    request.setAttribute("id", Integer.valueOf(id));
    
    request.setAttribute("type", Integer.valueOf(type));
    request.setAttribute("title", title);
    
    return mapping.findForward("collection");
  }
  












  public ActionForward doSave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int user_id = getUserId(request, response);
    int type = Integer.parseInt(request.getParameter("type"));
    int collection_id = Integer.parseInt(request.getParameter("id"));
    String url = request.getParameter("url");
    String title = request.getParameter("title");
    String remark = request.getParameter("remark");
    String tag = request.getParameter("tag");
    
    CollectionVO vo = new CollectionVO();
    vo.setUser_id(user_id);
    vo.setCollection_type(type);
    vo.setCollection_url(url);
    vo.setCollection_id(collection_id);
    vo.setTitle(title);
    vo.setRemark(remark);
    vo.setTag(tag);
    
    int flag = this.collectionDao.saveCollection(vo);
    

    int count = this.collectionDao.getProductCount(collection_id);
    
    response.setContentType("text/xml; charset=GB2312");
    response.setHeader("Cache-Control", "no-cache");
    
    PrintWriter out = response.getWriter();
    out.println("<pront>");
    out.println("<flag>" + flag + "</flag>");
    out.println("<count>" + count + "</count>");
    out.println("</pront>");
    out.close();
    
    return null;
  }
  














  public ActionForward doDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int type = Integer.parseInt(request.getParameter("type"));
    int pk = Integer.parseInt(request.getParameter("id"));
    int flag = this.collectionDao.delete(pk);
    
    if (type == 1) {
      response.sendRedirect("collection.do?method=doQuery&type=1");
      return null;
    }
    if (type == 2) {
      response.sendRedirect("collection.do?method=doQuery&type=2");
      return null;
    }
    if (type == 3) {
      response.sendRedirect("collection.do?method=doQuery&type=3");
      return null;
    }
    return null;
  }
  



  public ActionForward doUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int pk = 52;
    CollectionVO vo = new CollectionVO();
    vo.setUscl_id(pk);
    vo.setRemark("cjrlt");
    vo.setTitle("title");
    
    int flag = this.collectionDao.modify(vo);
    
    System.out.println("~~~~~modify:" + flag);
    return null;
  }
  
  public ActionForward doQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int user_id = getUserId(request, response);
    

    int type = Integer.parseInt(request.getParameter("type"));
    int tag_id = 0;
    
    if (request.getParameter("tag_id") != null) {
      tag_id = Integer.parseInt(request.getParameter("tag_id"));
    }
    
    List tag_list = this.tagDao.query(user_id, type);
    List list = this.collectionDao.query(user_id, tag_id, type);
    
    request.setAttribute("list", list);
    request.setAttribute("tag_list", tag_list);
    
    if (type == 1) {
      return mapping.findForward("product");
    }
    if (type == 2) {
      return mapping.findForward("merchant");
    }
    if (type == 3) {
      return mapping.findForward("search");
    }
    
    return null;
  }
  

  public ActionForward doChange(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int pk = 52;
    CollectionVO vo = new CollectionVO();
    vo.setUscl_id(pk);
    vo.setUslb_id(101);
    
    int flag = this.collectionDao.modify(vo);
    
    System.out.println("~~~~change:" + flag);
    
    return null;
  }
}
