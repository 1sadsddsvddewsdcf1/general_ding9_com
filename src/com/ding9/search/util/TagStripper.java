package com.ding9.search.util;

import java.io.IOException;
import java.io.Writer;
import javax.swing.text.html.HTMLEditorKit;





























class TagStripper
  extends HTMLEditorKit.ParserCallback
{
  private Writer out;
  
  public TagStripper(Writer out)
  {
    this.out = out;
  }
  
  public void handleText(char[] text, int position) {
    try {
      this.out.write(text);
      this.out.flush();
    }
    catch (IOException localIOException) {}
  }
}
