package in.vamsoft.assignment;

import in.vamsoft.assignment.sql.DbConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;



public class RetailStore {
  private static final Logger logger = Logger.getLogger(RetailStore.class);
  String storename;
  Connection con = null;
  Statement stmt = null;
  ResultSet resultset = null;

  public RetailStore() {
  }

  public RetailStore(String storename) {
    this.storename = storename;
  }

 
 
  /**
   * @param cust adds customer to customer table.
   */
  public boolean addCustomer(Customer cust) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering addCustomer(Customer)");
      logger.debug("cust: " + cust);
    }
    this.con = DbConnectionUtil.getConnection();
    try (PreparedStatement preparedStatement = con.prepareStatement(
        "insert into customer1 values(?,?,?)")) {
      preparedStatement.setInt(1, cust.getCust_id());
      preparedStatement.setLong(3, cust.getContact_no());
      preparedStatement.setString(2, cust.getCust_name());

      preparedStatement.executeUpdate();
      System.out.println("customer added");
      
      return true;
    } catch (Exception e) {
      System.out.println(e);
    }
    if (logger.isDebugEnabled()) {
      logger.debug("exiting addCustomer()");
    }
    return false;

  }

  /**
   * @param prod
   *          it is a prod object. adds the product to the inventory table.
   */
  public boolean addProduct(Product prod) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering addProduct(Product)");
      logger.debug("prod: " + prod);
    }
    this.con = DbConnectionUtil.getConnection();
    try (PreparedStatement preparedStatement = con.prepareStatement(
        "insert into inventory values(?,?,?,?)")) {
      preparedStatement.setInt(1, prod.getProd_id());
      preparedStatement.setLong(4, prod.getQuantity());
      preparedStatement.setString(2, prod.getProd_name());
      preparedStatement.setDouble(3, prod.getProd_price());

      preparedStatement.executeUpdate();
      System.out.println("Product added");
      
      return true;
    } catch (Exception e) {
      System.out.println(e);
    }
    if (logger.isDebugEnabled()) {
      logger.debug("exiting addProduct()");
    }
    return false;
  }

  /**
   * @param productname passes the product name searched by the customer.
   * @return the availability of stock from inventory table.
   */
  public int checkProductAvailability(String productname) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering checkProductAvailability(String)");
      logger.debug("product_name: \"" + productname + "\"");
    }
    this.con = DbConnectionUtil.getConnection();
    try (PreparedStatement preparedStatement = con
        .prepareStatement("select * from inventory where upper(name)=upper(?)")) {
      preparedStatement.setString(1, productname);
      resultset = preparedStatement.executeQuery();
      int available = 0;
      while (resultset.next()) {
        available = resultset.getInt(4);
      }
      if (logger.isDebugEnabled()) {
        logger.debug("exiting checkProductAvailability()");
        logger.debug("returning: " + available);
      }
      return available;

    } catch (Exception e) {
      System.out.println(e);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("exiting checkProductAvailability()");
      logger.debug("returning: " + 0);
    }
    return 0;

  }

  /**
   * @param custid
   *          gets the customer id from the customer.
   * @param productname
   *          gets the product name from the customer to search the corresponding
   *          product.
   * @param qtyofprod
   *          gets the quantity of the product to be booked.
   * 
   */
  public int bookProduct(int custid, String productname, int qtyofprod) {

    if (logger.isDebugEnabled()) {
      logger.debug("entering bookProduct(int,String,int)");
      logger.debug("cust_id: " + custid);
      logger.debug("product_name: \"" + productname + "\"");
      logger.debug("qty_of_prod: " + qtyofprod);
    }
    int instock = checkProductAvailability(productname);
    int newstock = instock - qtyofprod;
    if (instock != 0) {
      this.con = DbConnectionUtil.getConnection();
      try (
          PreparedStatement preparedStatement = con.prepareStatement(
              "update inventory set stock=new_stock where upper(name)=upper(product_name)");
          PreparedStatement preparedStatement1 = con.prepareStatement(
              "insert into invoice values(?,?,?,?,?,?)");
          PreparedStatement prep2 = con.prepareStatement("select count(*) from invoice");) {

        int resultsetcount = prep2.executeUpdate();
        resultset = preparedStatement.executeQuery();
        int proid = prep2.executeUpdate(
            "select pid from inventory where upper(name)=upper(product_name)");
        preparedStatement1.setInt(1, resultsetcount + 1);
        preparedStatement1.setInt(2, custid);
        preparedStatement1.setInt(3, proid);
        double price = prep2.executeUpdate(
            "select price from inventory where upper(name)=upper(product_name)");
        double amt = price * qtyofprod;
        preparedStatement1.setInt(4, qtyofprod);
        preparedStatement1.setDouble(5, price);
        preparedStatement1.setDouble(6, amt);

        int resultset1 = preparedStatement1.executeUpdate();
        if (resultset.getInt(4) < 0) {
          System.out.println("stock");
          if (logger.isDebugEnabled()) {
            logger.debug("exiting bookProduct()");
          }
          return resultset.getInt(4);
        }

      } catch (Exception e) {
        System.out.println(e);
      }
    } else {

      if (logger.isDebugEnabled()) {
        logger.debug("exiting bookProduct()");
      }
      return -1;
    }

    if (logger.isDebugEnabled()) {
      logger.debug("exiting bookProduct()");
      logger.debug("returning: " + 0);
    }
    return 0;

  }

  /**
   * @param cust_id.
   * @param discount.
   * @return.
   */
  public double calculateNetAmount(int custid, double discount) {

    if (logger.isDebugEnabled()) {
      logger.debug("entering calculateNetAmount(int,double)");
      logger.debug("cust_id: " + custid);
      logger.debug("discount: " + discount);
      logger.debug("exiting calculateNetAmount()");
      logger.debug("returning: " + 0);
    }
    return 0;

  }

  /**
   * @return.
   */
  public List<Product> listProduct() {

    if (logger.isDebugEnabled()) {
      logger.debug("entering listProduct()");
    }
    List<Product> list = new ArrayList<>();
    try (PreparedStatement preparedStatement = con.prepareStatement("select * from inventory")) {
      resultset = preparedStatement.executeQuery();

      while (resultset.next()) {
        Product prod = new Product();
        prod.setProd_id(resultset.getInt(1));
        prod.setProd_name(resultset.getString(2));
        prod.setProd_price(resultset.getDouble(3));
        prod.setQuantity(resultset.getInt(4));
        list.add(prod);

      }
      if (logger.isDebugEnabled()) {
        logger.debug("exiting listProduct()");
        logger.debug("returning: " + list);
      }
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    if (logger.isDebugEnabled()) {
      logger.debug("exiting listProduct()");
      logger.debug("returning: " + null);
    }
    return null;

  }

}
