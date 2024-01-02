package com.ding9.dao.merchant;

import com.ding9.entity.merchant.Merchant;
import com.ding9.entity.merchant.MerchantProduct;
import com.ding9.result.merchant.MerchantCnt;
import com.ding9.result.merchant.MerchantInfo;
import com.ding9.result.merchant.MerchantProductUrlInfo;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.sql.SQLException;
import java.util.List;








public class MerchantDaoImpl
  implements MerchantDao
{
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  


  public String getMerchantProductUrl(int merc_id, int prma_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult url = new MerchantProductUrlInfo();
    this.dba.setParam(new SQLParam(1, 1, prma_id));
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("select mepr_web_address ");
    this.sqlstr.append(" from merchant_product ");
    
    if ((merc_id != 0) && (prma_id != 0)) {
      this.sqlstr.append(" where prma_id=? and merc_id=?");
      this.dba.setParam(new SQLParam(2, 1, merc_id));
    } else {
      this.sqlstr.append(" where prma_id=?");
    }
    

    List rec = this.dba.queryData(this.sqlstr.toString(), url);
    this.dba.closeConnection();
    url = null;
    this.sqlstr = null;
    
    String weburl = null;
    
    if (!rec.isEmpty()) {
      MerchantProduct merchantproduct = (MerchantProduct)rec.get(0);
      weburl = merchantproduct.getMepr_web_address();
    }
    return weburl;
  }
  






  public boolean getFufeiClick(int merc_id, int prma_id)
    throws SQLException
  {
    boolean isClick = false;
    this.dba = new DBAccessDefaultlImpl();
    BaseResult url = new MerchantCnt();
    
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("select count(*) as cnt from merchant_product  where  mepr_forestall!=0 AND mepr_yn=1 AND sys_yn=1 AND mepr_price is not null AND mepr_price!=0 and prma_id=? and merc_id=? ");
    
    this.dba.setParam(new SQLParam(1, 1, prma_id));
    this.dba.setParam(new SQLParam(2, 1, merc_id));
    

    List rec = this.dba.queryData(this.sqlstr.toString(), url);
    this.dba.closeConnection();
    if ((rec != null) && (rec.size() > 0) && 
      (((Merchant)rec.get(0)).getMerc_id() > 0)) { isClick = true;
    }
    return isClick;
  }
  





  public Merchant getMerchantInfo(int merc_id)
    throws SQLException
  {
    this.dba = new DBAccessDefaultlImpl();
    BaseResult url = new MerchantInfo();
    
    String sqlstr = "";
    








    sqlstr = "select mb.merc_id, mb.merc_com_name, mw.merc_web_name, mb.merc_name,  mb.merc_address, mb.merc_omit, mb.merc_city, mb.merc_phone, mb.merc_handset, mb.merc_email, mb.merc_fax, mb.merc_msn,  mb.merc_qq, mb.merc_post,  mb.merc_date, mb.mesh_chap_logo,  mb.merc_from, mb.sys_yn, mb.merc_type, mb.syus_id, mw.merc_url,  mb.merc_state, mb.remark, mb.merc_equip,  mb.comments_cnt, mb.product_cnt,1 cnt  from merchant_baseinfo mb  left join  merchant_webinfo mw  on mb.merc_id=mw.merc_id  where merc_id= " + 
    







      merc_id;
    

    List rec = this.dba.queryData(sqlstr.toString(), url);
    
    this.dba.closeConnection();
    Merchant mc = new Merchant();
    if ((rec != null) && (rec.size() > 0)) {
      mc = (Merchant)rec.get(0);
      mc.setMerc_id(merc_id);
    }
    
    return mc;
  }
}
