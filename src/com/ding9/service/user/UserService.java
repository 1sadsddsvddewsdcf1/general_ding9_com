package com.ding9.service.user;

import com.ding9.dao.user.UserInfoDao;
import com.ding9.dao.user.UserInfoDaoImpl;
import com.ding9.entity.user.UserAccountInfo;
import com.ding9.util.MD5Helper;
import org.apache.log4j.Logger;





public class UserService
{
  private static final Logger logger = Logger.getLogger(UserService.class);
  









  public int authenticate(String username, String password)
  {
    if ((username == null) || (password == null)) {
      return -1;
    }
    UserAccountInfo user = null;
    UserInfoDao userDao = new UserInfoDaoImpl();
    user = userDao.findByName(username);
    if (user == null) {
      return -3;
    }
    user = userDao.findByAccount(username, MD5Helper.encode(password));
    if (user == null) {
      return -4;
    }
    return user.getUser_id();
  }
  






  public int checkName(String username)
  {
    if ((username == null) || ("".equals(username))) {
      return 0;
    }
    UserInfoDao userDao = new UserInfoDaoImpl();
    UserAccountInfo user = userDao.findByName(username);
    if (user != null) {
      return 0;
    }
    return 1;
  }
  






  public int checkEmail(String email)
  {
    if ((email == null) || ("".equals(email))) {
      return 0;
    }
    UserInfoDao userDao = new UserInfoDaoImpl();
    UserAccountInfo user = userDao.findByEmail(email);
    if (user != null) {
      return 0;
    }
    return 1;
  }
  







  public int checkEmail(String email, String username)
  {
    if ((email == null) || ("".equals(email)) || (username == null) || ("".equals(username))) {
      return 0;
    }
    UserInfoDao userDao = new UserInfoDaoImpl();
    UserAccountInfo user = userDao.findByName(username);
    

    if (email.equalsIgnoreCase(user.getUser_email())) {
      return 1;
    }
    
    user = userDao.findByEmail(email);
    if (user != null) {
      return 0;
    }
    return 1;
  }
  






  public boolean isActivated(String username)
  {
    if ((username == null) || ("".equals(username))) {
      return false;
    }
    UserInfoDao userDao = new UserInfoDaoImpl();
    Integer checkValue = userDao.findUserCheck(username);
    if (checkValue != null) {
      if (checkValue.intValue() == 0) {
        return false;
      }
      if (checkValue.intValue() == 1) {
        return true;
      }
    }
    return false;
  }
  






  public UserAccountInfo findById(int userId)
  {
    if (userId <= 0) {
      return null;
    }
    return new UserInfoDaoImpl().findById(userId);
  }
  






  public UserAccountInfo findByName(String username)
  {
    if (username == null) {
      return null;
    }
    return new UserInfoDaoImpl().findByName(username);
  }
  






  public int updateUser(UserAccountInfo user)
  {
    if (user == null) {
      return 0;
    }
    return new UserInfoDaoImpl().update(user);
  }
  







  public boolean updateEmail(int userId, String email)
  {
    if ((email == null) && ("".equals(email))) {
      return false;
    }
    int result = new UserInfoDaoImpl().updateEmail(email, userId);
    return result > 0;
  }
  












  public int updatePassword(int userId, String srcPassword, String newPassword, String verifyPassword)
  {
    if ((srcPassword == null) || (newPassword == null)) {
      return -1;
    }
    

    String srcPW = MD5Helper.encode(srcPassword);
    String password = MD5Helper.encode(newPassword);
    
    UserInfoDao userDao = new UserInfoDaoImpl();
    

    String pw = userDao.findById(userId).getUser_pass();
    if (logger.isInfoEnabled()) {
      logger.info("srcPW : " + srcPW);
      logger.info("pw : " + pw);
    }
    if (!srcPW.equals(pw)) {
      return -6;
    }
    

    if (!verifyPassword.equals(newPassword)) {
      return -7;
    }
    

    int result = userDao.updatePassword(password, userId);
    return result;
  }
  










  public int addQuestion(int userId, int questionCode, String answer)
  {
    if ((questionCode < 0) || (answer == null) || ("".equalsIgnoreCase(answer))) {
      return -1;
    }
    
    UserInfoDao userDao = new UserInfoDaoImpl();
    int result = userDao.updateQuestion(questionCode, answer, userId);
    return result;
  }
  














  public int updateQuestion(int userId, int srcQuesCode, String srcAnswer, int newQuesCode, String newAnswer)
  {
    if ((srcQuesCode < 0) || (srcAnswer == null) || (newQuesCode < 0) || (newAnswer == null)) {
      return -1;
    }
    
    UserInfoDao userDao = new UserInfoDaoImpl();
    

    UserAccountInfo user = userDao.findById(userId);
    if (srcQuesCode != user.getUser_quse()) {
      return -8;
    }
    
    String solu = user.getUser_solu();
    if ((solu == null) || (!srcAnswer.equalsIgnoreCase(user.getUser_solu().trim()))) {
      return -9;
    }
    
    int result = userDao.updateQuestion(newQuesCode, newAnswer, userId);
    return result;
  }
}
