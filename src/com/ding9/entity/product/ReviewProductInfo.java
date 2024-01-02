package com.ding9.entity.product;

public class ReviewProductInfo {
  private int rpi_id;
  private int prso_id;
  private int prma_id;
  private String rpi_merit;
  private String rpi_fefect;
  private String rpi_integration;
  private int info_source;
  private int cooperate_id;
  private String update_time;
  
  public int getCooperate_id() { return this.cooperate_id; }
  
  public void setCooperate_id(int cooperate_id) {
    this.cooperate_id = cooperate_id;
  }
  
  public int getInfo_source() { return this.info_source; }
  
  public void setInfo_source(int info_source) {
    this.info_source = info_source;
  }
  
  public int getPrma_id() { return this.prma_id; }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public int getPrso_id() { return this.prso_id; }
  
  public void setPrso_id(int prso_id) {
    this.prso_id = prso_id;
  }
  
  public String getRpi_fefect() { return this.rpi_fefect; }
  
  public void setRpi_fefect(String rpi_fefect) {
    this.rpi_fefect = rpi_fefect;
  }
  
  public int getRpi_id() { return this.rpi_id; }
  
  public void setRpi_id(int rpi_id) {
    this.rpi_id = rpi_id;
  }
  
  public String getRpi_integration() { return this.rpi_integration; }
  
  public void setRpi_integration(String rpi_integration) {
    this.rpi_integration = rpi_integration;
  }
  
  public String getRpi_merit() { return this.rpi_merit; }
  
  public void setRpi_merit(String rpi_merit) {
    this.rpi_merit = rpi_merit;
  }
  
  public String getUpdate_time() { return this.update_time; }
  
  public void setUpdate_time(String update_time) {
    this.update_time = update_time;
  }
}
