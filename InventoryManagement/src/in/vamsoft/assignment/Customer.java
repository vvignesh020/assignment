package in.vamsoft.assignment;

public class Customer {
	int cust_id;
	String cust_name;
	long contact_no;


	public int getCust_id() {
		return cust_id;
	}


	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}


	public String getCust_name() {
		return cust_name;
	}


	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}


	public long getContact_no() {
		return contact_no;
	}


	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}


	public Customer(int cust_id, String cust_name, long contact_no) {
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.contact_no = contact_no;
	}
	
	
	public void bookProduct() {
		
	}
}
