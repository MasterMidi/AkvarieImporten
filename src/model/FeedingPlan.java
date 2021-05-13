package model;

public class FeedingPlan {
    private int id;
    private String name;
    private int interval;
    private double amount;
    private Food food;

    public FeedingPlan(String name, int interval, double amount, Food food) {
	this.name = name;
	this.interval = interval;
	this.amount = amount;
	this.food = food;
    }

    public int getID() {
	return id;
    }

    public void setID(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

}
