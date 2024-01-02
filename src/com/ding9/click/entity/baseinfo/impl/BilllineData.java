package com.ding9.click.entity.baseinfo.impl;

import com.ding9.click.entity.baseinfo.IBilllineData;















public class BilllineData
  implements IBilllineData
{
  private int bl_id;
  private String bl_name;
  private String bl_url;
  private int bl_status;
  private String create_time;
  private String bl_remark;
  
  public int getBl_id()
  {
    return this.bl_id;
  }
  



  public void setBl_id(int bl_id)
  {
    this.bl_id = bl_id;
  }
  



  public String getBl_name()
  {
    return this.bl_name;
  }
  



  public void setBl_name(String bl_name)
  {
    this.bl_name = bl_name;
  }
  



  public String getBl_remark()
  {
    return this.bl_remark;
  }
  



  public void setBl_remark(String bl_remark)
  {
    this.bl_remark = bl_remark;
  }
  



  public int getBl_status()
  {
    return this.bl_status;
  }
  



  public void setBl_status(int bl_status)
  {
    this.bl_status = bl_status;
  }
  



  public String getBl_url()
  {
    return this.bl_url;
  }
  



  public void setBl_url(String bl_url)
  {
    this.bl_url = bl_url;
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
