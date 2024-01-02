package com.ding9.action.user;

import com.ding9.service.user.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;





public class EmailAction
  extends Action
{
  private static final Logger logger = Logger.getLogger(EmailAction.class);
  


  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered EmailAction.execute()");
    ActionErrors errors = new ActionErrors();
    ActionMessages messages = new ActionMessages();
    if (!errors.isEmpty()) {
      errors.clear();
    }
    if (!messages.isEmpty()) {
      messages.clear();
    }
    
    String userid = request.getParameter("userid");
    String username = request.getParameter("username");
    String useremail = request.getParameter("useremail");
    if (logger.isInfoEnabled()) {
      logger.info("userid: " + userid);
      logger.info("username: " + username);
      logger.info("useremail: " + useremail);
    }
    
    UserService userService = new UserService();
    
    boolean result = userService.updateEmail(Integer.parseInt(userid), useremail);
    if (result) {
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.update.success"));
      saveMessages(request, messages);
    } else {
      errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.update.unsuccess"));
      saveErrors(request, errors);
    }
    logger.info("left EmailAction.execute() normally");
    return mapping.findForward("success");
  }
}
