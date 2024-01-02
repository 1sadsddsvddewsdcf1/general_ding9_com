package com.ding9.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.struts.upload.FormFile;





public class FileManager
{
  public static String getLocalAddress(String urlpath)
  {
    urlpath = StringHelper.getRealString(urlpath);
    
    if ("".equals(urlpath)) {
      return "";
    }
    
    String localaddress = null;
    
    String md5str = MD5Helper.encode(urlpath);
    
    String postfix = "";
    if (urlpath.lastIndexOf(".") > -1) {
      postfix = urlpath.substring(urlpath.lastIndexOf("."));
    }
    
    String cata = String.valueOf(Long.parseLong(md5str.substring(0, 9), 16));
    
    localaddress = "/ProductPic/WEB/" + cata.substring(0, 3) + "/" + 
      cata.substring(3, 6) + "/" + 
      cata.substring(6, 9) + "/" + md5str + postfix;
    

    return localaddress;
  }
  
  public static String saveFileToLocalServer(FormFile file, String filePath, String id)
    throws IOException
  {
    InputStream stream = file.getInputStream();
    
    File dir = new File(filePath);
    if (!dir.exists()) {
      dir.mkdirs();
    }
    
    String originalFileName = file.getFileName();
    String destFileName = id + 
      originalFileName.substring(originalFileName.lastIndexOf('.'));
    
    OutputStream bos = new FileOutputStream(filePath + destFileName);
    
    int bytesRead = 0;
    byte[] buffer = new byte[8192];
    while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
      bos.write(buffer, 0, bytesRead);
    }
    bos.close();
    stream.close();
    return destFileName;
  }
}
