package com.ding9.dao.user;

import com.ding9.entity.user.UserAccountInfo;
import com.ding9.entity.user.UserContactInfo;
import com.ding9.result.user.UserResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.util.List;
import org.apache.log4j.Logger;

public class UserInfoDaoImpl implements UserInfoDao
{
  private static final Logger logger = Logger.getLogger(UserInfoDaoImpl.class);
  
  private IDBAccess dba = null;
  


  public int insert(UserAccountInfo data)
  {
    this.dba = new DBAccessDefaultlImpl();
    StringBuffer sql = new StringBuffer();
    sql.append("Insert Into user_info (user_id,");
    sql.append("user_id_tmp,");
    sql.append("user_name,user_pass,user_email,user_date_reg,user_sn,user_check,user_journal,user_credit,user_screen,user_name_true,user_sex,user_date,");
    sql.append("user_omit,user_city,user_phone,user_bain_fax,user_handset,user_address,user_post,");
    sql.append("user_quse,user_solu,merchant_tig,user_merchant,source_userid,source_username,source_useremail,is_using) ");
    sql.append("Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
    int index = 1;
    this.dba.setParam(SQLParam.createIntParam(index++, data.getUser_id()));
    
    return 0;
  }
  
  public UserAccountInfo findByAccount(String user_name, String user_pass) {
    logger.debug("entered findByAccount");
    
    StringBuffer sql = new StringBuffer();
    sql.append("select user_id,user_name,user_pass,user_check from user_info where user_name=? and user_pass=? ");
    
    int index = 1;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(SQLParam.createStringParam(index++, user_name));
    this.dba.setParam(SQLParam.createStringParam(index++, user_pass));
    List result = this.dba.queryData(sql.toString(), new UserResult());
    logger.debug("sql : " + sql.toString());
    logger.debug("left getUserByAccount normally");
    if ((result != null) && (result.size() >= 1)) {
      return (UserAccountInfo)result.get(0);
    }
    return null;
  }
  
  public UserAccountInfo findByEmail(String email) {
    logger.debug("entered findByEmail");
    
    String sql = "select user_id,user_name,user_email from user_info where user_email=? ";
    
    int index = 1;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(SQLParam.createStringParam(index++, email));
    List result = this.dba.queryData(sql, new UserResult());
    logger.debug("sql : " + sql);
    logger.debug("left findByEmail normally");
    if ((result != null) && (result.size() >= 1)) {
      return (UserAccountInfo)result.get(0);
    }
    return null;
  }
  
  public UserAccountInfo findByName(String username) {
    logger.debug("entered findByName");
    
    String sql = "select user_id,user_name,user_email from user_info where user_name=? ";
    
    int index = 1;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(SQLParam.createStringParam(index++, username));
    List result = this.dba.queryData(sql, new UserResult());
    logger.debug("sql : " + sql);
    logger.debug("left findByName normally");
    if ((result != null) && (result.size() >= 1)) {
      return (UserAccountInfo)result.get(0);
    }
    return null;
  }
  
  public UserAccountInfo findByUserSn(int user_id, long user_sn) {
    logger.debug("entered findByUserSn");
    
    String sql = "select user_id,user_name,user_email from user_info where user_sn=? and user_id=? ";
    
    int index = 1;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(SQLParam.createLongParam(index++, user_sn));
    this.dba.setParam(SQLParam.createIntParam(index++, user_id));
    List result = this.dba.queryData(sql, new UserResult());
    logger.debug("sql : " + sql);
    logger.debug("left findByUserSn normally");
    if ((result != null) && (result.size() >= 1)) {
      return (UserAccountInfo)result.get(0);
    }
    return null;
  }
  
  public UserAccountInfo findById(int id) {
    logger.info("entered findById");
    
    String sql = "select user_id,user_name,user_pass,user_email,user_date_reg,user_sn,user_check,user_journal,user_credit,user_screen,user_name_true,user_sex,user_date,user_omit,user_city,user_phone,user_bain_fax,user_handset,user_address,user_post,user_quse,user_solu,merchant_tig,user_merchant,source_userid,source_username,source_useremail,is_using from user_info where user_id=? ";
    
    int index = 1;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(SQLParam.createIntParam(index++, id));
    List result = this.dba.queryData(sql, new UserResult());
    if (logger.isInfoEnabled()) {
      logger.info("sql : " + sql);
      logger.info("id : " + id);
      logger.info("left findById normally");
    }
    
    if ((result != null) && (result.size() >= 1)) {
      return (UserAccountInfo)result.get(0);
    }
    return null;
  }
  
  public Integer findUserCheck(String username) {
    logger.debug("entered findUserCheck");
    
    String sql = "select user_check from user_info where user_name=? ";
    int index = 1;
    this.dba = new DBAccessDefaultlImpl();
    this.dba.setParam(SQLParam.createStringParam(index++, username));
    List result = this.dba.queryData(sql, new UserResult());
    if (logger.isDebugEnabled()) {
      logger.debug("sql : " + sql);
      logger.debug("left findUserCheck normally");
    }
    if ((result != null) && (result.size() >= 1)) {
      return Integer.valueOf(((UserAccountInfo)result.get(0)).getUser_check());
    }
    return null;
  }
  
  public int update(UserAccountInfo user) {
    this.dba = new DBAccessDefaultlImpl();
    StringBuffer sql = new StringBuffer();
    sql.append("UPDATE user_info SET ");
    






    int index = 1;
    

    if (!"".equals(user.getUser_pass())) {
      sql.append("user_pass=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, user.getUser_pass()));
    }
    String email = user.getUser_email();
    if ((email != null) && (!"".equals(email.trim()))) {
      sql.append("user_email=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, email.trim()));
    }
    
    String sn = user.getUser_sn();
    if ((sn != null) && (!"".equals(sn.trim()))) {
      sql.append("user_sn=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, sn.trim()));
    }
    


    if (user.getUser_journal() > 0) {
      sql.append("user_journal=?,");
      this.dba.setParam(SQLParam.createIntParam(index++, user.getUser_journal()));
    }
    if (user.getUser_credit() > 0) {
      sql.append("user_credit=?,");
      this.dba.setParam(SQLParam.createIntParam(index++, user.getUser_credit()));
    }
    if (user.getUser_screen() > 0) {
      sql.append("user_screen=?,");
      this.dba.setParam(SQLParam.createIntParam(index++, user.getUser_screen()));
    }
    
    String truename = user.getContact().getUser_name_true();
    if ((truename != null) && (!"".equals(truename.trim()))) {
      sql.append("user_name_true=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, truename.trim()));
    }
    String sex = user.getContact().getUser_sex();
    if ((sex != null) && (!"".equals(sex.trim()))) {
      sql.append("user_sex=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, sex.trim()));
    }
    String birth = user.getContact().getUser_date();
    if ((birth != null) && (!"".equals(birth.trim()))) {
      sql.append("user_date=to_date(?,'yyyy-MM-dd hh24:mi:ss'),");
      this.dba.setParam(SQLParam.createStringParam(index++, birth.trim() + " 00:00:00"));
    }
    String omit = user.getContact().getUser_omit();
    if ((omit != null) && (!"".equals(omit.trim()))) {
      sql.append("user_omit=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, omit.trim()));
    }
    String city = user.getContact().getUser_city();
    if ((city != null) && (!"".equals(city.trim()))) {
      sql.append("user_city=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, city.trim()));
    }
    String phone = user.getContact().getUser_phone();
    if ((phone != null) && (!"".equals(phone.trim()))) {
      sql.append("user_phone=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, phone.trim()));
    }
    String fax = user.getContact().getUser_bain_fax();
    if ((fax != null) && (!"".equals(fax.trim()))) {
      sql.append("user_bain_fax=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, fax.trim()));
    }
    String handset = user.getContact().getUser_handset();
    if ((handset != null) && (!"".equals(handset.trim()))) {
      sql.append("user_handset=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, handset.trim()));
    }
    String address = user.getContact().getUser_address();
    if ((address != null) && (!"".equals(address.trim()))) {
      sql.append("user_address=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, address.trim()));
    }
    String post = user.getContact().getUser_post();
    if ((post != null) && (!"".equals(post.trim()))) {
      sql.append("user_post=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, post.trim()));
    }
    
    int questionId = user.getUser_quse();
    if (questionId > 0) {
      sql.append("user_quse=?,");
      this.dba.setParam(SQLParam.createIntParam(index++, questionId));
    }
    String solu = user.getUser_solu();
    if ((solu != null) && (!"".equals(solu.trim()))) {
      sql.append("user_solu=?,");
      this.dba.setParam(SQLParam.createStringParam(index++, user.getUser_solu()));
    }
    sql.deleteCharAt(sql.lastIndexOf(","));
    










    sql.append(" WHERE user_id=?");
    this.dba.setParam(SQLParam.createIntParam(index++, user.getUser_id()));
    int result = this.dba.modifyData(sql.toString());
    if (logger.isInfoEnabled()) {
      logger.info("sql : " + sql.toString());
      logger.info("left findUserCheck normally");
    }
    
    this.dba = null;
    sql = null;
    
    return result;
  }
  
  public int updateEmail(String email, int userId) {
    this.dba = new DBAccessDefaultlImpl();
    String sql = "UPDATE user_info SET user_email=? WHERE user_id=?";
    int index = 1;
    this.dba.setParam(SQLParam.createStringParam(index++, email.trim()));
    this.dba.setParam(SQLParam.createIntParam(index++, userId));
    int result = this.dba.modifyData(sql.toString());
    if (logger.isInfoEnabled()) {
      logger.info("sql : " + sql.toString());
      logger.info("user_email : " + email);
      logger.info("user_id : " + userId);
    }
    
    this.dba = null;
    sql = null;
    
    return result;
  }
  
  public int updateUserSn(long user_sn, int userId) {
    this.dba = new DBAccessDefaultlImpl();
    String sql = "UPDATE user_info SET user_sn=? WHERE user_id=?";
    int index = 1;
    this.dba.setParam(SQLParam.createLongParam(index++, user_sn));
    this.dba.setParam(SQLParam.createIntParam(index++, userId));
    int result = this.dba.modifyData(sql.toString());
    if (logger.isInfoEnabled()) {
      logger.info("sql : " + sql.toString());
      logger.info("user_sn : " + user_sn);
      logger.info("user_id : " + userId);
    }
    
    this.dba = null;
    sql = null;
    
    return result;
  }
  
  public int updatePassword(String password, int userId) {
    this.dba = new DBAccessDefaultlImpl();
    String sql = "UPDATE user_info SET user_pass=? WHERE user_id=?";
    int index = 1;
    this.dba.setParam(SQLParam.createStringParam(index++, password.trim()));
    this.dba.setParam(SQLParam.createIntParam(index++, userId));
    int result = this.dba.modifyData(sql.toString());
    if (logger.isInfoEnabled()) {
      logger.info("sql : " + sql.toString());
      logger.info("user_pass : " + password);
      logger.info("user_id : " + userId);
    }
    
    this.dba = null;
    sql = null;
    
    return result;
  }
  
  public int updateQuestion(int questionCode, String answer, int userId) {
    this.dba = new DBAccessDefaultlImpl();
    String sql = "UPDATE user_info SET user_quse=?,user_solu=? WHERE user_id=?";
    int index = 1;
    this.dba.setParam(SQLParam.createIntParam(index++, questionCode));
    this.dba.setParam(SQLParam.createStringParam(index++, answer.trim()));
    this.dba.setParam(SQLParam.createIntParam(index++, userId));
    int result = this.dba.modifyData(sql.toString());
    
    if (logger.isInfoEnabled()) {
      logger.info("sql : " + sql.toString());
      logger.info("user_quse : " + questionCode);
      logger.info("user_solu : " + answer);
      logger.info("user_id : " + userId);
    }
    
    this.dba = null;
    sql = null;
    
    return result;
  }
}
