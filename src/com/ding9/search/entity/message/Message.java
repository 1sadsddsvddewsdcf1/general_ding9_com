package com.ding9.search.entity.message;




public class Message
{
  private int msg_id;
  

  private int msg_type;
  

  private int upd_type;
  

  private int record_id;
  


  public int getMsg_id()
  {
    return this.msg_id;
  }
  
  public void setMsg_id(int msg_id) {
    this.msg_id = msg_id;
  }
  
  public int getMsg_type() {
    return this.msg_type;
  }
  
  public void setMsg_type(int msg_type) {
    this.msg_type = msg_type;
  }
  
  public int getRecord_id() {
    return this.record_id;
  }
  
  public void setRecord_id(int record_id) {
    this.record_id = record_id;
  }
  
  public int getUpd_type() {
    return this.upd_type;
  }
  
  public void setUpd_type(int upd_type) {
    this.upd_type = upd_type;
  }
}
