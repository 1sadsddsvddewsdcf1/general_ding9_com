package com.ding9.multipleresult;

import com.ding9.multipleentity.MuProdutAndSort;
import com.ding9.sql.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;





public class ProdutParameterInfo
  implements BaseResult
{
  private MuProdutAndSort info = null;
  
  public Object getMapRow(ResultSet resultset, int i) throws SQLException {
    this.info = new MuProdutAndSort();
    
    this.info.setRemark(resultset.getString("prma_remark"));
    this.info.setParameter(resultset.getString("prso_parameter"));
    


    return this.info;
  }
}
