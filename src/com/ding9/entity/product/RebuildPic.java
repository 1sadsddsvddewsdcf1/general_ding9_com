package com.ding9.entity.product;

public class RebuildPic
{
  private int rp_id;
  private int prma_id;
  private int rpt_id;
  private String local_address;
  
  public String getLocal_address() {
    return this.local_address;
  }
  
  public void setLocal_address(String local_address) { this.local_address = local_address; }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) { this.prma_id = prma_id; }
  
  public int getRp_id() {
    return this.rp_id;
  }
  
  public void setRp_id(int rp_id) { this.rp_id = rp_id; }
  
  public int getRpt_id() {
    return this.rpt_id;
  }
  
  public void setRpt_id(int rpt_id) { this.rpt_id = rpt_id; }
}
