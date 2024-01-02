package com.ding9.action.register;

import com.ding9.dao.register.RegisterDao;
import com.ding9.dao.register.RegisterDaoImpl;
import com.ding9.entity.user.UserAccountInfo;
import com.ding9.service.user.UserService;
import com.ding9.util.Environment;
import com.ding9.util.MD5Helper;
import com.ding9.util.mail.Mail;
import com.ding9.util.mail.MailVO;
import com.ding9.util.validate.ValidateCode;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;



public class RegisterAction
  extends DispatchAction
{
  UserService userCheck = new UserService();
  
  RegisterDao registerDao = new RegisterDaoImpl();
  












  public ActionForward check(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    response.setContentType("text/xml; charset=GB2312");
    response.setHeader("Cache-Control", "no-cache");
    
    PrintWriter out = response.getWriter();
    
    String username = null;
    String email = null;
    String code = null;
    String new_email = null;
    String sn_code = null;
    

    if (request.getParameter("username") != null) {
      username = request.getParameter("username");
      int user = this.userCheck.checkName(username);
      out.println(user);
      out.close();
    }
    
    if (request.getParameter("email") != null) {
      email = request.getParameter("email");
      int e = this.userCheck.checkEmail(email);
      out.println(e);
      out.close();
    }
    
    if (request.getParameter("code") != null) {
      int c = 0;
      code = request.getParameter("code");
      boolean isVerified = false;
      isVerified = ValidateCode.verifyValidateCode(request, code);
      if (isVerified)
        c = 1;
      out.println(c);
      out.close();
    }
    

    if (request.getParameter("new_email") != null) {
      new_email = request.getParameter("new_email");
      String user = request.getParameter("name2");
      int e = this.userCheck.checkEmail(new_email, user);
      
      out.println(e);
    }
    

    if (request.getParameter("sn_code") != null) {
      int flag = 0;
      sn_code = request.getParameter("sn_code");
      String name = request.getParameter("name");
      List list = this.registerDao.checkActive(name, sn_code);
      
      if (list.size() > 0) {
        flag = 1;
      }
      out.println(flag);
    }
    

    return null;
  }
  











  public ActionForward register(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    response.setContentType("text/xml; charset=GB2312");
    response.setHeader("Cache-Control", "no-cache");
    
    PrintWriter out = response.getWriter();
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String sn = request.getParameter("sn");
    

    if ((username != null) && (password != null) && (email != null)) {
      int flag = 1;
      UserAccountInfo vo = new UserAccountInfo();
      
      String pwd = MD5Helper.encode(password);
      vo.setUser_name(username);
      vo.setUser_pass(pwd);
      vo.setUser_email(email);
      vo.setUser_sn(sn);
      flag = this.registerDao.addUser(vo);
      


      out.println("<pront>");
      out.println("<pwd>" + pwd + "</pwd>");
      out.println("<flag>" + flag + "</flag>");
      out.println("</pront>");
      out.close();
    }
    
    return null;
  }
  











  public ActionForward goemail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws MalformedURLException, UnsupportedEncodingException
  {
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String sn = request.getParameter("sn");
    UserAccountInfo vo = new UserAccountInfo();
    vo.setUser_name(username);
    vo.setUser_email(email);
    vo.setUser_sn(sn);
    request.setAttribute("vo", vo);
    
    String[] email_url = email.split("@");
    request.setAttribute("email_url", "http://mail." + email_url[1]);
    

    String tmp = "/email_info.jsp?username=" + username + "&email=" + email + "&sn=" + sn;
    

    String url = Environment.getDomainName() + "/register" + tmp;
    
    MailVO mailVO = new MailVO();
    
    boolean mail = false;
    mailVO.setTo(email);
    mailVO.setSubject("感谢您注册顶九网");
    mailVO.setUrl(url);
    mail = Mail.sendMail(mailVO);
    if (mail) {
      return mapping.findForward("register_email");
    }
    
    return null;
  }
  










  public ActionForward active(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    response.setContentType("text/xml; charset=GB2312");
    response.setHeader("Cache-Control", "no-cache");
    
    PrintWriter out = response.getWriter();
    String username = request.getParameter("username");
    
    int flag = 0;
    if ((!"".equals(username)) && (username != null)) {
      flag = this.registerDao.active(username);
    }
    out.println(flag);
    
    return null;
  }
  
  public ActionForward modEmail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    response.setContentType("text/xml; charset=GB2312");
    response.setHeader("Cache-Control", "no-cache");
    
    PrintWriter out = response.getWriter();
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    int sn = Integer.parseInt(request.getParameter("sn"));
    
    int flag = 0;
    flag = this.registerDao.modEmail(username, email, sn);
    
    out.println("<pront>");
    out.println("<flag>" + flag + "</flag>");
    out.println("</pront>");
    out.close();
    
    return null;
  }
}
