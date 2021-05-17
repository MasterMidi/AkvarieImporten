package model;

public class Aquarium {
    private String number;
    private Double size;
    private int id;
    private Location location;

    public Aquarium(String number, Double size, Location location) {
	super();
	this.number = number;
	this.size = size;
	this.location = location;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Double getSize() {
	return size;
    }

    public void setSize(Double size) {
	this.size = size;
    }

    // TODO Make aquarium fetch location
    public String getLocation() {
	return location.getAddress();
    }
}
