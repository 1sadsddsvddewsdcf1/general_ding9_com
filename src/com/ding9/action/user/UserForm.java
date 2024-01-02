package com.ding9.action.user;

import com.ding9.entity.user.UserAccountInfo;
import org.apache.struts.action.ActionForm;










public class UserForm
  extends ActionForm
{
  private static final long serialVersionUID = -7962035120506992296L;
  private UserAccountInfo user;
  private String newEmail;
  private String oldPassword;
  private String newPassword;
  private String verifyPassword;
  private String areaCode;
  private String telephone;
  private String extNumber;
  private int quesCode;
  private String answer;
  private int srcQuesCode;
  private String srcAnswer;
  private int newQuesCode;
  private String newAnswer;
  private String[] labels = { "请选择你喜欢的问题", "您的宠物的名字？", "您的出生地在哪里？", "您就读的第一所学校的名称？", "少年时代心目中的英雄是谁？", "您最喜欢的休闲运动是什么？", "您最喜欢哪支运动队？", "您最喜欢的运动员是谁？", "高中的校训是什么？", "您的第一辆汽车或自行车是什么牌子的？" };
  private String[] values = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
  
  public UserForm() {
    this.user = new UserAccountInfo();
    
    this.newEmail = "";
    
    this.newPassword = "";
    this.oldPassword = "";
    this.verifyPassword = "";
    
    this.areaCode = "";
    this.telephone = "";
    this.extNumber = "";
  }
  
  public UserAccountInfo getUser() {
    return this.user;
  }
  
  public void setUser(UserAccountInfo user) { this.user = user; }
  
  public String getNewEmail()
  {
    return this.newEmail;
  }
  
  public void setNewEmail(String email) {
    this.newEmail = email;
  }
  
  public String getNewPassword() {
    return this.newPassword;
  }
  
  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }
  
  public String getOldPassword() {
    return this.oldPassword;
  }
  
  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }
  
  public String getVerifyPassword() {
    return this.verifyPassword;
  }
  
  public void setVerifyPassword(String verifyPassword) {
    this.verifyPassword = verifyPassword;
  }
  
  public String getAreaCode() {
    return this.areaCode;
  }
  
  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }
  
  public String getExtNumber() {
    return this.extNumber;
  }
  
  public void setExtNumber(String extNumber) {
    this.extNumber = extNumber;
  }
  
  public String getTelephone() {
    return this.telephone;
  }
  
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  
  public String getAnswer()
  {
    return this.answer;
  }
  
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  
  public String getNewAnswer() {
    return this.newAnswer;
  }
  
  public void setNewAnswer(String newAnswer) {
    this.newAnswer = newAnswer;
  }
  
  public int getNewQuesCode() {
    return this.newQuesCode;
  }
  
  public void setNewQuesCode(int newQuesCode) {
    this.newQuesCode = newQuesCode;
  }
  
  public int getQuesCode() {
    return this.quesCode;
  }
  
  public void setQuesCode(int quesCode) {
    this.quesCode = quesCode;
  }
  
  public String getSrcAnswer() {
    return this.srcAnswer;
  }
  
  public void setSrcAnswer(String srcAnswer) {
    this.srcAnswer = srcAnswer;
  }
  
  public int getSrcQuesCode() {
    return this.srcQuesCode;
  }
  
  public void setSrcQuesCode(int srcQuesCode) {
    this.srcQuesCode = srcQuesCode;
  }
  
  public String[] getLabels() {
    return this.labels;
  }
  
  public void setLabels(String[] labels) {
    this.labels = labels;
  }
  
  public String[] getValues() {
    return this.values;
  }
  
  public void setValues(String[] values) {
    this.values = values;
  }
}
