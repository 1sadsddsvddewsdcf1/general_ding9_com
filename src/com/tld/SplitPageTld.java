package com.tld;

import com.ding9.util.UrlRewriteManager;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class SplitPageTld
  extends TagSupport
{
  private int current_page;
  private int count_page;
  private String url;
  private PageContext pageContext = null;
  
  public void setPageContext(PageContext pageContext) {
    this.pageContext = pageContext;
  }
  
  public int doEndTag() throws JspException {
    HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
    JspWriter out = this.pageContext.getOut();
    try
    {
      out.println(SplitPage(this.current_page, this.count_page, this.url));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return super.doEndTag();
  }
  
  public String SplitPage(int current_page, int count_page, String url) {
    if (current_page > count_page) {
      current_page = count_page;
    }
    String number_page = "";
    String number_page_one = "";
    String number_page_two = "";
    String number_page_three = "";
    
    int last = 0;
    int count_one = 0;
    int count_two = 0;
    int count_three = 0;
    
    int end_one = 0;
    int start_two = 0;
    
    for (int i = 1; i <= 2; i++) {
      if (i < count_page - 1) {
        count_one++;
        last = i;
        end_one = i;
        if (i == current_page) {
          number_page_one = number_page_one + "<font color='red'>" + i + "</font> ";
        } else {
          number_page_one = number_page_one + "<a href='" + UrlRewriteManager.dynamic2static(new StringBuilder(String.valueOf(url)).append(i).toString()) + "'><span class='H5'>" + i + "</span></a> ";
        }
      }
    }
    for (int i = current_page - 2; i <= current_page + 2; i++) {
      if ((i <= count_page) && 
        (i > 0) && (i > last)) {
        if (start_two == 0)
          start_two = i;
        count_two++;
        last = i;
        if (i == current_page) {
          number_page_two = number_page_two + "<font color='red'>" + i + "</font> ";
        } else {
          number_page_two = number_page_two + "<a href='" + UrlRewriteManager.dynamic2static(new StringBuilder(String.valueOf(url)).append(i).toString()) + "'><span class='H5'>" + i + "</span></a> ";
        }
      }
    }
    
    for (int i = count_page - 1; i <= count_page; i++) {
      if ((i > 0) && (i > last)) {
        count_three++;
        if (i != current_page) {
          number_page_three = number_page_three + "<a href='" + UrlRewriteManager.dynamic2static(new StringBuilder(String.valueOf(url)).append(i).toString()) + "'><span class='H5'>" + i + "</span></a> ";
        } else {
          number_page_three = number_page_three + "<font color='red'>" + i + "</font> ";
        }
      }
    }
    if (!number_page_one.equals(""))
      number_page = number_page + number_page_one;
    if (!number_page_two.equals("")) {
      if (number_page.equals("")) {
        number_page = number_page + number_page_two;
      }
      else if (count_two < 5) {
        if (count_three == 0) {
          if (start_two - end_one == 1) {
            number_page = number_page + number_page_two;
          } else {
            number_page = number_page + "... " + number_page_two;
          }
        } else {
          number_page = number_page + number_page_two;
        }
      } else {
        number_page = number_page + "... " + number_page_two;
      }
    }
    if (!number_page_three.equals("")) {
      if (number_page.equals("")) {
        number_page = number_page_three;
      }
      else if (count_three < 2) {
        number_page = number_page + number_page_three;
      } else {
        number_page = number_page + "... " + number_page_three;
      }
    }
    

    if (count_page == 1) {
      number_page = "";
    }
    String pre_page = "";
    String next_page = "";
    if (current_page > 0) {
      if (current_page != 1) {
        pre_page = "[ <a href='" + UrlRewriteManager.dynamic2static(new StringBuilder(String.valueOf(url)).append(current_page - 1).toString()) + "'><span class='H1'>上一页</span></a> ]";
        number_page = pre_page + "&nbsp;&nbsp;" + number_page;
      }
      if (current_page != count_page) {
        next_page = "[ <a href='" + UrlRewriteManager.dynamic2static(new StringBuilder(String.valueOf(url)).append(current_page + 1).toString()) + "'><span class='H1'>下一页</span></a> ]";
        number_page = number_page + "&nbsp;&nbsp;" + next_page;
      }
    }
    if (!number_page.equals("")) {
      number_page = "<span class='H1'>" + number_page + "</span>";
    }
    
    StringBuffer skip_page = new StringBuffer();
    if (count_page > 1) {
      skip_page.append("&nbsp;&nbsp;&nbsp;&nbsp;");
      skip_page.append("<span class='H1'>跳到</span>");
      if (current_page > 0) {
        skip_page.append("<input name='current_page' type='text' class='H7' size='3' onKeyPress=\"Javascript:if(window.event.keyCode==13){var current_page=this.value;document.location.href='" + url + "'+current_page;return false;}\" value='" + current_page + "'/>");
      } else {
        skip_page.append("<input name='current_page' type='text' class='H7' size='3' onKeyPress=\"Javascript:if(window.event.keyCode==13){var current_page=this.value;document.location.href='" + url + "'+current_page;return false;}\" value=''/>");
      }
      skip_page.append("<span class='H1'>页</span>");
      skip_page.append("<input class='form' style='HEIGHT: 19px' type='button' value='Go' name='go' onClick=\"Javascript:var current_page=document.all.current_page.value;document.location.href='" + url + "'+current_page;\" />");
      number_page = number_page + skip_page;
    }
    

    return number_page;
  }
  
  public int getCount_page() {
    return this.count_page;
  }
  
  public void setCount_page(int count_page) {
    this.count_page = count_page;
  }
  
  public int getCurrent_page() {
    return this.current_page;
  }
  
  public void setCurrent_page(int current_page) {
    this.current_page = current_page;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
}
