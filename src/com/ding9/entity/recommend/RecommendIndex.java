package com.ding9.entity.recommend;

public class RecommendIndex {
  private String prma_name;
  private String url;
  private String pic;
  private float price;
  private int merchantcount;
  
  public int getMerchantcount() { return this.merchantcount; }
  
  public void setMerchantcount(int merchantcount) {
    this.merchantcount = merchantcount;
  }
  
  public String getPic() { return this.pic; }
  
  public void setPic(String pic) {
    this.pic = pic;
  }
  
  public float getPrice() { return this.price; }
  
  public void setPrice(float price) {
    this.price = price;
  }
  
  public String getPrma_name() { return this.prma_name; }
  
  public void setPrma_name(String prma_name) {
    this.prma_name = prma_name;
  }
  
  public String getUrl() { return this.url; }
  
  public void setUrl(String url) {
    this.url = url;
  }
}
