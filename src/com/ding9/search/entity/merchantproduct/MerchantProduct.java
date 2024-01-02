package com.ding9.search.entity.merchantproduct;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

































public class MerchantProduct
  implements Serializable
{
  private int meprId;
  private int prmaId;
  private String prma_remark;
  private String product_pic;
  private int product_level;
  private int comment_count;
  private String mesh_logo;
  private String prma_ena = "";
  

  private String merc_com_name;
  

  private String merc_phone;
  

  private int comments_cnt;
  

  private String merc_province;
  

  private String merc_city;
  

  private String merc_email;
  

  private int comments_level;
  

  private String merc_payment;
  

  private String small_pic_address;
  

  private int prsoId;
  

  private int mercId;
  

  private String prmaName;
  

  private String meprRemark;
  

  private String meprContect;
  

  private int meprQuality;
  

  private int messId;
  

  private int meprCount;
  

  private Object meprValue;
  

  private int meprYn;
  

  private String meprYnReason;
  

  private int sysYn;
  

  private int meprSale;
  

  private int meprVouch;
  

  private int meprNew;
  

  private int meprPop;
  

  private int meprCheap;
  

  private String meprWebAddress;
  

  private String meprAddress;
  

  private Date meprTime;
  

  private Date upTime;
  

  private int meprCountDes;
  

  private int meprAss;
  

  private int meprCrawl;
  

  private int meprMatch;
  

  private int meprForestall;
  

  private BigDecimal meprValue1;
  

  private BigDecimal meprPrice;
  

  private BigDecimal meprWeight;
  

  private String meprReason;
  

  private BigDecimal meprBrId;
  

  private String mepr2ndName;
  

  private String meprUpc;
  

  private String meprModel;
  

  private BigDecimal meprTmp;
  

  private String meprBrand;
  

  private String meprPrsoName;
  
  private Integer meprAdui;
  
  private String meprMemo;
  
  private String meprAduiReason;
  

  public MerchantProduct(int meprId, int prmaId, int prsoId, int mercId, String prmaName, String meprRemark, String meprContect, int meprQuality, int messId, int meprCount, Object meprValue, int meprYn, String meprYnReason, int sysYn, int meprSale, int meprVouch, int meprNew, int meprPop, int meprCheap, String meprWebAddress, String meprAddress, Date meprTime, Date upTime, int meprCountDes, int meprAss, int meprCrawl, int meprMatch, int meprForestall, BigDecimal meprValue1, BigDecimal meprPrice, BigDecimal meprWeight, String meprReason, BigDecimal meprBrId, String mepr2ndName, String meprUpc, String meprModel, BigDecimal meprTmp, String meprBrand, String meprPrsoName, Integer meprAdui, String meprMemo, String meprAduiReason)
  {
    this.meprId = meprId;
    this.prmaId = prmaId;
    this.prsoId = prsoId;
    this.mercId = mercId;
    this.prmaName = prmaName;
    this.meprRemark = meprRemark;
    this.meprContect = meprContect;
    this.meprQuality = meprQuality;
    this.messId = messId;
    this.meprCount = meprCount;
    this.meprValue = meprValue;
    this.meprYn = meprYn;
    this.meprYnReason = meprYnReason;
    this.sysYn = sysYn;
    this.meprSale = meprSale;
    this.meprVouch = meprVouch;
    this.meprNew = meprNew;
    this.meprPop = meprPop;
    this.meprCheap = meprCheap;
    this.meprWebAddress = meprWebAddress;
    this.meprAddress = meprAddress;
    this.meprTime = meprTime;
    this.upTime = upTime;
    this.meprCountDes = meprCountDes;
    this.meprAss = meprAss;
    this.meprCrawl = meprCrawl;
    this.meprMatch = meprMatch;
    this.meprForestall = meprForestall;
    this.meprValue1 = meprValue1;
    this.meprPrice = meprPrice;
    this.meprWeight = meprWeight;
    this.meprReason = meprReason;
    this.meprBrId = meprBrId;
    this.mepr2ndName = mepr2ndName;
    this.meprUpc = meprUpc;
    this.meprModel = meprModel;
    this.meprTmp = meprTmp;
    this.meprBrand = meprBrand;
    this.meprPrsoName = meprPrsoName;
    this.meprAdui = meprAdui;
    this.meprMemo = meprMemo;
    this.meprAduiReason = meprAduiReason;
  }
  

  public MerchantProduct() {}
  

  public MerchantProduct(int meprId, int meprForestall)
  {
    this.meprId = meprId;
    this.meprForestall = meprForestall;
  }
  






  public int getMeprId()
  {
    return this.meprId;
  }
  
  public void setMeprId(int meprId) {
    this.meprId = meprId;
  }
  





  public int getPrmaId()
  {
    return this.prmaId;
  }
  
  public void setPrmaId(int prmaId) {
    this.prmaId = prmaId;
  }
  





  public int getPrsoId()
  {
    return this.prsoId;
  }
  
  public void setPrsoId(int prsoId) {
    this.prsoId = prsoId;
  }
  





  public int getMercId()
  {
    return this.mercId;
  }
  
  public void setMercId(int mercId) {
    this.mercId = mercId;
  }
  





  public String getPrmaName()
  {
    return this.prmaName;
  }
  
  public void setPrmaName(String prmaName) {
    this.prmaName = prmaName;
  }
  




  public String getMeprRemark()
  {
    return this.meprRemark;
  }
  
  public void setMeprRemark(String meprRemark) {
    this.meprRemark = meprRemark;
  }
  





  public String getMeprContect()
  {
    return this.meprContect;
  }
  
  public void setMeprContect(String meprContect) {
    this.meprContect = meprContect;
  }
  





  public int getMeprQuality()
  {
    return this.meprQuality;
  }
  
  public void setMeprQuality(int meprQuality) {
    this.meprQuality = meprQuality;
  }
  





  public int getMessId()
  {
    return this.messId;
  }
  
  public void setMessId(int messId) {
    this.messId = messId;
  }
  





  public int getMeprCount()
  {
    return this.meprCount;
  }
  
  public void setMeprCount(int meprCount) {
    this.meprCount = meprCount;
  }
  





  public Object getMeprValue()
  {
    return this.meprValue;
  }
  
  public void setMeprValue(Object meprValue) {
    this.meprValue = meprValue;
  }
  





  public int getMeprYn()
  {
    return this.meprYn;
  }
  
  public void setMeprYn(int meprYn) {
    this.meprYn = meprYn;
  }
  





  public String getMeprYnReason()
  {
    return this.meprYnReason;
  }
  
  public void setMeprYnReason(String meprYnReason) {
    this.meprYnReason = meprYnReason;
  }
  





  public int getSysYn()
  {
    return this.sysYn;
  }
  
  public void setSysYn(int sysYn) {
    this.sysYn = sysYn;
  }
  





  public int getMeprSale()
  {
    return this.meprSale;
  }
  
  public void setMeprSale(int meprSale) {
    this.meprSale = meprSale;
  }
  





  public int getMeprVouch()
  {
    return this.meprVouch;
  }
  
  public void setMeprVouch(int meprVouch) {
    this.meprVouch = meprVouch;
  }
  





  public int getMeprNew()
  {
    return this.meprNew;
  }
  
  public void setMeprNew(int meprNew) {
    this.meprNew = meprNew;
  }
  





  public int getMeprPop()
  {
    return this.meprPop;
  }
  
  public void setMeprPop(int meprPop) {
    this.meprPop = meprPop;
  }
  





  public int getMeprCheap()
  {
    return this.meprCheap;
  }
  
  public void setMeprCheap(int meprCheap) {
    this.meprCheap = meprCheap;
  }
  





  public String getMeprWebAddress()
  {
    return this.meprWebAddress;
  }
  
  public void setMeprWebAddress(String meprWebAddress) {
    this.meprWebAddress = meprWebAddress;
  }
  





  public String getMeprAddress()
  {
    return this.meprAddress;
  }
  
  public void setMeprAddress(String meprAddress) {
    this.meprAddress = meprAddress;
  }
  





  public Date getMeprTime()
  {
    return this.meprTime;
  }
  
  public void setMeprTime(Date meprTime) {
    this.meprTime = meprTime;
  }
  





  public Date getUpTime()
  {
    return this.upTime;
  }
  
  public void setUpTime(Date upTime) {
    this.upTime = upTime;
  }
  





  public int getMeprCountDes()
  {
    return this.meprCountDes;
  }
  
  public void setMeprCountDes(int meprCountDes) {
    this.meprCountDes = meprCountDes;
  }
  





  public int getMeprAss()
  {
    return this.meprAss;
  }
  
  public void setMeprAss(int meprAss) {
    this.meprAss = meprAss;
  }
  





  public int getMeprCrawl()
  {
    return this.meprCrawl;
  }
  
  public void setMeprCrawl(int meprCrawl) {
    this.meprCrawl = meprCrawl;
  }
  





  public int getMeprMatch()
  {
    return this.meprMatch;
  }
  
  public void setMeprMatch(int meprMatch) {
    this.meprMatch = meprMatch;
  }
  






  public int getMeprForestall()
  {
    return this.meprForestall;
  }
  
  public void setMeprForestall(int meprForestall) {
    this.meprForestall = meprForestall;
  }
  





  public BigDecimal getMeprValue1()
  {
    return this.meprValue1;
  }
  
  public void setMeprValue1(BigDecimal meprValue1) {
    this.meprValue1 = meprValue1;
  }
  





  public BigDecimal getMeprPrice()
  {
    return this.meprPrice;
  }
  
  public void setMeprPrice(BigDecimal meprPrice) {
    this.meprPrice = meprPrice;
  }
  





  public BigDecimal getMeprWeight()
  {
    return this.meprWeight;
  }
  
  public void setMeprWeight(BigDecimal meprWeight) {
    this.meprWeight = meprWeight;
  }
  





  public String getMeprReason()
  {
    return this.meprReason;
  }
  
  public void setMeprReason(String meprReason) {
    this.meprReason = meprReason;
  }
  





  public BigDecimal getMeprBrId()
  {
    return this.meprBrId;
  }
  
  public void setMeprBrId(BigDecimal meprBrId) {
    this.meprBrId = meprBrId;
  }
  





  public String getMepr2ndName()
  {
    return this.mepr2ndName;
  }
  
  public void setMepr2ndName(String mepr2ndName) {
    this.mepr2ndName = mepr2ndName;
  }
  





  public String getMeprUpc()
  {
    return this.meprUpc;
  }
  
  public void setMeprUpc(String meprUpc) {
    this.meprUpc = meprUpc;
  }
  





  public String getMeprModel()
  {
    return this.meprModel;
  }
  
  public void setMeprModel(String meprModel) {
    this.meprModel = meprModel;
  }
  





  public BigDecimal getMeprTmp()
  {
    return this.meprTmp;
  }
  
  public void setMeprTmp(BigDecimal meprTmp) {
    this.meprTmp = meprTmp;
  }
  





  public String getMeprBrand()
  {
    return this.meprBrand;
  }
  
  public void setMeprBrand(String meprBrand) {
    this.meprBrand = meprBrand;
  }
  





  public String getMeprPrsoName()
  {
    return this.meprPrsoName;
  }
  
  public void setMeprPrsoName(String meprPrsoName) {
    this.meprPrsoName = meprPrsoName;
  }
  





  public Integer getMeprAdui()
  {
    return this.meprAdui;
  }
  
  public void setMeprAdui(Integer meprAdui) {
    this.meprAdui = meprAdui;
  }
  





  public String getMeprMemo()
  {
    return this.meprMemo;
  }
  
  public void setMeprMemo(String meprMemo) {
    this.meprMemo = meprMemo;
  }
  





  public String getMeprAduiReason()
  {
    return this.meprAduiReason;
  }
  
  public void setMeprAduiReason(String meprAduiReason) {
    this.meprAduiReason = meprAduiReason;
  }
  
  public String toString() {
    return 
    
      new ToStringBuilder(this).append("meprId", getMeprId()).toString();
  }
  
  public int getComment_count() {
    return this.comment_count;
  }
  
  public void setComment_count(int comment_count) {
    this.comment_count = comment_count;
  }
  
  public String getPrma_remark() {
    return this.prma_remark;
  }
  
  public void setPrma_remark(String prma_remark) {
    this.prma_remark = prma_remark;
  }
  
  public int getProduct_level() {
    return this.product_level;
  }
  
  public void setProduct_level(int product_level) {
    this.product_level = product_level;
  }
  
  public int getComments_cnt() {
    return this.comments_cnt;
  }
  
  public void setComments_cnt(int comments_cnt) {
    this.comments_cnt = comments_cnt;
  }
  
  public int getComments_level() {
    return this.comments_level;
  }
  
  public void setComments_level(int comments_level) {
    this.comments_level = comments_level;
  }
  
  public String getMerc_city() {
    return this.merc_city;
  }
  
  public void setMerc_city(String merc_city) {
    this.merc_city = merc_city;
  }
  
  public String getMerc_com_name() {
    return this.merc_com_name;
  }
  
  public void setMerc_com_name(String merc_com_name) {
    this.merc_com_name = merc_com_name;
  }
  
  public String getMerc_email() {
    return this.merc_email;
  }
  
  public void setMerc_email(String merc_email) {
    this.merc_email = merc_email;
  }
  
  public String getMerc_payment() {
    return this.merc_payment;
  }
  
  public void setMerc_payment(String merc_payment) {
    this.merc_payment = merc_payment;
  }
  
  public String getMerc_phone() {
    return this.merc_phone;
  }
  
  public void setMerc_phone(String merc_phone) {
    this.merc_phone = merc_phone;
  }
  
  public String getMerc_province() {
    return this.merc_province;
  }
  
  public void setMerc_province(String merc_province) {
    this.merc_province = merc_province;
  }
  
  public String getMesh_logo() {
    return this.mesh_logo;
  }
  
  public void setMesh_logo(String mesh_logo) {
    this.mesh_logo = mesh_logo;
  }
  
  public String getProduct_pic() {
    return this.product_pic;
  }
  
  public void setProduct_pic(String product_pic) {
    this.product_pic = product_pic;
  }
  
  public String getSmall_pic_address() {
    return this.small_pic_address;
  }
  
  public void setSmall_pic_address(String small_pic_address) {
    this.small_pic_address = small_pic_address;
  }
  
  public String getPrma_ena() {
    return this.prma_ena;
  }
  
  public void setPrma_ena(String prma_ena) {
    this.prma_ena = prma_ena;
  }
}
