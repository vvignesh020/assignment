package in.vamsoft.assignment;

import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author vamsoft Main retail store test cases.
 */
public class RetailStoreTest {
  RetailStore rs = null;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
     rs = new RetailStore();
  }

//  @Test
//  public void testAddCustomer() {
//    Customer c = new Customer(1, "jk", 9852365);
//    boolean result = rs.addCustomer(c);
//    Assert.assertEquals(true, true);
//  }

//  @Test
//  public void testAddProduct() {
//    Product p = new Product();
//    boolean result = rs.addProduct(p);
//    Assert.assertEquals(true, true);
//  }

  @Test
  public void testCheckProductAvailability() {
    int availability = rs.checkProductAvailability("samsung");
    Assert.assertEquals(0, availability);
     
  }

  @Test
  public void testBookProduct() {
    int product = rs.bookProduct(1, "samsung", 2);
    Assert.assertEquals(-1, product);
    
  }

  @Test
  public void testCalculateNetAmount() {
    fail("Not yet implemented");
  }

  @Test
  public void testListProduct() {
    List<Product> list = rs.listProduct();
    Assert.assertNotNull(list.size());
    
    
  }

}
