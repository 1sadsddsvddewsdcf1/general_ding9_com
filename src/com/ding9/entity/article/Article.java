package com.ding9.entity.article;


public class Article
{
  private int articleId;
  
  private String title;
  private int memtId;
  private String sourceType;
  private String releaseTime;
  private String url;
  private String source;
  private String author;
  private String sourceRelationType;
  private String sourceRelationValue;
  private String content;
  private int display;
  private String memtName;
  private int id;
  private String relation_type;
  private String relationType;
  private String prmaName;
  private String sortName;
  private int relationValue;
  private int prsoIdOne;
  private String prsoNameOneEn;
  private String picture;
  private String pagination_sign;
  private int total_page;
  private String content_curr_page;
  
  public int getArticleId()
  {
    return this.articleId;
  }
  
  public String getRelation_type() { return this.relation_type; }
  
  public int getRelationValue() {
    return this.relationValue;
  }
  
  public void setRelationValue(int relationValue) { this.relationValue = relationValue; }
  
  public void setRelation_type(String relation_type) {
    this.relation_type = relation_type;
  }
  
  public void setArticleId(int articleId) { this.articleId = articleId; }
  
  public int getId() {
    return this.id;
  }
  
  public String getContent() { return this.content; }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public int getDisplay() { return this.display; }
  
  public void setDisplay(int display) {
    this.display = display;
  }
  
  public void setId(int id) { this.id = id; }
  
  public String getMemtName() {
    return this.memtName;
  }
  
  public void setMemtName(String memtName) { this.memtName = memtName; }
  
  public String getPrmaName() {
    return this.prmaName;
  }
  
  public void setPrmaName(String prmaName) { this.prmaName = prmaName; }
  
  public String getRelationType() {
    return this.relationType;
  }
  
  public void setRelationType(String relationType) { this.relationType = relationType; }
  
  public String getSortName() {
    return this.sortName;
  }
  
  public void setSortName(String sortName) { this.sortName = sortName; }
  
  public String getAuthor() {
    return this.author;
  }
  
  public void setAuthor(String author) { this.author = author; }
  
  public int getMemtId()
  {
    return this.memtId;
  }
  
  public void setMemtId(int memtId) { this.memtId = memtId; }
  
  public String getReleaseTime() {
    return this.releaseTime;
  }
  
  public void setReleaseTime(String releaseTime) { this.releaseTime = releaseTime; }
  
  public String getSource() {
    return this.source;
  }
  
  public void setSource(String source) { this.source = source; }
  
  public String getSourceRelationType() {
    return this.sourceRelationType;
  }
  
  public void setSourceRelationType(String sourceRelationType) { this.sourceRelationType = sourceRelationType; }
  
  public String getSourceRelationValue() {
    return this.sourceRelationValue;
  }
  
  public void setSourceRelationValue(String sourceRelationValue) { this.sourceRelationValue = sourceRelationValue; }
  
  public String getSourceType() {
    return this.sourceType;
  }
  
  public void setSourceType(String sourceType) { this.sourceType = sourceType; }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) { this.title = title; }
  
  public String getUrl() {
    if (this.url == null) {
      this.url = "";
    }
    return this.url;
  }
  
  public void setUrl(String url) { this.url = url; }
  
  public int getPrsoIdOne() {
    return this.prsoIdOne;
  }
  
  public void setPrsoIdOne(int prsoIdOne) { this.prsoIdOne = prsoIdOne; }
  
  public String getPrsoNameOneEn() {
    return this.prsoNameOneEn;
  }
  
  public void setPrsoNameOneEn(String prsoNameOneEn) { this.prsoNameOneEn = prsoNameOneEn; }
  
  public String getPicture()
  {
    return this.picture;
  }
  
  public void setPicture(String picture) { this.picture = picture; }
  
  public String getPagination_sign() {
    return this.pagination_sign;
  }
  
  public void setPagination_sign(String pagination_sign) { this.pagination_sign = pagination_sign; }
  
  public int getTotal_page() {
    return this.total_page;
  }
  
  public void setTotal_page(int total_page) { this.total_page = total_page; }
  
  public String getContent_curr_page() {
    return this.content_curr_page;
  }
  
  public void setContent_curr_page(String content_curr_page) { this.content_curr_page = content_curr_page; }
}
