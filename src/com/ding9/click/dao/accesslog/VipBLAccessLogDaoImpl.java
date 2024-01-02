package com.ding9.click.dao.accesslog;

import com.ding9.click.entity.accesslog.IVipBLAccessLogData;
import com.ding9.click.sql.DBAccessDefaultlImpl;
import com.ding9.click.sql.IDBAccess;
import com.ding9.click.sql.SQLParam;
import com.ding9.click.util.StringHelper;
import java.io.PrintStream;
import java.sql.SQLException;












public class VipBLAccessLogDaoImpl
  implements VipBLAccessLogDao
{
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  







  public int addAccessLog(IVipBLAccessLogData vipblaccesslog)
    throws SQLException
  {
    if (vipblaccesslog == null) {
      return -112;
    }
    
    this.dba = new DBAccessDefaultlImpl();
    
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("insert into click_vipbl_access_log ");
    this.sqlstr.append(" (  ");
    this.sqlstr.append("bl_id");
    this.sqlstr.append(",cooperate_id");
    this.sqlstr.append(",vipbl_id");
    this.sqlstr.append(",is_payclick");
    this.sqlstr.append(",action_price");
    this.sqlstr.append(",access_date");
    this.sqlstr.append(",remote_addr");
    this.sqlstr.append(",request_server");
    this.sqlstr.append(",request_port");
    this.sqlstr.append(",request_uri");
    this.sqlstr.append(",request_querystr");
    this.sqlstr.append(",accept_type");
    this.sqlstr.append(",referer_url");
    this.sqlstr.append(",referer_host");
    this.sqlstr.append(",referer_querystr");
    this.sqlstr.append(",user_agent");
    this.sqlstr.append(",init_referer_url");
    this.sqlstr.append(",init_referer_host");
    this.sqlstr.append(",session_id");
    this.sqlstr.append(",cookie_id");
    this.sqlstr.append(",is_spider");
    this.sqlstr.append(",prma_id");
    this.sqlstr.append(",prso_id_one");
    this.sqlstr.append(",prso_id_two");
    this.sqlstr.append(",prso_id_three");
    this.sqlstr.append(",TYPE");
    this.sqlstr.append(",ADAD_ID");
    this.sqlstr.append(",ADV_ID");
    this.sqlstr.append(",MERC_ID");
    this.sqlstr.append(",MEPR_ID");
    this.sqlstr.append(",TARGET_URL");
    this.sqlstr.append(",JUMP_URL");
    this.sqlstr.append(",LINKED_ID");
    this.sqlstr.append(") values (?,?,?,?,?");
    this.sqlstr.append(", SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
    int i = 1;
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getBl_id()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getCooperate_id()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getVipbl_id()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getIs_payclick()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getAction_price()));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getRemote_addr(), 50)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getRequest_server(), 100)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getRequest_port(), 10)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getRequest_uri(), 200)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getRequest_querystr(), 500)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getAccept_type(), 10)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getReferer_url(), 200)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getReferer_host(), 100)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getReferer_querystr(), 100)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getUser_agent(), 100)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getInit_referer_url(), 200)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getInit_referer_host(), 100)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getSession_id(), 50)));
    this.dba.setParam(new SQLParam(i++, 5, StringHelper.getSubString(vipblaccesslog.getCookie_id(), 50)));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getIs_spider()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getPrma_id()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getPrso_id_one()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getPrso_id_two()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getPrso_id_three()));
    this.dba.setParam(new SQLParam(i++, 5, vipblaccesslog.getType()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getAdad_id()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getAdv_id()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getMerc_id()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getMepr_id()));
    this.dba.setParam(new SQLParam(i++, 5, vipblaccesslog.getTarget_url()));
    this.dba.setParam(new SQLParam(i++, 5, vipblaccesslog.getJump_url()));
    this.dba.setParam(new SQLParam(i++, 1, vipblaccesslog.getLinked_id()));
    int result = 0;
    result = this.dba.modifyData(this.sqlstr.toString());
    if (result < 1) {
      return -106;
    }
    
    return 1;
  }
  






  public int addAccessLog(IVipBLAccessLogData[] vipblaccesslogdata)
    throws SQLException
  {
    IVipBLAccessLogData vipblaccesslog = vipblaccesslogdata[0];
    int length = vipblaccesslogdata.length;
    this.sqlstr = new StringBuffer();
    for (int i = 0; i < length; i++) {
      vipblaccesslog = vipblaccesslogdata[i];
      if (i == 0) {
        this.sqlstr.append("insert into click_vipbl_access_log ");
        this.sqlstr.append(" (  ");
        this.sqlstr.append("bl_id");
        this.sqlstr.append(",cooperate_id");
        this.sqlstr.append(",vipbl_id");
        this.sqlstr.append(",is_payclick");
        this.sqlstr.append(",action_price");
        this.sqlstr.append(",access_date");
        this.sqlstr.append(",remote_addr");
        this.sqlstr.append(",request_server");
        this.sqlstr.append(",request_port");
        this.sqlstr.append(",request_uri");
        this.sqlstr.append(",request_querystr");
        this.sqlstr.append(",accept_type");
        this.sqlstr.append(",referer_url");
        this.sqlstr.append(",referer_host");
        this.sqlstr.append(",referer_querystr");
        this.sqlstr.append(",user_agent");
        this.sqlstr.append(",init_referer_url");
        this.sqlstr.append(",init_referer_host");
        this.sqlstr.append(",session_id");
        this.sqlstr.append(",cookie_id");
        this.sqlstr.append(",is_spider");
        this.sqlstr.append(",prma_id");
        this.sqlstr.append(",prso_id_one");
        this.sqlstr.append(",prso_id_two");
        this.sqlstr.append(",prso_id_three");
        this.sqlstr.append(",TYPE");
        this.sqlstr.append(",ADAD_ID");
        this.sqlstr.append(",ADV_ID");
        this.sqlstr.append(",MERC_ID");
        this.sqlstr.append(",MEPR_ID");
        this.sqlstr.append(",TARGET_URL");
        this.sqlstr.append(",JUMP_URL");
        this.sqlstr.append(",LINKED_ID");
        this.sqlstr.append(")");
      } else {
        this.sqlstr.append(" union ");
      }
      this.sqlstr.append(" select '" + vipblaccesslog.getBl_id() + "','" + vipblaccesslog.getCooperate_id() + "','" + vipblaccesslog.getVipbl_id() + "','" + 
        vipblaccesslog.getIs_payclick() + "','" + vipblaccesslog.getAction_price() + 
        "',SYSDATE,'" + StringHelper.getSubString(vipblaccesslog.getRemote_addr(), 50) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getRequest_server(), 100) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getRequest_port(), 10) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getRequest_uri(), 200) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getRequest_querystr(), 500) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getAccept_type(), 10) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getReferer_url(), 200) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getReferer_host(), 100) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getReferer_querystr(), 100) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getUser_agent(), 100) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getInit_referer_url(), 200) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getInit_referer_host(), 100) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getSession_id(), 50) + 
        "','" + StringHelper.getSubString(vipblaccesslog.getCookie_id(), 50) + 
        "','" + vipblaccesslog.getIs_spider() + 
        "','" + vipblaccesslog.getPrma_id() + 
        "','" + vipblaccesslog.getPrso_id_one() + 
        "','" + vipblaccesslog.getPrso_id_two() + 
        "','" + vipblaccesslog.getPrso_id_three() + 
        "','" + vipblaccesslog.getType() + 
        "','" + vipblaccesslog.getAdad_id() + 
        "','" + vipblaccesslog.getAdv_id() + 
        "','" + vipblaccesslog.getMerc_id() + 
        "','" + vipblaccesslog.getMepr_id() + 
        "','" + vipblaccesslog.getTarget_url() + 
        "','" + vipblaccesslog.getJump_url() + 
        "','" + vipblaccesslog.getLinked_id() + 
        "' from dual ");
    }
    
    this.dba = new DBAccessDefaultlImpl();
    int result = 0;
    result = this.dba.modifyData(this.sqlstr.toString());
    System.out.println("ttt:" + result);
    if (result < 1) {
      return -106;
    }
    
    return 1;
  }
}
