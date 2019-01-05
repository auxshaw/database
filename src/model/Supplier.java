package model;

public class Supplier {

	private int supplierid;
	private String suppliername;
	private String address;
	private int telephone;
	
	//id
	public int getSupplierid() {
		return supplierid;
	}
 
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	
	//name
	public String getSuppliername() {
		return suppliername;
	}
 
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	
	//address
	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
	
	//telephone
	public int getTelephone() {
		return telephone;
	}
 
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
}
