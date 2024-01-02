package com.ding9.click.dao.baseinfo;

import com.ding9.click.entity.baseinfo.IVipBilllineData;
import com.ding9.click.result.baseinfo.BilllineDataResult;
import com.ding9.click.sql.BaseResult;
import com.ding9.click.sql.DBAccessDefaultlImpl;
import com.ding9.click.sql.IDBAccess;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;













public class VipBilllineDaoImpl
  implements VipBilllineDao
{
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  
  private static HashMap hmblcode = null;
  private static long pretime = 0L;
  








  public int validateVipBlCode(int vipbl_id)
    throws SQLException
  {
    int result = 0;
    
    if (vipbl_id < 1) {
      return -112;
    }
    try
    {
      loadVipBLCode();
    } catch (Exception ex) {
      return -109;
    }
    
    if (hmblcode != null) {
      try {
        String rr = (String)hmblcode.get(String.valueOf(vipbl_id));
        if (String.valueOf(vipbl_id).equals(rr)) {
          result = vipbl_id;
        }
      } catch (Exception ex) {
        result = -106;
      }
    }
    
    return result;
  }
  


  public HashMap getVipBLCodes()
  {
    try
    {
      loadVipBLCode();
    }
    catch (Exception localException) {}
    return hmblcode;
  }
  


  private void loadVipBLCode()
    throws SQLException
  {
    if ((hmblcode == null) || (System.currentTimeMillis() - pretime > 300000L)) {
      pretime = System.currentTimeMillis();
      
      getVipBLCode();
    }
  }
  
  private void getVipBLCode() throws SQLException {
    hmblcode = null;
    hmblcode = new HashMap();
    
    this.dba = new DBAccessDefaultlImpl();
    BaseResult bldr = new BilllineDataResult();
    
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("select vipbl_id from click_vipbillline_base_info where vipbl_status=2");
    
    List rec = this.dba.queryData(this.sqlstr.toString(), bldr);
    
    if ((rec != null) && 
      (rec.size() > 0)) {
      for (int i = 0; i < rec.size(); i++) {
        IVipBilllineData bldata = (IVipBilllineData)rec.get(i);
        
        hmblcode.put(String.valueOf(bldata.getVipbl_id()), String.valueOf(bldata.getVipbl_id()));
      }
    }
  }
}
