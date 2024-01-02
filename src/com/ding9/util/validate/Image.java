package com.ding9.util.validate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Image extends HttpServlet
{
  private static final String CONTENT_TYPE = "text/html; charset=GBK";
  
  Color getRandColor(int fc, int bc)
  {
    Random random = new Random();
    if (fc > 255) {
      fc = 255;
    }
    if (bc > 255) {
      bc = 255;
    }
    int r = fc + random.nextInt(bc - fc);
    int g = fc + random.nextInt(bc - fc);
    int b = fc + random.nextInt(bc - fc);
    return new Color(r, g, b);
  }
  

  public void init()
    throws ServletException
  {}
  
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html; charset=GBK");
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0L);
    int width = 60;int height = 20;
    BufferedImage image = new BufferedImage(width, height, 
      1);
    

    Graphics g = image.getGraphics();
    

    Random random = new Random();
    

    g.setColor(getRandColor(200, 250));
    g.setColor(Color.white);
    g.fillRect(0, 0, width, height);
    

    g.setFont(new java.awt.Font("Times New Roman", 0, 18));
    
    g.setColor(Color.black);
    g.drawRect(0, 0, width - 1, height - 1);
    


    g.setColor(getRandColor(160, 200));
    for (int i = 0; i < 155; i++) {
      int x = random.nextInt(width);
      int y = random.nextInt(height);
      int xl = random.nextInt(12);
      int yl = random.nextInt(12);
      g.drawLine(x, y, x + xl, y + yl);
    }
    



    String sRand = "";
    for (int i = 0; i < 4; i++) {
      String rand = String.valueOf(random.nextInt(10));
      sRand = sRand + rand;
      
      g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 
        20 + random.nextInt(110)));
      g.drawString(rand, 13 * i + 6, 16);
    }
    

    ValidateCode.setValidateCode(request, sRand);
    











    g.dispose();
    

    javax.imageio.ImageIO.write(image, "JPEG", response.getOutputStream());
  }
  
  public void destroy() {}
}
