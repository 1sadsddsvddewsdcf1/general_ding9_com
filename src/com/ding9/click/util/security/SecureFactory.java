package com.ding9.click.util.security;










public class SecureFactory
{
  private byte[] secretkey = null;
  



  public SecureFactory(byte[] salt)
  {
    this.secretkey = salt;
  }
  





  public byte[] encrypt(byte[] source)
  {
    if ((source == null) || (this.secretkey == null))
      return null;
    try {
      byte[] ciphertext = new byte[source.length];
      for (int i = 0; i < source.length; i++) {
        ciphertext[i] = ((byte)(source[i] ^ this.secretkey[(i % this.secretkey.length)]));
      }
      return ciphertext;
    }
    catch (Exception e) {}
    
    return null;
  }
  






  public byte[] decrypt(byte[] target)
  {
    if ((target == null) || (this.secretkey == null))
      return null;
    try {
      byte[] ciphertext = new byte[target.length];
      for (int i = 0; i < target.length; i++) {
        ciphertext[i] = ((byte)(target[i] ^ this.secretkey[(i % this.secretkey.length)]));
      }
      return ciphertext;
    }
    catch (Exception e) {}
    
    return null;
  }
}
