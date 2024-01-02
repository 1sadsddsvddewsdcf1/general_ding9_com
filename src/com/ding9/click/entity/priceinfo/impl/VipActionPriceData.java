package com.ding9.click.entity.priceinfo.impl;

import com.ding9.click.entity.priceinfo.IVipActionPriceData;















public class VipActionPriceData
  implements IVipActionPriceData
{
  private int vipbl_id;
  private int cooperate_id;
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
  



  public int getVipbl_id()
  {
    return this.vipbl_id;
  }
  



  public void setVipbl_id(int vipbl_id)
  {
    this.vipbl_id = vipbl_id;
  }
}
