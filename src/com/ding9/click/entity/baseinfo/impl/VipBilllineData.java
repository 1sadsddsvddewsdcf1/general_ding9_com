package com.ding9.click.entity.baseinfo.impl;

import com.ding9.click.entity.baseinfo.IVipBilllineData;















public class VipBilllineData
  implements IVipBilllineData
{
  private int vipbl_id;
  private String vipbl_name;
  private String vipbl_url;
  private int vipbl_status;
  private String create_time;
  private String vipbl_remark;
  
  public int getVipbl_id()
  {
    return this.vipbl_id;
  }
  



  public void setVipbl_id(int vipbl_id)
  {
    this.vipbl_id = vipbl_id;
  }
  



  public String getVipbl_name()
  {
    return this.vipbl_name;
  }
  



  public void setVipbl_name(String vipbl_name)
  {
    this.vipbl_name = vipbl_name;
  }
  



  public String getVipbl_remark()
  {
    return this.vipbl_remark;
  }
  



  public void setVipbl_remark(String vipbl_remark)
  {
    this.vipbl_remark = vipbl_remark;
  }
  



  public int getVipbl_status()
  {
    return this.vipbl_status;
  }
  



  public void setVipbl_status(int vipbl_status)
  {
    this.vipbl_status = vipbl_status;
  }
  



  public String getVipbl_url()
  {
    return this.vipbl_url;
  }
  



  public void setVipbl_url(String vipbl_url)
  {
    this.vipbl_url = vipbl_url;
  }
  



  public String getCreate_time()
  {
    return this.create_time;
  }
  



  public void setCreate_time(String create_time)
  {
    this.create_time = create_time;
  }
}
