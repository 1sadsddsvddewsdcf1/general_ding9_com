package com.ding9.multipleentity;

public class AdPlaceAdvertisement {
  private int adad_id;
  private int ad_type;
  private int adpl_id;
  private String adad_address;
  private String adad_pic;
  private String adpl_size;
  private String adad_name;
  private int adpl_type;
  private String adad_word;
  private int channelId;
  
  public String getAdad_word() { return this.adad_word; }
  
  public void setAdad_word(String adad_word) {
    this.adad_word = adad_word;
  }
  
  public int getAdpl_type() { return this.adpl_type; }
  
  public int getChannelId()
  {
    return this.channelId;
  }
  
  public void setChannelId(int channelId) { this.channelId = channelId; }
  
  public void setAdpl_type(int adpl_type) {
    this.adpl_type = adpl_type;
  }
  
  public String getAdad_name() { return this.adad_name; }
  
  public void setAdad_name(String adad_name) {
    this.adad_name = adad_name;
  }
  
  public int getAd_type() { return this.ad_type; }
  
  public void setAd_type(int ad_type) {
    this.ad_type = ad_type;
  }
  
  public String getAdad_address() { return this.adad_address; }
  
  public void setAdad_address(String adad_address) {
    this.adad_address = adad_address;
  }
  
  public String getAdad_pic() { return this.adad_pic; }
  
  public void setAdad_pic(String adad_pic) {
    this.adad_pic = adad_pic;
  }
  
  public String getAdpl_size() { return this.adpl_size; }
  
  public void setAdpl_size(String adpl_size) {
    this.adpl_size = adpl_size;
  }
  
  public int getAdpl_id() { return this.adpl_id; }
  
  public void setAdpl_id(int adpl_id) {
    this.adpl_id = adpl_id;
  }
  
  public int getAdad_id() { return this.adad_id; }
  
  public void setAdad_id(int adad_id) {
    this.adad_id = adad_id;
  }
}
