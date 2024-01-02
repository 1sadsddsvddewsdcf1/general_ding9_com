package com.ding9.sql;

import java.util.Date;















public class SQLParam
{
  public static final int PARAM_TYPE_INT = 1;
  public static final int PARAM_TYPE_LONG = 2;
  public static final int PARAM_TYPE_DOUBLE = 3;
  public static final int PARAM_TYPE_FLOAT = 4;
  public static final int PARAM_TYPE_STRING = 5;
  public static final int PARAM_TYPE_DATE = 6;
  public static final int PARAM_TYPE_CLOB = 7;
  private int index;
  private int paramType;
  private Object value;
  
  public SQLParam() {}
  
  public SQLParam(int index, int paramType, Object value)
  {
    this.index = index;
    this.paramType = paramType;
    this.value = value;
  }
  
  public SQLParam(int index, int paramType, int value) {
    this.index = index;
    this.paramType = paramType;
    this.value = new Integer(value);
  }
  
  public SQLParam(int index, int paramType, long value) {
    this.index = index;
    this.paramType = paramType;
    this.value = new Long(value);
  }
  
  public SQLParam(int index, int paramType, double value) {
    this.index = index;
    this.paramType = paramType;
    this.value = new Double(value);
  }
  
  public SQLParam(int index, int paramType, float value) {
    this.index = index;
    this.paramType = paramType;
    this.value = new Float(value);
  }
  
  public SQLParam(int index, int paramType, String value) {
    this.index = index;
    this.paramType = paramType;
    this.value = value;
  }
  
  public SQLParam(int index, int paramType, Date value) {
    this.index = index;
    this.paramType = paramType;
    this.value = value;
  }
  
  public static SQLParam createDateParam(int index, Date value) {
    return new SQLParam(index, 6, value);
  }
  
  public static SQLParam createStringParam(int index, String value) {
    return new SQLParam(index, 5, value);
  }
  
  public static SQLParam createIntParam(int index, int value) {
    return new SQLParam(index, 1, value);
  }
  
  public static SQLParam createLongParam(int index, long value) {
    return new SQLParam(index, 2, value);
  }
  
  public static SQLParam createFloatParam(int index, float value) {
    return new SQLParam(index, 4, value);
  }
  
  public static SQLParam createDoubleParam(int index, double value) {
    return new SQLParam(index, 3, value);
  }
  
  public static SQLParam createClobParam(int index, String value) {
    return new SQLParam(index, 7, value);
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public void setIndex(int index) {
    this.index = index;
  }
  
  public int getParamType() {
    return this.paramType;
  }
  
  public void setParamType(int paramType) {
    this.paramType = paramType;
  }
  
  public Object getValue() {
    return this.value;
  }
  
  public void setValue(Object value) {
    this.value = value;
  }
  
  public void setInt(int value) {
    this.value = new Integer(value);
  }
  
  public int getInt() {
    return ((Integer)this.value).intValue();
  }
  
  public void setLong(long value) {
    this.value = new Long(value);
  }
  
  public long getLong() {
    return ((Long)this.value).longValue();
  }
  
  public void setDouble(double value) {
    this.value = new Double(value);
  }
  
  public double getDouble() {
    return ((Double)this.value).doubleValue();
  }
  
  public void setFloat(float value) {
    this.value = new Float(value);
  }
  
  public float getFloat() {
    return ((Float)this.value).floatValue();
  }
  
  public void setString(String value) {
    this.value = value;
  }
  
  public String getString() {
    return (String)this.value;
  }
  
  public void setDate(Date value) {
    this.value = value;
  }
  
  public Date getDate() {
    return (Date)this.value;
  }
}
