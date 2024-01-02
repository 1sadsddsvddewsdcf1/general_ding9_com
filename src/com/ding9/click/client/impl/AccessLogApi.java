package com.ding9.click.client.impl;

import com.ding9.click.beans.AccessLogDataHelper;
import com.ding9.click.client.IAccessLogApi;
import com.ding9.click.entity.accesslog.IBLAccessLogData;
import com.ding9.click.entity.accesslog.IVipBLAccessLogData;
import com.ding9.click.entity.accesslog.impl.BLAccessLogData;
import com.ding9.click.entity.accesslog.impl.VipBLAccessLogData;
import com.ding9.click.server.AccessLogService;
import com.ding9.click.service.IAccessLogService;
import com.ding9.click.util.ConfigManager;
import com.ding9.click.util.security.MD5;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;






















public class AccessLogApi
  implements IAccessLogApi
{
  private static HashMap hmblcode = null;
  private static long bl_pretime = 0L;
  private static HashMap hmvipblcode = null;
  private static long vipbl_pretime = 0L;
  






  public static final String SSON_COOKIE_NAME = "DING9_SSONKEY_CLICK";
  





  private int timeout = 7200;
  



  private int refreshtime = 3600;
  



  private String serverhost = "";
  



  private int bl_id = 0;
  



  private int vipbl_id = 0;
  


  public AccessLogApi()
  {
    initData();
  }
  

  private void initData()
  {
    try
    {
      this.timeout = Integer.parseInt(ConfigManager.getProperty("COOKIE_TIMEOUT"));
    } catch (Exception localException) {}
    try {
      this.refreshtime = Integer.parseInt(ConfigManager.getProperty("COOKIE_REFRESHTIME"));
    } catch (Exception localException1) {}
    try {
      this.serverhost = String.valueOf(ConfigManager.getProperty("SERVER_HOST"));
    } catch (Exception localException2) {}
    try {
      this.bl_id = Integer.parseInt(ConfigManager.getProperty("BILLLINE_ID"));
    } catch (Exception localException3) {}
    try {
      this.vipbl_id = Integer.parseInt(ConfigManager.getProperty("VIPBILLLINE_ID"));
    }
    catch (Exception localException4) {}
    if (this.refreshtime >= this.timeout) {
      this.refreshtime = (this.timeout / 2);
    }
  }
  











  public int addAccessLogInfo(HttpServletRequest request, HttpServletResponse response)
  {
    return addAccessLogInfo(this.bl_id, request, response);
  }
  
























  public int addAccessLogInfo(int billline_id, HttpServletRequest request, HttpServletResponse response)
  {
    int result = -106;
    try {
      IBLAccessLogData accesslog = new BLAccessLogData();
      
      AccessLogDataHelper aldhelper = new AccessLogDataHelper(request, response);
      

      accesslog = aldhelper.initAccessLogData(billline_id, this.vipbl_id, accesslog, request);
      


      result = validateSEVister(accesslog);
      if (result != 1) {
        return result;
      }
      


      Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
      
      XFire xfire = XFireFactory.newInstance().getXFire();
      XFireProxyFactory factory = new XFireProxyFactory(xfire);
      
      String serviceUrl = null;
      serviceUrl = this.serverhost + "AccessLogService";
      
      IAccessLogService accesslogservice = null;
      try
      {
        accesslogservice = (IAccessLogService)factory.create(serviceModel, serviceUrl);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      

      int d_bl_id = accesslog.getBl_id();
      int d_vipbl_id = accesslog.getVipbl_id();
      int d_cooperate_id = accesslog.getCooperate_id();
      String d_remote_addr = accesslog.getRemote_addr();
      String d_session_id = accesslog.getSession_id();
      

      String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
      
      String encrypt_str = MD5.encode(originaltext);
      
      result = accesslogservice.addAccessLog(accesslog, encrypt_str, "");
    } catch (Exception ex) {
      result = -109;
    }
    
    return result;
  }
  















  public int addVipAccessLogInfo(int vipbillline_id, boolean is_payclick, HttpServletRequest request, HttpServletResponse response)
  {
    return addVipAccessLogInfo(this.bl_id, vipbillline_id, is_payclick, request, response);
  }
  































  public int addVipAdvAccessLogInfo(int billline_id, int vipbillline_id, int adad_id, String type, boolean is_payclick, HttpServletRequest request, HttpServletResponse response)
  {
    int result = -106;
    try
    {
      IVipBLAccessLogData vipaccesslog = new VipBLAccessLogData();
      
      AccessLogDataHelper aldhelper = new AccessLogDataHelper(request, response);
      

      vipaccesslog = aldhelper.initVipAccessLogData(billline_id, vipbillline_id, is_payclick, vipaccesslog, request);
      vipaccesslog.setAdad_id(adad_id);
      vipaccesslog.setAdv_id(0);
      vipaccesslog.setType(type);
      
      result = validateSEVister(vipaccesslog);
      if (result != 1) {
        return result;
      }
      


      Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
      
      XFire xfire = XFireFactory.newInstance().getXFire();
      XFireProxyFactory factory = new XFireProxyFactory(xfire);
      
      String serviceUrl = null;
      serviceUrl = this.serverhost + "AccessLogService";
      IAccessLogService accesslogservice = null;
      try
      {
        accesslogservice = new AccessLogService();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      

      int d_bl_id = vipaccesslog.getBl_id();
      int d_vipbl_id = vipaccesslog.getVipbl_id();
      int d_cooperate_id = vipaccesslog.getCooperate_id();
      String d_remote_addr = vipaccesslog.getRemote_addr();
      String d_session_id = vipaccesslog.getSession_id();
      

      String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
      
      String encrypt_str = MD5.encode(originaltext);
      
      result = accesslogservice.addVipAccessLog(vipaccesslog, encrypt_str, "");
    } catch (Exception ex) {
      result = -109;
    }
    

    return result;
  }
  































  public int addVipD9senseAccessLogInfo(int billline_id, int vipbillline_id, int adv_id, String type, boolean is_payclick, HttpServletRequest request, HttpServletResponse response)
  {
    int result = -106;
    try
    {
      IVipBLAccessLogData vipaccesslog = new VipBLAccessLogData();
      
      AccessLogDataHelper aldhelper = new AccessLogDataHelper(request, response);
      

      vipaccesslog = aldhelper.initVipAccessLogData(billline_id, vipbillline_id, is_payclick, vipaccesslog, request);
      vipaccesslog.setAdv_id(adv_id);
      vipaccesslog.setType(type);
      
      result = validateSEVister(vipaccesslog);
      if (result != 1) {
        return result;
      }
      


      Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
      
      XFire xfire = XFireFactory.newInstance().getXFire();
      XFireProxyFactory factory = new XFireProxyFactory(xfire);
      
      String serviceUrl = null;
      serviceUrl = this.serverhost + "AccessLogService";
      
      IAccessLogService accesslogservice = null;
      try
      {
        accesslogservice = new AccessLogService();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      

      int d_bl_id = vipaccesslog.getBl_id();
      int d_vipbl_id = vipaccesslog.getVipbl_id();
      int d_cooperate_id = vipaccesslog.getCooperate_id();
      String d_remote_addr = vipaccesslog.getRemote_addr();
      String d_session_id = vipaccesslog.getSession_id();
      

      String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
      
      String encrypt_str = MD5.encode(originaltext);
      
      result = accesslogservice.addVipAccessLog(vipaccesslog, encrypt_str, "");
    } catch (Exception ex) {
      result = -109;
    }
    

    return result;
  }
  


































  public int addVipGoGoAccessLogInfo(int billline_id, int vipbillline_id, int merc_id, int mepr_id, int prma_id, String type, String target_url, String jump_url, boolean is_payclick, HttpServletRequest request, HttpServletResponse response)
  {
    int result = -106;
    try
    {
      IVipBLAccessLogData vipaccesslog = new VipBLAccessLogData();
      
      AccessLogDataHelper aldhelper = new AccessLogDataHelper(request, response);
      

      vipaccesslog = aldhelper.initVipAccessLogData(billline_id, vipbillline_id, is_payclick, vipaccesslog, request);
      
      vipaccesslog.setType(type);
      vipaccesslog.setMerc_id(merc_id);
      vipaccesslog.setMepr_id(mepr_id);
      vipaccesslog.setPrma_id(prma_id);
      vipaccesslog.setTarget_url(target_url);
      vipaccesslog.setJump_url(jump_url);
      
      result = validateSEVister(vipaccesslog);
      if (result != 1) {
        return result;
      }
      


      Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
      
      XFire xfire = XFireFactory.newInstance().getXFire();
      XFireProxyFactory factory = new XFireProxyFactory(xfire);
      
      String serviceUrl = null;
      serviceUrl = this.serverhost + "AccessLogService";
      
      IAccessLogService accesslogservice = null;
      try
      {
        accesslogservice = new AccessLogService();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      

      int d_bl_id = vipaccesslog.getBl_id();
      int d_vipbl_id = vipaccesslog.getVipbl_id();
      int d_cooperate_id = vipaccesslog.getCooperate_id();
      String d_remote_addr = vipaccesslog.getRemote_addr();
      String d_session_id = vipaccesslog.getSession_id();
      

      String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
      
      String encrypt_str = MD5.encode(originaltext);
      
      result = accesslogservice.addVipAccessLog(vipaccesslog, encrypt_str, "");
    } catch (Exception ex) {
      result = -109;
    }
    
    return result;
  }
  




























  public int addVipAccessLogInfo(int billline_id, int vipbillline_id, boolean is_payclick, HttpServletRequest request, HttpServletResponse response)
  {
    int result = -106;
    try
    {
      IVipBLAccessLogData vipaccesslog = new VipBLAccessLogData();
      
      AccessLogDataHelper aldhelper = new AccessLogDataHelper(request, response);
      

      vipaccesslog = aldhelper.initVipAccessLogData(billline_id, vipbillline_id, is_payclick, vipaccesslog, request);
      

      result = validateSEVister(vipaccesslog);
      if (result != 1) {
        return result;
      }
      


      Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
      
      XFire xfire = XFireFactory.newInstance().getXFire();
      XFireProxyFactory factory = new XFireProxyFactory(xfire);
      
      String serviceUrl = null;
      serviceUrl = this.serverhost + "AccessLogService";
      
      IAccessLogService accesslogservice = null;
      try
      {
        accesslogservice = new AccessLogService();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      

      int d_bl_id = vipaccesslog.getBl_id();
      int d_vipbl_id = vipaccesslog.getVipbl_id();
      int d_cooperate_id = vipaccesslog.getCooperate_id();
      String d_remote_addr = vipaccesslog.getRemote_addr();
      String d_session_id = vipaccesslog.getSession_id();
      

      String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
      
      String encrypt_str = MD5.encode(originaltext);
      
      result = accesslogservice.addVipAccessLog(vipaccesslog, encrypt_str, "");
    } catch (Exception ex) {
      ex.printStackTrace();
      result = -109;
    }
    return result;
  }
  






























  public int addVipAccessLogInfo(int billline_id, int vipbillline_id, boolean is_payclick, int prma_id, int prso_id_one, int prso_id_two, int prso_id_three, String type, HttpServletRequest request, HttpServletResponse response)
  {
    int result = -106;
    try
    {
      IVipBLAccessLogData vipaccesslog = new VipBLAccessLogData();
      
      AccessLogDataHelper aldhelper = new AccessLogDataHelper(request, response);
      

      vipaccesslog = aldhelper.initVipAccessLogData(billline_id, vipbillline_id, is_payclick, vipaccesslog, request);
      
      vipaccesslog.setPrma_id(prma_id);
      vipaccesslog.setPrso_id_one(prso_id_one);
      vipaccesslog.setPrso_id_two(prso_id_two);
      vipaccesslog.setPrso_id_three(prso_id_three);
      vipaccesslog.setType(type);
      
      result = validateSEVister(vipaccesslog);
      if (result != 1) {
        return result;
      }
      


      Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
      
      XFire xfire = XFireFactory.newInstance().getXFire();
      XFireProxyFactory factory = new XFireProxyFactory(xfire);
      
      String serviceUrl = null;
      serviceUrl = this.serverhost + "AccessLogService";
      
      IAccessLogService accesslogservice = null;
      try
      {
        accesslogservice = new AccessLogService();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      

      int d_bl_id = vipaccesslog.getBl_id();
      int d_vipbl_id = vipaccesslog.getVipbl_id();
      int d_cooperate_id = vipaccesslog.getCooperate_id();
      String d_remote_addr = vipaccesslog.getRemote_addr();
      String d_session_id = vipaccesslog.getSession_id();
      

      String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
      
      String encrypt_str = MD5.encode(originaltext);
      
      result = accesslogservice.addVipAccessLog(vipaccesslog, encrypt_str, "");
    } catch (Exception ex) {
      result = -109;
    }
    return result;
  }
  
















  public int addVipAccessLogInfo(Map map, HttpServletRequest request, HttpServletResponse response)
  {
    int billline_id = 0;
    int vipbillline_id = 0;
    int action_price = 0;
    int prma_id = 0;
    int prso_id_one = 0;
    int prso_id_two = 0;
    int prso_id_three = 0;
    String type = "";
    int adad_id = 0;
    int adv_id = 0;
    int merc_id = 0;
    int mepr_id = 0;
    String target_url = "";
    String jump_url = "";
    boolean is_payclick = false;
    try {
      if ((map.get("billline_id") != null) && (!map.get("billline_id").toString().equals(""))) {
        billline_id = Integer.parseInt(map.get("billline_id").toString());
      }
      if ((map.get("vipbillline_id") != null) && (!map.get("vipbillline_id").toString().equals(""))) {
        vipbillline_id = Integer.parseInt(map.get("vipbillline_id").toString());
      }
      if ((map.get("adad_id") != null) && (!map.get("adad_id").toString().equals(""))) {
        adad_id = Integer.parseInt(map.get("adad_id").toString());
      }
      if ((map.get("type") != null) && (!map.get("type").toString().equals(""))) {
        type = map.get("type").toString();
      }
      if ((map.get("action_price") != null) && (!map.get("action_price").toString().equals(""))) {
        action_price = Integer.parseInt(map.get("adad_id").toString());
      }
      if ((map.get("prma_id") != null) && (!map.get("prma_id").toString().equals(""))) {
        prma_id = Integer.parseInt(map.get("prma_id").toString());
      }
      if ((map.get("prso_id_one") != null) && (!map.get("prso_id_one").toString().equals(""))) {
        prso_id_one = Integer.parseInt(map.get("prso_id_one").toString());
      }
      if ((map.get("prso_id_two") != null) && (!map.get("prso_id_two").toString().equals(""))) {
        prso_id_two = Integer.parseInt(map.get("prso_id_two").toString());
      }
      if ((map.get("prso_id_three") != null) && (!map.get("prso_id_three").toString().equals(""))) {
        prso_id_three = Integer.parseInt(map.get("prso_id_three").toString());
      }
      if ((map.get("adv_id") != null) && (!map.get("adv_id").toString().equals(""))) {
        adv_id = Integer.parseInt(map.get("adv_id").toString());
      }
      if ((map.get("merc_id") != null) && (!map.get("merc_id").toString().equals(""))) {
        merc_id = Integer.parseInt(map.get("merc_id").toString());
      }
      if ((map.get("mepr_id") != null) && (!map.get("mepr_id").toString().equals(""))) {
        mepr_id = Integer.parseInt(map.get("mepr_id").toString());
      }
      if ((map.get("target_url") != null) && (!map.get("target_url").toString().equals(""))) {
        target_url = map.get("target_url").toString();
      }
      if ((map.get("jump_url") != null) && (!map.get("jump_url").toString().equals(""))) {
        jump_url = map.get("jump_url").toString();
      }
      if ((map.get("is_payclick") != null) && (map.get("is_payclick").toString().equals("true")))
        is_payclick = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    









    int result = -106;
    try
    {
      IVipBLAccessLogData vipaccesslog = new VipBLAccessLogData();
      
      AccessLogDataHelper aldhelper = new AccessLogDataHelper(request, response);
      

      vipaccesslog = aldhelper.initVipAccessLogData(billline_id, vipbillline_id, is_payclick, vipaccesslog, request);
      vipaccesslog.setAction_price(action_price);
      vipaccesslog.setPrma_id(prma_id);
      vipaccesslog.setPrso_id_one(prso_id_one);
      vipaccesslog.setPrso_id_two(prso_id_two);
      vipaccesslog.setPrso_id_three(prso_id_three);
      vipaccesslog.setType(type);
      vipaccesslog.setAdad_id(adad_id);
      vipaccesslog.setAdv_id(adv_id);
      vipaccesslog.setMerc_id(merc_id);
      vipaccesslog.setMepr_id(mepr_id);
      vipaccesslog.setTarget_url(target_url);
      vipaccesslog.setJump_url(jump_url);
      
      result = validateSEVister(vipaccesslog);
      if (result != 1) {
        return result;
      }
      

      Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
      XFire xfire = XFireFactory.newInstance().getXFire();
      XFireProxyFactory factory = new XFireProxyFactory(xfire);
      
      String serviceUrl = null;
      serviceUrl = this.serverhost + "AccessLogService";
      IAccessLogService accesslogservice = null;
      try
      {
        accesslogservice = new AccessLogService();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      

      int d_bl_id = vipaccesslog.getBl_id();
      int d_vipbl_id = vipaccesslog.getVipbl_id();
      int d_cooperate_id = vipaccesslog.getCooperate_id();
      String d_remote_addr = vipaccesslog.getRemote_addr();
      String d_session_id = vipaccesslog.getSession_id();
      

      String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(d_bl_id) + String.valueOf(d_vipbl_id) + String.valueOf(d_cooperate_id) + d_remote_addr + d_session_id;
      
      String encrypt_str = MD5.encode(originaltext);
      
      result = accesslogservice.addVipAccessLog(vipaccesslog, encrypt_str, "");
    } catch (Exception ex) {
      result = -109;
    }
    

    return result;
  }
  
















  public int addVipAccessLogInfo(List list, HttpServletRequest request, HttpServletResponse response)
  {
    int billline_id = 0;
    int vipbillline_id = 0;
    int action_price = 0;
    int prma_id = 0;
    int prso_id_one = 0;
    int prso_id_two = 0;
    int prso_id_three = 0;
    String type = "";
    int adad_id = 0;
    int adv_id = 0;
    int merc_id = 0;
    int mepr_id = 0;
    String target_url = "";
    String jump_url = "";
    boolean is_payclick = false;
    int result = -106;
    
    IVipBLAccessLogData[] data = new IVipBLAccessLogData[list.size()];
    for (int i = 0; i < list.size(); i++) {
      try {
        Map map = (Map)list.get(i);
        if ((map.get("billline_id") != null) && (!map.get("billline_id").toString().equals(""))) {
          billline_id = Integer.parseInt(map.get("billline_id").toString());
        }
        if ((map.get("vipbillline_id") != null) && (!map.get("vipbillline_id").toString().equals(""))) {
          vipbillline_id = Integer.parseInt(map.get("vipbillline_id").toString());
        }
        if ((map.get("adad_id") != null) && (!map.get("adad_id").toString().equals(""))) {
          adad_id = Integer.parseInt(map.get("adad_id").toString());
        }
        if ((map.get("type") != null) && (!map.get("type").toString().equals(""))) {
          type = map.get("type").toString();
        }
        if ((map.get("action_price") != null) && (!map.get("action_price").toString().equals(""))) {
          action_price = Integer.parseInt(map.get("adad_id").toString());
        }
        if ((map.get("prma_id") != null) && (!map.get("prma_id").toString().equals(""))) {
          prma_id = Integer.parseInt(map.get("prma_id").toString());
        }
        if ((map.get("prso_id_one") != null) && (!map.get("prso_id_one").toString().equals(""))) {
          prso_id_one = Integer.parseInt(map.get("prso_id_one").toString());
        }
        if ((map.get("prso_id_two") != null) && (!map.get("prso_id_two").toString().equals(""))) {
          prso_id_two = Integer.parseInt(map.get("prso_id_two").toString());
        }
        if ((map.get("prso_id_three") != null) && (!map.get("prso_id_three").toString().equals(""))) {
          prso_id_three = Integer.parseInt(map.get("prso_id_three").toString());
        }
        if ((map.get("adv_id") != null) && (!map.get("adv_id").toString().equals(""))) {
          adv_id = Integer.parseInt(map.get("adv_id").toString());
        }
        if ((map.get("merc_id") != null) && (!map.get("merc_id").toString().equals(""))) {
          merc_id = Integer.parseInt(map.get("merc_id").toString());
        }
        if ((map.get("mepr_id") != null) && (!map.get("mepr_id").toString().equals(""))) {
          mepr_id = Integer.parseInt(map.get("mepr_id").toString());
        }
        if ((map.get("target_url") != null) && (!map.get("target_url").toString().equals(""))) {
          target_url = map.get("target_url").toString();
        }
        if ((map.get("jump_url") != null) && (!map.get("jump_url").toString().equals(""))) {
          jump_url = map.get("jump_url").toString();
        }
        if ((map.get("is_payclick") != null) && (map.get("is_payclick").toString().equals("true")))
          is_payclick = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
      IVipBLAccessLogData vipaccesslog = new VipBLAccessLogData();
      
      AccessLogDataHelper aldhelper = new AccessLogDataHelper(request, response);
      

      vipaccesslog = aldhelper.initVipAccessLogData(billline_id, vipbillline_id, is_payclick, vipaccesslog, request);
      vipaccesslog.setAction_price(action_price);
      vipaccesslog.setPrma_id(prma_id);
      vipaccesslog.setPrso_id_one(prso_id_one);
      vipaccesslog.setPrso_id_two(prso_id_two);
      vipaccesslog.setPrso_id_three(prso_id_three);
      vipaccesslog.setType(type);
      vipaccesslog.setAdad_id(adad_id);
      vipaccesslog.setAdv_id(adv_id);
      vipaccesslog.setMerc_id(merc_id);
      vipaccesslog.setMepr_id(mepr_id);
      vipaccesslog.setTarget_url(target_url);
      vipaccesslog.setJump_url(jump_url);
      





      data[i] = vipaccesslog;
    }
    try
    {
      Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
      XFire xfire = XFireFactory.newInstance().getXFire();
      XFireProxyFactory factory = new XFireProxyFactory(xfire);
      
      String serviceUrl = null;
      serviceUrl = this.serverhost + "AccessLogService";
      IAccessLogService accesslogservice = null;
      try {
        accesslogservice = new AccessLogService();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      
      result = accesslogservice.addVipAccessLog(data);
    } catch (Exception ex) {
      result = -109;
      ex.printStackTrace();
    }
    
    return result;
  }
  








  private int validateBlCode(int billline_id)
  {
    int result = 0;
    
    if (billline_id < 1) {
      return -112;
    }
    try
    {
      loadBLCodes(billline_id);
    } catch (Exception ex) {
      return -109;
    }
    
    if (hmblcode != null) {
      try {
        String rr = (String)hmblcode.get(String.valueOf(billline_id));
        if (String.valueOf(billline_id).equals(rr)) {
          result = billline_id;
        }
      } catch (Exception ex) {
        result = -106;
      }
    }
    
    return result;
  }
  



  private void loadBLCodes(int billline_id)
  {
    if ((hmblcode == null) || (System.currentTimeMillis() - bl_pretime > 300000L)) {
      bl_pretime = System.currentTimeMillis();
      
      getBLCodes(billline_id);
    }
  }
  



  private void getBLCodes(int billline_id)
  {
    hmblcode = null;
    hmblcode = new HashMap();
    


    Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
    
    XFire xfire = XFireFactory.newInstance().getXFire();
    XFireProxyFactory factory = new XFireProxyFactory(xfire);
    
    String serviceUrl = null;
    serviceUrl = this.serverhost + "AccessLogService";
    
    IAccessLogService accesslogservice = null;
    try
    {
      accesslogservice = (IAccessLogService)factory.create(serviceModel, serviceUrl);
    } catch (MalformedURLException ex) {
      ex.printStackTrace();
    }
    


    String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(billline_id);
    
    String encrypt_str = MD5.encode(originaltext);
    

    hmblcode = accesslogservice.getBLCodes(billline_id, encrypt_str, "");
  }
  









  private int validateVipBlCode(int vipbillline_id)
  {
    int result = 0;
    
    if (vipbillline_id < 1) {
      return -112;
    }
    try
    {
      loadVipBLCodes(vipbillline_id);
    } catch (Exception ex) {
      return -109;
    }
    
    if (hmvipblcode != null) {
      try {
        String rr = (String)hmvipblcode.get(String.valueOf(vipbillline_id));
        if (String.valueOf(vipbillline_id).equals(rr)) {
          result = vipbillline_id;
        }
      } catch (Exception ex) {
        result = -106;
      }
    }
    
    return result;
  }
  



  private void loadVipBLCodes(int vipbillline_id)
  {
    if ((hmvipblcode == null) || (System.currentTimeMillis() - vipbl_pretime > 300000L)) {
      vipbl_pretime = System.currentTimeMillis();
      
      getVipBLCodes(vipbillline_id);
    }
  }
  



  private void getVipBLCodes(int vipbillline_id)
  {
    hmvipblcode = null;
    hmvipblcode = new HashMap();
    


    Service serviceModel = new ObjectServiceFactory().create(IAccessLogService.class);
    
    XFire xfire = XFireFactory.newInstance().getXFire();
    XFireProxyFactory factory = new XFireProxyFactory(xfire);
    
    String serviceUrl = null;
    serviceUrl = this.serverhost + "AccessLogService";
    
    IAccessLogService accesslogservice = null;
    try
    {
      accesslogservice = (IAccessLogService)factory.create(serviceModel, serviceUrl);
    } catch (MalformedURLException ex) {
      ex.printStackTrace();
    }
    


    String originaltext = "ding9%@)KEVIN!*NO1veryGOOD" + String.valueOf(vipbillline_id);
    
    String encrypt_str = MD5.encode(originaltext);
    

    hmvipblcode = accesslogservice.getVipBLCodes(vipbillline_id, encrypt_str, "");
  }
  






  private int validateSEVister(IBLAccessLogData blaccesslog)
  {
    int result = 1;
    

    if (("".equals(blaccesslog.getSession_id())) && ("".equals(blaccesslog.getCookie_id()))) {
      result = -116;
      return result;
    }
    

    if (validateUserAgent(blaccesslog.getUser_agent())) {
      result = -116;
      return result;
    }
    
    return result;
  }
  






  private int validateSEVister(IVipBLAccessLogData vipblaccesslog)
  {
    int result = 1;
    

    if (("".equals(vipblaccesslog.getSession_id())) && ("".equals(vipblaccesslog.getCookie_id()))) {
      result = -116;
    }
    

    if (validateUserAgent(vipblaccesslog.getUser_agent())) {
      result = -116;
      return result;
    }
    

    return result;
  }
  






  private boolean validateUserAgent(String user_agent)
  {
    boolean result = false;
    

    user_agent = user_agent == null ? "" : user_agent.trim().toLowerCase();
    

    if (user_agent.indexOf(".html") > -1) {
      return true;
    }
    if (user_agent.indexOf(".htm") > -1) {
      return true;
    }
    

    if (user_agent.indexOf("yahoo") > -1) {
      return true;
    }
    

    if (user_agent.indexOf("google") > -1) {
      return true;
    }
    

    if (user_agent.indexOf("sogou") > -1) {
      return true;
    }
    

    if (user_agent.indexOf("bot") > -1) {
      return true;
    }
    
    return result;
  }
}
