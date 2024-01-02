package com.ding9.entity.regiontype;

import java.util.List;

public class RegionType { private int type_id;
  private int city_id;
  private int type_id_one;
  private int type_id_two;
  private int type_id_three;
  
  public int getCity_id() { return this.city_id; }
  
  private String type_name_one;
  
  public List getScshop() { return this.scshop; }
  
  private String type_name_two;
  
  public void setScshop(List scshop) { this.scshop = scshop; }
  
  private String type_two_pic;
  
  public void setCity_id(int city_id) { this.city_id = city_id; }
  
  private String type_two_address;
  private List scshop;
  public int getType_id() { return this.type_id; }
  
  public void setType_id(int type_id)
  {
    this.type_id = type_id;
  }
  
  public int getType_id_one() {
    return this.type_id_one;
  }
  
  public void setType_id_one(int type_id_one) {
    this.type_id_one = type_id_one;
  }
  
  public int getType_id_three() {
    return this.type_id_three;
  }
  
  public void setType_id_three(int type_id_three) {
    this.type_id_three = type_id_three;
  }
  
  public int getType_id_two() {
    return this.type_id_two;
  }
  
  public void setType_id_two(int type_id_two) {
    this.type_id_two = type_id_two;
  }
  
  public String getType_name_one() {
    return this.type_name_one;
  }
  
  public void setType_name_one(String type_name_one) {
    this.type_name_one = type_name_one;
  }
  
  public String getType_name_two() {
    return this.type_name_two;
  }
  
  public void setType_name_two(String type_name_two) {
    this.type_name_two = type_name_two;
  }
  
  public String getType_two_address() {
    return this.type_two_address;
  }
  
  public void setType_two_address(String type_two_address) {
    this.type_two_address = type_two_address;
  }
  
  public String getType_two_pic() {
    return this.type_two_pic;
  }
  
  public void setType_two_pic(String type_two_pic) {
    this.type_two_pic = type_two_pic;
  }
}
