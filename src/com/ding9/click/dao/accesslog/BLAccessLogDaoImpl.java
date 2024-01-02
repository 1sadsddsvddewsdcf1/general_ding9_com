package com.ding9.click.dao.accesslog;

import com.ding9.click.entity.accesslog.IBLAccessLogData;
import com.ding9.click.sql.DBAccessDefaultlImpl;
import com.ding9.click.sql.IDBAccess;
import com.ding9.click.sql.SQLParam;
import com.ding9.click.util.StringHelper;
import java.sql.SQLException;













public class BLAccessLogDaoImpl
  implements BLAccessLogDao
{
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  







  public int addAccessLog(IBLAccessLogData blaccesslog)
    throws SQLException
  {
    if (blaccesslog == null) {
      return -112;
    }
    
    String postfix = "";
    

    this.dba = new DBAccessDefaultlImpl();
    
    this.sqlstr = new StringBuffer();
    
    this.sqlstr.append("select to_char(sysdate, 'YYYYMMDD') dates from dual");
    


    postfix = this.dba.queryData(this.sqlstr.toString());
    
    postfix = "_" + postfix.trim();
    


    this.dba = null;
    

    this.dba = new DBAccessDefaultlImpl();
    
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("insert into click_bl_access_log" + postfix.trim());
    this.sqlstr.append(" (  ");
    this.sqlstr.append("bl_id");
    this.sqlstr.append(",cooperate_id");
    this.sqlstr.append(",vipbl_id");
    this.sqlstr.append(",access_date");
    this.sqlstr.append(",remote_addr");
    this.sqlstr.append(",remote_user");
    this.sqlstr.append(",http_method");
    this.sqlstr.append(",request_protocol");
    this.sqlstr.append(",request_scheme");
    this.sqlstr.append(",response_result");
    this.sqlstr.append(",request_server");
    this.sqlstr.append(",request_port");
    this.sqlstr.append(",request_uri");
    this.sqlstr.append(",Request_querystr");
    this.sqlstr.append(",accept_type");
    this.sqlstr.append(",referer_url");
    this.sqlstr.append(",Referer_host");
    this.sqlstr.append(",referer_querystr");
    this.sqlstr.append(",user_agent");
    this.sqlstr.append(",init_referer_url");
    this.sqlstr.append(",init_referer_host");
    this.sqlstr.append(",session_id");
    this.sqlstr.append(",cookie_id");
    this.sqlstr.append(",is_spider");
    this.sqlstr.append(",is_firstlog");
    this.sqlstr.append(") values (?,?,?");
    this.sqlstr.append(", SYSDATE ");
    this.sqlstr.append(",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    this.dba.setParam(new SQLParam(1, 1, blaccesslog.getBl_id()));
    this.dba.setParam(new SQLParam(2, 1, blaccesslog.getCooperate_id()));
    this.dba.setParam(new SQLParam(3, 1, blaccesslog.getVipbl_id()));
    this.dba.setParam(new SQLParam(4, 5, StringHelper.getSubString(blaccesslog.getRemote_addr(), 50)));
    this.dba.setParam(new SQLParam(5, 5, StringHelper.getSubString(blaccesslog.getRemote_user(), 50)));
    this.dba.setParam(new SQLParam(6, 5, StringHelper.getSubString(blaccesslog.getHttp_method(), 5)));
    this.dba.setParam(new SQLParam(7, 5, StringHelper.getSubString(blaccesslog.getRequest_protocol(), 20)));
    this.dba.setParam(new SQLParam(8, 5, StringHelper.getSubString(blaccesslog.getRequest_scheme(), 20)));
    this.dba.setParam(new SQLParam(9, 1, blaccesslog.getResponse_result()));
    this.dba.setParam(new SQLParam(10, 5, StringHelper.getSubString(blaccesslog.getRequest_server(), 100)));
    this.dba.setParam(new SQLParam(11, 5, StringHelper.getSubString(blaccesslog.getRequest_port(), 10)));
    this.dba.setParam(new SQLParam(12, 5, StringHelper.getSubString(blaccesslog.getRequest_uri(), 200)));
    this.dba.setParam(new SQLParam(13, 5, StringHelper.getSubString(blaccesslog.getRequest_querystr(), 500)));
    this.dba.setParam(new SQLParam(14, 5, StringHelper.getSubString(blaccesslog.getAccept_type(), 10)));
    this.dba.setParam(new SQLParam(15, 5, StringHelper.getSubString(blaccesslog.getReferer_url(), 200)));
    this.dba.setParam(new SQLParam(16, 5, StringHelper.getSubString(blaccesslog.getReferer_host(), 100)));
    this.dba.setParam(new SQLParam(17, 5, StringHelper.getSubString(blaccesslog.getReferer_querystr(), 100)));
    this.dba.setParam(new SQLParam(18, 5, StringHelper.getSubString(blaccesslog.getUser_agent(), 100)));
    this.dba.setParam(new SQLParam(19, 5, StringHelper.getSubString(blaccesslog.getInit_referer_url(), 200)));
    this.dba.setParam(new SQLParam(20, 5, StringHelper.getSubString(blaccesslog.getInit_referer_host(), 100)));
    this.dba.setParam(new SQLParam(21, 5, StringHelper.getSubString(blaccesslog.getSession_id(), 50)));
    this.dba.setParam(new SQLParam(22, 5, StringHelper.getSubString(blaccesslog.getCookie_id(), 50)));
    this.dba.setParam(new SQLParam(23, 1, blaccesslog.getIs_spider()));
    this.dba.setParam(new SQLParam(24, 1, blaccesslog.getIs_firstlog()));
    int result = 0;
    
    result = this.dba.modifyData(this.sqlstr.toString());
    
    if (result < 1) {
      return -106;
    }
    
    return 1;
  }
}
