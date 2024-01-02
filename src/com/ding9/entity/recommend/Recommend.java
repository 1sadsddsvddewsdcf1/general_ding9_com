package com.ding9.entity.recommend;

import com.ding9.util.Character;
import java.util.Date;





public class Recommend
{
  private int rety_id;
  private int reco_id;
  private int prso_id;
  private int prma_id;
  private int reco_yn;
  private int eco_sequence;
  private String reco_time = Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  



  public int getRety_id()
  {
    return this.rety_id;
  }
  
  public void setRety_id(int rety_id) {
    this.rety_id = rety_id;
  }
  
  public int getEco_sequence() {
    return this.eco_sequence;
  }
  
  public void setEco_sequence(int eco_sequence) {
    this.eco_sequence = eco_sequence;
  }
  
  public int getPrma_id() {
    return this.prma_id;
  }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public int getPrso_id() {
    return this.prso_id;
  }
  
  public void setPrso_id(int prso_id) {
    this.prso_id = prso_id;
  }
  
  public int getReco_id() {
    return this.reco_id;
  }
  
  public void setReco_id(int reco_id) {
    this.reco_id = reco_id;
  }
  
  public String getReco_time() {
    return this.reco_time;
  }
  
  public void setReco_time(String reco_time) {
    this.reco_time = reco_time;
  }
  
  public int getReco_yn() {
    return this.reco_yn;
  }
  
  public void setReco_yn(int reco_yn) {
    this.reco_yn = reco_yn;
  }
}
