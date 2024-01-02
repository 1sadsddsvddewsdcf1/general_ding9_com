package com.ding9.click.util;

import sun.io.ConversionBufferFullException;
import sun.io.MalformedInputException;









public final class Conversions
{
  private static final char[] hexArray = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
  




  private static final byte[] high = new byte[16];
  



  private static final byte[] low = new byte[16];
  



  static
  {
    createHigh();
    createLow();
  }
  





  public static byte[] wrapByteArray(byte[] bytes, int start, int len)
  {
    if (len < 1) {
      return null;
    }
    byte[] ret = new byte[len];
    
    if ((start < 0) || (bytes == null) || (start >= bytes.length)) {
      return ret;
    }
    for (int i = 0; i < len; i++) {
      if (i >= bytes.length - start)
        break;
      ret[i] = bytes[(start + i)];
    }
    return ret;
  }
  





  public static byte[] chopByteArray(byte[] bytes)
  {
    if (bytes == null) {
      return null;
    }
    int pos = 0;
    
    for (int i = 0; i < bytes.length; i++) {
      if (bytes[i] == 0)
        break;
      pos++;
    }
    return wrapByteArray(bytes, 0, pos);
  }
  





  public static char[] byteArray2CharArray(byte[] bytes)
  {
    byte[] newbytes = chopByteArray(bytes);
    
    if (newbytes == null)
    {
      return null;
    }
    
    String theUtf8CharacterEncoding = "UTF8";
    
    try
    {
      char[] sunConversion = (char[])null;
      
      return UTF82CharArray(newbytes);

    }
    catch (Exception e)
    {

      e.printStackTrace(); }
    return null;
  }
  






  public static String bytesToHexString(byte[] inByteArray)
  {
    if (inByteArray == null) {
      return null;
    }
    StringBuffer returnBuffer = new StringBuffer();
    
    for (int position = 0; position < inByteArray.length; position++)
    {
      returnBuffer.append(hexArray[
        (inByteArray[position] >> 4 & 0xF)]);
      returnBuffer.append(hexArray[(inByteArray[position] & 0xF)]);
    }
    
    return returnBuffer.toString();
  }
  





  public static long bytesToLong(byte[] bytes)
  {
    boolean negative = false;
    long returnLong = 0L;
    
    for (int n = 0; n < 8; n++)
    {
      returnLong <<= 8;
      
      long aByte = bytes[n];
      
      if (aByte < 0L)
      {
        aByte += 256L;
      }
      
      returnLong |= aByte;
    }
    
    return returnLong;
  }
  





  public static byte[] charArray2ByteArray(char[] characters)
  {
    if (characters == null)
    {
      return null;
    }
    
    String theUtf8CharacterEncoding = "UTF8";
    
    try
    {
      byte[] sunConversion = (byte[])null;
      
      return charArray2UTF8(characters);
    }
    catch (Exception e) {}
    


    return null;
  }
  








