package com.ding9.action.logon;

import com.ding9.dao.user.UserInfoDaoImpl;
import com.ding9.entity.user.UserAccountInfo;
import com.ding9.service.user.UserService;
import com.ding9.util.Environment;
import com.ding9.util.MD5Helper;
import com.ding9.util.mail.Mail;
import com.ding9.util.mail.MailVO;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;





public class GetPwdAction
  extends DispatchAction
{
  private static final Logger logger = Logger.getLogger(GetPwdAction.class);
  private ActionMessages messages = new ActionMessages();
  private ActionErrors errors = new ActionErrors();
  



  public ActionForward getUserInfoByName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    System.out.println("test");
    LogonForm lf = (LogonForm)form;
    
    if (!this.messages.isEmpty()) {
      this.messages.clear();
    }
    if (!this.errors.isEmpty()) {
      this.errors.clear();
    }
    
    UserInfoDaoImpl uidi = new UserInfoDaoImpl();
    UserService us = new UserService();
    UserAccountInfo uai = uidi.findByName(lf.getUsername());
    
    if (!us.isActivated(lf.getUsername()))
    {
      this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "error.user.notActivated"));
      saveErrors(request, this.errors);
      return mapping.findForward("togetname");
    }
    
    if (uai == null)
    {
      this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "error.user.notexist"));
      saveErrors(request, this.errors);
      return mapping.findForward("togetname");
    }
    
    lf.setUsername(uai.getUser_name());
    lf.setPassword(uai.getUser_pass());
    
    return mapping.findForward("toemail");
  }
  



  public ActionForward getUpdPwd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    System.out.println("test");
    LogonForm lf = (LogonForm)form;
    
    if (!this.messages.isEmpty()) {
      this.messages.clear();
    }
    if (!this.errors.isEmpty()) {
      this.errors.clear();
    }
    
    UserInfoDaoImpl uidi = new UserInfoDaoImpl();
    System.out.println("user_id:" + lf.getUser_id());
    UserAccountInfo uai = uidi.findByUserSn(lf.getUser_id(), lf.getUser_sn());
    
    if (uai == null)
    {
      this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "error.user.usersn"));
      saveErrors(request, this.errors);
      return mapping.findForward("tofillsn");
    }
    

    return mapping.findForward("toupdpwd");
  }
  



  public ActionForward updPwd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    System.out.println("test");
    LogonForm lf = (LogonForm)form;
    
    if (!this.messages.isEmpty()) {
      this.messages.clear();
    }
    if (!this.errors.isEmpty()) {
      this.errors.clear();
    }
    
    UserInfoDaoImpl uidi = new UserInfoDaoImpl();
    

    if (lf.getPassword().length() < 6)
    {
      this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "error.user.pwdlength"));
      saveErrors(request, this.errors);
      return mapping.findForward("toupdpwd");
    }
    
    if (!lf.getPassword().equals(lf.getPwd()))
    {
      this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "error.password.confirm"));
      saveErrors(request, this.errors);
      return mapping.findForward("toupdpwd");
    }
    

    int result = uidi.updatePassword(MD5Helper.encode(lf.getPassword()), lf.getUser_id());
    
    if (result <= 0)
    {
      this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
        "error.user.upd"));
      saveErrors(request, this.errors);
      return mapping.findForward("toupdpwd");
    }
    

    return mapping.findForward("tofinish");
  }
  


  public ActionForward sendMail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws MalformedURLException, UnsupportedEncodingException
  {
    LogonForm lf = (LogonForm)form;
    
    if (!this.messages.isEmpty()) {
      this.messages.clear();
    }
    if (!this.errors.isEmpty()) {
      this.errors.clear();
    }
    
    UserInfoDaoImpl uidi = new UserInfoDaoImpl();
    System.out.println("uidi:" + lf.getUsername());
    UserAccountInfo uai = uidi.findByName(lf.getUsername());
    System.out.println("uai.getuser_email:" + uai.getUser_email());
    System.out.println("lf.getuser_email:" + lf.getUser_email());
    

    if (uai.getUser_email().equals(lf.getUser_email()))
    {

      long user_sn = Math.round(Math.random() * 100000.0D);
      uidi.updateUserSn(user_sn, uai.getUser_id());
      


      String url = Environment.getDomainName() + "/user/tomail.jsp?user_sn=" + user_sn + "&user_id=" + uai.getUser_id();
      System.out.println("user_sn:" + user_sn);
      System.out.println("user_id:" + uai.getUser_id());
      MailVO mailvo = new MailVO();
      mailvo.setTo(uai.getUser_email());
      mailvo.setSubject("修改密码");
      mailvo.setUrl(url);
      Mail.sendMail(mailvo);
      
      System.out.println("finish");
      return mapping.findForward("finish");
    }
    
    this.errors.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage(
      "error.user.mail"));
    saveErrors(request, this.errors);
    
    return mapping.findForward("toemail");
  }
}
