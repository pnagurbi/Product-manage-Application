package com.sathya;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {


	
public int save(Product product) {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		
		try {
			connection=DatabaseUtils.createConnection();
			preparedStatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			
			preparedStatement.setDate(6, product.getProMfgDate());
			preparedStatement.setDate(7, product.getProExpDate());
			preparedStatement.setBytes(8, product.getProImage());
			
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null)
					connection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return count;
}
public List<Product> findAll()
{
	List<Product> productList=new ArrayList<Product>();
	try(Connection connection=DatabaseUtils.createConnection();
		Statement statement= connection.createStatement())
	{
		ResultSet resultSet= statement.executeQuery("select * from product_data");
		while(resultSet.next()) {
			Product product= new Product();
					product.setProId(resultSet.getString(1));
					product.setProName(resultSet.getString(2));
					product.setProPrice(resultSet.getDouble(3));
					product.setProBrand(resultSet.getString(4));
					product.setProMadeIn(resultSet.getString(5));
					product.setProMfgDate(resultSet.getDate(6));
					product.setProExpDate(resultSet.getDate(7));
					product.setProImage(resultSet.getBytes(8));
					productList.add(product);
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}	
			return productList;
		}
            public int deleteById(String proId)
            {
            	int count = 0;
            	try(Connection connection=DatabaseUtils.createConnection();
            PreparedStatement PreparedStatement = connection.prepareStatement("delete from product_data where PROID=?"))			      
            	{
            		PreparedStatement.setString(1, proId);
            	}
            	catch(SQLException e)
            	{
            		e.printStackTrace();
            	}
            	return count;
            }
            public Product findById(String proId) {
                
                Product product = null;
                try (Connection connection = DatabaseUtils.createConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement("select * from product_data where PROID=?")) {
                    
               	 preparedStatement.setString(1, proId);
               	 
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) 
                    {
                        product = new Product();
                        product.setProId(resultSet.getString(1));
                        product.setProName(resultSet.getString(2));
                        product.setProPrice(resultSet.getDouble(3));
                        product.setProBrand(resultSet.getString(4));
                        product.setProMadeIn(resultSet.getString(5));
                        product.setProMfgDate(resultSet.getDate(6));
                        product.setProExpDate(resultSet.getDate(7));
                        product.setProImage(resultSet.getBytes(8));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
				return product;
            }	
				 public int UpdateById(Product product) {
			    	    String sql = "UPDATE product_data SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, proMfgDate=?, proExpDate=?, proImage=? WHERE ProId=?";
			    	    int updateResult = 0;
			    	    try (Connection connection = DatabaseUtils.createConnection()) {
			    	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    	        preparedStatement.setString(1, product.getProName());
			    	        preparedStatement.setDouble(2, product.getProPrice());
			    	        preparedStatement.setString(3, product.getProBrand());
			    	        preparedStatement.setString(4, product.getProMadeIn());
			    	        preparedStatement.setDate(5, product.getProMfgDate());
			    	        preparedStatement.setDate(6, product.getProExpDate());
			    	        preparedStatement.setBytes(7, product.getProImage());
			    	        preparedStatement.setString(8, product.getProId());
			    	        updateResult = preparedStatement.executeUpdate();
			    	    } catch (SQLException e) {
			    	        e.printStackTrace();
			    	    }
			    	    return updateResult;

   
	}
}