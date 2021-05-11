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

	public void setAquariumPeriods(List<Period<Aquarium>> aquariumPeriods) {
		this.aquariumPeriods = aquariumPeriods;
	}
}
