package com.ding9.entity.comment;

public class CommentCount {
  private int count;
  private int prma_id;
  
  public int getPrma_id() { return this.prma_id; }
  
  public void setPrma_id(int prma_id)
  {
    this.prma_id = prma_id;
  }
  
  public int getCount() {
    return this.count;
  }
  
  public void setCount(int count) {
    this.count = count;
  }
}
