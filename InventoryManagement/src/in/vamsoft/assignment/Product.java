package in.vamsoft.assignment;

import org.apache.log4j.Logger;

public class Product {
  /**
   * . logger intialise.
   */
  private static final Logger logger = Logger.getLogger(Product.class);
  int prodid;
  String prodname;
  double prodprice;
  long quantity;

  /**
   * .
   * 
   * @return product id
   */
  public int getProd_id() {
    if (logger.isDebugEnabled()) {
      logger.debug("entering getProd_id()");
      logger.debug("exiting getProd_id()");
      logger.debug("returning: " + prodid);
    }
    return prodid;
  }

  /**
   * . proid setter method.
   */
  public void setProd_id(int prodid) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering setProd_id(int)");
      logger.debug("prod_id: " + prodid);
    }
    this.prodid = prodid;
    if (logger.isDebugEnabled()) {
      logger.debug("exiting setProd_id()");
    }
  }

  /**
   * @return product name.
   */
  public String getProd_name() {
    if (logger.isDebugEnabled()) {
      logger.debug("entering getProd_name()");
      logger.debug("exiting getProd_name()");
      logger.debug("returning: " + prodname);
    }
    return prodname;
  }

  /**
   * @param prodname
   *          setter method.
   */
  public void setProd_name(String prodname) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering setProd_name(String)");
      logger.debug("prod_name: \"" + prodname + "\"");
    }
    this.prodname = prodname;
    if (logger.isDebugEnabled()) {
      logger.debug("exiting setProd_name()");
    }
  }

  /**
   * @return product price.
   */
  public double getProd_price() {
    if (logger.isDebugEnabled()) {
      logger.debug("entering getProd_price()");
      logger.debug("exiting getProd_price()");
      logger.debug("returning: " + prodprice);
    }
    return prodprice;
  }

  /**
   * @param prodprice
   *          setter method.
   */
  public void setProd_price(double prodprice) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering setProd_price(double)");
      logger.debug("prod_price: " + prodprice);
    }
    this.prodprice = prodprice;
    if (logger.isDebugEnabled()) {
      logger.debug("exiting setProd_price()");
    }
  }

  /**
   * @return quantity of the product from inventory table.
   */
  public long getQuantity() {
    if (logger.isDebugEnabled()) {
      logger.debug("entering getQuantity()");
      logger.debug("exiting getQuantity()");
      logger.debug("returning: " + quantity);
    }
    return quantity;
  }

  /**
   * @param quantity.
   * @param quantity
   *          setter method.
   */
  public void setQuantity(long quantity) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering setQuantity(long)");
      logger.debug("quantity: " + quantity);
    }
    this.quantity = quantity;
    if (logger.isDebugEnabled()) {
      logger.debug("exiting setQuantity()");
    }
  }

  @Override
  public String toString() {
    if (logger.isDebugEnabled()) {
      logger.debug("entering toString()");
      logger.debug("exiting toString()");
      logger.debug("returning: " + ("Product [prod_id=" + prodid + ", prod_name=" + prodname 
          + ", prod_price=" + prodprice + ", quantity=" + quantity + "]\n"));
    }
    return "Product [prod_id=" + prodid + ", prod_name=" + prodname + ", prod_price=" 
      + prodprice + ", quantity=" + quantity + "]\n";
  }

  /**
   * @param prodid.
   * @param prodname.
   * @param prodprice.
   * @param quantity.
   */
  public Product(int prodid, String prodname, double prodprice, long quantity) {

    this.prodid = prodid;
    this.prodname = prodname;
    this.prodprice = prodprice;
    this.quantity = quantity;
  }

  public Product() {
    // TODO Auto-generated constructor stub
  }

}
