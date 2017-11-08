package in.vamsoft.assignment;

import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Customer {
  private static final Logger logger = Logger.getLogger(Customer.class);
  int custid;
  String custname;
  long contactno;

  /**
   * @return customer id.
   */
  public int getCust_id() {
    if (logger.isDebugEnabled()) {
      logger.debug("entering getCust_id()");
      logger.debug("exiting getCust_id()");
      logger.debug("returning: " + custid);
    }
    return custid;
  }

  /**
   * @param custid.
   */
  public void setCust_id(int custid) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering setCust_id(int)");
      logger.debug("cust_id: " + custid);
    }
    this.custid = custid;
    if (logger.isDebugEnabled()) {
      logger.debug("exiting setCust_id()");
    }
  }

  /**
   * @return customer name.
   */
  public String getCust_name() {
    if (logger.isDebugEnabled()) {
      logger.debug("entering getCust_name()");
      logger.debug("exiting getCust_name()");
      logger.debug("returning: " + custname);
    }
    return custname;
  }

  /**
   * @param cust_name.
   */
  public void setCust_name(String custname) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering setCust_name(String)");
      logger.debug("cust_name: \"" + custname + "\"");
    }
    this.custname = custname;
    if (logger.isDebugEnabled()) {
      logger.debug("exiting setCust_name()");
    }
  }

  /**
   * @return contact.
   */
  public long getContact_no() {
    if (logger.isDebugEnabled()) {
      logger.debug("entering getContact_no()");
      logger.debug("exiting getContact_no()");
      logger.debug("returning: " + contactno);
    }
    return contactno;
  }

  /**
   * @param contactno.
   */
  public void setContact_no(long contactno) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering setContact_no(long)");
      logger.debug("contact_no: " + contactno);
    }
    this.contactno = contactno;
    if (logger.isDebugEnabled()) {
      logger.debug("exiting setContact_no()");
    }
  }

  /**
   * @param custid.
   * @param custname.
   * @param contactno.
   */
  public Customer(int custid, String custname, long contactno) {
    this.custid = custid;
    this.custname = custname;
    this.contactno = contactno;
  }

  ArrayList<Product> bookedProductList = new ArrayList<Product>();

  /**
   * @param obj.
   */
  public void addBookedProduct(Product obj) {

    if (logger.isDebugEnabled()) {
      logger.debug("entering addBookedProduct(Product)");
      logger.debug("obj: " + obj);
    }
    bookedProductList.add(obj);
    if (logger.isDebugEnabled()) {
      logger.debug("exiting addBookedProduct()");
    }
  }

}
