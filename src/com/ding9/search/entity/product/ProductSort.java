package com.ding9.search.entity.product;

import com.ding9.search.util.StringHelper;




public class ProductSort
{
  private int prso_id;
  private int prso_id_one;
  private int prso_id_two;
  private int prso_id_three;
  private String prso_name_one = "";
  
  private String prso_name_two = "";
  
  private String prso_name_three = "";
  
  private String prso_parameter = "";
  
  public boolean isSortOne() {
    return this.prso_id == this.prso_id_one;
  }
  
  public boolean isSortTwo() {
    return this.prso_id == this.prso_id_two;
  }
  
  public boolean isSortThree() {
    return this.prso_id == this.prso_id_three;
  }
  
  public String getSortName() {
    if (isSortOne())
      return this.prso_name_one;
    if (isSortTwo()) {
      return this.prso_name_two;
    }
    return this.prso_name_three;
  }
  
  public int getPrso_id()
  {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) {
    this.prso_id = prso_id;
  }
  
  public int getPrso_id_one() {
    return this.prso_id_one;
  }
  
  public void setPrso_id_one(int prso_id_one) {
    this.prso_id_one = prso_id_one;
  }
  
  public int getPrso_id_three() {
    return this.prso_id_three;
  }
  
  public void setPrso_id_three(int prso_id_three) {
    this.prso_id_three = prso_id_three;
  }
  
  public int getPrso_id_two() {
    return this.prso_id_two;
  }
  
  public void setPrso_id_two(int prso_id_two) {
    this.prso_id_two = prso_id_two;
  }
  
  public String getPrso_name_one() {
    return this.prso_name_one;
  }
  
  public void setPrso_name_one(String prso_name_one) {
    this.prso_name_one = StringHelper.getRealString(prso_name_one);
  }
  
  public String getPrso_name_three() {
    return this.prso_name_three;
  }
  
  public void setPrso_name_three(String prso_name_three) {
    this.prso_name_three = StringHelper.getRealString(prso_name_three);
  }
  
  public String getPrso_name_two() {
    return this.prso_name_two;
  }
  
  public void setPrso_name_two(String prso_name_two) {
    this.prso_name_two = StringHelper.getRealString(prso_name_two);
  }
  
  public String getPrso_parameter() {
    return this.prso_parameter;
  }
  
  public void setPrso_parameter(String prso_parameter) {
    this.prso_parameter = StringHelper.getRealString(prso_parameter);
  }
}
