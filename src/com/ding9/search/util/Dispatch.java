package com.ding9.search.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.util.LabelValueBean;





















public class Dispatch
{
  private ArrayList numbers = null;
  
  public Dispatch() {
    this.numbers = new ArrayList();
    this.numbers.add(new LabelValueBean("中国邮政平邮", "1"));
    this.numbers.add(new LabelValueBean("中国邮政挂号信件", "2"));
    this.numbers.add(new LabelValueBean("中国邮政普通包裹", "3"));
    
    this.numbers.add(new LabelValueBean("中国邮政快递包裹", "4"));
    this.numbers.add(new LabelValueBean("中国邮政特快专递(EMS)", "5"));
    this.numbers.add(new LabelValueBean("快递公司", "6"));
    this.numbers.add(new LabelValueBean("消费者上门自提", "7"));
    this.numbers.add(new LabelValueBean("送货上门", "8"));
  }
  
  public ArrayList getNumbers() {
    return this.numbers;
  }
  
  public String[] getEquip(String equip) {
    String[] rs = (String[])null;
    List list = getNumbers();
    if ((equip != null) && (!"".equals(equip))) {
      String[] chinese = equip.split(",");
      rs = new String[chinese.length];
      for (int i = 0; i < list.size(); i++) {
        LabelValueBean vo = (LabelValueBean)list.get(i);
        String value = vo.getValue();
        if (value != null) {
          for (int j = 0; j < chinese.length; j++) {
            if (value.equals(chinese[j])) {
              rs[j] = vo.getLabel();
            }
          }
        }
      }
    }
    return rs;
  }
}