  private static byte[] charArray2UTF8(char[] characters)
    throws MalformedInputException, ConversionBufferFullException
  {
    byte[] outputByte = new byte[6];
    


    byte[] output = new byte[characters.length * 3];
    int charOff = 0;
    int byteOff = 0;
    
    while (charOff < characters.length)
    {
      char inputChar = characters[charOff];
      //int outputSize;
      int inputSize = 1; int outputSize; if(inputChar < '\200')
      {
        outputByte[0] = ((byte)inputChar);
        //int inputSize = 1;
        outputSize = 1;
      } else { //int outputSize;
        if(inputChar < '\u0800')
        {
          outputByte[0] = ((byte)(0xC0 | inputChar >> '\006' & 0x1F));
          outputByte[1] = ((byte)(0x80 | inputChar & 0x3F));
          inputSize = 1;
          outputSize = 2;
        } else { //int inputSize;
          if(inputChar >= '\uD800' && inputChar <= '\uDBFF')
          {

            if (charOff + 1 >= characters.length) {
              break;
            }
            


            char lowChar = characters[(charOff + 1)];
            
            if(lowChar < '\uDC00' || lowChar > '\uDFFF')
            {
              for (int i = 0; i < output.length; i++)
              {
                output[i] = 0;
              }
              
              for (int i = 0; i < outputByte.length; i++)
              {
                outputByte[i] = 0;
              }
              
              inputChar = '\000';
              throw new MalformedInputException();
            }
            
            int ucs4 = (inputChar - 55296) * 1024 + (
              lowChar - 56320) + 65536;
            outputByte[0] = ((byte)(0xF0 | ucs4 >> 18 & 0x7));
            outputByte[1] = ((byte)(0x80 | ucs4 >> 12 & 0x3F));
            outputByte[2] = ((byte)(0x80 | ucs4 >> 6 & 0x3F));
            outputByte[3] = ((byte)(0x80 | ucs4 & 0x3F));
            outputSize = 4;
            inputSize = 2;
          }
          else
          {
            outputByte[0] = ((byte)(0xE0 | inputChar >> '\f' & 0xF));
            outputByte[1] = ((byte)(0x80 | inputChar >> '\006' & 0x3F));
            outputByte[2] = ((byte)(0x80 | inputChar & 0x3F));
            inputSize = 1;
            outputSize = 3;
          }
        } }
      if (byteOff + outputSize > output.length)
      {
        for (int i = 0; i < output.length; i++)
        {
          output[i] = 0;
        }
        
        for (int i = 0; i < outputByte.length; i++)
        {
          outputByte[i] = 0;
        }
        
        inputChar = '\000';
        throw new ConversionBufferFullException();
      }
      
      for (int i = 0; i < outputSize; i++)
      {
        output[(byteOff++)] = outputByte[i];
      }
      
      charOff += inputSize;
    }
    
    byte[] toReturn = new byte[byteOff];
    System.arraycopy(output, 0, toReturn, 0, toReturn.length);
    

    for (int i = 0; i < output.length; i++)
    {
      output[i] = 0;
    }
    
    for (int i = 0; i < outputByte.length; i++)
    {
      outputByte[i] = 0;
    }
    
    char inputChar = '\000';
    
    return toReturn;
  }
  








  private static void createHigh()
  {
    for (int i = 0; i < high.length; i++)
    {
      byte b = (byte)i;
      high[i] = ((byte)(b << 4 & 0xF0));
    }
  }
  








  private static void createLow()
  {
    for (int i = 0; i < low.length; i++)
    {
      byte b = (byte)i;
      low[i] = ((byte)(b & 0xF));
    }
  }
  







  private static int getIndex(char c)
  {
    if (('0' <= c) && (c <= '9'))
    {
      return (byte)c - 48;
    }
    if (('a' <= c) && (c <= 'f'))
    {
      return (byte)c - 97 + 10;
    }
    if (('A' <= c) && (c <= 'F'))
    {
      return (byte)c - 65 + 10;
    }
    

    return -1;
  }
  






  public static byte[] hexStringToBytes(String str)
  {
    if (str == null) {
      return null;
    }
    

    int len = str.length();
    byte[] retval = new byte[len / 2];
    
    int j = 0;
    
    for (int i = 0; i < len; i += 2)
    {
      byte b = high[getIndex(str.charAt(i))];
      byte b2 = low[getIndex(str.charAt(i + 1))];
      retval[(j++)] = ((byte)(b | b2));
    }
    
    return retval;
  }
  





  public static byte[] intToBytes(int i)
  {
    int ii = i;
    
    byte[] returnBytes = new byte[8];
    
    for (int n = 3; n >= 0; n--)
    {
      returnBytes[n] = ((byte)ii);
      ii >>>= 8;
    }
    
    return returnBytes;
  }
  





  public static byte[] longToBytes(long l)
  {
    long ll = l;
    
    byte[] returnBytes = new byte[8];
    
    for (int n = 7; n >= 0; n--)
    {
      returnBytes[n] = ((byte)(int)ll);
      ll >>>= 8;
    }
    
    return returnBytes;
  }
  






  public static int unSign(int i)
  {
    if (i < 0)
    {
      return i + 256;
    }
    

    return i;
  }
  






















