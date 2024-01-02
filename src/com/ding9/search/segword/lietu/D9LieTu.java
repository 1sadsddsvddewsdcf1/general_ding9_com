package com.ding9.search.segword.lietu;

import java.util.ArrayList;
import seg.result.CnToken;
import seg.result.Tagger;









public class D9LieTu
{
  public boolean makeTag = true;
  public boolean segName = false;
  




  private ArrayList getFormatSegResultPri(String sourceStr)
  {
    ArrayList result = null;
    try {
      Tagger.makeTag = this.makeTag;
      Tagger.segName = this.segName;
      result = Tagger.getFormatSegResult(sourceStr);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    
    return result;
  }
  




  public ArrayList getFormatSegResult(String sourceStr)
  {
    ArrayList result = new ArrayList();
    ArrayList ctResult = getFormatSegResultPri(sourceStr);
    CnToken t = new CnToken();
    String splitstr = "";
    
    if (ctResult != null) {
      for (int i = 0; i < ctResult.size(); i++) {
        t = (CnToken)ctResult.get(i);
        splitstr = t.termText();
        if (!wordfilter(splitstr)) {
          result.add(splitstr);
        }
      }
    }
    
    return result;
  }
  




  public String getNormalSegResult(String sourceStr)
  {
    ArrayList result = null;
    StringBuffer strresult = new StringBuffer();
    try {
      result = getFormatSegResult(sourceStr);
      
      for (int i = 0; i < result.size(); i++) {
        strresult.append(((String)result.get(i)).trim() + " ");
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    
    return strresult.toString().trim();
  }
  




  public String getNormalSegResultWithLogic(String sourceStr, boolean logic)
  {
    ArrayList result = null;
    StringBuffer strresult = new StringBuffer();
    try {
      result = getFormatSegResult(sourceStr);
      
      for (int i = 0; i < result.size(); i++) {
        if (!"".equals(strresult.toString())) {
          if (logic) {
            strresult.append(" AND ");
          } else {
            strresult.append(" OR ");
          }
        }
        strresult.append(((String)result.get(i)).trim() + " ");
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    
    return strresult.toString().trim();
  }
  




  private boolean wordfilter(String str)
  {
    boolean result = false;
    
    str = str.toLowerCase();
    
    if ((" ".equals(str)) || 
      ("　".equals(str))) {
      result = true;
    }
    
    if ((str.equals("!")) || 
      (str.equals("@")) || 
      (str.equals("#")) || 
      (str.equals("$")) || 
      (str.equals("%")) || 
      (str.equals("^")) || 
      (str.equals("&")) || 
      (str.equals("*")) || 
      (str.equals("(")) || 
      (str.equals(")")) || 
      (str.equals("-")) || 
      (str.equals("_")) || 
      (str.equals("+")) || 
      (str.equals("=")) || 
      (str.equals("|")) || 
      (str.equals("{")) || 
      (str.equals("}")) || 
      (str.equals("[")) || 
      (str.equals("]")) || 
      (str.equals(":")) || 
      (str.equals(";")) || 
      (str.equals("\"")) || 
      (str.equals(",")) || 
      (str.equals("<")) || 
      (str.equals(">")) || 
      (str.equals(".")) || 
      (str.equals("?")) || 
      (str.equals("\\")) || 
      (str.indexOf("\\") == str.length() - 1)) {
      result = true;
    }
    
    return result;
  }
}
