package com.ding9.multipleentity;

public class MulProductInfo {
  private String prma_id;
  private int prso_id_one;
  private String prma_name;
  private float price;
  private int merccount;
  private String remark;
  private String prbr_name;
  private int comment;
  private String img;
  private String url;
  private float merc_price;
  private String prma_url;
  private String click_url;
  private String time;
  
  public String getPrma_url() { return this.prma_url; }
  
  public void setPrma_url(String prma_url) {
    this.prma_url = prma_url;
  }
  
  public int getComment() { return this.comment; }
  
  public void setComment(int comment) {
    this.comment = comment;
  }
  
  public String getImg() { return this.img; }
  
  public void setImg(String img) {
    this.img = img;
  }
  
  public int getMerccount() { return this.merccount; }
  
  public void setMerccount(int merccount) {
    this.merccount = merccount;
  }
  
  public float getPrice() { return this.price; }
  
  public void setPrice(float price) {
    this.price = price;
  }
  
  public String getPrma_name() { return this.prma_name; }
  
  public void setPrma_name(String prma_name) {
    this.prma_name = prma_name;
  }
  
  public String getRemark() { return this.remark; }
  
  public void setRemark(String remark) {
    this.remark = remark;
  }
  
  public String getPrbr_name() { return this.prbr_name; }
  
  public void setPrbr_name(String prbr_name) {
    this.prbr_name = prbr_name;
  }
  
  public String getPrma_id() { return this.prma_id; }
  
  public void setPrma_id(String prma_id) {
    this.prma_id = prma_id;
  }
  
  public int getPrso_id_one() { return this.prso_id_one; }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public float getMerc_price() { return this.merc_price; }
  
  public void setMerc_price(float merc_price) {
    this.merc_price = merc_price;
  }
  
  public String getUrl() { return this.url; }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public String getClick_url() { return this.click_url; }
  
  public void setClick_url(String click_url) {
    this.click_url = click_url;
  }
  
  public String getTime() { return this.time; }
  
  public void setTime(String time) {
    this.time = time;
  }
}
