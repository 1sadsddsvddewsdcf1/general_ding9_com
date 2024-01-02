package com.ding9.click.util.security;

import com.ding9.click.util.Conversions;
import java.io.PrintStream;









public class AccountSecure
{
  private byte[] secretkey = null;
  



  private int ran = 7;
  





  public String encrypt(String source)
  {
    if (source == null)
      return null;
    long systime = System.currentTimeMillis();
    long key = systime * this.ran;
    try {
      this.secretkey = Long.toString(systime).getBytes();
      SecureFactory sf = new SecureFactory(this.secretkey);
      byte[] ciphertext = sf.encrypt(source.getBytes());
      return key + "D" + Conversions.bytesToHexString(ciphertext);
    }
    catch (Exception e) {}
    
    return null;
  }
  






  public String decrypt(String target)
  {
    if (target == null)
      return null;
    try {
      long systime = Long.parseLong(target.substring(0, target.indexOf("D"))) / this.ran;
      this.secretkey = Long.toString(systime).getBytes();
      SecureFactory sf = new SecureFactory(this.secretkey);
      target = target.substring(target.indexOf("D") + 1);
      byte[] desttext = sf.decrypt(Conversions.hexStringToBytes(target));
      if (desttext == null)
        return null;
      return new String(desttext);
    }
    catch (Exception e) {}
    
    return null;
  }
  
  public static void main(String[] args) throws Exception
  {
    AccountSecure df = new AccountSecure();
    

    String result = args[0];
    System.out.println("decrypt=" + df.decrypt(result));
  }
}
