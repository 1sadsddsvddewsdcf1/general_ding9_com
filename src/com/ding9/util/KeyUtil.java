package com.ding9.util;

import java.io.PrintStream;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.IntRange;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.math.Range;









public class KeyUtil
{
  private static final Range chinaeseCodePointScore;
  private static final char[] chars = { 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p' };
  

  private static final int[] ints = new int[''];
  
  static
  {
    int minChinaeseCodePoint = NumberUtils.createNumber("0x4E00").intValue();
    int maxChinaeseCodePoint = NumberUtils.createNumber("0x9FFF").intValue();
    chinaeseCodePointScore = new IntRange(minChinaeseCodePoint, maxChinaeseCodePoint);
    

    for (int i = 0; i < chars.length; i++) {
      ints[chars[i]] = i;
    }
  }
  






  private static String getAlphaFromHex(String hex)
  {
    if (StringUtils.isBlank(hex)) {
      return "";
    }
    
    StringBuffer alphas = new StringBuffer();
    char[] hexChar = hex.toCharArray();
    for (int j = 0; j < hexChar.length; j++) {
      if (CharUtils.isAsciiNumeric(hexChar[j])) {
        alphas.append(chars[CharUtils.toIntValue(hexChar[j])]);
      } else {
        alphas.append(hexChar[j]);
      }
    }
    return alphas.toString();
  }
  







  private static boolean isNotEnd(char[] ch, int index)
  {
    if (index < ch.length - 1) {
      return true;
    }
    return false;
  }
  






  private static boolean isLowerCaseString(String alpha)
  {
    if (StringUtils.isBlank(alpha)) {
      return false;
    }
    
    char[] chars = alpha.toCharArray();
    for (int j = 0; j < chars.length; j++) {
      if (!java.lang.Character.isLowerCase(chars[j])) {
        return false;
      }
    }
    return true;
  }
  






  private static String createPrefix(char ch)
  {
    if ((!CharUtils.isAsciiAlphanumeric(ch)) && 
      (!StringUtils.equals(CharUtils.toString(ch), "_"))) {
      return "_";
    }
    return "";
  }
  






  private static String createSuffix(char ch)
  {
    if ((!StringUtils.isWhitespace(CharUtils.toString(ch))) && 
      (!CharUtils.isAsciiAlphanumeric(ch)) && 
      (!StringUtils.equals(CharUtils.toString(ch), "_"))) {
      return "_";
    }
    return "";
  }
  






  private static String getStringFromCodePoint(String hex)
  {
    int codePoint = NumberUtils.createNumber("0x" + hex).intValue();
    return CharUtils.toString((char)codePoint);
  }
  






  public static String toAlphaString(String original)
  {
    if (StringUtils.isBlank(original)) {
      return "";
    }
    
    char[] chinaeseChar = original.toCharArray();
    String cnChar = null;
    StringBuffer alphas = new StringBuffer();
    for (int i = 0; i < chinaeseChar.length; i++) {
      int codePointOfChar = chinaeseChar[i];
      String hexString = Integer.toHexString(codePointOfChar);
      
      char previousChar = '\000';
      if (i != 0) {
        previousChar = chinaeseChar[(i - 1)];
      } else {
        previousChar = chinaeseChar[i];
      }
      char nextChar = '\000';
      if (isNotEnd(chinaeseChar, i)) {
        nextChar = chinaeseChar[(i + 1)];
      } else {
        nextChar = chinaeseChar[i];
      }
      
      cnChar = CharUtils.toString(chinaeseChar[i]);
      

      if (java.lang.Character.isWhitespace(chinaeseChar[i])) {
        String p = CharUtils.toString(previousChar);
        if ((!StringUtils.isWhitespace(p)) && 
          (!StringUtils.equals(p, "_"))) {
          alphas.append("_");
        }
        
        alphas.append(getAlphaFromHex(hexString));
        
        String n = CharUtils.toString(nextChar);
        if ((!StringUtils.isWhitespace(n)) && 
          (!StringUtils.equals(n, "_"))) {
          alphas.append("_");
        }
        
      }
      else if (CharUtils.isAsciiAlpha(chinaeseChar[i])) {
        alphas.append(createPrefix(previousChar));
        
        alphas.append(cnChar);
        
        if (isNotEnd(chinaeseChar, i)) {
          alphas.append(createSuffix(nextChar));
        }
        
      }
      else if (CharUtils.isAsciiNumeric(chinaeseChar[i])) {
        alphas.append(createPrefix(previousChar));
        
        alphas.append(cnChar);
        
        if (isNotEnd(chinaeseChar, i)) {
          alphas.append(createSuffix(nextChar));
        }
        
      }
      else if (CharUtils.isAscii(chinaeseChar[i])) {
        alphas.append(createPrefix(previousChar));
        
        alphas.append(getAlphaFromHex(hexString));
        
        if (isNotEnd(chinaeseChar, i)) {
          alphas.append(createSuffix(nextChar));
        }
      }
      else
      {
        alphas.append(getAlphaFromHex(hexString));
      }
    }
    return StringUtils.replace(alphas.toString(), "__", "_");
  }
  






  public static String toOriginalString(String alpha)
  {
    if (StringUtils.isBlank(alpha)) {
      return "";
    }
    
    String[] alphas = StringUtils.split(alpha, "_");
    
    StringBuffer originalString = new StringBuffer();
    for (int i = 0; i < alphas.length; i++)
    {
      if (alphas[i].length() % 4 == 0) {
        if (isLowerCaseString(alphas[i])) {
          StringBuffer hexs = new StringBuffer();
          
          char[] alphaChar = alphas[i].toCharArray();
          for (int j = 0; j < alphaChar.length; j++) {
            int codePoint = alphaChar[j];
            if (codePoint > 102) {
              hexs.append(ints[codePoint]);
            } else {
              hexs.append(alphaChar[j]);
            }
            
            int currentCharCodePoint = NumberUtils.createNumber("0x" + hexs.toString()).intValue();
            if ((j + 1) % 4 == 0) {
              if (chinaeseCodePointScore.containsInteger(currentCharCodePoint)) {
                originalString.append(getStringFromCodePoint(hexs.toString()));
                hexs.delete(0, hexs.length());
              } else {
                originalString.append(alphas[i]);
                hexs.delete(0, hexs.length());
              }
            }
          }
        } else {
          originalString.append(alphas[i]);
        }
      } else if (alphas[i].length() % 2 == 0) {
        StringBuffer hexs = new StringBuffer();
        char[] alphaChar = alphas[i].toCharArray();
        for (int k = 0; k < alphaChar.length; k++) {
          int codePoint = alphaChar[k];
          if (codePoint > 102) {
            hexs.append(ints[codePoint]);
          } else {
            hexs.append(alphaChar[k]);
          }
          
          int currentCharCodePoint = NumberUtils.createNumber("0x" + hexs.toString()).intValue();
          if ((k + 1) % 2 == 0) {
            if (CharUtils.isAsciiPrintable((char)currentCharCodePoint))
            {
              originalString.append(getStringFromCodePoint(hexs.toString()));
              hexs.delete(0, hexs.length());
            }
            else {
              originalString.append(hexs.toString());
              hexs.delete(0, hexs.length());
              System.out.println("(2)originalString = " + originalString.toString());
            }
          }
        }
      } else {
        originalString.append(alphas[i]);
      }
    }
    
    return originalString.toString();
  }
  











  public static void main(String[] args)
  {
    String str = "诺基亚-N73 CDMA手机/红色 夏新e603/ abcd jdbc jcp";
    






    String codepointHexStr = toAlphaString(str);
    System.out.println("str = " + str);
    System.out.println("toAlphaString(str) = " + codepointHexStr);
    System.out.println("");
    System.out.println("toOriginalString(str) = [" + toOriginalString(codepointHexStr) + "]");
  }
}
