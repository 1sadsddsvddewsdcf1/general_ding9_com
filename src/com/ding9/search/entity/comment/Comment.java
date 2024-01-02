package com.ding9.search.entity.comment;

import com.ding9.search.util.StringHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;












public class Comment
{
  private int recount;
  private List restore;
  private int comment_id;
  private Date release_time;
  private String source = "";
  

  private String content = "";
  

  private int prma_id;
  

  private String comment_type = "";
  

  private int product_level;
  

  private String advantage = "";
  

  private String disadvantage = "";
  

  private String source_url = "";
  

  private String title = "";
  

  private int author_id;
  

  private String author_name = "";
  

  private int homepage;
  

  private int userful_count;
  
  private String prma_name = "";
  

  private int prso_id;
  

  private String prso_name = "";
  


  private int prso_id_one;
  

  private String prso_name_one = "";
  

  private int prso_id_two;
  

  private String prso_name_two = "";
  

  private String pic_address = "";
  

  private String small_pic_address = "";
  

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
    "yyyy-MM-dd");
  
  public Comment() {}
  
  public Comment(int comment_id, String title, String content)
  {
    setComment_id(comment_id);
    setTitle(title);
    setContent(content);
  }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public Date getRelease_time() {
    return this.release_time;
  }
  
  public void setRelease_time(Date release_time) {
    this.release_time = release_time;
  }
  
  public String getAdvantage() {
    return this.advantage;
  }
  
  public void setAdvantage(String advantage) {
    this.advantage = StringHelper.getRealString(advantage);
  }
  
  public String getDisadvantage() {
    return this.disadvantage;
  }
  
  public void setDisadvantage(String disadvantage) {
    this.disadvantage = StringHelper.getRealString(disadvantage);
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = StringHelper.getRealString(content);
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = StringHelper.getRealString(title);
  }
  
  public String getFormatTime() {
    String result = "";
    if (this.release_time != null) {
      try {
        result = dateFormat.format(this.release_time);
      }
      catch (Exception localException) {}
    }
    
    return result;
  }
  
  public int getAuthor_id() {
    return this.author_id;
  }
  
  public void setAuthor_id(int author_id) {
    this.author_id = author_id;
  }
  
  public String getAuthor_name() {
    return this.author_name;
  }
  
  public void setAuthor_name(String author_name) {
    this.author_name = StringHelper.getRealString(author_name);
  }
  
  public int getComment_id() {
    return this.comment_id;
  }
  
  public void setComment_id(int comment_id) {
    this.comment_id = comment_id;
  }
  
  public String getComment_type() {
    return this.comment_type;
  }
  
  public void setComment_type(String comment_type) {
    this.comment_type = StringHelper.getRealString(comment_type);
  }
  
  public int getHomepage() {
    return this.homepage;
  }
  
  public void setHomepage(int homepage) {
    this.homepage = homepage;
  }
  
  public String getPic_address() {
    return this.pic_address;
  }
  
  public void setPic_address(String pic_address) {
    this.pic_address = StringHelper.getRealString(pic_address);
  }
  
  public String getPrma_name() {
    return this.prma_name;
  }
  
  public void setPrma_name(String prma_name) {
    this.prma_name = StringHelper.getRealString(prma_name);
  }
  
  public int getProduct_level() {
    return this.product_level;
  }
  
  public void setProduct_level(int product_level) {
    this.product_level = product_level;
  }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) {
    this.prso_id = prso_id;
  }
  
  public int getPrso_id_two() {
    return this.prso_id_two;
  }
  
  public void setPrso_id_two(int prso_id_two) {
    this.prso_id_two = prso_id_two;
  }
  
  public String getPrso_name() {
    return this.prso_name;
  }
  
  public void setPrso_name(String prso_name) {
    this.prso_name = StringHelper.getRealString(prso_name);
  }
  
  public String getPrso_name_one() {
    return this.prso_name_one;
  }
  
  public void setPrso_name_one(String prso_name_one) {
    this.prso_name_one = StringHelper.getRealString(prso_name_one);
  }
  
  public String getPrso_name_two() {
    return this.prso_name_two;
  }
  
  public void setPrso_name_two(String prso_name_two) {
    this.prso_name_two = StringHelper.getRealString(prso_name_two);
  }
  
  public String getSmall_pic_address() {
    return this.small_pic_address;
  }
  
  public void setSmall_pic_address(String small_pic_address) {
    this.small_pic_address = StringHelper.getRealString(small_pic_address);
  }
  
  public String getSource() {
    return this.source;
  }
  
  public void setSource(String source) {
    this.source = StringHelper.getRealString(source);
  }
  
  public String getSource_url() {
    return this.source_url;
  }
  
  public void setSource_url(String source_url) {
    this.source_url = StringHelper.getRealString(source_url);
  }
  
  public List getRestore() {
    return this.restore;
  }
  
  public void setRestore(List restore) {
    this.restore = restore;
  }
  
  public int getRecount() {
    return this.recount;
  }
  
  public void setRecount(int recount) {
    this.recount = recount;
  }
  
  public int getUserful_count() {
    return this.userful_count;
  }
  
  public void setUserful_count(int userful_count) {
    this.userful_count = userful_count;
  }
}
