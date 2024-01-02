package com.ding9.click.util.security;

import com.ding9.click.util.Conversions;
import java.io.PrintStream;









public class DesFactory
{
  private byte[] secretkey = null;
  



  public DesFactory(String salt)
  {
    if (salt != null) {
      this.secretkey = salt.getBytes();
    }
  }
  




  public String encrypt(String source)
  {
    if ((source == null) || (this.secretkey == null))
      return null;
    try {
      SecureFactory sf = new SecureFactory(this.secretkey);
      byte[] ciphertext = sf.encrypt(source.getBytes());
      return Conversions.bytesToHexString(ciphertext);
    }
    catch (Exception e) {}
    
    return null;
  }
  






  public String decrypt(String target)
  {
    if ((target == null) || (this.secretkey == null))
      return null;
    try {
      SecureFactory sf = new SecureFactory(this.secretkey);
      target = target.toLowerCase();
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
    DesFactory df = new DesFactory(args[0]);
    String result = df.encrypt(args[1]);
    byte[] str = args[1].getBytes();
    for (int i = 0; i < str.length; i++)
      System.out.println(str[i]);
    System.out.println("encrypt=" + df.encrypt(args[1]));
    System.out.println("decrypt=" + df.decrypt(result));
  }
}
