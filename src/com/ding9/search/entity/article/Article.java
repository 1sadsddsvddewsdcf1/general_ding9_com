package com.ding9.search.entity.article;

import com.ding9.search.util.StringHelper;
import java.util.Date;

























public class Article
{
  private int article_id;
  private String title = "";
  



  private int memt_id;
  



  private String source_type = "";
  



  private Date release_time;
  



  private String url = "";
  



  private String source = "";
  



  private String author = "";
  



  private String source_relation_type = "";
  



  private String source_relation_value = "";
  



  private String content = "";
  




  private int display;
  




  private String pagination_sign;
  




  private int cooperate_id;
  



  private String picture;
  



  private int sort_prso_id_one;
  



  private String sort_prso_name_one = "";
  



  private String sort_name;
  



  private int relation_type;
  



  private int relation_value;
  



  private int prma_id;
  



  private String prma_name = "";
  



  private int prso_id_one;
  



  private String prso_name_one = "";
  



  private int prso_id_two;
  



  private String prso_name_two = "";
  



  private int prso_id_three;
  



  private String prso_name_three = "";
  











  public int getDisplay()
  {
    return this.display;
  }
  






  public void setDisplay(int display)
  {
    this.display = display;
  }
  



  public int getArticle_id()
  {
    return this.article_id;
  }
  



  public void setArticle_id(int article_id)
  {
    this.article_id = article_id;
  }
  



  public String getAuthor()
  {
    return this.author;
  }
  



  public void setAuthor(String author)
  {
    this.author = StringHelper.getRealString(author);
  }
  



  public String getContent()
  {
    return this.content;
  }
  



  public void setContent(String content)
  {
    this.content = StringHelper.getRealString(content);
  }
  



  public int getCooperate_id()
  {
    return this.cooperate_id;
  }
  



  public void setCooperate_id(int cooperate_id)
  {
    this.cooperate_id = cooperate_id;
  }
  



  public int getMemt_id()
  {
    return this.memt_id;
  }
  



  public void setMemt_id(int memt_id)
  {
    this.memt_id = memt_id;
  }
  



  public String getPagination_sign()
  {
    return this.pagination_sign;
  }
  



  public void setPagination_sign(String pagination_sign)
  {
    this.pagination_sign = StringHelper.getRealString(pagination_sign);
  }
  



  public String getPicture()
  {
    return this.picture;
  }
  



  public void setPicture(String picture)
  {
    this.picture = StringHelper.getRealString(picture);
  }
  



  public int getPrma_id()
  {
    return this.prma_id;
  }
  



  public void setPrma_id(int prma_id)
  {
    this.prma_id = prma_id;
  }
  



  public String getPrma_name()
  {
    return this.prma_name;
  }
  



  public void setPrma_name(String prma_name)
  {
    this.prma_name = StringHelper.getRealString(prma_name);
  }
  



  public int getPrso_id_one()
  {
    return this.prso_id_one;
  }
  



  public void setPrso_id_one(int prso_id_one)
  {
    this.prso_id_one = prso_id_one;
  }
  



  public int getPrso_id_three()
  {
    return this.prso_id_three;
  }
  



  public void setPrso_id_three(int prso_id_three)
  {
    this.prso_id_three = prso_id_three;
  }
  



  public int getPrso_id_two()
  {
    return this.prso_id_two;
  }
  



  public void setPrso_id_two(int prso_id_two)
  {
    this.prso_id_two = prso_id_two;
  }
  



  public String getPrso_name_one()
  {
    return this.prso_name_one;
  }
  



  public void setPrso_name_one(String prso_name_one)
  {
    this.prso_name_one = StringHelper.getRealString(prso_name_one);
  }
  



  public String getPrso_name_three()
  {
    return this.prso_name_three;
  }
  



  public void setPrso_name_three(String prso_name_three)
  {
    this.prso_name_three = StringHelper.getRealString(prso_name_three);
  }
  



  public String getPrso_name_two()
  {
    return this.prso_name_two;
  }
  



  public void setPrso_name_two(String prso_name_two)
  {
    this.prso_name_two = StringHelper.getRealString(prso_name_two);
  }
  



  public int getRelation_type()
  {
    return this.relation_type;
  }
  



  public void setRelation_type(int relation_type)
  {
    this.relation_type = relation_type;
  }
  



  public int getRelation_value()
  {
    return this.relation_value;
  }
  



  public void setRelation_value(int relation_value)
  {
    this.relation_value = relation_value;
  }
  



  public Date getRelease_time()
  {
    return this.release_time;
  }
  



  public void setRelease_time(Date release_time)
  {
    this.release_time = release_time;
  }
  



  public String getSort_name()
  {
    return this.sort_name;
  }
  



  public void setSort_name(String sort_name)
  {
    this.sort_name = StringHelper.getRealString(sort_name);
  }
  



  public int getSort_prso_id_one()
  {
    return this.sort_prso_id_one;
  }
  



  public void setSort_prso_id_one(int sort_prso_id_one)
  {
    this.sort_prso_id_one = sort_prso_id_one;
  }
  



  public String getSort_prso_name_one()
  {
    return this.sort_prso_name_one;
  }
  



  public void setSort_prso_name_one(String sort_prso_name_one)
  {
    this.sort_prso_name_one = StringHelper.getRealString(sort_prso_name_one);
  }
  



  public String getSource()
  {
    return this.source;
  }
  



  public void setSource(String source)
  {
    this.source = StringHelper.getRealString(source);
  }
  



  public String getSource_relation_type()
  {
    return this.source_relation_type;
  }
  



  public void setSource_relation_type(String source_relation_type)
  {
    this.source_relation_type = StringHelper.getRealString(source_relation_type);
  }
  



  public String getSource_relation_value()
  {
    return this.source_relation_value;
  }
  



  public void setSource_relation_value(String source_relation_value)
  {
    this.source_relation_value = StringHelper.getRealString(source_relation_value);
  }
  



  public String getSource_type()
  {
    return this.source_type;
  }
  



  public void setSource_type(String source_type)
  {
    this.source_type = StringHelper.getRealString(source_type);
  }
  



  public String getTitle()
  {
    return this.title;
  }
  



  public void setTitle(String title)
  {
    this.title = StringHelper.getRealString(title);
  }
  



  public String getUrl()
  {
    return this.url;
  }
  



  public void setUrl(String url)
  {
    this.url = StringHelper.getRealString(url);
  }
}
