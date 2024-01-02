package com.ding9.click.dao.baseinfo;

import com.ding9.click.entity.baseinfo.IBilllineData;
import com.ding9.click.result.baseinfo.BilllineDataResult;
import com.ding9.click.sql.BaseResult;
import com.ding9.click.sql.DBAccessDefaultlImpl;
import com.ding9.click.sql.IDBAccess;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;













public class BilllineDaoImpl
  implements BilllineDao
{
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  
  private static HashMap hmblcode = null;
  private static long pretime = 0L;
  








  public int validateBlCode(int bl_id)
    throws SQLException
  {
    int result = 0;
    
    if (bl_id < 1) {
      return -112;
    }
    try
    {
      loadBLCode();
    } catch (Exception ex) {
      return -109;
    }
    
    if (hmblcode != null) {
      try {
        String rr = (String)hmblcode.get(String.valueOf(bl_id));
        if (String.valueOf(bl_id).equals(rr)) {
          result = bl_id;
        }
      } catch (Exception ex) {
        result = -106;
      }
    }
    
    return result;
  }
  


  public HashMap getBLCodes()
  {
    try
    {
      loadBLCode();
    }
    catch (Exception localException) {}
    return hmblcode;
  }
  


  private void loadBLCode()
    throws SQLException
  {
    if ((hmblcode == null) || (System.currentTimeMillis() - pretime > 300000L)) {
      pretime = System.currentTimeMillis();
      
      getBLCode();
    }
  }
  
  private void getBLCode() throws SQLException {
    hmblcode = null;
    hmblcode = new HashMap();
    
    this.dba = new DBAccessDefaultlImpl();
    BaseResult bldr = new BilllineDataResult();
    
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("select bl_id from click_billline_base_info where bl_status=2");
    
    List rec = this.dba.queryData(this.sqlstr.toString(), bldr);
    
    if ((rec != null) && 
      (rec.size() > 0)) {
      for (int i = 0; i < rec.size(); i++) {
        IBilllineData bldata = (IBilllineData)rec.get(i);
        

        hmblcode.put(String.valueOf(bldata.getBl_id()), String.valueOf(bldata.getBl_id()));
      }
    }
  }
}
