package model;

public class Location {
	private int id; //Other usecase
	private int zipcode; //Other usecase
	private String address;
	
	
	public Location(String address)
	{
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
