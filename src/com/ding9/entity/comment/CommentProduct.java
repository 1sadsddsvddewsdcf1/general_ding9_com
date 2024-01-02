package com.ding9.entity.comment;

import java.util.Date;

public class CommentProduct { private int copr_id;
  private int user_id;
  private int prma_id;
  private int prso_id;
  private String copr_title;
  private String copr_merit;
  private String copr_defect;
  private String copr_content;
  private int copr_grade;
  private int copr_agree;
  private String copr_time = com.ding9.util.Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  private int vouch;
  private String hold_time = com.ding9.util.Character.FieldDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
  
  public int getCopr_agree() { return this.copr_agree; }
  
  public void setCopr_agree(int copr_agree) {
    this.copr_agree = copr_agree;
  }
  
  public String getCopr_content() { return this.copr_content; }
  
  public void setCopr_content(String copr_content) {
    this.copr_content = copr_content;
  }
  
  public String getCopr_defect() { return this.copr_defect; }
  
  public void setCopr_defect(String copr_defect) {
    this.copr_defect = copr_defect;
  }
  
  public int getCopr_grade() { return this.copr_grade; }
  
  public void setCopr_grade(int copr_grade) {
    this.copr_grade = copr_grade;
  }
  
  public int getCopr_id() { return this.copr_id; }
  
  public void setCopr_id(int copr_id) {
    this.copr_id = copr_id;
  }
  
  public String getCopr_merit() { return this.copr_merit; }
  
  public void setCopr_merit(String copr_merit) {
    this.copr_merit = copr_merit;
  }
  
  public String getCopr_time() { return this.copr_time; }
  
  public void setCopr_time(String copr_time) {
    this.copr_time = copr_time;
  }
  
  public String getCopr_title() { return this.copr_title; }
  
  public void setCopr_title(String copr_title) {
    this.copr_title = copr_title;
  }
  
  public String getHold_time() { return this.hold_time; }
  
  public void setHold_time(String hold_time) {
    this.hold_time = hold_time;
  }
  
  public int getPrma_id() { return this.prma_id; }
  
  public void setPrma_id(int prma_id) {
    this.prma_id = prma_id;
  }
  
  public int getPrso_id() { return this.prso_id; }
  
  public void setPrso_id(int prso_id) {
    this.prso_id = prso_id;
  }
  
  public int getUser_id() { return this.user_id; }
  
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  
  public int getVouch() { return this.vouch; }
  
  public void setVouch(int vouch) {
    this.vouch = vouch;
  }
}
