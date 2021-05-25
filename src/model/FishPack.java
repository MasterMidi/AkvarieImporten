package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FishPack {
	private int id;
	private LocalDate birthDate;
	private String status;
	private String packNumber;
	private FeedingPlan feedingPlan;
	private FishSpecies species;
	private List<Period<Aquarium>> aquariumPeriods;

	public FishPack() {
		this(0, null, null, null, null, null, null);
	}

	public FishPack(LocalDate birthDate, FeedingPlan feedingPlan, FishSpecies species) {
		this(0, null, null, birthDate, feedingPlan, species, null);
	}

	public FishPack(int id, String packNumber, String status, LocalDate birthday, FeedingPlan feedingPlan,
			FishSpecies fishSpecies, Period<Aquarium> aquarium) {
		this.id = id;
		this.packNumber = packNumber;
		this.status = status;
		this.birthDate = birthday;
		this.feedingPlan = feedingPlan;
		this.species = fishSpecies;

		this.aquariumPeriods = new ArrayList<Period<Aquarium>>();
		this.aquariumPeriods.add(aquarium);
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

	// Always sets startdate to LocalDate.now()
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

	// TODO Make the calculate for the correct amount of days.
	public String getStatus() {
		return status;
	}

	// TODO Get the current aquarium for the fishpack
	public Aquarium getCurrentAquarium() {
		return aquariumPeriods.get(0).getObject();
	}

	// TODO Fetch fishpack number
	public String getFishPackNumber() {
		return this.packNumber;
	}

	public void setID(Integer id) {
		this.id = id;

	}

}
