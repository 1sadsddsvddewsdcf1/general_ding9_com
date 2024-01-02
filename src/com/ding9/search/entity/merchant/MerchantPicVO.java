package com.ding9.search.entity.merchant;

import com.ding9.search.util.Character;
import java.util.Date;



public class MerchantPicVO
{
  private int id;
  private int sort_id;
  private String images_source;
  private String images_info;
  private String update_time = Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  
  public int getId() { return this.id; }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getImages_info() { return this.images_info; }
  
  public void setImages_info(String images_info) {
    this.images_info = images_info;
  }
  
  public String getImages_source() { return this.images_source; }
  
  public void setImages_source(String images_source) {
    this.images_source = images_source;
  }
  
  public int getSort_id() { return this.sort_id; }
  
  public void setSort_id(int sort_id) {
    this.sort_id = sort_id;
  }
  
  public String getUpdate_time() { return this.update_time; }
  
  public void setUpdate_time(String update_time) {
    this.update_time = update_time;
  }
}
