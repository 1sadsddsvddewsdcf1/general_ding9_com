package com.ding9.multipleentity;

import java.util.List;

public class MuParameters {
  private com.ding9.entity.product.ProductParameterName parametername;
  private List parameterlist;
  
  public com.ding9.entity.product.ProductParameterName getParametername() {
    return this.parametername;
  }
  
  public void setParametername(com.ding9.entity.product.ProductParameterName parametername) { this.parametername = parametername; }
  
  public List getParameterlist() {
    return this.parameterlist;
  }
  
  public void setParameterlist(List parameterlist) { this.parameterlist = parameterlist; }
}
