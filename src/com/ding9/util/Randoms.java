package com.ding9.util;




public class Randoms
{
  public static int[] random(int lenth)
  {
    int[] n = new int[lenth];
    for (int i = 0; i < lenth; i++) { n[i] = i;
    }
    
    for (int i = 0; i < lenth; i++) {
      int r = (int)(Math.random() * (lenth - i)) + i;
      int t = n[i];
      n[i] = n[r];
      n[r] = t;
    }
    return n;
  }
}
