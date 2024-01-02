package com.ding9.search.entity.assistant;

import com.ding9.search.util.StringHelper;



public class Counter
{
  private String value = "";
  



  private int count;
  



  private String extend_value_one = "";
  



  private String extend_value_two = "";
  



  private String extend_value_three = "";
  



  private String extend_value_four = "";
  



  public int getCount()
  {
    return this.count;
  }
  



  public void setCount(int count)
  {
    this.count = count;
  }
  



  public String getExtend_value_four()
  {
    return this.extend_value_four;
  }
  



  public void setExtend_value_four(String extend_value_four)
  {
    this.extend_value_four = StringHelper.getRealString(extend_value_four);
  }
  



  public String getExtend_value_one()
  {
    return this.extend_value_one;
  }
  



  public void setExtend_value_one(String extend_value_one)
  {
    this.extend_value_one = StringHelper.getRealString(extend_value_one);
  }
  



  public String getExtend_value_three()
  {
    return this.extend_value_three;
  }
  



  public void setExtend_value_three(String extend_value_three)
  {
    this.extend_value_three = StringHelper.getRealString(extend_value_three);
  }
  



  public String getExtend_value_two()
  {
    return this.extend_value_two;
  }
  



  public void setExtend_value_two(String extend_value_two)
  {
    this.extend_value_two = StringHelper.getRealString(extend_value_two);
  }
  



  public String getValue()
  {
    return this.value;
  }
  



  public void setValue(String value)
  {
    this.value = StringHelper.getRealString(value);
  }
}
