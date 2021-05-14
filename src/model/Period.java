package model;

import java.time.LocalDate;

public class Period<T> {
	private T object;
	private LocalDate startDate;
	private LocalDate endDate;

	public Period(T object, LocalDate startDate) {
		super();
		this.object = object;
		this.startDate = startDate;
	}

	public T getObject() {
		return object;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

}
