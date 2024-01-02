package com.ding9.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDynamicFileToStaticFile extends HttpServlet
{
  private static String defaultsp = "/index.do";
  private static String defaultdp = "/index.html";
  









  public void destroy()
  {
    super.destroy();
  }
  










  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    execute(request, response);
  }
  









  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    execute(request, response);
  }
  
  public void execute(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String sourcepath = null;
    String destpath = null;
    

    sourcepath = request.getParameter("sp");
    sourcepath = sourcepath == null ? "" : sourcepath.trim();
    destpath = request.getParameter("dp");
    destpath = destpath == null ? "" : destpath.trim();
    
    String host = request.getScheme() + "://" + request.getHeader("Host");
    
    PrintWriter out = response.getWriter();
    
    if ("".equals(sourcepath)) {
      sourcepath = host + defaultsp;
    }
    
    if ("".equals(destpath)) {
      destpath = request.getRealPath("/") + defaultdp;
    }
    




    boolean result = getRemoteFileToLocalServer(sourcepath, destpath);
    
    out.println("from " + sourcepath + " to " + destpath);
    out.println(" result : " + result);
  }
  






  private boolean getRemoteFileToLocalServer(String sourcepath, String destinationpath)
  {
    boolean result = false;
    

    sourcepath = sourcepath == null ? "" : sourcepath.trim();
    destinationpath = destinationpath == null ? "" : destinationpath.trim();
    try
    {
      URL url = new URL(sourcepath);
      HttpURLConnection connection = (HttpURLConnection)url
        .openConnection();
      DataInputStream in = new DataInputStream(connection.getInputStream());
      DataOutputStream out = new DataOutputStream(new FileOutputStream(destinationpath));
      byte[] buffer = new byte[4096];
      int count = 0;
      
      while ((count = in.read(buffer)) > 0) {
        out.write(buffer, 0, count);
      }
      out.close();
      in.close();
      
      result = true;
    }
    catch (Exception ex) {
      ex.printStackTrace();
      result = false;
    }
    
    return result;
  }
  
  public void init()
    throws ServletException
  {}
}
