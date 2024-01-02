package com.ding9.click.dao.priceinfo;

import com.ding9.click.entity.priceinfo.IActionPriceData;
import com.ding9.click.result.priceinfo.ActionPriceDataResult;
import com.ding9.click.sql.BaseResult;
import com.ding9.click.sql.DBAccessDefaultlImpl;
import com.ding9.click.sql.IDBAccess;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;














public class ActionPriceDaoImpl
  implements ActionPriceDao
{
  private static final Log log = LogFactory.getLog(ActionPriceDaoImpl.class);
  private IDBAccess dba = null;
  private StringBuffer sqlstr = null;
  
  private static HashMap hmprice = null;
  private static long pretime = 0L;
  








  public int getActionPrice(int cooperate_id)
    throws SQLException
  {
    int result = 0;
    
    if (log.isWarnEnabled()) {
      log.warn("cooperate_id : " + cooperate_id);
    }
    
    if (cooperate_id < 1) {
      return -112;
    }
    try
    {
      loadActionPrice();
    } catch (Exception ex) {
      return -109;
    }
    
    if (log.isWarnEnabled()) {
      log.warn("hmprice.size (1) : " + hmprice.size());
    }
    

    if (hmprice != null) {
      try {
        String rr = (String)hmprice.get(String.valueOf(cooperate_id));
        
        if (log.isWarnEnabled()) {
          log.warn("hmprice.get : " + String.valueOf(cooperate_id));
          log.warn("rr : " + rr);
        }
        
        result = Integer.parseInt(rr);
      } catch (Exception ex) {
        result = 0;
      }
    }
    
    return result;
  }
  


  public HashMap getAllActionPrices()
  {
    try
    {
      loadActionPrice();
    }
    catch (Exception localException) {}
    return hmprice;
  }
  


  private void loadActionPrice()
    throws SQLException
  {
    if (log.isWarnEnabled()) {
      log.warn("prepare loadActionPrice ");
    }
    
    if ((hmprice == null) || (System.currentTimeMillis() - pretime > 300000L)) {
      pretime = System.currentTimeMillis();
      
      if (log.isWarnEnabled()) {
        log.warn("begin loadActionPrice ");
      }
      
      getActionPrice();
      
      if (log.isWarnEnabled()) {
        log.warn("loadActionPrice ok");
      }
    }
  }
  
  private void getActionPrice() throws SQLException {
    hmprice = null;
    hmprice = new HashMap();
    
    this.dba = new DBAccessDefaultlImpl();
    BaseResult bldr = new ActionPriceDataResult();
    
    this.sqlstr = new StringBuffer();
    this.sqlstr.append("select cooperate_id, action_price from click_coop_actionprice");
    
    if (log.isWarnEnabled()) {
      log.warn("get default ap : " + this.sqlstr.toString());
    }
    
    List rec = this.dba.queryData(this.sqlstr.toString(), bldr);
    
    if (log.isWarnEnabled()) {
      log.warn("rec.size() : " + rec.size());
    }
    
    if ((rec != null) && 
      (rec.size() > 0)) {
      for (int i = 0; i < rec.size(); i++) {
        IActionPriceData apdata = (IActionPriceData)rec.get(i);
        
        if (log.isWarnEnabled()) {
          log.warn(String.valueOf(apdata.getCooperate_id()) + " : " + String.valueOf(apdata.getAction_price()));
        }
        
        hmprice.put(String.valueOf(apdata.getCooperate_id()), String.valueOf(apdata.getAction_price()));
      }
    }
  }
}
