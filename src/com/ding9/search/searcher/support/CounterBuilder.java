package com.ding9.search.searcher.support;

import com.ding9.search.entity.assistant.Counter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;




public class CounterBuilder
{
  public static Counter[] getCounters(HashMap hmcount, HashMap hmextendvalueone, HashMap hmextendvaluetwo, HashMap hmextendvaluethree, HashMap hmextendvaluefour)
  {
    Counter[] counters = (Counter[])null;
    
    if (hmcount == null) {
      return counters;
    }
    

    counters = new Counter[hmcount.size()];
    
    String key = null;
    String value = null;
    int i = 0;
    Iterator keys = hmcount.keySet().iterator();
    while (keys.hasNext()) {
      key = (String)keys.next();
      value = (String)hmcount.get(key);
      
      counters[i] = new Counter();
      
      counters[i].setValue(key);
      try {
        counters[i].setCount(Integer.parseInt(value));
      }
      catch (Exception localException) {}
      
      if ((hmextendvalueone != null) && 
        (hmextendvalueone.size() > 0)) {
        value = (String)hmextendvalueone.get(key);
        counters[i].setExtend_value_one(value);
      }
      

      if ((hmextendvaluetwo != null) && 
        (hmextendvaluetwo.size() > 0)) {
        value = (String)hmextendvaluetwo.get(key);
        counters[i].setExtend_value_two(value);
      }
      

      if ((hmextendvaluethree != null) && 
        (hmextendvaluethree.size() > 0)) {
        value = (String)hmextendvaluethree.get(key);
        counters[i].setExtend_value_three(value);
      }
      

      if ((hmextendvaluefour != null) && 
        (hmextendvaluefour.size() > 0)) {
        value = (String)hmextendvaluefour.get(key);
        counters[i].setExtend_value_four(value);
      }
      


      i++;
    }
    
    return counters;
  }
  
  public static HashMap setCounter(HashMap hm, String value) {
    if (hm == null) {
      hm = new HashMap();
    }
    
    int count = 1;
    if (hm.containsKey(value)) {
      try {
        count = Integer.parseInt((String)hm.get(value)) + 1;
      } catch (Exception ex) { count = 1;
      }
    }
    hm.put(value, String.valueOf(count));
    
    return hm;
  }
}
