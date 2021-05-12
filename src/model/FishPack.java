package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FishPack {
	private LocalDate birthDate;
	private FeedingPlan feedingPlan;
	private FishSpecies species;
	private List<Period<Aquarium>> aquariumPeriods;

	public FishPack() {
		this.aquariumPeriods = new ArrayList<Period<Aquarium>>();
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setFeedingPlan(FeedingPlan feedingPlan) {
		this.feedingPlan = feedingPlan;
	}

	public void setSpecies(FishSpecies species) {
		this.species = species;
	}
	//Always sets startdate to LocalDate.now() 
	public void setAquarium(Aquarium aquarium) {
		Period<Aquarium> res = new Period<Aquarium>(aquarium, LocalDate.now());
		this.aquariumPeriods.add(res);
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public FeedingPlan getFeedingPlan() {
		return feedingPlan;
	}

	public FishSpecies getSpecies() {
		return species;
	}

	public List<Period<Aquarium>> getAquariumPeriods() {
		return aquariumPeriods;
	}

	public FishPack(LocalDate birthDate, FeedingPlan feedingPlan, FishSpecies species) {
		super();
		this.birthDate = birthDate;
		this.feedingPlan = feedingPlan;
		this.species = species;
	}
	
}
