package com.ding9.util.mail;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;




public class Mail
{
  public static String transferChinese(String strText)
  {
    try
    {
      strText = MimeUtility.encodeText(new String(strText.getBytes(), 
        "UTF-8"), "UTF-8", "B");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return strText;
  }
  
  public static boolean sendMail(MailVO vo)
    throws MalformedURLException, UnsupportedEncodingException
  {
    Properties props = System.getProperties();
    props.put("mail.smtp.host", "mail.ding9.com");
    Session session = Session.getDefaultInstance(props, null);
    
    try
    {
      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress("contact@ding9.com", "顶九网", "UTF-8"));
      
      InternetAddress[] address = { new InternetAddress(vo.getTo()) };
      msg.setRecipients(Message.RecipientType.TO, address);
      

      msg.setSubject(vo.getSubject(), "UTF-8");
      

      Multipart mp = new MimeMultipart();
      

















      URL url = new URL(vo.getUrl());
      msg.setDataHandler(new DataHandler(url));
      

      Enumeration efile = vo.getFile().elements();
      while (efile.hasMoreElements())
      {
        MimeBodyPart mbpFile = new MimeBodyPart();
        
        vo.setFilename(efile.nextElement().toString());
        FileDataSource fds = new FileDataSource(vo.getFilename());
        mbpFile.setDataHandler(new DataHandler(fds));
        mbpFile.setFileName(fds.getName());
        
        mp.addBodyPart(mbpFile);
      }
      
      vo.getFile().removeAllElements();
      msg.setSentDate(new Date());
      


      Transport.send(msg);
    }
    catch (MessagingException mex) {
      mex.printStackTrace();
      Exception ex = null;
      if ((ex = mex.getNextException()) != null) {
        ex.printStackTrace();
      }
      return false;
    }
    return true;
  }
}
