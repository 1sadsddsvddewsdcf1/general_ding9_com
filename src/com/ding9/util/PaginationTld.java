package com.ding9.util;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;


public class PaginationTld
  extends TagSupport
{
  private static final long serialVersionUID = -408620748834056498L;
  private int currentPage = 1;
  private int pageCount;
  private String url;
  private PageContext pageContext = null;
  
  public void setPageContext(PageContext pageContext) {
    this.pageContext = pageContext;
  }
  
  public int doEndTag() throws JspException
  {
    JspWriter out = this.pageContext.getOut();
    HttpServletResponse response = (HttpServletResponse)this.pageContext.getResponse();
    try {
      out.print(SplitPage(this.currentPage, this.pageCount, this.url, response));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return super.doEndTag();
  }
  


  public String SplitPage(int currentPage, int pageCount, String url, HttpServletResponse response)
  {
    if (currentPage > pageCount) {
      currentPage = pageCount;
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
      if (i < pageCount - 1) {
        count_one++;
        last = i;
        end_one = i;
        if (i == currentPage) {
          number_page_one = number_page_one + "<font color='red'>" + i + "</font> ";
        } else {
          number_page_one = number_page_one + "<a href='" + response.encodeURL(new StringBuilder(String.valueOf(url)).append(i).toString()) + "'><span class='H5'>" + i + "</span></a> ";
        }
      }
    }
    for (int i = currentPage - 2; i <= currentPage + 2; i++) {
      if ((i <= pageCount) && 
        (i > 0) && (i > last)) {
        if (start_two == 0)
          start_two = i;
        count_two++;
        last = i;
        if (i == currentPage) {
          number_page_two = number_page_two + "<font color='red'>" + i + "</font> ";
        } else {
          number_page_two = number_page_two + "<a href='" + response.encodeURL(new StringBuilder(String.valueOf(url)).append(i).toString()) + "'><span class='H5'>" + i + "</span></a> ";
        }
      }
    }
    
    for (int i = pageCount - 1; i <= pageCount; i++) {
      if ((i > 0) && (i > last)) {
        count_three++;
        if (i != currentPage) {
          number_page_three = number_page_three + "<a href='" + response.encodeURL(new StringBuilder(String.valueOf(url)).append(i).toString()) + "'><span class='H5'>" + i + "</span></a> ";
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
    
    if (pageCount == 1) {
      number_page = "";
    }
    String pre_page = "";
    String next_page = "";
    if (currentPage > 0) {
      if (currentPage != 1) {
        pre_page = "[ <a href='" + response.encodeURL(new StringBuilder(String.valueOf(url)).append(currentPage - 1).toString()) + "'><span class='H1'>上一页</span></a> ]";
        number_page = pre_page + "&nbsp;&nbsp;" + number_page;
      }
      if (currentPage != pageCount) {
        next_page = "[ <a href='" + response.encodeURL(new StringBuilder(String.valueOf(url)).append(currentPage + 1).toString()) + "'><span class='H1'>下一页</span></a> ]";
        number_page = number_page + "&nbsp;&nbsp;" + next_page;
      }
    }
    if (!number_page.equals("")) {
      number_page = "<span class='H1'>" + number_page + "</span>";
    }
    
    StringBuffer skip_page = new StringBuffer();
    if (pageCount > 1) {
      skip_page.append("&nbsp;&nbsp;&nbsp;&nbsp;");
      skip_page.append("<span class='H1'>跳到</span>");
      if (currentPage > 0) {
        skip_page.append("<input name='currentPage' type='text' class='H7' size='3' onKeyPress=\"Javascript:if(window.event.keyCode==13){var currentPage=this.value;document.location.href='" + response.encodeURL(url) + "'+currentPage+'/';return false;}\" value='" + currentPage + "'/>");
      } else {
        skip_page.append("<input name='currentPage' type='text' class='H7' size='3' onKeyPress=\"Javascript:if(window.event.keyCode==13){var currentPage=this.value;document.location.href='" + response.encodeURL(url) + "'+currentPage+'/';return false;}\" value=''/>");
      }
      skip_page.append("<span class='H1'>页</span>");
      skip_page.append("<input class='form' style='HEIGHT: 19px' type='button' value='Go' name='go' onClick=\"Javascript:var currentPage=document.all.current_page.value;document.location.href='" + response.encodeURL(url) + "'+currentPage+'/';\"/>");
      number_page = number_page + skip_page;
    }
    
    return number_page;
  }
  
  public int getPageCount() {
    return this.pageCount;
  }
  
  public void setPageCount(int page) {
    this.pageCount = page;
  }
  
  public int getCurrentpage() {
    return this.currentPage;
  }
  
  public void setCurrentpage(int page) {
    this.currentPage = page;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
}
