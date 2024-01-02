package com.ding9.entity.indexkey;


public class IndexKey
{
  private int auto_id;
  
  private int prso_id_one;
  
  private String keyWord;
  private String text;
  private String link;
  
  public int getAuto_id()
  {
    return this.auto_id;
  }
  
  public void setAuto_id(int auto_id) { this.auto_id = auto_id; }
  
  public String getKeyWord() {
    return this.keyWord;
  }
  
  public void setKeyWord(String keyWord) { this.keyWord = keyWord; }
  
  public String getLink() {
    return this.link;
  }
  
  public void setLink(String link) { this.link = link; }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) { this.prso_id_one = prso_id_one; }
  
  public String getText() {
    return this.text;
  }
  
  public void setText(String text) { this.text = text; }
}
