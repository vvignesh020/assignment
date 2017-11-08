package in.vamsoft.assignment.test;

import in.vamsoft.assignment.Customer;
import in.vamsoft.assignment.Product;
import in.vamsoft.assignment.RetailStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;


/**
 * @author vamsoft Main class for retail operations.
 */
public class MainRetail {
  private static final Logger logger = Logger.getLogger(MainRetail.class);

  /**
   * @param args.
   * @throws IOException
   *           for input read from buffered reader. Main method references for
   *           retail operations execution.
   */
  public static void main(String[] args) throws IOException {
    if (logger.isDebugEnabled()) {
      logger.debug("entering main(String[])");

    }
    RetailStore rs = new RetailStore("retail");
    System.out.println(rs.checkProductAvailability("samsung"));
    Scanner br1 = new Scanner(System.in);
    BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
    String ans = "";
    do {
      System.out.println("enter 1 to add a product");
      System.out.println("enter 2 to add customer");
      System.out.println("enter 3 to find availability");
      System.out.println("enter 4 for product list: ");
      System.out.println("enter 5 to book a product");
      System.out.println("enter your option");

      int option = br1.nextInt();

      switch (option) {
        case 1:
          System.out.println("Enter productID: ");
          int prodid = br1.nextInt();
          System.out.println("Enter productName: ");
          String prodname = br2.readLine();
          System.out.println("Enter Productprice: ");
          double price = br1.nextDouble();
          System.out.println("Enter product qty: ");
          int qty = br1.nextInt();
          Product prod = new Product(prodid, prodname, price, qty);
          rs.addProduct(prod);
          break;
  
        case 2:
          System.out.println("enter  customer id");
          int id = br1.nextInt();
          System.out.println("enter customer name");
          String name = br2.readLine();
          System.out.println("enter phone number");
          long ph = br1.nextLong();
          Customer c = new Customer(id, name, ph);
          rs.addCustomer(c);
          break;
  
        case 3:
          System.out.println("enter  productname: ");
          String prodname1 = br2.readLine();
          System.out.println(rs.checkProductAvailability(prodname1));
          break;
  
        case 4:
          System.out.println("list of products:");
          List<Product> list = rs.listProduct();
          System.out.println(list);
          break;
  
        case 5:
          System.out.println("------book Product-------");
          System.out.println("Enter the customer id:");
          int custid = Integer.parseInt(br2.readLine());
          System.out.println("enter the product name");
          String name1 = br2.readLine();
          System.out.println("Enter the number of products:");
          int prodqty = Integer.parseInt(br2.readLine());
          rs.bookProduct(custid, name1, prodqty);
          break;
  
        case 6:
          System.out.println("------calculate cost-------");
          System.out.println("Enter the customer id:");
          int id1 = Integer.parseInt(br2.readLine());
          System.out.println("Enter the discount:");
          double discount = Double.parseDouble(br2.readLine());
  
          double cost = rs.calculateNetAmount(id1, discount);
          System.out.println("Total cost=" + cost);
          break;
  
        default:
          System.out.println("not a valid case");
      }

      System.out.println("enter any character to continue: ");
      ans = br2.readLine() == null ? "no" : "yes";
    } while (ans.equalsIgnoreCase("yes"));
    if (logger.isDebugEnabled()) {
      logger.debug("exiting main()");
    }
  }

}
