package com.ding9.search.server;

import java.io.IOException;
import java.io.PrintStream;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermDocs;
import org.apache.lucene.index.TermEnum;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.ScoreDocComparator;
import org.apache.lucene.search.SortComparatorSource;

public class DistanceComparatorSource implements SortComparatorSource
{
  private int x;
  private int y;
  
  public DistanceComparatorSource(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  public ScoreDocComparator newComparator(IndexReader reader, String fieldname) throws IOException
  {
    return new DistanceScoreDocLookupComparator(reader, fieldname, this.x, this.y);
  }
  

  private static class DistanceScoreDocLookupComparator
    implements ScoreDocComparator
  {
    private float[] distances;
    
    public DistanceScoreDocLookupComparator(IndexReader reader, String fieldname, int x, int y)
      throws IOException
    {
      TermEnum enumerator = reader.terms(new Term(fieldname, ""));
      this.distances = new float[reader.maxDoc()];
      if (this.distances.length > 0) {
        TermDocs termDocs = reader.termDocs();
        try {
          if (enumerator.term() == null) {
            throw new RuntimeException("no terms in field " + 
              fieldname);
          }
          int i = 0;int j = 0;
          do {
            System.out.println("in do-while :" + i++);
            
            Term term = enumerator.term();
            if (term.field() != fieldname) {
              break;
            }
            
            termDocs.seek(enumerator);
            while (termDocs.next()) {
              System.out.println("    in while :" + j++);
              System.out.println("    in while ,Term :" + term.toString());
              
              String[] xy = term.text().split(",");
              int deltax = Integer.parseInt(xy[0]) - x;
              int deltay = Integer.parseInt(xy[1]) - y;
              
              this.distances[termDocs.doc()] = 
                ((float)Math.sqrt(deltax * deltax + deltay * deltay));
            }
          } while (
          


















            enumerator.next());
        } finally {
          termDocs.close();
        }
      }
    }
    
    public int compare(ScoreDoc i, ScoreDoc j)
    {
      if (this.distances[i.doc] < this.distances[j.doc])
        return -1;
      if (this.distances[i.doc] > this.distances[j.doc])
        return 1;
      return 0;
    }
    
    public Comparable sortValue(ScoreDoc i)
    {
      return new Float(this.distances[i.doc]);
    }
    
    public int sortType()
    {
      return 5;
    }
  }
  
  public String toString() {
    return "Distance from (" + this.x + "," + this.y + ")";
  }
}
