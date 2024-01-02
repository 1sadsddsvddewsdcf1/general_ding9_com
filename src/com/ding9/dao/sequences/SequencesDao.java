package com.ding9.dao.sequences;

public abstract interface SequencesDao
{
  public abstract int getSeqCurrval(String paramString);
  
  public abstract int getSeqNextval(String paramString);
}
