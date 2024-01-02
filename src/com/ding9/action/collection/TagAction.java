package com.ding9.action.collection;

import com.ding9.dao.collection.UserTagDao;
import com.ding9.dao.collection.UserTagDaoImpl;
import com.ding9.entity.collection.UserTagVO;
import com.ding9.sso.SSOAppManager;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;







public class TagAction
  extends DispatchAction
{
  UserTagDao tagDao = new UserTagDaoImpl();
  
  private int getUserId(HttpServletRequest request, HttpServletResponse response)
  {
    return new SSOAppManager(request, response).findUserId();
  }
  












  public ActionForward doSave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int user_id = getUserId(request, response);
    

    TagAF af = (TagAF)form;
    
    int type = af.getType();
    String tab_name = af.getLb_name();
    








    UserTagVO vo = new UserTagVO();
    vo.setType(type);
    vo.setUser_id(user_id);
    
    int flag = this.tagDao.addLabel(tab_name, vo);
    
    response.sendRedirect("tag.do?method=doQuery&type=" + type);
    
    return null;
  }
  











  public ActionForward doDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int id = Integer.parseInt(request.getParameter("id"));
    int type = Integer.parseInt(request.getParameter("type"));
    
    int flag = this.tagDao.delLabel(id);
    


    response.sendRedirect("tag.do?method=doQuery&type=" + type);
    
    return null;
  }
  











  public ActionForward doUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    TagAF af = (TagAF)form;
    int type = af.getType();
    String name = af.getLb_name();
    int id = af.getUslb_id();
    

    UserTagVO vo = new UserTagVO();
    vo = this.tagDao.findByPk(id);
    
    int flag = this.tagDao.ModLabel(vo, name);
    
    response.sendRedirect("tag.do?method=doQuery&type=" + type);
    
    return null;
  }
  










  public ActionForward doQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    int user_id = getUserId(request, response);
    
    int type = Integer.parseInt(request.getParameter("type"));
    
    List list = this.tagDao.query(user_id, type);
    
    request.setAttribute("list", list);
    
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
}
