package com.ding9.entity.category;

public class PrsoSort
{
  private int id;
  private String name;
  private int parentId;
  private String parentName;
  
  public int getParentId()
  {
    return this.parentId;
  }
  
  public void setParentId(int parentId) { this.parentId = parentId; }
  
  public String getParentName() {
    return this.parentName;
  }
  
  public void setParentName(String parentName) { this.parentName = parentName; }
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) { this.id = id; }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) { this.name = name; }
}
