package model;

public class Aquarium {
    private String number;
    private Double size;
    private int id;

    public Aquarium(String number, Double size) {
	super();
	this.number = number;
	this.size = size;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }
}
