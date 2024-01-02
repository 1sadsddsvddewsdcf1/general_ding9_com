package com.ding9.click.server;

import com.ding9.click.dao.accesslog.BLAccessLogDao;
import com.ding9.click.dao.accesslog.BLAccessLogDaoImpl;
import com.ding9.click.dao.accesslog.VipBLAccessLogDao;
import com.ding9.click.dao.accesslog.VipBLAccessLogDaoImpl;
import com.ding9.click.dao.baseinfo.BilllineDao;
import com.ding9.click.dao.baseinfo.BilllineDaoImpl;
import com.ding9.click.dao.baseinfo.VipBilllineDao;
import com.ding9.click.dao.baseinfo.VipBilllineDaoImpl;
import com.ding9.click.dao.priceinfo.ActionPriceDao;
import com.ding9.click.dao.priceinfo.ActionPriceDaoImpl;
import com.ding9.click.dao.priceinfo.VipActionPriceDao;
import com.ding9.click.dao.priceinfo.VipActionPriceDaoImpl;
import com.ding9.click.entity.accesslog.IBLAccessLogData;
import com.ding9.click.entity.accesslog.IVipBLAccessLogData;
import com.ding9.click.service.IAccessLogService;
import com.ding9.click.util.security.MD5;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

















public class AccessLogService
  implements IAccessLogService
{
  private static final Log log = LogFactory.getLog(AccessLogService.class);
  














  public int addAccessLog(IBLAccessLogData blaccesslog, String encrypt_str, String key_encrypt_str)
  {
    if ((blaccesslog == null) || (encrypt_str == null) || ("".equals(encrypt_str.trim()))) {
      return -112;
    }
    

    int d_bl_id = blaccesslog.getBl_id();
    int d_vipbl_id = blaccesslog.getVipbl_id();
    int d_cooperate_id = blaccesslog.getCooperate_id();
    String d_remote_addr = blaccesslog.getRemote_addr();
    String d_session_id = blaccesslog.getSession_id();
    

    String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
    
    String compare_encrypt_str = MD5.encode(originaltext);
    

    if ((!compare_encrypt_str.equals(encrypt_str)) || (!encrypt_str.equals(compare_encrypt_str))) {
      return -114;
    }
    




    BLAccessLogDao bald = new BLAccessLogDaoImpl();
    
    int result = 0;
    try
    {
      result = bald.addAccessLog(blaccesslog);
    } catch (Exception ex) {
      ex.printStackTrace();
      result = -109;
    }
    
    return result;
  }
  













  public int addVipAccessLog(IVipBLAccessLogData vipblaccesslog, String encrypt_str, String key_encrypt_str)
  {
    if ((vipblaccesslog == null) || (encrypt_str == null) || ("".equals(encrypt_str.trim()))) {
      return -112;
    }
    

    int d_bl_id = vipblaccesslog.getBl_id();
    int d_vipbl_id = vipblaccesslog.getVipbl_id();
    int d_cooperate_id = vipblaccesslog.getCooperate_id();
    String d_remote_addr = vipblaccesslog.getRemote_addr();
    String d_session_id = vipblaccesslog.getSession_id();
    

    String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
    
    String compare_encrypt_str = MD5.encode(originaltext);
    

    if ((!compare_encrypt_str.equals(encrypt_str)) || (!encrypt_str.equals(compare_encrypt_str))) {
      return -114;
    }
    

    if (log.isWarnEnabled()) {
      log.warn("vipblaccesslog.getIs_payclick() : " + vipblaccesslog.getIs_payclick());
      log.warn("vipblaccesslog.getCooperate_id() : " + vipblaccesslog.getCooperate_id());
    }
    
    if ((vipblaccesslog.getCooperate_id() > 0) && (vipblaccesslog.getIs_payclick() == 1))
    {
      VipActionPriceDao vapdao = new VipActionPriceDaoImpl();
      
      int action_price = 0;
      try {
        action_price = vapdao.getActionPrice(vipblaccesslog.getVipbl_id(), vipblaccesslog.getCooperate_id());
        
        if (log.isWarnEnabled()) {
          log.warn("default action_price : " + action_price);
        }
      } catch (Exception ex) {
        action_price = -1;
      }
      vapdao = null;
      
      if (log.isWarnEnabled()) {
        log.warn("default 2 action_price : " + action_price);
      }
      
      if (action_price < 1)
      {
        ActionPriceDao apdao = new ActionPriceDaoImpl();
        try
        {
          action_price = apdao.getActionPrice(vipblaccesslog.getCooperate_id());
          
          if (log.isWarnEnabled()) {
            log.warn("vip action_price : " + action_price);
          }
        }
        catch (Exception ex) {
          action_price = 0;
        }
        apdao = null;
      }
      
      if (log.isWarnEnabled()) {
        log.warn("vip 2 action_price : " + action_price);
      }
      
      if (action_price > 0) {
        vipblaccesslog.setAction_price(action_price);
      }
    }
    

    VipBLAccessLogDao vbald = new VipBLAccessLogDaoImpl();
    
    if (vbald == null) {
      return -1;
    }
    
    int result = 0;
    try {
      result = vbald.addAccessLog(vipblaccesslog);
    } catch (Exception ex) {
      ex.printStackTrace();
      result = -109;
    }
    
    return result;
  }
  












  public int addVipAccessLog(IVipBLAccessLogData[] datalist)
  {
    IVipBLAccessLogData vipblaccesslog = null;
    for (int i = 0; i < datalist.length; i++) {
      vipblaccesslog = datalist[i];
      
      if ((vipblaccesslog.getCooperate_id() > 0) && (vipblaccesslog.getIs_payclick() == 1))
      {
        VipActionPriceDao vapdao = new VipActionPriceDaoImpl();
        
        int action_price = 0;
        try {
          action_price = vapdao.getActionPrice(vipblaccesslog.getVipbl_id(), vipblaccesslog.getCooperate_id());
          
          if (log.isWarnEnabled()) {
            log.warn("default action_price : " + action_price);
          }
        } catch (Exception ex) {
          action_price = -1;
        }
        vapdao = null;
        
        if (log.isWarnEnabled()) {
          log.warn("default 2 action_price : " + action_price);
        }
        
        if (action_price < 1)
        {
          ActionPriceDao apdao = new ActionPriceDaoImpl();
          try
          {
            action_price = apdao.getActionPrice(vipblaccesslog.getCooperate_id());
            
            if (log.isWarnEnabled()) {
              log.warn("vip action_price : " + action_price);
            }
          }
          catch (Exception ex) {
            action_price = 0;
          }
          apdao = null;
        }
        
        if (log.isWarnEnabled()) {
          log.warn("vip 2 action_price : " + action_price);
        }
        
        if (action_price > 0) {
          vipblaccesslog.setAction_price(action_price);
        }
      }
      datalist[i] = vipblaccesslog;
    }
    
    VipBLAccessLogDao vbald = new VipBLAccessLogDaoImpl();
    
    if (vbald == null) {
      return -1;
    }
    
    int result = 0;
    try {
      result = vbald.addAccessLog(datalist);
    } catch (Exception ex) {
      ex.printStackTrace();
      result = -109;
    }
    
    return result;
  }
  








  public HashMap getBLCodes(int bl_id, String encrypt_str, String key_encrypt_str)
  {
    if ((bl_id < 1) || (encrypt_str == null) || ("".equals(encrypt_str.trim()))) {
      return null;
    }
    

    String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(bl_id);
    
    String compare_encrypt_str = MD5.encode(originaltext);
    

    if ((!compare_encrypt_str.equals(encrypt_str)) || (!encrypt_str.equals(compare_encrypt_str))) {
      return null;
    }
    



    HashMap result = null;
    BilllineDao bld = new BilllineDaoImpl();
    
    result = bld.getBLCodes();
    
    return result;
  }
  








  public HashMap getVipBLCodes(int vipbl_id, String encrypt_str, String key_encrypt_str)
  {
    if ((vipbl_id < 1) || (encrypt_str == null) || ("".equals(encrypt_str.trim()))) {
      return null;
    }
    

    String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(vipbl_id);
    
    String compare_encrypt_str = MD5.encode(originaltext);
    

    if ((!compare_encrypt_str.equals(encrypt_str)) || (!encrypt_str.equals(compare_encrypt_str))) {
      return null;
    }
    



    HashMap result = null;
    VipBilllineDao vbld = new VipBilllineDaoImpl();
    
    result = vbld.getVipBLCodes();
    
    return result;
  }
  



  public HashMap getVipAllPrices()
  {
    HashMap result = null;
    
    VipActionPriceDao vapdao = new VipActionPriceDaoImpl();
    result = vapdao.getAllActionPrices();
    return result;
  }
}
