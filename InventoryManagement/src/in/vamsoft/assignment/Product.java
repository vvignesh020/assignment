package in.vamsoft.assignment;

public class Product {
	int prod_id;
	String prod_name;
	double prod_price;
	long quantity;
	
	
	public int getProd_id() {
		return prod_id;
	}


	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}


	public String getProd_name() {
		return prod_name;
	}


	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}


	public double getProd_price() {
		return prod_price;
	}


	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
public Product() {
	
}

	@Override
public String toString() {
	return "Product [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_price=" + prod_price + ", quantity="
			+ quantity + "]\n";
}


	public Product(int prod_id, String prod_name, double prod_price, long quantity) {

		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.quantity = quantity;
	}
	
	
}
