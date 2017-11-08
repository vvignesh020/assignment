package in.vamsoft.assignment.test;

import in.vamsoft.assignment.RetailStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import in.vamsoft.assignment.Customer;
import in.vamsoft.assignment.Product;

public class MainRetail {
	public static void main(String[] args) throws IOException {
		RetailStore rs = new RetailStore("retail");
//		Customer c1 = new Customer(1,"abc",80121);
//		Product prod = new Product(3,"samsung",2500,1);
		System.out.println(rs.checkProductAvailability("samsung"));
		Scanner br1 = new Scanner(System.in);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String ans = "";
		do {
			System.out.println("enter 1 to add a product");
		      System.out.println("enter 2 to add customer");
		      System.out.println("enter 3 to find availability");
		      System.out.println("enter 4 for product list: ");
		      System.out.println("enter your option");
		      
		      int option = br1.nextInt();
		      
		      
		      switch(option) {
		      case 1:
		    	  System.out.println("Enter productID: ");
		    	  int prod_id = br1.nextInt();
		    	  System.out.println("Enter productName: ");
		    	  String prod_name = br2.readLine();
		    	  System.out.println("Enter Productprice: ");
		    	  double price = br1.nextDouble();
		    	  System.out.println("Enter product qty: ");
		    	  int qty = br1.nextInt();
		    	  Product prod = new Product(prod_id,prod_name,price,qty);
		    	  rs.addProduct(prod);
		    	  break;
		    	  
		      case 2:
		    	  System.out.println("enter  customer id");
		    	  int id =br1.nextInt();
		    	 System.out.println("enter customer name");
		    	 String name =br2.readLine();
		    	 System.out.println("enter phone number");
		    	 long ph = br1.nextLong();
		    	 Customer c =new Customer(id,name,ph);
		    	 rs.addCustomer(c);
		    	 break;
		    	 
		      case 3:
		    	  System.out.println("enter  productname: ");
		    	  String prodname = br2.readLine();
		    	  System.out.println(rs.checkProductAvailability(prodname));
		    	  break;
		    	  
		      case 4:
		    	  System.out.println("list of products:");
		    	  List<Product> list = rs.listProduct();
		    	  System.out.println(list);

		      }
		      
		    	  
		      System.out.println("enter any character to continue: ");
			 ans = br2.readLine() == null ? "no" : "yes";	
		}while(ans.equalsIgnoreCase("yes"));
	}
	
	
	
}
