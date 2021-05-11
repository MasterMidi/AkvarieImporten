package model;

public class FeedingPlan {
	private int id;
	private int interval;
	private double amount;
	private Food food;
	
	public FeedingPlan(int interval, double amount, Food food) {
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

}
