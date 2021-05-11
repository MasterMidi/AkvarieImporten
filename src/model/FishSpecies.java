package model;

public class FishSpecies {
	private int id;

	private String name;
	private int averageEggs;
	private double birthSize;
	private double growthRate;
	private double minimumSalesSize;
	
	public FishSpecies(String name, int averageEggs, double birthSize, double growthRate, double minimumSalesSize) {
		super();
		this.name = name;
		this.averageEggs = averageEggs;
		this.birthSize = birthSize;
		this.growthRate = growthRate;
		this.minimumSalesSize = minimumSalesSize;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
}
