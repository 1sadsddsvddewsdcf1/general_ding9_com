package com.ding9.search.index.support.analysis;

import java.io.Reader;
import java.util.Set;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import seg.result.CnTokenizer;



















public class CnAnalyzer
  extends Analyzer
{
  private static String[] stopWords = {
    "www", "的", "和", "与", "时", "在", 
    "是", "被", "所", "那", "这", "有", 
    "将", "会", "为", "对", "了", "过", 
    "去" };
  
  private Set stopSet;
  
  public CnAnalyzer()
  {
    this.stopSet = StopFilter.makeStopSet(stopWords);
  }
  
  public CnAnalyzer(String[] stopWords) {
    this.stopSet = StopFilter.makeStopSet(stopWords);
  }
  
  public final TokenStream tokenStream(String fieldName, Reader reader) {
    TokenStream result = new CnTokenizer(reader);
    return new StopFilter(result, this.stopSet);
  }
}
