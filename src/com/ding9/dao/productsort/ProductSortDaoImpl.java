package com.ding9.dao.productsort;

import com.ding9.result.productsort.ProductSort;
import com.ding9.result.productsort.ProductType;
import com.ding9.sql.BaseResult;
import com.ding9.sql.DBAccessDefaultlImpl;
import com.ding9.sql.IDBAccess;
import com.ding9.sql.SQLParam;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;












public class ProductSortDaoImpl
  implements ProductSortDao
{
  private static Log log = LogFactory.getLog(ProductSortDaoImpl.class);
  private IDBAccess dba = null;
  private StringBuffer sql = null;
  









  public List getProductSort()
    throws SQLException
  {
    List result = null;
    this.sql = new StringBuffer();
    
    BaseResult index = new ProductSort();
    try {
      this.dba = new DBAccessDefaultlImpl();
      this.sql.append("SELECT prso_id,prso_id_one,prso_id_two,prso_id_three,prso_name_one,prso_name_two,prso_name_three,prso_table_name,prso_nadir_num,prso_small_num,prso_rake,prso_address,prso_parameter,criterion_flag,prso_label FROM product_sort WHERE prso_id_two=0 AND prso_id_three=0 AND prso_id IN (1,2,4,6,7,8,12,15)");
      result = this.dba.queryData(this.sql.toString(), index);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("\n出错信息 getProductSort: " + ex.getMessage());
        log.error("\n执行语句 getProductSort: " + this.sql.toString());
      }
    }
    finally {
      this.dba.closeConnection();
      
      index = null;
      this.sql = null;
    }
    return result;
  }
  









  public List getProductSort(int prso_id_three)
    throws SQLException
  {
    List result = null;
    this.sql = new StringBuffer();
    
    BaseResult index = new ProductSort();
    try {
      this.dba = new DBAccessDefaultlImpl();
      this.sql.append("SELECT prso_id,prso_id_one,prso_id_two,prso_id_three,prso_name_one,prso_name_two,prso_name_three,replace(prso_name_one_en,' ','_') as prso_name_one_en,replace(prso_name_two_en,' ','_') as prso_name_two_en,replace(replace(trim(prso_name_three_en),' ','_'),'/','_and_') as prso_name_three_en,prso_table_name,prso_nadir_num,prso_small_num,prso_rake,prso_address,prso_parameter,criterion_flag,prso_label FROM product_sort WHERE prso_id= ?");
      this.dba.setParam(new SQLParam(1, 1, prso_id_three));
      
      result = this.dba.queryData(this.sql.toString(), index);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("\n出错信息 getProductSort: " + ex.getMessage());
        log.error("\n执行语句 getProductSort: " + this.sql.toString());
      }
    } finally {
      this.dba.closeConnection();
      
      index = null;
      this.sql = null;
    }
    return result;
  }
  









  public List getOneProductSort(int prso_id_one)
    throws SQLException
  {
    List result = null;
    this.sql = new StringBuffer();
    
    BaseResult index = new ProductSort();
    try {
      this.dba = new DBAccessDefaultlImpl();
      this.sql.append("SELECT prso_id,prso_id_one,prso_id_two,prso_id_three,prso_name_one,prso_name_two,prso_name_three,prso_table_name,prso_nadir_num,prso_small_num,prso_rake,prso_address,prso_parameter,criterion_flag,prso_label,replace(prso_name_one_en,' ','_') as prso_name_one_en,replace(prso_name_two_en,' ','_') as prso_name_two_en,replace(replace(trim(prso_name_three_en),' ','_'),'/','_and_') as prso_name_three_en FROM product_sort WHERE prso_id= ? ");
      this.dba.setParam(new SQLParam(1, 1, prso_id_one));
      
      result = this.dba.queryData(this.sql.toString(), index);
    }
    catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("\n出错信息 getOneProductSort: " + ex.getMessage());
        log.error("\n执行语句 getOneProductSort: " + this.sql.toString());
      }
    }
    finally {
      this.dba.closeConnection();
      
      index = null;
      this.sql = null;
    }
    return result;
  }
  









  public List getThreeGrade(int prso_id_three)
    throws SQLException
  {
    List result = null;
    

    BaseResult index = new ProductType();
    try {
      this.dba = new DBAccessDefaultlImpl();
      

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT COUNT(*) as CNT,A.PRSO_ID,A.PRSO_NAME_THREE");
      sql.append(",A.PRSO_ID_ONE,A.PRSO_NAME_ONE_EN,A.PRSO_ID_THREE,A.PRSO_NAME_THREE_EN");
      sql.append(" FROM PRODUCT_SORT A,PRODUCT_MASTER B");
      sql.append(" WHERE A.PRSO_ID = B.PRSO_ID  AND A.PRSO_ID<>?");
      sql.append(" AND A.PRSO_ID_TWO = (SELECT PRSO_ID_TWO FROM PRODUCT_SORT WHERE PRSO_ID =?)");
      
      sql.append(" GROUP BY A.PRSO_ID,A.PRSO_NAME_THREE");
      sql.append(",A.PRSO_ID_ONE,A.PRSO_NAME_ONE_EN,A.PRSO_ID_THREE,A.PRSO_NAME_THREE_EN");
      sql.append(" ORDER BY CNT DESC ");
      
      this.dba.setParam(new SQLParam(1, 1, prso_id_three));
      this.dba.setParam(new SQLParam(2, 1, prso_id_three));
      
      result = this.dba.queryData(sql.toString(), index);
    } catch (Exception ex) {
      if (log.isErrorEnabled()) {
        log.error("\n执行语句 getThreeGrade: " + this.sql.toString());
        log.error("\n出错信息 getThreeGrade: " + ex.getMessage());
      }
    }
    finally
    {
      index = null;
      this.sql = null;
    }
    return result;
  }
}
