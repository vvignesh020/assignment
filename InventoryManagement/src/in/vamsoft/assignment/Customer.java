package in.vamsoft.assignment;

class Customer {
	int cust_id;
	String cust_name;
	long contact_no;
	
	
	
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



	Customer(int cust_id, String cust_name, long contact_no) {
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.contact_no = contact_no;
	}
}
