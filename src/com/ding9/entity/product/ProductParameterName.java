package com.ding9.entity.product;



public class ProductParameterName
{
  private String table_name;
  

  private String field_name;
  

  private String field_content;
  

  public String getField_content()
  {
    return this.field_content;
  }
  
  public void setField_content(String field_content) { this.field_content = field_content; }
  
  public String getField_name() {
    return this.field_name;
  }
  
  public void setField_name(String field_name) { this.field_name = field_name; }
  
  public String getTable_name() {
    return this.table_name;
  }
  
  public void setTable_name(String table_name) { this.table_name = table_name; }
}
