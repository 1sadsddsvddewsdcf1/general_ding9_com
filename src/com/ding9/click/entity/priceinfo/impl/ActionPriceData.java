package com.ding9.click.entity.priceinfo.impl;

import com.ding9.click.entity.priceinfo.IActionPriceData;















public class ActionPriceData
  implements IActionPriceData
{
  private int cooperate_id;
  private String cooperate_name;
  private int action_price;
  
  public int getAction_price()
  {
    return this.action_price;
  }
  



  public void setAction_price(int action_price)
  {
    this.action_price = action_price;
  }
  



  public int getCooperate_id()
  {
    return this.cooperate_id;
  }
  



  public void setCooperate_id(int cooperate_id)
  {
    this.cooperate_id = cooperate_id;
  }
  



  public String getCooperate_name()
  {
    return this.cooperate_name;
  }
  



  public void setCooperate_name(String cooperate_name)
  {
    this.cooperate_name = cooperate_name;
  }
}
