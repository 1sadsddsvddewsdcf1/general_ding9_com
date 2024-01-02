package com.ding9.entity.product;



public class ProductParameterValue
{
  private String field_name;
  
  private String field_value;
  
  private ProductParameterName parametername;
  

  public ProductParameterName getParametername()
  {
    return this.parametername;
  }
  
  public void setParametername(ProductParameterName parametername) { this.parametername = parametername; }
  
  public String getField_name() {
    return this.field_name;
  }
  
  public void setField_name(String field_name) { this.field_name = field_name; }
  
  public String getField_value() {
    return this.field_value;
  }
  
  public void setField_value(String field_value) { this.field_value = field_value; }
}