  private static char[] UTF82CharArray(byte[] input)
    throws MalformedInputException, ConversionBufferFullException
  {
    int savedSize = 0;
    byte[] savedBytes = new byte[5];
    

    char[] output = new char[input.length];
    int inEnd = input.length;
    int outEnd = output.length;
    int inOff = 0;
    int outOff = 0;
    




    char[] outputChar = new char[2];
    
    int byteOffAdjustment = 0;
    
    if (savedSize != 0)
    {

      byte[] newBuf = new byte[inEnd - inOff + savedSize];
      
      for (int i = 0; i < savedSize; i++)
      {
        newBuf[i] = savedBytes[i];
      }
      
      System.arraycopy(input, inOff, newBuf, savedSize, inEnd - inOff);
      input = newBuf;
      inOff = 0;
      inEnd = newBuf.length;
      byteOffAdjustment = -savedSize;
      savedSize = 0;
    }
    
    int charOff = outOff;
    int byteOff = inOff;
    


    while (byteOff < inEnd)
    {
      int startByteOff = byteOff;
      int byte1 = input[(byteOff++)] & 0xFF;
      //int outputSize;
      int outputSize; if ((byte1 & 0x80) == 0)
      {
        outputChar[0] = ((char)byte1);
        outputSize = 1;
      } else { //int outputSize;
        if ((byte1 & 0xE0) == 192)
        {
          if (byteOff >= inEnd)
          {
            savedSize = 1;
            savedBytes[0] = ((byte)byte1);
            
            break;
          }
          
          int byte2 = input[(byteOff++)] & 0xFF;
          
          if ((byte2 & 0xC0) != 128)
          {
            int badInputLength = 2;
            byteOff += byteOffAdjustment;
            throw new MalformedInputException();
          }
          
          outputChar[0] = 
            ((char)((byte1 & 0x1F) << 6 | byte2 & 0x3F));
          outputSize = 1;
        } else { //int outputSize;
          if ((byte1 & 0xF0) == 224)
          {
            if (byteOff + 1 >= inEnd)
            {
              savedBytes[0] = ((byte)byte1);
              
              if (byteOff >= inEnd)
              {
                savedSize = 1; break;
              }
              

              savedSize = 2;
              savedBytes[1] = input[(byteOff++)];
              

              break;
            }
            
            int byte2 = input[(byteOff++)] & 0xFF;
            int byte3 = input[(byteOff++)] & 0xFF;
            
            if (((byte2 & 0xC0) != 128) || ((byte3 & 0xC0) != 128))
            {
              int badInputLength = 3;
              byteOff += byteOffAdjustment;
              throw new MalformedInputException();
            }
            
            outputChar[0] = 
              ((char)((byte1 & 0xF) << 12 | (byte2 & 0x3F) << 6 | byte3 & 0x3F));
            outputSize = 1;
          }
          else if ((byte1 & 0xF8) == 240)
          {
            if (byteOff + 2 >= inEnd)
            {
              savedBytes[0] = ((byte)byte1);
              
              if (byteOff >= inEnd)
              {
                savedSize = 1; break;
              }
              if (byteOff + 1 >= inEnd)
              {
                savedSize = 2;
                savedBytes[1] = input[(byteOff++)]; break;
              }
              

              savedSize = 3;
              savedBytes[1] = input[(byteOff++)];
              savedBytes[2] = input[(byteOff++)];
              

              break;
            }
            
            int byte2 = input[(byteOff++)] & 0xFF;
            int byte3 = input[(byteOff++)] & 0xFF;
            int byte4 = input[(byteOff++)] & 0xFF;
            
            if (((byte2 & 0xC0) != 128) || ((byte3 & 0xC0) != 128) || 
              ((byte4 & 0xC0) != 128))
            {
              int badInputLength = 4;
              byteOff += byteOffAdjustment;
              throw new MalformedInputException();
            }
            

            int ucs4 = (0x7 & byte1) << 18 | 
              (0x3F & byte2) << 12 | 
              (0x3F & byte3) << 6 | 
              0x3F & byte4;
            outputChar[0] = ((char)((ucs4 - 65536) / 1024 + 55296));
            outputChar[1] = ((char)((ucs4 - 65536) % 1024 + 56320));
            outputSize = 2;
          }
          else
          {
            int badInputLength = 1;
            byteOff += byteOffAdjustment;
            throw new MalformedInputException();
          } } }
      //int outputSize;
      if (charOff + outputSize > outEnd)
      {
        byteOff = startByteOff;
        byteOff += byteOffAdjustment;
        throw new ConversionBufferFullException();
      }
      
      for (int i = 0; i < outputSize; i++)
      {
        output[(charOff + i)] = outputChar[i];
      }
      
      charOff += outputSize;
    }
    
    byteOff += byteOffAdjustment;
    
    char[] toReturn = new char[charOff];
    System.arraycopy(output, 0, toReturn, 0, toReturn.length);
    

    for (int i = 0; i < output.length; i++)
    {
      output[i] = '\000';
    }
    
    for (int i = 0; i < outputChar.length; i++)
    {
      outputChar[i] = '\000';
    }
    
    return toReturn;
  }
}
