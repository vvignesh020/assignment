package in.vamsoft.assignment;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.assignment.sql.DbConnectionUtil;

public class RetailStore implements Factory {
	String store_name;
	   Connection con = null;
	    Statement stmt = null;
	    ResultSet resultset = null;
	    
	    
	public RetailStore() {
		}

	public RetailStore(String store_name) {
		this.store_name = store_name;
	}
	
	/* (non-Javadoc)
	 * @see in.vamsoft.assignment.Factory#addCustomer(in.vamsoft.assignment.Customer)
	 */
	@Override
	public void addCustomer(Customer cust) {
		this.con = DbConnectionUtil.getConnection();
	    try (PreparedStatement preparedStatement = con.prepareStatement("insert into customer1 values(?,?,?)")) {
	    	preparedStatement.setInt(1, cust.getCust_id());
	    	preparedStatement.setLong(3, cust.getContact_no());
	        preparedStatement.setString(2, cust.getCust_name());
	        
	        preparedStatement.executeUpdate();
	        System.out.println("customer added");
	      } catch (Exception e) {
	    	  System.out.println(e);
	      }
	        
		
	}
	public void addProduct(Product prod) {
		this.con = DbConnectionUtil.getConnection();
	    try (PreparedStatement preparedStatement = con.prepareStatement("insert into inventory values(?,?,?,?)")) {
	    	preparedStatement.setInt(1, prod.getProd_id());
	    	preparedStatement.setLong(4, prod.getQuantity());
	        preparedStatement.setString(2, prod.getProd_name());
	        preparedStatement.setDouble(3, prod.getProd_price());
	        
	        
	        preparedStatement.executeUpdate();
	        System.out.println("Product added");
	       
	      } catch (Exception e) {
	    	  System.out.println(e);
	      }
	}
	public int checkProductAvailability(String product_name) {
		this.con = DbConnectionUtil.getConnection();
	    try (PreparedStatement preparedStatement = con.prepareStatement("select * from inventory where upper(name)=upper(?)")) {
	    	preparedStatement.setString(1, product_name);
	    	resultset = preparedStatement.executeQuery();
//	    	if(resultset.getInt(4)<0) {
//	    		return resultset.getInt(4);
//	    	}
	    	int available=0;
	        while(resultset.next()) {
	        	available=resultset.getInt(4);
	        }
	        return available;
	        
	       
	       
	      } catch (Exception e) {
	    	  System.out.println(e);
	      }
		
		return 0;
		
	}
	public int bookProduct(int cust_id, String product_name, int qty_of_prod) {
		
		int instock = checkProductAvailability(product_name);
		int new_stock= instock-qty_of_prod;
		if(instock!=0) {
			this.con = DbConnectionUtil.getConnection();
		    try (PreparedStatement preparedStatement = con.prepareStatement("update inventory set stock=? where upper(name)=upper(?)")) {
		    	resultset = preparedStatement.executeQuery();
		    	if(resultset.getInt(4)<0) {
		    		return resultset.getInt(4);
		    	}
		        
		        
		       
		       
		      } catch (Exception e) {
		    	  System.out.println(e);
		      }
		}else {
			return 0;
		}
		return 0;
		
	}
	public double calculateNetAmount(int cust_id,double discount) {
		return 0;
		
	}
	public List<Product> listProduct() {
	   
	    List<Product> list = new ArrayList<>();
	    try (PreparedStatement preparedStatement = con
	        .prepareStatement("select * from inventory")) {
	      resultset = preparedStatement.executeQuery();

	      while (resultset.next()) {
	        Product prod = new Product();
	        prod.setProd_id(resultset.getInt(1));
	        prod.setProd_name(resultset.getString(2));
	        prod.setProd_price(resultset.getDouble(3));
	        prod.setQuantity(resultset.getInt(4));
	        list.add(prod);
	      
	       
	      } return list;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }


	    return null;

	  }

	
}
