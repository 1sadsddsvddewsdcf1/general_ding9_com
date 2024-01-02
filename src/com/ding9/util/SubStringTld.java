package com.ding9.util;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class SubStringTld extends TagSupport
{
  private static final long serialVersionUID = 2849236673514548986L;
  private String title;
  private int length;
  private PageContext pageContext = null;
  
  public void setPageContext(PageContext pageContext) {
    this.pageContext = pageContext;
  }
  
  public int doEndTag() throws JspException {
    JspWriter out = this.pageContext.getOut();
    try
    {
      out.print(SubString(this.title, this.length));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return super.doEndTag();
  }
  
  public int getLength() {
    return this.length;
  }
  
  public void setLength(int len) {
    this.length = len;
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
    
    if ((this.title != null) && (this.title.length() > len)) {
      result.append("...");
    }
    return result.toString();
  }
}
