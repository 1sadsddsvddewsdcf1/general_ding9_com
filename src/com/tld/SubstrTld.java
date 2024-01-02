package com.tld;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SubstrTld
  extends TagSupport
{
  private final Log log = LogFactory.getLog(getClass().getName());
  private String title;
  private int len;
  private PageContext pageContext = null;
  
  public void setPageContext(PageContext pageContext) {
    this.pageContext = pageContext;
  }
  
  public int doEndTag() throws JspException {
    HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
    JspWriter out = this.pageContext.getOut();
    try
    {
      out.println(SubString(this.title, this.len));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return super.doEndTag();
  }
  
  public int getLen() {
    return this.len;
  }
  
  public void setLen(int len) {
    this.len = len;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String SubString(String str, int len) {
    StringBuffer result = new StringBuffer();
    int counter = 0;
    
    str = str == null ? "" : str.trim();
    
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) < 'Ā') {
        counter++;
      } else {
        counter += 2;
      }
      if (counter <= len * 2) {
        result.append(String.valueOf(str.charAt(i)));
      }
    }
    this.log.info("title : " + this.title);
    this.log.info("title.length(): " + this.title.length());
    this.log.info("len: " + len);
    if ((this.title != null) && (this.title.length() > len)) {
      result.append("...");
    }
    return result.toString();
  }
}
