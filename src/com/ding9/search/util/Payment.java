package com.ding9.search.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.util.LabelValueBean;

















public class Payment
{
  private ArrayList numbers = null;
  
  public Payment() {
    this.numbers = new ArrayList();
    this.numbers.add(new LabelValueBean("货到付款", "231101"));
    this.numbers.add(new LabelValueBean("邮政汇款", "211101"));
    this.numbers.add(new LabelValueBean("银行汇款", "221101"));
    
    this.numbers.add(new LabelValueBean("云网支付", "242001"));
    this.numbers.add(new LabelValueBean("网银在线", "911601"));
    this.numbers.add(new LabelValueBean("工行网上支付", "241101"));
    
    this.numbers.add(new LabelValueBean("易达信动", "911701"));
    this.numbers.add(new LabelValueBean("和讯支付", "911801"));
    this.numbers.add(new LabelValueBean("建行网上支付", "241201"));
    
    this.numbers.add(new LabelValueBean("环讯IPS/i付通", "241601"));
    

    this.numbers.add(new LabelValueBean("招行一卡通", "241501"));
    this.numbers.add(new LabelValueBean("首信易支付", "241701"));
    
    this.numbers.add(new LabelValueBean("支付宝", "911101"));
    this.numbers.add(new LabelValueBean("财付通支付", "911201"));
    this.numbers.add(new LabelValueBean("银联电子支付(ChinaPay))", "241801"));
    
    this.numbers.add(new LabelValueBean("YeePay易宝", "911301"));
    this.numbers.add(new LabelValueBean("网汇通支付", "911401"));
    this.numbers.add(new LabelValueBean("百付通支付", "911501"));
    
    this.numbers.add(new LabelValueBean("快钱", "241901"));
  }
  
  public ArrayList getNumbers() {
    return this.numbers;
  }
  
  public String[] getPayment(String payment)
  {
    List list = getNumbers();
    String[] rs = (String[])null;
    if ((payment != null) && (!"".equals(payment))) {
      String[] chinese = payment.split(",");
      rs = new String[chinese.length];
      for (int i = 0; i < list.size(); i++) {
        LabelValueBean vo = (LabelValueBean)list.get(i);
        String value = vo.getValue();
        
        for (int j = 0; j < chinese.length; j++) {
          if (value.equals(chinese[j])) {
            rs[j] = vo.getLabel();
          }
        }
      }
    }
    
    return rs;
  }
}
