package com.ding9.dao.register;

import com.ding9.entity.user.UserAccountInfo;
import com.ding9.result.user.UserResult;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.util.List;










public class RegisterDaoImpl
  implements RegisterDao
{
  public int addUser(UserAccountInfo vo)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    StringBuffer sql = new StringBuffer();
    int i = 1;
    sql.append("insert into user_info(user_id,user_name,user_pass,user_email,user_check,user_sn,user_date_reg)");
    sql.append(" values (seq_user.nextval,?,?,?,0,?,sysdate)");
    
    dba.setParam(SQLParam.createStringParam(i++, vo.getUser_name()));
    dba.setParam(SQLParam.createStringParam(i++, vo.getUser_pass()));
    dba.setParam(SQLParam.createStringParam(i++, vo.getUser_email()));
    dba.setParam(SQLParam.createStringParam(i++, vo.getUser_sn()));
    int flag = dba.modifyData(sql.toString());
    
    dba.closeConnection();
    
    return flag;
  }
  





  public int modEmail(String username, String email, int sn)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    StringBuffer sql = new StringBuffer();
    int i = 1;
    sql.append("update user_info set user_email=?,user_sn=? where user_name=?");
    dba.setParam(SQLParam.createStringParam(i++, email));
    dba.setParam(SQLParam.createIntParam(i++, sn));
    dba.setParam(SQLParam.createStringParam(i++, username));
    
    int flag = dba.modifyData(sql.toString());
    dba.closeConnection();
    return flag;
  }
  





  public int active(String username)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    StringBuffer sql = new StringBuffer();
    int i = 1;
    sql.append("update user_info set user_check=1 where user_name=?");
    dba.setParam(SQLParam.createStringParam(i++, username));
    int flag = dba.modifyData(sql.toString());
    return flag;
  }
  
  public List checkActive(String username, String code)
  {
    IDBAccess dba = new DBAccessDefaultlImpl();
    BaseResult rs = new UserResult();
    String sql = "select * from user_info where user_name='" + username + "' and user_sn='" + code + "'";
    List list = dba.queryData(sql, rs);
    return list;
  }
}
