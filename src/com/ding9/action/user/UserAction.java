package com.ding9.action.user;

import com.ding9.entity.user.UserAccountInfo;
import com.ding9.service.user.UserService;
import com.ding9.sso.SSOAppManager;
import com.ding9.sso.SSOUser;
import com.ding9.util.CookieUtil;
import com.ding9.util.Environment;
import com.ding9.util.mail.Mail;
import com.ding9.util.mail.MailVO;
import com.oreilly.servlet.Base64Decoder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;






public class UserAction
  extends DispatchAction
{
  private static final Logger logger = Logger.getLogger(UserAction.class);
  


  public ActionForward preModifyBaseInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered preModifyBaseInfo");
    UserForm userForm = (UserForm)form;
    
    ActionMessages messages = new ActionMessages();
    if (!messages.isEmpty()) {
      messages.clear();
    }
    
    int userId = getUserId(request, response);
    
    UserService userService = new UserService();
    UserAccountInfo user = userService.findById(userId);
    userForm.setUser(user);
    
    logger.info("left preModifyBaseInfo normally");
    return mapping.findForward("userbaseinfo");
  }
  


  public ActionForward doModifyBaseInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered doModifyBaseInfo");
    ActionErrors errors = new ActionErrors();
    ActionMessages messages = new ActionMessages();
    if (!errors.isEmpty()) {
      errors.clear();
    }
    if (!messages.isEmpty()) {
      messages.clear();
    }
    
    UserForm userForm = (UserForm)form;
    
    UserService userService = new UserService();
    int result = userService.updateUser(userForm.getUser());
    if (result == 1) {
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.update.success"));
      saveMessages(request, messages);
    } else {
      errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.update.unsuccess"));
      saveErrors(request, errors);
    }
    logger.info("left doModifyBaseInfo normally");
    return mapping.findForward("userbaseinfo");
  }
  


  public ActionForward doModifyEmail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered doModifyEmail");
    ActionErrors errors = new ActionErrors();
    ActionMessages messages = new ActionMessages();
    if (!errors.isEmpty()) {
      errors.clear();
    }
    if (!messages.isEmpty()) {
      messages.clear();
    }
    
    UserService userService = new UserService();
    UserForm userForm = (UserForm)form;
    UserAccountInfo user = userForm.getUser();
    String newEmail = userForm.getNewEmail();
    
    int checkResult = userService.checkEmail(newEmail);
    if (checkResult == 0) {
      errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("error.user.email.exist"));
      saveErrors(request, errors);
      return mapping.findForward("useremail");
    }
    String oldEmail = user.getUser_email();
    
    userForm.setNewEmail("");
    String username = user.getUser_name();
    
    MailVO mailVO = new MailVO();
    boolean mail = false;
    

    String newEmailPage = "/useremail/newemail_info.jsp?id=" + user.getUser_id() + "&username=" + username + "&useremail=" + newEmail;
    String newEmailUrl = Environment.getDomainName() + newEmailPage;
    mailVO.setTo(newEmail);
    mailVO.setSubject("感谢您注册顶九网");
    mailVO.setUrl(newEmailUrl);
    try {
      mail = Mail.sendMail(mailVO);
    } catch (MalformedURLException e) {
      if (logger.isEnabledFor(Level.ERROR)) {
        logger.error("MalformedURLException" + e.getMessage(), e);
      }
    } catch (UnsupportedEncodingException e) {
      if (logger.isEnabledFor(Level.ERROR)) {
        logger.error("UnsupportedEncodingException" + e.getMessage(), e);
      }
    }
    
    if ((oldEmail == null) && (!"".equals(oldEmail.trim())))
    {
      String oldEmailPage = "/useremail/oldemail_info.jsp?id=" + user.getUser_id() + "&username=" + username + "&useremail=" + newEmail;
      String oldEmailUrl = Environment.getDomainName() + oldEmailPage;
      mailVO.setTo(oldEmail);
      mailVO.setSubject("感谢您注册顶九网");
      mailVO.setUrl(oldEmailUrl);
      try {
        mail = Mail.sendMail(mailVO);
      } catch (MalformedURLException e) {
        if (logger.isEnabledFor(Level.ERROR)) {
          logger.error("MalformedURLException" + e.getMessage(), e);
        }
      } catch (UnsupportedEncodingException e) {
        if (logger.isEnabledFor(Level.ERROR)) {
          logger.error("UnsupportedEncodingException" + e.getMessage(), e);
        }
      }
    }
    
    if (mail) {
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.email.send.success"));
      saveMessages(request, messages);
    } else {
      errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.email.send.unsuccess"));
      saveErrors(request, errors);
    }
    
    logger.info("left doModifyEmail normally");
    return mapping.findForward("useremail");
  }
  

  public ActionForward doModifyPassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    if (logger.isInfoEnabled()) logger.info("entered doModifyPassword");
    ActionErrors errors = new ActionErrors();
    ActionMessages messages = new ActionMessages();
    if (!errors.isEmpty()) {
      errors.clear();
    }
    if (!messages.isEmpty()) {
      messages.clear();
    }
    
    UserForm userForm = (UserForm)form;
    
    UserService userService = new UserService();
    int result = userService.updatePassword(userForm.getUser().getUser_id(), 
      userForm.getOldPassword(), 
      userForm.getNewPassword(), 
      userForm.getVerifyPassword());
    
    if (result == 1) {
      if (logger.isInfoEnabled()) logger.info("save password normally");
      if (logger.isInfoEnabled()) logger.info("save Cookies...");
      SSOAppManager appMgr = new SSOAppManager(request, response);
      String cookieValue = appMgr.findSSOIdFromCookie();
      if (logger.isInfoEnabled()) logger.info("cookie Value : " + cookieValue);
      if (StringUtils.isBlank(cookieValue)) {
        response.sendRedirect(request.getContextPath() + "/logon/logon.jsp");
      }
      String[] cookStrings = cookieValue.split(":");
      String userId = cookStrings[0];
      String username = Base64Decoder.decode(cookStrings[1]);
      String password = Base64Decoder.decode(cookStrings[2]);
      String rememberMe = cookStrings[3];
      
      SSOUser ssoUser = new SSOUser();
      ssoUser.setUserId(Integer.parseInt(userId));
      ssoUser.setUsername(username);
      ssoUser.setPassword(password);
      ssoUser.setRememberMe(rememberMe);
      
      String cookvalue = CookieUtil.createAndSaveCookie(response, "SSOUserId", ssoUser, 28800);
      if ((StringUtils.isBlank(cookvalue)) && 
        (logger.isInfoEnabled())) { logger.info("save cookie value error");
      }
      
      userForm.setOldPassword("");
      userForm.setNewPassword("");
      userForm.setVerifyPassword("");
      
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.update.success"));
      saveMessages(request, messages);
    } else {
      if (logger.isInfoEnabled()) {
        logger.info("save password error");
        logger.info("save result : " + result);
      }
      
      switch (result) {
      case -1: 
        errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("error.parameter"));
        break;
      case -6: 
        errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("error.password.original"));
        break;
      case -7: 
        errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("error.password.confirm"));
        break;
      }
      
      
      if (!errors.isEmpty()) {
        saveErrors(request, errors);
      }
    }
    if (logger.isInfoEnabled()) logger.info("left doModifyPassword normally");
    return mapping.findForward("userpassword");
  }
  


  public ActionForward doAddQuestion(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered doAddQuestion");
    ActionErrors errors = new ActionErrors();
    ActionMessages messages = new ActionMessages();
    if (!errors.isEmpty()) {
      errors.clear();
    }
    if (!messages.isEmpty()) {
      messages.clear();
    }
    
    UserForm userForm = (UserForm)form;
    
    UserService userService = new UserService();
    int result = userService.addQuestion(userForm.getUser().getUser_id(), 
      userForm.getQuesCode(), 
      userForm.getAnswer());
    if (result == 1) {
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.update.success"));
      saveMessages(request, messages);
    } else {
      errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.update.unsuccess"));
      saveErrors(request, errors);
    }
    logger.info("left doAddQuestion normally");
    return mapping.findForward("userquestion");
  }
  


  public ActionForward doModifyQuestion(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered doModifyQuestion");
    ActionErrors errors = new ActionErrors();
    ActionMessages messages = new ActionMessages();
    if (!errors.isEmpty()) {
      errors.clear();
    }
    if (!messages.isEmpty()) {
      messages.clear();
    }
    
    UserForm userForm = (UserForm)form;
    
    UserService userService = new UserService();
    int result = userService.updateQuestion(userForm.getUser().getUser_id(), 
      userForm.getSrcQuesCode(), 
      userForm.getSrcAnswer(), 
      userForm.getNewQuesCode(), 
      userForm.getNewAnswer());
    if (result == 1) {
      messages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("msg.update.success"));
      saveMessages(request, messages);
    } else {
      logger.info("save question & answer error");
      logger.info("save result : " + result);
      switch (result) {
      case -1: 
        errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("error.parameter"));
        break;
      case -8: 
        errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("error.question"));
        break;
      case -9: 
        errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("error.answer"));
        break;
      }
      
      
      if (!errors.isEmpty()) {
        saveErrors(request, errors);
      }
    }
    logger.info("left doModifyQuestion normally");
    return mapping.findForward("userquestion");
  }
  


  public ActionForward preModifyEmail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered preModifyEmail");
    UserForm userForm = (UserForm)form;
    
    ActionMessages messages = new ActionMessages();
    if (!messages.isEmpty()) {
      messages.clear();
    }
    
    int userId = getUserId(request, response);
    
    UserService userService = new UserService();
    UserAccountInfo user = userService.findById(userId);
    userForm.setUser(user);
    
    logger.info("left preModifyEmail normally");
    return mapping.findForward("useremail");
  }
  


  public ActionForward preModifyPassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered preModifyPassword");
    UserForm userForm = (UserForm)form;
    
    ActionMessages messages = new ActionMessages();
    if (!messages.isEmpty()) {
      messages.clear();
    }
    int userId = getUserId(request, response);
    userForm.getUser().setUser_id(userId);
    
    logger.info("left preModifyPassword normally");
    return mapping.findForward("userpassword");
  }
  


  public ActionForward preModifyQuestion(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    logger.info("entered preModifyQuestion");
    UserForm userForm = (UserForm)form;
    
    ActionMessages messages = new ActionMessages();
    if (!messages.isEmpty()) {
      messages.clear();
    }
    int userId = getUserId(request, response);
    userForm.getUser().setUser_id(userId);
    
    logger.info("left preModifyQuestion normally");
    return mapping.findForward("userquestion");
  }
  
  private int getUserId(HttpServletRequest request, HttpServletResponse response)
  {
    return new SSOAppManager(request, response).findUserId();
  }
}
