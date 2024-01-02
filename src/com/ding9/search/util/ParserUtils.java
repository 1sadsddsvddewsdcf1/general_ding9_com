package com.ding9.search.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.text.html.HTMLEditorKit;



public class ParserUtils
{
  private static HTMLEditorKit.Parser parser = new ParserGetter().getParser();
  


  public static String parse(String source)
  {
    String result = "";
    Writer writer = new StringWriter();
    HTMLEditorKit.ParserCallback callback = new TagStripper(writer);
    
    try
    {
      source = source.replaceAll("&nbsp;", "");
      StringReader reader = new StringReader(source);
      parser.parse(reader, callback, false);
      result = writer.toString();
    }
    catch (IOException localIOException) {}
    
    return result;
  }
}
